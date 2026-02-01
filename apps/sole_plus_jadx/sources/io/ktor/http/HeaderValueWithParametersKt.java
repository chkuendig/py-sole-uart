package io.ktor.http;

import com.facebook.share.internal.ShareConstants;
import io.ktor.util.StringValuesBuilder;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: HeaderValueWithParameters.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u0007*\u00020\u0007\u001a\u0019\u0010\u000b\u001a\u00020\u0004*\u00020\u00072\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0082\b\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\n\u0010\u0012\u001a\u00020\u0007*\u00020\u0007\u001a\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00072\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"HeaderFieldValueSeparators", "", "", "append", "", "Lio/ktor/util/StringValuesBuilder;", "name", "", "value", "Lio/ktor/http/HeaderValueWithParameters;", "escapeIfNeeded", "escapeIfNeededTo", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isQuoted", "", "needQuotes", ShareConstants.WEB_DIALOG_PARAM_QUOTE, "quoteTo", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HeaderValueWithParametersKt {
    private static final Set<Character> HeaderFieldValueSeparators = SetsKt.setOf((Object[]) new Character[]{'(', ')', Character.valueOf(Typography.less), Character.valueOf(Typography.greater), '@', Character.valueOf(AbstractJsonLexerKt.COMMA), ';', ':', Character.valueOf(AbstractJsonLexerKt.STRING_ESC), '\"', '/', Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), '?', Character.valueOf(SignatureVisitor.INSTANCEOF), Character.valueOf(AbstractJsonLexerKt.BEGIN_OBJ), Character.valueOf(AbstractJsonLexerKt.END_OBJ), ' ', '\t', '\n', '\r'});

    public static final void append(StringValuesBuilder stringValuesBuilder, String name, HeaderValueWithParameters value) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        stringValuesBuilder.append(name, value.toString());
    }

    public static final String escapeIfNeeded(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return needQuotes(str) ? quote(str) : str;
    }

    private static final void escapeIfNeededTo(String str, StringBuilder sb) {
        if (needQuotes(str)) {
            sb.append(quote(str));
        } else {
            sb.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean needQuotes(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (isQuoted(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (HeaderFieldValueSeparators.contains(Character.valueOf(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isQuoted(String str) {
        if (str.length() < 2) {
            return false;
        }
        String str2 = str;
        if (StringsKt.first(str2) != '\"' || StringsKt.last(str2) != '\"') {
            return false;
        }
        int i = 1;
        do {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, '\"', i, false, 4, (Object) null);
            if (iIndexOf$default == StringsKt.getLastIndex(str2)) {
                break;
            }
            int i2 = 0;
            for (int i3 = iIndexOf$default - 1; str.charAt(i3) == '\\'; i3--) {
                i2++;
            }
            if (i2 % 2 == 0) {
                return false;
            }
            i = iIndexOf$default + 1;
        } while (i < str.length());
        return true;
    }

    public static final String quote(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        quoteTo(str, sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final void quoteTo(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append("\"");
    }
}
