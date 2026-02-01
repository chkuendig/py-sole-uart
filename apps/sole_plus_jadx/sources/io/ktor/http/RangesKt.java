package io.ktor.http;

import com.android.SdkConstants;
import io.ktor.http.ContentRange;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"parseRangesSpecifier", "Lio/ktor/http/RangesSpecifier;", "rangeSpec", "", "mergeRangesKeepOrder", "", "Lkotlin/ranges/LongRange;", "toLongRanges", "Lio/ktor/http/ContentRange;", "contentLength", "", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RangesKt {
    public static final RangesSpecifier parseRangesSpecifier(String rangeSpec) {
        Pair pair;
        ContentRange bounded;
        Intrinsics.checkNotNullParameter(rangeSpec, "rangeSpec");
        try {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) rangeSpec, "=", 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                return null;
            }
            String strSubstring = rangeSpec.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strSubstring2 = rangeSpec.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            Pair pair2 = TuplesKt.to(strSubstring, strSubstring2);
            String str = (String) pair2.component1();
            List<String> listSplit$default = StringsKt.split$default((CharSequence) pair2.component2(), new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            for (String str2 : listSplit$default) {
                if (StringsKt.startsWith$default(str2, SdkConstants.RES_QUALIFIER_SEP, false, 2, (Object) null)) {
                    bounded = new ContentRange.Suffix(Long.parseLong(StringsKt.removePrefix(str2, (CharSequence) SdkConstants.RES_QUALIFIER_SEP)));
                } else {
                    int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, SdkConstants.RES_QUALIFIER_SEP, 0, false, 6, (Object) null);
                    if (iIndexOf$default2 == -1) {
                        pair = TuplesKt.to("", "");
                    } else {
                        String strSubstring3 = str2.substring(0, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        String strSubstring4 = str2.substring(iIndexOf$default2 + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String).substring(startIndex)");
                        pair = TuplesKt.to(strSubstring3, strSubstring4);
                    }
                    String str3 = (String) pair.component1();
                    String str4 = (String) pair.component2();
                    bounded = str4.length() > 0 ? new ContentRange.Bounded(Long.parseLong(str3), Long.parseLong(str4)) : new ContentRange.TailFrom(Long.parseLong(str3));
                }
                arrayList.add(bounded);
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty() && str.length() != 0) {
                RangesSpecifier rangesSpecifier = new RangesSpecifier(str, arrayList2);
                if (RangesSpecifier.isValid$default(rangesSpecifier, null, 1, null)) {
                    return rangesSpecifier;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final List<LongRange> toLongRanges(List<? extends ContentRange> list, long j) {
        LongRange longRangeUntil;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends ContentRange> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ContentRange contentRange : list2) {
            if (contentRange instanceof ContentRange.Bounded) {
                ContentRange.Bounded bounded = (ContentRange.Bounded) contentRange;
                longRangeUntil = new LongRange(bounded.getFrom(), kotlin.ranges.RangesKt.coerceAtMost(bounded.getTo(), j - 1));
            } else if (contentRange instanceof ContentRange.TailFrom) {
                longRangeUntil = kotlin.ranges.RangesKt.until(((ContentRange.TailFrom) contentRange).getFrom(), j);
            } else {
                if (!(contentRange instanceof ContentRange.Suffix)) {
                    throw new NoWhenBranchMatchedException();
                }
                longRangeUntil = kotlin.ranges.RangesKt.until(kotlin.ranges.RangesKt.coerceAtLeast(j - ((ContentRange.Suffix) contentRange).getLastCount(), 0L), j);
            }
            arrayList.add(longRangeUntil);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((LongRange) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final List<LongRange> mergeRangesKeepOrder(List<LongRange> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<LongRange> listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: io.ktor.http.RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((LongRange) t).getStart(), ((LongRange) t2).getStart());
            }
        });
        ArrayList arrayList = new ArrayList(list.size());
        for (LongRange longRange : listSortedWith) {
            if (arrayList.isEmpty()) {
                arrayList.add(longRange);
            } else {
                ArrayList arrayList2 = arrayList;
                if (((LongRange) CollectionsKt.last((List) arrayList2)).getEndInclusive().longValue() < longRange.getStart().longValue() - 1) {
                    arrayList.add(longRange);
                } else {
                    LongRange longRange2 = (LongRange) CollectionsKt.last((List) arrayList2);
                    arrayList.set(CollectionsKt.getLastIndex(arrayList2), new LongRange(longRange2.getStart().longValue(), Math.max(longRange2.getEndInclusive().longValue(), longRange.getEndInclusive().longValue())));
                }
            }
        }
        LongRange[] longRangeArr = new LongRange[list.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LongRange range = (LongRange) it.next();
            int size = list.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    Intrinsics.checkNotNullExpressionValue(range, "range");
                    if (io.ktor.util.RangesKt.contains(range, list.get(i))) {
                        longRangeArr[i] = range;
                        break;
                    }
                    i++;
                }
            }
        }
        return ArraysKt.filterNotNull(longRangeArr);
    }
}
