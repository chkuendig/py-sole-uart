package com.soletreadmills.sole_v2._type.user;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UserStatusType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_type/user/UserStatusType;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "REGISTERING", "WAITING_FOR_VERIFY", "NORMAL_USE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserStatusType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserStatusType[] $VALUES;
    private final int id;
    public static final UserStatusType REGISTERING = new UserStatusType("REGISTERING", 0, 4);
    public static final UserStatusType WAITING_FOR_VERIFY = new UserStatusType("WAITING_FOR_VERIFY", 1, 5);
    public static final UserStatusType NORMAL_USE = new UserStatusType("NORMAL_USE", 2, 9);

    private static final /* synthetic */ UserStatusType[] $values() {
        return new UserStatusType[]{REGISTERING, WAITING_FOR_VERIFY, NORMAL_USE};
    }

    public static EnumEntries<UserStatusType> getEntries() {
        return $ENTRIES;
    }

    public static UserStatusType valueOf(String str) {
        return (UserStatusType) Enum.valueOf(UserStatusType.class, str);
    }

    public static UserStatusType[] values() {
        return (UserStatusType[]) $VALUES.clone();
    }

    private UserStatusType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        UserStatusType[] userStatusTypeArr$values = $values();
        $VALUES = userStatusTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(userStatusTypeArr$values);
    }
}
