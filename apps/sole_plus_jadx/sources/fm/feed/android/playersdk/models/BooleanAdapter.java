package fm.feed.android.playersdk.models;

import com.android.SdkConstants;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Station.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lfm/feed/android/playersdk/models/BooleanAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", SdkConstants.UNIT_IN, "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Boolean;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class BooleanAdapter extends TypeAdapter<Boolean> {
    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
        write(jsonWriter, bool.booleanValue());
    }

    public void write(JsonWriter out, boolean value) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        out.value(value ? 1L : 0L);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Boolean read(JsonReader in) throws IOException {
        Intrinsics.checkNotNullParameter(in, "in");
        return Boolean.valueOf(in.nextInt() != 0);
    }
}
