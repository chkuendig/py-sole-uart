package com.github.gzuliyujiang.wheelpicker.entity;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public class SexEntity implements TextProvider, Serializable {
    private static final boolean IS_CHINESE = Locale.getDefault().getDisplayLanguage().contains("中文");
    private String english;
    private String id;
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEnglish() {
        return this.english;
    }

    public void setEnglish(String str) {
        this.english = str;
    }

    @Override // com.github.gzuliyujiang.wheelview.contract.TextProvider
    public String provideText() {
        if (IS_CHINESE) {
            return this.name;
        }
        return this.english;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SexEntity sexEntity = (SexEntity) obj;
        return Objects.equals(this.id, sexEntity.id) || Objects.equals(this.name, sexEntity.name) || Objects.equals(this.english, sexEntity.english);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.name, this.english);
    }

    public String toString() {
        return "SexEntity{id='" + this.id + "', name='" + this.name + "', english" + this.english + "'}";
    }
}
