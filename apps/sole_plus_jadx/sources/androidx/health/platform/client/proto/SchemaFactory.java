package androidx.health.platform.client.proto;

@CheckReturnValue
/* loaded from: classes2.dex */
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}
