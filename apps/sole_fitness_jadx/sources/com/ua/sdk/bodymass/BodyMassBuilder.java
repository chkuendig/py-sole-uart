package com.ua.sdk.bodymass;

import com.ua.sdk.internal.Precondition;
import java.util.Date;

/* loaded from: classes2.dex */
public class BodyMassBuilder {
    private static final String RECORDER_DEFAULT = "client_manual_creation";
    String bmi;
    String dateTimeTimezone;
    Date dateTimeUtc;
    String fatMass;
    String fatPercent;
    String leanMass;
    String mass;
    String recorderType;
    String referenceKey;

    public BodyMassBuilder setDateTimeUtc(Date date) {
        this.dateTimeUtc = date;
        return this;
    }

    public BodyMassBuilder setDateTimeTimezone(String str) {
        this.dateTimeTimezone = str;
        return this;
    }

    public BodyMassBuilder setRecorderType(String str) {
        this.recorderType = str;
        return this;
    }

    public BodyMassBuilder setReferenceKey(String str) {
        this.referenceKey = str;
        return this;
    }

    public BodyMassBuilder setMass(String str) {
        this.mass = str;
        return this;
    }

    public BodyMassBuilder setBmi(String str) {
        this.bmi = str;
        return this;
    }

    public BodyMassBuilder setFatPercent(String str) {
        this.fatPercent = str;
        return this;
    }

    public BodyMassBuilder setLeanMass(String str) {
        this.leanMass = str;
        return this;
    }

    public BodyMassBuilder setFatMass(String str) {
        this.fatMass = str;
        return this;
    }

    public BodyMass build() throws NullPointerException {
        Precondition.isNotNull(this.dateTimeUtc, "Measurement DateTime");
        Precondition.isNotNull(this.dateTimeTimezone, "Measurement DateTime Timezone");
        Precondition.isNotNull(this.referenceKey, "Measurement Device's Reference Key");
        if (this.recorderType == null) {
            this.recorderType = RECORDER_DEFAULT;
        }
        BodyMassImpl bodyMassImpl = new BodyMassImpl();
        bodyMassImpl.setDateTimeUtc(this.dateTimeUtc);
        bodyMassImpl.setDateTimeTimezone(this.dateTimeTimezone);
        bodyMassImpl.setRecorderType(this.recorderType);
        bodyMassImpl.setReferenceKey(this.referenceKey);
        bodyMassImpl.setMass(this.mass);
        bodyMassImpl.setBmi(this.bmi);
        bodyMassImpl.setFatPercent(this.fatPercent);
        bodyMassImpl.setLeanMass(this.leanMass);
        bodyMassImpl.setFatMass(this.fatMass);
        return bodyMassImpl;
    }
}
