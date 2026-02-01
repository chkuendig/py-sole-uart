package io.ktor.client.request.forms;

import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.PartData;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.ByteReadPacketExtensionsKt;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.objectweb.asm.Opcodes;

/* compiled from: formDsl.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\n¢\u0006\u0002\u0010\u000b\u001a[\u0010\f\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0002\u0010\u0015\u001a]\u0010\f\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"formData", "", "Lio/ktor/http/content/PartData;", "block", "Lkotlin/Function1;", "Lio/ktor/client/request/forms/FormBuilder;", "", "Lkotlin/ExtensionFunctionType;", SdkConstants.FD_RES_VALUES, "", "Lio/ktor/client/request/forms/FormPart;", "([Lio/ktor/client/request/forms/FormPart;)Ljava/util/List;", "append", "key", "", "headers", "Lio/ktor/http/Headers;", ContentDisposition.Parameters.Size, "", "bodyBuilder", "Lio/ktor/utils/io/core/BytePacketBuilder;", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Lio/ktor/http/Headers;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", ContentDisposition.Parameters.FileName, "contentType", "Lio/ktor/http/ContentType;", "(Lio/ktor/client/request/forms/FormBuilder;Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/ContentType;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;)V", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FormDslKt {
    public static final List<PartData> formData(FormPart<?>... values) {
        PartData binaryChannelItem;
        Intrinsics.checkNotNullParameter(values, "values");
        ArrayList arrayList = new ArrayList();
        for (FormPart<?> formPart : values) {
            String key = formPart.getKey();
            final Object objComponent2 = formPart.component2();
            Headers headers = formPart.getHeaders();
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            headersBuilder.append(HttpHeaders.INSTANCE.getContentDisposition(), "form-data; name=" + HeaderValueWithParametersKt.escapeIfNeeded(key));
            headersBuilder.appendAll(headers);
            if (objComponent2 instanceof String) {
                binaryChannelItem = new PartData.FormItem((String) objComponent2, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Number) {
                binaryChannelItem = new PartData.FormItem(objComponent2.toString(), new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$2
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof Boolean) {
                binaryChannelItem = new PartData.FormItem(objComponent2.toString(), new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$3
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof byte[]) {
                headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(((byte[]) objComponent2).length));
                binaryChannelItem = new PartData.BinaryItem(new Function0<Input>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Input invoke() {
                        final byte[] bArr = (byte[]) objComponent2;
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, bArr.length);
                        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
                        return ByteReadPacketExtensionsKt.ByteReadPacket(byteBufferWrap, new Function1<ByteBuffer, Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$4$invoke$$inlined$ByteReadPacket$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ByteBuffer it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                                invoke2(byteBuffer);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$5
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof ByteReadPacket) {
                headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(((ByteReadPacket) objComponent2).getRemaining()));
                binaryChannelItem = new PartData.BinaryItem(new Function0<Input>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Input invoke() {
                        return ((ByteReadPacket) objComponent2).copy();
                    }
                }, new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ((ByteReadPacket) objComponent2).close();
                    }
                }, headersBuilder.build());
            } else if (objComponent2 instanceof InputProvider) {
                InputProvider inputProvider = (InputProvider) objComponent2;
                Long size = inputProvider.getSize();
                if (size != null) {
                    headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), size.toString());
                }
                binaryChannelItem = new PartData.BinaryItem(inputProvider.getBlock(), new Function0<Unit>() { // from class: io.ktor.client.request.forms.FormDslKt$formData$1$part$8
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, headersBuilder.build());
            } else {
                if (!(objComponent2 instanceof ChannelProvider)) {
                    if (objComponent2 instanceof Input) {
                        throw new IllegalStateException(("Can't use [Input] as part of form: " + objComponent2 + ". Consider using [InputProvider] instead.").toString());
                    }
                    throw new IllegalStateException(("Unknown form content type: " + objComponent2).toString());
                }
                ChannelProvider channelProvider = (ChannelProvider) objComponent2;
                Long size2 = channelProvider.getSize();
                if (size2 != null) {
                    headersBuilder.append(HttpHeaders.INSTANCE.getContentLength(), size2.toString());
                }
                binaryChannelItem = new PartData.BinaryChannelItem(channelProvider.getBlock(), headersBuilder.build());
            }
            arrayList.add(binaryChannelItem);
        }
        return arrayList;
    }

    public static final List<PartData> formData(Function1<? super FormBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FormBuilder formBuilder = new FormBuilder();
        block.invoke(formBuilder);
        FormPart[] formPartArr = (FormPart[]) formBuilder.build$ktor_client_core().toArray(new FormPart[0]);
        return formData((FormPart<?>[]) Arrays.copyOf(formPartArr, formPartArr.length));
    }

    public static /* synthetic */ void append$default(FormBuilder formBuilder, String key, Headers headers, Long l, Function1 bodyBuilder, int i, Object obj) {
        if ((i & 2) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i & 4) != 0) {
            l = null;
        }
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        formBuilder.append(new FormPart(key, new InputProvider(l, new AnonymousClass2(bodyBuilder)), headers));
    }

    /* compiled from: formDsl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.client.request.forms.FormDslKt$append$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Input> {
        final /* synthetic */ Function1<BytePacketBuilder, Unit> $bodyBuilder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super BytePacketBuilder, Unit> function1) {
            super(0);
            this.$bodyBuilder = function1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Input invoke() {
            Function1<BytePacketBuilder, Unit> function1 = this.$bodyBuilder;
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
            try {
                function1.invoke(bytePacketBuilder);
                return bytePacketBuilder.build();
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        }
    }

    public static final void append(FormBuilder formBuilder, String key, Headers headers, Long l, Function1<? super BytePacketBuilder, Unit> bodyBuilder) {
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        formBuilder.append(new FormPart(key, new InputProvider(l, new AnonymousClass2(bodyBuilder)), headers));
    }

    public static final void append(FormBuilder formBuilder, String key, String filename, ContentType contentType, Long l, Function1<? super BytePacketBuilder, Unit> bodyBuilder) {
        Intrinsics.checkNotNullParameter(formBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(bodyBuilder, "bodyBuilder");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.set(HttpHeaders.INSTANCE.getContentDisposition(), "filename=" + HeaderValueWithParametersKt.escapeIfNeeded(filename));
        if (contentType != null) {
            headersBuilder.set(HttpHeaders.INSTANCE.getContentType(), contentType.toString());
        }
        formBuilder.append(new FormPart(key, new InputProvider(l, new AnonymousClass2(bodyBuilder)), headersBuilder.build()));
    }
}
