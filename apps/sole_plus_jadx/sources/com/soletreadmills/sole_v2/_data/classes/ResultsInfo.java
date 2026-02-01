package com.soletreadmills.sole_v2._data.classes;

import kotlin.Metadata;

/* compiled from: ClassesData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/classes/ResultsInfo;", "", "resultCount", "", "filterCount", "(II)V", "getFilterCount", "()I", "getResultCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ResultsInfo {
    public static final int $stable = 0;
    private final int filterCount;
    private final int resultCount;

    public static /* synthetic */ ResultsInfo copy$default(ResultsInfo resultsInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = resultsInfo.resultCount;
        }
        if ((i3 & 2) != 0) {
            i2 = resultsInfo.filterCount;
        }
        return resultsInfo.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getResultCount() {
        return this.resultCount;
    }

    /* renamed from: component2, reason: from getter */
    public final int getFilterCount() {
        return this.filterCount;
    }

    public final ResultsInfo copy(int resultCount, int filterCount) {
        return new ResultsInfo(resultCount, filterCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultsInfo)) {
            return false;
        }
        ResultsInfo resultsInfo = (ResultsInfo) other;
        return this.resultCount == resultsInfo.resultCount && this.filterCount == resultsInfo.filterCount;
    }

    public int hashCode() {
        return (Integer.hashCode(this.resultCount) * 31) + Integer.hashCode(this.filterCount);
    }

    public String toString() {
        return "ResultsInfo(resultCount=" + this.resultCount + ", filterCount=" + this.filterCount + ')';
    }

    public ResultsInfo(int i, int i2) {
        this.resultCount = i;
        this.filterCount = i2;
    }

    public final int getResultCount() {
        return this.resultCount;
    }

    public final int getFilterCount() {
        return this.filterCount;
    }
}
