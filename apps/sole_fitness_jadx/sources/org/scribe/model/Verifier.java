package org.scribe.model;

import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class Verifier {
    private final String value;

    public Verifier(String str) {
        Preconditions.checkNotNull(str, "Must provide a valid string as verifier");
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
