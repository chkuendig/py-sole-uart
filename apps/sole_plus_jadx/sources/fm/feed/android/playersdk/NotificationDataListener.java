package fm.feed.android.playersdk;

import android.graphics.Bitmap;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: Listeners.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lfm/feed/android/playersdk/NotificationDataListener;", "", "onArtWorkChanged", "", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "onNotificationStyleChanged", "onPendingIntentChanged", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface NotificationDataListener {
    void onArtWorkChanged(Bitmap bitmap);

    void onNotificationStyleChanged();

    void onPendingIntentChanged();
}
