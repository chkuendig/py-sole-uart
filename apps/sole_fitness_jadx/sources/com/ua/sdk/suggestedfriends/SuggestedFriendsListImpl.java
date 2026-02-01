package com.ua.sdk.suggestedfriends;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class SuggestedFriendsListImpl extends AbstractEntityList<SuggestedFriends> {
    public static Parcelable.Creator<SuggestedFriendsListImpl> CREATOR = new Parcelable.Creator<SuggestedFriendsListImpl>() { // from class: com.ua.sdk.suggestedfriends.SuggestedFriendsListImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsListImpl createFromParcel(Parcel parcel) {
            return new SuggestedFriendsListImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsListImpl[] newArray(int i) {
            return new SuggestedFriendsListImpl[i];
        }
    };
    private static final String LIST_KEY = "suggestions";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "suggestions";
    }

    public SuggestedFriendsListImpl() {
    }

    private SuggestedFriendsListImpl(Parcel parcel) {
        super(parcel);
    }
}
