package defpackage;

import android.util.Patterns;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValidateEmail.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isValidateEmail", "", "email", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* renamed from: ValidateEmailKt, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class isValidateEmail {
    public static final boolean isValidateEmail(String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
