package androidx.datastore.preferences.protobuf;

/* loaded from: classes2.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* renamed from: id, reason: collision with root package name */
    private final int f103id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.f103id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public int getId() {
        return this.f103id;
    }

    public java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
