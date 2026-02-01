package com.android.support;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentTagUtil.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/android/support/FragmentTagUtil;", "", "()V", "isFragmentTag", "", "name", "", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FragmentTagUtil {
    public static final FragmentTagUtil INSTANCE = new FragmentTagUtil();

    private FragmentTagUtil() {
    }

    @JvmStatic
    public static final boolean isFragmentTag(String name) {
        return name != null && (Intrinsics.areEqual("fragment", name) || Intrinsics.areEqual("androidx.fragment.app.FragmentContainerView", name));
    }
}
