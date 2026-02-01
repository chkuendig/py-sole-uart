package com.soletreadmills.sole_v2._data.classes;

import android.net.Uri;
import com.soletreadmills.sole_v2._type.ClassType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetClassVideoDetailApiData.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B×\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jà\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u0011J\t\u0010I\u001a\u00020\bHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\n\u0010(R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010&\u001a\u0004\b,\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001f¨\u0006K"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "", "class_id", "", "class_name", "instructor_avatar_url", "instructor_name", "intro_audio_end_time", "", "intro_fm_station", "is_enabled_background_music", "", "main_fm_station", "mid_fm_station", "outro_audio_start_time_from_the_end", "outro_fm_station", "signed_cookie_infos", "", "Lcom/soletreadmills/sole_v2/_data/classes/CookieInfoListData;", "songs", "Lcom/soletreadmills/sole_v2/_data/classes/SongsData;", "subtitles", "Lcom/soletreadmills/sole_v2/_data/classes/VideoSubtitleData;", "video_url", "class_type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "classType", "Lcom/soletreadmills/sole_v2/_type/ClassType;", "getClassType", "()Lcom/soletreadmills/sole_v2/_type/ClassType;", "getClass_id", "()Ljava/lang/String;", "getClass_name", "getClass_type", "getInstructor_avatar_url", "getInstructor_name", "getIntro_audio_end_time", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIntro_fm_station", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMain_fm_station", "getMid_fm_station", "getOutro_audio_start_time_from_the_end", "getOutro_fm_station", "getSigned_cookie_infos", "()Ljava/util/List;", "getSongs", "getSubtitles", "getVideo_url", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "equals", "other", "getSongsUriList", "Landroid/net/Uri;", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VideoDetailData {
    public static final int $stable = 8;
    private final String class_id;
    private final String class_name;
    private final String class_type;
    private final String instructor_avatar_url;
    private final String instructor_name;
    private final Integer intro_audio_end_time;
    private final String intro_fm_station;
    private final Boolean is_enabled_background_music;
    private final String main_fm_station;
    private final String mid_fm_station;
    private final Integer outro_audio_start_time_from_the_end;
    private final String outro_fm_station;
    private final List<CookieInfoListData> signed_cookie_infos;
    private final List<SongsData> songs;
    private final List<VideoSubtitleData> subtitles;
    private final String video_url;

    public VideoDetailData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClass_id() {
        return this.class_id;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getOutro_audio_start_time_from_the_end() {
        return this.outro_audio_start_time_from_the_end;
    }

    /* renamed from: component11, reason: from getter */
    public final String getOutro_fm_station() {
        return this.outro_fm_station;
    }

    public final List<CookieInfoListData> component12() {
        return this.signed_cookie_infos;
    }

    public final List<SongsData> component13() {
        return this.songs;
    }

    public final List<VideoSubtitleData> component14() {
        return this.subtitles;
    }

    /* renamed from: component15, reason: from getter */
    public final String getVideo_url() {
        return this.video_url;
    }

    /* renamed from: component16, reason: from getter */
    public final String getClass_type() {
        return this.class_type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getClass_name() {
        return this.class_name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInstructor_avatar_url() {
        return this.instructor_avatar_url;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInstructor_name() {
        return this.instructor_name;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getIntro_audio_end_time() {
        return this.intro_audio_end_time;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIntro_fm_station() {
        return this.intro_fm_station;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getIs_enabled_background_music() {
        return this.is_enabled_background_music;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMain_fm_station() {
        return this.main_fm_station;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMid_fm_station() {
        return this.mid_fm_station;
    }

    public final VideoDetailData copy(String class_id, String class_name, String instructor_avatar_url, String instructor_name, Integer intro_audio_end_time, String intro_fm_station, Boolean is_enabled_background_music, String main_fm_station, String mid_fm_station, Integer outro_audio_start_time_from_the_end, String outro_fm_station, List<CookieInfoListData> signed_cookie_infos, List<SongsData> songs, List<VideoSubtitleData> subtitles, String video_url, String class_type) {
        return new VideoDetailData(class_id, class_name, instructor_avatar_url, instructor_name, intro_audio_end_time, intro_fm_station, is_enabled_background_music, main_fm_station, mid_fm_station, outro_audio_start_time_from_the_end, outro_fm_station, signed_cookie_infos, songs, subtitles, video_url, class_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoDetailData)) {
            return false;
        }
        VideoDetailData videoDetailData = (VideoDetailData) other;
        return Intrinsics.areEqual(this.class_id, videoDetailData.class_id) && Intrinsics.areEqual(this.class_name, videoDetailData.class_name) && Intrinsics.areEqual(this.instructor_avatar_url, videoDetailData.instructor_avatar_url) && Intrinsics.areEqual(this.instructor_name, videoDetailData.instructor_name) && Intrinsics.areEqual(this.intro_audio_end_time, videoDetailData.intro_audio_end_time) && Intrinsics.areEqual(this.intro_fm_station, videoDetailData.intro_fm_station) && Intrinsics.areEqual(this.is_enabled_background_music, videoDetailData.is_enabled_background_music) && Intrinsics.areEqual(this.main_fm_station, videoDetailData.main_fm_station) && Intrinsics.areEqual(this.mid_fm_station, videoDetailData.mid_fm_station) && Intrinsics.areEqual(this.outro_audio_start_time_from_the_end, videoDetailData.outro_audio_start_time_from_the_end) && Intrinsics.areEqual(this.outro_fm_station, videoDetailData.outro_fm_station) && Intrinsics.areEqual(this.signed_cookie_infos, videoDetailData.signed_cookie_infos) && Intrinsics.areEqual(this.songs, videoDetailData.songs) && Intrinsics.areEqual(this.subtitles, videoDetailData.subtitles) && Intrinsics.areEqual(this.video_url, videoDetailData.video_url) && Intrinsics.areEqual(this.class_type, videoDetailData.class_type);
    }

    public int hashCode() {
        String str = this.class_id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.class_name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.instructor_avatar_url;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.instructor_name;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.intro_audio_end_time;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.intro_fm_station;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.is_enabled_background_music;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.main_fm_station;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mid_fm_station;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num2 = this.outro_audio_start_time_from_the_end;
        int iHashCode10 = (iHashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str8 = this.outro_fm_station;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<CookieInfoListData> list = this.signed_cookie_infos;
        int iHashCode12 = (iHashCode11 + (list == null ? 0 : list.hashCode())) * 31;
        List<SongsData> list2 = this.songs;
        int iHashCode13 = (iHashCode12 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<VideoSubtitleData> list3 = this.subtitles;
        int iHashCode14 = (iHashCode13 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str9 = this.video_url;
        int iHashCode15 = (iHashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.class_type;
        return iHashCode15 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoDetailData(class_id=");
        sb.append(this.class_id).append(", class_name=").append(this.class_name).append(", instructor_avatar_url=").append(this.instructor_avatar_url).append(", instructor_name=").append(this.instructor_name).append(", intro_audio_end_time=").append(this.intro_audio_end_time).append(", intro_fm_station=").append(this.intro_fm_station).append(", is_enabled_background_music=").append(this.is_enabled_background_music).append(", main_fm_station=").append(this.main_fm_station).append(", mid_fm_station=").append(this.mid_fm_station).append(", outro_audio_start_time_from_the_end=").append(this.outro_audio_start_time_from_the_end).append(", outro_fm_station=").append(this.outro_fm_station).append(", signed_cookie_infos=");
        sb.append(this.signed_cookie_infos).append(", songs=").append(this.songs).append(", subtitles=").append(this.subtitles).append(", video_url=").append(this.video_url).append(", class_type=").append(this.class_type).append(')');
        return sb.toString();
    }

    public VideoDetailData(String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, String str6, String str7, Integer num2, String str8, List<CookieInfoListData> list, List<SongsData> list2, List<VideoSubtitleData> list3, String str9, String str10) {
        this.class_id = str;
        this.class_name = str2;
        this.instructor_avatar_url = str3;
        this.instructor_name = str4;
        this.intro_audio_end_time = num;
        this.intro_fm_station = str5;
        this.is_enabled_background_music = bool;
        this.main_fm_station = str6;
        this.mid_fm_station = str7;
        this.outro_audio_start_time_from_the_end = num2;
        this.outro_fm_station = str8;
        this.signed_cookie_infos = list;
        this.songs = list2;
        this.subtitles = list3;
        this.video_url = str9;
        this.class_type = str10;
    }

    public /* synthetic */ VideoDetailData(String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, String str6, String str7, Integer num2, String str8, List list, List list2, List list3, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : list, (i & 4096) != 0 ? null : list2, (i & 8192) != 0 ? null : list3, (i & 16384) != 0 ? null : str9, (i & 32768) != 0 ? null : str10);
    }

    public final String getClass_id() {
        return this.class_id;
    }

    public final String getClass_name() {
        return this.class_name;
    }

    public final String getInstructor_avatar_url() {
        return this.instructor_avatar_url;
    }

    public final String getInstructor_name() {
        return this.instructor_name;
    }

    public final Integer getIntro_audio_end_time() {
        return this.intro_audio_end_time;
    }

    public final String getIntro_fm_station() {
        return this.intro_fm_station;
    }

    public final Boolean is_enabled_background_music() {
        return this.is_enabled_background_music;
    }

    public final String getMain_fm_station() {
        return this.main_fm_station;
    }

    public final String getMid_fm_station() {
        return this.mid_fm_station;
    }

    public final Integer getOutro_audio_start_time_from_the_end() {
        return this.outro_audio_start_time_from_the_end;
    }

    public final String getOutro_fm_station() {
        return this.outro_fm_station;
    }

    public final List<CookieInfoListData> getSigned_cookie_infos() {
        return this.signed_cookie_infos;
    }

    public final List<SongsData> getSongs() {
        return this.songs;
    }

    public final List<VideoSubtitleData> getSubtitles() {
        return this.subtitles;
    }

    public final String getVideo_url() {
        return this.video_url;
    }

    public final String getClass_type() {
        return this.class_type;
    }

    public final ClassType getClassType() {
        return ClassType.INSTANCE.fromRaw(this.class_type);
    }

    public final List<Uri> getSongsUriList() {
        Object objM9087constructorimpl;
        List<SongsData> list = this.songs;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String hls_url = ((SongsData) it.next()).getHls_url();
            if (hls_url != null) {
                arrayList.add(hls_url);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            try {
                Result.Companion companion = Result.INSTANCE;
                VideoDetailData videoDetailData = this;
                objM9087constructorimpl = Result.m9087constructorimpl(Uri.parse(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9093isFailureimpl(objM9087constructorimpl)) {
                objM9087constructorimpl = null;
            }
            Uri uri = (Uri) objM9087constructorimpl;
            if (uri != null) {
                arrayList2.add(uri);
            }
        }
        return arrayList2;
    }
}
