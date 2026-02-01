package io.ktor.utils.io;

import androidx.camera.video.AudioStats;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.sun.jna.platform.win32.WinError;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.AwaitingSlot;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.objectweb.asm.Opcodes;

/* compiled from: ByteChannelSequential.kt */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b&\u0018\u00002\u00030Ö\u00012\u00030×\u00012\u00030Ø\u00012\u00020{2\u00030Ù\u00012\u00030Ú\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\u0013\u0010\u0018\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u0003H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0084@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J\u001b\u0010.\u001a\u0002002\u0006\u00101\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u00102J#\u00104\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010,J\u0017\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\tH\u0016¢\u0006\u0004\b8\u0010\rJ\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010,J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010,J\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010,J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000bH\u0002¢\u0006\u0004\b?\u0010,JA\u0010G\u001a\u0002002\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u0002002\u0006\u0010C\u001a\u0002002\u0006\u0010D\u001a\u0002002\u0006\u00101\u001a\u000200H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020\u000bH\u0004¢\u0006\u0004\bH\u0010,J\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020IH\u0080@ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ+\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bM\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0004¢\u0006\u0004\bR\u0010SJ\u0013\u0010T\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\bT\u0010\u0019J\u0013\u0010U\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u0019J\u0013\u0010W\u001a\u00020VH\u0096@ø\u0001\u0000¢\u0006\u0004\bW\u0010\u0019J\u0013\u0010X\u001a\u00020VH\u0082@ø\u0001\u0000¢\u0006\u0004\bX\u0010\u0019J\u0013\u0010Z\u001a\u00020YH\u0096@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0019J\u0013\u0010[\u001a\u00020YH\u0082@ø\u0001\u0000¢\u0006\u0004\b[\u0010\u0019J\u0013\u0010]\u001a\u00020\\H\u0096@ø\u0001\u0000¢\u0006\u0004\b]\u0010\u0019J\u0013\u0010^\u001a\u00020\\H\u0082@ø\u0001\u0000¢\u0006\u0004\b^\u0010\u0019J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b_\u0010aJ+\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b_\u0010QJ#\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010`J+\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bb\u0010QJ\u0013\u0010c\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u0019J\u0013\u0010d\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bd\u0010\u0019J\u0013\u0010e\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\be\u0010\u0019J\u0013\u0010f\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\bf\u0010\u0019J\u001b\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0004\bi\u0010\u0013J#\u0010k\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010g\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001b\u0010n\u001a\u00020h2\u0006\u0010m\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0004\bn\u00102J#\u0010o\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010m\u001a\u000200H\u0082@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ(\u0010u\u001a\u00020\u000b2\u0017\u0010t\u001a\u0013\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u000b0q¢\u0006\u0002\bsH\u0017¢\u0006\u0004\bu\u0010vJ\u0013\u0010x\u001a\u00020wH\u0096@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0019J\u0013\u0010y\u001a\u00020wH\u0082@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0019J<\u0010~\u001a\u00020\u000b2'\u0010t\u001a#\b\u0001\u0012\u0004\u0012\u00020{\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH\u0097@ø\u0001\u0000¢\u0006\u0004\b~\u0010\u007fJ \u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010m\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0081\u0001\u0010\u0013J8\u0010\u0086\u0001\u001a\u00020\u0003\"\u000f\b\u0000\u0010\u0084\u0001*\b0\u0082\u0001j\u0003`\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00028\u00002\u0006\u0010m\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001c\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001c\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J\u0012\u0010\u008b\u0001\u001a\u00020{H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\"\u0010\u008f\u0001\u001a\u0002002\u0006\u0010J\u001a\u00020\u00002\u0006\u0010m\u001a\u000200H\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001e\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010NJ.\u0010\u0091\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010QJ\u001e\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010NJ.\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010QJ\u001f\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020VH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001f\u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0096\u0001\u001a\u00020YH\u0096@ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001f\u0010\u009a\u0001\u001a\u00020\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\\H\u0096@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J7\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u009c\u0001\u001a\u00020@2\u0007\u0010\u009d\u0001\u001a\u00020\t2\u0007\u0010\u009e\u0001\u001a\u00020\tH\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u001e\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020IH\u0096@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010LJ.\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0090\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010QJ\u001e\u0010£\u0001\u001a\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0005\b£\u0001\u0010\u0013J\u001e\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010¤\u0001\u001a\u000200H\u0096@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u00102J\u001f\u0010§\u0001\u001a\u00020\u000b2\u0007\u0010¦\u0001\u001a\u00020hH\u0096@ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001f\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010©\u0001\u001a\u00020wH\u0096@ø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J?\u0010\u00ad\u0001\u001a\u00020\u000b2(\u0010¬\u0001\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH\u0097@ø\u0001\u0000¢\u0006\u0005\b\u00ad\u0001\u0010\u007fR\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\u000e\n\u0005\b\u0004\u0010®\u0001\u001a\u0005\b¯\u0001\u0010>R\u0016\u0010±\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010SR\u0016\u0010³\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010SR)\u0010¸\u0001\u001a\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u00038D@DX\u0084\u000e¢\u0006\u000f\u001a\u0005\bµ\u0001\u0010>\"\u0006\b¶\u0001\u0010·\u0001R.\u0010½\u0001\u001a\u0004\u0018\u00010!2\t\u0010´\u0001\u001a\u0004\u0018\u00010!8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u0017\u0010¾\u0001\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010Á\u0001\u001a\u00070}j\u0003`À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0016\u0010Ã\u0001\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010>R\u0016\u0010Ä\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010>R\u0016\u0010Å\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010>R\u001f\u0010Æ\u0001\u001a\u00020h8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0017\u0010Ï\u0001\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ñ\u0001\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Î\u0001R\u001f\u0010Ò\u0001\u001a\u00020&8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\bÒ\u0001\u0010¿\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Õ\u0001"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "initial", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", SdkConstants.CONSTRUCTOR_NAME, "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ZLio/ktor/utils/io/pool/ObjectPool;)V", "", "count", "", "addBytesRead", "(I)V", "addBytesWritten", "afterRead", "afterWrite", "atLeast", "await", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastNBytesAvailableForRead$ktor_io", "awaitAtLeastNBytesAvailableForRead", "awaitAtLeastNBytesAvailableForWrite$ktor_io", "awaitAtLeastNBytesAvailableForWrite", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "awaitInternalAtLeast1$ktor_io", "awaitInternalAtLeast1", "awaitSuspend", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "remaining", "Lio/ktor/utils/io/core/BytePacketBuilder;", "closeable", "checkClosed", "(ILio/ktor/utils/io/core/BytePacketBuilder;)V", "close", "completeReading", "()V", "n", SdkConstants.ATTR_DISCARD, "(I)I", "", "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endReadSession", "written", "endWriteSession", "ensureNotClosed", "ensureNotFailed", "(Lio/ktor/utils/io/core/BytePacketBuilder;)V", "flush", "flushImpl", "()Z", "flushWrittenBytes", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "offset", HealthConstants.HeartRate.MIN, "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "prepareFlushedBytes", "Lio/ktor/utils/io/core/Buffer;", "dst", "readAvailable$ktor_io", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", SessionDescription.ATTR_LENGTH, "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailableClosed", "()I", "readBoolean", "readBooleanSlow", "", "readByte", "readByteSlow", "", "readDouble", "readDoubleSlow", "", "readFloat", "readFloatSlow", "readFully", "(Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "readInt", "readIntSlow", "readLong", "readLongSlow", ContentDisposition.Parameters.Size, "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "builder", "readPacketSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "limit", "readRemaining", "readRemainingSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/utils/io/ReadSession;", "Lkotlin/ExtensionFunctionType;", "consumer", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readShortSlow", "Lkotlin/Function2;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lkotlin/coroutines/Continuation;", "", "readSuspendableSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestNextView", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "transferTo$ktor_io", "(Lio/ktor/utils/io/ByteChannelSequentialBase;J)J", "transferTo", "src", "writeAvailable", "writeAvailableSuspend", "b", "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "i", "writeInt", "l", "writeLong", "packet", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visitor", "writeSuspendSession", "Z", "getAutoFlush", "getAvailableForRead", "availableForRead", "getAvailableForWrite", "availableForWrite", "<anonymous parameter 0>", "getClosed", "setClosed", "(Z)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "closedCause", "flushBuffer", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "flushMutex", "Ljava/lang/Object;", "isCancelled", "isClosedForRead", "isClosedForWrite", "readable", "Lio/ktor/utils/io/core/ByteReadPacket;", "getReadable", "()Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/internal/AwaitingSlot;", "slot", "Lio/ktor/utils/io/internal/AwaitingSlot;", "getTotalBytesRead", "()J", "totalBytesRead", "getTotalBytesWritten", "totalBytesWritten", "writable", "getWritable", "()Lio/ktor/utils/io/core/BytePacketBuilder;", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;
    private final boolean autoFlush;
    private volatile /* synthetic */ int channelSize;
    private final BytePacketBuilder flushBuffer;
    private final Object flushMutex;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;
    private final ByteReadPacket readable;
    private final AwaitingSlot slot;
    private final BytePacketBuilder writable;
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesRead$FU = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesRead");
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesWritten$FU = AtomicLongFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_totalBytesWritten");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "_availableForRead");
    private static final /* synthetic */ AtomicIntegerFieldUpdater channelSize$FU = AtomicIntegerFieldUpdater.newUpdater(ByteChannelSequentialBase.class, "channelSize");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU = AtomicReferenceFieldUpdater.newUpdater(ByteChannelSequentialBase.class, Object.class, "_closed");

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {799}, m = "awaitFreeSpace$suspendImpl", n = {"$this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.awaitFreeSpace$suspendImpl(ByteChannelSequentialBase.this, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {611}, m = "awaitSuspend", n = {"this", "atLeast"}, s = {"L$0", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12161 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12161(Continuation<? super C12161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.awaitSuspend(0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {WinError.ERROR_PNP_IRQ_TRANSLATION_FAILED}, m = "discardSuspend", n = {"this", "max", "discarded"}, s = {"L$0", "J$0", "J$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12181 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12181(Continuation<? super C12181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.discardSuspend(0L, 0L, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {486}, m = "readAvailable$ktor_io", n = {"this", "dst"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2, reason: invalid class name */
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readAvailable$ktor_io(null, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {530}, m = "readAvailable$suspendImpl", n = {"$this", "dst", "offset", SessionDescription.ATTR_LENGTH}, s = {"L$0", "L$1", "I$0", "I$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4, reason: invalid class name */
    static final class AnonymousClass4 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readAvailable$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {WinError.ERROR_NET_OPEN_FAILED, WinError.ERROR_CONTROL_C_EXIT}, m = "readBooleanSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12191(Continuation<? super C12191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readBooleanSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {313}, m = "readByteSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12201(Continuation<? super C12201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readByteSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {390}, m = "readDoubleSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12211(Continuation<? super C12211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readDoubleSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {377}, m = "readFloatSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12221 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12221(Continuation<? super C12221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFloatSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {WinError.ERROR_INVALID_UNWIND_TARGET, WinError.ERROR_DEVICE_ALREADY_ATTACHED}, m = "readFully$suspendImpl", n = {"$this", "dst", "offset", SessionDescription.ATTR_LENGTH}, s = {"L$0", "L$1", "I$0", "I$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFully$6, reason: invalid class name */
    static final class AnonymousClass6 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readFully$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {519, 520}, m = "readFullySuspend", n = {"this", "dst", "n"}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12231 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12231(Continuation<? super C12231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFullySuspend(null, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0, 0}, l = {WinError.ERROR_CANT_TERMINATE_SELF}, m = "readFullySuspend", n = {"this", "dst", "offset", SessionDescription.ATTR_LENGTH, "written"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2, reason: invalid class name and case insensitive filesystem */
    static final class C12242 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12242(Continuation<? super C12242> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readFullySuspend(null, 0, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {349}, m = "readIntSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12251 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12251(Continuation<? super C12251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readIntSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {364}, m = "readLongSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12261(Continuation<? super C12261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readLongSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {459}, m = "readPacketSuspend", n = {"this", "builder", "remaining"}, s = {"L$0", "L$1", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12271 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12271(Continuation<? super C12271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readPacketSuspend(null, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "readRemainingSuspend", n = {"this", "builder", "limit"}, s = {"L$0", "L$1", "J$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12281 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12281(Continuation<? super C12281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readRemainingSuspend(null, 0L, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {329}, m = "readShortSlow", n = {"this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C12291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12291(Continuation<? super C12291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.readShortSlow(this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {704}, m = "readSuspendableSession$suspendImpl", n = {"$this"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1, reason: invalid class name and case insensitive filesystem */
    static final class C12301 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12301(Continuation<? super C12301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readSuspendableSession$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0}, l = {WinError.ERROR_WAIT_1}, m = "readUTF8Line$suspendImpl", n = {"builder"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    static final class C12311 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12311(Continuation<? super C12311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.readUTF8Line$suspendImpl(ByteChannelSequentialBase.this, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {WinError.ERROR_REQUEST_OUT_OF_SEQUENCE, WinError.ERROR_VERSION_PARSE_ERROR}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C12331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12331(Continuation<? super C12331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.writeAvailableSuspend(null, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {WinError.ERROR_INSUFFICIENT_RESOURCE_FOR_SPECIFIED_SHARED_SECTION_SIZE, WinError.ERROR_SYSTEM_POWERSTATE_TRANSITION}, m = "writeAvailableSuspend", n = {"this", "src", "offset", SessionDescription.ATTR_LENGTH}, s = {"L$0", "L$1", "I$0", "I$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2, reason: invalid class name and case insensitive filesystem */
    static final class C12342 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12342(Continuation<? super C12342> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.this.writeAvailableSuspend(null, 0, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {150}, m = "writeByte$suspendImpl", n = {"$this", "b"}, s = {"L$0", "B$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1, reason: invalid class name and case insensitive filesystem */
    static final class C12351 extends ContinuationImpl {
        byte B$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12351(Continuation<? super C12351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeByte$suspendImpl(ByteChannelSequentialBase.this, (byte) 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {180}, m = "writeDouble$suspendImpl", n = {"$this", "d"}, s = {"L$0", "D$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1, reason: invalid class name and case insensitive filesystem */
    static final class C12361 extends ContinuationImpl {
        double D$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12361(Continuation<? super C12361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeDouble$suspendImpl(ByteChannelSequentialBase.this, AudioStats.AUDIO_AMPLITUDE_NONE, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {174}, m = "writeFloat$suspendImpl", n = {"$this", "f"}, s = {"L$0", "F$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1, reason: invalid class name and case insensitive filesystem */
    static final class C12371 extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12371(Continuation<? super C12371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFloat$suspendImpl(ByteChannelSequentialBase.this, 0.0f, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {193}, m = "writeFully$suspendImpl", n = {"$this", "src"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1, reason: invalid class name and case insensitive filesystem */
    static final class C12381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12381(Continuation<? super C12381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFully$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {204}, m = "writeFully$suspendImpl", n = {"$this", "src", "currentIndex", "endIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2, reason: invalid class name and case insensitive filesystem */
    static final class C12392 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12392(Continuation<? super C12392> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeFully$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0, 0, 0}, l = {WinError.ERROR_EXE_CANNOT_MODIFY_STRONG_SIGNED_BINARY}, m = "writeFully-JT6ljtQ$suspendImpl", n = {"$this", "memory", "endIndex", "currentIndex"}, s = {"L$0", "L$1", "I$0", "I$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3, reason: invalid class name and case insensitive filesystem */
    static final class C12403 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12403(Continuation<? super C12403> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.m8803writeFullyJT6ljtQ$suspendImpl(ByteChannelSequentialBase.this, null, 0, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {162}, m = "writeInt$suspendImpl", n = {"$this", "i"}, s = {"L$0", "I$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1, reason: invalid class name and case insensitive filesystem */
    static final class C12411 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12411(Continuation<? super C12411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeInt$suspendImpl(ByteChannelSequentialBase.this, 0, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {Opcodes.JSR}, m = "writeLong$suspendImpl", n = {"$this", "l"}, s = {"L$0", "J$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1, reason: invalid class name and case insensitive filesystem */
    static final class C12421 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12421(Continuation<? super C12421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeLong$suspendImpl(ByteChannelSequentialBase.this, 0L, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {186}, m = "writePacket$suspendImpl", n = {"$this", "packet"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1, reason: invalid class name and case insensitive filesystem */
    static final class C12431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12431(Continuation<? super C12431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writePacket$suspendImpl(ByteChannelSequentialBase.this, null, this);
        }
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", i = {0, 0}, l = {156}, m = "writeShort$suspendImpl", n = {"$this", "s"}, s = {"L$0", "S$0"})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1, reason: invalid class name and case insensitive filesystem */
    static final class C12441 extends ContinuationImpl {
        Object L$0;
        short S$0;
        int label;
        /* synthetic */ Object result;

        C12441(Continuation<? super C12441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteChannelSequentialBase.writeShort$suspendImpl(ByteChannelSequentialBase.this, (short) 0, this);
        }
    }

    @Override // io.ktor.utils.io.SuspendableReadSession
    public Object await(int i, Continuation<? super Boolean> continuation) {
        return await$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(Continuation<? super Unit> continuation) {
        return awaitContent$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object awaitFreeSpace(Continuation<? super Unit> continuation) {
        return awaitFreeSpace$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object discard(long j, Continuation<? super Long> continuation) {
        return discard$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readBoolean(Continuation<? super Boolean> continuation) {
        return readBoolean$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readByte(Continuation<? super Byte> continuation) {
        return readByte$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readDouble(Continuation<? super Double> continuation) {
        return readDouble$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFloat(Continuation<? super Float> continuation) {
        return readFloat$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, chunkBuffer, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readInt(Continuation<? super Integer> continuation) {
        return readInt$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readLong(Continuation<? super Long> continuation) {
        return readLong$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readPacket(int i, Continuation<? super ByteReadPacket> continuation) {
        return readPacket$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        return readRemaining$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readShort(Continuation<? super Short> continuation) {
        return readShort$suspendImpl(this, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public <A extends Appendable> Object readUTF8LineTo(A a, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineTo$suspendImpl(this, a, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, chunkBuffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeByte(byte b, Continuation<? super Unit> continuation) {
        return writeByte$suspendImpl(this, b, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeDouble(double d, Continuation<? super Unit> continuation) {
        return writeDouble$suspendImpl(this, d, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFloat(float f, Continuation<? super Unit> continuation) {
        return writeFloat$suspendImpl(this, f, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(Buffer buffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, buffer, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* renamed from: writeFully-JT6ljtQ */
    public Object mo8802writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m8803writeFullyJT6ljtQ$suspendImpl(this, byteBuffer, i, i2, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeInt(int i, Continuation<? super Unit> continuation) {
        return writeInt$suspendImpl(this, i, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeLong(long j, Continuation<? super Unit> continuation) {
        return writeLong$suspendImpl(this, j, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return writePacket$suspendImpl(this, byteReadPacket, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public Object writeShort(short s, Continuation<? super Unit> continuation) {
        return writeShort$suspendImpl(this, s, continuation);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    @Deprecated(message = "Use write { } instead.")
    public Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return writeSuspendSession$suspendImpl(this, function2, continuation);
    }

    public ByteChannelSequentialBase(ChunkBuffer initial, boolean z, ObjectPool<ChunkBuffer> pool) throws Throwable {
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.autoFlush = z;
        this._lastReadView = ChunkBuffer.INSTANCE.getEmpty();
        this._totalBytesRead = 0L;
        this._totalBytesWritten = 0L;
        this._availableForRead = 0;
        this.channelSize = 0;
        this._closed = null;
        this.writable = new BytePacketBuilder(pool);
        this.readable = new ByteReadPacket(initial, pool);
        this.lastReadAvailable$delegate = 0;
        this.lastReadView$delegate = ChunkBuffer.INSTANCE.getEmpty();
        this.slot = new AwaitingSlot();
        this.flushMutex = new Object();
        this.flushBuffer = new BytePacketBuilder(null, 1, null);
        int iRemainingAll = (int) BuffersKt.remainingAll(initial);
        afterWrite(iRemainingAll);
        _availableForRead$FU.addAndGet(this, iRemainingAll);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public /* synthetic */ ByteChannelSequentialBase(ChunkBuffer chunkBuffer, boolean z, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkBuffer, z, (i & 4) != 0 ? ChunkBuffer.INSTANCE.getPool() : objectPool);
    }

    private final boolean isCancelled() {
        CloseElement closeElement = (CloseElement) this._closed;
        return (closeElement != null ? closeElement.getCause() : null) != null;
    }

    protected final boolean getClosed() {
        return this._closed != null;
    }

    protected final void setClosed(boolean z) {
        throw new IllegalStateException("Setting is not allowed for closed".toString());
    }

    protected final BytePacketBuilder getWritable() {
        return this.writable;
    }

    protected final ByteReadPacket getReadable() {
        return this.readable;
    }

    /* renamed from: getLastReadAvailable, reason: from getter */
    private final int getLastReadAvailable$delegate() {
        return this.lastReadAvailable$delegate;
    }

    private final void setLastReadAvailable(int i) {
        this.lastReadAvailable$delegate = i;
    }

    private final ChunkBuffer getLastReadView() {
        return (ChunkBuffer) this.lastReadView$delegate;
    }

    private final void setLastReadView(ChunkBuffer chunkBuffer) {
        this.lastReadView$delegate = chunkBuffer;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getAvailableForRead, reason: from getter */
    public int get_availableForRead() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public int getAvailableForWrite() {
        return Math.max(0, 4088 - this.channelSize);
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return isCancelled() || (getClosed() && this.channelSize == 0);
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public boolean isClosedForWrite() {
        return getClosed();
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: getTotalBytesRead, reason: from getter */
    public long get_totalBytesRead() {
        return this._totalBytesRead;
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    /* renamed from: getTotalBytesWritten, reason: from getter */
    public long get_totalBytesWritten() {
        return this._totalBytesWritten;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public final Throwable getClosedCause() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.getCause();
        }
        return null;
    }

    public final void setClosedCause(Throwable th) {
        throw new IllegalStateException("Closed cause shouldn't be changed directly".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitAtLeastNBytesAvailableForWrite$ktor_io(final int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3c
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r5
        L3c:
            int r7 = r2.getAvailableForWrite()
            if (r7 >= r6) goto L64
            boolean r7 = r2.getClosed()
            if (r7 != 0) goto L64
            boolean r7 = r2.flushImpl()
            if (r7 != 0) goto L3c
            io.ktor.utils.io.internal.AwaitingSlot r7 = r2.slot
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2
            r4.<init>()
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.sleep(r4, r0)
            if (r7 != r1) goto L3c
            return r1
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitAtLeastNBytesAvailableForRead$ktor_io(final int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3c
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r5
        L3c:
            int r7 = r2.get_availableForRead()
            if (r7 >= r6) goto L5e
            boolean r7 = r2.isClosedForRead()
            if (r7 != 0) goto L5e
            io.ktor.utils.io.internal.AwaitingSlot r7 = r2.slot
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
            r4.<init>()
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.sleep(r4, r0)
            if (r7 != r1) goto L3c
            return r1
        L5e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForRead$ktor_io(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public void flush() {
        flushImpl();
    }

    private final boolean flushImpl() {
        if (this.writable.isEmpty()) {
            this.slot.resume();
            return false;
        }
        flushWrittenBytes();
        this.slot.resume();
        return true;
    }

    private final void flushWrittenBytes() {
        synchronized (this.flushMutex) {
            int size = this.writable.getSize();
            ChunkBuffer chunkBufferStealAll$ktor_io = this.writable.stealAll$ktor_io();
            Intrinsics.checkNotNull(chunkBufferStealAll$ktor_io);
            this.flushBuffer.writeChunkBuffer$ktor_io(chunkBufferStealAll$ktor_io);
            _availableForRead$FU.addAndGet(this, size);
        }
    }

    protected final void prepareFlushedBytes() {
        synchronized (this.flushMutex) {
            UnsafeKt.unsafeAppend(this.readable, this.flushBuffer);
        }
    }

    private final void ensureNotClosed() throws Throwable {
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            throw new ClosedWriteChannelException("Channel " + this + " is already closed");
        }
    }

    private final void ensureNotFailed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final void ensureNotFailed(BytePacketBuilder closeable) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return;
        }
        closeable.release();
        throw closedCause;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeByte$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, byte r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12351
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            byte r5 = r0.B$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.B$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            io.ktor.utils.io.core.BytePacketBuilder r6 = r4.writable
            byte r5 = (byte) r5
            r6.writeByte(r5)
            r4.afterWrite(r3)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeByte$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeShort$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, short r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12441
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            short r6 = r0.S$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.S$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.writable
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            short r6 = (short) r6
            io.ktor.utils.io.core.OutputPrimitivesKt.writeShort(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeShort$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeInt$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12411
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.writable
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            io.ktor.utils.io.core.OutputPrimitivesKt.writeInt(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeInt$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeLong$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, long r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12421
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            long r6 = r0.J$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4a
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.writable
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.io.core.Output) r8
            io.ktor.utils.io.core.OutputPrimitivesKt.writeLong(r8, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeLong$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFloat$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, float r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12371
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            float r6 = r0.F$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.F$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.writable
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            io.ktor.utils.io.core.OutputPrimitivesKt.writeFloat(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFloat$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeDouble$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, double r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12361
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            double r6 = r0.D$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4a
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.D$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.writable
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.io.core.Output) r8
            io.ktor.utils.io.core.OutputPrimitivesKt.writeDouble(r8, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeDouble$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12431
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            long r0 = r5.getRemaining()
            int r6 = (int) r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.writable
            r0.writePacket(r5)
            r4.afterWrite(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12381
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            int r6 = r5.getWritePosition()
            int r0 = r5.getReadPosition()
            int r6 = r6 - r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.writable
            io.ktor.utils.io.core.Output r0 = (io.ktor.utils.io.core.Output) r0
            r1 = 2
            r2 = 0
            r3 = 0
            io.ktor.utils.io.core.OutputKt.writeFully$default(r0, r5, r3, r1, r2)
            r4.afterWrite(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005a -> B:19:0x005d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12392
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12392) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L5d
        L39:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L41:
            kotlin.ResultKt.throwOnFailure(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L4a:
            if (r8 >= r5) goto L73
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r9 = r6.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L5d
            return r1
        L5d:
            int r9 = r6.getAvailableForWrite()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r6.writable
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputKt.writeFully(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.afterWrite(r9)
            goto L4a
        L73:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0056 -> B:19:0x0059). Please report as a decompilation issue!!! */
    /* renamed from: writeFully-JT6ljtQ$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object m8803writeFullyJT6ljtQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, java.nio.ByteBuffer r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12403
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12403) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r4
            goto L59
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            kotlin.ResultKt.throwOnFailure(r9)
        L46:
            if (r7 >= r8) goto L6f
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            int r9 = r5.getAvailableForWrite()
            int r2 = r8 - r7
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r5.writable
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputKt.m9028writeFullyUAd2zVI(r2, r6, r7, r9)
            int r7 = r7 + r9
            r5.afterWrite(r9)
            goto L46
        L6f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.m8803writeFullyJT6ljtQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, java.nio.ByteBuffer, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) throws Throwable {
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        int writePosition = chunkBuffer2.getWritePosition() - chunkBuffer2.getReadPosition();
        if (writePosition == 0) {
            return Boxing.boxInt(0);
        }
        int iMin = Math.min(writePosition, byteChannelSequentialBase.getAvailableForWrite());
        if (iMin == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(chunkBuffer, continuation);
        }
        OutputKt.writeFully(byteChannelSequentialBase.writable, chunkBuffer2, iMin);
        byteChannelSequentialBase.afterWrite(iMin);
        return Boxing.boxInt(iMin);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) throws Throwable {
        if (i2 == 0) {
            return Boxing.boxInt(0);
        }
        int iMin = Math.min(i2, byteChannelSequentialBase.getAvailableForWrite());
        if (iMin == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(bArr, i, i2, continuation);
        }
        OutputKt.writeFully((Output) byteChannelSequentialBase.writable, bArr, i, iMin);
        byteChannelSequentialBase.afterWrite(iMin);
        return Boxing.boxInt(iMin);
    }

    @Deprecated(message = "Use write { } instead.")
    static /* synthetic */ Object writeSuspendSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objInvoke = function2.invoke(byteChannelSequentialBase.beginWriteSession(), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public WriterSuspendSession beginWriteSession() {
        return new WriterSuspendSession() { // from class: io.ktor.utils.io.ByteChannelSequentialBase.beginWriteSession.1
            @Override // io.ktor.utils.io.WriterSession
            public ChunkBuffer request(int min) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() == 0) {
                    return null;
                }
                return ByteChannelSequentialBase.this.getWritable().prepareWriteHead(min);
            }

            @Override // io.ktor.utils.io.WriterSession
            public void written(int n) throws Throwable {
                ByteChannelSequentialBase.this.getWritable().afterHeadWrite();
                ByteChannelSequentialBase.this.afterWrite(n);
            }

            @Override // io.ktor.utils.io.WriterSession
            public void flush() {
                ByteChannelSequentialBase.this.flush();
            }

            @Override // io.ktor.utils.io.WriterSuspendSession
            public Object tryAwait(int i, Continuation<? super Unit> continuation) {
                if (ByteChannelSequentialBase.this.getAvailableForWrite() < i) {
                    Object objAwaitAtLeastNBytesAvailableForWrite$ktor_io = ByteChannelSequentialBase.this.awaitAtLeastNBytesAvailableForWrite$ktor_io(i, continuation);
                    return objAwaitAtLeastNBytesAvailableForWrite$ktor_io == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitAtLeastNBytesAvailableForWrite$ktor_io : Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // io.ktor.utils.io.HasWriteSession
    public void endWriteSession(int written) throws Throwable {
        this.writable.afterHeadWrite();
        afterWrite(written);
    }

    static /* synthetic */ Object readByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Byte> continuation) {
        if (!byteChannelSequentialBase.readable.getEndOfInput()) {
            byte b = byteChannelSequentialBase.readable.readByte();
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxByte(b);
        }
        return byteChannelSequentialBase.readByteSlow(continuation);
    }

    static /* synthetic */ void checkClosed$default(ByteChannelSequentialBase byteChannelSequentialBase, int i, BytePacketBuilder bytePacketBuilder, int i2, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
        }
        if ((i2 & 2) != 0) {
            bytePacketBuilder = null;
        }
        byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
    }

    private final void checkClosed(int remaining, BytePacketBuilder closeable) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            if (closeable != null) {
                closeable.close();
                throw closedCause;
            }
            throw closedCause;
        }
        if (!getClosed() || get_availableForRead() >= remaining) {
            return;
        }
        if (closeable != null) {
            closeable.close();
        }
        throw new EOFException(remaining + " bytes required but EOF reached");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:18:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readByteSlow(kotlin.coroutines.Continuation<? super java.lang.Byte> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12201
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
        L3a:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r2.awaitSuspend(r3, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.readable
            boolean r6 = r6.getEndOfInput()
            if (r6 != 0) goto L61
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.readable
            byte r6 = r6.readByte()
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)
            r0 = r6
            java.lang.Number r0 = (java.lang.Number) r0
            r0.byteValue()
            r2.afterRead(r3)
            return r6
        L61:
            r6 = 2
            r4 = 0
            checkClosed$default(r2, r3, r4, r6, r4)
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readByteSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Short> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(2)) {
            short s = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(2);
            return Boxing.boxShort(s);
        }
        return byteChannelSequentialBase.readShortSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readShortSlow(kotlin.coroutines.Continuation<? super java.lang.Short> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12291
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r0 = r5
        L46:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            short r6 = io.ktor.utils.io.core.InputPrimitivesKt.readShort(r6)
            r0.afterRead(r3)
            short r6 = (short) r6
            java.lang.Short r6 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readShortSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected final void afterRead(int count) {
        addBytesRead(count);
        this.slot.resume();
    }

    static /* synthetic */ Object readInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Integer> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(4)) {
            int i = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxInt(i);
        }
        return byteChannelSequentialBase.readIntSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readIntSlow(kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12251
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r0 = r5
        L46:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            int r6 = io.ktor.utils.io.core.InputPrimitivesKt.readInt(r6)
            r0.afterRead(r3)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readIntSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Long> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(8)) {
            long j = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxLong(j);
        }
        return byteChannelSequentialBase.readLongSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readLongSlow(kotlin.coroutines.Continuation<? super java.lang.Long> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12261
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            r0 = r5
        L47:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            long r1 = io.ktor.utils.io.core.InputPrimitivesKt.readLong(r6)
            r0.afterRead(r3)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readLongSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Float> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(4)) {
            float f = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(4);
            return Boxing.boxFloat(f);
        }
        return byteChannelSequentialBase.readFloatSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFloatSlow(kotlin.coroutines.Continuation<? super java.lang.Float> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12221
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r0 = r5
        L46:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            float r6 = io.ktor.utils.io.core.InputPrimitivesKt.readFloat(r6)
            r0.afterRead(r3)
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFloatSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Double> continuation) {
        if (byteChannelSequentialBase.readable.hasBytes(8)) {
            double d = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
            byteChannelSequentialBase.afterRead(8);
            return Boxing.boxDouble(d);
        }
        return byteChannelSequentialBase.readDoubleSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDoubleSlow(kotlin.coroutines.Continuation<? super java.lang.Double> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12211
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            r0 = r5
        L47:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            double r1 = io.ktor.utils.io.core.InputPrimitivesKt.readDouble(r6)
            r0.afterRead(r3)
            java.lang.Double r6 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readDoubleSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super ByteReadPacket> continuation) throws Throwable {
        byteChannelSequentialBase.ensureNotFailed();
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        long jMin = Math.min(j, byteChannelSequentialBase.readable.getRemaining());
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, jMin);
        byteChannelSequentialBase.afterRead((int) jMin);
        if (j - bytePacketBuilder.getSize() == 0 || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
            return bytePacketBuilder.build();
        }
        return byteChannelSequentialBase.readRemainingSuspend(bytePacketBuilder, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readRemainingSuspend(io.ktor.utils.io.core.BytePacketBuilder r11, long r12, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12281
            if (r0 == 0) goto L14
            r0 = r14
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r13 = (io.ktor.utils.io.core.BytePacketBuilder) r13
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r8 = r11
            r11 = r13
            r12 = r8
            goto L43
        L37:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3f:
            kotlin.ResultKt.throwOnFailure(r14)
            r2 = r10
        L43:
            int r14 = r11.getSize()
            long r4 = (long) r14
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L86
            int r14 = r11.getSize()
            long r4 = (long) r14
            long r4 = r12 - r4
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.readable
            long r6 = r14.getRemaining()
            long r4 = java.lang.Math.min(r4, r6)
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.readable
            r11.writePacket(r14, r4)
            int r14 = (int) r4
            r2.afterRead(r14)
            r2.ensureNotFailed(r11)
            boolean r14 = r2.isClosedForRead()
            if (r14 != 0) goto L86
            int r14 = r11.getSize()
            int r4 = (int) r12
            if (r14 != r4) goto L77
            goto L86
        L77:
            r0.L$0 = r2
            r0.L$1 = r11
            r0.J$0 = r12
            r0.label = r3
            java.lang.Object r14 = r2.awaitSuspend(r3, r0)
            if (r14 != r1) goto L43
            return r1
        L86:
            r2.ensureNotFailed(r11)
            io.ktor.utils.io.core.ByteReadPacket r11 = r11.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readRemainingSuspend(io.ktor.utils.io.core.BytePacketBuilder, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super ByteReadPacket> continuation) throws Throwable {
        checkClosed$default(byteChannelSequentialBase, i, null, 2, null);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, null);
        int iMin = (int) Math.min(i, byteChannelSequentialBase.readable.getRemaining());
        int i2 = i - iMin;
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, iMin);
        byteChannelSequentialBase.afterRead(iMin);
        byteChannelSequentialBase.checkClosed(i2, bytePacketBuilder);
        if (i2 > 0) {
            return byteChannelSequentialBase.readPacketSuspend(bytePacketBuilder, i2, continuation);
        }
        return bytePacketBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readPacketSuspend(io.ktor.utils.io.core.BytePacketBuilder r10, int r11, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12271
            if (r0 == 0) goto L14
            r0 = r12
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r11 = (io.ktor.utils.io.core.BytePacketBuilder) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L43
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r9
        L43:
            if (r11 <= 0) goto L6e
            long r4 = (long) r11
            io.ktor.utils.io.core.ByteReadPacket r12 = r2.readable
            long r6 = r12.getRemaining()
            long r4 = java.lang.Math.min(r4, r6)
            int r12 = (int) r4
            int r11 = r11 - r12
            io.ktor.utils.io.core.ByteReadPacket r4 = r2.readable
            r10.writePacket(r4, r12)
            r2.afterRead(r12)
            r2.checkClosed(r11, r10)
            if (r11 <= 0) goto L43
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r12 = r2.awaitSuspend(r3, r0)
            if (r12 != r1) goto L43
            return r1
        L6e:
            r2.checkClosed(r11, r10)
            io.ktor.utils.io.core.ByteReadPacket r10 = r10.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readPacketSuspend(io.ktor.utils.io.core.BytePacketBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected final int readAvailableClosed() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (get_availableForRead() <= 0) {
            return -1;
        }
        prepareFlushedBytes();
        return -1;
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        return byteChannelSequentialBase.readAvailable$ktor_io(chunkBuffer, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAvailable$ktor_io(io.ktor.utils.io.core.Buffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Throwable r7 = r5.getClosedCause()
            if (r7 != 0) goto La9
            boolean r7 = r5.getClosed()
            if (r7 == 0) goto L55
            int r7 = r5.get_availableForRead()
            if (r7 != 0) goto L55
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L55:
            int r7 = r6.getLimit()
            int r2 = r6.getWritePosition()
            int r7 = r7 - r2
            if (r7 != 0) goto L66
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L66:
            int r7 = r5.get_availableForRead()
            if (r7 != 0) goto L79
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.awaitSuspend(r3, r0)
            if (r7 != r1) goto L79
            return r1
        L79:
            r0 = r5
        L7a:
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.readable
            boolean r7 = r7.canRead()
            if (r7 != 0) goto L85
            r0.prepareFlushedBytes()
        L85:
            int r7 = r6.getLimit()
            int r1 = r6.getWritePosition()
            int r7 = r7 - r1
            long r1 = (long) r7
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.readable
            long r3 = r7.getRemaining()
            long r1 = java.lang.Math.min(r1, r3)
            int r7 = (int) r1
            io.ktor.utils.io.core.ByteReadPacket r1 = r0.readable
            io.ktor.utils.io.core.Input r1 = (io.ktor.utils.io.core.Input) r1
            io.ktor.utils.io.core.InputArraysKt.readFully(r1, r6, r7)
            r0.afterRead(r7)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r6
        La9:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readAvailable$ktor_io(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) throws Throwable {
        Intrinsics.checkNotNull(chunkBuffer, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        Object fully = byteChannelSequentialBase.readFully((Buffer) chunkBuffer, i, continuation);
        return fully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fully : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(io.ktor.utils.io.core.Buffer r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12231
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L64
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L56
        L43:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitSuspend(r7, r0)
            if (r8 != r1) goto L55
            return r1
        L55:
            r2 = r5
        L56:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = r2.readFully(r6, r7, r0)
            if (r6 != r1) goto L64
            return r1
        L64:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFullySuspend(io.ktor.utils.io.core.Buffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r6, byte[] r7, int r8, int r9, kotlin.coroutines.Continuation<? super java.lang.Integer> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass4
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r9 = (io.ktor.utils.io.ByteChannelSequentialBase) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L7e
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Throwable r10 = r6.getClosedCause()
            if (r10 != 0) goto La4
            boolean r10 = r6.getClosed()
            if (r10 == 0) goto L5f
            int r10 = r6.get_availableForRead()
            if (r10 != 0) goto L5f
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L5f:
            if (r9 != 0) goto L67
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L67:
            int r10 = r6.get_availableForRead()
            if (r10 != 0) goto L7e
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r10 = r6.awaitSuspend(r3, r0)
            if (r10 != r1) goto L7e
            return r1
        L7e:
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.readable
            boolean r10 = r10.canRead()
            if (r10 != 0) goto L89
            r6.prepareFlushedBytes()
        L89:
            long r9 = (long) r9
            io.ktor.utils.io.core.ByteReadPacket r0 = r6.readable
            long r0 = r0.getRemaining()
            long r9 = java.lang.Math.min(r9, r0)
            int r9 = (int) r9
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.readable
            io.ktor.utils.io.core.Input r10 = (io.ktor.utils.io.core.Input) r10
            io.ktor.utils.io.core.InputArraysKt.readFully(r10, r7, r8, r9)
            r6.afterRead(r9)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r6
        La4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.io.EOFException {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass6
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass6) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L78
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L46:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.readAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != r8) goto L65
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L65:
            r2 = -1
            if (r9 == r2) goto L7b
            int r7 = r7 + r9
            int r8 = r8 - r9
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r5 = r5.readFullySuspend(r6, r7, r8, r0)
            if (r5 != r1) goto L78
            return r1
        L78:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L7b:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.String r6 = "Unexpected end of stream"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0067 -> B:12:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFullySuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.io.EOFException {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12242
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12242) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r0
            r0 = r9
            r9 = r2
        L3a:
            r2 = r6
            goto L6b
        L3c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r4 = r7
            r6 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r6
        L4e:
            if (r8 >= r11) goto L80
            int r2 = r10 + r8
            int r5 = r11 - r8
            r0.L$0 = r4
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r8
            r0.label = r3
            java.lang.Object r2 = r4.readAvailable(r9, r2, r5, r0)
            if (r2 != r1) goto L67
            return r1
        L67:
            r6 = r0
            r0 = r11
            r11 = r2
            goto L3a
        L6b:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r5 = -1
            if (r11 == r5) goto L78
            int r8 = r8 + r11
            r11 = r0
            r0 = r2
            goto L4e
        L78:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r9 = "Unexpected end of stream"
            r8.<init>(r9)
            throw r8
        L80:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readBoolean$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Boolean> continuation) {
        if (byteChannelSequentialBase.readable.canRead()) {
            boolean z = byteChannelSequentialBase.readable.readByte() == 1;
            byteChannelSequentialBase.afterRead(1);
            return Boxing.boxBoolean(z);
        }
        return byteChannelSequentialBase.readBooleanSlow(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readBooleanSlow(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12191
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12191) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5b
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L3d:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r4, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            r2 = r5
        L4c:
            r6 = 0
            checkClosed$default(r2, r4, r6, r3, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.readBoolean(r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readBooleanSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void completeReading() {
        ChunkBuffer lastReadView = getLastReadView();
        int lastReadAvailable$delegate = getLastReadAvailable$delegate() - (lastReadView.getWritePosition() - lastReadView.getReadPosition());
        if (getLastReadView() != Buffer.INSTANCE.getEmpty()) {
            UnsafeKt.completeReadHead(this.readable, getLastReadView());
        }
        if (lastReadAvailable$delegate > 0) {
            afterRead(lastReadAvailable$delegate);
        }
        setLastReadAvailable(0);
        setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
    }

    static /* synthetic */ Object await$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation<? super Boolean> continuation) {
        if (i < 0) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i).toString());
        }
        long j = i;
        if (j > 4088) {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i).toString());
        }
        byteChannelSequentialBase.completeReading();
        if (i == 0) {
            return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead());
        }
        return byteChannelSequentialBase.readable.getRemaining() >= j ? Boxing.boxBoolean(true) : byteChannelSequentialBase.awaitSuspend(i, continuation);
    }

    public final Object awaitInternalAtLeast1$ktor_io(Continuation<? super Boolean> continuation) {
        if (this.readable.getEndOfInput()) {
            return awaitSuspend(1, continuation);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object awaitSuspend(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12161
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            int r5 = r0.I$0
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 < 0) goto L68
            r0.L$0 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForRead$ktor_io(r5, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r0 = r4
        L4b:
            r0.prepareFlushedBytes()
            java.lang.Throwable r6 = r0.getClosedCause()
            if (r6 != 0) goto L67
            boolean r6 = r0.isClosedForRead()
            if (r6 != 0) goto L61
            int r6 = r0.get_availableForRead()
            if (r6 < r5) goto L61
            goto L62
        L61:
            r3 = 0
        L62:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L67:
            throw r6
        L68:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Failed requirement."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ReadSession
    public int discard(int n) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        if (n == 0) {
            return 0;
        }
        int iDiscard = this.readable.discard(n);
        afterRead(n);
        requestNextView(1);
        return iDiscard;
    }

    @Override // io.ktor.utils.io.ReadSession
    public ChunkBuffer request(int atLeast) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
        completeReading();
        return requestNextView(atLeast);
    }

    private final ChunkBuffer requestNextView(int atLeast) {
        if (this.readable.getEndOfInput()) {
            prepareFlushedBytes();
        }
        ChunkBuffer chunkBufferPrepareReadHead$ktor_io = this.readable.prepareReadHead$ktor_io(atLeast);
        if (chunkBufferPrepareReadHead$ktor_io == null) {
            setLastReadView(ChunkBuffer.INSTANCE.getEmpty());
            setLastReadAvailable(0);
        } else {
            setLastReadView(chunkBufferPrepareReadHead$ktor_io);
            ChunkBuffer chunkBuffer = chunkBufferPrepareReadHead$ktor_io;
            setLastReadAvailable(chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition());
        }
        return chunkBufferPrepareReadHead$ktor_io;
    }

    static /* synthetic */ Object discard$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation<? super Long> continuation) throws Throwable {
        long jDiscard = byteChannelSequentialBase.readable.discard(j);
        byteChannelSequentialBase.afterRead((int) jDiscard);
        if (jDiscard == j || byteChannelSequentialBase.isClosedForRead()) {
            byteChannelSequentialBase.ensureNotFailed();
            return Boxing.boxLong(jDiscard);
        }
        return byteChannelSequentialBase.discardSuspend(j, jDiscard, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        if (r2.isClosedForRead() == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004d -> B:18:0x0050). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object discardSuspend(long r9, long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12181
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12181) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            long r9 = r0.J$1
            long r11 = r0.J$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r9
            r9 = r11
            r11 = r6
            goto L50
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            r2 = r8
        L41:
            r0.L$0 = r2
            r0.J$0 = r9
            r0.J$1 = r11
            r0.label = r3
            java.lang.Object r13 = r2.await(r3, r0)
            if (r13 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L6f
            io.ktor.utils.io.core.ByteReadPacket r13 = r2.readable
            long r4 = r9 - r11
            long r4 = r13.discard(r4)
            int r13 = (int) r4
            r2.afterRead(r13)
            long r11 = r11 + r4
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 >= 0) goto L6f
            boolean r13 = r2.isClosedForRead()
            if (r13 == 0) goto L41
        L6f:
            r2.ensureNotFailed()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    @Deprecated(message = "Use read instead.")
    public void readSession(Function1<? super ReadSession, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        try {
            consumer.invoke(this);
        } finally {
            completeReading();
        }
    }

    @Override // io.ktor.utils.io.HasReadSession
    public SuspendableReadSession startReadSession() {
        return this;
    }

    @Override // io.ktor.utils.io.HasReadSession
    public void endReadSession() {
        completeReading();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.utils.io.ByteChannelSequentialBase, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.ktor.utils.io.ByteChannelSequentialBase] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, kotlin.Unit] */
    @kotlin.Deprecated(message = "Use read instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readSuspendableSession$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.jvm.functions.Function2<? super io.ktor.utils.io.SuspendableReadSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12301
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12301) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L4a
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4a
            r0.label = r3     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch: java.lang.Throwable -> L4a
            if (r5 != r1) goto L44
            return r1
        L44:
            r4.completeReading()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4a:
            r5 = move-exception
            r4.completeReading()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readSuspendableSession$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ <A extends Appendable> Object readUTF8LineTo$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, A a, int i, Continuation<? super Boolean> continuation) throws Throwable {
        if (byteChannelSequentialBase.isClosedForRead()) {
            Throwable closedCause = byteChannelSequentialBase.getClosedCause();
            if (closedCause != null) {
                throw closedCause;
            }
            return Boxing.boxBoolean(false);
        }
        return UTF8Kt.decodeUTF8LineLoopSuspend(a, i, byteChannelSequentialBase.new C12322(null), new Function1<Integer, Unit>() { // from class: io.ktor.utils.io.ByteChannelSequentialBase.readUTF8LineTo.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                ByteChannelSequentialBase.this.afterRead(i2);
            }
        }, continuation);
    }

    /* compiled from: ByteChannelSequential.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ContentDisposition.Parameters.Size, ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2", f = "ByteChannelSequential.kt", i = {}, l = {WinError.ERROR_NO_YIELD_PERFORMED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2, reason: invalid class name and case insensitive filesystem */
    static final class C12322 extends SuspendLambda implements Function2<Integer, Continuation<? super Input>, Object> {
        /* synthetic */ int I$0;
        int label;

        C12322(Continuation<? super C12322> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12322 c12322 = ByteChannelSequentialBase.this.new C12322(continuation);
            c12322.I$0 = ((Number) obj).intValue();
            return c12322;
        }

        public final Object invoke(int i, Continuation<? super Input> continuation) {
            return ((C12322) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Input> continuation) {
            return invoke(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = this.I$0;
                this.label = 1;
                obj = ByteChannelSequentialBase.this.await(i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return ByteChannelSequentialBase.this.getReadable();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object readUTF8Line$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12311
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r2 = r7
            java.lang.Appendable r2 = (java.lang.Appendable) r2
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.readUTF8LineTo(r2, r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r4 = r7
            r7 = r5
            r5 = r4
        L4f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L59
            r5 = 0
            return r5
        L59:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readUTF8Line$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean cancel(Throwable cause) {
        if (getClosedCause() != null || getClosed()) {
            return false;
        }
        if (cause == null) {
            cause = new CancellationException("Channel cancelled");
        }
        return close(cause);
    }

    @Override // io.ktor.utils.io.ByteWriteChannel
    public boolean close(Throwable cause) {
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closed$FU, this, null, cause == null ? CloseElementKt.getCLOSED_SUCCESS() : new CloseElement(cause))) {
            return false;
        }
        if (cause != null) {
            this.readable.release();
            this.writable.release();
            this.flushBuffer.release();
        } else {
            flush();
        }
        this.slot.cancel(cause);
        return true;
    }

    public final long transferTo$ktor_io(ByteChannelSequentialBase dst, long limit) throws Throwable {
        Intrinsics.checkNotNullParameter(dst, "dst");
        long remaining = this.readable.getRemaining();
        if (remaining > limit) {
            return 0L;
        }
        dst.writable.writePacket(this.readable);
        int i = (int) remaining;
        dst.afterWrite(i);
        afterRead(i);
        return remaining;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12331
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L52
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r5
        L52:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.writeAvailable(r6, r0)
            if (r7 != r1) goto L60
            return r1
        L60:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeAvailableSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase.C12342
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.C12342) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L68
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            byte[] r6 = (byte[]) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5a
        L45:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            r2 = r5
        L5a:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.writeAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L68
            return r1
        L68:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeAvailableSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected final void afterWrite(int count) throws Throwable {
        addBytesWritten(count);
        if (getClosed()) {
            this.writable.release();
            ensureNotClosed();
        }
        if (getAutoFlush() || getAvailableForWrite() == 0) {
            flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object awaitFreeSpace$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L47
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.flush()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            r4.ensureNotClosed()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitFreeSpace$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super Unit> continuation) {
        Object objAwait = byteChannelSequentialBase.await(1, continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // io.ktor.utils.io.ByteReadChannel
    /* renamed from: peekTo-lBXzO7A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo8801peekTolBXzO7A(java.nio.ByteBuffer r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation<? super java.lang.Long> r28) {
        /*
            r18 = this;
            r0 = r18
            r1 = r28
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            if (r2 == 0) goto L18
            r2 = r1
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = (io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r2 = r2.L$0
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L63
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
            r1.<init>()
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2
            r17 = 0
            r6 = r4
            r7 = r24
            r9 = r22
            r11 = r1
            r12 = r26
            r14 = r19
            r15 = r20
            r6.<init>(r7, r9, r11, r12, r14, r15, r17)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r2 = r0.readSuspendableSession(r4, r2)
            if (r2 != r3) goto L62
            return r3
        L62:
            r2 = r1
        L63:
            long r1 = r2.element
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.mo8801peekTolBXzO7A(java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readFully(Buffer buffer, int i, Continuation<? super Unit> continuation) throws Throwable {
        if (i > buffer.getLimit() - buffer.getWritePosition()) {
            throw new IllegalArgumentException(("Not enough space in the destination buffer to write " + i + " bytes").toString());
        }
        if (i < 0) {
            throw new IllegalArgumentException("n shouldn't be negative".toString());
        }
        if (getClosedCause() != null) {
            Throwable closedCause = getClosedCause();
            Intrinsics.checkNotNull(closedCause);
            throw closedCause;
        }
        if (this.readable.getRemaining() < i) {
            if (getClosed()) {
                throw new EOFException("Channel is closed and not enough bytes available: required " + i + " but " + get_availableForRead() + " available");
            }
            Object fullySuspend = readFullySuspend(buffer, i, continuation);
            return fullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fullySuspend : Unit.INSTANCE;
        }
        InputArraysKt.readFully(this.readable, buffer, i);
        Unit unit = Unit.INSTANCE;
        afterRead(i);
        return Unit.INSTANCE;
    }

    private final void addBytesRead(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("Can't read negative amount of bytes: " + count).toString());
        }
        int i = -count;
        channelSize$FU.getAndAdd(this, i);
        _totalBytesRead$FU.addAndGet(this, count);
        _availableForRead$FU.getAndAdd(this, i);
        if (this.channelSize < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + get_availableForRead() + ", " + count + " in " + this).toString());
        }
        if (get_availableForRead() < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + get_availableForRead() + ", " + count + " in " + this).toString());
        }
    }

    private final void addBytesWritten(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(("Can't write negative amount of bytes: " + count).toString());
        }
        channelSize$FU.getAndAdd(this, count);
        _totalBytesWritten$FU.addAndGet(this, count);
        if (this.channelSize < 0) {
            throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + count + " in " + this).toString());
        }
    }
}
