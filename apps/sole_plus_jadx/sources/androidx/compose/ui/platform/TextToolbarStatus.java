package androidx.compose.ui.platform;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TextToolbarStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/TextToolbarStatus;", "", SdkConstants.CONSTRUCTOR_NAME, "(Ljava/lang/String;I)V", "Shown", "Hidden", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextToolbarStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TextToolbarStatus[] $VALUES;
    public static final TextToolbarStatus Shown = new TextToolbarStatus("Shown", 0);
    public static final TextToolbarStatus Hidden = new TextToolbarStatus("Hidden", 1);

    private static final /* synthetic */ TextToolbarStatus[] $values() {
        return new TextToolbarStatus[]{Shown, Hidden};
    }

    public static EnumEntries<TextToolbarStatus> getEntries() {
        return $ENTRIES;
    }

    private TextToolbarStatus(String str, int i) {
    }

    static {
        TextToolbarStatus[] textToolbarStatusArr$values = $values();
        $VALUES = textToolbarStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(textToolbarStatusArr$values);
    }

    public static TextToolbarStatus valueOf(String str) {
        return (TextToolbarStatus) Enum.valueOf(TextToolbarStatus.class, str);
    }

    public static TextToolbarStatus[] values() {
        return (TextToolbarStatus[]) $VALUES.clone();
    }
}
