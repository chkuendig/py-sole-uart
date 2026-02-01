package com.facebook.stetho.dumpapp;

import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.LightHttpServer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;

@Deprecated
/* loaded from: classes.dex */
public class DumpappHttpSocketLikeHandler implements SocketLikeHandler {
    private final LightHttpServer mServer;

    public DumpappHttpSocketLikeHandler(Dumper dumper) {
        HandlerRegistry handlerRegistry = new HandlerRegistry();
        handlerRegistry.register(new ExactPathMatcher("/dumpapp"), new DumpappLegacyHttpHandler(dumper));
        this.mServer = new LightHttpServer(handlerRegistry);
    }

    @Override // com.facebook.stetho.server.SocketLikeHandler
    public void onAccepted(SocketLike socketLike) throws IOException {
        this.mServer.serve(socketLike);
    }

    private static class DumpappLegacyHttpHandler implements HttpHandler {
        private static final String CONTENT_TYPE = "application/octet-stream";
        private static final String QUERY_PARAM_ARGV = "argv";
        private static final String RESPONSE_HEADER_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        private final Dumper mDumper;

        public DumpappLegacyHttpHandler(Dumper dumper) {
            this.mDumper = dumper;
        }

        @Override // com.facebook.stetho.server.http.HttpHandler
        public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) throws IOException {
            boolean zEquals = HttpPost.METHOD_NAME.equals(lightHttpRequest.method);
            boolean z = !zEquals && HttpGet.METHOD_NAME.equals(lightHttpRequest.method);
            if (z || zEquals) {
                List<String> queryParameters = lightHttpRequest.uri.getQueryParameters(QUERY_PARAM_ARGV);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Framer framer = new Framer(new ByteArrayInputStream(new byte[0]), byteArrayOutputStream);
                String str = zEquals ? "ERROR" : "WARNING";
                framer.getStderr().println("*** " + str + ": Using legacy HTTP protocol; update dumpapp script! ***");
                if (z) {
                    DumpappSocketLikeHandler.dump(this.mDumper, framer, (String[]) queryParameters.toArray(new String[queryParameters.size()]));
                } else {
                    framer.writeExitCode(1);
                }
                lightHttpResponse.code = 200;
                lightHttpResponse.reasonPhrase = "OK";
                lightHttpResponse.addHeader(RESPONSE_HEADER_ALLOW_ORIGIN, "*");
                lightHttpResponse.body = LightHttpBody.create(byteArrayOutputStream.toByteArray(), "application/octet-stream");
            } else {
                lightHttpResponse.code = 501;
                lightHttpResponse.reasonPhrase = "Not implemented";
                lightHttpResponse.body = LightHttpBody.create(lightHttpRequest.method + " not implemented", HTTP.PLAIN_TEXT_TYPE);
            }
            return true;
        }
    }
}
