package com.github.mikephil.charting.utils;

import androidx.camera.video.AudioStats;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* loaded from: classes3.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;
    public double x;
    public double y;

    static {
        ObjectPool<MPPointD> objectPoolCreate = ObjectPool.create(64, new MPPointD(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE));
        pool = objectPoolCreate;
        objectPoolCreate.setReplenishPercentage(0.5f);
    }

    public static MPPointD getInstance(double d, double d2) {
        MPPointD mPPointD = (MPPointD) pool.get();
        mPPointD.x = d;
        mPPointD.y = d2;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        pool.recycle((ObjectPool<MPPointD>) mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        pool.recycle(list);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointD(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    private MPPointD(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public String toString() {
        return "MPPointD, x: " + this.x + ", y: " + this.y;
    }
}
