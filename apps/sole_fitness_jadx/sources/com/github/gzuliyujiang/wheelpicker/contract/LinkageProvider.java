package com.github.gzuliyujiang.wheelpicker.contract;

import java.util.List;

/* loaded from: classes.dex */
public interface LinkageProvider {
    public static final int INDEX_NO_FOUND = -1;

    int findFirstIndex(Object obj);

    int findSecondIndex(int i, Object obj);

    int findThirdIndex(int i, int i2, Object obj);

    boolean firstLevelVisible();

    List<?> linkageSecondData(int i);

    List<?> linkageThirdData(int i, int i2);

    List<?> provideFirstData();

    boolean thirdLevelVisible();
}
