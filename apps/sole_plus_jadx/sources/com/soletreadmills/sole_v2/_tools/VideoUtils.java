package com.soletreadmills.sole_v2._tools;

import com.soletreadmills.sole_v2._data.classes.VideoSubtitleData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SrtParser.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/VideoUtils;", "", "()V", "getSrtURL", "", "data", "Lcom/soletreadmills/sole_v2/_data/classes/VideoDetailData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoUtils {
    public static final int $stable = 0;
    public static final VideoUtils INSTANCE = new VideoUtils();

    private VideoUtils() {
    }

    public final String getSrtURL(com.soletreadmills.sole_v2._data.classes.VideoDetailData data) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(data, "data");
        List<VideoSubtitleData> subtitles = data.getSubtitles();
        if (subtitles == null) {
            return null;
        }
        Iterator<VideoSubtitleData> it = subtitles.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            iIntValue = -1;
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (Intrinsics.areEqual(it.next().getLang_tag(), Global.INSTANCE.getSubtitleLangStr())) {
                break;
            }
            i2++;
        }
        Integer numValueOf = Integer.valueOf(i2);
        if (numValueOf.intValue() < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            Iterator<VideoSubtitleData> it2 = subtitles.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(it2.next().getLang_tag(), "en")) {
                    iIntValue = i;
                    break;
                }
                i++;
            }
        }
        if (iIntValue >= 0) {
            return subtitles.get(iIntValue).getUrl();
        }
        return null;
    }
}
