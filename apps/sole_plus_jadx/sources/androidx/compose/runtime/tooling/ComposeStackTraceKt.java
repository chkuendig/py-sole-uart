package androidx.compose.runtime.tooling;

import com.android.ddmlib.DdmConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ComposeStackTrace.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0000\u001a \u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0000\u001a\u001e\u0010\b\u001a\u00020\t*\u00060\nj\u0002`\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"tryAttachComposeStackTrace", "", "", DdmConstants.EXTENSION, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "attachComposeStackTrace", "appendStackTrace", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "RuntimePackageHash", "", "IncludeDebugInfo", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposeStackTraceKt {
    private static final boolean IncludeDebugInfo = false;
    private static final String RuntimePackageHash = "9igjgp";

    /* JADX WARN: Removed duplicated region for block: B:24:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean tryAttachComposeStackTrace(java.lang.Throwable r3, kotlin.jvm.functions.Function0<? extends java.util.List<androidx.compose.runtime.tooling.ComposeStackTraceFrame>> r4) {
        /*
            java.util.List r0 = kotlin.ExceptionsKt.getSuppressedExceptions(r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            if (r1 == 0) goto L15
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L15
            goto L2a
        L15:
            java.util.Iterator r0 = r0.iterator()
        L19:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2a
            java.lang.Object r1 = r0.next()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            boolean r1 = r1 instanceof androidx.compose.runtime.tooling.DiagnosticComposeException
            if (r1 == 0) goto L19
            goto L4c
        L2a:
            java.lang.Object r4 = r4.invoke()     // Catch: java.lang.Throwable -> L45
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L45
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L45
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L45
            r2 = r0 ^ 1
            if (r0 != 0) goto L41
            androidx.compose.runtime.tooling.DiagnosticComposeException r0 = new androidx.compose.runtime.tooling.DiagnosticComposeException     // Catch: java.lang.Throwable -> L45
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L45
            goto L42
        L41:
            r0 = 0
        L42:
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L45
            goto L47
        L45:
            r4 = move-exception
            r0 = r4
        L47:
            if (r0 == 0) goto L4c
            kotlin.ExceptionsKt.addSuppressed(r3, r0)
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceKt.tryAttachComposeStackTrace(java.lang.Throwable, kotlin.jvm.functions.Function0):boolean");
    }

    public static final Throwable attachComposeStackTrace(Throwable th, Function0<? extends List<ComposeStackTraceFrame>> function0) {
        tryAttachComposeStackTrace(th, function0);
        return th;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[PHI: r9
      0x0037: PHI (r9v1 java.lang.String) = (r9v0 java.lang.String), (r9v14 java.lang.String) binds: [B:5:0x0024, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void appendStackTrace(java.lang.StringBuilder r12, java.util.List<androidx.compose.runtime.tooling.ComposeStackTraceFrame> r13) {
        /*
            java.util.List r0 = kotlin.collections.CollectionsKt.createListBuilder()
            java.util.List r13 = kotlin.collections.CollectionsKt.asReversed(r13)
            r1 = r13
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L14:
            if (r4 >= r1) goto Lc7
            java.lang.Object r7 = r13.get(r4)
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r7 = (androidx.compose.runtime.tooling.ComposeStackTraceFrame) r7
            androidx.compose.runtime.tooling.SourceInformation r8 = r7.getSourceInfo()
            java.lang.String r9 = r8.getFunctionName()
            if (r9 != 0) goto L37
            boolean r9 = r8.getIsCall()
            if (r9 == 0) goto L2f
            java.lang.String r9 = "<lambda>"
            goto L30
        L2f:
            r9 = r2
        L30:
            if (r9 != 0) goto L37
            if (r5 != 0) goto L38
            java.lang.String r5 = "<unknown function>"
            goto L38
        L37:
            r5 = r9
        L38:
            java.lang.String r9 = r8.getSourceFile()
            if (r9 != 0) goto L43
            if (r6 != 0) goto L44
            java.lang.String r6 = "<unknown file>"
            goto L44
        L43:
            r6 = r9
        L44:
            java.util.List r9 = r8.getLocations()
            java.lang.Integer r10 = r7.getGroupOffset()
            if (r10 == 0) goto L73
            java.lang.Integer r10 = r7.getGroupOffset()
            int r10 = r10.intValue()
            int r11 = r9.size()
            if (r10 >= r11) goto L73
            java.lang.Integer r7 = r7.getGroupOffset()
            int r7 = r7.intValue()
            java.lang.Object r7 = r9.get(r7)
            androidx.compose.runtime.tooling.LocationSourceInformation r7 = (androidx.compose.runtime.tooling.LocationSourceInformation) r7
            int r7 = r7.getLineNumber()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            goto L75
        L73:
            java.lang.String r7 = "<unknown line>"
        L75:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r10 = 40
            r9.append(r10)
            r9.append(r6)
            r10 = 58
            r9.append(r10)
            r9.append(r7)
            r7 = 41
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            boolean r9 = r8.getIsCall()
            if (r9 != 0) goto La7
            java.lang.Object r9 = kotlin.collections.CollectionsKt.removeLastOrNull(r0)
            java.lang.String r9 = (java.lang.String) r9
        La7:
            java.lang.String r9 = r8.getFunctionName()
            java.lang.String r10 = "rememberCompositionContext"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r9 == 0) goto Lc0
            java.lang.String r8 = r8.getPackageHash()
            java.lang.String r9 = "9igjgp"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto Lc0
            goto Lc3
        Lc0:
            r0.add(r7)
        Lc3:
            int r4 = r4 + 1
            goto L14
        Lc7:
            java.util.List r13 = kotlin.collections.CollectionsKt.build(r0)
            java.util.List r13 = kotlin.collections.CollectionsKt.asReversed(r13)
            r0 = r13
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
        Ld6:
            if (r3 >= r0) goto L102
            java.lang.Object r1 = r13.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "\tat "
            r2.<init>(r4)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r1 = r12.append(r1)
            java.lang.String r2 = "append(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r4 = 10
            java.lang.StringBuilder r1 = r1.append(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r3 = r3 + 1
            goto Ld6
        L102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceKt.appendStackTrace(java.lang.StringBuilder, java.util.List):void");
    }
}
