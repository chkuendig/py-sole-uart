package com.android.ddmlib;

import com.google.common.base.Charsets;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public abstract class MultiLineReceiver implements IShellOutputReceiver {
    private boolean mTrimLines = true;
    private String mUnfinishedLine = null;
    private final Collection<String> mArray = new ArrayList();

    public void done() {
    }

    public abstract void processNewLines(String[] lines);

    public void setTrimLine(boolean trim) {
        this.mTrimLines = trim;
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public final void addOutput(byte[] data, int offset, int length) {
        int i;
        if (isCancelled()) {
            return;
        }
        String str = new String(data, offset, length, Charsets.UTF_8);
        if (this.mUnfinishedLine != null) {
            str = this.mUnfinishedLine + str;
            this.mUnfinishedLine = null;
        }
        this.mArray.clear();
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(10, i2);
            if (iIndexOf == -1) {
                break;
            }
            if (iIndexOf <= 0 || str.charAt(iIndexOf - 1) != '\r') {
                i = 1;
            } else {
                iIndexOf--;
                i = 2;
            }
            String strSubstring = str.substring(i2, iIndexOf);
            if (this.mTrimLines) {
                strSubstring = strSubstring.trim();
            }
            this.mArray.add(strSubstring);
            i2 = iIndexOf + i;
        }
        this.mUnfinishedLine = str.substring(i2);
        if (this.mArray.isEmpty()) {
            return;
        }
        processNewLines((String[]) this.mArray.toArray(new String[0]));
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void flush() {
        String str = this.mUnfinishedLine;
        if (str != null) {
            processNewLines(new String[]{str});
        }
        done();
    }
}
