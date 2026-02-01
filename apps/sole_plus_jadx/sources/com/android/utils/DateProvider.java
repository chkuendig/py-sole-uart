package com.android.utils;

import java.util.Date;

/* loaded from: classes3.dex */
public interface DateProvider {
    public static final DateProvider SYSTEM = new DateProvider() { // from class: com.android.utils.DateProvider.1
        @Override // com.android.utils.DateProvider
        public Date now() {
            return new Date();
        }
    };

    Date now();
}
