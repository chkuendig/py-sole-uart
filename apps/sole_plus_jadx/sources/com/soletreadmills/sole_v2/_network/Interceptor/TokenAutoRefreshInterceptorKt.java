package com.soletreadmills.sole_v2._network.Interceptor;

import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.UnitSettings;
import com.soletreadmills.sole_v2._type.user.GenderType;
import com.soletreadmills.sole_v2._type.user.RegisterType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenAutoRefreshInterceptor.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"loginByTokenAgain", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLoginData", "", "data", "Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TokenAutoRefreshInterceptorKt {

    /* compiled from: TokenAutoRefreshInterceptor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptorKt", f = "TokenAutoRefreshInterceptor.kt", i = {0}, l = {172}, m = "loginByTokenAgain", n = {"sharedPreferences"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptorKt$loginByTokenAgain$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TokenAutoRefreshInterceptorKt.loginByTokenAgain(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object loginByTokenAgain(kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._network.Interceptor.TokenAutoRefreshInterceptorKt.loginByTokenAgain(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void saveLoginData(LoginUserData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String globalUserUuid = data.getGlobalUserUuid();
        String str = globalUserUuid == null ? "" : globalUserUuid;
        String userUuid = data.getUserUuid();
        String str2 = userUuid == null ? "" : userUuid;
        String loginName = data.getLoginName();
        String str3 = loginName == null ? "" : loginName;
        String photoFileUrl = data.getPhotoFileUrl();
        String avatarId = data.getAvatarId();
        Integer registerType = data.getRegisterType();
        Integer numValueOf = Integer.valueOf(registerType != null ? registerType.intValue() : RegisterType.Email.getId());
        String email = data.getEmail();
        String str4 = email == null ? "" : email;
        String birthDate = data.getBirthDate();
        String str5 = birthDate == null ? "" : birthDate;
        String gender = data.getGender();
        if (gender == null) {
            gender = GenderType.Male.getId();
        }
        String str6 = gender;
        String firstName = data.getFirstName();
        String str7 = firstName == null ? "" : firstName;
        String lastName = data.getLastName();
        String str8 = lastName == null ? "" : lastName;
        String displayName = data.getDisplayName();
        String str9 = displayName == null ? "" : displayName;
        String weight = data.getWeight();
        String str10 = weight == null ? "" : weight;
        Integer measurementUnit = data.getMeasurementUnit();
        Integer numValueOf2 = Integer.valueOf(measurementUnit != null ? measurementUnit.intValue() : UnitSettings.M.getId());
        String height = data.getHeight();
        MySharedPreferences.INSTANCE.getInstance().setUserData(new LoginUserData(str, str2, str3, photoFileUrl, avatarId, numValueOf, str4, str5, str6, str7, str8, str9, str10, numValueOf2, height == null ? "" : height, data.getEnabledPreferenceItems()));
        Global global = Global.INSTANCE;
        Global.userData = data;
    }
}
