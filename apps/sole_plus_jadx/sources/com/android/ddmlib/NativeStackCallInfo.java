package com.android.ddmlib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class NativeStackCallInfo {
    private static final Pattern SOURCE_NAME_PATTERN = Pattern.compile("^(.+):(\\d+)(\\s+\\(discriminator\\s+\\d+\\))?$");
    private long mAddress;
    private String mLibrary;
    private int mLineNumber;
    private String mMethod;
    private String mSourceFile;

    public NativeStackCallInfo(long address, String lib, String method, String sourceFile) {
        this.mLineNumber = -1;
        this.mAddress = address;
        this.mLibrary = lib;
        this.mMethod = method;
        Matcher matcher = SOURCE_NAME_PATTERN.matcher(sourceFile);
        if (matcher.matches()) {
            this.mSourceFile = matcher.group(1);
            try {
                this.mLineNumber = Integer.parseInt(matcher.group(2));
            } catch (NumberFormatException unused) {
            }
            if (matcher.groupCount() != 3 || matcher.group(3) == null) {
                return;
            }
            this.mSourceFile += matcher.group(3);
            return;
        }
        this.mSourceFile = sourceFile;
    }

    public long getAddress() {
        return this.mAddress;
    }

    public String getLibraryName() {
        return this.mLibrary;
    }

    public String getMethodName() {
        return this.mMethod;
    }

    public String getSourceFile() {
        return this.mSourceFile;
    }

    public int getLineNumber() {
        return this.mLineNumber;
    }

    public String toString() {
        return String.format("\t%1$08x\t%2$s --- %3$s --- %4$s:%5$d", Long.valueOf(getAddress()), getLibraryName(), getMethodName(), getSourceFile(), Integer.valueOf(getLineNumber()));
    }
}
