package io.ktor.utils.io.core;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.bits.PrimitiveArraysJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BufferPrimitives.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a)\u0010\u0006\u001a\u00020\u0007*\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0086\b\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u001eH\u0086\b\u001as\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"*\u00020\u00022\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%26\u0010\u0003\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\"0&H\u0081\bø\u0001\u0000ø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0002\u0010*\u001a\n\u0010+\u001a\u00020,*\u00020\u0002\u001a\r\u0010+\u001a\u00020,*\u00020\u001eH\u0086\b\u001a\u001c\u0010-\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b.\u0010/\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b0\u00101\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b2\u00103\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105\u001a)\u0010-\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0086\b\u001a\n\u00106\u001a\u00020\u0007*\u00020\u0002\u001a\r\u00106\u001a\u00020\u0007*\u00020\u001eH\u0086\b\u001a\n\u00107\u001a\u000208*\u00020\u0002\u001a\r\u00107\u001a\u000208*\u00020\u001eH\u0086\b\u001a\n\u00109\u001a\u00020:*\u00020\u0002\u001a\r\u00109\u001a\u00020:*\u00020\u001eH\u0086\b\u001a\u0012\u0010;\u001a\u00020<*\u00020\u0002ø\u0001\u0002¢\u0006\u0002\u0010=\u001a\u0015\u0010;\u001a\u00020<*\u00020\u001eH\u0086\bø\u0001\u0002¢\u0006\u0002\u0010>\u001a\u0012\u0010?\u001a\u00020@*\u00020\u0002ø\u0001\u0002¢\u0006\u0002\u0010A\u001a\u0015\u0010?\u001a\u00020@*\u00020\u001eH\u0086\bø\u0001\u0002¢\u0006\u0002\u0010B\u001a\u0012\u0010C\u001a\u00020D*\u00020\u0002ø\u0001\u0002¢\u0006\u0002\u0010E\u001a\u0015\u0010C\u001a\u00020D*\u00020\u001eH\u0086\bø\u0001\u0002¢\u0006\u0002\u0010F\u001a\u0012\u0010G\u001a\u00020H*\u00020\u0002ø\u0001\u0002¢\u0006\u0002\u0010I\u001a\u0015\u0010G\u001a\u00020H*\u00020\u001eH\u0086\bø\u0001\u0002¢\u0006\u0002\u0010J\u001a\u0012\u0010K\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020 \u001a\u0015\u0010K\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020 H\u0086\b\u001ah\u0010M\u001a\u00020\u0001*\u00020\u00022\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%26\u0010\u0003\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010&H\u0081\bø\u0001\u0000ø\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a\u0012\u0010N\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020,\u001a\u0015\u0010N\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020,H\u0086\b\u001a\u0012\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bR\u0010/\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bS\u00101\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bT\u00103\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bU\u00105\u001a)\u0010O\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010Q\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0086\b\u001a\u0012\u0010V\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020\u0007\u001a\u0015\u0010V\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020\u0007H\u0086\b\u001a\u0012\u0010W\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u000208\u001a\u0015\u0010W\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u000208H\u0086\b\u001a\u0012\u0010X\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020:\u001a\u0015\u0010X\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020:H\u0086\b\u001a\u001f\u0010Y\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020<ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bZ\u0010[\u001a\u001f\u0010Y\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020<ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bZ\u0010\\\u001a\u001f\u0010]\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020@ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b^\u0010_\u001a\"\u0010]\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020@H\u0086\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b^\u0010`\u001a\u001f\u0010a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020Dø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bb\u0010c\u001a\"\u0010a\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020DH\u0086\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bb\u0010d\u001a\u001f\u0010e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020Hø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bf\u0010g\u001a\"\u0010e\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020HH\u0086\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bf\u0010h\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006i"}, d2 = {"forEach", "", "Lio/ktor/utils/io/core/Buffer;", "block", "Lkotlin/Function1;", "", "readAvailable", "", "dst", SessionDescription.ATTR_LENGTH, "destination", "", "offset", "", "", "", "", "", "Lkotlin/UByteArray;", "readAvailable-o1GoV1E", "(Lio/ktor/utils/io/core/Buffer;[BII)I", "Lkotlin/UIntArray;", "readAvailable-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)I", "Lkotlin/ULongArray;", "readAvailable-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)I", "Lkotlin/UShortArray;", "readAvailable-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)I", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "readDouble", "", "readExact", "R", ContentDisposition.Parameters.Size, "name", "", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "memory", "(Lio/ktor/utils/io/core/Buffer;ILjava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "readFloat", "", "readFully", "readFully-o1GoV1E", "(Lio/ktor/utils/io/core/Buffer;[BII)V", "readFully-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)V", "readFully-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)V", "readFully-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)V", "readInt", "readLong", "", "readShort", "", "readUByte", "Lkotlin/UByte;", "(Lio/ktor/utils/io/core/Buffer;)B", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)B", "readUInt", "Lkotlin/UInt;", "(Lio/ktor/utils/io/core/Buffer;)I", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)I", "readULong", "Lkotlin/ULong;", "(Lio/ktor/utils/io/core/Buffer;)J", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)J", "readUShort", "Lkotlin/UShort;", "(Lio/ktor/utils/io/core/Buffer;)S", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)S", "writeDouble", "value", "writeExact", "writeFloat", "writeFully", "src", "source", "writeFully-o1GoV1E", "writeFully-o2ZM2JE", "writeFully-pqYNikA", "writeFully-Wt3Bwxc", "writeInt", "writeLong", "writeShort", "writeUByte", "writeUByte-EK-6454", "(Lio/ktor/utils/io/core/Buffer;B)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;B)V", "writeUInt", "writeUInt-Qn1smSk", "(Lio/ktor/utils/io/core/Buffer;I)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;I)V", "writeULong", "writeULong-2TYgG_w", "(Lio/ktor/utils/io/core/Buffer;J)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;J)V", "writeUShort", "writeUShort-i8woANY", "(Lio/ktor/utils/io/core/Buffer;S)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;S)V", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BufferPrimitivesKt {
    public static final byte readUByte(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return UByte.m9105constructorimpl(buffer.readByte());
    }

    public static final byte readUByte(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readUByte((Buffer) chunkBuffer);
    }

    /* renamed from: writeUByte-EK-6454, reason: not valid java name */
    public static final void m8982writeUByteEK6454(Buffer writeUByte, byte b) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        writeUByte.writeByte(b);
    }

    /* renamed from: writeUByte-EK-6454, reason: not valid java name */
    public static final void m8983writeUByteEK6454(ChunkBuffer writeUByte, byte b) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUByte, "$this$writeUByte");
        m8982writeUByteEK6454((Buffer) writeUByte, b);
    }

    public static final short readShort(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readShort((Buffer) chunkBuffer);
    }

    public static final short readUShort(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readUShort((Buffer) chunkBuffer);
    }

    public static final int readInt(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readInt((Buffer) chunkBuffer);
    }

    public static final int readUInt(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readUInt((Buffer) chunkBuffer);
    }

    public static final long readLong(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readLong((Buffer) chunkBuffer);
    }

    public static final long readULong(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readULong((Buffer) chunkBuffer);
    }

    public static final float readFloat(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readFloat((Buffer) chunkBuffer);
    }

    public static final double readDouble(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readDouble((Buffer) chunkBuffer);
    }

    public static final void writeShort(ChunkBuffer chunkBuffer, short s) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeShort((Buffer) chunkBuffer, s);
    }

    /* renamed from: writeUShort-i8woANY, reason: not valid java name */
    public static final void m8989writeUShorti8woANY(ChunkBuffer writeUShort, short s) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        m8988writeUShorti8woANY((Buffer) writeUShort, s);
    }

    public static final void writeInt(ChunkBuffer chunkBuffer, int i) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeInt((Buffer) chunkBuffer, i);
    }

    /* renamed from: writeUInt-Qn1smSk, reason: not valid java name */
    public static final void m8985writeUIntQn1smSk(ChunkBuffer writeUInt, int i) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        m8984writeUIntQn1smSk((Buffer) writeUInt, i);
    }

    public static final void writeLong(ChunkBuffer chunkBuffer, long j) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeLong((Buffer) chunkBuffer, j);
    }

    /* renamed from: writeULong-2TYgG_w, reason: not valid java name */
    public static final void m8987writeULong2TYgG_w(ChunkBuffer writeULong, long j) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        m8986writeULong2TYgG_w((Buffer) writeULong, j);
    }

    public static final void writeFloat(ChunkBuffer chunkBuffer, float f) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeFloat((Buffer) chunkBuffer, f);
    }

    public static final void writeDouble(ChunkBuffer chunkBuffer, double d) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeDouble((Buffer) chunkBuffer, d);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(ChunkBuffer chunkBuffer, byte[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = destination.length - i;
        }
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully((Buffer) chunkBuffer, destination, i, i2);
    }

    public static final void readFully(ChunkBuffer chunkBuffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully((Buffer) chunkBuffer, destination, i, i2);
    }

    /* renamed from: readFully-o1GoV1E$default, reason: not valid java name */
    public static /* synthetic */ void m8969readFullyo1GoV1E$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m9164getSizeimpl(bArr) - i;
        }
        m8968readFullyo1GoV1E(buffer, bArr, i, i2);
    }

    /* renamed from: readFully-o1GoV1E, reason: not valid java name */
    public static final void m8968readFullyo1GoV1E(Buffer readFully, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(buffer, bArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        if (i + i2 > destination.length) {
            throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length).toString());
        }
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
        readFully(buffer, destination, i, iMin);
        return iMin;
    }

    public static /* synthetic */ int readAvailable$default(ChunkBuffer chunkBuffer, byte[] destination, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = destination.length - i;
        }
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable((Buffer) chunkBuffer, destination, i, i2);
    }

    public static final int readAvailable(ChunkBuffer chunkBuffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable((Buffer) chunkBuffer, destination, i, i2);
    }

    /* renamed from: readAvailable-o1GoV1E$default, reason: not valid java name */
    public static /* synthetic */ int m8961readAvailableo1GoV1E$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m9164getSizeimpl(bArr) - i;
        }
        return m8960readAvailableo1GoV1E(buffer, bArr, i, i2);
    }

    /* renamed from: readAvailable-o1GoV1E, reason: not valid java name */
    public static final int m8960readAvailableo1GoV1E(Buffer readAvailable, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(ChunkBuffer chunkBuffer, byte[] source, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = source.length - i;
        }
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully((Buffer) chunkBuffer, source, i, i2);
    }

    public static final void writeFully(ChunkBuffer chunkBuffer, byte[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully((Buffer) chunkBuffer, source, i, i2);
    }

    /* renamed from: writeFully-o1GoV1E$default, reason: not valid java name */
    public static /* synthetic */ void m8977writeFullyo1GoV1E$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m9164getSizeimpl(bArr) - i;
        }
        m8976writeFullyo1GoV1E(buffer, bArr, i, i2);
    }

    /* renamed from: writeFully-o1GoV1E, reason: not valid java name */
    public static final void m8976writeFullyo1GoV1E(Buffer writeFully, byte[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFully(buffer, sArr, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc$default, reason: not valid java name */
    public static /* synthetic */ void m8967readFullyWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m9427getSizeimpl(sArr) - i;
        }
        m8966readFullyWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc, reason: not valid java name */
    public static final void m8966readFullyWt3Bwxc(Buffer readFully, short[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailable(buffer, sArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, short[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        if (i + i2 > destination.length) {
            throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length).toString());
        }
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(i2 / 2, buffer.getWritePosition() - buffer.getReadPosition());
        readFully(buffer, destination, i, iMin);
        return iMin;
    }

    /* renamed from: readAvailable-Wt3Bwxc$default, reason: not valid java name */
    public static /* synthetic */ int m8959readAvailableWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m9427getSizeimpl(sArr) - i;
        }
        return m8958readAvailableWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: readAvailable-Wt3Bwxc, reason: not valid java name */
    public static final int m8958readAvailableWt3Bwxc(Buffer readAvailable, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFully(buffer, sArr, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc$default, reason: not valid java name */
    public static /* synthetic */ void m8975writeFullyWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m9427getSizeimpl(sArr) - i;
        }
        m8974writeFullyWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc, reason: not valid java name */
    public static final void m8974writeFullyWt3Bwxc(Buffer writeFully, short[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFully(buffer, iArr, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE$default, reason: not valid java name */
    public static /* synthetic */ void m8971readFullyo2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m9243getSizeimpl(iArr) - i;
        }
        m8970readFullyo2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE, reason: not valid java name */
    public static final void m8970readFullyo2ZM2JE(Buffer readFully, int[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailable(buffer, iArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, int[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        if (i + i2 > destination.length) {
            throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length).toString());
        }
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(i2 / 4, buffer.getWritePosition() - buffer.getReadPosition());
        readFully(buffer, destination, i, iMin);
        return iMin;
    }

    /* renamed from: readAvailable-o2ZM2JE$default, reason: not valid java name */
    public static /* synthetic */ int m8963readAvailableo2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m9243getSizeimpl(iArr) - i;
        }
        return m8962readAvailableo2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: readAvailable-o2ZM2JE, reason: not valid java name */
    public static final int m8962readAvailableo2ZM2JE(Buffer readAvailable, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFully(buffer, iArr, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE$default, reason: not valid java name */
    public static /* synthetic */ void m8979writeFullyo2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m9243getSizeimpl(iArr) - i;
        }
        m8978writeFullyo2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE, reason: not valid java name */
    public static final void m8978writeFullyo2ZM2JE(Buffer writeFully, int[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFully(buffer, jArr, i, i2);
    }

    /* renamed from: readFully-pqYNikA$default, reason: not valid java name */
    public static /* synthetic */ void m8973readFullypqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m9322getSizeimpl(jArr) - i;
        }
        m8972readFullypqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: readFully-pqYNikA, reason: not valid java name */
    public static final void m8972readFullypqYNikA(Buffer readFully, long[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(readFully, "$this$readFully");
        Intrinsics.checkNotNullParameter(destination, "destination");
        readFully(readFully, destination, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailable(buffer, jArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, long[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        if (i + i2 > destination.length) {
            throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length).toString());
        }
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(i2 / 8, buffer.getWritePosition() - buffer.getReadPosition());
        readFully(buffer, destination, i, iMin);
        return iMin;
    }

    /* renamed from: readAvailable-pqYNikA$default, reason: not valid java name */
    public static /* synthetic */ int m8965readAvailablepqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m9322getSizeimpl(jArr) - i;
        }
        return m8964readAvailablepqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: readAvailable-pqYNikA, reason: not valid java name */
    public static final int m8964readAvailablepqYNikA(Buffer readAvailable, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(readAvailable, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return readAvailable(readAvailable, destination, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFully(buffer, jArr, i, i2);
    }

    /* renamed from: writeFully-pqYNikA$default, reason: not valid java name */
    public static /* synthetic */ void m8981writeFullypqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m9322getSizeimpl(jArr) - i;
        }
        m8980writeFullypqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: writeFully-pqYNikA, reason: not valid java name */
    public static final void m8980writeFullypqYNikA(Buffer writeFully, long[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeFully, "$this$writeFully");
        Intrinsics.checkNotNullParameter(source, "source");
        writeFully(writeFully, source, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFully(buffer, fArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailable(buffer, fArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, float[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        if (i + i2 > destination.length) {
            throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length).toString());
        }
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(i2 / 4, buffer.getWritePosition() - buffer.getReadPosition());
        readFully(buffer, destination, i, iMin);
        return iMin;
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFully(buffer, fArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) throws EOFException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFully(buffer, dArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailable(buffer, dArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, double[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (i < 0) {
            throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        if (i + i2 > destination.length) {
            throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + destination.length).toString());
        }
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(i2 / 8, buffer.getWritePosition() - buffer.getReadPosition());
        readFully(buffer, destination, i, iMin);
        return iMin;
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) throws InsufficientSpaceException {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFully(buffer, dArr, i, i2);
    }

    public static final int readFully(Buffer buffer, Buffer dst, int i) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (i < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i > dst.getLimit() - dst.getWritePosition()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            Memory.m8813copyToJT6ljtQ(memory, dst.getMemory(), readPosition, i, dst.getWritePosition());
            dst.commitWritten(i);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i);
            return i;
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + i + '.');
    }

    public static final void forEach(Buffer buffer, Function1<? super Byte, Unit> block) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        for (int i = readPosition; i < writePosition; i++) {
            block.invoke(Byte.valueOf(memory.get(i)));
        }
        buffer.discardExact(writePosition - readPosition);
    }

    public static final short readShort(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            Short shValueOf = Short.valueOf(memory.getShort(readPosition));
            buffer.discardExact(2);
            return shValueOf.shortValue();
        }
        throw new EOFException("Not enough bytes to read a short integer of size 2.");
    }

    public static final short readUShort(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            UShort uShortM9362boximpl = UShort.m9362boximpl(UShort.m9368constructorimpl(memory.getShort(readPosition)));
            buffer.discardExact(2);
            return uShortM9362boximpl.getData();
        }
        throw new EOFException("Not enough bytes to read a short unsigned integer of size 2.");
    }

    public static final int readInt(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            Integer numValueOf = Integer.valueOf(memory.getInt(readPosition));
            buffer.discardExact(4);
            return numValueOf.intValue();
        }
        throw new EOFException("Not enough bytes to read a regular integer of size 4.");
    }

    public static final int readUInt(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            UInt uIntM9176boximpl = UInt.m9176boximpl(UInt.m9182constructorimpl(memory.getInt(readPosition)));
            buffer.discardExact(4);
            return uIntM9176boximpl.getData();
        }
        throw new EOFException("Not enough bytes to read a regular unsigned integer of size 4.");
    }

    public static final long readLong(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            Long lValueOf = Long.valueOf(memory.getLong(readPosition));
            buffer.discardExact(8);
            return lValueOf.longValue();
        }
        throw new EOFException("Not enough bytes to read a long integer of size 8.");
    }

    public static final long readULong(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            ULong uLongM9255boximpl = ULong.m9255boximpl(ULong.m9261constructorimpl(memory.getLong(readPosition)));
            buffer.discardExact(8);
            return uLongM9255boximpl.getData();
        }
        throw new EOFException("Not enough bytes to read a long unsigned integer of size 8.");
    }

    public static final float readFloat(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            Float fValueOf = Float.valueOf(memory.getFloat(readPosition));
            buffer.discardExact(4);
            return fValueOf.floatValue();
        }
        throw new EOFException("Not enough bytes to read a floating point number of size 4.");
    }

    public static final double readDouble(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            Double dValueOf = Double.valueOf(memory.getDouble(readPosition));
            buffer.discardExact(8);
            return dValueOf.doubleValue();
        }
        throw new EOFException("Not enough bytes to read a long floating point number of size 8.");
    }

    public static final void writeShort(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 2) {
            throw new InsufficientSpaceException("short integer", 2, limit);
        }
        memory.putShort(writePosition, s);
        buffer.commitWritten(2);
    }

    /* renamed from: writeUShort-i8woANY, reason: not valid java name */
    public static final void m8988writeUShorti8woANY(Buffer writeUShort, short s) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUShort, "$this$writeUShort");
        ByteBuffer memory = writeUShort.getMemory();
        int writePosition = writeUShort.getWritePosition();
        int limit = writeUShort.getLimit() - writePosition;
        if (limit < 2) {
            throw new InsufficientSpaceException("short unsigned integer", 2, limit);
        }
        memory.putShort(writePosition, s);
        writeUShort.commitWritten(2);
    }

    public static final void writeInt(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 4) {
            throw new InsufficientSpaceException("regular integer", 4, limit);
        }
        memory.putInt(writePosition, i);
        buffer.commitWritten(4);
    }

    /* renamed from: writeUInt-Qn1smSk, reason: not valid java name */
    public static final void m8984writeUIntQn1smSk(Buffer writeUInt, int i) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeUInt, "$this$writeUInt");
        ByteBuffer memory = writeUInt.getMemory();
        int writePosition = writeUInt.getWritePosition();
        int limit = writeUInt.getLimit() - writePosition;
        if (limit < 4) {
            throw new InsufficientSpaceException("regular unsigned integer", 4, limit);
        }
        memory.putInt(writePosition, i);
        writeUInt.commitWritten(4);
    }

    public static final void writeLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 8) {
            throw new InsufficientSpaceException("long integer", 8, limit);
        }
        memory.putLong(writePosition, j);
        buffer.commitWritten(8);
    }

    /* renamed from: writeULong-2TYgG_w, reason: not valid java name */
    public static final void m8986writeULong2TYgG_w(Buffer writeULong, long j) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(writeULong, "$this$writeULong");
        ByteBuffer memory = writeULong.getMemory();
        int writePosition = writeULong.getWritePosition();
        int limit = writeULong.getLimit() - writePosition;
        if (limit < 8) {
            throw new InsufficientSpaceException("long unsigned integer", 8, limit);
        }
        memory.putLong(writePosition, j);
        writeULong.commitWritten(8);
    }

    public static final void writeFloat(Buffer buffer, float f) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 4) {
            throw new InsufficientSpaceException("floating point number", 4, limit);
        }
        memory.putFloat(writePosition, f);
        buffer.commitWritten(4);
    }

    public static final void writeDouble(Buffer buffer, double d) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < 8) {
            throw new InsufficientSpaceException("long floating point number", 8, limit);
        }
        memory.putDouble(writePosition, d);
        buffer.commitWritten(8);
    }

    public static final void readFully(Buffer buffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition < i2) {
            throw new EOFException("Not enough bytes to read a byte array of size " + i2 + '.');
        }
        MemoryJvmKt.m8831copyTo9zorpBc(memory, destination, readPosition, i2, i);
        Unit unit = Unit.INSTANCE;
        buffer.discardExact(i2);
    }

    public static final void writeFully(Buffer buffer, byte[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < i2) {
            throw new InsufficientSpaceException("byte array", i2, limit);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(source, i, i2).slice().order(java.nio.ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m8813copyToJT6ljtQ(Memory.m8812constructorimpl(byteBufferOrder), memory, 0, i2, writePosition);
        buffer.commitWritten(i2);
    }

    public static final void readFully(Buffer buffer, short[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 2;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m8932loadShortArray9zorpBc(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a short integers array of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, short[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 2;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m8952storeShortArray9zorpBc(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("short integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, int[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m8924loadIntArray9zorpBc(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a integers array of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, int[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m8944storeIntArray9zorpBc(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, long[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m8928loadLongArray9zorpBc(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a long integers array of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, long[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m8948storeLongArray9zorpBc(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("long integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, float[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m8920loadFloatArray9zorpBc(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a floating point numbers array of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, float[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 4;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m8940storeFloatArray9zorpBc(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("floating point numbers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, double[] destination, int i, int i2) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m8916loadDoubleArray9zorpBc(memory, readPosition, destination, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a floating point numbers array of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, double[] source, int i, int i2) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 * 8;
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m8936storeDoubleArray9zorpBc(memory, writePosition, source, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("floating point numbers array", i3, limit);
    }

    public static /* synthetic */ int readFully$default(Buffer buffer, Buffer buffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer2.getLimit() - buffer2.getWritePosition();
        }
        return readFully(buffer, buffer2, i);
    }

    public static final int readAvailable(Buffer buffer, Buffer dst, int i) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (buffer.getWritePosition() <= buffer.getReadPosition()) {
            return -1;
        }
        int iMin = Math.min(dst.getLimit() - dst.getWritePosition(), Math.min(buffer.getWritePosition() - buffer.getReadPosition(), i));
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= iMin) {
            Memory.m8813copyToJT6ljtQ(memory, dst.getMemory(), readPosition, iMin, dst.getWritePosition());
            dst.commitWritten(iMin);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(iMin);
            return iMin;
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + iMin + '.');
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, Buffer buffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer2.getLimit() - buffer2.getWritePosition();
        }
        return readAvailable(buffer, buffer2, i);
    }

    public static final void writeFully(Buffer buffer, Buffer src) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        int writePosition = src.getWritePosition() - src.getReadPosition();
        ByteBuffer memory = buffer.getMemory();
        int writePosition2 = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition2;
        if (limit >= writePosition) {
            Memory.m8813copyToJT6ljtQ(src.getMemory(), memory, src.getReadPosition(), writePosition, writePosition2);
            src.discardExact(writePosition);
            buffer.commitWritten(writePosition);
            return;
        }
        throw new InsufficientSpaceException("buffer readable content", writePosition, limit);
    }

    public static final void writeFully(Buffer buffer, Buffer src, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        if (i < 0) {
            throw new IllegalArgumentException(("length shouldn't be negative: " + i).toString());
        }
        if (i > src.getWritePosition() - src.getReadPosition()) {
            throw new IllegalArgumentException(("length shouldn't be greater than the source read remaining: " + i + " > " + (src.getWritePosition() - src.getReadPosition())).toString());
        }
        if (i > buffer.getLimit() - buffer.getWritePosition()) {
            throw new IllegalArgumentException(("length shouldn't be greater than the destination write remaining space: " + i + " > " + (buffer.getLimit() - buffer.getWritePosition())).toString());
        }
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i) {
            Memory.m8813copyToJT6ljtQ(src.getMemory(), memory, src.getReadPosition(), i, writePosition);
            src.discardExact(i);
            buffer.commitWritten(i);
            return;
        }
        throw new InsufficientSpaceException("buffer readable content", i, limit);
    }

    public static final <R> R readExact(Buffer buffer, int i, String name, Function2<? super Memory, ? super Integer, ? extends R> block) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition < i) {
            throw new EOFException("Not enough bytes to read a " + name + " of size " + i + '.');
        }
        R rInvoke = block.invoke(Memory.m8811boximpl(memory), Integer.valueOf(readPosition));
        buffer.discardExact(i);
        return rInvoke;
    }

    public static final void writeExact(Buffer buffer, int i, String name, Function2<? super Memory, ? super Integer, Unit> block) throws InsufficientSpaceException {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer memory = buffer.getMemory();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit < i) {
            throw new InsufficientSpaceException(name, i, limit);
        }
        block.invoke(Memory.m8811boximpl(memory), Integer.valueOf(writePosition));
        buffer.commitWritten(i);
    }
}
