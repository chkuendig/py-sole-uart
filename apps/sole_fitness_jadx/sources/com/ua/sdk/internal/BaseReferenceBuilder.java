package com.ua.sdk.internal;

import com.ua.sdk.UaLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class BaseReferenceBuilder {
    private static final String SELF_KEY = "self";
    private int expectedLength;
    private String href;
    private String hrefTemplate;
    private boolean dirty = false;
    private boolean multiGet = false;
    private boolean didParseTemplateParams = false;
    ArrayList<Param> params = null;
    ArrayList<String> selfParams = null;

    protected BaseReferenceBuilder(String str) {
        this.expectedLength = 0;
        str = str == null ? "" : str;
        this.hrefTemplate = str;
        this.expectedLength = 0 + str.length();
    }

    protected void addSelfParam(int i) {
        addSelfParam(String.valueOf(i));
    }

    protected void addSelfParam(String str) {
        if (str == null) {
            return;
        }
        if (this.params == null) {
            this.params = new ArrayList<>(8);
        }
        if (this.selfParams == null) {
            this.selfParams = new ArrayList<>(8);
        }
        this.dirty = true;
        this.multiGet = true;
        this.selfParams.add(str);
        this.expectedLength += str.length();
    }

    protected void setParam(String str, int i) {
        setParam(str, String.valueOf(i));
    }

    protected void setParam(String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            if (removeParam(str) != null) {
                this.dirty = true;
                return;
            }
            return;
        }
        if (this.params == null) {
            this.params = new ArrayList<>(8);
        }
        this.dirty = true;
        Param param = getParam(str);
        if (param == null) {
            this.params.add(new Param(str, str2));
            this.expectedLength += str.length() + str2.length() + 2;
        } else {
            this.expectedLength += str2.length() - param.value.length();
            param.value = str2;
        }
    }

    protected void setParams(String str, String... strArr) {
        if (str == null) {
            return;
        }
        if (strArr == null || strArr.length == 0) {
            if (removeParams(str) != null) {
                this.dirty = true;
                return;
            }
            return;
        }
        if (this.params == null) {
            this.params = new ArrayList<>(8);
        }
        this.dirty = true;
        for (int i = 0; i < strArr.length; i++) {
            this.params.add(new Param(str, strArr[i]));
            this.expectedLength += str.length() + strArr[i].length() + 2;
        }
    }

    protected void parseTemplateParams() {
        if (this.didParseTemplateParams) {
            return;
        }
        this.didParseTemplateParams = true;
        int iIndexOf = this.hrefTemplate.indexOf(63);
        if (iIndexOf >= 0) {
            String strSubstring = this.hrefTemplate.substring(iIndexOf);
            this.hrefTemplate = this.hrefTemplate.substring(0, iIndexOf);
            this.dirty = true;
            int length = strSubstring.length();
            int i = 1;
            while (i < length) {
                int iIndexOf2 = strSubstring.indexOf(61, i);
                if (iIndexOf2 < 0) {
                    throw new IllegalArgumentException(this.hrefTemplate + " is incorrectly formatted.");
                }
                String strSubstring2 = strSubstring.substring(i, iIndexOf2);
                int iIndexOf3 = strSubstring.indexOf(38, i);
                if (iIndexOf3 < 0) {
                    iIndexOf3 = length;
                }
                setParam(strSubstring2, strSubstring.substring(iIndexOf2 + 1, iIndexOf3));
                i = iIndexOf3 + 1;
            }
        }
    }

    public String getHref() {
        if (!this.dirty) {
            if (this.href == null) {
                this.href = this.hrefTemplate;
            }
            return this.href;
        }
        if (this.multiGet) {
            this.expectedLength += 4;
        }
        StringBuilder sb = new StringBuilder(this.expectedLength);
        writeHref(sb);
        writeParams(sb);
        writeSelfParams(sb);
        return sb.toString();
    }

    protected Param removeParam(String str) {
        parseTemplateParams();
        ArrayList<Param> arrayList = this.params;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Param param = this.params.get(i);
            if (param.key.equals(str)) {
                this.params.remove(i);
                this.expectedLength -= (param.key.length() + param.value.length()) + 2;
                return param;
            }
        }
        return null;
    }

    protected List<Param> removeParams(String str) {
        parseTemplateParams();
        ArrayList<Param> arrayList = this.params;
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Param param = this.params.get(i);
            if (param.key.equals(str)) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                this.params.remove(i);
                this.expectedLength -= (param.key.length() + param.value.length()) + 2;
                arrayList2.add(param);
            }
        }
        return arrayList2;
    }

    protected Param getParam(String str) {
        parseTemplateParams();
        ArrayList<Param> arrayList = this.params;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Param param = this.params.get(i);
            if (param.key.equals(str)) {
                return param;
            }
        }
        return null;
    }

    protected List<Param> getParams(String str) {
        parseTemplateParams();
        ArrayList<Param> arrayList = this.params;
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Param param = this.params.get(i);
            if (param.key.equals(str)) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(param);
            }
        }
        return arrayList2;
    }

    private void writeHref(StringBuilder sb) {
        String str = this.hrefTemplate;
        int length = str.length();
        int i = -1;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                sb.append(cCharAt);
                z = false;
            } else if (cCharAt == '\\') {
                sb.append(cCharAt);
                z = true;
            } else if (cCharAt == '{') {
                i2++;
                if (i2 == 1) {
                    i = i4;
                }
            } else if (cCharAt != '}') {
                if (i < 0) {
                    sb.append(cCharAt);
                }
            } else if (i2 > 0) {
                i3++;
                if (i2 == i3) {
                    Param param = getParam(str.substring(i + i2, (i4 + 1) - i3));
                    param.isTemplateParam = true;
                    if (param == null) {
                        sb.append("null");
                    } else {
                        sb.append(urlEncode(param.value));
                    }
                    i = -1;
                    i2 = 0;
                    i3 = 0;
                }
            } else {
                sb.append(cCharAt);
            }
        }
    }

    private void writeParams(StringBuilder sb) {
        int size = this.params.size();
        char c = '?';
        for (int i = 0; i < size; i++) {
            Param param = this.params.get(i);
            if (!param.isTemplateParam) {
                sb.append(c);
                c = Typography.amp;
                sb.append(param.key);
                sb.append('=');
                String valueTemplateKey = param.getValueTemplateKey();
                if (valueTemplateKey != null) {
                    Param param2 = getParam(valueTemplateKey);
                    if (param2 != null) {
                        param2.isTemplateParam = true;
                        sb.append(urlEncode(param2.value));
                    } else {
                        sb.append(urlEncode(param.value));
                    }
                } else {
                    sb.append(urlEncode(param.value));
                }
            }
        }
    }

    private void writeSelfParams(StringBuilder sb) {
        if (this.multiGet) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = this.selfParams.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(next);
            }
            if (sb2.length() > 0) {
                sb.append(this.params.isEmpty() ? '?' : Typography.amp);
                sb.append("self");
                sb.append("=");
                sb.append(sb2.toString());
            }
        }
    }

    private static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            UaLog.error("UrlEncode error", (Throwable) e);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static class Param {
        boolean isTemplateParam;
        String key;
        String value;

        private Param(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getValueTemplateKey() {
            int length = this.value.length();
            if (length <= 1) {
                return null;
            }
            int i = 0;
            if (this.value.charAt(0) != '{' || this.value.charAt(length - 1) != '}') {
                return null;
            }
            while (this.value.charAt(i) == '{') {
                i++;
            }
            while (this.value.charAt(length - 1) == '}') {
                length--;
            }
            return this.value.substring(i, length);
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }
    }
}
