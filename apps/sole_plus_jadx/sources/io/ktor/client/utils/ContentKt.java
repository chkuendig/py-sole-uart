package io.ktor.client.utils;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.Job;

/* compiled from: Content.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"wrapHeaders", "Lio/ktor/http/content/OutgoingContent;", "block", "Lkotlin/Function1;", "Lio/ktor/http/Headers;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ContentKt {
    public static final OutgoingContent wrapHeaders(OutgoingContent outgoingContent, Function1<? super Headers, ? extends Headers> block) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            return new OutgoingContent.NoContent(block, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.1
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = block.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new OutgoingContent.ReadChannelContent(block, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.2
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = block.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                /* renamed from: readFrom */
                public ByteReadChannel getChannel() {
                    return ((OutgoingContent.ReadChannelContent) this.$this_wrapHeaders).getChannel();
                }

                @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
                public ByteReadChannel readFrom(LongRange range) {
                    Intrinsics.checkNotNullParameter(range, "range");
                    return ((OutgoingContent.ReadChannelContent) this.$this_wrapHeaders).readFrom(range);
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            return new OutgoingContent.WriteChannelContent(block, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.3
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = block.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
                public Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
                    Object objWriteTo = ((OutgoingContent.WriteChannelContent) this.$this_wrapHeaders).writeTo(byteWriteChannel, continuation);
                    return objWriteTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteTo : Unit.INSTANCE;
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            return new OutgoingContent.ByteArrayContent(block, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.4
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = block.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public HttpStatusCode getStatus() {
                    return this.$this_wrapHeaders.getStatus();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
                /* renamed from: bytes */
                public byte[] getContent() {
                    return ((OutgoingContent.ByteArrayContent) this.$this_wrapHeaders).getContent();
                }
            };
        }
        if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            return new OutgoingContent.ProtocolUpgrade(block, outgoingContent) { // from class: io.ktor.client.utils.ContentKt.wrapHeaders.5
                final /* synthetic */ OutgoingContent $this_wrapHeaders;
                private final Headers headers;

                {
                    this.$this_wrapHeaders = outgoingContent;
                    this.headers = block.invoke(outgoingContent.getHeaders());
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Long getContentLength() {
                    return this.$this_wrapHeaders.getContentLength();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public ContentType getContentType() {
                    return this.$this_wrapHeaders.getContentType();
                }

                @Override // io.ktor.http.content.OutgoingContent
                public Headers getHeaders() {
                    return this.headers;
                }

                @Override // io.ktor.http.content.OutgoingContent.ProtocolUpgrade
                public Object upgrade(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Continuation<? super Job> continuation) {
                    return ((OutgoingContent.ProtocolUpgrade) this.$this_wrapHeaders).upgrade(byteReadChannel, byteWriteChannel, coroutineContext, coroutineContext2, continuation);
                }
            };
        }
        throw new NoWhenBranchMatchedException();
    }
}
