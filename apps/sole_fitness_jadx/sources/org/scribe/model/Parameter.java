package org.scribe.model;

import org.scribe.utils.OAuthEncoder;

/* loaded from: classes2.dex */
public class Parameter implements Comparable<Parameter> {
    private static final String UTF = "UTF8";
    private final String key;
    private final String value;

    public Parameter(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String asUrlEncodedPair() {
        return OAuthEncoder.encode(this.key).concat("=").concat(OAuthEncoder.encode(this.value));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        return parameter.key.equals(this.key) && parameter.value.equals(this.value);
    }

    public int hashCode() {
        return this.key.hashCode() + this.value.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Parameter parameter) {
        int iCompareTo = this.key.compareTo(parameter.key);
        return iCompareTo != 0 ? iCompareTo : this.value.compareTo(parameter.value);
    }
}
