package com.ua.sdk.user;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.suggestedfriends.SuggestedFriendsImpl;

/* loaded from: classes2.dex */
public class UserListRef implements EntityListRef<User> {
    public static Parcelable.Creator<UserListRef> CREATOR = new Parcelable.Creator<UserListRef>() { // from class: com.ua.sdk.user.UserListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserListRef createFromParcel(Parcel parcel) {
            return new UserListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserListRef[] newArray(int i) {
            return new UserListRef[i];
        }
    };
    private final String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private UserListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        private static final int EMAIL_LENGTH = 1024;
        private static final int EMAIL_LIMIT = 50;
        private String email;
        private String friendsWith;
        private String mutualFriends;
        private String name;
        private String query;
        private String requestedFriendshipWith;
        private String suggestedFriendsEmails;
        private String suggestedFriendsFor;
        private String suggestedFriendsSource;
        private String username;

        private Builder() {
            super("/v7.0/user/");
        }

        public Builder setFriendsWith(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide a user id");
            this.friendsWith = str;
            return this;
        }

        public Builder setMutualFriendsIds(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide user ids");
            this.mutualFriends = str;
            return this;
        }

        public Builder setRequestedFriendshipWith(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide a user id");
            this.requestedFriendshipWith = str;
            return this;
        }

        public Builder setSuggestedFriendsFor(EntityRef<User> entityRef) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(entityRef);
            Precondition.check(!TextUtils.isEmpty(entityRef.getId()), "You must provide a user that has an id");
            this.suggestedFriendsFor = entityRef.getId();
            return this;
        }

        public Builder setSuggestedFriendsSource(UserSource userSource) throws NullPointerException {
            Precondition.isNotNull(userSource);
            this.suggestedFriendsSource = userSource.getName();
            return this;
        }

        public Builder setSuggestedFriendsEmails(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide comma separated emails");
            if (str.length() > 1024 && str.length() - str.replaceAll(",", "").length() > 50) {
                throw new IllegalArgumentException("Too many emails provided. Please limit them to at least 50.");
            }
            this.suggestedFriendsEmails = str;
            return this;
        }

        public Builder setQueryFilter(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide a query");
            this.query = str;
            return this;
        }

        public Builder setEmailFilter(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide an email");
            this.email = str;
            return this;
        }

        public Builder setNameFilter(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide a name");
            this.name = str;
            return this;
        }

        public Builder setUsernameFilter(String str) throws IllegalArgumentException, NullPointerException {
            Precondition.isNotNull(str);
            Precondition.check(!TextUtils.isEmpty(str), "You must provide a username");
            this.username = str;
            return this;
        }

        public UserListRef build() {
            String str = this.friendsWith;
            if (str != null) {
                setParam("friends_with", str);
            } else {
                String str2 = this.mutualFriends;
                if (str2 != null) {
                    setParam(SuggestedFriendsImpl.REF_MUTUAL_FRIENDS, str2);
                } else {
                    String str3 = this.requestedFriendshipWith;
                    if (str3 != null) {
                        setParam("requested_friendship_with", str3);
                    } else {
                        String str4 = this.suggestedFriendsFor;
                        if (str4 != null) {
                            setParam("suggested_friends_for", str4);
                            String str5 = this.suggestedFriendsEmails;
                            if (str5 == null && this.suggestedFriendsSource == null) {
                                throw new IllegalArgumentException("SuggestedFriends source or emails must be provided.");
                            }
                            String str6 = this.suggestedFriendsSource;
                            if (str6 != null) {
                                setParam("suggested_friends_source", str6);
                            } else if (str5 != null) {
                                setParam("suggested_friends_emails", str5);
                            }
                        } else {
                            String str7 = this.query;
                            if (str7 != null) {
                                setParam("q", str7);
                            } else {
                                String str8 = this.email;
                                if (str8 != null) {
                                    setParam("email", str8);
                                } else {
                                    String str9 = this.username;
                                    if (str9 != null) {
                                        setParam("username", str9);
                                    } else {
                                        String str10 = this.name;
                                        if (str10 != null) {
                                            setParam("name", str10);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new UserListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private UserListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
