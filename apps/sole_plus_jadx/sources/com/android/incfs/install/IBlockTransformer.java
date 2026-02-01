package com.android.incfs.install;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface IBlockTransformer {
    PendingBlock transform(PendingBlock block) throws IOException;
}
