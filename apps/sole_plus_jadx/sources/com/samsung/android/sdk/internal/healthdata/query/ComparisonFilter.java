package com.samsung.android.sdk.internal.healthdata.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.healthdata.HealthDataResolver;

/* loaded from: classes5.dex */
public class ComparisonFilter extends HealthDataResolver.Filter {
    private Operator a;
    private String b;
    private Number c;

    public enum Operator implements Parcelable {
        GREATER_THAN_EQUALS { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.1
            @Override // com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator
            public String toQueryString() {
                return " >= ";
            }
        },
        GREATER_THAN { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.2
            @Override // com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator
            public String toQueryString() {
                return " > ";
            }
        },
        LESS_THAN_EQUALS { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.3
            @Override // com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator
            public String toQueryString() {
                return " <= ";
            }
        },
        LESS_THAN { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.4
            @Override // com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator
            public String toQueryString() {
                return " < ";
            }
        },
        EQ { // from class: com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator.5
            @Override // com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter.Operator
            public String toQueryString() {
                return " = ";
            }
        };

        public static final Parcelable.Creator<Operator> CREATOR = new a();

        static class a implements Parcelable.Creator<Operator> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public Operator createFromParcel(Parcel parcel) {
                return Operator.values()[parcel.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public Operator[] newArray(int i) {
                return new Operator[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public abstract String toQueryString();

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(ordinal());
        }
    }

    public ComparisonFilter(Operator operator, String str, Number number) {
        this.mType = HealthDataResolver.Filter.ParcelType.COMPARABLE;
        this.a = operator;
        this.b = str;
        this.c = number;
    }

    public String getField() {
        return this.b;
    }

    public Operator getOperator() {
        return this.a;
    }

    public Number getValue() {
        return this.c;
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter
    protected void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.a = (Operator) parcel.readParcelable(Operator.class.getClassLoader());
        this.b = parcel.readString();
        this.c = (Number) parcel.readSerializable();
    }

    @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.a, 0);
        parcel.writeString(this.b);
        parcel.writeSerializable(this.c);
    }

    public ComparisonFilter(Parcel parcel) {
        readFromParcel(parcel);
    }
}
