package com.soletreadmills.sole_v2._tools;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.core.net.UriKt;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.bumptech.glide.Glide;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* compiled from: FileTool.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bJ\u001a\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J$\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\bJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J(\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bJ\u0016\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0004J\u0018\u0010.\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006/"}, d2 = {"Lcom/soletreadmills/sole_v2/_tools/FileTool;", "", "()V", "bitmapToBitmapBase64Str", "", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "bitmapToTempFile", "Ljava/io/File;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "changeImgSize", "img", "createFileObjFromPath", "path", "mustCanRead", "", "getFileExtension", "uri", "Landroid/net/Uri;", "getFileFromUri", "getFolderSize", "", "file", "getImgPathByUri", "getResourceRawFileJsonStr", "id", "", "imageBase64StrToBitmap", "imageBase64Str", "imageBase64StrToByteArray", "", "imageFileToBitmapBase64Str", "imageFile", "imageUriToBitmapBase64Str", "imageUri", "inputStreamToString", "inputStream", "Ljava/io/InputStream;", "isUriValid", "queryAbsolutePath", "resizeImageWithGlide", "targetWidth", "targetHeight", "saveBitmapFile", "filepath", "uriToFile", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FileTool {
    public static final int $stable = 0;
    public static final FileTool INSTANCE = new FileTool();

    private FileTool() {
    }

    public final String getImgPathByUri(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            return null;
        }
        try {
            if (String.valueOf(uri.getScheme()).compareTo("content") == 0) {
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                Intrinsics.checkNotNull(cursorQuery);
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
                cursorQuery.close();
                return string;
            }
            if (String.valueOf(uri.getScheme()).compareTo("file") != 0) {
                return null;
            }
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String strReplace$default = StringsKt.replace$default(string, "file://", "", false, 4, (Object) null);
            try {
                return !StringsKt.startsWith$default(strReplace$default, "/mnt", false, 2, (Object) null) ? strReplace$default + "/mnt" : strReplace$default;
            } catch (Exception e) {
                string = strReplace$default;
                e = e;
                Timber.INSTANCE.e(e);
                return string;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public final long getFolderSize(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles(...)");
            long folderSize = 0;
            for (File file2 : fileArrListFiles) {
                Intrinsics.checkNotNull(file2);
                folderSize += getFolderSize(file2);
            }
            return folderSize;
        }
        return file.length();
    }

    public final File changeImgSize(Context context, File img) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(img, "img");
        long folderSize = getFolderSize(img) / 1024;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(img.getPath(), options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = (int) (folderSize / 400.0f);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(img.getPath(), options);
        Intrinsics.checkNotNull(bitmapDecodeFile);
        return saveBitmapFile(bitmapDecodeFile, context.getFilesDir().getAbsolutePath() + "/changeImg.jpg");
    }

    public final String getFileExtension(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (StringsKt.equals$default(uri.getScheme(), "content", false, 2, null)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(UriKt.toFile(uri)).toString());
    }

    public final File saveBitmapFile(Bitmap bitmap, String filepath) throws IOException {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(filepath, "filepath");
        File file = new File(filepath);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            Timber.INSTANCE.e("saveBitmapFile=" + e, new Object[0]);
        }
        return file;
    }

    public final String imageUriToBitmapBase64Str(Uri imageUri) {
        File file;
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        try {
            file = UriKt.toFile(imageUri);
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            file = null;
        }
        if (file == null) {
            return null;
        }
        return imageFileToBitmapBase64Str(file);
    }

    public final String imageFileToBitmapBase64Str(File imageFile) {
        Bitmap bitmapDecodeFile;
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(imageFile, "imageFile");
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null) {
            return null;
        }
        try {
            int attributeInt = new ExifInterface(imageFile).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            int i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
            if (i != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
            } else {
                bitmapCreateBitmap = bitmapDecodeFile;
            }
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            bitmapDecodeFile = bitmapCreateBitmap;
        } catch (Exception e2) {
            Timber.INSTANCE.e(e2);
        }
        return bitmapToBitmapBase64Str(bitmapDecodeFile);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:51:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String bitmapToBitmapBase64Str(android.graphics.Bitmap r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r1.<init>()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L5d
            r3 = r1
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L5d
            r4 = 100
            r6.compress(r2, r4, r3)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L5d
            byte[] r6 = r1.toByteArray()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L5d
            java.lang.String r2 = "toByteArray(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L5d
            r2 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r6, r2)     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L5d
            r1.flush()     // Catch: java.lang.Exception -> L27
            goto L2f
        L27:
            r6 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.INSTANCE
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r2.e(r6)
        L2f:
            r1.close()     // Catch: java.lang.Exception -> L33
            goto L5c
        L33:
            r6 = move-exception
            timber.log.Timber$Forest r1 = timber.log.Timber.INSTANCE
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r1.e(r6)
            goto L5c
        L3c:
            r6 = move-exception
            goto L42
        L3e:
            r6 = move-exception
            goto L5f
        L40:
            r6 = move-exception
            r1 = r0
        L42:
            timber.log.Timber$Forest r2 = timber.log.Timber.INSTANCE     // Catch: java.lang.Throwable -> L5d
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch: java.lang.Throwable -> L5d
            r2.e(r6)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L57
            r1.flush()     // Catch: java.lang.Exception -> L4f
            goto L57
        L4f:
            r6 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.INSTANCE
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r2.e(r6)
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.lang.Exception -> L33
        L5c:
            return r0
        L5d:
            r6 = move-exception
            r0 = r1
        L5f:
            if (r0 == 0) goto L6d
            r0.flush()     // Catch: java.lang.Exception -> L65
            goto L6d
        L65:
            r1 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.INSTANCE
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r2.e(r1)
        L6d:
            if (r0 == 0) goto L7b
            r0.close()     // Catch: java.lang.Exception -> L73
            goto L7b
        L73:
            r0 = move-exception
            timber.log.Timber$Forest r1 = timber.log.Timber.INSTANCE
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.e(r0)
        L7b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._tools.FileTool.bitmapToBitmapBase64Str(android.graphics.Bitmap):java.lang.String");
    }

    public final byte[] imageBase64StrToByteArray(String imageBase64Str) {
        byte[] bArrDecode;
        Intrinsics.checkNotNullParameter(imageBase64Str, "imageBase64Str");
        try {
            bArrDecode = Base64.decode(imageBase64Str, 0);
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            bArrDecode = null;
        }
        if (bArrDecode == null) {
            return null;
        }
        return bArrDecode;
    }

    public final Bitmap imageBase64StrToBitmap(String imageBase64Str) {
        Intrinsics.checkNotNullParameter(imageBase64Str, "imageBase64Str");
        try {
            byte[] bArrImageBase64StrToByteArray = imageBase64StrToByteArray(imageBase64Str);
            if (bArrImageBase64StrToByteArray != null) {
                return BitmapFactory.decodeByteArray(bArrImageBase64StrToByteArray, 0, bArrImageBase64StrToByteArray.length);
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        return null;
    }

    public final File getFileFromUri(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getFileFromUri(context, uri, false);
    }

    public final File getFileFromUri(Context context, Uri uri, boolean mustCanRead) throws FileNotFoundException {
        String path;
        Uri uri2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            return null;
        }
        try {
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if (Intrinsics.areEqual("com.android.externalstorage.documents", authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNull(documentId);
                String[] strArr = (String[]) StringsKt.split$default((CharSequence) documentId, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
                String str = strArr[0];
                if (Intrinsics.areEqual("primary", str)) {
                    return createFileObjFromPath(Environment.getExternalStorageDirectory().getAbsolutePath() + '/' + strArr[1], mustCanRead);
                }
                return createFileObjFromPath("/storage/" + str + '/' + strArr[1], mustCanRead);
            }
            String str2 = "";
            if (Intrinsics.areEqual("com.android.providers.downloads.documents", authority)) {
                String documentId2 = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNull(documentId2);
                if (StringsKt.startsWith$default(documentId2, "raw:", false, 2, (Object) null)) {
                    return createFileObjFromPath(new Regex("raw:").replaceFirst(documentId2, ""), mustCanRead);
                }
                if (StringsKt.startsWith$default(documentId2, "msf:", false, 2, (Object) null)) {
                    try {
                        File file = new File(context.getCacheDir(), uri.getLastPathSegment());
                        FileOutputStream fileOutputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        try {
                            InputStream inputStream = fileOutputStreamOpenInputStream;
                            fileOutputStreamOpenInputStream = new FileOutputStream(file);
                            try {
                                FileOutputStream fileOutputStream = fileOutputStreamOpenInputStream;
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    Intrinsics.checkNotNull(inputStream);
                                    int i = inputStream.read(bArr);
                                    if (i != -1) {
                                        fileOutputStream.write(bArr, 0, i);
                                    } else {
                                        fileOutputStream.flush();
                                        CloseableKt.closeFinally(fileOutputStreamOpenInputStream, null);
                                        CloseableKt.closeFinally(fileOutputStreamOpenInputStream, null);
                                        return file;
                                    }
                                }
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Exception e2) {
                        Timber.INSTANCE.e(e2);
                        return null;
                    }
                } else {
                    Uri uriWithAppendedId = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId2));
                    Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                    String strQueryAbsolutePath = queryAbsolutePath(context, uriWithAppendedId);
                    if (strQueryAbsolutePath != null) {
                        str2 = strQueryAbsolutePath;
                    }
                    return createFileObjFromPath(str2, mustCanRead);
                }
            } else {
                if (Intrinsics.areEqual("com.android.providers.media.documents", authority)) {
                    String documentId3 = DocumentsContract.getDocumentId(uri);
                    Intrinsics.checkNotNull(documentId3);
                    String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) documentId3, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
                    String str3 = strArr2[0];
                    if (Intrinsics.areEqual("image", str3)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (Intrinsics.areEqual("video", str3)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else {
                        if (!Intrinsics.areEqual("audio", str3)) {
                            return null;
                        }
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    String strQueryAbsolutePath2 = queryAbsolutePath(context, ContentUris.withAppendedId(uri2, Long.parseLong(strArr2[1])));
                    if (strQueryAbsolutePath2 != null) {
                        str2 = strQueryAbsolutePath2;
                    }
                    return createFileObjFromPath(str2, mustCanRead);
                }
                try {
                    return UriKt.toFile(uri);
                } catch (Exception e3) {
                    Timber.INSTANCE.e(e3);
                }
            }
            Timber.INSTANCE.e(e);
            return null;
        }
        if (Intrinsics.areEqual("content", uri.getScheme())) {
            path = queryAbsolutePath(context, uri);
        } else {
            path = uri.getPath();
        }
        return createFileObjFromPath(path, mustCanRead);
    }

    public final File createFileObjFromPath(String path, boolean mustCanRead) {
        if (path != null) {
            try {
                File file = new File(path);
                if (mustCanRead) {
                    file.setReadable(true);
                    if (!file.canRead()) {
                        return null;
                    }
                }
                return file.getAbsoluteFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public final String queryAbsolutePath(Context context, Uri uri) {
        Cursor cursorQuery;
        Intrinsics.checkNotNullParameter(context, "context");
        String[] strArr = {"_data"};
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull(uri);
            cursorQuery = contentResolver.query(uri, strArr, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        }
        return null;
    }

    public final synchronized String getResourceRawFileJsonStr(Context context, int id2) {
        InputStream inputStreamOpenRawResource;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(id2);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return null;
        }
        return inputStreamToString(inputStreamOpenRawResource);
    }

    public final synchronized String inputStreamToString(InputStream inputStream) {
        String str;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        try {
            int iAvailable = inputStream.available();
            byte[] bArr = new byte[iAvailable];
            inputStream.read(bArr, 0, iAvailable);
            str = new String(bArr, Charsets.UTF_8);
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            str = null;
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final File resizeImageWithGlide(Context context, Uri uri, int targetWidth, int targetHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            Bitmap bitmap = (Bitmap) Glide.with(context).asBitmap().load(uri).override(targetWidth, targetHeight).submit().get();
            Intrinsics.checkNotNull(bitmap);
            return bitmapToTempFile(context, bitmap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final File bitmapToTempFile(Context context, Bitmap bitmap) throws IOException {
        try {
            File fileCreateTempFile = File.createTempFile("temp_image", null, context.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return fileCreateTempFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final File uriToFile(Context context, Uri uri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        if (isUriValid(context, uri)) {
            try {
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                File file = new File(context.getCacheDir(), "temp_image_file");
                if (inputStreamOpenInputStream != null) {
                    FileOutputStream fileOutputStream = inputStreamOpenInputStream;
                    try {
                        InputStream inputStream = fileOutputStream;
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            long jCopyTo$default = ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            Long.valueOf(jCopyTo$default);
                            CloseableKt.closeFinally(fileOutputStream, null);
                        } finally {
                        }
                    } finally {
                    }
                }
                return file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private final boolean isUriValid(Context context, Uri uri) throws FileNotFoundException {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return false;
            }
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                boolean z = inputStream.available() >= 0;
                CloseableKt.closeFinally(inputStream, null);
                return z;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (SecurityException | Exception unused) {
            return false;
        }
    }
}
