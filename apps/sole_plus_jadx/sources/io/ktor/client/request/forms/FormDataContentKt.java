package io.ktor.client.request.forms;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.objectweb.asm.Opcodes;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"RN_BYTES", "", "generateBoundary", "", "copyTo", "", "Lio/ktor/utils/io/core/Input;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/core/Input;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FormDataContentKt {
    private static final byte[] RN_BYTES;

    /* compiled from: FormDataContent.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.request.forms.FormDataContentKt", f = "FormDataContent.kt", i = {1, 1, 1, 2, 2}, l = {159, 174, Opcodes.PUTFIELD, Opcodes.PUTFIELD}, m = "copyTo", n = {"$this$copyTo", "channel", "$this$write_u24default$iv", "$this$copyTo", "channel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    /* renamed from: io.ktor.client.request.forms.FormDataContentKt$copyTo$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FormDataContentKt.copyTo(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            String string = Integer.toString(Random.INSTANCE.nextInt(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        return StringsKt.take(string2, 70);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00d8 -> B:28:0x008a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.core.Input r18, io.ktor.utils.io.ByteWriteChannel r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.FormDataContentKt.copyTo(io.ktor.utils.io.core.Input, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        byte[] bArrEncodeToByteArray;
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArrEncodeToByteArray = StringsKt.encodeToByteArray("\r\n");
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrEncodeToByteArray = CharsetJVMKt.encodeToByteArray(charsetEncoderNewEncoder, "\r\n", 0, "\r\n".length());
        }
        RN_BYTES = bArrEncodeToByteArray;
    }
}
