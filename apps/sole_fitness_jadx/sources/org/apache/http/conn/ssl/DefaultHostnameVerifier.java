package org.apache.http.conn.ssl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.util.DomainType;
import org.apache.http.conn.util.InetAddressUtils;
import org.apache.http.conn.util.PublicSuffixMatcher;

/* loaded from: classes2.dex */
public final class DefaultHostnameVerifier implements HostnameVerifier {
    static final int DNS_NAME_TYPE = 2;
    static final int IP_ADDRESS_TYPE = 7;
    private final Log log;
    private final PublicSuffixMatcher publicSuffixMatcher;

    public DefaultHostnameVerifier(PublicSuffixMatcher publicSuffixMatcher) {
        this.log = LogFactory.getLog(getClass());
        this.publicSuffixMatcher = publicSuffixMatcher;
    }

    public DefaultHostnameVerifier() {
        this(null);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) throws CertificateParsingException {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e) {
            if (this.log.isDebugEnabled()) {
                this.log.debug(e.getMessage(), e);
            }
            return false;
        }
    }

    public void verify(String str, X509Certificate x509Certificate) throws SSLException, CertificateParsingException {
        boolean zIsIPv4Address = InetAddressUtils.isIPv4Address(str);
        boolean zIsIPv6Address = InetAddressUtils.isIPv6Address(str);
        List<String> listExtractSubjectAlts = extractSubjectAlts(x509Certificate, (zIsIPv4Address || zIsIPv6Address) ? 7 : 2);
        if (listExtractSubjectAlts != null && !listExtractSubjectAlts.isEmpty()) {
            if (zIsIPv4Address) {
                matchIPAddress(str, listExtractSubjectAlts);
                return;
            } else if (zIsIPv6Address) {
                matchIPv6Address(str, listExtractSubjectAlts);
                return;
            } else {
                matchDNSName(str, listExtractSubjectAlts, this.publicSuffixMatcher);
                return;
            }
        }
        String strExtractCN = extractCN(x509Certificate.getSubjectX500Principal().getName("RFC2253"));
        if (strExtractCN == null) {
            throw new SSLException("Certificate subject for <" + str + "> doesn't contain a common name and does not have alternative names");
        }
        matchCN(str, strExtractCN, this.publicSuffixMatcher);
    }

    static void matchIPAddress(String str, List<String> list) throws SSLException {
        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                return;
            }
        }
        throw new SSLException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    static void matchIPv6Address(String str, List<String> list) throws SSLException {
        String strNormaliseAddress = normaliseAddress(str);
        for (int i = 0; i < list.size(); i++) {
            if (strNormaliseAddress.equals(normaliseAddress(list.get(i)))) {
                return;
            }
        }
        throw new SSLException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    static void matchDNSName(String str, List<String> list, PublicSuffixMatcher publicSuffixMatcher) throws SSLException {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        for (int i = 0; i < list.size(); i++) {
            if (matchIdentityStrict(lowerCase, list.get(i).toLowerCase(Locale.ROOT), publicSuffixMatcher)) {
                return;
            }
        }
        throw new SSLException("Certificate for <" + str + "> doesn't match any of the subject alternative names: " + list);
    }

    static void matchCN(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) throws SSLException {
        if (matchIdentityStrict(str, str2, publicSuffixMatcher)) {
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't match common name of the certificate subject: " + str2);
    }

    static boolean matchDomainRoot(String str, String str2) {
        if (str2 != null && str.endsWith(str2)) {
            return str.length() == str2.length() || str.charAt((str.length() - str2.length()) - 1) == '.';
        }
        return false;
    }

    private static boolean matchIdentity(String str, String str2, PublicSuffixMatcher publicSuffixMatcher, boolean z) {
        if (publicSuffixMatcher != null && str.contains(".") && !matchDomainRoot(str, publicSuffixMatcher.getDomainRoot(str2, DomainType.ICANN))) {
            return false;
        }
        int iIndexOf = str2.indexOf(42);
        if (iIndexOf != -1) {
            String strSubstring = str2.substring(0, iIndexOf);
            String strSubstring2 = str2.substring(iIndexOf + 1);
            if (!strSubstring.isEmpty() && !str.startsWith(strSubstring)) {
                return false;
            }
            if (strSubstring2.isEmpty() || str.endsWith(strSubstring2)) {
                return (z && str.substring(strSubstring.length(), str.length() - strSubstring2.length()).contains(".")) ? false : true;
            }
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    static boolean matchIdentity(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) {
        return matchIdentity(str, str2, publicSuffixMatcher, false);
    }

    static boolean matchIdentity(String str, String str2) {
        return matchIdentity(str, str2, null, false);
    }

    static boolean matchIdentityStrict(String str, String str2, PublicSuffixMatcher publicSuffixMatcher) {
        return matchIdentity(str, str2, publicSuffixMatcher, true);
    }

    static boolean matchIdentityStrict(String str, String str2) {
        return matchIdentity(str, str2, null, true);
    }

    static String extractCN(String str) throws SSLException {
        if (str == null) {
            return null;
        }
        try {
            List rdns = new LdapName(str).getRdns();
            for (int size = rdns.size() - 1; size >= 0; size--) {
                Attribute attribute = ((Rdn) rdns.get(size)).toAttributes().get("cn");
                if (attribute != null) {
                    try {
                        Object obj = attribute.get();
                        if (obj != null) {
                            return obj.toString();
                        }
                        continue;
                    } catch (NoSuchElementException | NamingException unused) {
                        continue;
                    }
                }
            }
            return null;
        } catch (InvalidNameException unused2) {
            throw new SSLException(str + " is not a valid X500 distinguished name");
        }
    }

    static List<String> extractSubjectAlts(X509Certificate x509Certificate, int i) throws CertificateParsingException {
        Collection<List<?>> subjectAlternativeNames;
        ArrayList arrayList = null;
        try {
            subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException unused) {
            subjectAlternativeNames = null;
        }
        if (subjectAlternativeNames != null) {
            for (List<?> list : subjectAlternativeNames) {
                if (((Integer) list.get(0)).intValue() == i) {
                    String str = (String) list.get(1);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    static String normaliseAddress(String str) {
        if (str == null) {
            return str;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException unused) {
            return str;
        }
    }
}
