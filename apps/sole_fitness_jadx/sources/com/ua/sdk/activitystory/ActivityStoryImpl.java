package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.Source;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import java.util.Date;

/* loaded from: classes2.dex */
public class ActivityStoryImpl extends ApiTransferObject implements ActivityStory {
    public static Parcelable.Creator<ActivityStoryImpl> CREATOR = new Parcelable.Creator<ActivityStoryImpl>() { // from class: com.ua.sdk.activitystory.ActivityStoryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryImpl[] newArray(int i) {
            return new ActivityStoryImpl[i];
        }
    };

    @SerializedName("actor")
    ActivityStoryActor mActor;

    @SerializedName("attachments")
    Attachments mAttachments;

    @SerializedName("comments")
    ActivityStoryReplySummaryImpl mCommentSummary;

    @SerializedName("id")
    String mId;

    @SerializedName("likes")
    ActivityStoryReplySummaryImpl mLikeSummary;

    @SerializedName("object")
    ActivityStoryObject mObject;

    @SerializedName("published")
    Date mPublishedTime;

    @SerializedName("reposts")
    ActivityStoryRepostSummaryImpl mRepostSummary;

    @SerializedName("sharing")
    SocialSettings mSharingSettngs;

    @SerializedName(TypedValues.AttributesType.S_TARGET)
    ActivityStoryTarget mTarget;

    @SerializedName("template")
    ActivityStoryTemplateImpl mTemplate;

    @SerializedName("verb")
    ActivityStoryVerb mVerb;

    @SerializedName("source")
    Source source;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public String getId() {
        return this.mId;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryActor getActor() {
        return this.mActor;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryObject getObject() {
        return this.mObject;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryVerb getVerb() {
        return this.mVerb;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryTemplate getTemplate() {
        return this.mTemplate;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public Date getPublished() {
        return this.mPublishedTime;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public EntityRef<ActivityStory> getTargetRef() {
        if (this.mTarget != null) {
            return new LinkEntityRef(this.mTarget.getId(), "");
        }
        return null;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryReplySummary getCommentsSummary() {
        return this.mCommentSummary;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryReplySummary getLikesSummary() {
        return this.mLikeSummary;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryRepostSummary getRepostSummary() {
        return this.mRepostSummary;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryListRef getCommmentsRef() {
        return ActivityStoryListRef.getBuilder().setId(getRef().getId()).setReplyType(ActivityStoryReplyType.COMMENTS).build();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryListRef getLikesRef() {
        return ActivityStoryListRef.getBuilder().setId(getRef().getId()).setReplyType(ActivityStoryReplyType.LIKES).build();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public ActivityStoryListRef getRepostsRef() {
        return ActivityStoryListRef.getBuilder().setId(getRef().getId()).setReplyType(ActivityStoryReplyType.REPOSTS).build();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public boolean isLikedByCurrentUser() {
        ActivityStoryReplySummaryImpl activityStoryReplySummaryImpl = this.mLikeSummary;
        if (activityStoryReplySummaryImpl != null) {
            return activityStoryReplySummaryImpl.isReplied();
        }
        return false;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public boolean isCommentedByCurrentUser() {
        ActivityStoryReplySummaryImpl activityStoryReplySummaryImpl = this.mCommentSummary;
        if (activityStoryReplySummaryImpl != null) {
            return activityStoryReplySummaryImpl.isReplied();
        }
        return false;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public boolean isRepostedByCurrentUser() {
        ActivityStoryRepostSummaryImpl activityStoryRepostSummaryImpl = this.mRepostSummary;
        if (activityStoryRepostSummaryImpl != null) {
            return activityStoryRepostSummaryImpl.isReposted();
        }
        return false;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public int getLikeCount() {
        ActivityStoryReplySummaryImpl activityStoryReplySummaryImpl = this.mLikeSummary;
        if (activityStoryReplySummaryImpl == null) {
            return 0;
        }
        return activityStoryReplySummaryImpl.getTotalCount();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public int getCommentCount() {
        ActivityStoryReplySummaryImpl activityStoryReplySummaryImpl = this.mCommentSummary;
        if (activityStoryReplySummaryImpl == null) {
            return 0;
        }
        return activityStoryReplySummaryImpl.getTotalCount();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public int getRepostCount() {
        ActivityStoryRepostSummaryImpl activityStoryRepostSummaryImpl = this.mRepostSummary;
        if (activityStoryRepostSummaryImpl == null) {
            return 0;
        }
        return activityStoryRepostSummaryImpl.getTotalCount();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public int getAttachmentCount() {
        Attachments attachments = this.mAttachments;
        if (attachments == null) {
            return 0;
        }
        return attachments.getCount();
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public Attachment getAttachment(int i) throws IndexOutOfBoundsException {
        Attachments attachments = this.mAttachments;
        if (attachments == null) {
            throw new IndexOutOfBoundsException("Activity Story does not have any attachments.");
        }
        return attachments.getAttachment(i);
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public SocialSettings getSocialSettings() {
        return this.mSharingSettngs;
    }

    @Override // com.ua.sdk.activitystory.ActivityStory
    public Source getSource() {
        return this.source;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<ActivityStory> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mActor, 0);
        ActivityStoryVerb activityStoryVerb = this.mVerb;
        parcel.writeInt(activityStoryVerb == null ? -1 : activityStoryVerb.ordinal());
        parcel.writeParcelable(this.mObject, 0);
        Date date = this.mPublishedTime;
        parcel.writeLong(date != null ? date.getTime() : -1L);
        parcel.writeParcelable(this.mTemplate, i);
        parcel.writeParcelable(this.mTarget, i);
        parcel.writeParcelable(this.mCommentSummary, i);
        parcel.writeParcelable(this.mLikeSummary, i);
        parcel.writeParcelable(this.mRepostSummary, i);
        parcel.writeParcelable(this.mAttachments, i);
        parcel.writeParcelable(this.mSharingSettngs, i);
        parcel.writeParcelable(this.source, i);
    }

    public ActivityStoryImpl() {
    }

    private ActivityStoryImpl(Parcel parcel) {
        super(parcel);
        this.mId = parcel.readString();
        this.mActor = (ActivityStoryActor) parcel.readParcelable(ActivityStoryActor.class.getClassLoader());
        int i = parcel.readInt();
        this.mVerb = i == -1 ? null : ActivityStoryVerb.values()[i];
        this.mObject = (ActivityStoryObject) parcel.readParcelable(ActivityStoryObject.class.getClassLoader());
        long j = parcel.readLong();
        this.mPublishedTime = j != -1 ? new Date(j) : null;
        this.mTemplate = (ActivityStoryTemplateImpl) parcel.readParcelable(ActivityStoryTemplate.class.getClassLoader());
        this.mTarget = (ActivityStoryTarget) parcel.readParcelable(ActivityStoryTarget.class.getClassLoader());
        this.mCommentSummary = (ActivityStoryReplySummaryImpl) parcel.readParcelable(ActivityStoryReplySummaryImpl.class.getClassLoader());
        this.mLikeSummary = (ActivityStoryReplySummaryImpl) parcel.readParcelable(ActivityStoryReplySummaryImpl.class.getClassLoader());
        this.mRepostSummary = (ActivityStoryRepostSummaryImpl) parcel.readParcelable(ActivityStoryReplySummaryImpl.class.getClassLoader());
        this.mAttachments = (Attachments) parcel.readParcelable(Attachments.class.getClassLoader());
        this.mSharingSettngs = (SocialSettings) parcel.readParcelable(SocialSettings.class.getClassLoader());
        this.source = (Source) parcel.readParcelable(Source.class.getClassLoader());
    }
}
