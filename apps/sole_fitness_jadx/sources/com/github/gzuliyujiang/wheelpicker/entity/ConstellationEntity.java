package com.github.gzuliyujiang.wheelpicker.entity;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public class ConstellationEntity implements TextProvider, Serializable {
    private static final boolean IS_CHINESE = Locale.getDefault().getDisplayLanguage().contains("中文");
    private String endDate;
    private String english;
    private String id;
    private String name;
    private String startDate;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
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
        ConstellationEntity constellationEntity = (ConstellationEntity) obj;
        return Objects.equals(this.id, constellationEntity.id) || Objects.equals(this.startDate, constellationEntity.startDate) || Objects.equals(this.endDate, constellationEntity.endDate) || Objects.equals(this.name, constellationEntity.name) || Objects.equals(this.english, constellationEntity.english);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.startDate, this.endDate, this.name, this.english);
    }

    public String toString() {
        return "ConstellationEntity{id='" + this.id + "', startDate='" + this.startDate + "', endDate='" + this.endDate + "', name='" + this.name + "', english" + this.english + "'}";
    }
}
