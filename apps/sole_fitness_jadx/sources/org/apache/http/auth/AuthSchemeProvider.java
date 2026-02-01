package org.apache.http.auth;

import org.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext httpContext);
}
