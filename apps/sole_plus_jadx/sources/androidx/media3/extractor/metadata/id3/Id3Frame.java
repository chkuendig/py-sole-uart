package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;

/* loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: id, reason: collision with root package name */
    public final String f128id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Id3Frame(String str) {
        this.f128id = str;
    }

    public String toString() {
        return this.f128id;
    }
}
