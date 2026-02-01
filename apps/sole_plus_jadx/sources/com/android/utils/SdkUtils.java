package com.android.utils;

import com.android.SdkConstants;
import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class SdkUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String FILENAME_PREFIX = "From: ";
    public static final List<String> IMAGE_EXTENSIONS = ImmutableList.of(SdkConstants.DOT_PNG, SdkConstants.DOT_9PNG, SdkConstants.DOT_GIF, SdkConstants.DOT_JPEG, SdkConstants.DOT_JPG, SdkConstants.DOT_BMP, SdkConstants.DOT_WEBP, SdkConstants.DOT_AVIF);

    public static boolean endsWithIgnoreCase(String string, String suffix) {
        return string.regionMatches(true, string.length() - suffix.length(), suffix, 0, suffix.length());
    }

    public static boolean endsWith(CharSequence sequence, CharSequence suffix) {
        return endsWith(sequence, sequence.length(), suffix);
    }

    public static boolean endsWith(CharSequence sequence, int endOffset, CharSequence suffix) {
        if (endOffset < suffix.length()) {
            return false;
        }
        int i = endOffset - 1;
        for (int length = suffix.length() - 1; length >= 0; length--) {
            if (sequence.charAt(i) != suffix.charAt(length)) {
                return false;
            }
            i--;
        }
        return true;
    }

    public static boolean startsWithIgnoreCase(String string, String prefix) {
        return string.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static String wrap(String text, int lineWidth, String hangingIndent) {
        return wrap(text, lineWidth, lineWidth, hangingIndent);
    }

    public static String wrap(String text, int firstLineWidth, int nextLineWidth, String hangingIndent) {
        return wrap(text, firstLineWidth, nextLineWidth, hangingIndent, true);
    }

    public static String wrap(String text, int firstLineWidth, int nextLineWidth, String hangingIndent, boolean forceBreak) {
        int iMin;
        int iLastIndexOf;
        if (hangingIndent == null) {
            hangingIndent = "";
        }
        int length = text.length();
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i = iMin) {
            int iIndexOf = text.indexOf(10, i);
            if (iIndexOf == -1 || iIndexOf - i >= firstLineWidth) {
                iMin = Math.min(i + firstLineWidth, length);
                if (iMin - i < firstLineWidth) {
                    iLastIndexOf = iMin;
                    iMin = length;
                } else {
                    iLastIndexOf = text.lastIndexOf(32, iMin);
                    if (iLastIndexOf > i) {
                        iMin = iLastIndexOf + 1;
                    } else {
                        iLastIndexOf = iMin;
                        if (!forceBreak) {
                            while (iMin < length && !Character.isWhitespace(text.charAt(iMin))) {
                                iLastIndexOf++;
                                iMin++;
                            }
                        }
                    }
                }
            } else {
                iLastIndexOf = iIndexOf;
                iMin = iIndexOf + 1;
            }
            if (sb.length() > 0) {
                sb.append(hangingIndent);
            } else {
                firstLineWidth = nextLineWidth - hangingIndent.length();
            }
            sb.append((CharSequence) text, i, iLastIndexOf);
            sb.append('\n');
        }
        return sb.toString();
    }

    public static File urlToFile(String url) throws MalformedURLException {
        return urlToFile(new URL(url));
    }

    public static File urlToFile(URL url) throws MalformedURLException {
        try {
            return new File(url.toURI());
        } catch (IllegalArgumentException e) {
            MalformedURLException malformedURLException = new MalformedURLException(e.getLocalizedMessage());
            malformedURLException.initCause(e);
            throw malformedURLException;
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public static String fileToUrlString(File file) throws MalformedURLException {
        String externalForm = fileToUrl(file).toExternalForm();
        return !externalForm.startsWith("file:///") ? externalForm.replaceFirst("file:/", "file:///") : externalForm;
    }

    public static URL fileToUrl(File file) throws MalformedURLException {
        return file.toURI().toURL();
    }

    public static String createPathComment(File file, boolean includePadding) throws MalformedURLException {
        String strFileToUrlString = fileToUrlString(file);
        if (strFileToUrlString.indexOf("--") != -1) {
            strFileToUrlString = strFileToUrlString.replace("--", "%2D%2D");
        }
        if (includePadding) {
            return " From: " + strFileToUrlString + ' ';
        }
        return FILENAME_PREFIX + strFileToUrlString;
    }

    public static String xmlNameToConstantName(String xmlName) {
        return CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_UNDERSCORE, xmlName);
    }

    public static String camelCaseToConstantName(String camelCaseName) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, camelCaseName);
    }

    public static String constantNameToCamelCase(String constantName) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, constantName);
    }

    public static String constantNameToXmlName(String constantName) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, constantName);
    }

    public static String fileNameToResourceName(String fileName) {
        int iLastIndexOf = fileName.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            return fileName;
        }
        if (fileName.endsWith(SdkConstants.DOT_9PNG)) {
            return fileName.length() > SdkConstants.DOT_9PNG.length() ? fileName.substring(0, fileName.length() - SdkConstants.DOT_9PNG.length()) : fileName;
        }
        return fileName.substring(0, iLastIndexOf);
    }

    public static boolean hasImageExtension(String path) {
        Iterator<String> it = IMAGE_EXTENSIONS.iterator();
        while (it.hasNext()) {
            if (endsWithIgnoreCase(path, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBitmapFile(File file) {
        return hasImageExtension(file.getPath());
    }

    public static String escapePropertyValue(String value) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("k", value);
        StringWriter stringWriter = new StringWriter();
        try {
            properties.store(stringWriter, (String) null);
            String string = stringWriter.toString();
            int length = string.length();
            String strLineSeparator = System.lineSeparator();
            if (string.endsWith(strLineSeparator)) {
                length -= strLineSeparator.length();
            }
            return string.substring(string.indexOf(61) + 1, length);
        } catch (IOException unused) {
            return value;
        }
    }

    public static String globToRegexp(String glob) {
        StringBuilder sb = new StringBuilder(glob.length() * 2);
        sb.append('^');
        int length = glob.length();
        int i = 0;
        int iAppendQuoted = 0;
        while (i < length) {
            char cCharAt = glob.charAt(i);
            if (cCharAt == '*') {
                int iAppendQuoted2 = appendQuoted(sb, glob, iAppendQuoted, i);
                int i2 = iAppendQuoted2 + 1;
                if (i < length - 1) {
                    int i3 = i + 1;
                    if (glob.charAt(i3) == '*') {
                        i2 = iAppendQuoted2 + 2;
                        i = i3;
                    }
                }
                sb.append(".*?");
                iAppendQuoted = i2;
            } else if (cCharAt == '?') {
                iAppendQuoted = appendQuoted(sb, glob, iAppendQuoted, i) + 1;
                sb.append(".?");
            }
            i++;
        }
        appendQuoted(sb, glob, iAppendQuoted, glob.length());
        sb.append(Typography.dollar);
        return sb.toString();
    }

    private static int appendQuoted(StringBuilder sb, String s, int from, int to) {
        if (to > from) {
            int i = from;
            while (true) {
                if (i < to) {
                    char cCharAt = s.charAt(i);
                    if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '/' && cCharAt != ' ') {
                        sb.append(Pattern.quote(s.substring(from, to)));
                        break;
                    }
                    i++;
                } else {
                    while (from < to) {
                        sb.append(s.charAt(from));
                        from++;
                    }
                }
            }
        }
        return to;
    }

    public static boolean isServiceKey(String name) {
        name.hashCode();
        switch (name) {
            case "gcm_defaultSenderId":
            case "google_storage_bucket":
            case "google_crash_reporting_api_key":
            case "google_app_id":
            case "firebase_database_url":
            case "ga_trackingID":
            case "default_web_client_id":
            case "google_api_key":
                return true;
            default:
                return false;
        }
    }
}
