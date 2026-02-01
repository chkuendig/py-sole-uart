package com.google.ai.client.generativeai.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: RequestOptions.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B$\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u0002\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lcom/google/ai/client/generativeai/common/RequestOptions;", "", "timeout", "", "apiVersion", "", "endpoint", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/time/Duration;", "(JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getApiVersion", "()Ljava/lang/String;", "getEndpoint", "getTimeout-UwyO8pc", "()J", "J", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RequestOptions {
    private final String apiVersion;
    private final String endpoint;
    private final long timeout;

    public RequestOptions() {
        this((Long) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ RequestOptions(long j, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2);
    }

    public RequestOptions(Long l) {
        this(l, (String) null, (String) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestOptions(Long l, String apiVersion) {
        this(l, apiVersion, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(apiVersion, "apiVersion");
    }

    private RequestOptions(long j, String apiVersion, String endpoint) {
        Intrinsics.checkNotNullParameter(apiVersion, "apiVersion");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        this.timeout = j;
        this.apiVersion = apiVersion;
        this.endpoint = endpoint;
    }

    /* renamed from: getTimeout-UwyO8pc, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    public /* synthetic */ RequestOptions(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? "v1beta" : str, (i & 4) != 0 ? "https://generativelanguage.googleapis.com" : str2, null);
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public /* synthetic */ RequestOptions(Long l, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Long.MAX_VALUE : l, (i & 2) != 0 ? "v1beta" : str, (i & 4) != 0 ? "https://generativelanguage.googleapis.com" : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestOptions(Long l, String apiVersion, String endpoint) {
        this(DurationKt.toDuration(l != null ? l.longValue() : Long.MAX_VALUE, DurationUnit.MILLISECONDS), apiVersion, endpoint, null);
        Intrinsics.checkNotNullParameter(apiVersion, "apiVersion");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
    }
}
