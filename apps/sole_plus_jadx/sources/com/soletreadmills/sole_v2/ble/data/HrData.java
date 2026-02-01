package com.soletreadmills.sole_v2.ble.data;

import java.util.Date;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class HrData {
    protected final Date createDate = new Date();
    protected String modelCode = "";
    protected String macAddress = null;
    private Integer hr = null;

    public Date getCreateDate() {
        return this.createDate;
    }

    public String getModelCode() {
        return this.modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getHr() {
        return this.hr;
    }

    public void setHr(Integer hr) {
        this.hr = hr;
    }

    public String toString() {
        return "HrData{createDate=" + this.createDate + ", modelCode='" + this.modelCode + "', macAddress='" + this.macAddress + "', hr=" + this.hr + AbstractJsonLexerKt.END_OBJ;
    }
}
