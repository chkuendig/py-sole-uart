package com.dyaco.sole.custom_view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* loaded from: classes.dex */
public class MyEditText extends EditText {
    private EditTextImeBackListener mOnImeBack;

    public interface EditTextImeBackListener {
        void onImeBack(KeyEvent keyEvent, String str);
    }

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTypeface(Context context, String str, int i) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), str), i);
    }

    public void setTypeface(Context context, String str) {
        setTypeface(context, str, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        EditTextImeBackListener editTextImeBackListener;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && (editTextImeBackListener = this.mOnImeBack) != null) {
            editTextImeBackListener.onImeBack(keyEvent, getText().toString());
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }

    public void showSoftInput(Context context, EditText editText, IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 1);
        }
    }

    public void hideSoftInput(Context context, IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 0);
        }
    }

    public void setOnEditTextImeBackListener(EditTextImeBackListener editTextImeBackListener) {
        this.mOnImeBack = editTextImeBackListener;
    }
}
