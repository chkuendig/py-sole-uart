package com.android.ide.common.blame;

import com.google.common.base.Objects;
import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class SourceFile implements Serializable {
    public static final SourceFile UNKNOWN = new SourceFile();
    private final String mDescription;
    private final String mFilePath;
    private String mSourcePath;

    public SourceFile(File sourceFile, String description) {
        this.mFilePath = sourceFile.getAbsolutePath();
        this.mDescription = description;
    }

    public SourceFile(File sourceFile) {
        this(sourceFile, null);
    }

    public SourceFile(String description) {
        this.mFilePath = null;
        this.mDescription = description;
    }

    private SourceFile() {
        this.mFilePath = null;
        this.mDescription = null;
    }

    public void setOverrideSourcePath(String value) {
        this.mSourcePath = value;
    }

    public File getSourceFile() {
        if (this.mFilePath != null) {
            return new File(this.mFilePath);
        }
        return null;
    }

    public String getSourcePath() {
        String str = this.mSourcePath;
        if (str != null) {
            return str;
        }
        String str2 = this.mFilePath;
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceFile)) {
            return false;
        }
        SourceFile sourceFile = (SourceFile) obj;
        return Objects.equal(this.mDescription, sourceFile.mDescription) && Objects.equal(getSourcePath(), sourceFile.getSourcePath());
    }

    public int hashCode() {
        return Objects.hashCode(getSourcePath(), this.mDescription);
    }

    public String toString() {
        return print(false);
    }

    public String print(boolean shortFormat) {
        String str = this.mSourcePath;
        if (str == null && (str = this.mFilePath) == null) {
            String str2 = this.mDescription;
            return str2 == null ? "Unknown source file" : str2;
        }
        String name = new File(str).getName();
        if (shortFormat) {
            str = name;
        }
        String str3 = this.mDescription;
        return (str3 == null || str3.equals(name)) ? str : String.format("[%1$s] %2$s", this.mDescription, str);
    }
}
