package com.android.utils;

import com.google.common.base.Charsets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* loaded from: classes3.dex */
public class CharSequences {
    public static int indexOf(CharSequence sequence, char c) {
        return indexOf(sequence, c, 0);
    }

    public static int indexOf(CharSequence sequence, char c, int start) {
        while (start < sequence.length()) {
            if (sequence.charAt(start) == c) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence haystack, String needle, int start) {
        int length = haystack.length();
        int length2 = needle.length();
        if (length2 > length || start < 0) {
            return -1;
        }
        if (length2 <= 0) {
            return start < length ? start : length;
        }
        int i = length - length2;
        if (start > i) {
            start = i;
        }
        char cCharAt = needle.charAt(0);
        while (true) {
            int iLastIndexOf = lastIndexOf(haystack, cCharAt, start);
            if (iLastIndexOf == -1) {
                return -1;
            }
            int i2 = iLastIndexOf;
            int i3 = 0;
            do {
                i3++;
                if (i3 >= length2) {
                    break;
                }
                i2++;
            } while (haystack.charAt(i2) == needle.charAt(i3));
            if (i3 == length2) {
                return iLastIndexOf;
            }
            start = iLastIndexOf - 1;
        }
    }

    public static int lastIndexOf(CharSequence sequence, char c) {
        return lastIndexOf(sequence, c, sequence.length());
    }

    public static int lastIndexOf(CharSequence sequence, int c, int start) {
        int length = sequence.length();
        if (start < 0) {
            return -1;
        }
        if (start >= length) {
            start = length - 1;
        }
        while (start >= 0) {
            if (sequence.charAt(start) == c) {
                return start;
            }
            start--;
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence haystack, String needle) {
        return lastIndexOf(haystack, needle, haystack.length());
    }

    public static boolean regionMatches(CharSequence sequence, int thisStart, CharSequence string, int start, int length) {
        if (start < 0 || string.length() - start < length || thisStart < 0 || sequence.length() - thisStart < length) {
            return false;
        }
        if (length <= 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (sequence.charAt(thisStart + i) != string.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean regionMatches(CharSequence sequence, boolean ignoreCase, int thisStart, CharSequence string, int start, int length) {
        if (!ignoreCase) {
            return regionMatches(sequence, thisStart, string, start, length);
        }
        if (thisStart < 0 || length > sequence.length() - thisStart || start < 0 || length > string.length() - start) {
            return false;
        }
        int i = length + thisStart;
        while (thisStart < i) {
            int i2 = thisStart + 1;
            char cCharAt = sequence.charAt(thisStart);
            int i3 = start + 1;
            char cCharAt2 = string.charAt(start);
            if (cCharAt != cCharAt2 && foldCase(cCharAt) != foldCase(cCharAt2)) {
                return false;
            }
            thisStart = i2;
            start = i3;
        }
        return true;
    }

    private static char foldCase(char ch) {
        if (ch < 128) {
            return ('A' > ch || ch > 'Z') ? ch : (char) (ch + ' ');
        }
        return Character.toLowerCase(Character.toUpperCase(ch));
    }

    public static boolean startsWith(CharSequence sequence, CharSequence prefix) {
        return startsWith(sequence, prefix, 0);
    }

    public static boolean startsWith(CharSequence sequence, CharSequence prefix, int start) {
        int length = sequence.length();
        int length2 = prefix.length();
        if (length < start + length2) {
            return false;
        }
        for (int i = 0; i < length2; i++) {
            if (sequence.charAt(start) != prefix.charAt(i)) {
                return false;
            }
            start++;
        }
        return true;
    }

    public static boolean endsWith(CharSequence sequence, CharSequence suffix, boolean caseSensitive) {
        if (suffix.length() > sequence.length()) {
            return false;
        }
        int length = suffix.length();
        int length2 = sequence.length();
        int i = length2 - length;
        int i2 = 0;
        while (i < length2) {
            char cCharAt = sequence.charAt(i);
            char cCharAt2 = suffix.charAt(i2);
            if (cCharAt != cCharAt2 && (caseSensitive || Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2))) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static boolean containsUpperCase(CharSequence s) {
        if (s != null) {
            int length = s.length();
            for (int i = 0; i < length; i++) {
                if (Character.isUpperCase(s.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int indexOf(CharSequence haystack, CharSequence needle) {
        return indexOf(haystack, needle, 0);
    }

    public static int indexOf(CharSequence haystack, CharSequence needle, int start) {
        int length = needle.length();
        if (length == 0) {
            return start;
        }
        char cCharAt = needle.charAt(0);
        if (length == 1) {
            return indexOf(haystack, cCharAt, start);
        }
        int length2 = haystack.length() - length;
        while (start <= length2) {
            if (haystack.charAt(start) == cCharAt) {
                int i = start + 1;
                for (int i2 = 1; i2 < length; i2++) {
                    if (haystack.charAt(i) != needle.charAt(i2)) {
                        break;
                    }
                    i++;
                }
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int indexOfIgnoreCase(CharSequence where, CharSequence what, int fromIndex) {
        int length = what.length();
        int length2 = where.length();
        if (fromIndex >= length2) {
            if (length == 0) {
                return length2;
            }
            return -1;
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (length == 0) {
            return fromIndex;
        }
        char cCharAt = what.charAt(0);
        int i = length2 - length;
        while (fromIndex <= i) {
            if (!charsEqualIgnoreCase(where.charAt(fromIndex), cCharAt)) {
                do {
                    fromIndex++;
                    if (fromIndex > i) {
                        break;
                    }
                } while (!charsEqualIgnoreCase(where.charAt(fromIndex), cCharAt));
            }
            if (fromIndex <= i) {
                int i2 = fromIndex + 1;
                int i3 = (i2 + length) - 1;
                for (int i4 = 1; i2 < i3 && charsEqualIgnoreCase(where.charAt(i2), what.charAt(i4)); i4++) {
                    i2++;
                }
                if (i2 == i3) {
                    return fromIndex;
                }
            }
            fromIndex++;
        }
        return -1;
    }

    private static boolean charsEqualIgnoreCase(char c1, char c2) {
        return toUpperCase(c1) == toUpperCase(c2) || toLowerCase(c1) == toLowerCase(c2);
    }

    public static char toUpperCase(char c) {
        return c < 'a' ? c : c <= 'z' ? (char) (c - ' ') : Character.toUpperCase(c);
    }

    public static char toLowerCase(char c) {
        return c >= 'A' ? (c < 'a' || c > 'z') ? c <= 'Z' ? (char) (c + ' ') : Character.toLowerCase(c) : c : c;
    }

    public static CharSequence createSequence(char[] data) {
        return new ArrayBackedCharSequence(data);
    }

    public static CharSequence createSequence(char[] data, int offset, int length) {
        return new ArrayBackedCharSequence(data, offset, length);
    }

    public static char[] getCharArray(CharSequence sequence) {
        if (sequence instanceof ArrayBackedCharSequence) {
            return ((ArrayBackedCharSequence) sequence).getCharArray();
        }
        return sequence.toString().toCharArray();
    }

    public static CharSequenceReader getReader(CharSequence data, boolean stripBom) {
        CharSequenceReader charSequenceReader = new CharSequenceReader(data);
        if (stripBom && data.length() > 0 && data.charAt(0) == 65279) {
            charSequenceReader.read();
        }
        return charSequenceReader;
    }

    public static Document parseDocumentSilently(CharSequence xml, boolean namespaceAware) {
        try {
            return XmlUtils.parseDocument(getReader(xml, true), namespaceAware);
        } catch (IOException | SAXException unused) {
            return null;
        }
    }

    public static InputStream getInputStream(CharSequence text) {
        return new ByteArrayInputStream(text.toString().getBytes(Charsets.UTF_8));
    }

    private static class ArrayBackedCharSequence implements CharSequence {
        public final char[] data;
        private final int length;
        private final int offset;

        public ArrayBackedCharSequence(char[] data) {
            this(data, 0, data.length);
        }

        public ArrayBackedCharSequence(char[] data, int offset, int length) {
            this.data = data;
            this.offset = offset;
            this.length = length;
        }

        public char[] getCharArray() {
            int i = this.offset;
            if (i == 0) {
                int i2 = this.length;
                char[] cArr = this.data;
                if (i2 == cArr.length) {
                    return cArr;
                }
            }
            return Arrays.copyOfRange(this.data, i, this.length + i);
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.length;
        }

        @Override // java.lang.CharSequence
        public char charAt(int index) {
            return this.data[this.offset + index];
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int start, int end) {
            return new ArrayBackedCharSequence(this.data, this.offset + start, end - start);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return new String(this.data, this.offset, this.length);
        }
    }
}
