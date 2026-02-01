package com.ua.sdk.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UserCommunicationImpl implements UserCommunication, Parcelable {
    public static Parcelable.Creator<UserCommunicationImpl> CREATOR = new Parcelable.Creator<UserCommunicationImpl>() { // from class: com.ua.sdk.user.UserCommunicationImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserCommunicationImpl createFromParcel(Parcel parcel) {
            return new UserCommunicationImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserCommunicationImpl[] newArray(int i) {
            return new UserCommunicationImpl[i];
        }
    };

    @SerializedName("newsletter")
    Boolean newsletter;

    @SerializedName("promotions")
    Boolean promotions;

    @SerializedName("system_messages")
    Boolean systemMessages;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserCommunicationImpl() {
    }

    @Override // com.ua.sdk.user.UserCommunication
    public boolean isPromotions() {
        Boolean bool = this.promotions;
        return bool != null && bool.booleanValue();
    }

    @Override // com.ua.sdk.user.UserCommunication
    public Boolean getPromotions() {
        return this.promotions;
    }

    @Override // com.ua.sdk.user.UserCommunication
    public void setPromotions(Boolean bool) {
        this.promotions = bool;
    }

    @Override // com.ua.sdk.user.UserCommunication
    public boolean isNewsletter() {
        Boolean bool = this.newsletter;
        return bool != null && bool.booleanValue();
    }

    @Override // com.ua.sdk.user.UserCommunication
    public Boolean getNewsletter() {
        return this.newsletter;
    }

    @Override // com.ua.sdk.user.UserCommunication
    public void setNewsletter(Boolean bool) {
        this.newsletter = bool;
    }

    @Override // com.ua.sdk.user.UserCommunication
    public boolean isSystemMessages() {
        Boolean bool = this.systemMessages;
        return bool != null && bool.booleanValue();
    }

    @Override // com.ua.sdk.user.UserCommunication
    public Boolean getSystemMessages() {
        return this.systemMessages;
    }

    @Override // com.ua.sdk.user.UserCommunication
    public void setSystemMessages(Boolean bool) {
        this.systemMessages = bool;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Boolean newletters;
        private Boolean promotions;
        private Boolean systemMessages;

        public Builder setPromotions(Boolean bool) {
            this.promotions = bool;
            return this;
        }

        public Builder setNewletters(Boolean bool) {
            this.newletters = bool;
            return this;
        }

        public Builder setSystemMessages(Boolean bool) {
            this.systemMessages = bool;
            return this;
        }

        public UserCommunicationImpl build() {
            UserCommunicationImpl userCommunicationImpl = new UserCommunicationImpl();
            userCommunicationImpl.setPromotions(this.promotions);
            userCommunicationImpl.setNewsletter(this.newletters);
            userCommunicationImpl.setSystemMessages(this.systemMessages);
            return userCommunicationImpl;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.promotions);
        parcel.writeValue(this.newsletter);
        parcel.writeValue(this.systemMessages);
    }

    private UserCommunicationImpl(Parcel parcel) {
        this.promotions = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.newsletter = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.systemMessages = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }
}
