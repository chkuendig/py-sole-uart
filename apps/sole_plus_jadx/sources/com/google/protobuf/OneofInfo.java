package com.google.protobuf;

/* loaded from: classes5.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* renamed from: id, reason: collision with root package name */
    private final int f188id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.f188id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public int getId() {
        return this.f188id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
