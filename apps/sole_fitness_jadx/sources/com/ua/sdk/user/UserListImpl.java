package com.ua.sdk.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.Reference;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class UserListImpl extends AbstractEntityList<User> {
    public static Parcelable.Creator<UserListImpl> CREATOR = new Parcelable.Creator<UserListImpl>() { // from class: com.ua.sdk.user.UserListImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserListImpl createFromParcel(Parcel parcel) {
            return new UserListImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserListImpl[] newArray(int i) {
            return new UserListImpl[i];
        }
    };

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "user";
    }

    public UserListImpl() {
    }

    private UserListImpl(Parcel parcel) {
        super(parcel);
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    public boolean preparePartials(Reference reference) {
        if (reference == null || !reference.getHref().contains("friends_with")) {
            return false;
        }
        for (User user : getAll()) {
            if (user instanceof UserImpl) {
                ((UserImpl) user).setObjectState(UserObjectState.FRIENDS_WITH);
            }
        }
        return true;
    }
}
