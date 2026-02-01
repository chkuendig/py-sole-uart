package com.soletreadmills.sole_v2._data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoRefDataVo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/VideoRefDataVo;", "", "classId", "", "className", "classType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/String;", "getClassName", "getClassType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VideoRefDataVo {
    public static final int $stable = 0;

    @SerializedName("classId")
    private final String classId;

    @SerializedName("className")
    private final String className;

    @SerializedName("classType")
    private final String classType;

    public VideoRefDataVo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoRefDataVo copy$default(VideoRefDataVo videoRefDataVo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoRefDataVo.classId;
        }
        if ((i & 2) != 0) {
            str2 = videoRefDataVo.className;
        }
        if ((i & 4) != 0) {
            str3 = videoRefDataVo.classType;
        }
        return videoRefDataVo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClassId() {
        return this.classId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClassType() {
        return this.classType;
    }

    public final VideoRefDataVo copy(String classId, String className, String classType) {
        return new VideoRefDataVo(classId, className, classType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoRefDataVo)) {
            return false;
        }
        VideoRefDataVo videoRefDataVo = (VideoRefDataVo) other;
        return Intrinsics.areEqual(this.classId, videoRefDataVo.classId) && Intrinsics.areEqual(this.className, videoRefDataVo.className) && Intrinsics.areEqual(this.classType, videoRefDataVo.classType);
    }

    public int hashCode() {
        String str = this.classId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.className;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.classType;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "VideoRefDataVo(classId=" + this.classId + ", className=" + this.className + ", classType=" + this.classType + ')';
    }

    public VideoRefDataVo(String str, String str2, String str3) {
        this.classId = str;
        this.className = str2;
        this.classType = str3;
    }

    public /* synthetic */ VideoRefDataVo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getClassType() {
        return this.classType;
    }
}
