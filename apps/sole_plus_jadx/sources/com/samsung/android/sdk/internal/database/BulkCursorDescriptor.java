package com.samsung.android.sdk.internal.database;

import android.database.CursorWindow;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public final class BulkCursorDescriptor implements Parcelable {
    public static final Parcelable.Creator<BulkCursorDescriptor> CREATOR = new a();
    public String[] columnNames;
    public int count;
    public IBulkCursor cursor;
    public boolean wantsAllOnMoveCalls;
    public CursorWindow window;

    static class a implements Parcelable.Creator<BulkCursorDescriptor> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public BulkCursorDescriptor createFromParcel(Parcel parcel) {
            BulkCursorDescriptor bulkCursorDescriptor = new BulkCursorDescriptor();
            bulkCursorDescriptor.readFromParcel(parcel);
            return bulkCursorDescriptor;
        }

        @Override // android.os.Parcelable.Creator
        public BulkCursorDescriptor[] newArray(int i) {
            return new BulkCursorDescriptor[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.cursor = BulkCursorNative.asInterface(parcel.readStrongBinder());
        this.columnNames = parcel.createStringArray();
        this.wantsAllOnMoveCalls = parcel.readInt() != 0;
        this.count = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.window = (CursorWindow) CursorWindow.CREATOR.createFromParcel(parcel);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.cursor.asBinder());
        parcel.writeStringArray(this.columnNames);
        parcel.writeInt(this.wantsAllOnMoveCalls ? 1 : 0);
        parcel.writeInt(this.count);
        if (this.window == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            this.window.writeToParcel(parcel, i);
        }
    }
}
