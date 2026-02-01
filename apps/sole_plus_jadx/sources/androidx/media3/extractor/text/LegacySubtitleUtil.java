package androidx.media3.extractor.text;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;

/* loaded from: classes3.dex */
public class LegacySubtitleUtil {
    private LegacySubtitleUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void toCuesWithTiming(androidx.media3.extractor.text.Subtitle r11, androidx.media3.extractor.text.SubtitleParser.OutputOptions r12, androidx.media3.common.util.Consumer<androidx.media3.extractor.text.CuesWithTiming> r13) {
        /*
            int r0 = getStartIndex(r11, r12)
            long r1 = r12.startTimeUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L3d
            long r3 = r12.startTimeUs
            java.util.List r6 = r11.getCues(r3)
            long r3 = r11.getEventTime(r0)
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L3d
            int r1 = r11.getEventTimeCount()
            if (r0 >= r1) goto L3d
            long r7 = r12.startTimeUs
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L3d
            androidx.media3.extractor.text.CuesWithTiming r1 = new androidx.media3.extractor.text.CuesWithTiming
            long r7 = r12.startTimeUs
            long r9 = r12.startTimeUs
            long r9 = r3 - r9
            r5 = r1
            r5.<init>(r6, r7, r9)
            r13.accept(r1)
            r1 = 1
            goto L3e
        L3d:
            r1 = r2
        L3e:
            r3 = r0
        L3f:
            int r4 = r11.getEventTimeCount()
            if (r3 >= r4) goto L4b
            outputSubtitleEvent(r11, r3, r13)
            int r3 = r3 + 1
            goto L3f
        L4b:
            boolean r3 = r12.outputAllCues
            if (r3 == 0) goto L78
            if (r1 == 0) goto L53
            int r0 = r0 + (-1)
        L53:
            if (r2 >= r0) goto L5b
            outputSubtitleEvent(r11, r2, r13)
            int r2 = r2 + 1
            goto L53
        L5b:
            if (r1 == 0) goto L78
            androidx.media3.extractor.text.CuesWithTiming r1 = new androidx.media3.extractor.text.CuesWithTiming
            long r2 = r12.startTimeUs
            java.util.List r4 = r11.getCues(r2)
            long r5 = r11.getEventTime(r0)
            long r2 = r12.startTimeUs
            long r11 = r11.getEventTime(r0)
            long r7 = r2 - r11
            r3 = r1
            r3.<init>(r4, r5, r7)
            r13.accept(r1)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.LegacySubtitleUtil.toCuesWithTiming(androidx.media3.extractor.text.Subtitle, androidx.media3.extractor.text.SubtitleParser$OutputOptions, androidx.media3.common.util.Consumer):void");
    }

    private static int getStartIndex(Subtitle subtitle, SubtitleParser.OutputOptions outputOptions) {
        if (outputOptions.startTimeUs == -9223372036854775807L) {
            return 0;
        }
        int nextEventTimeIndex = subtitle.getNextEventTimeIndex(outputOptions.startTimeUs);
        if (nextEventTimeIndex == -1) {
            return subtitle.getEventTimeCount();
        }
        return (nextEventTimeIndex <= 0 || subtitle.getEventTime(nextEventTimeIndex + (-1)) != outputOptions.startTimeUs) ? nextEventTimeIndex : nextEventTimeIndex - 1;
    }

    private static void outputSubtitleEvent(Subtitle subtitle, int i, Consumer<CuesWithTiming> consumer) {
        long eventTime = subtitle.getEventTime(i);
        List<Cue> cues = subtitle.getCues(eventTime);
        if (cues.isEmpty()) {
            return;
        }
        if (i == subtitle.getEventTimeCount() - 1) {
            throw new IllegalStateException();
        }
        consumer.accept(new CuesWithTiming(cues, eventTime, subtitle.getEventTime(i + 1) - subtitle.getEventTime(i)));
    }
}
