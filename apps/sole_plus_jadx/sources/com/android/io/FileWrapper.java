package com.android.io;

import com.android.io.StreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class FileWrapper extends File implements IAbstractFile {
    private static final long serialVersionUID = 1;

    public FileWrapper(File file) {
        super(file.getAbsolutePath());
    }

    public FileWrapper(File parent, String child) {
        super(parent, child);
    }

    @Override // com.android.io.IAbstractFile
    public InputStream getContents() throws StreamException {
        try {
            return new FileInputStream(this);
        } catch (FileNotFoundException e) {
            throw new StreamException(e, this, StreamException.Error.FILENOTFOUND);
        }
    }

    @Override // com.android.io.IAbstractFile
    public void setContents(InputStream source) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = source.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException e2) {
                        throw new StreamException(e2, this);
                    }
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            throw new StreamException(e, this);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    throw new StreamException(e4, this);
                }
            }
            throw th;
        }
    }

    @Override // com.android.io.IAbstractFile
    public OutputStream getOutputStream() throws StreamException {
        try {
            return new FileOutputStream(this);
        } catch (FileNotFoundException e) {
            throw new StreamException(e, this);
        }
    }

    @Override // com.android.io.IAbstractResource
    public String getOsLocation() {
        return getAbsolutePath();
    }

    @Override // java.io.File, com.android.io.IAbstractResource
    public boolean exists() {
        return isFile();
    }
}
