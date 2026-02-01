package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterClubAvatarItemBinding extends ViewDataBinding {
    public final CardView cvAvatarWrap;
    public final ImageView imgAvatar;

    protected AdapterClubAvatarItemBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cvAvatarWrap, ImageView imgAvatar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cvAvatarWrap = cvAvatarWrap;
        this.imgAvatar = imgAvatar;
    }

    public static AdapterClubAvatarItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubAvatarItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClubAvatarItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_avatar_item, root, attachToRoot, component);
    }

    public static AdapterClubAvatarItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubAvatarItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClubAvatarItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_club_avatar_item, null, false, component);
    }

    public static AdapterClubAvatarItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClubAvatarItemBinding bind(View view, Object component) {
        return (AdapterClubAvatarItemBinding) bind(component, view, R.layout.adapter_club_avatar_item);
    }
}
