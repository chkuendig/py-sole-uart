package com.soletreadmills.sole_v2.ble.data;

import com.soletreadmills.sole_v2.ble.BleTools;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class FitnessMachineControlPointResponseData {
    private FitnessMachineStatusType fitnessMachineStatusType;
    private FitnessMachineControlPointOpCode.Type opCodeType;
    private FitnessMachineControlPointResultCode.Type resultCodeType;
    private byte[] value;

    public byte[] getValue() {
        return this.value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public FitnessMachineControlPointOpCode.Type getOpCodeType() {
        return this.opCodeType;
    }

    public void setOpCodeType(FitnessMachineControlPointOpCode.Type opCodeType) {
        this.opCodeType = opCodeType;
    }

    public FitnessMachineControlPointResultCode.Type getResultCodeType() {
        return this.resultCodeType;
    }

    public void setResultCodeType(FitnessMachineControlPointResultCode.Type resultCodeType) {
        this.resultCodeType = resultCodeType;
    }

    public FitnessMachineStatusType getFitnessMachineStatusType() {
        return this.fitnessMachineStatusType;
    }

    public void setFitnessMachineStatusType(FitnessMachineStatusType fitnessMachineStatusType) {
        this.fitnessMachineStatusType = fitnessMachineStatusType;
    }

    public String toString() {
        return "FitnessMachineControlPointResponseData{opCodeType=" + this.opCodeType + ", resultCodeType=" + this.resultCodeType + ", fitnessMachineStatusType=" + this.fitnessMachineStatusType + ", value (0x)=" + BleTools.bytesToHexUpper(this.value, true) + AbstractJsonLexerKt.END_OBJ;
    }
}
