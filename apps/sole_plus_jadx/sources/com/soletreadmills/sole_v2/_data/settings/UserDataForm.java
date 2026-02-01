package com.soletreadmills.sole_v2._data.settings;

import com.soletreadmills.sole_v2._type.user.GenderType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserDataForm.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/settings/UserDataForm;", "", "displayName", "", "birthDate", "gender", "firstName", "lastName", "weight", "height", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBirthDate", "()Ljava/lang/String;", "getDisplayName", "getFirstName", "getGender", "getHeight", "getLastName", "getWeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserDataForm {
    public static final int $stable = 0;
    private final String birthDate;
    private final String displayName;
    private final String firstName;
    private final String gender;
    private final String height;
    private final String lastName;
    private final String weight;

    public UserDataForm() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ UserDataForm copy$default(UserDataForm userDataForm, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userDataForm.displayName;
        }
        if ((i & 2) != 0) {
            str2 = userDataForm.birthDate;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = userDataForm.gender;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = userDataForm.firstName;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = userDataForm.lastName;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = userDataForm.weight;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = userDataForm.height;
        }
        return userDataForm.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBirthDate() {
        return this.birthDate;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getWeight() {
        return this.weight;
    }

    /* renamed from: component7, reason: from getter */
    public final String getHeight() {
        return this.height;
    }

    public final UserDataForm copy(String displayName, String birthDate, String gender, String firstName, String lastName, String weight, String height) {
        return new UserDataForm(displayName, birthDate, gender, firstName, lastName, weight, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserDataForm)) {
            return false;
        }
        UserDataForm userDataForm = (UserDataForm) other;
        return Intrinsics.areEqual(this.displayName, userDataForm.displayName) && Intrinsics.areEqual(this.birthDate, userDataForm.birthDate) && Intrinsics.areEqual(this.gender, userDataForm.gender) && Intrinsics.areEqual(this.firstName, userDataForm.firstName) && Intrinsics.areEqual(this.lastName, userDataForm.lastName) && Intrinsics.areEqual(this.weight, userDataForm.weight) && Intrinsics.areEqual(this.height, userDataForm.height);
    }

    public int hashCode() {
        String str = this.displayName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.birthDate;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.gender;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.firstName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.lastName;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.weight;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.height;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "UserDataForm(displayName=" + this.displayName + ", birthDate=" + this.birthDate + ", gender=" + this.gender + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", weight=" + this.weight + ", height=" + this.height + ')';
    }

    public UserDataForm(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.displayName = str;
        this.birthDate = str2;
        this.gender = str3;
        this.firstName = str4;
        this.lastName = str5;
        this.weight = str6;
        this.height = str7;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getBirthDate() {
        return this.birthDate;
    }

    public /* synthetic */ UserDataForm(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? GenderType.Male.getId() : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getWeight() {
        return this.weight;
    }

    public final String getHeight() {
        return this.height;
    }
}
