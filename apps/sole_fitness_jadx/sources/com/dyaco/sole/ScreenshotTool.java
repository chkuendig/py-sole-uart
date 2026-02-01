package com.dyaco.sole;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.activity.OutdoorMapsActivity;
import com.dyaco.sole.custom.Global;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ScreenshotTool {
    public static void takeScreenshotFromView(final Activity activity) {
        final View viewFindViewById;
        try {
            viewFindViewById = activity.findViewById(android.R.id.content);
        } catch (Exception e) {
            e.printStackTrace();
            viewFindViewById = null;
        }
        if (viewFindViewById == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.dyaco.sole.ScreenshotTool.1
            /* JADX WARN: Removed duplicated region for block: B:21:0x005e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws IOException {
                Bitmap bitmapCreateBitmap;
                Canvas canvas;
                if (Global.screenshotFile == null) {
                    Global.screenshotFile = new File(activity.getFilesDir(), "share_screenshot.jpg");
                }
                FileOutputStream fileOutputStream = null;
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(viewFindViewById.getMeasuredWidth(), viewFindViewById.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bitmapCreateBitmap = null;
                }
                if (bitmapCreateBitmap == null) {
                    return;
                }
                try {
                    canvas = new Canvas(bitmapCreateBitmap);
                } catch (Exception e3) {
                    e = e3;
                    canvas = null;
                }
                try {
                    View view = viewFindViewById;
                    view.layout(view.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
                    viewFindViewById.draw(canvas);
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    if (canvas != null) {
                    }
                }
                if (canvas != null) {
                    return;
                }
                try {
                    fileOutputStream = new FileOutputStream(Global.screenshotFile);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                if (fileOutputStream == null) {
                    return;
                }
                try {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    Activity activity2 = activity;
                    if (activity2 instanceof MainActivity) {
                        MainActivity mainActivity = (MainActivity) activity2;
                        mainActivity.goShare(mainActivity.nowPage);
                    } else if (activity2 instanceof OutdoorMapsActivity) {
                        OutdoorMapsActivity outdoorMapsActivity = (OutdoorMapsActivity) activity2;
                        outdoorMapsActivity.shareImage(outdoorMapsActivity.getString(com.soletreadmills.sole.R.string.shareto));
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            activity.runOnUiThread(runnable);
        }
    }
}
