package com.samsung.android.sdk.healthdata;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public final class HealthDevice implements Parcelable {
    public static final Parcelable.Creator<HealthDevice> CREATOR = new a();
    public static final int GROUP_COMPANION = 360003;
    public static final int GROUP_EXTERNAL = 360002;
    public static final int GROUP_MOBILE = 360001;
    public static final int GROUP_UNKNOWN = 0;
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final String f;

    public static class Builder {
        private String a;
        private String b;
        private String c;
        private String d;
        private int e;

        public HealthDevice build() {
            String str = this.d;
            if (str == null || str.isEmpty()) {
                throw new IllegalStateException("Seed is not specified");
            }
            int i = this.e;
            if (i != 0) {
                switch (i) {
                    case HealthDevice.GROUP_MOBILE /* 360001 */:
                    case HealthDevice.GROUP_EXTERNAL /* 360002 */:
                    case HealthDevice.GROUP_COMPANION /* 360003 */:
                        break;
                    default:
                        throw new IllegalStateException("Device group is not set correctly");
                }
            }
            return new HealthDevice(this, (a) null);
        }

        public Builder setCustomName(String str) {
            this.a = str;
            return this;
        }

        public Builder setDeviceSeed(String str) {
            this.d = str;
            return this;
        }

        public Builder setGroup(int i) {
            this.e = i;
            return this;
        }

        public Builder setManufacturer(String str) {
            this.c = str;
            return this;
        }

        public Builder setModel(String str) {
            this.b = str;
            return this;
        }
    }

    static class a implements Parcelable.Creator<HealthDevice> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public HealthDevice createFromParcel(Parcel parcel) {
            return new HealthDevice(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        public HealthDevice[] newArray(int i) {
            return new HealthDevice[i];
        }
    }

    /* synthetic */ HealthDevice(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HealthDevice)) {
            return false;
        }
        HealthDevice healthDevice = (HealthDevice) obj;
        String str2 = this.f;
        if (str2 == null || (str = healthDevice.f) == null) {
            return false;
        }
        return str2.equals(str);
    }

    public String getCustomName() {
        return this.b;
    }

    public int getGroup() {
        return this.e;
    }

    public String getManufacturer() {
        return this.d;
    }

    public String getModel() {
        return this.c;
    }

    public String getSeed() {
        return this.f;
    }

    public String getUuid() {
        return this.a;
    }

    public int hashCode() {
        String str = this.f;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
    }

    /* synthetic */ HealthDevice(Builder builder, a aVar) {
        this(builder);
    }

    public HealthDevice(String str, String str2, String str3, String str4, String str5, int i) {
        this.a = str;
        this.f = str2;
        this.d = str3;
        this.c = str4;
        this.b = str5;
        this.e = i;
    }

    private HealthDevice(Builder builder) {
        this.a = null;
        this.b = builder.a;
        this.c = builder.b;
        this.d = builder.c;
        this.e = builder.e;
        this.f = builder.d;
    }

    private HealthDevice(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }
}
