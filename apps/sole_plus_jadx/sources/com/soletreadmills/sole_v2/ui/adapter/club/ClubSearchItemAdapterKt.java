package com.soletreadmills.sole_v2.ui.adapter.club;

import android.content.Context;
import com.android.SdkConstants;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import kotlin.Metadata;

/* compiled from: ClubSearchItemAdapter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"formatStartLabel", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "startTimeMillis", "", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubSearchItemAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatStartLabel(Context context, long j) {
        LocalDate localDateNow = LocalDate.now();
        LocalDate localDate = Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()).toLocalDate();
        if (localDate.isEqual(localDateNow)) {
            return "Today";
        }
        if (localDate.isEqual(localDateNow.plusDays(1L))) {
            return "From Tomorrow";
        }
        return "From " + localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));
    }
}
