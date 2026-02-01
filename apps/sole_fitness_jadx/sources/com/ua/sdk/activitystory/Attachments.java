package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.activitystory.Attachment;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Attachments implements Parcelable {
    public static final Parcelable.Creator<Attachments> CREATOR = new Parcelable.Creator<Attachments>() { // from class: com.ua.sdk.activitystory.Attachments.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Attachments createFromParcel(Parcel parcel) {
            return new Attachments(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Attachments[] newArray(int i) {
            return new Attachments[i];
        }
    };

    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    ArrayList<Attachment> attachments;

    @SerializedName("count")
    Integer count;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Attachment getAttachment(int i) {
        ArrayList<Attachment> arrayList = this.attachments;
        if (arrayList == null) {
            throw new IndexOutOfBoundsException();
        }
        return arrayList.get(i);
    }

    public int getCount() {
        Integer num = this.count;
        if (num == null) {
            ArrayList<Attachment> arrayList = this.attachments;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return num.intValue();
    }

    public void addAttachment(Attachment.Type type) {
        if (this.attachments == null) {
            this.attachments = new ArrayList<>();
        }
        if (type == Attachment.Type.PHOTO) {
            this.attachments.add(new PhotoAttachmentImpl(type));
        }
        if (type == Attachment.Type.VIDEO) {
            this.attachments.add(new VideoAttachmentImpl(type));
        }
    }

    public ArrayList<Attachment> getAttachments() {
        return this.attachments;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.count);
        parcel.writeList(this.attachments);
    }

    public Attachments() {
    }

    private Attachments(Parcel parcel) {
        this.count = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.attachments = parcel.readArrayList(PhotoAttachmentImpl.class.getClassLoader());
    }
}
