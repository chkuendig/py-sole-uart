package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: VideoPlayerView.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aQ\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001aQ\u0010\u0013\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"SubtitleView", "", "subtitle", "", "isVisible", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VideoPlayerAutoPlay", "data", "Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "controller", "Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "onProgressChanged", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "(Lcom/soletreadmills/sole_v2/ui/classes/CookieData;Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "VideoPlayerAutoPlay2", "highlightSubtitle", "Landroidx/compose/ui/text/AnnotatedString;", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "rememberVideoPlayerController", "(Landroidx/compose/runtime/Composer;I)Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPlayerViewKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void VideoPlayerAutoPlay(final com.soletreadmills.sole_v2.ui.classes.CookieData r21, com.soletreadmills.sole_v2.ui.classes.VideoPlayerController r22, androidx.compose.ui.Modifier r23, kotlin.jvm.functions.Function1<? super kotlin.Pair<java.lang.Long, java.lang.Long>, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt.VideoPlayerAutoPlay(com.soletreadmills.sole_v2.ui.classes.CookieData, com.soletreadmills.sole_v2.ui.classes.VideoPlayerController, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* compiled from: VideoPlayerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay$2", f = "VideoPlayerView.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay$2, reason: invalid class name and case insensitive filesystem */
    static final class C09052 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Pair<Long, Long>, Unit> $onProgressChanged;
        final /* synthetic */ ExoPlayer $player;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09052(Function1<? super Pair<Long, Long>, Unit> function1, ExoPlayer exoPlayer, Continuation<? super C09052> continuation) {
            super(2, continuation);
            this.$onProgressChanged = function1;
            this.$player = exoPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09052(this.$onProgressChanged, this.$player, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                Function1<Pair<Long, Long>, Unit> function1 = this.$onProgressChanged;
                if (function1 != null) {
                    function1.invoke(TuplesKt.to(Boxing.boxLong(this.$player.getCurrentPosition()), Boxing.boxLong(this.$player.getDuration())));
                }
                this.label = 1;
            } while (DelayKt.delay(500L, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }

    public static final VideoPlayerController rememberVideoPlayerController(Composer composer, int i) {
        composer.startReplaceGroup(67007445);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(67007445, i, -1, "com.soletreadmills.sole_v2.ui.classes.rememberVideoPlayerController (VideoPlayerView.kt:107)");
        }
        composer.startReplaceGroup(-1390512384);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new VideoPlayerController();
            composer.updateRememberedValue(objRememberedValue);
        }
        VideoPlayerController videoPlayerController = (VideoPlayerController) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return videoPlayerController;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SubtitleView(final java.lang.String r32, boolean r33, androidx.compose.ui.Modifier r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt.SubtitleView(java.lang.String, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final AnnotatedString highlightSubtitle(String subtitle, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        composer.startReplaceGroup(143999030);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(143999030, i, -1, "com.soletreadmills.sole_v2.ui.classes.highlightSubtitle (VideoPlayerView.kt:183)");
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        builder.append(subtitle);
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return annotatedString;
    }

    public static final void VideoPlayerAutoPlay2(final CookieData cookieData, VideoPlayerController videoPlayerController, Modifier modifier, Function1<? super Pair<Long, Long>, Unit> function1, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-563797927);
        VideoPlayerController videoPlayerController2 = (i2 & 2) != 0 ? null : videoPlayerController;
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Function1<? super Pair<Long, Long>, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563797927, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoPlayerAutoPlay2 (VideoPlayerView.kt:262)");
        }
        if (cookieData == null || cookieData.getVideoUrl().length() == 0) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final VideoPlayerController videoPlayerController3 = videoPlayerController2;
                final Modifier modifier3 = modifier2;
                final Function1<? super Pair<Long, Long>, Unit> function13 = function12;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt.VideoPlayerAutoPlay2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        VideoPlayerViewKt.VideoPlayerAutoPlay2(cookieData, videoPlayerController3, modifier3, function13, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        EffectsKt.LaunchedEffect(cookieData.getVideoUrl(), new C09072((Context) objConsume, null), composerStartRestartGroup, 64);
        String videoUrl = cookieData.getVideoUrl();
        composerStartRestartGroup.startReplaceGroup(731112194);
        boolean zChanged = composerStartRestartGroup.changed(videoUrl);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = VideoPlayerHolder.INSTANCE.get();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final ExoPlayer exoPlayer = (ExoPlayer) objRememberedValue;
        composerStartRestartGroup.endReplaceGroup();
        if (exoPlayer == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                final VideoPlayerController videoPlayerController4 = videoPlayerController2;
                final Modifier modifier4 = modifier2;
                final Function1<? super Pair<Long, Long>, Unit> function14 = function12;
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay2$player$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        VideoPlayerViewKt.VideoPlayerAutoPlay2(cookieData, videoPlayerController4, modifier4, function14, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        EffectsKt.LaunchedEffect(exoPlayer, new C09083(function12, exoPlayer, null), composerStartRestartGroup, 72);
        EffectsKt.DisposableEffect(exoPlayer, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt.VideoPlayerAutoPlay2.4
            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                return new DisposableEffectResult() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay2$4$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, composerStartRestartGroup, 56);
        AndroidView_androidKt.AndroidView(new Function1<Context, PlayerView>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt.VideoPlayerAutoPlay2.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PlayerView invoke(Context ctx) {
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                PlayerView playerView = new PlayerView(ctx);
                playerView.setPlayer(exoPlayer);
                playerView.setUseController(false);
                playerView.setResizeMode(0);
                playerView.setBackgroundColor(-16777216);
                return playerView;
            }
        }, SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), null, composerStartRestartGroup, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup3 != null) {
            final VideoPlayerController videoPlayerController5 = videoPlayerController2;
            final Modifier modifier5 = modifier2;
            final Function1<? super Pair<Long, Long>, Unit> function15 = function12;
            scopeUpdateScopeEndRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt.VideoPlayerAutoPlay2.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    VideoPlayerViewKt.VideoPlayerAutoPlay2(cookieData, videoPlayerController5, modifier5, function15, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* compiled from: VideoPlayerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay2$2", f = "VideoPlayerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay2$2, reason: invalid class name and case insensitive filesystem */
    static final class C09072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09072(Context context, Continuation<? super C09072> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09072(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09072) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            VideoPlayerHolder.INSTANCE.initialize(this.$context);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VideoPlayerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay2$3", f = "VideoPlayerView.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoPlayerViewKt$VideoPlayerAutoPlay2$3, reason: invalid class name and case insensitive filesystem */
    static final class C09083 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Pair<Long, Long>, Unit> $onProgressChanged;
        final /* synthetic */ ExoPlayer $player;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09083(Function1<? super Pair<Long, Long>, Unit> function1, ExoPlayer exoPlayer, Continuation<? super C09083> continuation) {
            super(2, continuation);
            this.$onProgressChanged = function1;
            this.$player = exoPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09083(this.$onProgressChanged, this.$player, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09083) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            do {
                Function1<Pair<Long, Long>, Unit> function1 = this.$onProgressChanged;
                if (function1 != null) {
                    function1.invoke(TuplesKt.to(Boxing.boxLong(this.$player.getCurrentPosition()), Boxing.boxLong(this.$player.getDuration())));
                }
                this.label = 1;
            } while (DelayKt.delay(500L, this) != coroutine_suspended);
            return coroutine_suspended;
        }
    }
}
