package com.android.xml;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

/* loaded from: classes3.dex */
public class AndroidXPathFactory {
    public static final String DEFAULT_NS_PREFIX = "android";
    private static final XPathFactory sFactory = XPathFactory.newInstance();

    private static class AndroidNamespaceContext implements NamespaceContext {
        private static final AndroidNamespaceContext sThis = new AndroidNamespaceContext("android");
        private final String mAndroidPrefix;
        private final List<String> mAndroidPrefixes;

        /* JADX INFO: Access modifiers changed from: private */
        public static AndroidNamespaceContext getDefault() {
            return sThis;
        }

        public AndroidNamespaceContext(String androidPrefix) {
            this.mAndroidPrefix = androidPrefix;
            this.mAndroidPrefixes = Collections.singletonList(androidPrefix);
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String prefix) {
            if (prefix != null && prefix.equals(this.mAndroidPrefix)) {
                return "http://schemas.android.com/apk/res/android";
            }
            return "";
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String namespaceURI) {
            if ("http://schemas.android.com/apk/res/android".equals(namespaceURI)) {
                return this.mAndroidPrefix;
            }
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator<String> getPrefixes(String namespaceURI) {
            if ("http://schemas.android.com/apk/res/android".equals(namespaceURI)) {
                return this.mAndroidPrefixes.iterator();
            }
            return null;
        }
    }

    public static XPath newXPath(String androidPrefix) {
        XPath xPathNewXPath = sFactory.newXPath();
        xPathNewXPath.setNamespaceContext(new AndroidNamespaceContext(androidPrefix));
        return xPathNewXPath;
    }

    public static XPath newXPath() {
        XPath xPathNewXPath = sFactory.newXPath();
        xPathNewXPath.setNamespaceContext(AndroidNamespaceContext.getDefault());
        return xPathNewXPath;
    }
}
