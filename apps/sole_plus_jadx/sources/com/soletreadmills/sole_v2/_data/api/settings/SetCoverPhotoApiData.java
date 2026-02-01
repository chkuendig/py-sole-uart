package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetCoverPhotoApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SetCoverPhotoApiData {
    public static final int $stable = 0;

    /* compiled from: SetCoverPhotoApiData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$RequestBodyData;", "", "file", "Ljava/io/File;", "avatarId", "", "(Ljava/io/File;Ljava/lang/String;)V", "getAvatarId", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;
        private final String avatarId;
        private final File file;

        public RequestBodyData(File file, String str) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.avatarId = str;
        }

        public final File getFile() {
            return this.file;
        }

        public final String getAvatarId() {
            return this.avatarId;
        }
    }

    /* compiled from: SetCoverPhotoApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap;)V", com.google.android.gms.wearable.DataMap.TAG, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }

        /* compiled from: SetCoverPhotoApiData.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap;", "", "data", "Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap$Data;", "(Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap$Data;)V", "getData", "()Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap$Data;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Data", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DataMap {
            public static final int $stable = 8;

            @SerializedName("data")
            private Data data;

            /* JADX WARN: Multi-variable type inference failed */
            public DataMap() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ DataMap copy$default(DataMap dataMap, Data data, int i, Object obj) {
                if ((i & 1) != 0) {
                    data = dataMap.data;
                }
                return dataMap.copy(data);
            }

            /* renamed from: component1, reason: from getter */
            public final Data getData() {
                return this.data;
            }

            public final DataMap copy(Data data) {
                return new DataMap(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
            }

            public int hashCode() {
                Data data = this.data;
                if (data == null) {
                    return 0;
                }
                return data.hashCode();
            }

            public String toString() {
                return "DataMap(data=" + this.data + ')';
            }

            public DataMap(Data data) {
                this.data = data;
            }

            public /* synthetic */ DataMap(Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : data);
            }

            public final Data getData() {
                return this.data;
            }

            public final void setData(Data data) {
                this.data = data;
            }

            /* compiled from: SetCoverPhotoApiData.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SetCoverPhotoApiData$ResponseData$DataMap$Data;", "", "fileName", "", "fileUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getFileUrl", "setFileUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Data {
                public static final int $stable = 8;

                @SerializedName("fileName")
                private String fileName;

                @SerializedName("fileUrl")
                private String fileUrl;

                /* JADX WARN: Multi-variable type inference failed */
                public Data() {
                    this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                }

                public static /* synthetic */ Data copy$default(Data data, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = data.fileName;
                    }
                    if ((i & 2) != 0) {
                        str2 = data.fileUrl;
                    }
                    return data.copy(str, str2);
                }

                /* renamed from: component1, reason: from getter */
                public final String getFileName() {
                    return this.fileName;
                }

                /* renamed from: component2, reason: from getter */
                public final String getFileUrl() {
                    return this.fileUrl;
                }

                public final Data copy(String fileName, String fileUrl) {
                    return new Data(fileName, fileUrl);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Data)) {
                        return false;
                    }
                    Data data = (Data) other;
                    return Intrinsics.areEqual(this.fileName, data.fileName) && Intrinsics.areEqual(this.fileUrl, data.fileUrl);
                }

                public int hashCode() {
                    String str = this.fileName;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.fileUrl;
                    return iHashCode + (str2 != null ? str2.hashCode() : 0);
                }

                public String toString() {
                    return "Data(fileName=" + this.fileName + ", fileUrl=" + this.fileUrl + ')';
                }

                public Data(String str, String str2) {
                    this.fileName = str;
                    this.fileUrl = str2;
                }

                public /* synthetic */ Data(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
                }

                public final String getFileName() {
                    return this.fileName;
                }

                public final void setFileName(String str) {
                    this.fileName = str;
                }

                public final String getFileUrl() {
                    return this.fileUrl;
                }

                public final void setFileUrl(String str) {
                    this.fileUrl = str;
                }
            }
        }
    }
}
