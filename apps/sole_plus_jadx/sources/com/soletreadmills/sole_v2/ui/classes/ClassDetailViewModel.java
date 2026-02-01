package com.soletreadmills.sole_v2.ui.classes;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2._data.classes.CookieInfoListData;
import com.soletreadmills.sole_v2._data.classes.VideoDetailData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._tools.SrtParser;
import com.soletreadmills.sole_v2._tools.VideoUtils;
import com.sun.jna.platform.win32.WinError;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: ClassDetailViewModel.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010D\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010G\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010H\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010I\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010J\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010K\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010L\u001a\u00020EH\u0086@¢\u0006\u0002\u0010FJ\u0006\u0010M\u001a\u00020EJ\u0006\u0010N\u001a\u00020EJ\u0016\u0010O\u001a\u00020E2\u0006\u0010P\u001a\u00020&2\u0006\u0010Q\u001a\u00020&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00128F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010#\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R+\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020&8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082D¢\u0006\u0002\n\u0000R+\u00101\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001d8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R+\u00105\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0011\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR/\u0010:\u001a\u0004\u0018\u0001092\b\u0010\t\u001a\u0004\u0018\u0001098F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010\u0011\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006R"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "classId", "", "getClassId", "()Ljava/lang/String;", "setClassId", "(Ljava/lang/String;)V", "<set-?>", "Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "cookieData", "getCookieData", "()Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "setCookieData", "(Lcom/soletreadmills/sole_v2/ui/classes/CookieData;)V", "cookieData$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "data", "getData", "()Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "setData", "(Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;)V", "data$delegate", "errorData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getErrorData", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "isConnectingFtms", "()Z", "setConnectingFtms", "(Z)V", "isConnectingFtms$delegate", "isConnectingHr", "setConnectingHr", "isConnectingHr$delegate", "", "lastPosition", "getLastPosition", "()J", "setLastPosition", "(J)V", "lastPosition$delegate", "prefs", "Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "previews_sec", "", "showSubtitles", "getShowSubtitles", "setShowSubtitles", "showSubtitles$delegate", "subtitle", "getSubtitle", "setSubtitle", "subtitle$delegate", "Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "videoDetailData", "getVideoDetailData", "()Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "setVideoDetailData", "(Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;)V", "videoDetailData$delegate", "videoPlayerController", "Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "getVideoPlayerController", "()Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "apiDeleteFavorite", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiGetClassDetail", "apiGetClassVideo", "apiGetSubscriptionStatus", "apiPostClassClick", "apiPostFavorite", "apiPostStartClass", "updateFtmsConnectionStatus", "updateHrConnectionStatus", "updateVideoProgress", "currentTimeMs", "totalTime", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassDetailViewModel extends ViewModel {
    public static final int $stable = 8;
    private String classId;

    /* renamed from: cookieData$delegate, reason: from kotlin metadata */
    private final MutableState cookieData;

    /* renamed from: data$delegate, reason: from kotlin metadata */
    private final MutableState data;
    private final MutableSharedFlow<String> errorData;

    /* renamed from: isConnectingFtms$delegate, reason: from kotlin metadata */
    private final MutableState isConnectingFtms;

    /* renamed from: isConnectingHr$delegate, reason: from kotlin metadata */
    private final MutableState isConnectingHr;

    /* renamed from: lastPosition$delegate, reason: from kotlin metadata */
    private final MutableState lastPosition;
    private final MySharedPreferences prefs;
    private final float previews_sec;

    /* renamed from: showSubtitles$delegate, reason: from kotlin metadata */
    private final MutableState showSubtitles;

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final MutableState subtitle;

    /* renamed from: videoDetailData$delegate, reason: from kotlin metadata */
    private final MutableState videoDetailData;
    private final VideoPlayerController videoPlayerController;

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0}, l = {249, 251}, m = "apiDeleteFavorite", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiDeleteFavorite$1, reason: invalid class name */
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
            return ClassDetailViewModel.this.apiDeleteFavorite(this);
        }
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0}, l = {136, 143}, m = "apiGetClassDetail", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassDetail$1, reason: invalid class name and case insensitive filesystem */
    static final class C08631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08631(Continuation<? super C08631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassDetailViewModel.this.apiGetClassDetail(this);
        }
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0}, l = {153, 160, 211}, m = "apiGetClassVideo", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$1, reason: invalid class name and case insensitive filesystem */
    static final class C08641 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08641(Continuation<? super C08641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassDetailViewModel.this.apiGetClassVideo(this);
        }
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0}, l = {90, 105}, m = "apiGetSubscriptionStatus", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetSubscriptionStatus$1, reason: invalid class name and case insensitive filesystem */
    static final class C08651 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08651(Continuation<? super C08651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassDetailViewModel.this.apiGetSubscriptionStatus(this);
        }
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0, 0, 1}, l = {113, 115, 118}, m = "apiPostClassClick", n = {"this", "$this$apiPostClassClick_u24lambda_u240", "this"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostClassClick$1, reason: invalid class name and case insensitive filesystem */
    static final class C08661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08661(Continuation<? super C08661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassDetailViewModel.this.apiPostClassClick(this);
        }
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0}, l = {WinError.ERROR_NO_DATA, WinError.ERROR_MORE_DATA}, m = "apiPostFavorite", n = {"this"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostFavorite$1, reason: invalid class name and case insensitive filesystem */
    static final class C08671 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08671(Continuation<? super C08671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassDetailViewModel.this.apiPostFavorite(this);
        }
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel", f = "ClassDetailViewModel.kt", i = {0, 0, 1}, l = {124, 126, 129}, m = "apiPostStartClass", n = {"this", "$this$apiPostStartClass_u24lambda_u242", "this"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostStartClass$1, reason: invalid class name and case insensitive filesystem */
    static final class C08681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08681(Continuation<? super C08681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClassDetailViewModel.this.apiPostStartClass(this);
        }
    }

    public ClassDetailViewModel() {
        MySharedPreferences companion = MySharedPreferences.INSTANCE.getInstance();
        this.prefs = companion;
        this.data = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.videoDetailData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.cookieData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.subtitle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.showSubtitles = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(companion.getShowSubtitles()), null, 2, null);
        this.previews_sec = 180.0f;
        this.lastPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
        this.classId = "";
        this.errorData = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.isConnectingHr = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.isConnectingFtms = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.videoPlayerController = new VideoPlayerController();
    }

    private final void setData(ClassesData classesData) {
        this.data.setValue(classesData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ClassesData getData() {
        return (ClassesData) this.data.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVideoDetailData(VideoDetailData videoDetailData) {
        this.videoDetailData.setValue(videoDetailData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final VideoDetailData getVideoDetailData() {
        return (VideoDetailData) this.videoDetailData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCookieData(CookieData cookieData) {
        this.cookieData.setValue(cookieData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CookieData getCookieData() {
        return (CookieData) this.cookieData.getValue();
    }

    private final void setSubtitle(String str) {
        this.subtitle.setValue(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getSubtitle() {
        return (String) this.subtitle.getValue();
    }

    private final void setShowSubtitles(boolean z) {
        this.showSubtitles.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShowSubtitles() {
        return ((Boolean) this.showSubtitles.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long getLastPosition() {
        return ((Number) this.lastPosition.getValue()).longValue();
    }

    public final void setLastPosition(long j) {
        this.lastPosition.setValue(Long.valueOf(j));
    }

    public final String getClassId() {
        return this.classId;
    }

    public final void setClassId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classId = str;
    }

    public final MutableSharedFlow<String> getErrorData() {
        return this.errorData;
    }

    private final void setConnectingHr(boolean z) {
        this.isConnectingHr.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isConnectingHr() {
        return ((Boolean) this.isConnectingHr.getValue()).booleanValue();
    }

    private final void setConnectingFtms(boolean z) {
        this.isConnectingFtms.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isConnectingFtms() {
        return ((Boolean) this.isConnectingFtms.getValue()).booleanValue();
    }

    public final VideoPlayerController getVideoPlayerController() {
        return this.videoPlayerController;
    }

    public final void updateHrConnectionStatus() {
        setConnectingHr(BleManager.getInstance().isConnectedHr());
    }

    public final void updateFtmsConnectionStatus() {
        setConnectingFtms(BleManager.getInstance().isConnectedFtms());
    }

    public final void updateVideoProgress(long currentTimeMs, long totalTime) {
        float f = currentTimeMs / 1000.0f;
        setSubtitle(SrtParser.INSTANCE.getShared().updateSubtitle(currentTimeMs));
        if (f >= this.previews_sec) {
            this.videoPlayerController.replay();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGetSubscriptionStatus(kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08651
            if (r0 == 0) goto L14
            r0 = r10
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetSubscriptionStatus$1 r0 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetSubscriptionStatus$1 r0 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetSubscriptionStatus$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9a
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L37:
            java.lang.Object r2 = r0.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r2 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L4e
        L3f:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callGetSubscriptionStatus(r0)
            if (r10 != r1) goto L4d
            return r1
        L4d:
            r2 = r9
        L4e:
            retrofit2.Response r10 = (retrofit2.Response) r10
            java.lang.Object r10 = r10.body()
            com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusApiData$ResponseData r10 = (com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusApiData.ResponseData) r10
            r6 = 0
            if (r10 == 0) goto L64
            com.soletreadmills.sole_v2._data._base.JwtApiBaseData$SysResponseMessage r7 = r10.getSysMsg()
            if (r7 == 0) goto L64
            java.lang.String r7 = r7.getCode()
            goto L65
        L64:
            r7 = r6
        L65:
            com.soletreadmills.sole_v2._data.api.JwtErrorCode r8 = com.soletreadmills.sole_v2._data.api.JwtErrorCode.JWT_SUCCESS_1
            java.lang.String r8 = r8.getId()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r8 == 0) goto L89
            if (r10 == 0) goto L7d
            com.soletreadmills.sole_v2._data.classes.GetSubscriptionStatusDataMap r10 = r10.getDataMap()
            if (r10 == 0) goto L7d
            com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType r6 = r10.getSubscriptionStatus()
        L7d:
            if (r6 == 0) goto L9a
            com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType$Companion r10 = com.soletreadmills.sole_v2._data.classes.SubscriptionStatusType.INSTANCE
            boolean r10 = r10.isSubscribedOrTrial(r6)
            if (r10 != r5) goto L9a
            r3 = r5
            goto L9a
        L89:
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r10 = r2.errorData
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r10 = r10.emit(r2, r0)
            if (r10 != r1) goto L9a
            return r1
        L9a:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiGetSubscriptionStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiPostClassClick(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "網路異常 ("
            boolean r1 = r10 instanceof com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08661
            if (r1 == 0) goto L16
            r1 = r10
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostClassClick$1 r1 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08661) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r10 = r1.label
            int r10 = r10 - r3
            r1.label = r10
            goto L1b
        L16:
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostClassClick$1 r1 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostClassClick$1
            r1.<init>(r10)
        L1b:
            java.lang.Object r10 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L57
            if (r3 == r7) goto L48
            if (r3 == r6) goto L3e
            if (r3 != r5) goto L36
            java.lang.Object r0 = r1.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lcb
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3e:
            java.lang.Object r0 = r1.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r0 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L46
            goto La1
        L46:
            r10 = move-exception
            goto Laa
        L48:
            java.lang.Object r3 = r1.L$1
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r3 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r3
            java.lang.Object r7 = r1.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r7 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L54
            goto L72
        L54:
            r10 = move-exception
            r0 = r7
            goto Laa
        L57:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La8
            r10 = r9
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r10 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r10     // Catch: java.lang.Throwable -> La8
            java.lang.String r10 = "sole"
            java.lang.String r3 = r9.classId     // Catch: java.lang.Throwable -> La8
            r1.L$0 = r9     // Catch: java.lang.Throwable -> La8
            r1.L$1 = r9     // Catch: java.lang.Throwable -> La8
            r1.label = r7     // Catch: java.lang.Throwable -> La8
            java.lang.Object r10 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callPostClassClick(r10, r3, r1)     // Catch: java.lang.Throwable -> La8
            if (r10 != r2) goto L70
            return r2
        L70:
            r3 = r9
            r7 = r3
        L72:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L54
            boolean r8 = r10.isSuccessful()     // Catch: java.lang.Throwable -> L54
            if (r8 != 0) goto La0
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r3 = r3.errorData     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L54
            int r10 = r10.code()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r10 = r8.append(r10)     // Catch: java.lang.Throwable -> L54
            r0 = 41
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L54
            r1.L$0 = r7     // Catch: java.lang.Throwable -> L54
            r1.L$1 = r4     // Catch: java.lang.Throwable -> L54
            r1.label = r6     // Catch: java.lang.Throwable -> L54
            java.lang.Object r10 = r3.emit(r10, r1)     // Catch: java.lang.Throwable -> L54
            if (r10 != r2) goto La0
            return r2
        La0:
            r0 = r7
        La1:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L46
            java.lang.Object r10 = kotlin.Result.m9087constructorimpl(r10)     // Catch: java.lang.Throwable -> L46
            goto Lb4
        La8:
            r10 = move-exception
            r0 = r9
        Laa:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m9087constructorimpl(r10)
        Lb4:
            java.lang.Throwable r3 = kotlin.Result.m9090exceptionOrNullimpl(r10)
            if (r3 == 0) goto Lcb
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r0 = r0.errorData
            r1.L$0 = r10
            r1.L$1 = r4
            r1.label = r5
            java.lang.String r10 = "服務暫時不可用"
            java.lang.Object r10 = r0.emit(r10, r1)
            if (r10 != r2) goto Lcb
            return r2
        Lcb:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiPostClassClick(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiPostStartClass(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "網路異常 ("
            boolean r1 = r10 instanceof com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08681
            if (r1 == 0) goto L16
            r1 = r10
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostStartClass$1 r1 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08681) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r10 = r1.label
            int r10 = r10 - r3
            r1.label = r10
            goto L1b
        L16:
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostStartClass$1 r1 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiPostStartClass$1
            r1.<init>(r10)
        L1b:
            java.lang.Object r10 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L57
            if (r3 == r7) goto L48
            if (r3 == r6) goto L3e
            if (r3 != r5) goto L36
            java.lang.Object r0 = r1.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc9
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3e:
            java.lang.Object r0 = r1.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r0 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L46
            goto L9f
        L46:
            r10 = move-exception
            goto La8
        L48:
            java.lang.Object r3 = r1.L$1
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r3 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r3
            java.lang.Object r7 = r1.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r7 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r7
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L54
            goto L70
        L54:
            r10 = move-exception
            r0 = r7
            goto La8
        L57:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> La6
            r10 = r9
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r10 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r10     // Catch: java.lang.Throwable -> La6
            java.lang.String r10 = r9.classId     // Catch: java.lang.Throwable -> La6
            r1.L$0 = r9     // Catch: java.lang.Throwable -> La6
            r1.L$1 = r9     // Catch: java.lang.Throwable -> La6
            r1.label = r7     // Catch: java.lang.Throwable -> La6
            java.lang.Object r10 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callPostStartClass(r10, r1)     // Catch: java.lang.Throwable -> La6
            if (r10 != r2) goto L6e
            return r2
        L6e:
            r3 = r9
            r7 = r3
        L70:
            retrofit2.Response r10 = (retrofit2.Response) r10     // Catch: java.lang.Throwable -> L54
            boolean r8 = r10.isSuccessful()     // Catch: java.lang.Throwable -> L54
            if (r8 != 0) goto L9e
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r3 = r3.errorData     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r8.<init>(r0)     // Catch: java.lang.Throwable -> L54
            int r10 = r10.code()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r10 = r8.append(r10)     // Catch: java.lang.Throwable -> L54
            r0 = 41
            java.lang.StringBuilder r10 = r10.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L54
            r1.L$0 = r7     // Catch: java.lang.Throwable -> L54
            r1.L$1 = r4     // Catch: java.lang.Throwable -> L54
            r1.label = r6     // Catch: java.lang.Throwable -> L54
            java.lang.Object r10 = r3.emit(r10, r1)     // Catch: java.lang.Throwable -> L54
            if (r10 != r2) goto L9e
            return r2
        L9e:
            r0 = r7
        L9f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L46
            java.lang.Object r10 = kotlin.Result.m9087constructorimpl(r10)     // Catch: java.lang.Throwable -> L46
            goto Lb2
        La6:
            r10 = move-exception
            r0 = r9
        La8:
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m9087constructorimpl(r10)
        Lb2:
            java.lang.Throwable r3 = kotlin.Result.m9090exceptionOrNullimpl(r10)
            if (r3 == 0) goto Lc9
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r0 = r0.errorData
            r1.L$0 = r10
            r1.L$1 = r4
            r1.label = r5
            java.lang.String r10 = "服務暫時不可用"
            java.lang.Object r10 = r0.emit(r10, r1)
            if (r10 != r2) goto Lc9
            return r2
        Lc9:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiPostStartClass(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGetClassDetail(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08631
            if (r0 == 0) goto L14
            r0 = r8
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassDetail$1 r0 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08631) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassDetail$1 r0 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassDetail$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2d
            goto L8f
        L2d:
            r8 = move-exception
            goto L8c
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            java.lang.Object r2 = r0.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r2 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L2d
            goto L50
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = r7.classId     // Catch: java.lang.Exception -> L2d
            r0.L$0 = r7     // Catch: java.lang.Exception -> L2d
            r0.label = r4     // Catch: java.lang.Exception -> L2d
            java.lang.Object r8 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callGetClassDetailApiData(r8, r0)     // Catch: java.lang.Exception -> L2d
            if (r8 != r1) goto L4f
            return r1
        L4f:
            r2 = r7
        L50:
            retrofit2.Response r8 = (retrofit2.Response) r8     // Catch: java.lang.Exception -> L2d
            java.lang.Object r8 = r8.body()     // Catch: java.lang.Exception -> L2d
            com.soletreadmills.sole_v2._data.classes.GetClassDetailApiData$ResponseData r8 = (com.soletreadmills.sole_v2._data.classes.GetClassDetailApiData.ResponseData) r8     // Catch: java.lang.Exception -> L2d
            r4 = 0
            if (r8 == 0) goto L66
            com.soletreadmills.sole_v2._data._base.JwtApiBaseData$SysResponseMessage r5 = r8.getSysMsg()     // Catch: java.lang.Exception -> L2d
            if (r5 == 0) goto L66
            java.lang.String r5 = r5.getCode()     // Catch: java.lang.Exception -> L2d
            goto L67
        L66:
            r5 = r4
        L67:
            com.soletreadmills.sole_v2._data.api.JwtErrorCode r6 = com.soletreadmills.sole_v2._data.api.JwtErrorCode.JWT_SUCCESS_1     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = r6.getId()     // Catch: java.lang.Exception -> L2d
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)     // Catch: java.lang.Exception -> L2d
            if (r6 == 0) goto L7b
            com.soletreadmills.sole_v2._data.classes.ClassesData r8 = r8.getDataMap()     // Catch: java.lang.Exception -> L2d
            r2.setData(r8)     // Catch: java.lang.Exception -> L2d
            goto L8f
        L7b:
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r8 = r2.errorData     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L2d
            r0.L$0 = r4     // Catch: java.lang.Exception -> L2d
            r0.label = r3     // Catch: java.lang.Exception -> L2d
            java.lang.Object r8 = r8.emit(r2, r0)     // Catch: java.lang.Exception -> L2d
            if (r8 != r1) goto L8f
            return r1
        L8c:
            r8.printStackTrace()
        L8f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiGetClassDetail(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiGetClassVideo(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08641
            if (r0 == 0) goto L14
            r0 = r9
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$1 r0 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.C08641) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$1 r0 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L46
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            goto L36
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L3b
            goto Lb8
        L3b:
            r9 = move-exception
            goto Lb5
        L3e:
            java.lang.Object r2 = r0.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r2 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L3b
            goto L61
        L46:
            kotlin.ResultKt.throwOnFailure(r9)
            com.soletreadmills.sole_v2._data.classes.ClassesData r9 = r8.getData()     // Catch: java.lang.Exception -> L3b
            if (r9 == 0) goto L54
            java.lang.String r9 = r9.getVideo_id()     // Catch: java.lang.Exception -> L3b
            goto L55
        L54:
            r9 = r6
        L55:
            r0.L$0 = r8     // Catch: java.lang.Exception -> L3b
            r0.label = r5     // Catch: java.lang.Exception -> L3b
            java.lang.Object r9 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callGetVideoDetailApiData(r9, r0)     // Catch: java.lang.Exception -> L3b
            if (r9 != r1) goto L60
            return r1
        L60:
            r2 = r8
        L61:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch: java.lang.Exception -> L3b
            java.lang.Object r9 = r9.body()     // Catch: java.lang.Exception -> L3b
            com.soletreadmills.sole_v2._data.classes.GetClassVideoDetailApiData$ResponseData r9 = (com.soletreadmills.sole_v2._data.classes.GetClassVideoDetailApiData.ResponseData) r9     // Catch: java.lang.Exception -> L3b
            if (r9 == 0) goto L76
            com.soletreadmills.sole_v2._data._base.JwtApiBaseData$SysResponseMessage r5 = r9.getSysMsg()     // Catch: java.lang.Exception -> L3b
            if (r5 == 0) goto L76
            java.lang.String r5 = r5.getCode()     // Catch: java.lang.Exception -> L3b
            goto L77
        L76:
            r5 = r6
        L77:
            com.soletreadmills.sole_v2._data.api.JwtErrorCode r7 = com.soletreadmills.sole_v2._data.api.JwtErrorCode.JWT_SUCCESS_1     // Catch: java.lang.Exception -> L3b
            java.lang.String r7 = r7.getId()     // Catch: java.lang.Exception -> L3b
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r7)     // Catch: java.lang.Exception -> L3b
            if (r7 == 0) goto La4
            com.soletreadmills.sole_v2._data.classes.VideoDetailData r9 = r9.getDataMap()     // Catch: java.lang.Exception -> L3b
            if (r9 != 0) goto L8c
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> L3b
            return r9
        L8c:
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L3b
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3     // Catch: java.lang.Exception -> L3b
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$2 r5 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$2     // Catch: java.lang.Exception -> L3b
            r5.<init>(r9, r6)     // Catch: java.lang.Exception -> L3b
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Exception -> L3b
            r0.L$0 = r6     // Catch: java.lang.Exception -> L3b
            r0.label = r4     // Catch: java.lang.Exception -> L3b
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r3, r5, r0)     // Catch: java.lang.Exception -> L3b
            if (r9 != r1) goto Lb8
            return r1
        La4:
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r9 = r2.errorData     // Catch: java.lang.Exception -> L3b
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> L3b
            r0.L$0 = r6     // Catch: java.lang.Exception -> L3b
            r0.label = r3     // Catch: java.lang.Exception -> L3b
            java.lang.Object r9 = r9.emit(r2, r0)     // Catch: java.lang.Exception -> L3b
            if (r9 != r1) goto Lb8
            return r1
        Lb5:
            r9.printStackTrace()
        Lb8:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiGetClassVideo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: ClassDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$2", f = "ClassDetailViewModel.kt", i = {0, 0}, l = {200}, m = "invokeSuspend", n = {"httpCookieList", "videoURL"}, s = {"L$0", "L$1"})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiGetClassVideo$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VideoDetailData $videoData;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(VideoDetailData videoDetailData, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$videoData = videoDetailData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClassDetailViewModel.this.new AnonymousClass2(this.$videoData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            URL url;
            List<CookieInfoListData> listFilterNotNull;
            String value;
            String domain;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ClassDetailViewModel.this.setVideoDetailData(this.$videoData);
                arrayList = new ArrayList();
                String video_url = this.$videoData.getVideo_url();
                if (video_url == null) {
                    return Unit.INSTANCE;
                }
                try {
                    URL url2 = new URL(video_url);
                    boolean z2 = false;
                    Set of = SetsKt.setOf((Object[]) new String[]{"CloudFront-Key-Pair-Id", "CloudFront-Policy", "CloudFront-Signature"});
                    List<CookieInfoListData> signed_cookie_infos = this.$videoData.getSigned_cookie_infos();
                    if (signed_cookie_infos != null && (listFilterNotNull = CollectionsKt.filterNotNull(signed_cookie_infos)) != null) {
                        for (CookieInfoListData cookieInfoListData : listFilterNotNull) {
                            String name = cookieInfoListData.getName();
                            if (name != null && of.contains(name) && (value = cookieInfoListData.getValue()) != null && (domain = cookieInfoListData.getDomain()) != null) {
                                String path = cookieInfoListData.getPath();
                                if (path == null) {
                                    path = "/";
                                }
                                String str = path;
                                Boolean boolIs_secure = cookieInfoListData.is_secure();
                                boolean zBooleanValue = boolIs_secure != null ? boolIs_secure.booleanValue() : z;
                                Boolean boolIs_http_only = cookieInfoListData.is_http_only();
                                boolean zBooleanValue2 = boolIs_http_only != null ? boolIs_http_only.booleanValue() : z2;
                                HttpCookie httpCookie = new HttpCookie(name, value);
                                httpCookie.setDomain(StringsKt.replace$default(StringsKt.replace$default(domain, "https://", "", false, 4, (Object) null), "http://", "", false, 4, (Object) null));
                                httpCookie.setPath(str);
                                httpCookie.setSecure(zBooleanValue);
                                httpCookie.setHttpOnly(zBooleanValue2);
                                arrayList.add(httpCookie);
                            }
                            z = true;
                            z2 = false;
                        }
                    }
                    String srtURL = VideoUtils.INSTANCE.getSrtURL(this.$videoData);
                    if (srtURL != null) {
                        SrtParser shared = SrtParser.INSTANCE.getShared();
                        this.L$0 = arrayList;
                        this.L$1 = url2;
                        this.label = 1;
                        if (shared.loadSubtitles(srtURL, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    url = url2;
                } catch (MalformedURLException unused) {
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                url = (URL) this.L$1;
                arrayList = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            List list = arrayList;
            ClassDetailViewModel classDetailViewModel = ClassDetailViewModel.this;
            String string = url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            classDetailViewModel.setCookieData(new CookieData(string, list, false, false, 12, null));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiPostFavorite(kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiPostFavorite(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object apiDeleteFavorite(kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            r29 = this;
            r1 = r29
            r0 = r30
            java.lang.String r2 = "網路異常 ("
            boolean r3 = r0 instanceof com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.AnonymousClass1
            if (r3 == 0) goto L1a
            r3 = r0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiDeleteFavorite$1 r3 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L1a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L1f
        L1a:
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiDeleteFavorite$1 r3 = new com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel$apiDeleteFavorite$1
            r3.<init>(r0)
        L1f:
            java.lang.Object r0 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L47
            if (r5 == r7) goto L3f
            if (r5 != r6) goto L37
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L34
            goto Ld2
        L34:
            r0 = move-exception
            goto Lcf
        L37:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L3f:
            java.lang.Object r5 = r3.L$0
            com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r5 = (com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L34
            goto L6d
        L47:
            kotlin.ResultKt.throwOnFailure(r0)
            com.soletreadmills.sole_v2._data.classes.ClassesData r0 = r29.getData()     // Catch: java.lang.Exception -> L34
            if (r0 == 0) goto L56
            java.lang.String r0 = r0.getFavorite_id()     // Catch: java.lang.Exception -> L34
            if (r0 != 0) goto L58
        L56:
            java.lang.String r0 = ""
        L58:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)     // Catch: java.lang.Exception -> L34
            com.soletreadmills.sole_v2._data.classes.DeleteFavoriteRequest$RequestBodyData r5 = new com.soletreadmills.sole_v2._data.classes.DeleteFavoriteRequest$RequestBodyData     // Catch: java.lang.Exception -> L34
            r5.<init>(r0)     // Catch: java.lang.Exception -> L34
            r3.L$0 = r1     // Catch: java.lang.Exception -> L34
            r3.label = r7     // Catch: java.lang.Exception -> L34
            java.lang.Object r0 = com.soletreadmills.sole_v2._network.JwtDyacoApiKt.callDeleteFavorite(r5, r3)     // Catch: java.lang.Exception -> L34
            if (r0 != r4) goto L6c
            return r4
        L6c:
            r5 = r1
        L6d:
            retrofit2.Response r0 = (retrofit2.Response) r0     // Catch: java.lang.Exception -> L34
            boolean r7 = r0.isSuccessful()     // Catch: java.lang.Exception -> L34
            r8 = 0
            if (r7 != 0) goto L9a
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> r5 = r5.errorData     // Catch: java.lang.Exception -> L34
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34
            r7.<init>(r2)     // Catch: java.lang.Exception -> L34
            int r0 = r0.code()     // Catch: java.lang.Exception -> L34
            java.lang.StringBuilder r0 = r7.append(r0)     // Catch: java.lang.Exception -> L34
            r2 = 41
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> L34
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L34
            r3.L$0 = r8     // Catch: java.lang.Exception -> L34
            r3.label = r6     // Catch: java.lang.Exception -> L34
            java.lang.Object r0 = r5.emit(r0, r3)     // Catch: java.lang.Exception -> L34
            if (r0 != r4) goto Ld2
            return r4
        L9a:
            com.soletreadmills.sole_v2._data.classes.ClassesData r6 = r5.getData()     // Catch: java.lang.Exception -> L34
            if (r6 == 0) goto Lcb
            r0 = 0
            java.lang.Boolean r22 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)     // Catch: java.lang.Exception -> L34
            r27 = 1015807(0xf7fff, float:1.423449E-39)
            r28 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            com.soletreadmills.sole_v2._data.classes.ClassesData r8 = com.soletreadmills.sole_v2._data.classes.ClassesData.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)     // Catch: java.lang.Exception -> L34
        Lcb:
            r5.setData(r8)     // Catch: java.lang.Exception -> L34
            goto Ld2
        Lcf:
            r0.printStackTrace()
        Ld2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel.apiDeleteFavorite(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
