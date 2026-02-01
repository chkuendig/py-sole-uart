package com.ua.sdk.friendship;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class FriendshipListImpl extends AbstractEntityList<Friendship> {
    public static Parcelable.Creator<FriendshipListImpl> CREATOR = new Parcelable.Creator<FriendshipListImpl>() { // from class: com.ua.sdk.friendship.FriendshipListImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipListImpl createFromParcel(Parcel parcel) {
            return new FriendshipListImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FriendshipListImpl[] newArray(int i) {
            return new FriendshipListImpl[i];
        }
    };

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return FriendshipPageTransferObject.KEY_FRIENDSHIPS;
    }

    public FriendshipListImpl() {
    }

    private FriendshipListImpl(Parcel parcel) {
        super(parcel);
    }
}
