package com.samsung.android.sdk.healthdata;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class HealthDataUtil {

    private static final class a implements ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        a(Type type, Type[] typeArr, Type type2) {
            if (type instanceof Class) {
                if ((type2 == null) != (((Class) type).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                a(type3, "typeArgument == null");
                a(type3);
            }
            this.a = type2;
            this.b = type;
            this.c = (Type[]) typeArr.clone();
        }

        private <T> T a(T t, String str) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(str);
        }

        private String b(Type type) {
            return type instanceof Class ? ((Class) type).getName() : type.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            Type type = this.a;
            Type ownerType = parameterizedType.getOwnerType();
            return (type == ownerType || (type != null && type.equals(ownerType))) && this.b.equals(parameterizedType.getRawType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.b;
        }

        public int hashCode() {
            int iHashCode = Arrays.hashCode(this.c) ^ this.b.hashCode();
            Type type = this.a;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.c;
            if (typeArr.length == 0) {
                return b(this.b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(b(this.b));
            sb.append("<").append(b(this.c[0]));
            for (int i = 1; i < this.c.length; i++) {
                sb.append(", ").append(b(this.c[i]));
            }
            return sb.append(">").toString();
        }

        private void a(Type type) {
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private HealthDataUtil() {
    }

    public static <T> byte[] getJsonBlob(T t) throws IOException {
        String json = new Gson().toJson(t);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(json.length());
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(json.getBytes(StandardCharsets.UTF_8));
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> T getStructuredData(byte[] bArr, Class<T> cls) throws IOException {
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream);
                        try {
                            T t = (T) new Gson().fromJson((Reader) inputStreamReader, (Class) cls);
                            inputStreamReader.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            return t;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (JsonSyntaxException | ZipException unused) {
                throw new IllegalArgumentException("Json blob is invalid. It should be a JSON compressed by Zip.");
            }
        } catch (JsonIOException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> List<T> getStructuredDataList(byte[] bArr, Class<T> cls) throws IOException {
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream);
                        try {
                            List<T> list = (List) new Gson().fromJson(inputStreamReader, new a(List.class, new Type[]{cls}, null));
                            inputStreamReader.close();
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            return list;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (JsonSyntaxException | ZipException unused) {
                throw new IllegalArgumentException("Json blob is invalid. It should be a JSON compressed by Zip.");
            }
        } catch (JsonIOException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> byte[] getJsonBlob(List<T> list) throws IOException {
        String json = new Gson().toJson(list);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(json.length());
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(json.getBytes(StandardCharsets.UTF_8));
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
