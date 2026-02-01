package com.ua.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.dyaco.sole.R2;
import com.ua.oss.org.apache.http.entity.ContentType;
import com.ua.oss.org.apache.http.entity.mime.HttpMultipartMode;
import com.ua.oss.org.apache.http.entity.mime.MultipartEntityBuilder;
import com.ua.sdk.Resource;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.UploadCallback;
import com.ua.sdk.activitystory.AttachmentDest;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.authentication.FilemobileCredential;
import com.ua.sdk.authentication.FilemobileCredentialManager;
import com.ua.sdk.internal.net.UrlBuilder;
import com.ua.sdk.util.Media;
import com.ua.sdk.util.ProgressHttpEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes2.dex */
public class MediaService<T extends Resource> {
    protected static final int MAX_HEIGHT = 1000;
    protected static final int MAX_WIDTH = 1000;
    protected final AuthenticationManager authManager;
    protected final ConnectionFactory connFactory;
    protected final Context context;
    protected FilemobileCredentialManager filemobileCredentialManager;
    protected final JsonParser<T> jsonParser;
    protected ProgressOutputStream outputStream;
    protected final UrlBuilder urlBuilder;

    public MediaService(Context context, ConnectionFactory connectionFactory, UrlBuilder urlBuilder, JsonParser<T> jsonParser, AuthenticationManager authenticationManager) {
        this.context = context;
        this.connFactory = connectionFactory;
        this.urlBuilder = urlBuilder;
        this.jsonParser = jsonParser;
        this.authManager = authenticationManager;
    }

    public MediaService(Context context, ConnectionFactory connectionFactory, UrlBuilder urlBuilder, JsonParser<T> jsonParser, AuthenticationManager authenticationManager, FilemobileCredentialManager filemobileCredentialManager) {
        this(context, connectionFactory, urlBuilder, jsonParser, authenticationManager);
        this.filemobileCredentialManager = filemobileCredentialManager;
    }

    public void close() throws IOException {
        ProgressOutputStream progressOutputStream = this.outputStream;
        if (progressOutputStream != null) {
            progressOutputStream.close();
        }
    }

    public T uploadUserProfileImage(Uri uri, T t) throws UaException, NullPointerException {
        Precondition.isNotNull(uri, "image");
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildGetUserProfilePhotoUrl(t.getRef()));
            File file = getFile(uri);
            Precondition.isNotNull(file, "imageFile");
            try {
                this.authManager.signAsUser(sslConnection);
                ByteArrayOutputStream byteArrayOutputStreamCompressBitmap = compressBitmap(resizeBitmap(file, 1000, 1000));
                int size = byteArrayOutputStreamCompressBitmap.size();
                sslConnection.setRequestMethod(HttpPut.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                sslConnection.setRequestProperty("Content-Type", "image/jpeg");
                sslConnection.setRequestProperty("Content-Length", String.valueOf(size));
                sslConnection.setFixedLengthStreamingMode(size);
                byteArrayOutputStreamCompressBitmap.writeTo(sslConnection.getOutputStream());
                byteArrayOutputStreamCompressBitmap.close();
                Precondition.isResponseSuccess(sslConnection);
                return this.jsonParser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            UaLog.debug("Upload image cancelled.");
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (Throwable th) {
            UaLog.error("Unable to upload image.", th);
            throw new UaException("Unable to upload image.", th);
        }
    }

    public T uploadImage(Uri uri, AttachmentDest attachmentDest, UploadCallback uploadCallback) throws UaException, NullPointerException {
        Precondition.isNotNull(attachmentDest, "dest");
        Precondition.isNotNull(uri, "image");
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(this.urlBuilder.buildPostImageUrl());
            try {
                this.authManager.signAsUser(sslConnection);
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                ProgressHttpEntity progressHttpEntityCreateHttpBodyEntity = createHttpBodyEntity(uri, attachmentDest);
                long contentLength = progressHttpEntityCreateHttpBodyEntity.getContentLength();
                sslConnection.setFixedLengthStreamingMode((int) contentLength);
                sslConnection.setRequestProperty("Content-Length", String.valueOf(contentLength));
                Header contentType = progressHttpEntityCreateHttpBodyEntity.getContentType();
                sslConnection.setRequestProperty(contentType.getName(), contentType.getValue());
                Header contentEncoding = progressHttpEntityCreateHttpBodyEntity.getContentEncoding();
                if (contentEncoding != null) {
                    sslConnection.setRequestProperty(contentEncoding.getName(), contentEncoding.getValue());
                }
                ProgressOutputStream progressOutputStream = new ProgressOutputStream(sslConnection.getOutputStream(), contentLength, uploadCallback);
                this.outputStream = progressOutputStream;
                progressHttpEntityCreateHttpBodyEntity.writeTo(progressOutputStream);
                Precondition.isResponseSuccess(sslConnection);
                return null;
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            UaLog.debug("Upload image cancelled.");
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (Throwable th) {
            UaLog.error("Unable to upload image.", th);
            throw new UaException("Unable to upload image.", th);
        }
    }

    public T uploadVideo(Uri uri, AttachmentDest attachmentDest, UploadCallback uploadCallback) throws UaException, NullPointerException {
        Precondition.isNotNull(attachmentDest, "dest");
        Precondition.isNotNull(uri, "video");
        try {
            HttpURLConnection connection = this.connFactory.getConnection(this.urlBuilder.buildPostVideoUrl());
            try {
                FilemobileCredential filemobileTokenCredentials = this.filemobileCredentialManager.getFilemobileTokenCredentials();
                connection.setRequestMethod(HttpPost.METHOD_NAME);
                connection.setDoOutput(true);
                connection.setUseCaches(false);
                ProgressHttpEntity progressHttpEntityCreateHttpBodyEntity = createHttpBodyEntity(filemobileTokenCredentials, uri, attachmentDest);
                long contentLength = progressHttpEntityCreateHttpBodyEntity.getContentLength();
                connection.setFixedLengthStreamingMode((int) contentLength);
                connection.setRequestProperty("Content-Length", String.valueOf(contentLength));
                Header contentType = progressHttpEntityCreateHttpBodyEntity.getContentType();
                connection.setRequestProperty(contentType.getName(), contentType.getValue());
                Header contentEncoding = progressHttpEntityCreateHttpBodyEntity.getContentEncoding();
                if (contentEncoding != null) {
                    connection.setRequestProperty(contentEncoding.getName(), contentEncoding.getValue());
                }
                ProgressOutputStream progressOutputStream = new ProgressOutputStream(connection.getOutputStream(), contentLength, uploadCallback);
                this.outputStream = progressOutputStream;
                progressHttpEntityCreateHttpBodyEntity.writeTo(progressOutputStream);
                Precondition.isResponseSuccess(connection);
                return null;
            } finally {
                connection.disconnect();
            }
        } catch (InterruptedIOException e) {
            UaLog.debug("Upload video cancelled.");
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (Throwable th) {
            UaLog.error("Unable to upload video.", th);
            throw new UaException("Unable to upload video.", th);
        }
    }

    protected ContentType getContentType(Uri uri) {
        String fileExtensionFromUrl;
        String type = this.context.getContentResolver().getType(uri);
        if (type == null && (fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.getPath())) != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        if (type == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            type = options.outMimeType;
        }
        if (type != null) {
            return ContentType.create(type);
        }
        return null;
    }

    protected File getFile(Uri uri) throws UaException, NullPointerException {
        String path = Media.getPath(this.context, uri);
        Precondition.isNotNull(path, ClientCookie.PATH_ATTR);
        return new File(path);
    }

    protected ByteArrayOutputStream compressBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    protected int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    protected Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    protected Bitmap resizeBitmap(File file, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return rotateBitmap(bitmapDecodeFile, R2.attr.com_facebook_foreground_color);
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? bitmapDecodeFile : rotateBitmap(bitmapDecodeFile, -90);
        }
        return rotateBitmap(bitmapDecodeFile, 90);
    }

    private ProgressHttpEntity createHttpBodyEntity(FilemobileCredential filemobileCredential, Uri uri, AttachmentDest attachmentDest) throws UaException, NullPointerException {
        ContentType contentType = getContentType(uri);
        File file = getFile(uri);
        Precondition.isNotNull(file, "videoFile");
        return new ProgressHttpEntity(MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).addTextBody("sessiontoken", filemobileCredential.getToken()).addTextBody("vhost", filemobileCredential.getVhost()).addTextBody("uid", filemobileCredential.getUid()).addTextBody("meta[user][user_id]", attachmentDest.getUserId()).addTextBody("meta[user][href]", attachmentDest.getHref()).addTextBody("meta[user][index]", String.valueOf(attachmentDest.getIndex())).addTextBody("meta[user][rel]", attachmentDest.getRel()).addBinaryBody("file", file, contentType, uri.getLastPathSegment()).build());
    }

    private ProgressHttpEntity createHttpBodyEntity(Uri uri, AttachmentDest attachmentDest) throws UaException, NullPointerException {
        ContentType contentTypeCreate = ContentType.create("application/json");
        ContentType contentType = getContentType(uri);
        File file = getFile(uri);
        Precondition.isNotNull(file);
        UaLog.debug("request=" + attachmentDest.toString());
        return new ProgressHttpEntity(MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).addBinaryBody("data", attachmentDest.toString().getBytes(), contentTypeCreate, "page_json.json").addBinaryBody("image", file, contentType, uri.getLastPathSegment()).build());
    }
}
