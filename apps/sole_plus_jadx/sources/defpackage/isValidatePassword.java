package defpackage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import timber.log.Timber;

/* compiled from: ValidatePassword.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isValidatePassword", "", "password", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: ValidatePasswordKt, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class isValidatePassword {
    public static final boolean isValidatePassword(String password) {
        Intrinsics.checkNotNullParameter(password, "password");
        Regex regex = new Regex("^(?=.*[A-Za-z])(?=.*\\d)[\\s\\S]{8,}$");
        String str = password;
        Timber.INSTANCE.d("Password format: " + regex.matches(str), new Object[0]);
        return regex.matches(str);
    }
}
