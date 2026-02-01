package com.soletreadmills.sole_v2._data.api.classes;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassInstructorsApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData;", "", "()V", "ClassInstructorsData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetClassInstructorsApiData {
    public static final int $stable = 0;

    /* compiled from: GetClassInstructorsApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "dataMap", "", "Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;", "getDataMap", "()Ljava/util/List;", "setDataMap", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 8;

        @SerializedName("sys_response_data")
        private List<ClassInstructorsData> dataMap;

        public final List<ClassInstructorsData> getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(List<ClassInstructorsData> list) {
            this.dataMap = list;
        }
    }

    /* compiled from: GetClassInstructorsApiData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/classes/GetClassInstructorsApiData$ClassInstructorsData;", "", "avatar_url", "", "instructor_id", "instructor_name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar_url", "()Ljava/lang/String;", "setAvatar_url", "(Ljava/lang/String;)V", "getInstructor_id", "setInstructor_id", "getInstructor_name", "setInstructor_name", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ClassInstructorsData {
        public static final int $stable = 8;
        private String avatar_url;
        private String instructor_id;
        private String instructor_name;

        public static /* synthetic */ ClassInstructorsData copy$default(ClassInstructorsData classInstructorsData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = classInstructorsData.avatar_url;
            }
            if ((i & 2) != 0) {
                str2 = classInstructorsData.instructor_id;
            }
            if ((i & 4) != 0) {
                str3 = classInstructorsData.instructor_name;
            }
            return classInstructorsData.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAvatar_url() {
            return this.avatar_url;
        }

        /* renamed from: component2, reason: from getter */
        public final String getInstructor_id() {
            return this.instructor_id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getInstructor_name() {
            return this.instructor_name;
        }

        public final ClassInstructorsData copy(String avatar_url, String instructor_id, String instructor_name) {
            return new ClassInstructorsData(avatar_url, instructor_id, instructor_name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClassInstructorsData)) {
                return false;
            }
            ClassInstructorsData classInstructorsData = (ClassInstructorsData) other;
            return Intrinsics.areEqual(this.avatar_url, classInstructorsData.avatar_url) && Intrinsics.areEqual(this.instructor_id, classInstructorsData.instructor_id) && Intrinsics.areEqual(this.instructor_name, classInstructorsData.instructor_name);
        }

        public int hashCode() {
            String str = this.avatar_url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.instructor_id;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.instructor_name;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "ClassInstructorsData(avatar_url=" + this.avatar_url + ", instructor_id=" + this.instructor_id + ", instructor_name=" + this.instructor_name + ')';
        }

        public ClassInstructorsData(String str, String str2, String str3) {
            this.avatar_url = str;
            this.instructor_id = str2;
            this.instructor_name = str3;
        }

        public final String getAvatar_url() {
            return this.avatar_url;
        }

        public final void setAvatar_url(String str) {
            this.avatar_url = str;
        }

        public final String getInstructor_id() {
            return this.instructor_id;
        }

        public final void setInstructor_id(String str) {
            this.instructor_id = str;
        }

        public final String getInstructor_name() {
            return this.instructor_name;
        }

        public final void setInstructor_name(String str) {
            this.instructor_name = str;
        }
    }
}
