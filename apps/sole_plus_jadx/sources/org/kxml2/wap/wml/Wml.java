package org.kxml2.wap.wml;

import androidx.health.connect.client.records.CervicalMucusRecord;
import com.android.SdkConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.samsung.android.sdk.healthdata.HealthConstants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.LinkHeader;
import org.kxml2.wap.WbxmlParser;
import org.kxml2.wap.WbxmlSerializer;

/* loaded from: classes6.dex */
public abstract class Wml {
    public static final String[] TAG_TABLE = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "a", "td", "tr", "table", "p", "postfield", LinkHeader.Parameters.Anchor, "access", "b", "big", "br", "card", "do", UserDataStore.EMAIL, "fieldset", "go", "head", "i", "img", "input", "meta", "noop", "prev", "onevent", "optgroup", "option", "refresh", "select", "small", "strong", null, SDKConstants.PARAM_UPDATE_TEMPLATE, "timer", "u", "setvar", "wml"};
    public static final String[] ATTR_START_TABLE = {"accept-charset", "align=bottom", "align=center", "align=left", "align=middle", "align=right", "align=top", HealthConstants.Alt.ALT, "content", null, "domain", "emptyok=false", "emptyok=true", "format", "height", "hspace", "ivalue", "iname", null, "label", "localsrc", "maxlength", "method=get", "method=post", "mode=nowrap", "mode=wrap", "multiple=false", "multiple=true", "name", "newcontext=false", "newcontext=true", "onpick", "onenterbackward", "onenterforward", "ontimer", "optimal=false", "optimal=true", "path", null, null, null, SdkConstants.ATTR_SCHEME, "sendreferer=false", "sendreferer=true", ContentDisposition.Parameters.Size, "src", "ordered=true", "ordered=false", "tabindex", "title", "type", "type=accept", "type=delete", "type=help", "type=password", "type=onpick", "type=onenterbackward", "type=onenterforward", "type=ontimer", null, null, null, null, null, "type=options", "type=prev", "type=reset", "type=text", "type=vnd.", ShareConstants.WEB_DIALOG_PARAM_HREF, "href=http://", "href=https://", "value", "vspace", "width", "xml:lang", null, "align", "columns", "class", "id", "forua=false", "forua=true", "src=http://", "src=https://", "http-equiv", "http-equiv=Content-Type", "content=application/vnd.wap.wmlc;charset=", "http-equiv=Expires", null, null};
    public static final String[] ATTR_VALUE_TABLE = {".com/", ".edu/", ".net/", ".org/", "accept", "bottom", CervicalMucusRecord.Appearance.CLEAR, "delete", "help", "http://", "http://www.", "https://", "https://www.", null, "middle", "nowrap", "onpick", "onenterbackward", "onenterforward", "ontimer", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "password", "reset", null, "text", "top", "unknown", "wrap", "www."};

    public static WbxmlParser createParser() {
        WbxmlParser wbxmlParser = new WbxmlParser();
        wbxmlParser.setTagTable(0, TAG_TABLE);
        wbxmlParser.setAttrStartTable(0, ATTR_START_TABLE);
        wbxmlParser.setAttrValueTable(0, ATTR_VALUE_TABLE);
        return wbxmlParser;
    }

    public static WbxmlSerializer createSerializer() {
        WbxmlSerializer wbxmlSerializer = new WbxmlSerializer();
        wbxmlSerializer.setTagTable(0, TAG_TABLE);
        wbxmlSerializer.setAttrStartTable(0, ATTR_START_TABLE);
        wbxmlSerializer.setAttrValueTable(0, ATTR_VALUE_TABLE);
        return wbxmlSerializer;
    }
}
