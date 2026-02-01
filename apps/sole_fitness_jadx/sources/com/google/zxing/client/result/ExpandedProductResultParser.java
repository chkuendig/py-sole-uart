package com.google.zxing.client.result;

import com.dyaco.sole.R2;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;
import org.apache.http.message.TokenParser;

/* loaded from: classes2.dex */
public final class ExpandedProductResultParser extends ResultParser {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    @Override // com.google.zxing.client.result.ResultParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExpandedProductParsedResult parse(Result result) {
        ExpandedProductParsedResult expandedProductParsedResult = null;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = getMassagedText(result);
        HashMap map = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String strSubstring = null;
        String str10 = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        int i = 0;
        while (i < massagedText.length()) {
            String strFindAIvalue = findAIvalue(i, massagedText);
            if (strFindAIvalue == null) {
                return expandedProductParsedResult;
            }
            char c = 2;
            int length = i + strFindAIvalue.length() + 2;
            String strFindValue = findValue(length, massagedText);
            int length2 = length + strFindValue.length();
            strFindAIvalue.hashCode();
            switch (strFindAIvalue.hashCode()) {
                case R2.dimen.sign_item_delete_size /* 1536 */:
                    if (!strFindAIvalue.equals("00")) {
                        c = 65535;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case R2.dimen.sign_item_divider_height /* 1537 */:
                    if (strFindAIvalue.equals("01")) {
                        c = 1;
                        break;
                    }
                    break;
                case R2.dimen.tooltip_y_offset_touch /* 1567 */:
                    if (!strFindAIvalue.equals("10")) {
                    }
                    break;
                case R2.dimen.track_minute_textview_textSize /* 1568 */:
                    if (strFindAIvalue.equals("11")) {
                        c = 3;
                        break;
                    }
                    break;
                case R2.dimen.user_margin_top /* 1570 */:
                    if (strFindAIvalue.equals("13")) {
                        c = 4;
                        break;
                    }
                    break;
                case R2.dimen.volumebar_height /* 1572 */:
                    if (strFindAIvalue.equals("15")) {
                        c = 5;
                        break;
                    }
                    break;
                case R2.dimen.workout_data_chart_title_height /* 1574 */:
                    if (strFindAIvalue.equals("17")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1567966:
                    if (strFindAIvalue.equals("3100")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1567967:
                    if (strFindAIvalue.equals("3101")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1567968:
                    if (strFindAIvalue.equals("3102")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1567969:
                    if (strFindAIvalue.equals("3103")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1567970:
                    if (strFindAIvalue.equals("3104")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1567971:
                    if (strFindAIvalue.equals("3105")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1567972:
                    if (strFindAIvalue.equals("3106")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1567973:
                    if (strFindAIvalue.equals("3107")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1567974:
                    if (strFindAIvalue.equals("3108")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1567975:
                    if (strFindAIvalue.equals("3109")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1568927:
                    if (strFindAIvalue.equals("3200")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1568928:
                    if (strFindAIvalue.equals("3201")) {
                        c = 18;
                        break;
                    }
                    break;
                case 1568929:
                    if (strFindAIvalue.equals("3202")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1568930:
                    if (strFindAIvalue.equals("3203")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1568931:
                    if (strFindAIvalue.equals("3204")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1568932:
                    if (strFindAIvalue.equals("3205")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1568933:
                    if (strFindAIvalue.equals("3206")) {
                        c = 23;
                        break;
                    }
                    break;
                case 1568934:
                    if (strFindAIvalue.equals("3207")) {
                        c = 24;
                        break;
                    }
                    break;
                case 1568935:
                    if (strFindAIvalue.equals("3208")) {
                        c = 25;
                        break;
                    }
                    break;
                case 1568936:
                    if (strFindAIvalue.equals("3209")) {
                        c = 26;
                        break;
                    }
                    break;
                case 1575716:
                    if (strFindAIvalue.equals("3920")) {
                        c = 27;
                        break;
                    }
                    break;
                case 1575717:
                    if (strFindAIvalue.equals("3921")) {
                        c = 28;
                        break;
                    }
                    break;
                case 1575718:
                    if (strFindAIvalue.equals("3922")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1575719:
                    if (strFindAIvalue.equals("3923")) {
                        c = 30;
                        break;
                    }
                    break;
                case 1575747:
                    if (strFindAIvalue.equals("3930")) {
                        c = 31;
                        break;
                    }
                    break;
                case 1575748:
                    if (strFindAIvalue.equals("3931")) {
                        c = TokenParser.SP;
                        break;
                    }
                    break;
                case 1575749:
                    if (strFindAIvalue.equals("3932")) {
                        c = '!';
                        break;
                    }
                    break;
                case 1575750:
                    if (strFindAIvalue.equals("3933")) {
                        c = '\"';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str2 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 1:
                    str = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 2:
                    str3 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 3:
                    str4 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 4:
                    str5 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 5:
                    str6 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 6:
                    str7 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                case 16:
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = ExpandedProductParsedResult.KILOGRAM;
                    str8 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = ExpandedProductParsedResult.POUND;
                    str8 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 27:
                case 28:
                case 29:
                case 30:
                    strSubstring2 = strFindAIvalue.substring(3);
                    str10 = strFindValue;
                    i = length2;
                    expandedProductParsedResult = null;
                case 31:
                case ' ':
                case '!':
                case '\"':
                    if (strFindValue.length() < 4) {
                        return null;
                    }
                    String strSubstring4 = strFindValue.substring(3);
                    strSubstring3 = strFindValue.substring(0, 3);
                    str10 = strSubstring4;
                    i = length2;
                    expandedProductParsedResult = null;
                    strSubstring2 = strFindAIvalue.substring(3);
                default:
                    map.put(strFindAIvalue, strFindValue);
                    i = length2;
                    expandedProductParsedResult = null;
            }
        }
        return new ExpandedProductParsedResult(massagedText, str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, str10, strSubstring2, strSubstring3, map);
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String strSubstring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i);
        for (int i2 = 0; i2 < strSubstring.length(); i2++) {
            char cCharAt = strSubstring.charAt(i2);
            if (cCharAt == '(') {
                if (findAIvalue(i2, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
