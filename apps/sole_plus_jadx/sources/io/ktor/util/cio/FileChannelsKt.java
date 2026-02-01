package io.ktor.util.cio;

import com.android.SdkConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.jvm.nio.WritingKt;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: FileChannels.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"readChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/File;", "start", "", "endInclusive", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "writeChannel", "Lio/ktor/utils/io/ByteWriteChannel;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FileChannelsKt {
    public static /* synthetic */ ByteReadChannel readChannel$default(File file, long j, long j2, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = -1;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        return readChannel(file, j3, j4, coroutineContext);
    }

    /* compiled from: FileChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1", f = "FileChannels.kt", i = {0, 0, 1, 1}, l = {46, 65}, m = "invokeSuspend", n = {"$this$use$iv", "closed$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "I$0", "L$0", "I$0"})
    /* renamed from: io.ktor.util.cio.FileChannelsKt$readChannel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $endInclusive;
        final /* synthetic */ long $fileLength;
        final /* synthetic */ long $start;
        final /* synthetic */ File $this_readChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, long j2, long j3, File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$start = j;
            this.$endInclusive = j2;
            this.$fileLength = j3;
            this.$this_readChannel = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$start, this.$endInclusive, this.$fileLength, this.$this_readChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Closeable closeable;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope = (WriterScope) this.L$0;
                long j = this.$start;
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(("start position shouldn't be negative but it is " + j).toString());
                }
                long j2 = this.$endInclusive;
                long j3 = this.$fileLength;
                if (!(j2 <= j3 - 1)) {
                    throw new IllegalArgumentException(("endInclusive points to the position out of the file: file size = " + j3 + ", endInclusive = " + j2).toString());
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.$this_readChannel, SdkConstants.FD_RES_CLASS);
                long j4 = this.$start;
                final long j5 = this.$endInclusive;
                try {
                    final FileChannel channel = randomAccessFile.getChannel();
                    Intrinsics.checkNotNullExpressionValue(channel, "file.channel");
                    if (j4 > 0) {
                        channel.position(j4);
                    }
                    if (j5 == -1) {
                        ByteWriteChannel channel2 = writerScope.getChannel();
                        FileChannelsKt$readChannel$1$3$1 fileChannelsKt$readChannel$1$3$1 = new FileChannelsKt$readChannel$1$3$1(writerScope, channel, null);
                        this.L$0 = randomAccessFile;
                        this.I$0 = 0;
                        this.label = 1;
                        if (channel2.writeSuspendSession(fileChannelsKt$readChannel$1$3$1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        final Ref.LongRef longRef = new Ref.LongRef();
                        longRef.element = j4;
                        ByteWriteChannel channel3 = writerScope.getChannel();
                        Function1<ByteBuffer, Boolean> function1 = new Function1<ByteBuffer, Boolean>() { // from class: io.ktor.util.cio.FileChannelsKt$readChannel$1$3$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(ByteBuffer buffer) throws IOException {
                                int i2;
                                Intrinsics.checkNotNullParameter(buffer, "buffer");
                                long j6 = (j5 - longRef.element) + 1;
                                if (j6 < buffer.remaining()) {
                                    int iLimit = buffer.limit();
                                    buffer.limit(buffer.position() + ((int) j6));
                                    i2 = channel.read(buffer);
                                    buffer.limit(iLimit);
                                } else {
                                    i2 = channel.read(buffer);
                                }
                                if (i2 > 0) {
                                    longRef.element += i2;
                                }
                                return Boolean.valueOf(i2 != -1 && longRef.element <= j5);
                            }
                        };
                        this.L$0 = randomAccessFile;
                        this.I$0 = 0;
                        this.label = 2;
                        if (channel3.writeWhile(function1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    closeable = randomAccessFile;
                } catch (Throwable th) {
                    th = th;
                    closeable = randomAccessFile;
                    closeable.close();
                    throw th;
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                closeable = (Closeable) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        closeable.close();
                    } catch (Throwable th3) {
                        CloseableJVMKt.addSuppressedInternal(th, th3);
                    }
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            closeable.close();
            return Unit.INSTANCE;
        }
    }

    public static final ByteReadChannel readChannel(File file, long j, long j2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return CoroutinesKt.writer(CoroutineScopeKt.CoroutineScope(coroutineContext), new CoroutineName("file-reader").plus(coroutineContext), false, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1(j, j2, file.length(), file, null)).getChannel();
    }

    /* compiled from: FileChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$writeChannel$1", f = "FileChannels.kt", i = {0, 0, 0}, l = {98}, m = "invokeSuspend", n = {"$this$use$iv", "file", "closed$iv"}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.util.cio.FileChannelsKt$writeChannel$1, reason: invalid class name and case insensitive filesystem */
    static final class C11721 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $this_writeChannel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11721(File file, Continuation<? super C11721> continuation) {
            super(2, continuation);
            this.$this_writeChannel = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11721 c11721 = new C11721(this.$this_writeChannel, continuation);
            c11721.L$0 = obj;
            return c11721;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
            return ((C11721) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
            RandomAccessFile randomAccessFile;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ReaderScope readerScope = (ReaderScope) this.L$0;
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.$this_writeChannel, "rw");
                    RandomAccessFile randomAccessFile3 = randomAccessFile2;
                    ByteReadChannel channel = readerScope.getChannel();
                    FileChannel channel2 = randomAccessFile3.getChannel();
                    Intrinsics.checkNotNullExpressionValue(channel2, "file.channel");
                    this.L$0 = randomAccessFile2;
                    this.L$1 = randomAccessFile3;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = WritingKt.copyTo$default(channel, channel2, 0L, this, 2, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    randomAccessFile = randomAccessFile3;
                    r1 = randomAccessFile2;
                } else {
                    if (r1 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    randomAccessFile = (RandomAccessFile) this.L$1;
                    Closeable closeable = (Closeable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = closeable;
                }
                randomAccessFile.setLength(((Number) obj).longValue());
                Unit unit = Unit.INSTANCE;
                r1.close();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    r1.close();
                } catch (Throwable th2) {
                    CloseableJVMKt.addSuppressedInternal(th, th2);
                }
                throw th;
            }
        }
    }

    public static /* synthetic */ ByteWriteChannel writeChannel$default(File file, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        return writeChannel(file, coroutineContext);
    }

    public static final ByteWriteChannel writeChannel(File file, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return CoroutinesKt.reader((CoroutineScope) GlobalScope.INSTANCE, new CoroutineName("file-writer").plus(coroutineContext), true, (Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object>) new C11721(file, null)).getChannel();
    }
}
