package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class ActivityStoryListRef implements EntityListRef<ActivityStory> {
    public static Parcelable.Creator<ActivityStoryListRef> CREATOR = new Parcelable.Creator<ActivityStoryListRef>() { // from class: com.ua.sdk.activitystory.ActivityStoryListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryListRef createFromParcel(Parcel parcel) {
            return new ActivityStoryListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryListRef[] newArray(int i) {
            return new ActivityStoryListRef[i];
        }
    };
    public final String mHref;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private ActivityStoryListRef(Builder builder) throws NullPointerException {
        Precondition.isNotNull(builder);
        this.mHref = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.mHref;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private ActivityStoryType feedType;
        private ActivityStoryView feedView;
        private String id;
        private ActivityStoryReplyType replyType;

        private Builder() {
            super("/v7.0/activity_story/");
        }

        public Builder setActivityStoryType(ActivityStoryType activityStoryType) {
            this.feedType = activityStoryType;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setActivityStoryView(ActivityStoryView activityStoryView) {
            this.feedView = activityStoryView;
            return this;
        }

        public Builder setReplyType(ActivityStoryReplyType activityStoryReplyType) {
            this.feedType = ActivityStoryType.REPLY;
            this.replyType = activityStoryReplyType;
            return this;
        }

        @Deprecated
        public Builder setParentRef(EntityRef<ActivityStory> entityRef) {
            if (entityRef != null) {
                this.id = entityRef.getId();
                this.feedType = ActivityStoryType.REPLY;
            }
            return this;
        }

        @Deprecated
        public Builder setUser(EntityRef<User> entityRef) {
            if (entityRef != null) {
                this.id = entityRef.getId();
                this.feedType = ActivityStoryType.USER;
            }
            return this;
        }

        @Deprecated
        public Builder setMeFilter(boolean z) {
            if (z) {
                this.feedView = ActivityStoryView.USER_ME;
            }
            return this;
        }

        public ActivityStoryListRef build() throws NullPointerException {
            Precondition.isNotNull(this.feedType, "ActivityStoryType cannot be null");
            if (this.feedType == ActivityStoryType.WORKOUT) {
                setParam("object_type", this.feedType.toString());
            } else if (this.feedType != ActivityStoryType.REPLY) {
                setParam("feed_type", this.feedType.toString());
            } else {
                Precondition.isNotNull(this.replyType, "ReplyType cannot be null if ActivityStoryType is ReplyType");
                setParam("reply_type", this.replyType.toString());
            }
            if (this.feedType.isIdRequired()) {
                Precondition.isNotNull(this.id, "Story id cannot be null for this ActivityStoryType");
                if (this.feedType == ActivityStoryType.REPLY) {
                    setParam("parent_story_id", this.id);
                } else if (this.feedType == ActivityStoryType.WORKOUT) {
                    setParam("object_id", this.id);
                } else {
                    setParam("feed_id", this.id);
                }
            }
            ActivityStoryView activityStoryView = this.feedView;
            if (activityStoryView != null) {
                if (activityStoryView.getActivityStoryType() == this.feedType) {
                    setParam("feed_view", this.feedView.toString());
                } else {
                    throw new IllegalStateException(String.format("Feed view (%S) is not valid for Feed type (%S)", this.feedView, this.feedType));
                }
            }
            return new ActivityStoryListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mHref);
    }

    private ActivityStoryListRef(Parcel parcel) {
        this.mHref = parcel.readString();
    }
}
