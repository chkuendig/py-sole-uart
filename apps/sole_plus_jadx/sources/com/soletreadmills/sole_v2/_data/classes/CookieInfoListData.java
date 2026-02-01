package com.soletreadmills.sole_v2._data.classes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassVideoDetailApiData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0004\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/CookieInfoListData;", "", "domain", "", "is_http_only", "", "is_secure", "name", "path", "value", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDomain", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getPath", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/classes/CookieInfoListData;", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CookieInfoListData {
    public static final int $stable = 0;
    private final String domain;
    private final Boolean is_http_only;
    private final Boolean is_secure;
    private final String name;
    private final String path;
    private final String value;

    public CookieInfoListData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CookieInfoListData copy$default(CookieInfoListData cookieInfoListData, String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cookieInfoListData.domain;
        }
        if ((i & 2) != 0) {
            bool = cookieInfoListData.is_http_only;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            bool2 = cookieInfoListData.is_secure;
        }
        Boolean bool4 = bool2;
        if ((i & 8) != 0) {
            str2 = cookieInfoListData.name;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = cookieInfoListData.path;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            str4 = cookieInfoListData.value;
        }
        return cookieInfoListData.copy(str, bool3, bool4, str5, str6, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIs_http_only() {
        return this.is_http_only;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIs_secure() {
        return this.is_secure;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component6, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final CookieInfoListData copy(String domain, Boolean is_http_only, Boolean is_secure, String name, String path, String value) {
        return new CookieInfoListData(domain, is_http_only, is_secure, name, path, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CookieInfoListData)) {
            return false;
        }
        CookieInfoListData cookieInfoListData = (CookieInfoListData) other;
        return Intrinsics.areEqual(this.domain, cookieInfoListData.domain) && Intrinsics.areEqual(this.is_http_only, cookieInfoListData.is_http_only) && Intrinsics.areEqual(this.is_secure, cookieInfoListData.is_secure) && Intrinsics.areEqual(this.name, cookieInfoListData.name) && Intrinsics.areEqual(this.path, cookieInfoListData.path) && Intrinsics.areEqual(this.value, cookieInfoListData.value);
    }

    public int hashCode() {
        String str = this.domain;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.is_http_only;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.is_secure;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.path;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.value;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CookieInfoListData(domain=" + this.domain + ", is_http_only=" + this.is_http_only + ", is_secure=" + this.is_secure + ", name=" + this.name + ", path=" + this.path + ", value=" + this.value + ')';
    }

    public CookieInfoListData(String str, Boolean bool, Boolean bool2, String str2, String str3, String str4) {
        this.domain = str;
        this.is_http_only = bool;
        this.is_secure = bool2;
        this.name = str2;
        this.path = str3;
        this.value = str4;
    }

    public /* synthetic */ CookieInfoListData(String str, Boolean bool, Boolean bool2, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final Boolean is_http_only() {
        return this.is_http_only;
    }

    public final Boolean is_secure() {
        return this.is_secure;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getValue() {
        return this.value;
    }
}
