package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.android.SdkConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/ImageRequest;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", com.sun.jna.Callback.METHOD_NAME, "Lcom/facebook/internal/ImageRequest$Callback;", "allowCachedRedirects", "", "callerTag", "(Landroid/content/Context;Landroid/net/Uri;Lcom/facebook/internal/ImageRequest$Callback;ZLjava/lang/Object;)V", "getAllowCachedRedirects", "()Z", "getCallback", "()Lcom/facebook/internal/ImageRequest$Callback;", "getCallerTag", "()Ljava/lang/Object;", "getContext", "()Landroid/content/Context;", "getImageUri", "()Landroid/net/Uri;", "isCachedRedirectAllowed", "Builder", "Callback", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageRequest {
    private static final String ACCESS_TOKEN_PARAM = "access_token";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private final boolean allowCachedRedirects;
    private final Callback callback;
    private final Object callerTag;
    private final Context context;
    private final Uri imageUri;

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/ImageRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/internal/ImageResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onCompleted(ImageResponse response);
    }

    public /* synthetic */ ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uri, callback, z, obj);
    }

    @JvmStatic
    public static final Uri getProfilePictureUri(String str, int i, int i2) {
        return INSTANCE.getProfilePictureUri(str, i, i2);
    }

    @JvmStatic
    public static final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        return INSTANCE.getProfilePictureUri(str, i, i2, str2);
    }

    private ImageRequest(Context context, Uri uri, Callback callback, boolean z, Object obj) {
        this.context = context;
        this.imageUri = uri;
        this.callback = callback;
        this.allowCachedRedirects = z;
        this.callerTag = obj;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Uri getImageUri() {
        return this.imageUri;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    public final Object getCallerTag() {
        return this.callerTag;
    }

    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0007J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/ImageRequest$Companion;", "", "()V", "ACCESS_TOKEN_PARAM", "", "HEIGHT_PARAM", "MIGRATION_PARAM", "MIGRATION_VALUE", "PATH", "UNSPECIFIED_DIMENSION", "", "WIDTH_PARAM", "getProfilePictureUri", "Landroid/net/Uri;", "userId", "width", "height", SDKConstants.PARAM_ACCESS_TOKEN, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Uri getProfilePictureUri(String userId, int width, int height) {
            return getProfilePictureUri(userId, width, height, "");
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00b9  */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.net.Uri getProfilePictureUri(java.lang.String r4, int r5, int r6, java.lang.String r7) {
            /*
                r3 = this;
                com.facebook.internal.Validate r0 = com.facebook.internal.Validate.INSTANCE
                java.lang.String r0 = "userId"
                com.facebook.internal.Validate.notNullOrEmpty(r4, r0)
                r0 = 0
                int r5 = java.lang.Math.max(r5, r0)
                int r6 = java.lang.Math.max(r6, r0)
                if (r5 != 0) goto L15
                if (r6 == 0) goto L16
            L15:
                r0 = 1
            L16:
                if (r0 == 0) goto Lca
                com.facebook.internal.ServerProtocol r0 = com.facebook.internal.ServerProtocol.INSTANCE
                java.lang.String r0 = com.facebook.internal.ServerProtocol.getGraphUrlBase()
                android.net.Uri r0 = android.net.Uri.parse(r0)
                android.net.Uri$Builder r0 = r0.buildUpon()
                kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
                java.util.Locale r1 = java.util.Locale.US
                com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE
                java.lang.String r2 = com.facebook.FacebookSdk.getGraphApiVersion()
                java.lang.Object[] r4 = new java.lang.Object[]{r2, r4}
                r2 = 2
                java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r2)
                java.lang.String r2 = "%s/%s/picture"
                java.lang.String r4 = java.lang.String.format(r1, r2, r4)
                java.lang.String r1 = "java.lang.String.format(locale, format, *args)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
                android.net.Uri$Builder r4 = r0.path(r4)
                if (r6 == 0) goto L53
                java.lang.String r0 = "height"
                java.lang.String r6 = java.lang.String.valueOf(r6)
                r4.appendQueryParameter(r0, r6)
            L53:
                if (r5 == 0) goto L5f
                java.lang.String r6 = "width"
                java.lang.String r5 = java.lang.String.valueOf(r5)
                r4.appendQueryParameter(r6, r5)
            L5f:
                java.lang.String r5 = "migration_overrides"
                java.lang.String r6 = "{october_2012:true}"
                r4.appendQueryParameter(r5, r6)
                com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
                boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r7)
                java.lang.String r6 = "access_token"
                if (r5 != 0) goto L76
                r4.appendQueryParameter(r6, r7)
                goto Lc0
            L76:
                com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
                com.facebook.FacebookSdk r5 = com.facebook.FacebookSdk.INSTANCE
                java.lang.String r5 = com.facebook.FacebookSdk.getClientToken()
                boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r5)
                if (r5 != 0) goto Lb9
                com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE
                com.facebook.FacebookSdk r5 = com.facebook.FacebookSdk.INSTANCE
                java.lang.String r5 = com.facebook.FacebookSdk.getApplicationId()
                boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r5)
                if (r5 != 0) goto Lb9
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                com.facebook.FacebookSdk r7 = com.facebook.FacebookSdk.INSTANCE
                java.lang.String r7 = com.facebook.FacebookSdk.getApplicationId()
                java.lang.StringBuilder r5 = r5.append(r7)
                r7 = 124(0x7c, float:1.74E-43)
                java.lang.StringBuilder r5 = r5.append(r7)
                com.facebook.FacebookSdk r7 = com.facebook.FacebookSdk.INSTANCE
                java.lang.String r7 = com.facebook.FacebookSdk.getClientToken()
                java.lang.StringBuilder r5 = r5.append(r7)
                java.lang.String r5 = r5.toString()
                r4.appendQueryParameter(r6, r5)
                goto Lc0
            Lb9:
                java.lang.String r5 = "ImageRequest"
                java.lang.String r6 = "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned"
                android.util.Log.d(r5, r6)
            Lc0:
                android.net.Uri r4 = r4.build()
                java.lang.String r5 = "builder.build()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                return r4
            Lca:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Either width or height must be greater than 0"
                java.lang.String r5 = r5.toString()
                r4.<init>(r5)
                java.lang.Throwable r4 = (java.lang.Throwable) r4
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageRequest.Companion.getProfilePictureUri(java.lang.String, int, int, java.lang.String):android.net.Uri");
        }
    }

    /* compiled from: ImageRequest.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/ImageRequest$Builder;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "allowCachedRedirects", "", com.sun.jna.Callback.METHOD_NAME, "Lcom/facebook/internal/ImageRequest$Callback;", "callerTag", "build", "Lcom/facebook/internal/ImageRequest;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "setAllowCachedRedirects", "setCallback", "setCallerTag", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private final Context context;
        private final Uri imageUri;

        /* renamed from: component1, reason: from getter */
        private final Context getContext() {
            return this.context;
        }

        /* renamed from: component2, reason: from getter */
        private final Uri getImageUri() {
            return this.imageUri;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Context context, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                context = builder.context;
            }
            if ((i & 2) != 0) {
                uri = builder.imageUri;
            }
            return builder.copy(context, uri);
        }

        public final Builder copy(Context context, Uri imageUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            return new Builder(context, imageUri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.context, builder.context) && Intrinsics.areEqual(this.imageUri, builder.imageUri);
        }

        public int hashCode() {
            return (this.context.hashCode() * 31) + this.imageUri.hashCode();
        }

        public String toString() {
            return "Builder(context=" + this.context + ", imageUri=" + this.imageUri + ')';
        }

        public Builder(Context context, Uri imageUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            this.context = context;
            this.imageUri = imageUri;
        }

        public final Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public final Builder setCallerTag(Object callerTag) {
            this.callerTag = callerTag;
            return this;
        }

        public final Builder setAllowCachedRedirects(boolean allowCachedRedirects) {
            this.allowCachedRedirects = allowCachedRedirects;
            return this;
        }

        public final ImageRequest build() {
            Context context = this.context;
            Uri uri = this.imageUri;
            Callback callback = this.callback;
            boolean z = this.allowCachedRedirects;
            Object obj = this.callerTag;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            return new ImageRequest(context, uri, callback, z, obj, null);
        }
    }
}
