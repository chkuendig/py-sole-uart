package com.soletreadmills.sole_v2.ui.settings;

import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetSubscriptionPlansApiData;
import com.soletreadmills.sole_v2.ui._base.BaseViewModel;
import kotlin.Metadata;

/* compiled from: SettingViewModel.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseViewModel;", "()V", "inBoxMsgData", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "getInBoxMsgData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;", "setInBoxMsgData", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetMessagesApiData$MessageData;)V", "subscriptionPlansData", "Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "getSubscriptionPlansData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;", "setSubscriptionPlansData", "(Lcom/soletreadmills/sole_v2/_data/api/settings/GetSubscriptionPlansApiData$SubscriptionPlansData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingViewModel extends BaseViewModel {
    public static final int $stable = 8;
    private GetMessagesApiData.MessageData inBoxMsgData;
    private GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData;

    public final GetSubscriptionPlansApiData.SubscriptionPlansData getSubscriptionPlansData() {
        return this.subscriptionPlansData;
    }

    public final void setSubscriptionPlansData(GetSubscriptionPlansApiData.SubscriptionPlansData subscriptionPlansData) {
        this.subscriptionPlansData = subscriptionPlansData;
    }

    public final GetMessagesApiData.MessageData getInBoxMsgData() {
        return this.inBoxMsgData;
    }

    public final void setInBoxMsgData(GetMessagesApiData.MessageData messageData) {
        this.inBoxMsgData = messageData;
    }
}
