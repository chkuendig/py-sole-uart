package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object objInvoke;
        Font font;
        List list2;
        List list3;
        Object objM9087constructorimpl;
        Font font2;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font3 = list.get(i);
            int loadingStrategy = font3.getLoadingStrategy();
            if (!FontLoadingStrategy.m6817equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6822getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m6817equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6823getOptionalLocalPKNRLFQ())) {
                    list3 = listMutableListOf;
                    if (FontLoadingStrategy.m6817equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m6821getAsyncPKNRLFQ())) {
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM6783get1ASDuI8 = asyncTypefaceCache.m6783get1ASDuI8(font3, platformFontLoader);
                        if (asyncTypefaceResultM6783get1ASDuI8 == null) {
                            if (list3 == null) {
                                listMutableListOf = CollectionsKt.mutableListOf(font3);
                            } else {
                                list3.add(font3);
                            }
                        } else if (!AsyncTypefaceCache.AsyncTypefaceResult.m6789isPermanentFailureimpl(asyncTypefaceResultM6783get1ASDuI8.m6791unboximpl()) && asyncTypefaceResultM6783get1ASDuI8.m6791unboximpl() != null) {
                            return TuplesKt.to(list3, FontSynthesis_androidKt.m6851synthesizeTypefaceFxwP2eA(typefaceRequest.m6877getFontSynthesisGVVA2EU(), asyncTypefaceResultM6783get1ASDuI8.m6791unboximpl(), font3, typefaceRequest.getFontWeight(), typefaceRequest.m6876getFontStyle_LCdwA()));
                        }
                    } else {
                        throw new IllegalStateException("Unknown font type " + font3);
                    }
                } else {
                    synchronized (asyncTypefaceCache.cacheLock) {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font3, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objM9087constructorimpl = asyncTypefaceResult.m6791unboximpl();
                            font2 = font3;
                            list3 = listMutableListOf;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                objM9087constructorimpl = Result.m9087constructorimpl(platformFontLoader.loadBlocking(font3));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM9087constructorimpl = Result.m9087constructorimpl(ResultKt.createFailure(th));
                            }
                            if (Result.m9093isFailureimpl(objM9087constructorimpl)) {
                                objM9087constructorimpl = null;
                            }
                            font2 = font3;
                            list3 = listMutableListOf;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font3, platformFontLoader, objM9087constructorimpl, false, 8, null);
                        }
                    }
                    if (objM9087constructorimpl != null) {
                        return TuplesKt.to(list3, FontSynthesis_androidKt.m6851synthesizeTypefaceFxwP2eA(typefaceRequest.m6877getFontSynthesisGVVA2EU(), objM9087constructorimpl, font2, typefaceRequest.getFontWeight(), typefaceRequest.m6876getFontStyle_LCdwA()));
                    }
                }
                listMutableListOf = list3;
            } else {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font3, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        objInvoke = asyncTypefaceResult2.m6791unboximpl();
                        font = font3;
                        list2 = listMutableListOf;
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            objInvoke = platformFontLoader.loadBlocking(font3);
                        } catch (Exception unused) {
                            objInvoke = function1.invoke(typefaceRequest);
                        }
                        font = font3;
                        list2 = listMutableListOf;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font3, platformFontLoader, objInvoke, false, 8, null);
                    }
                }
                if (objInvoke == null) {
                    objInvoke = function1.invoke(typefaceRequest);
                }
                return TuplesKt.to(list2, FontSynthesis_androidKt.m6851synthesizeTypefaceFxwP2eA(typefaceRequest.m6877getFontSynthesisGVVA2EU(), objInvoke, font, typefaceRequest.getFontWeight(), typefaceRequest.m6876getFontStyle_LCdwA()));
            }
        }
        return TuplesKt.to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
