package androidx.health.platform.client.proto;

@CheckReturnValue
/* loaded from: classes2.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* renamed from: id, reason: collision with root package name */
    private final int f106id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int id2, java.lang.reflect.Field caseField, java.lang.reflect.Field valueField) {
        this.f106id = id2;
        this.caseField = caseField;
        this.valueField = valueField;
    }

    public int getId() {
        return this.f106id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
