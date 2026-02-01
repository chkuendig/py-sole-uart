package com.android.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.io.LineProcessor;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class LineCollector implements LineProcessor<List<String>> {
    final ImmutableList.Builder<String> listBuilder = ImmutableList.builder();

    @Override // com.google.common.io.LineProcessor
    public boolean processLine(String line) throws IOException {
        this.listBuilder.add((ImmutableList.Builder<String>) line);
        return true;
    }

    @Override // com.google.common.io.LineProcessor
    public List<String> getResult() {
        return this.listBuilder.build();
    }
}
