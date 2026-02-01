package com.soletreadmills.sole_v2._helper.customChart;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.LineChartRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: CustomChartHelper.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004/012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002JR\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\nJ<\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u001a0\u00192\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0015J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0015J:\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00192\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\bJa\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00192\u0012\b\u0002\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00192\b\b\u0002\u0010)\u001a\u00020\u000f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010.\u001a\u00020\n¨\u00063"}, d2 = {"Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper;", "", "()V", "animateProgressTo", "", "chart", "Lcom/github/mikephil/charting/charts/LineChart;", "config", "Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;", "targetX", "", "duration", "", "createConfig", "darkColor", "", "lightColor", "yMinBuffer", "yMaxBuffer", "progressX", "isDragEnabled", "", "isBarHide", "lineWidth", "downsampleIndexed", "", "Lkotlin/Pair;", "data", "maxPoints", "handleChartDrag", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setBarHide", "enabled", "setDragEnabled", "setupChart", "rawLine1", "rawLine2", "updateDataWithDownSample", "rawData1", "rawData2", "maxVisiblePoints", "yMin", "yMax", "(Lcom/github/mikephil/charting/charts/LineChart;Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;Ljava/util/List;Ljava/util/List;ILjava/lang/Float;Ljava/lang/Float;)V", "updateProgress", "x", "Config", "DataSyncCallback", "SyncCallback", "SyncManager", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomChartHelper {
    public static final int $stable = 0;
    public static final CustomChartHelper INSTANCE = new CustomChartHelper();

    /* compiled from: CustomChartHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$DataSyncCallback;", "", "handleChartClick", "", "sourceChart", "Lcom/github/mikephil/charting/charts/LineChart;", "newProgress", "", "onProgressChanged", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DataSyncCallback {
        void handleChartClick(LineChart sourceChart, float newProgress);

        void onProgressChanged(LineChart sourceChart, float newProgress);
    }

    /* compiled from: CustomChartHelper.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncCallback;", "", "onProgressChanged", "", "sourceChart", "Lcom/github/mikephil/charting/charts/LineChart;", "newProgress", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface SyncCallback {
        void onProgressChanged(LineChart sourceChart, float newProgress);
    }

    private CustomChartHelper() {
    }

    /* compiled from: CustomChartHelper.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u0015J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u008b\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001J\u0013\u0010?\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001f\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u001c\"\u0004\b \u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#¨\u0006D"}, d2 = {"Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;", "", "darkColor", "", "lightColor", "yMinBuffer", "", "yMaxBuffer", "progressX", "isDragEnabled", "", "isBarHide", "originalEntries1", "", "Lcom/github/mikephil/charting/data/Entry;", "syncCallback", "Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncCallback;", "isUpdatingFromSync", "dataCallBack", "Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$DataSyncCallback;", "lineWidth", "(IIFFFZZLjava/util/List;Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncCallback;ZLcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$DataSyncCallback;F)V", "getDarkColor", "()I", "getDataCallBack", "()Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$DataSyncCallback;", "setDataCallBack", "(Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$DataSyncCallback;)V", "()Z", "setBarHide", "(Z)V", "setDragEnabled", "setUpdatingFromSync", "getLightColor", "getLineWidth", "()F", "setLineWidth", "(F)V", "getOriginalEntries1", "()Ljava/util/List;", "setOriginalEntries1", "(Ljava/util/List;)V", "getProgressX", "setProgressX", "getSyncCallback", "()Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncCallback;", "setSyncCallback", "(Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncCallback;)V", "getYMaxBuffer", "getYMinBuffer", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Config {
        public static final int $stable = 8;
        private final int darkColor;
        private DataSyncCallback dataCallBack;
        private boolean isBarHide;
        private boolean isDragEnabled;
        private boolean isUpdatingFromSync;
        private final int lightColor;
        private float lineWidth;
        private List<? extends Entry> originalEntries1;
        private float progressX;
        private SyncCallback syncCallback;
        private final float yMaxBuffer;
        private final float yMinBuffer;

        /* renamed from: component1, reason: from getter */
        public final int getDarkColor() {
            return this.darkColor;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsUpdatingFromSync() {
            return this.isUpdatingFromSync;
        }

        /* renamed from: component11, reason: from getter */
        public final DataSyncCallback getDataCallBack() {
            return this.dataCallBack;
        }

        /* renamed from: component12, reason: from getter */
        public final float getLineWidth() {
            return this.lineWidth;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLightColor() {
            return this.lightColor;
        }

        /* renamed from: component3, reason: from getter */
        public final float getYMinBuffer() {
            return this.yMinBuffer;
        }

        /* renamed from: component4, reason: from getter */
        public final float getYMaxBuffer() {
            return this.yMaxBuffer;
        }

        /* renamed from: component5, reason: from getter */
        public final float getProgressX() {
            return this.progressX;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsDragEnabled() {
            return this.isDragEnabled;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsBarHide() {
            return this.isBarHide;
        }

        public final List<Entry> component8() {
            return this.originalEntries1;
        }

        /* renamed from: component9, reason: from getter */
        public final SyncCallback getSyncCallback() {
            return this.syncCallback;
        }

        public final Config copy(int darkColor, int lightColor, float yMinBuffer, float yMaxBuffer, float progressX, boolean isDragEnabled, boolean isBarHide, List<? extends Entry> originalEntries1, SyncCallback syncCallback, boolean isUpdatingFromSync, DataSyncCallback dataCallBack, float lineWidth) {
            Intrinsics.checkNotNullParameter(originalEntries1, "originalEntries1");
            return new Config(darkColor, lightColor, yMinBuffer, yMaxBuffer, progressX, isDragEnabled, isBarHide, originalEntries1, syncCallback, isUpdatingFromSync, dataCallBack, lineWidth);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.darkColor == config.darkColor && this.lightColor == config.lightColor && Float.compare(this.yMinBuffer, config.yMinBuffer) == 0 && Float.compare(this.yMaxBuffer, config.yMaxBuffer) == 0 && Float.compare(this.progressX, config.progressX) == 0 && this.isDragEnabled == config.isDragEnabled && this.isBarHide == config.isBarHide && Intrinsics.areEqual(this.originalEntries1, config.originalEntries1) && Intrinsics.areEqual(this.syncCallback, config.syncCallback) && this.isUpdatingFromSync == config.isUpdatingFromSync && Intrinsics.areEqual(this.dataCallBack, config.dataCallBack) && Float.compare(this.lineWidth, config.lineWidth) == 0;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((Integer.hashCode(this.darkColor) * 31) + Integer.hashCode(this.lightColor)) * 31) + Float.hashCode(this.yMinBuffer)) * 31) + Float.hashCode(this.yMaxBuffer)) * 31) + Float.hashCode(this.progressX)) * 31) + Boolean.hashCode(this.isDragEnabled)) * 31) + Boolean.hashCode(this.isBarHide)) * 31) + this.originalEntries1.hashCode()) * 31;
            SyncCallback syncCallback = this.syncCallback;
            int iHashCode2 = (((iHashCode + (syncCallback == null ? 0 : syncCallback.hashCode())) * 31) + Boolean.hashCode(this.isUpdatingFromSync)) * 31;
            DataSyncCallback dataSyncCallback = this.dataCallBack;
            return ((iHashCode2 + (dataSyncCallback != null ? dataSyncCallback.hashCode() : 0)) * 31) + Float.hashCode(this.lineWidth);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Config(darkColor=");
            sb.append(this.darkColor).append(", lightColor=").append(this.lightColor).append(", yMinBuffer=").append(this.yMinBuffer).append(", yMaxBuffer=").append(this.yMaxBuffer).append(", progressX=").append(this.progressX).append(", isDragEnabled=").append(this.isDragEnabled).append(", isBarHide=").append(this.isBarHide).append(", originalEntries1=").append(this.originalEntries1).append(", syncCallback=").append(this.syncCallback).append(", isUpdatingFromSync=").append(this.isUpdatingFromSync).append(", dataCallBack=").append(this.dataCallBack).append(", lineWidth=");
            sb.append(this.lineWidth).append(')');
            return sb.toString();
        }

        public Config(int i, int i2, float f, float f2, float f3, boolean z, boolean z2, List<? extends Entry> originalEntries1, SyncCallback syncCallback, boolean z3, DataSyncCallback dataSyncCallback, float f4) {
            Intrinsics.checkNotNullParameter(originalEntries1, "originalEntries1");
            this.darkColor = i;
            this.lightColor = i2;
            this.yMinBuffer = f;
            this.yMaxBuffer = f2;
            this.progressX = f3;
            this.isDragEnabled = z;
            this.isBarHide = z2;
            this.originalEntries1 = originalEntries1;
            this.syncCallback = syncCallback;
            this.isUpdatingFromSync = z3;
            this.dataCallBack = dataSyncCallback;
            this.lineWidth = f4;
        }

        public final int getDarkColor() {
            return this.darkColor;
        }

        public final int getLightColor() {
            return this.lightColor;
        }

        public final float getYMinBuffer() {
            return this.yMinBuffer;
        }

        public final float getYMaxBuffer() {
            return this.yMaxBuffer;
        }

        public final float getProgressX() {
            return this.progressX;
        }

        public final void setProgressX(float f) {
            this.progressX = f;
        }

        public final boolean isDragEnabled() {
            return this.isDragEnabled;
        }

        public final void setDragEnabled(boolean z) {
            this.isDragEnabled = z;
        }

        public final boolean isBarHide() {
            return this.isBarHide;
        }

        public final void setBarHide(boolean z) {
            this.isBarHide = z;
        }

        public /* synthetic */ Config(int i, int i2, float f, float f2, float f3, boolean z, boolean z2, List list, SyncCallback syncCallback, boolean z3, DataSyncCallback dataSyncCallback, float f4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? 1.0f : f, (i3 & 8) != 0 ? 1.0f : f2, (i3 & 16) != 0 ? 0.0f : f3, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? CollectionsKt.emptyList() : list, (i3 & 256) != 0 ? null : syncCallback, (i3 & 512) != 0 ? false : z3, (i3 & 1024) != 0 ? null : dataSyncCallback, (i3 & 2048) != 0 ? 2.5f : f4);
        }

        public final List<Entry> getOriginalEntries1() {
            return this.originalEntries1;
        }

        public final void setOriginalEntries1(List<? extends Entry> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.originalEntries1 = list;
        }

        public final SyncCallback getSyncCallback() {
            return this.syncCallback;
        }

        public final void setSyncCallback(SyncCallback syncCallback) {
            this.syncCallback = syncCallback;
        }

        public final boolean isUpdatingFromSync() {
            return this.isUpdatingFromSync;
        }

        public final void setUpdatingFromSync(boolean z) {
            this.isUpdatingFromSync = z;
        }

        public final DataSyncCallback getDataCallBack() {
            return this.dataCallBack;
        }

        public final void setDataCallBack(DataSyncCallback dataSyncCallback) {
            this.dataCallBack = dataSyncCallback;
        }

        public final float getLineWidth() {
            return this.lineWidth;
        }

        public final void setLineWidth(float f) {
            this.lineWidth = f;
        }
    }

    /* compiled from: CustomChartHelper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0010H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncManager;", "", "()V", "chartConfigs", "", "Lcom/github/mikephil/charting/charts/LineChart;", "Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$Config;", "getChartConfigs", "()Ljava/util/Map;", "addChart", "", "chart", "config", "removeChart", "setAllProgress", "progress", "", "syncAllCharts", "sourceChart", "newProgress", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SyncManager {
        public static final int $stable = 8;
        private final Map<LineChart, Config> chartConfigs = new LinkedHashMap();

        public final Map<LineChart, Config> getChartConfigs() {
            return this.chartConfigs;
        }

        public final void addChart(LineChart chart, final Config config) {
            Intrinsics.checkNotNullParameter(chart, "chart");
            Intrinsics.checkNotNullParameter(config, "config");
            this.chartConfigs.put(chart, config);
            config.setSyncCallback(new SyncCallback() { // from class: com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper$SyncManager$addChart$1
                @Override // com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper.SyncCallback
                public void onProgressChanged(LineChart sourceChart, float newProgress) {
                    Intrinsics.checkNotNullParameter(sourceChart, "sourceChart");
                    this.this$0.syncAllCharts(sourceChart, newProgress);
                    CustomChartHelper.DataSyncCallback dataCallBack = config.getDataCallBack();
                    if (dataCallBack != null) {
                        dataCallBack.onProgressChanged(sourceChart, newProgress);
                    }
                }
            });
        }

        public final void removeChart(LineChart chart) {
            Intrinsics.checkNotNullParameter(chart, "chart");
            this.chartConfigs.remove(chart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void syncAllCharts(LineChart sourceChart, float newProgress) {
            for (Map.Entry<LineChart, Config> entry : this.chartConfigs.entrySet()) {
                LineChart key = entry.getKey();
                Config value = entry.getValue();
                if (!Intrinsics.areEqual(key, sourceChart) && !value.isUpdatingFromSync()) {
                    float fMin = (float) Math.min(newProgress, ((Entry) CollectionsKt.lastOrNull((List) value.getOriginalEntries1())) != null ? r3.getX() : newProgress);
                    value.setUpdatingFromSync(true);
                    value.setProgressX(fMin);
                    key.invalidate();
                    value.setUpdatingFromSync(false);
                    DataSyncCallback dataCallBack = value.getDataCallBack();
                    if (dataCallBack != null) {
                        dataCallBack.onProgressChanged(sourceChart, newProgress);
                    }
                }
            }
        }

        public final void setAllProgress(float progress) {
            for (Map.Entry<LineChart, Config> entry : this.chartConfigs.entrySet()) {
                LineChart key = entry.getKey();
                Config value = entry.getValue();
                float fMin = (float) Math.min(progress, ((Entry) CollectionsKt.lastOrNull((List) value.getOriginalEntries1())) != null ? r3.getX() : progress);
                value.setUpdatingFromSync(true);
                value.setProgressX(fMin);
                key.invalidate();
                value.setUpdatingFromSync(false);
            }
        }
    }

    public final Config createConfig(int darkColor, int lightColor, float yMinBuffer, float yMaxBuffer, float progressX, boolean isDragEnabled, boolean isBarHide, float lineWidth) {
        return new Config(darkColor, lightColor, yMinBuffer, yMaxBuffer, progressX, isDragEnabled, isBarHide, CollectionsKt.emptyList(), null, false, null, lineWidth, WinError.ERROR_NETLOGON_NOT_STARTED, null);
    }

    public final void setupChart(final LineChart chart, List<Float> rawLine1, List<Float> rawLine2, final Config config) {
        ArrayList arrayListEmptyList;
        ArrayList arrayListEmptyList2;
        List listPlus;
        Float fValueOf;
        Float fValueOf2;
        Intrinsics.checkNotNullParameter(chart, "chart");
        Intrinsics.checkNotNullParameter(config, "config");
        if (rawLine1 == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : rawLine1) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Float f = (Float) obj;
                Entry entry = f != null ? new Entry(i, f.floatValue()) : null;
                if (entry != null) {
                    arrayList.add(entry);
                }
                i = i2;
            }
            arrayListEmptyList = arrayList;
        }
        if (rawLine2 == null) {
            arrayListEmptyList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (Object obj2 : rawLine2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Float f2 = (Float) obj2;
                Entry entry2 = f2 != null ? new Entry(i3, f2.floatValue()) : null;
                if (entry2 != null) {
                    arrayList2.add(entry2);
                }
                i3 = i4;
            }
            arrayListEmptyList2 = arrayList2;
        }
        config.setOriginalEntries1(arrayListEmptyList);
        Entry entry3 = (Entry) CollectionsKt.lastOrNull((List) arrayListEmptyList);
        float x = entry3 != null ? entry3.getX() : 0.0f;
        Entry entry4 = (Entry) CollectionsKt.lastOrNull(arrayListEmptyList2);
        float x2 = entry4 != null ? entry4.getX() : 0.0f;
        float fMax = Math.max(x, x2);
        List list = arrayListEmptyList2;
        List listListOf = !list.isEmpty() ? arrayListEmptyList2 : CollectionsKt.listOf((Object[]) new Entry[]{new Entry(0.0f, 0.0f), new Entry(fMax, 0.0f)});
        if (list.isEmpty() || x2 >= x) {
            listPlus = arrayListEmptyList2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            int i5 = ((int) x2) + 1;
            int i6 = (int) x;
            if (i5 <= i6) {
                while (true) {
                    Entry entry5 = (Entry) CollectionsKt.lastOrNull(arrayListEmptyList2);
                    arrayList3.add(new Entry(i5, entry5 != null ? entry5.getY() : 0.0f));
                    if (i5 == i6) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            listPlus = CollectionsKt.plus((Collection) list, (Iterable) arrayList3);
        }
        List list2 = listPlus;
        if (!list2.isEmpty()) {
            listListOf = list2;
        }
        LineDataSet lineDataSet = new LineDataSet(listListOf, "Light");
        lineDataSet.setColor(listPlus.isEmpty() ? 0 : config.getLightColor());
        lineDataSet.setDrawCircles(false);
        lineDataSet.setLineWidth(config.getLineWidth());
        lineDataSet.setDrawValues(false);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR);
        lineDataSet.setCubicIntensity(0.5f);
        chart.setData(new LineData(lineDataSet));
        List listPlus2 = CollectionsKt.plus((Collection) arrayListEmptyList, (Iterable) arrayListEmptyList2);
        Iterator it = listPlus2.iterator();
        if (it.hasNext()) {
            float y = ((Entry) it.next()).getY();
            while (it.hasNext()) {
                y = Math.max(y, ((Entry) it.next()).getY());
            }
            fValueOf = Float.valueOf(y);
        } else {
            fValueOf = null;
        }
        float fFloatValue = fValueOf != null ? fValueOf.floatValue() : 0.0f;
        Iterator it2 = listPlus2.iterator();
        if (it2.hasNext()) {
            float y2 = ((Entry) it2.next()).getY();
            while (it2.hasNext()) {
                y2 = Math.min(y2, ((Entry) it2.next()).getY());
            }
            fValueOf2 = Float.valueOf(y2);
        } else {
            fValueOf2 = null;
        }
        float fFloatValue2 = fValueOf2 != null ? fValueOf2.floatValue() : 0.0f;
        chart.getAxisLeft().setAxisMaximum(fFloatValue + config.getYMaxBuffer());
        chart.getAxisLeft().setAxisMinimum(fFloatValue2 - config.getYMinBuffer());
        chart.getXAxis().setDrawLabels(false);
        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawAxisLine(false);
        chart.getAxisLeft().setDrawAxisLine(false);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDragEnabled(true);
        chart.setTouchEnabled(true);
        chart.setDragDecelerationEnabled(false);
        chart.setScaleEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setPinchZoom(false);
        chart.setViewPortOffsets(16.0f, 16.0f, 16.0f, 16.0f);
        chart.setVisibleXRangeMaximum(20.0f);
        chart.getXAxis().setAxisMaximum(fMax);
        chart.getXAxis().setAxisMinimum(0.0f);
        chart.setRenderer(new LineChartRenderer(config, chart.getAnimator(), chart.getViewPortHandler()) { // from class: com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper.setupChart.2
            final /* synthetic */ Config $config;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.$chart, chartAnimator, viewPortHandler);
                this.$config = config;
            }

            @Override // com.github.mikephil.charting.renderer.LineChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
            public void drawData(Canvas c) {
                Intrinsics.checkNotNullParameter(c, "c");
                super.drawData(c);
                drawTruncatedDarkLine(c, this.$config);
            }

            @Override // com.github.mikephil.charting.renderer.LineChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
            public void drawExtras(Canvas c) {
                Intrinsics.checkNotNullParameter(c, "c");
                super.drawExtras(c);
                int iSave = c.save();
                drawAuxiliaryLines(c, this.$config);
                c.restoreToCount(iSave);
            }

            private final void drawTruncatedDarkLine(Canvas c, Config config2) {
                Object next;
                List<Entry> originalEntries1 = config2.getOriginalEntries1();
                if (originalEntries1.isEmpty()) {
                    return;
                }
                Transformer transformer = this.$chart.getTransformer(YAxis.AxisDependency.LEFT);
                Path path = new Path();
                List<Entry> list3 = originalEntries1;
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : list3) {
                    if (((Entry) obj3).getX() <= config2.getProgressX()) {
                        arrayList4.add(obj3);
                    }
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5.isEmpty()) {
                    return;
                }
                int i7 = 0;
                for (Object obj4 : arrayList5) {
                    int i8 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Entry entry6 = (Entry) obj4;
                    MPPointD pixelForValues = transformer.getPixelForValues(entry6.getX(), entry6.getY());
                    if (i7 == 0) {
                        path.moveTo((float) pixelForValues.x, (float) pixelForValues.y);
                    } else {
                        path.lineTo((float) pixelForValues.x, (float) pixelForValues.y);
                    }
                    i7 = i8;
                }
                Entry entry7 = (Entry) CollectionsKt.lastOrNull((List) arrayList5);
                Iterator<T> it3 = list3.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        next = it3.next();
                        if (((Entry) next).getX() > config2.getProgressX()) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                Entry entry8 = (Entry) next;
                if (entry7 != null && entry8 != null && config2.getProgressX() > entry7.getX()) {
                    MPPointD pixelForValues2 = transformer.getPixelForValues(config2.getProgressX(), entry7.getY() + (((config2.getProgressX() - entry7.getX()) / (entry8.getX() - entry7.getX())) * (entry8.getY() - entry7.getY())));
                    path.lineTo((float) pixelForValues2.x, (float) pixelForValues2.y);
                }
                LineData lineData = (LineData) this.$chart.getData();
                ILineDataSet iLineDataSet = lineData != null ? (ILineDataSet) lineData.getDataSetByLabel("Light", true) : null;
                float lineWidth = iLineDataSet != null ? iLineDataSet.getLineWidth() : config2.getLineWidth();
                Paint paint = new Paint();
                paint.setColor(config2.getDarkColor());
                paint.setStrokeWidth(lineWidth);
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setStrokeJoin(Paint.Join.ROUND);
                paint.setStrokeCap(Paint.Cap.ROUND);
                c.drawPath(path, paint);
            }

            private final void drawAuxiliaryLines(Canvas c, Config config2) {
                Transformer transformer = this.$chart.getTransformer(YAxis.AxisDependency.LEFT);
                double d = transformer.getPixelForValues(config2.getProgressX(), 0.0f).x;
                float axisMaximum = this.$chart.getAxisLeft().getAxisMaximum();
                float axisMinimum = this.$chart.getAxisLeft().getAxisMinimum();
                float f3 = (float) transformer.getPixelForValues(0.0f, axisMaximum).y;
                float f4 = (float) transformer.getPixelForValues(0.0f, axisMinimum).y;
                c.save();
                Paint paint = new Paint();
                paint.setColor(ContextCompat.getColor(MyApplication.INSTANCE.getAppContext(), R.color.colorLabel_outline));
                paint.setStrokeWidth(2.0f);
                paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
                c.drawLine(this.$chart.getViewPortHandler().contentLeft(), f3, this.$chart.getViewPortHandler().contentRight(), f3, paint);
                c.drawLine(this.$chart.getViewPortHandler().contentLeft(), f4, this.$chart.getViewPortHandler().contentRight(), f4, paint);
                if (!config2.isBarHide()) {
                    Paint paint2 = new Paint();
                    paint2.setColor(ContextCompat.getColor(MyApplication.INSTANCE.getAppContext(), R.color.colorGlobal_black));
                    paint2.setStrokeWidth(4.0f);
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setAntiAlias(true);
                    float f5 = (float) d;
                    float f6 = f3 + 8.0f;
                    float f7 = f4 - 8.0f;
                    c.drawLine(f5, f6, f5, f7, paint2);
                    Paint paint3 = new Paint();
                    paint3.setColor(ContextCompat.getColor(MyApplication.INSTANCE.getAppContext(), R.color.colorGlobal_black));
                    paint3.setStyle(Paint.Style.FILL);
                    paint3.setAntiAlias(true);
                    c.drawCircle(f5, f6, 8.0f, paint3);
                    c.drawCircle(f5, f7, 8.0f, paint3);
                }
                c.restore();
            }
        });
        chart.setOnTouchListener(new View.OnTouchListener() { // from class: com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CustomChartHelper.setupChart$lambda$10(config, chart, view, motionEvent);
            }
        });
        chart.setHighlightPerTapEnabled(false);
        chart.setHighlightPerDragEnabled(false);
        Entry entry6 = (Entry) CollectionsKt.lastOrNull((List) arrayListEmptyList);
        final float x3 = entry6 != null ? entry6.getX() : 0.0f;
        chart.post(new Runnable() { // from class: com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CustomChartHelper.setupChart$lambda$11(chart, config, x3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupChart$lambda$10(Config config, LineChart chart, View view, MotionEvent motionEvent) {
        Triple triple;
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(chart, "$chart");
        if (!config.isDragEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                Object tag = chart.getTag();
                triple = tag instanceof Triple ? (Triple) tag : null;
                if (triple != null) {
                    long jLongValue = ((Number) triple.component1()).longValue();
                    float fFloatValue = ((Number) triple.component2()).floatValue();
                    float fFloatValue2 = ((Number) triple.component3()).floatValue();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    float fSqrt = (float) Math.sqrt(((motionEvent.getX() - fFloatValue) * (motionEvent.getX() - fFloatValue)) + ((motionEvent.getY() - fFloatValue2) * (motionEvent.getY() - fFloatValue2)));
                    if (jCurrentTimeMillis < 300 && fSqrt < 30.0f) {
                        double d = chart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(motionEvent.getX(), motionEvent.getY()).x;
                        Entry entry = (Entry) CollectionsKt.lastOrNull((List) config.getOriginalEntries1());
                        double dCoerceIn = RangesKt.coerceIn(d, AudioStats.AUDIO_AMPLITUDE_NONE, (entry != null ? Float.valueOf(entry.getX()) : Double.valueOf(d)).doubleValue());
                        DataSyncCallback dataCallBack = config.getDataCallBack();
                        if (dataCallBack != null) {
                            dataCallBack.handleChartClick(chart, (float) dCoerceIn);
                        }
                    }
                }
            } else if (action == 2) {
                Object tag2 = chart.getTag();
                triple = tag2 instanceof Triple ? (Triple) tag2 : null;
                if (triple == null) {
                    return false;
                }
                float fFloatValue3 = ((Number) triple.component1()).floatValue();
                float fFloatValue4 = ((Number) triple.component2()).floatValue();
                float fAbs = Math.abs(motionEvent.getX() - fFloatValue3);
                float fAbs2 = Math.abs(motionEvent.getY() - fFloatValue4);
                if (fAbs > fAbs2 * 1.2d && fAbs > 10.0f) {
                    ViewParent parent = chart.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!config.isUpdatingFromSync()) {
                        CustomChartHelper customChartHelper = INSTANCE;
                        Intrinsics.checkNotNull(motionEvent);
                        customChartHelper.handleChartDrag(chart, motionEvent, config);
                    }
                } else if (fAbs2 > 10.0f) {
                    ViewParent parent2 = chart.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
            }
        } else {
            chart.setTag(new Triple(Long.valueOf(System.currentTimeMillis()), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY())));
            CustomChartHelper customChartHelper2 = INSTANCE;
            Intrinsics.checkNotNull(motionEvent);
            customChartHelper2.handleChartDrag(chart, motionEvent, config);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupChart$lambda$11(LineChart chart, Config config, float f) {
        Intrinsics.checkNotNullParameter(chart, "$chart");
        Intrinsics.checkNotNullParameter(config, "$config");
        chart.fitScreen();
        Entry entry = (Entry) CollectionsKt.lastOrNull((List) config.getOriginalEntries1());
        float x = entry != null ? entry.getX() : 0.0f;
        config.setProgressX(x);
        chart.moveViewToX(Math.max(0.0f, (x - 20.0f) + 1.0f));
        INSTANCE.animateProgressTo(chart, config, f, 800L);
    }

    private final void handleChartDrag(LineChart chart, MotionEvent event, Config config) {
        if (config.isUpdatingFromSync()) {
            return;
        }
        float fCoerceIn = (float) RangesKt.coerceIn(chart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(event.getX(), event.getY()).x, 0.0f, Math.max(0.0f, ((Entry) CollectionsKt.lastOrNull((List) config.getOriginalEntries1())) != null ? r8.getX() : 0.0f));
        config.setProgressX(fCoerceIn);
        chart.invalidate();
        SyncCallback syncCallback = config.getSyncCallback();
        if (syncCallback != null) {
            syncCallback.onProgressChanged(chart, fCoerceIn);
        }
    }

    public final void updateProgress(LineChart chart, Config config, float x) {
        Intrinsics.checkNotNullParameter(chart, "chart");
        Intrinsics.checkNotNullParameter(config, "config");
        config.setProgressX(x);
        chart.invalidate();
    }

    public final void setDragEnabled(Config config, boolean enabled) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setDragEnabled(enabled);
    }

    public final void setBarHide(Config config, boolean enabled) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.setBarHide(enabled);
    }

    static /* synthetic */ void animateProgressTo$default(CustomChartHelper customChartHelper, LineChart lineChart, Config config, float f, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 300;
        }
        customChartHelper.animateProgressTo(lineChart, config, f, j);
    }

    private final void animateProgressTo(final LineChart chart, final Config config, float targetX, long duration) {
        float progressX = config.getProgressX();
        Entry entry = (Entry) CollectionsKt.lastOrNull((List) config.getOriginalEntries1());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(progressX, RangesKt.coerceIn(targetX, 0.0f, entry != null ? entry.getX() : targetX));
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CustomChartHelper.animateProgressTo$lambda$13$lambda$12(config, chart, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateProgressTo$lambda$13$lambda$12(Config config, LineChart chart, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(chart, "$chart");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        config.setProgressX(fFloatValue);
        chart.invalidate();
        chart.moveViewToX(Math.max(0.0f, (fFloatValue - 20.0f) + 1.0f));
    }

    public final void updateDataWithDownSample(final LineChart chart, final Config config, List<Float> rawData1, List<Float> rawData2, int maxVisiblePoints, Float yMin, Float yMax) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(chart, "chart");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(rawData1, "rawData1");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawData1.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Float f = (Float) next;
            Pair pair = f != null ? TuplesKt.to(Integer.valueOf(i), Float.valueOf(f.floatValue())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        if (rawData2 == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList();
            int i3 = 0;
            for (Object obj : rawData2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Float f2 = (Float) obj;
                Pair pair2 = f2 != null ? TuplesKt.to(Integer.valueOf(i3), Float.valueOf(f2.floatValue())) : null;
                if (pair2 != null) {
                    arrayList3.add(pair2);
                }
                i3 = i4;
            }
            arrayListEmptyList = arrayList3;
        }
        List<Pair<Integer, Float>> listDownsampleIndexed = downsampleIndexed(arrayList2, maxVisiblePoints);
        List<Pair<Integer, Float>> listDownsampleIndexed2 = downsampleIndexed(arrayListEmptyList, maxVisiblePoints);
        List<Pair<Integer, Float>> list = listDownsampleIndexed;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(new Entry(((Number) r8.getFirst()).intValue(), ((Number) ((Pair) it2.next()).getSecond()).floatValue()));
        }
        final ArrayList arrayList5 = arrayList4;
        List<Pair<Integer, Float>> list2 = listDownsampleIndexed2;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it3 = list2.iterator();
        while (it3.hasNext()) {
            arrayList6.add(new Entry(((Number) r3.getFirst()).intValue(), ((Number) ((Pair) it3.next()).getSecond()).floatValue()));
        }
        ArrayList arrayList7 = arrayList6;
        config.setOriginalEntries1(arrayList5);
        LineDataSet lineDataSet = new LineDataSet(arrayList7, "Light");
        lineDataSet.setColor(config.getLightColor());
        lineDataSet.setDrawCircles(false);
        lineDataSet.setLineWidth(config.getLineWidth());
        lineDataSet.setDrawValues(false);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR);
        lineDataSet.setCubicIntensity(0.5f);
        chart.setData(!arrayList7.isEmpty() ? new LineData(lineDataSet) : new LineData());
        if (yMin != null && yMax != null) {
            chart.getAxisLeft().setAxisMaximum(yMax.floatValue() + config.getYMaxBuffer());
            chart.getAxisLeft().setAxisMinimum(yMin.floatValue() - config.getYMinBuffer());
        } else {
            List listPlus = CollectionsKt.plus((Collection) arrayList5, (Iterable) arrayList7);
            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPlus, 10));
            Iterator it4 = listPlus.iterator();
            while (it4.hasNext()) {
                arrayList8.add(Float.valueOf(((Entry) it4.next()).getY()));
            }
            YAxis axisLeft = chart.getAxisLeft();
            ArrayList arrayList9 = arrayList8;
            Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) arrayList9);
            axisLeft.setAxisMaximum((fMaxOrNull != null ? fMaxOrNull.floatValue() : 0.0f) + config.getYMaxBuffer());
            YAxis axisLeft2 = chart.getAxisLeft();
            Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) arrayList9);
            axisLeft2.setAxisMinimum((fMinOrNull != null ? fMinOrNull.floatValue() : 0.0f) - config.getYMinBuffer());
        }
        Entry entry = (Entry) CollectionsKt.lastOrNull((List) arrayList5);
        float x = entry != null ? entry.getX() : 0.0f;
        Entry entry2 = (Entry) CollectionsKt.lastOrNull((List) arrayList7);
        final float fMax = Math.max(x, entry2 != null ? entry2.getX() : 0.0f);
        chart.getXAxis().setAxisMaximum(fMax);
        chart.getXAxis().setAxisMinimum(0.0f);
        Entry entry3 = (Entry) CollectionsKt.lastOrNull((List) arrayList5);
        final float x2 = entry3 != null ? entry3.getX() : 0.0f;
        config.setProgressX(config.getProgressX());
        chart.post(new Runnable() { // from class: com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CustomChartHelper.updateDataWithDownSample$lambda$22(chart, fMax, arrayList5, config, x2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDataWithDownSample$lambda$22(LineChart chart, float f, List entries1, Config config, float f2) {
        Intrinsics.checkNotNullParameter(chart, "$chart");
        Intrinsics.checkNotNullParameter(entries1, "$entries1");
        Intrinsics.checkNotNullParameter(config, "$config");
        chart.notifyDataSetChanged();
        chart.setVisibleXRangeMaximum(f);
        chart.fitScreen();
        INSTANCE.animateProgressTo(chart, config, f2, entries1.size() > 1000 ? 0L : 800L);
    }

    private final List<Pair<Integer, Float>> downsampleIndexed(List<Pair<Integer, Float>> data, int maxPoints) {
        if (data.size() <= maxPoints) {
            return data;
        }
        float size = data.size() / maxPoints;
        IntRange intRangeUntil = RangesKt.until(0, maxPoints);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            int i = (int) (iNextInt * size);
            int iMin = Math.min((int) ((iNextInt + 1) * size), data.size());
            Object next = null;
            if (i < iMin) {
                List<Pair<Integer, Float>> listSubList = data.subList(i, iMin);
                if (iNextInt % 2 == 0) {
                    Iterator<T> it2 = listSubList.iterator();
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (it2.hasNext()) {
                            float fFloatValue = ((Number) ((Pair) next).getSecond()).floatValue();
                            do {
                                Object next2 = it2.next();
                                float fFloatValue2 = ((Number) ((Pair) next2).getSecond()).floatValue();
                                if (Float.compare(fFloatValue, fFloatValue2) < 0) {
                                    next = next2;
                                    fFloatValue = fFloatValue2;
                                }
                            } while (it2.hasNext());
                        }
                    }
                    next = (Pair) next;
                } else {
                    Iterator<T> it3 = listSubList.iterator();
                    if (it3.hasNext()) {
                        next = it3.next();
                        if (it3.hasNext()) {
                            float fFloatValue3 = ((Number) ((Pair) next).getSecond()).floatValue();
                            do {
                                Object next3 = it3.next();
                                float fFloatValue4 = ((Number) ((Pair) next3).getSecond()).floatValue();
                                if (Float.compare(fFloatValue3, fFloatValue4) > 0) {
                                    next = next3;
                                    fFloatValue3 = fFloatValue4;
                                }
                            } while (it3.hasNext());
                        }
                    }
                    next = (Pair) next;
                }
            }
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
