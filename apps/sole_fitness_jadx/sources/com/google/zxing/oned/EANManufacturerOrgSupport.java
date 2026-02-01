package com.google.zxing.oned;

import com.dyaco.sole.R2;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    EANManufacturerOrgSupport() {
    }

    String lookupCountryIdentifier(String str) throws NumberFormatException {
        int[] iArr;
        int i;
        initIfNeeded();
        int i2 = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i3 = 0; i3 < size && i2 >= (i = (iArr = this.ranges.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i = iArr[1];
            }
            if (i2 <= i) {
                return this.countryIdentifiers.get(i3);
            }
        }
        return null;
    }

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, R2.attr.carousel_infinite}, "US/CA");
            add(new int[]{300, R2.attr.layout_constraintLeft_toRightOf}, "FR");
            add(new int[]{R2.attr.layout_constraintRight_creator}, "BG");
            add(new int[]{R2.attr.layout_constraintStart_toEndOf}, "SI");
            add(new int[]{R2.attr.layout_constraintTag}, "HR");
            add(new int[]{R2.attr.layout_constraintTop_toBottomOf}, "BA");
            add(new int[]{400, R2.attr.matProg_linearProgress}, "DE");
            add(new int[]{R2.attr.measureFactor, R2.attr.mock_label}, "JP");
            add(new int[]{R2.attr.mock_labelBackgroundColor, R2.attr.motionEffect_strict}, "RU");
            add(new int[]{R2.attr.motionEffect_translationY}, "TW");
            add(new int[]{R2.attr.motionPathRotate}, "EE");
            add(new int[]{R2.attr.motionProgress}, "LV");
            add(new int[]{R2.attr.motionStagger}, "AZ");
            add(new int[]{R2.attr.motionTarget}, "LT");
            add(new int[]{R2.attr.motion_postLayoutCollision}, "UZ");
            add(new int[]{R2.attr.motion_triggerOnCollision}, "LK");
            add(new int[]{R2.attr.moveWhenScrollAtTop}, "PH");
            add(new int[]{R2.attr.multiChoiceItemLayout}, "BY");
            add(new int[]{R2.attr.navigationContentDescription}, "UA");
            add(new int[]{R2.attr.navigationMode}, "MD");
            add(new int[]{R2.attr.nestedScrollFlags}, "AM");
            add(new int[]{R2.attr.nestedScrollViewStyle}, "GE");
            add(new int[]{R2.attr.numberPickerStyle}, "KZ");
            add(new int[]{R2.attr.offColor}, "HK");
            add(new int[]{R2.attr.offDrawable, R2.attr.onTouchUp}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{R2.attr.popupTheme}, "GR");
            add(new int[]{R2.attr.queryBackground}, ExpandedProductParsedResult.POUND);
            add(new int[]{R2.attr.queryHint}, "CY");
            add(new int[]{R2.attr.radioButtonStyle}, "MK");
            add(new int[]{R2.attr.ratingBarStyleSmall}, "MT");
            add(new int[]{R2.attr.reactiveGuide_valueId}, "IE");
            add(new int[]{R2.attr.recyclerViewStyle, R2.attr.saturation}, "BE/LU");
            add(new int[]{R2.attr.selectionDividerHeight}, "PT");
            add(new int[]{R2.attr.singleChoiceItemLayout}, "IS");
            add(new int[]{R2.attr.sizePercent, R2.attr.springMass}, "DK");
            add(new int[]{R2.attr.subtitleTextAppearance}, "PL");
            add(new int[]{R2.attr.switchMinWidth}, "RO");
            add(new int[]{R2.attr.telltales_tailColor}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{608}, "BH");
            add(new int[]{609}, "MU");
            add(new int[]{611}, "MA");
            add(new int[]{R2.attr.textBackgroundPanY}, "DZ");
            add(new int[]{R2.attr.textColorAlertDialogListItem}, "KE");
            add(new int[]{R2.attr.textFillColor}, "CI");
            add(new int[]{R2.attr.textLocale}, "TN");
            add(new int[]{R2.attr.textOutlineThickness}, "SY");
            add(new int[]{R2.attr.textPanX}, "EG");
            add(new int[]{R2.attr.textureBlurFactor}, "LY");
            add(new int[]{R2.attr.textureEffect}, "JO");
            add(new int[]{R2.attr.textureHeight}, "IR");
            add(new int[]{R2.attr.textureWidth}, "KW");
            add(new int[]{R2.attr.theme}, "SA");
            add(new int[]{R2.attr.thickness}, "AE");
            add(new int[]{R2.attr.thumb_marginRight, R2.attr.titleMargin}, "FI");
            add(new int[]{R2.attr.upDuration, R2.attr.viewTransitionOnNegativeCross}, "CN");
            add(new int[]{700, R2.attr.wheel_atmosphericEnabled}, "NO");
            add(new int[]{R2.attr.wheel_itemTextColorSelected}, "IL");
            add(new int[]{R2.attr.wheel_itemTextSize, R2.attr.wheel_stepNumber}, "SE");
            add(new int[]{R2.attr.wheel_thirdLabel}, "GT");
            add(new int[]{R2.attr.wheel_thirdVisible}, "SV");
            add(new int[]{R2.attr.wheel_timeMode}, "HN");
            add(new int[]{R2.attr.wheel_visibleItemCount}, "NI");
            add(new int[]{R2.attr.wheel_yearLabel}, "CR");
            add(new int[]{R2.attr.windowActionBar}, "PA");
            add(new int[]{R2.attr.windowActionBarOverlay}, "DO");
            add(new int[]{R2.attr.windowFixedWidthMajor}, "MX");
            add(new int[]{R2.attr.windowNoTitle, R2.attr.zOrderOnTop}, "CA");
            add(new int[]{R2.attr.zxing_possible_result_points}, "VE");
            add(new int[]{R2.attr.zxing_preview_scaling_strategy, R2.color.abc_background_cache_hint_selector_material_dark}, "CH");
            add(new int[]{R2.color.abc_background_cache_hint_selector_material_light}, "CO");
            add(new int[]{R2.color.abc_color_highlight_material}, "UY");
            add(new int[]{R2.color.abc_decor_view_status_guard_light}, "PE");
            add(new int[]{R2.color.abc_hint_foreground_material_light}, "BO");
            add(new int[]{R2.color.abc_primary_text_disable_only_material_light}, "AR");
            add(new int[]{R2.color.abc_primary_text_material_dark}, "CL");
            add(new int[]{R2.color.abc_search_url_text_pressed}, "PY");
            add(new int[]{R2.color.abc_search_url_text_selected}, "PE");
            add(new int[]{R2.color.abc_secondary_text_material_dark}, "EC");
            add(new int[]{R2.color.abc_tint_default, R2.color.abc_tint_edittext}, "BR");
            add(new int[]{R2.color.aqua, R2.color.colorGoal_bg}, "IT");
            add(new int[]{R2.color.colorPrimary, R2.color.com_facebook_button_send_background_color}, "ES");
            add(new int[]{R2.color.com_facebook_button_send_background_color_pressed}, "CU");
            add(new int[]{R2.color.com_facebook_primary_button_pressed_text_color}, "SK");
            add(new int[]{R2.color.com_facebook_primary_button_text_color}, "CZ");
            add(new int[]{R2.color.com_facebook_send_button_text_color}, "YU");
            add(new int[]{R2.color.common_google_signin_btn_text_dark_focused}, "MN");
            add(new int[]{R2.color.common_google_signin_btn_text_light}, "KP");
            add(new int[]{R2.color.common_google_signin_btn_text_light_default, R2.color.common_google_signin_btn_text_light_disabled}, "TR");
            add(new int[]{R2.color.common_google_signin_btn_text_light_focused, R2.color.dark_gray1}, "NL");
            add(new int[]{R2.color.dark_gray2}, "KR");
            add(new int[]{R2.color.darkgoldenrod}, "TH");
            add(new int[]{R2.color.darkkhaki}, "SG");
            add(new int[]{R2.color.darkolivegreen}, "IN");
            add(new int[]{R2.color.darkred}, "VN");
            add(new int[]{R2.color.darkslateblue}, "PK");
            add(new int[]{R2.color.darkturquoise}, "ID");
            add(new int[]{900, R2.color.forestgreen}, "AT");
            add(new int[]{R2.color.grey, R2.color.khaki}, "AU");
            add(new int[]{R2.color.lavender, R2.color.lightcyan}, "AZ");
            add(new int[]{R2.color.lightsalmon}, "MY");
            add(new int[]{R2.color.lightslategray}, "MO");
        }
    }
}
