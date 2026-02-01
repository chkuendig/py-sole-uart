package com.soletreadmills.sole_v2._data.signUp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignUpForm.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/signUp/SignUpForm;", "", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getPassword", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SignUpForm {
    public static final int $stable = 0;
    private final String email;
    private final String password;

    /* JADX WARN: Multi-variable type inference failed */
    public SignUpForm() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SignUpForm copy$default(SignUpForm signUpForm, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signUpForm.email;
        }
        if ((i & 2) != 0) {
            str2 = signUpForm.password;
        }
        return signUpForm.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    public final SignUpForm copy(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        return new SignUpForm(email, password);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignUpForm)) {
            return false;
        }
        SignUpForm signUpForm = (SignUpForm) other;
        return Intrinsics.areEqual(this.email, signUpForm.email) && Intrinsics.areEqual(this.password, signUpForm.password);
    }

    public int hashCode() {
        return (this.email.hashCode() * 31) + this.password.hashCode();
    }

    public String toString() {
        return "SignUpForm(email=" + this.email + ", password=" + this.password + ')';
    }

    public SignUpForm(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        this.email = email;
        this.password = password;
    }

    public /* synthetic */ SignUpForm(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }
}
