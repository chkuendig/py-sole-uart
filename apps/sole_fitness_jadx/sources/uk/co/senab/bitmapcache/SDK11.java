package uk.co.senab.bitmapcache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* loaded from: classes3.dex */
class SDK11 {
    SDK11() {
    }

    static void addInBitmapOption(BitmapFactory.Options options, Bitmap bitmap) {
        options.inBitmap = bitmap;
    }
}
