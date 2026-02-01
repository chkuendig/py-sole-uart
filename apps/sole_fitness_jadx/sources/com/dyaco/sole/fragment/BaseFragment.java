package com.dyaco.sole.fragment;

import android.app.Fragment;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment {
    protected abstract void findViews();

    protected abstract void initParams();

    protected abstract void setListeners();

    @Override // android.app.Fragment
    public void onDetach() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super.onDetach();
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
