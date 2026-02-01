package com.soletreadmills.sole_v2._data.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: JwtErrorCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/JwtErrorCode;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "JWT_SUCCESS_1", "JWT_INVALID_PARAMETER_102", "JWT_MISSING_PARAMETERS_104", "JWT_AUTHORIZATION_105", "JWT_OK_200", "JWT_ERROR_1501", "JWT_ERROR_1502", "JWT_ERROR_1503", "JWT_ERROR_1510", "JWT_ERROR_1515", "JWT_SERVICE_TOKEN_EXPIRED_3007", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JwtErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ JwtErrorCode[] $VALUES;
    private final String id;
    public static final JwtErrorCode JWT_SUCCESS_1 = new JwtErrorCode("JWT_SUCCESS_1", 0, "1");
    public static final JwtErrorCode JWT_INVALID_PARAMETER_102 = new JwtErrorCode("JWT_INVALID_PARAMETER_102", 1, "102");
    public static final JwtErrorCode JWT_MISSING_PARAMETERS_104 = new JwtErrorCode("JWT_MISSING_PARAMETERS_104", 2, "104");
    public static final JwtErrorCode JWT_AUTHORIZATION_105 = new JwtErrorCode("JWT_AUTHORIZATION_105", 3, "105");
    public static final JwtErrorCode JWT_OK_200 = new JwtErrorCode("JWT_OK_200", 4, "200");
    public static final JwtErrorCode JWT_ERROR_1501 = new JwtErrorCode("JWT_ERROR_1501", 5, "1501");
    public static final JwtErrorCode JWT_ERROR_1502 = new JwtErrorCode("JWT_ERROR_1502", 6, "1502");
    public static final JwtErrorCode JWT_ERROR_1503 = new JwtErrorCode("JWT_ERROR_1503", 7, "1503");
    public static final JwtErrorCode JWT_ERROR_1510 = new JwtErrorCode("JWT_ERROR_1510", 8, "1510");
    public static final JwtErrorCode JWT_ERROR_1515 = new JwtErrorCode("JWT_ERROR_1515", 9, "1515");
    public static final JwtErrorCode JWT_SERVICE_TOKEN_EXPIRED_3007 = new JwtErrorCode("JWT_SERVICE_TOKEN_EXPIRED_3007", 10, "3007");

    private static final /* synthetic */ JwtErrorCode[] $values() {
        return new JwtErrorCode[]{JWT_SUCCESS_1, JWT_INVALID_PARAMETER_102, JWT_MISSING_PARAMETERS_104, JWT_AUTHORIZATION_105, JWT_OK_200, JWT_ERROR_1501, JWT_ERROR_1502, JWT_ERROR_1503, JWT_ERROR_1510, JWT_ERROR_1515, JWT_SERVICE_TOKEN_EXPIRED_3007};
    }

    public static EnumEntries<JwtErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static JwtErrorCode valueOf(String str) {
        return (JwtErrorCode) Enum.valueOf(JwtErrorCode.class, str);
    }

    public static JwtErrorCode[] values() {
        return (JwtErrorCode[]) $VALUES.clone();
    }

    private JwtErrorCode(String str, int i, String str2) {
        this.id = str2;
    }

    public final String getId() {
        return this.id;
    }

    static {
        JwtErrorCode[] jwtErrorCodeArr$values = $values();
        $VALUES = jwtErrorCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(jwtErrorCodeArr$values);
    }
}
