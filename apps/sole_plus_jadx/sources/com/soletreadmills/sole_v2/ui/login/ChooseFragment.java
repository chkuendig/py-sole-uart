package com.soletreadmills.sole_v2.ui.login;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.databinding.FragmentChooseBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: ChooseFragment.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/login/ChooseFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentChooseBinding;", "()V", "requestNotificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "checkNotificationPermission", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChooseFragment extends BaseFragment<FragmentChooseBinding> {
    public static final int $stable = 8;
    private final ActivityResultLauncher<String> requestNotificationPermissionLauncher;

    public ChooseFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ChooseFragment.requestNotificationPermissionLauncher$lambda$0(((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.requestNotificationPermissionLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestNotificationPermissionLauncher$lambda$0(boolean z) {
        if (z) {
            Timber.INSTANCE.d("通知權限已授予", new Object[0]);
        } else {
            Timber.INSTANCE.d("通知權限被拒絕", new Object[0]);
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentChooseBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentChooseBinding fragmentChooseBindingInflate = FragmentChooseBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentChooseBindingInflate, "inflate(...)");
        return fragmentChooseBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        final VideoView videoView;
        VideoView videoView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        FragmentChooseBinding binding = getBinding();
        if (binding != null && (linearLayout4 = binding.LLFB) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseFragment.initViews$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentChooseBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout3 = binding2.LLGoogle) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseFragment.initViews$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentChooseBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout2 = binding3.LLLogin) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseFragment.initViews$lambda$3(this.f$0, view);
                }
            });
        }
        FragmentChooseBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.LLSignup) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseFragment.initViews$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentChooseBinding binding5 = getBinding();
        if (binding5 != null && (videoView2 = binding5.videoView) != null) {
            videoView2.start();
        }
        StringBuilder sb = new StringBuilder("android.resource://");
        FragmentActivity activity = getActivity();
        Uri uri = Uri.parse(sb.append(activity != null ? activity.getPackageName() : null).append('/').append(R.raw.sole3_light).toString());
        FragmentChooseBinding binding6 = getBinding();
        if (binding6 != null && (videoView = binding6.videoView) != null) {
            videoView.setVideoURI(uri);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda5
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    ChooseFragment.initViews$lambda$7$lambda$5(videoView, mediaPlayer);
                }
            });
            videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.soletreadmills.sole_v2.ui.login.ChooseFragment$$ExternalSyntheticLambda6
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return ChooseFragment.initViews$lambda$7$lambda$6(mediaPlayer, i, i2);
                }
            });
        }
        FragmentChooseBinding binding7 = getBinding();
        if (binding7 != null) {
            TextView tvTerms = binding7.tvTerms;
            Intrinsics.checkNotNullExpressionValue(tvTerms, "tvTerms");
            setupTermsText(tvTerms);
        }
        checkNotificationPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(ChooseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFbIdAndLoginFB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(ChooseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getGoogleIdAndLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3(ChooseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.loginFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4(ChooseFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.signUpFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7$lambda$5(VideoView this_apply, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        mediaPlayer.setVolume(0.0f, 0.0f);
        mediaPlayer.setLooping(true);
        this_apply.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$7$lambda$6(MediaPlayer mediaPlayer, int i, int i2) {
        Timber.INSTANCE.e("播放影片錯誤", new Object[0]);
        return true;
    }

    private final void checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            Context context = getContext();
            if ((context == null || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) && !shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                this.requestNotificationPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
            }
        }
    }
}
