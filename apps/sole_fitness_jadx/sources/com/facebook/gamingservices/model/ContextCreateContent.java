package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

/* loaded from: classes.dex */
public class ContextCreateContent implements ShareModel {
    private final String suggestedPlayerIDs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ContextCreateContent(Builder builder) {
        this.suggestedPlayerIDs = builder.suggestedPlayerIDs;
    }

    ContextCreateContent(Parcel parcel) {
        this.suggestedPlayerIDs = parcel.readString();
    }

    public String getSuggestedPlayerIDs() {
        return this.suggestedPlayerIDs;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.suggestedPlayerIDs);
    }

    public static class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {
        private String suggestedPlayerIDs;

        public Builder setSuggestedPlayerIDs(String str) {
            this.suggestedPlayerIDs = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextCreateContent build() {
            return new ContextCreateContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextCreateContent contextCreateContent) {
            return contextCreateContent == null ? this : setSuggestedPlayerIDs(contextCreateContent.getSuggestedPlayerIDs());
        }

        Builder readFrom(Parcel parcel) {
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }
}
