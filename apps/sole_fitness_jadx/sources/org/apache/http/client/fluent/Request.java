package org.apache.http.client.fluent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public class Request {
    public static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final Locale DATE_LOCALE = Locale.US;
    public static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GMT");
    private Integer connectTimeout;
    private SimpleDateFormat dateFormatter;
    private HttpHost proxy;
    private final InternalHttpRequest request;
    private Integer socketTmeout;
    private Boolean useExpectContinue;

    @Deprecated
    public Request config(String str, Object obj) {
        return this;
    }

    @Deprecated
    public Request elementCharset(String str) {
        return this;
    }

    @Deprecated
    public Request removeConfig(String str) {
        return this;
    }

    @Deprecated
    public Request staleConnectionCheck(boolean z) {
        return this;
    }

    public static Request Get(URI uri) {
        return new Request(new InternalHttpRequest(HttpGet.METHOD_NAME, uri));
    }

    public static Request Get(String str) {
        return new Request(new InternalHttpRequest(HttpGet.METHOD_NAME, URI.create(str)));
    }

    public static Request Head(URI uri) {
        return new Request(new InternalHttpRequest(HttpHead.METHOD_NAME, uri));
    }

    public static Request Head(String str) {
        return new Request(new InternalHttpRequest(HttpHead.METHOD_NAME, URI.create(str)));
    }

    public static Request Post(URI uri) {
        return new Request(new InternalEntityEnclosingHttpRequest(HttpPost.METHOD_NAME, uri));
    }

    public static Request Post(String str) {
        return new Request(new InternalEntityEnclosingHttpRequest(HttpPost.METHOD_NAME, URI.create(str)));
    }

    public static Request Patch(URI uri) {
        return new Request(new InternalEntityEnclosingHttpRequest(HttpPatch.METHOD_NAME, uri));
    }

    public static Request Patch(String str) {
        return new Request(new InternalEntityEnclosingHttpRequest(HttpPatch.METHOD_NAME, URI.create(str)));
    }

    public static Request Put(URI uri) {
        return new Request(new InternalEntityEnclosingHttpRequest(HttpPut.METHOD_NAME, uri));
    }

    public static Request Put(String str) {
        return new Request(new InternalEntityEnclosingHttpRequest(HttpPut.METHOD_NAME, URI.create(str)));
    }

    public static Request Trace(URI uri) {
        return new Request(new InternalHttpRequest(HttpTrace.METHOD_NAME, uri));
    }

    public static Request Trace(String str) {
        return new Request(new InternalHttpRequest(HttpTrace.METHOD_NAME, URI.create(str)));
    }

    public static Request Delete(URI uri) {
        return new Request(new InternalHttpRequest(HttpDelete.METHOD_NAME, uri));
    }

    public static Request Delete(String str) {
        return new Request(new InternalHttpRequest(HttpDelete.METHOD_NAME, URI.create(str)));
    }

    public static Request Options(URI uri) {
        return new Request(new InternalHttpRequest(HttpOptions.METHOD_NAME, uri));
    }

    public static Request Options(String str) {
        return new Request(new InternalHttpRequest(HttpOptions.METHOD_NAME, URI.create(str)));
    }

    Request(InternalHttpRequest internalHttpRequest) {
        this.request = internalHttpRequest;
    }

    HttpResponse internalExecute(HttpClient httpClient, HttpContext httpContext) throws IOException {
        RequestConfig.Builder builderCustom;
        if (httpClient instanceof Configurable) {
            builderCustom = RequestConfig.copy(((Configurable) httpClient).getConfig());
        } else {
            builderCustom = RequestConfig.custom();
        }
        Boolean bool = this.useExpectContinue;
        if (bool != null) {
            builderCustom.setExpectContinueEnabled(bool.booleanValue());
        }
        Integer num = this.socketTmeout;
        if (num != null) {
            builderCustom.setSocketTimeout(num.intValue());
        }
        Integer num2 = this.connectTimeout;
        if (num2 != null) {
            builderCustom.setConnectTimeout(num2.intValue());
        }
        HttpHost httpHost = this.proxy;
        if (httpHost != null) {
            builderCustom.setProxy(httpHost);
        }
        this.request.setConfig(builderCustom.build());
        return httpClient.execute(this.request, httpContext);
    }

    public Response execute() throws IOException {
        return new Response(internalExecute(Executor.CLIENT, null));
    }

    public void abort() throws UnsupportedOperationException {
        this.request.abort();
    }

    public Request addHeader(Header header) {
        this.request.addHeader(header);
        return this;
    }

    public Request setHeader(Header header) {
        this.request.setHeader(header);
        return this;
    }

    public Request addHeader(String str, String str2) {
        this.request.addHeader(str, str2);
        return this;
    }

    public Request setHeader(String str, String str2) {
        this.request.setHeader(str, str2);
        return this;
    }

    public Request removeHeader(Header header) {
        this.request.removeHeader(header);
        return this;
    }

    public Request removeHeaders(String str) {
        this.request.removeHeaders(str);
        return this;
    }

    public Request setHeaders(Header... headerArr) {
        this.request.setHeaders(headerArr);
        return this;
    }

    public Request setCacheControl(String str) {
        this.request.setHeader("Cache-Control", str);
        return this;
    }

    private SimpleDateFormat getDateFormat() {
        if (this.dateFormatter == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", DATE_LOCALE);
            this.dateFormatter = simpleDateFormat;
            simpleDateFormat.setTimeZone(TIME_ZONE);
        }
        return this.dateFormatter;
    }

    public Request setDate(Date date) {
        this.request.setHeader("Date", getDateFormat().format(date));
        return this;
    }

    public Request setIfModifiedSince(Date date) {
        this.request.setHeader("If-Modified-Since", getDateFormat().format(date));
        return this;
    }

    public Request setIfUnmodifiedSince(Date date) {
        this.request.setHeader("If-Unmodified-Since", getDateFormat().format(date));
        return this;
    }

    public Request version(HttpVersion httpVersion) {
        this.request.setProtocolVersion(httpVersion);
        return this;
    }

    public Request useExpectContinue() {
        this.useExpectContinue = Boolean.TRUE;
        return this;
    }

    public Request userAgent(String str) {
        this.request.setHeader("User-Agent", str);
        return this;
    }

    public Request socketTimeout(int i) {
        this.socketTmeout = Integer.valueOf(i);
        return this;
    }

    public Request connectTimeout(int i) {
        this.connectTimeout = Integer.valueOf(i);
        return this;
    }

    public Request viaProxy(HttpHost httpHost) {
        this.proxy = httpHost;
        return this;
    }

    public Request viaProxy(String str) {
        this.proxy = HttpHost.create(str);
        return this;
    }

    public Request body(HttpEntity httpEntity) {
        Configurable configurable = this.request;
        if (configurable instanceof HttpEntityEnclosingRequest) {
            ((HttpEntityEnclosingRequest) configurable).setEntity(httpEntity);
            return this;
        }
        throw new IllegalStateException(this.request.getMethod() + " request cannot enclose an entity");
    }

    public Request bodyForm(Iterable<? extends NameValuePair> iterable, Charset charset) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends NameValuePair> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return bodyString(URLEncodedUtils.format(arrayList, charset != null ? charset.name() : null), ContentType.create("application/x-www-form-urlencoded", charset));
    }

    public Request bodyForm(Iterable<? extends NameValuePair> iterable) {
        return bodyForm(iterable, Consts.ISO_8859_1);
    }

    public Request bodyForm(NameValuePair... nameValuePairArr) {
        return bodyForm(Arrays.asList(nameValuePairArr), Consts.ISO_8859_1);
    }

    public Request bodyString(String str, ContentType contentType) {
        Charset charset = contentType != null ? contentType.getCharset() : null;
        return body(new InternalByteArrayEntity(charset != null ? str.getBytes(charset) : str.getBytes(), contentType));
    }

    public Request bodyFile(File file, ContentType contentType) {
        return body(new InternalFileEntity(file, contentType));
    }

    public Request bodyByteArray(byte[] bArr) {
        return body(new InternalByteArrayEntity(bArr));
    }

    public Request bodyByteArray(byte[] bArr, ContentType contentType) {
        return body(new InternalByteArrayEntity(bArr, contentType));
    }

    public Request bodyByteArray(byte[] bArr, int i, int i2) {
        return body(new InternalByteArrayEntity(bArr, i, i2));
    }

    public Request bodyByteArray(byte[] bArr, int i, int i2, ContentType contentType) {
        return body(new InternalByteArrayEntity(bArr, i, i2, contentType));
    }

    public Request bodyStream(InputStream inputStream) {
        return body(new InternalInputStreamEntity(inputStream, -1L, null));
    }

    public Request bodyStream(InputStream inputStream, ContentType contentType) {
        return body(new InternalInputStreamEntity(inputStream, -1L, contentType));
    }

    public String toString() {
        return this.request.getRequestLine().toString();
    }
}
