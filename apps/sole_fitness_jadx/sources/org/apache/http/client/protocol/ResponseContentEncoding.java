package org.apache.http.client.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.ParseException;
import org.apache.http.client.entity.DecompressingEntity;
import org.apache.http.client.entity.DeflateInputStream;
import org.apache.http.client.entity.InputStreamFactory;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes2.dex */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";
    private final Lookup<InputStreamFactory> decoderRegistry;
    private final boolean ignoreUnknown;
    private static final InputStreamFactory GZIP = new InputStreamFactory() { // from class: org.apache.http.client.protocol.ResponseContentEncoding.1
        @Override // org.apache.http.client.entity.InputStreamFactory
        public InputStream create(InputStream inputStream) throws IOException {
            return new GZIPInputStream(inputStream);
        }
    };
    private static final InputStreamFactory DEFLATE = new InputStreamFactory() { // from class: org.apache.http.client.protocol.ResponseContentEncoding.2
        @Override // org.apache.http.client.entity.InputStreamFactory
        public InputStream create(InputStream inputStream) throws IOException {
            return new DeflateInputStream(inputStream);
        }
    };

    public ResponseContentEncoding(Lookup<InputStreamFactory> lookup, boolean z) {
        if (lookup == null) {
            RegistryBuilder registryBuilderCreate = RegistryBuilder.create();
            InputStreamFactory inputStreamFactory = GZIP;
            lookup = registryBuilderCreate.register("gzip", inputStreamFactory).register("x-gzip", inputStreamFactory).register("deflate", DEFLATE).build();
        }
        this.decoderRegistry = lookup;
        this.ignoreUnknown = z;
    }

    public ResponseContentEncoding(boolean z) {
        this(null, z);
    }

    public ResponseContentEncoding(Lookup<InputStreamFactory> lookup) {
        this(lookup, true);
    }

    public ResponseContentEncoding() {
        this((Lookup<InputStreamFactory>) null);
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, ParseException, IOException {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (!HttpClientContext.adapt(httpContext).getRequestConfig().isContentCompressionEnabled() || entity == null || entity.getContentLength() == 0 || (contentEncoding = entity.getContentEncoding()) == null) {
            return;
        }
        for (HeaderElement headerElement : contentEncoding.getElements()) {
            String lowerCase = headerElement.getName().toLowerCase(Locale.ROOT);
            InputStreamFactory inputStreamFactoryLookup = this.decoderRegistry.lookup(lowerCase);
            if (inputStreamFactoryLookup != null) {
                httpResponse.setEntity(new DecompressingEntity(httpResponse.getEntity(), inputStreamFactoryLookup));
                httpResponse.removeHeaders("Content-Length");
                httpResponse.removeHeaders("Content-Encoding");
                httpResponse.removeHeaders(HttpHeaders.CONTENT_MD5);
            } else if (!HTTP.IDENTITY_CODING.equals(lowerCase) && !this.ignoreUnknown) {
                throw new HttpException("Unsupported Content-Encoding: " + headerElement.getName());
            }
        }
    }
}
