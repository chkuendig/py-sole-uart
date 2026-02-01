package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;

@Deprecated
/* loaded from: classes4.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: id, reason: collision with root package name */
    public final String f161id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Id3Frame(String str) {
        this.f161id = str;
    }

    public String toString() {
        return this.f161id;
    }
}
