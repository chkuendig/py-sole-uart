package io.ktor.http;

import com.android.SdkConstants;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* compiled from: ContentTypes.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u0001:\t\u001b\u001c\u001d\u001e\u001f !\"#B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0003J\u0016\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006$"}, d2 = {"Lio/ktor/http/ContentType;", "Lio/ktor/http/HeaderValueWithParameters;", "contentType", "", "contentSubtype", "parameters", "", "Lio/ktor/http/HeaderValueParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "existingContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContentSubtype", "()Ljava/lang/String;", "getContentType", "equals", "", "other", "", "hasParameter", "name", "value", "hashCode", "", "match", "pattern", "withParameter", "withoutParameters", "Application", "Audio", "Companion", "Font", "Image", "Message", "MultiPart", "Text", "Video", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ContentType extends HeaderValueWithParameters {
    private final String contentSubtype;
    private final String contentType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ContentType Any = new ContentType(Marker.ANY_MARKER, Marker.ANY_MARKER, null, 4, null);

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContentSubtype() {
        return this.contentSubtype;
    }

    /* synthetic */ ContentType(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    private ContentType(String str, String str2, String str3, List<HeaderValueParam> list) {
        super(str3, list);
        this.contentType = str;
        this.contentSubtype = str2;
    }

    public /* synthetic */ ContentType(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List<HeaderValueParam> parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    public final ContentType withParameter(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return hasParameter(name, value) ? this : new ContentType(this.contentType, this.contentSubtype, getContent(), CollectionsKt.plus((Collection<? extends HeaderValueParam>) getParameters(), new HeaderValueParam(name, value)));
    }

    private final boolean hasParameter(String name, String value) {
        int size = getParameters().size();
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            HeaderValueParam headerValueParam = getParameters().get(0);
            if (!StringsKt.equals(headerValueParam.getName(), name, true) || !StringsKt.equals(headerValueParam.getValue(), value, true)) {
                return false;
            }
        } else {
            List<HeaderValueParam> parameters = getParameters();
            if ((parameters instanceof Collection) && parameters.isEmpty()) {
                return false;
            }
            for (HeaderValueParam headerValueParam2 : parameters) {
                if (!StringsKt.equals(headerValueParam2.getName(), name, true) || !StringsKt.equals(headerValueParam2.getValue(), value, true)) {
                }
            }
            return false;
        }
        return true;
    }

    public final ContentType withoutParameters() {
        if (getParameters().isEmpty()) {
            return this;
        }
        return new ContentType(this.contentType, this.contentSubtype, null, 4, null);
    }

    public final boolean match(ContentType pattern) {
        boolean zEquals;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (!Intrinsics.areEqual(pattern.contentType, Marker.ANY_MARKER) && !StringsKt.equals(pattern.contentType, this.contentType, true)) {
            return false;
        }
        if (!Intrinsics.areEqual(pattern.contentSubtype, Marker.ANY_MARKER) && !StringsKt.equals(pattern.contentSubtype, this.contentSubtype, true)) {
            return false;
        }
        for (HeaderValueParam headerValueParam : pattern.getParameters()) {
            String name = headerValueParam.getName();
            String value = headerValueParam.getValue();
            if (Intrinsics.areEqual(name, Marker.ANY_MARKER)) {
                if (!Intrinsics.areEqual(value, Marker.ANY_MARKER)) {
                    List<HeaderValueParam> parameters = getParameters();
                    if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                        Iterator<T> it = parameters.iterator();
                        while (it.hasNext()) {
                            if (StringsKt.equals(((HeaderValueParam) it.next()).getValue(), value, true)) {
                            }
                        }
                    }
                    zEquals = false;
                }
                zEquals = true;
                break;
            }
            String strParameter = parameter(name);
            if (!Intrinsics.areEqual(value, Marker.ANY_MARKER)) {
                zEquals = StringsKt.equals(strParameter, value, true);
            } else {
                if (strParameter != null) {
                    zEquals = true;
                    break;
                    break;
                }
                zEquals = false;
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public final boolean match(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return match(INSTANCE.parse(pattern));
    }

    public boolean equals(Object other) {
        if (other instanceof ContentType) {
            ContentType contentType = (ContentType) other;
            if (StringsKt.equals(this.contentType, contentType.contentType, true) && StringsKt.equals(this.contentSubtype, contentType.contentSubtype, true) && Intrinsics.areEqual(getParameters(), contentType.getParameters())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String lowerCase = this.contentType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int iHashCode = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return iHashCode + (iHashCode * 31) + lowerCase2.hashCode() + (getParameters().hashCode() * 31);
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "parse", "value", "", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentType parse(String value) throws BadContentTypeFormatException {
            Intrinsics.checkNotNullParameter(value, "value");
            if (StringsKt.isBlank(value)) {
                return getAny();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.INSTANCE;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last((List) HttpHeaderValueParserKt.parseHeaderValue(value));
            String value2 = headerValue.getValue();
            List<HeaderValueParam> params = headerValue.getParams();
            String str = value2;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', 0, false, 6, (Object) null);
            if (iIndexOf$default == -1) {
                if (Intrinsics.areEqual(StringsKt.trim((CharSequence) str).toString(), Marker.ANY_MARKER)) {
                    return ContentType.INSTANCE.getAny();
                }
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring = value2.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String string = StringsKt.trim((CharSequence) strSubstring).toString();
            String str2 = string;
            if (str2.length() == 0) {
                throw new BadContentTypeFormatException(value);
            }
            String strSubstring2 = value2.substring(iIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String string2 = StringsKt.trim((CharSequence) strSubstring2).toString();
            if (!StringsKt.contains$default((CharSequence) str2, ' ', false, 2, (Object) null)) {
                String str3 = string2;
                if (!StringsKt.contains$default((CharSequence) str3, ' ', false, 2, (Object) null)) {
                    if (str3.length() == 0 || StringsKt.contains$default((CharSequence) str3, '/', false, 2, (Object) null)) {
                        throw new BadContentTypeFormatException(value);
                    }
                    return new ContentType(string, string2, params);
                }
            }
            throw new BadContentTypeFormatException(value);
        }

        public final ContentType getAny() {
            return ContentType.Any;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006¨\u0006/"}, d2 = {"Lio/ktor/http/ContentType$Application;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Atom", "getAtom", "Cbor", "getCbor", "Docx", "getDocx", "FormUrlEncoded", "getFormUrlEncoded", "GZip", "getGZip", "HalJson", "getHalJson", "JavaScript", "getJavaScript", "Json", "getJson", "OctetStream", "getOctetStream", "Pdf", "getPdf", "Pptx", "getPptx", "ProblemJson", "getProblemJson", "ProblemXml", "getProblemXml", "ProtoBuf", "getProtoBuf", "Rss", "getRss", "Wasm", "getWasm", "Xlsx", "getXlsx", "Xml", "getXml", "Xml_Dtd", "getXml_Dtd", "Zip", "getZip", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Application {
        private static final ContentType Any;
        private static final ContentType Atom;
        private static final ContentType Cbor;
        private static final ContentType Docx;
        private static final ContentType FormUrlEncoded;
        private static final ContentType GZip;
        private static final ContentType HalJson;
        public static final Application INSTANCE = new Application();
        private static final ContentType JavaScript;
        private static final ContentType Json;
        private static final ContentType OctetStream;
        private static final ContentType Pdf;
        private static final ContentType Pptx;
        private static final ContentType ProblemJson;
        private static final ContentType ProblemXml;
        private static final ContentType ProtoBuf;
        private static final ContentType Rss;
        private static final ContentType Wasm;
        private static final ContentType Xlsx;
        private static final ContentType Xml;
        private static final ContentType Xml_Dtd;
        private static final ContentType Zip;

        private Application() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("application", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Atom = new ContentType("application", "atom+xml", list2, i2, defaultConstructorMarker2);
            Cbor = new ContentType("application", "cbor", list, i, defaultConstructorMarker);
            Json = new ContentType("application", SdkConstants.EXT_JSON, list2, i2, defaultConstructorMarker2);
            HalJson = new ContentType("application", "hal+json", list, i, defaultConstructorMarker);
            JavaScript = new ContentType("application", "javascript", list2, i2, defaultConstructorMarker2);
            OctetStream = new ContentType("application", "octet-stream", list, i, defaultConstructorMarker);
            Rss = new ContentType("application", "rss+xml", list2, i2, defaultConstructorMarker2);
            Xml = new ContentType("application", "xml", list, i, defaultConstructorMarker);
            Xml_Dtd = new ContentType("application", "xml-dtd", list2, i2, defaultConstructorMarker2);
            Zip = new ContentType("application", SdkConstants.EXT_ZIP, list, i, defaultConstructorMarker);
            GZip = new ContentType("application", "gzip", list2, i2, defaultConstructorMarker2);
            FormUrlEncoded = new ContentType("application", "x-www-form-urlencoded", list, i, defaultConstructorMarker);
            Pdf = new ContentType("application", "pdf", list2, i2, defaultConstructorMarker2);
            Xlsx = new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", list, i, defaultConstructorMarker);
            Docx = new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", list2, i2, defaultConstructorMarker2);
            Pptx = new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", list, i, defaultConstructorMarker);
            ProtoBuf = new ContentType("application", "protobuf", list2, i2, defaultConstructorMarker2);
            Wasm = new ContentType("application", "wasm", list, i, defaultConstructorMarker);
            ProblemJson = new ContentType("application", "problem+json", list2, i2, defaultConstructorMarker2);
            ProblemXml = new ContentType("application", "problem+xml", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getAtom() {
            return Atom;
        }

        public final ContentType getCbor() {
            return Cbor;
        }

        public final ContentType getJson() {
            return Json;
        }

        public final ContentType getHalJson() {
            return HalJson;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getOctetStream() {
            return OctetStream;
        }

        public final ContentType getRss() {
            return Rss;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getXml_Dtd() {
            return Xml_Dtd;
        }

        public final ContentType getZip() {
            return Zip;
        }

        public final ContentType getGZip() {
            return GZip;
        }

        public final ContentType getFormUrlEncoded() {
            return FormUrlEncoded;
        }

        public final ContentType getPdf() {
            return Pdf;
        }

        public final ContentType getXlsx() {
            return Xlsx;
        }

        public final ContentType getDocx() {
            return Docx;
        }

        public final ContentType getPptx() {
            return Pptx;
        }

        public final ContentType getProtoBuf() {
            return ProtoBuf;
        }

        public final ContentType getWasm() {
            return Wasm;
        }

        public final ContentType getProblemJson() {
            return ProblemJson;
        }

        public final ContentType getProblemXml() {
            return ProblemXml;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Audio;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Audio {
        private static final ContentType Any;
        public static final Audio INSTANCE = new Audio();
        private static final ContentType MP4;
        private static final ContentType MPEG;
        private static final ContentType OGG;

        private Audio() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("audio", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            MP4 = new ContentType("audio", "mp4", list2, i2, defaultConstructorMarker2);
            MPEG = new ContentType("audio", "mpeg", list, i, defaultConstructorMarker);
            OGG = new ContentType("audio", "ogg", list2, i2, defaultConstructorMarker2);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getOGG() {
            return OGG;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/ktor/http/ContentType$Image;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "GIF", "getGIF", "JPEG", "getJPEG", "PNG", "getPNG", "SVG", "getSVG", "XIcon", "getXIcon", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Image {
        private static final ContentType Any;
        private static final ContentType GIF;
        public static final Image INSTANCE = new Image();
        private static final ContentType JPEG;
        private static final ContentType PNG;
        private static final ContentType SVG;
        private static final ContentType XIcon;

        private Image() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("image", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            GIF = new ContentType("image", "gif", list2, i2, defaultConstructorMarker2);
            JPEG = new ContentType("image", "jpeg", list, i, defaultConstructorMarker);
            PNG = new ContentType("image", SdkConstants.EXT_PNG, list2, i2, defaultConstructorMarker2);
            SVG = new ContentType("image", "svg+xml", list, i, defaultConstructorMarker);
            XIcon = new ContentType("image", "x-icon", list2, i2, defaultConstructorMarker2);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getGIF() {
            return GIF;
        }

        public final ContentType getJPEG() {
            return JPEG;
        }

        public final ContentType getPNG() {
            return PNG;
        }

        public final ContentType getSVG() {
            return SVG;
        }

        public final ContentType getXIcon() {
            return XIcon;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/http/ContentType$Message;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Http", "getHttp", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Message {
        public static final Message INSTANCE = new Message();
        private static final ContentType Any = new ContentType("message", Marker.ANY_MARKER, null, 4, null);
        private static final ContentType Http = new ContentType("message", "http", null, 4, null);

        private Message() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getHttp() {
            return Http;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lio/ktor/http/ContentType$MultiPart;", "", "()V", "Alternative", "Lio/ktor/http/ContentType;", "getAlternative", "()Lio/ktor/http/ContentType;", "Any", "getAny", "ByteRanges", "getByteRanges", "Encrypted", "getEncrypted", "FormData", "getFormData", "Mixed", "getMixed", "Related", "getRelated", "Signed", "getSigned", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MultiPart {
        private static final ContentType Alternative;
        private static final ContentType Any;
        private static final ContentType ByteRanges;
        private static final ContentType Encrypted;
        private static final ContentType FormData;
        public static final MultiPart INSTANCE = new MultiPart();
        private static final ContentType Mixed;
        private static final ContentType Related;
        private static final ContentType Signed;

        private MultiPart() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("multipart", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Mixed = new ContentType("multipart", "mixed", list2, i2, defaultConstructorMarker2);
            Alternative = new ContentType("multipart", "alternative", list, i, defaultConstructorMarker);
            Related = new ContentType("multipart", "related", list2, i2, defaultConstructorMarker2);
            FormData = new ContentType("multipart", "form-data", list, i, defaultConstructorMarker);
            Signed = new ContentType("multipart", "signed", list2, i2, defaultConstructorMarker2);
            Encrypted = new ContentType("multipart", "encrypted", list, i, defaultConstructorMarker);
            ByteRanges = new ContentType("multipart", "byteranges", list2, i2, defaultConstructorMarker2);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMixed() {
            return Mixed;
        }

        public final ContentType getAlternative() {
            return Alternative;
        }

        public final ContentType getRelated() {
            return Related;
        }

        public final ContentType getFormData() {
            return FormData;
        }

        public final ContentType getSigned() {
            return Signed;
        }

        public final ContentType getEncrypted() {
            return Encrypted;
        }

        public final ContentType getByteRanges() {
            return ByteRanges;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lio/ktor/http/ContentType$Text;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "CSS", "getCSS", "CSV", "getCSV", "EventStream", "getEventStream", "Html", "getHtml", "JavaScript", "getJavaScript", "Plain", "getPlain", "VCard", "getVCard", "Xml", "getXml", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Text {
        private static final ContentType Any;
        private static final ContentType CSS;
        private static final ContentType CSV;
        private static final ContentType EventStream;
        private static final ContentType Html;
        public static final Text INSTANCE = new Text();
        private static final ContentType JavaScript;
        private static final ContentType Plain;
        private static final ContentType VCard;
        private static final ContentType Xml;

        private Text() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("text", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Plain = new ContentType("text", "plain", list2, i2, defaultConstructorMarker2);
            CSS = new ContentType("text", "css", list, i, defaultConstructorMarker);
            CSV = new ContentType("text", SdkConstants.EXT_CSV, list2, i2, defaultConstructorMarker2);
            Html = new ContentType("text", "html", list, i, defaultConstructorMarker);
            JavaScript = new ContentType("text", "javascript", list2, i2, defaultConstructorMarker2);
            VCard = new ContentType("text", "vcard", list, i, defaultConstructorMarker);
            Xml = new ContentType("text", "xml", list2, i2, defaultConstructorMarker2);
            EventStream = new ContentType("text", "event-stream", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getPlain() {
            return Plain;
        }

        public final ContentType getCSS() {
            return CSS;
        }

        public final ContentType getCSV() {
            return CSV;
        }

        public final ContentType getHtml() {
            return Html;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getVCard() {
            return VCard;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getEventStream() {
            return EventStream;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/ktor/http/ContentType$Video;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "QuickTime", "getQuickTime", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Video {
        private static final ContentType Any;
        public static final Video INSTANCE = new Video();
        private static final ContentType MP4;
        private static final ContentType MPEG;
        private static final ContentType OGG;
        private static final ContentType QuickTime;

        private Video() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("video", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            MPEG = new ContentType("video", "mpeg", list2, i2, defaultConstructorMarker2);
            MP4 = new ContentType("video", "mp4", list, i, defaultConstructorMarker);
            OGG = new ContentType("video", "ogg", list2, i2, defaultConstructorMarker2);
            QuickTime = new ContentType("video", "quicktime", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final ContentType getQuickTime() {
            return QuickTime;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lio/ktor/http/ContentType$Font;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Collection", "getCollection", "Otf", "getOtf", "Sfnt", "getSfnt", "Ttf", "getTtf", "Woff", "getWoff", "Woff2", "getWoff2", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Font {
        private static final ContentType Any;
        private static final ContentType Collection;
        public static final Font INSTANCE = new Font();
        private static final ContentType Otf;
        private static final ContentType Sfnt;
        private static final ContentType Ttf;
        private static final ContentType Woff;
        private static final ContentType Woff2;

        private Font() {
        }

        static {
            int i = 4;
            DefaultConstructorMarker defaultConstructorMarker = null;
            List list = null;
            Any = new ContentType("font", Marker.ANY_MARKER, list, i, defaultConstructorMarker);
            int i2 = 4;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            List list2 = null;
            Collection = new ContentType("font", "collection", list2, i2, defaultConstructorMarker2);
            Otf = new ContentType("font", "otf", list, i, defaultConstructorMarker);
            Sfnt = new ContentType("font", "sfnt", list2, i2, defaultConstructorMarker2);
            Ttf = new ContentType("font", "ttf", list, i, defaultConstructorMarker);
            Woff = new ContentType("font", "woff", list2, i2, defaultConstructorMarker2);
            Woff2 = new ContentType("font", "woff2", list, i, defaultConstructorMarker);
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getCollection() {
            return Collection;
        }

        public final ContentType getOtf() {
            return Otf;
        }

        public final ContentType getSfnt() {
            return Sfnt;
        }

        public final ContentType getTtf() {
            return Ttf;
        }

        public final ContentType getWoff() {
            return Woff;
        }

        public final ContentType getWoff2() {
            return Woff2;
        }
    }
}
