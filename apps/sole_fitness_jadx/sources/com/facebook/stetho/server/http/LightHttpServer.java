package com.facebook.stetho.server.http;

import android.net.Uri;
import com.facebook.stetho.server.LeakyBufferedInputStream;
import com.facebook.stetho.server.SocketLike;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.HTTP;

/* loaded from: classes.dex */
public class LightHttpServer {
    private static final String TAG = "LightHttpServer";
    private final HandlerRegistry mHandlerRegistry;

    public LightHttpServer(HandlerRegistry handlerRegistry) {
        this.mHandlerRegistry = handlerRegistry;
    }

    public void serve(SocketLike socketLike) throws IOException {
        LeakyBufferedInputStream leakyBufferedInputStream = new LeakyBufferedInputStream(socketLike.getInput(), 1024);
        OutputStream output = socketLike.getOutput();
        HttpMessageReader httpMessageReader = new HttpMessageReader(leakyBufferedInputStream);
        HttpMessageWriter httpMessageWriter = new HttpMessageWriter(new BufferedOutputStream(output));
        SocketLike socketLike2 = new SocketLike(socketLike, leakyBufferedInputStream);
        LightHttpRequest lightHttpRequest = new LightHttpRequest();
        LightHttpResponse lightHttpResponse = new LightHttpResponse();
        while (true) {
            LightHttpRequest requestMessage = readRequestMessage(lightHttpRequest, httpMessageReader);
            if (requestMessage == null) {
                return;
            }
            lightHttpResponse.reset();
            if (!dispatchToHandler(socketLike2, requestMessage, lightHttpResponse)) {
                return;
            } else {
                writeFullResponse(lightHttpResponse, httpMessageWriter, output);
            }
        }
    }

    private boolean dispatchToHandler(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) throws IOException {
        HttpHandler httpHandlerLookup = this.mHandlerRegistry.lookup(lightHttpRequest.uri.getPath());
        if (httpHandlerLookup == null) {
            lightHttpResponse.code = 404;
            lightHttpResponse.reasonPhrase = "Not found";
            lightHttpResponse.body = LightHttpBody.create("No handler found\n", HTTP.PLAIN_TEXT_TYPE);
            return true;
        }
        try {
            return httpHandlerLookup.handleRequest(socketLike, lightHttpRequest, lightHttpResponse);
        } catch (RuntimeException e) {
            lightHttpResponse.code = 500;
            lightHttpResponse.reasonPhrase = "Internal Server Error";
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                e.printStackTrace(printWriter);
                printWriter.close();
                lightHttpResponse.body = LightHttpBody.create(stringWriter.toString(), HTTP.PLAIN_TEXT_TYPE);
                return true;
            } catch (Throwable th) {
                printWriter.close();
                throw th;
            }
        }
    }

    private static LightHttpRequest readRequestMessage(LightHttpRequest lightHttpRequest, HttpMessageReader httpMessageReader) throws IOException {
        lightHttpRequest.reset();
        String line = httpMessageReader.readLine();
        if (line == null) {
            return null;
        }
        String[] strArrSplit = line.split(StringUtils.SPACE, 3);
        if (strArrSplit.length != 3) {
            throw new IOException("Invalid request line: " + line);
        }
        lightHttpRequest.method = strArrSplit[0];
        lightHttpRequest.uri = Uri.parse(strArrSplit[1]);
        lightHttpRequest.protocol = strArrSplit[2];
        readHeaders(lightHttpRequest, httpMessageReader);
        return lightHttpRequest;
    }

    private static void readHeaders(LightHttpMessage lightHttpMessage, HttpMessageReader httpMessageReader) throws IOException {
        while (true) {
            String line = httpMessageReader.readLine();
            if (line == null) {
                throw new EOFException();
            }
            if ("".equals(line)) {
                return;
            }
            String[] strArrSplit = line.split(": ", 2);
            if (strArrSplit.length != 2) {
                throw new IOException("Malformed header: " + line);
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            lightHttpMessage.headerNames.add(str);
            lightHttpMessage.headerValues.add(str2);
        }
    }

    private static void writeFullResponse(LightHttpResponse lightHttpResponse, HttpMessageWriter httpMessageWriter, OutputStream outputStream) throws IOException {
        lightHttpResponse.prepare();
        writeResponseMessage(lightHttpResponse, httpMessageWriter);
        if (lightHttpResponse.body != null) {
            lightHttpResponse.body.writeTo(outputStream);
        }
    }

    public static void writeResponseMessage(LightHttpResponse lightHttpResponse, HttpMessageWriter httpMessageWriter) throws IOException {
        httpMessageWriter.writeLine("HTTP/1.1 " + lightHttpResponse.code + StringUtils.SPACE + lightHttpResponse.reasonPhrase);
        int size = lightHttpResponse.headerNames.size();
        for (int i = 0; i < size; i++) {
            httpMessageWriter.writeLine(lightHttpResponse.headerNames.get(i) + ": " + lightHttpResponse.headerValues.get(i));
        }
        httpMessageWriter.writeLine();
        httpMessageWriter.flush();
    }

    private static class HttpMessageReader {
        private final BufferedInputStream mIn;
        private final StringBuilder mBuffer = new StringBuilder();
        private final NewLineDetector mNewLineDetector = new NewLineDetector();

        public HttpMessageReader(BufferedInputStream bufferedInputStream) {
            this.mIn = bufferedInputStream;
        }

        public String readLine() throws IOException {
            while (true) {
                int i = this.mIn.read();
                if (i < 0) {
                    return null;
                }
                char c = (char) i;
                this.mNewLineDetector.accept(c);
                int iState = this.mNewLineDetector.state();
                if (iState == 1) {
                    this.mBuffer.append(c);
                } else if (iState == 3) {
                    String string = this.mBuffer.toString();
                    this.mBuffer.setLength(0);
                    return string;
                }
            }
        }

        private static class NewLineDetector {
            private static final int STATE_ON_CR = 2;
            private static final int STATE_ON_CRLF = 3;
            private static final int STATE_ON_OTHER = 1;
            private int state;

            private NewLineDetector() {
                this.state = 1;
            }

            public void accept(char c) {
                int i = this.state;
                if (i == 1) {
                    if (c == '\r') {
                        this.state = 2;
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (c == '\n') {
                        this.state = 3;
                        return;
                    } else {
                        this.state = 1;
                        return;
                    }
                }
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown state: " + this.state);
                }
                if (c == '\r') {
                    this.state = 2;
                } else {
                    this.state = 1;
                }
            }

            public int state() {
                return this.state;
            }
        }
    }

    public static class HttpMessageWriter {
        private static final byte[] CRLF = "\r\n".getBytes();
        private final BufferedOutputStream mOut;

        public HttpMessageWriter(BufferedOutputStream bufferedOutputStream) {
            this.mOut = bufferedOutputStream;
        }

        public void writeLine(String str) throws IOException {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                this.mOut.write(str.charAt(i));
            }
            this.mOut.write(CRLF);
        }

        public void writeLine() throws IOException {
            this.mOut.write(CRLF);
        }

        public void flush() throws IOException {
            this.mOut.flush();
        }
    }
}
