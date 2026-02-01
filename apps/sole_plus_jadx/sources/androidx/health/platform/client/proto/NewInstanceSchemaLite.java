package androidx.health.platform.client.proto;

@CheckReturnValue
/* loaded from: classes2.dex */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    @Override // androidx.health.platform.client.proto.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageLite) defaultInstance).newMutableInstance();
    }
}
