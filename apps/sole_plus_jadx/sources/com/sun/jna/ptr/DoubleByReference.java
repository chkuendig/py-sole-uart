package com.sun.jna.ptr;

import androidx.camera.video.AudioStats;
import com.sun.jna.Pointer;

/* loaded from: classes4.dex */
public class DoubleByReference extends ByReference {
    public DoubleByReference() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public DoubleByReference(double d) {
        super(8);
        setValue(d);
    }

    public void setValue(double d) {
        getPointer().setDouble(0L, d);
    }

    public double getValue() {
        return getPointer().getDouble(0L);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("double@0x%x=%s", Long.valueOf(Pointer.nativeValue(getPointer())), Double.valueOf(getValue()));
    }
}
