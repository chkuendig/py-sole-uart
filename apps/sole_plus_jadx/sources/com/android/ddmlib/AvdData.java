package com.android.ddmlib;

import java.util.Objects;

/* loaded from: classes3.dex */
public class AvdData {
    private final String name;
    private final String path;

    public AvdData(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.path);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AvdData)) {
            return false;
        }
        AvdData avdData = (AvdData) obj;
        return Objects.equals(this.name, avdData.name) && Objects.equals(this.path, avdData.path);
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }
}
