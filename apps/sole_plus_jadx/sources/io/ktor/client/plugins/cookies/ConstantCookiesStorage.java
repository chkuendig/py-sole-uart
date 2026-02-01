package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.URLBuilder;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConstantCookiesStorage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\tH\u0016J\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/cookies/ConstantCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "cookies", "", "Lio/ktor/http/Cookie;", "([Lio/ktor/http/Cookie;)V", "storage", "", "addCookie", "", "requestUrl", "Lio/ktor/http/Url;", "cookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ConstantCookiesStorage implements CookiesStorage {
    private final List<Cookie> storage;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public ConstantCookiesStorage(Cookie... cookies) {
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        ArrayList arrayList = new ArrayList(cookies.length);
        for (Cookie cookie : cookies) {
            arrayList.add(CookiesStorageKt.fillDefaults(cookie, new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null).build()));
        }
        this.storage = CollectionsKt.toList(arrayList);
    }

    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    public Object get(Url url, Continuation<? super List<Cookie>> continuation) {
        List<Cookie> list = this.storage;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (CookiesStorageKt.matches((Cookie) obj, url)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // io.ktor.client.plugins.cookies.CookiesStorage
    public Object addCookie(Url url, Cookie cookie, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
