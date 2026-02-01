package com.android.prefs;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLocationsException.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u0000 \b2\u00060\u0001j\u0002`\u0002:\u0001\bB\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/android/prefs/AndroidLocationsException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidLocationsException extends Exception {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidLocationsException(String message) {
        this(message, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public /* synthetic */ AndroidLocationsException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* compiled from: AndroidLocationsException.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/prefs/AndroidLocationsException$Companion;", "", "()V", "createForHomeLocation", "Lcom/android/prefs/AndroidLocationsException;", "vars", "", "Lcom/android/prefs/LocationValue;", "createForHomeLocation$common", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AndroidLocationsException createForHomeLocation$common(List<? extends LocationValue> vars) {
            Intrinsics.checkNotNullParameter(vars, "vars");
            return new AndroidLocationsException("Unable to find the location of the home directory.\nThe following locations have been checked, but they do not exist:\n" + CollectionsKt.joinToString$default(vars, "\n", null, null, 0, null, new Function1<LocationValue, CharSequence>() { // from class: com.android.prefs.AndroidLocationsException$Companion$createForHomeLocation$list$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(LocationValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "- " + it.getPropertyName() + '(' + it.getQueryType() + " -> " + it.getValue();
                }
            }, 30, null), null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidLocationsException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
