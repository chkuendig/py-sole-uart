package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: CallbackManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/facebook/CallbackManager;", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Factory", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface CallbackManager {
    boolean onActivityResult(int requestCode, int resultCode, Intent data);

    /* compiled from: CallbackManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/facebook/CallbackManager$Factory;", "", "()V", "create", "Lcom/facebook/CallbackManager;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Factory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @JvmStatic
        public static final CallbackManager create() {
            return new CallbackManagerImpl();
        }
    }
}
