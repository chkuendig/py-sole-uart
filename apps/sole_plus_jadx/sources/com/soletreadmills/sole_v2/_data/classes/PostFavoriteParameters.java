package com.soletreadmills.sole_v2._data.classes;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FavoriteRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016Jd\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/PostFavoriteParameters;", "", "object_class_types", "", "", "object_cover_url", "object_id", "object_machine_type", "object_name", "object_type", "object_workout_amount", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getObject_class_types", "()Ljava/util/List;", "getObject_cover_url", "()Ljava/lang/String;", "getObject_id", "getObject_machine_type", "getObject_name", "getObject_type", "getObject_workout_amount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/classes/PostFavoriteParameters;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PostFavoriteParameters {
    public static final int $stable = 8;

    @SerializedName("object_class_types")
    private final List<String> object_class_types;

    @SerializedName("object_cover_url")
    private final String object_cover_url;

    @SerializedName("object_id")
    private final String object_id;

    @SerializedName("object_machine_type")
    private final String object_machine_type;

    @SerializedName("object_name")
    private final String object_name;

    @SerializedName("object_type")
    private final String object_type;

    @SerializedName("object_workout_amount")
    private final Integer object_workout_amount;

    public static /* synthetic */ PostFavoriteParameters copy$default(PostFavoriteParameters postFavoriteParameters, List list, String str, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = postFavoriteParameters.object_class_types;
        }
        if ((i & 2) != 0) {
            str = postFavoriteParameters.object_cover_url;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = postFavoriteParameters.object_id;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = postFavoriteParameters.object_machine_type;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = postFavoriteParameters.object_name;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = postFavoriteParameters.object_type;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            num = postFavoriteParameters.object_workout_amount;
        }
        return postFavoriteParameters.copy(list, str6, str7, str8, str9, str10, num);
    }

    public final List<String> component1() {
        return this.object_class_types;
    }

    /* renamed from: component2, reason: from getter */
    public final String getObject_cover_url() {
        return this.object_cover_url;
    }

    /* renamed from: component3, reason: from getter */
    public final String getObject_id() {
        return this.object_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getObject_machine_type() {
        return this.object_machine_type;
    }

    /* renamed from: component5, reason: from getter */
    public final String getObject_name() {
        return this.object_name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getObject_type() {
        return this.object_type;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getObject_workout_amount() {
        return this.object_workout_amount;
    }

    public final PostFavoriteParameters copy(List<String> object_class_types, String object_cover_url, String object_id, String object_machine_type, String object_name, String object_type, Integer object_workout_amount) {
        Intrinsics.checkNotNullParameter(object_id, "object_id");
        Intrinsics.checkNotNullParameter(object_type, "object_type");
        return new PostFavoriteParameters(object_class_types, object_cover_url, object_id, object_machine_type, object_name, object_type, object_workout_amount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostFavoriteParameters)) {
            return false;
        }
        PostFavoriteParameters postFavoriteParameters = (PostFavoriteParameters) other;
        return Intrinsics.areEqual(this.object_class_types, postFavoriteParameters.object_class_types) && Intrinsics.areEqual(this.object_cover_url, postFavoriteParameters.object_cover_url) && Intrinsics.areEqual(this.object_id, postFavoriteParameters.object_id) && Intrinsics.areEqual(this.object_machine_type, postFavoriteParameters.object_machine_type) && Intrinsics.areEqual(this.object_name, postFavoriteParameters.object_name) && Intrinsics.areEqual(this.object_type, postFavoriteParameters.object_type) && Intrinsics.areEqual(this.object_workout_amount, postFavoriteParameters.object_workout_amount);
    }

    public int hashCode() {
        List<String> list = this.object_class_types;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.object_cover_url;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.object_id.hashCode()) * 31;
        String str2 = this.object_machine_type;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.object_name;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.object_type.hashCode()) * 31;
        Integer num = this.object_workout_amount;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "PostFavoriteParameters(object_class_types=" + this.object_class_types + ", object_cover_url=" + this.object_cover_url + ", object_id=" + this.object_id + ", object_machine_type=" + this.object_machine_type + ", object_name=" + this.object_name + ", object_type=" + this.object_type + ", object_workout_amount=" + this.object_workout_amount + ')';
    }

    public PostFavoriteParameters(List<String> list, String str, String object_id, String str2, String str3, String object_type, Integer num) {
        Intrinsics.checkNotNullParameter(object_id, "object_id");
        Intrinsics.checkNotNullParameter(object_type, "object_type");
        this.object_class_types = list;
        this.object_cover_url = str;
        this.object_id = object_id;
        this.object_machine_type = str2;
        this.object_name = str3;
        this.object_type = object_type;
        this.object_workout_amount = num;
    }

    public /* synthetic */ PostFavoriteParameters(List list, String str, String str2, String str3, String str4, String str5, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, str5, (i & 64) != 0 ? null : num);
    }

    public final List<String> getObject_class_types() {
        return this.object_class_types;
    }

    public final String getObject_cover_url() {
        return this.object_cover_url;
    }

    public final String getObject_id() {
        return this.object_id;
    }

    public final String getObject_machine_type() {
        return this.object_machine_type;
    }

    public final String getObject_name() {
        return this.object_name;
    }

    public final String getObject_type() {
        return this.object_type;
    }

    public final Integer getObject_workout_amount() {
        return this.object_workout_amount;
    }
}
