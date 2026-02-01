package com.soletreadmills.sole_v2;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.databinding.ActivityMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterCategoryItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClassesEndBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClassesQuickPicksBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClassesResultsBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClassesSessionsBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubAvatarItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubEditPrivacyItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubEditScoreItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubListItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubMemberScoreItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubOngiongItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubScoreboardItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterClubSearchItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterCollectionsItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterConnectDeviceItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterConnectEditProgramItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterConnectHrmItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterConnectPageCategoryItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterConnectPageItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterDisplayDashboardItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterDisplayStatsSelectItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterFavoritesItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterFollowedCollectionItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterGoalsItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterGoalsMainItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterGoalsTopItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryActivitytypeItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryHeaderItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterHistoryWorkoutItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterHomeConnectItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterInboxItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterIosAlertActionSheetDialogBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterLanguageSettingsBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterMyDevicesItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterMyFavoritesItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterPayWallItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterPersonalBestYearItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterPickForYouItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterQuickPickItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterRunningTrendsItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterSelectDurationItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterSelectFocusItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterSelectIconItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.AdapterSelectInstructorItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.BottomSheetDisplayModeAdjustBindingImpl;
import com.soletreadmills.sole_v2.databinding.BottomSheetGoalsDetailBindingImpl;
import com.soletreadmills.sole_v2.databinding.BottomSheetGoalsEditTargetBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomBottomDialogBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomDashboardChartBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomDisplayStatsSelectBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomHistoryWorkoutChartItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomHistoryWorkoutItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomPairingDialogBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomProgramSliderviewBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSectionItemViewBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectActivityBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectBleConnectBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectDurationBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectFitnessLevelBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectFocusBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectInstructorsBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomSelectLanguageBindingImpl;
import com.soletreadmills.sole_v2.databinding.CustomTabBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogClubFilterDurationBottomSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogClubFilterEquipmentBottomSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogClubFilterFormatBottomSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogClubFilterTargetBottomSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogClubSelectEventTypeBottomSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogIosAlertActionSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogIosOnePickerBottomSheetBindingImpl;
import com.soletreadmills.sole_v2.databinding.DialogSubscriptionViaSnCameraBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentActivityMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentBannerBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentCancelSubscriptionBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentChooseBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClassesMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubAllEventsBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubEditFormBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubEventDetailBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubJoinEventBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubMemberScoreBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubMyEventsBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubRaceBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubRaceBindingLandImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubScoreboardListBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentClubSearchEventBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentConnectDeviceBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentConnectEditProgramBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentConnectProgramBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentConnectedPageBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardP1BindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardP2BindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentDisplayDashboardP3BindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentDisplaySettingsBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentEditProfileBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentGarminConnectBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentGoalsCreateBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentGoalsMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentHeartRateMonitorBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentHistoryBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentHistoryWorkoutBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentHomeMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentHowToLinkProfileBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentInboxBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentInboxMsgBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentLoginBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentLogoBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentMyDevicesBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentMyFavoritesBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentOnboardingBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentPairDeviceBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentPairDevicePageItemBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentPaywallBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentPersonalBestBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentQrcodeBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentRematchBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentRematchBindingLandImpl;
import com.soletreadmills.sole_v2.databinding.FragmentResetPasswordBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSelectIconBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSettingProfileBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSettingsAppsBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSettingsMainBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSignUpBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSubscriptionBluetoothBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentSubscriptionPayWebBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentTrendChartBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentUserSubscriptionBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentVerifyEmailBindingImpl;
import com.soletreadmills.sole_v2.databinding.FragmentWorkoutSettingsBindingImpl;
import com.soletreadmills.sole_v2.databinding.PopupItemLayoutBindingImpl;
import com.soletreadmills.sole_v2.databinding.SharedProcessBarBindingImpl;
import com.soletreadmills.sole_v2.databinding.ViewDisplayDashboardItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYMAIN = 1;
    private static final int LAYOUT_ADAPTERCATEGORYITEM = 2;
    private static final int LAYOUT_ADAPTERCLASSESEND = 3;
    private static final int LAYOUT_ADAPTERCLASSESQUICKPICKS = 4;
    private static final int LAYOUT_ADAPTERCLASSESRESULTS = 5;
    private static final int LAYOUT_ADAPTERCLASSESSESSIONS = 6;
    private static final int LAYOUT_ADAPTERCLUBAVATARITEM = 7;
    private static final int LAYOUT_ADAPTERCLUBEDITPRIVACYITEM = 8;
    private static final int LAYOUT_ADAPTERCLUBEDITSCOREITEM = 9;
    private static final int LAYOUT_ADAPTERCLUBLISTITEM = 10;
    private static final int LAYOUT_ADAPTERCLUBMEMBERSCOREITEM = 11;
    private static final int LAYOUT_ADAPTERCLUBONGIONGITEM = 12;
    private static final int LAYOUT_ADAPTERCLUBSCOREBOARDITEM = 13;
    private static final int LAYOUT_ADAPTERCLUBSEARCHITEM = 14;
    private static final int LAYOUT_ADAPTERCOLLECTIONSITEM = 15;
    private static final int LAYOUT_ADAPTERCONNECTDEVICEITEM = 16;
    private static final int LAYOUT_ADAPTERCONNECTEDITPROGRAMITEM = 17;
    private static final int LAYOUT_ADAPTERCONNECTHRMITEM = 18;
    private static final int LAYOUT_ADAPTERCONNECTPAGECATEGORYITEM = 19;
    private static final int LAYOUT_ADAPTERCONNECTPAGEITEM = 20;
    private static final int LAYOUT_ADAPTERDISPLAYDASHBOARDITEM = 21;
    private static final int LAYOUT_ADAPTERDISPLAYSTATSSELECTITEM = 22;
    private static final int LAYOUT_ADAPTERFAVORITESITEM = 23;
    private static final int LAYOUT_ADAPTERFOLLOWEDCOLLECTIONITEM = 24;
    private static final int LAYOUT_ADAPTERGOALSITEM = 25;
    private static final int LAYOUT_ADAPTERGOALSMAINITEM = 26;
    private static final int LAYOUT_ADAPTERGOALSTOPITEM = 27;
    private static final int LAYOUT_ADAPTERHISTORYACTIVITYTYPEITEM = 28;
    private static final int LAYOUT_ADAPTERHISTORYHEADERITEM = 29;
    private static final int LAYOUT_ADAPTERHISTORYITEM = 30;
    private static final int LAYOUT_ADAPTERHISTORYWORKOUTITEM = 31;
    private static final int LAYOUT_ADAPTERHOMECONNECTITEM = 32;
    private static final int LAYOUT_ADAPTERINBOXITEM = 33;
    private static final int LAYOUT_ADAPTERIOSALERTACTIONSHEETDIALOG = 34;
    private static final int LAYOUT_ADAPTERLANGUAGESETTINGS = 35;
    private static final int LAYOUT_ADAPTERMYDEVICESITEM = 36;
    private static final int LAYOUT_ADAPTERMYFAVORITESITEM = 37;
    private static final int LAYOUT_ADAPTERPAYWALLITEM = 38;
    private static final int LAYOUT_ADAPTERPERSONALBESTYEARITEM = 39;
    private static final int LAYOUT_ADAPTERPICKFORYOUITEM = 40;
    private static final int LAYOUT_ADAPTERQUICKPICKITEM = 41;
    private static final int LAYOUT_ADAPTERRUNNINGTRENDSITEM = 42;
    private static final int LAYOUT_ADAPTERSELECTDURATIONITEM = 43;
    private static final int LAYOUT_ADAPTERSELECTFOCUSITEM = 44;
    private static final int LAYOUT_ADAPTERSELECTICONITEM = 45;
    private static final int LAYOUT_ADAPTERSELECTINSTRUCTORITEM = 46;
    private static final int LAYOUT_BOTTOMSHEETDISPLAYMODEADJUST = 47;
    private static final int LAYOUT_BOTTOMSHEETGOALSDETAIL = 48;
    private static final int LAYOUT_BOTTOMSHEETGOALSEDITTARGET = 49;
    private static final int LAYOUT_CUSTOMBOTTOMDIALOG = 50;
    private static final int LAYOUT_CUSTOMDASHBOARDCHART = 51;
    private static final int LAYOUT_CUSTOMDISPLAYSTATSSELECT = 52;
    private static final int LAYOUT_CUSTOMHISTORYWORKOUTCHARTITEM = 53;
    private static final int LAYOUT_CUSTOMHISTORYWORKOUTITEM = 54;
    private static final int LAYOUT_CUSTOMPAIRINGDIALOG = 55;
    private static final int LAYOUT_CUSTOMPROGRAMSLIDERVIEW = 56;
    private static final int LAYOUT_CUSTOMSECTIONITEMVIEW = 57;
    private static final int LAYOUT_CUSTOMSELECTACTIVITY = 58;
    private static final int LAYOUT_CUSTOMSELECTBLECONNECT = 59;
    private static final int LAYOUT_CUSTOMSELECTDURATION = 60;
    private static final int LAYOUT_CUSTOMSELECTFITNESSLEVEL = 61;
    private static final int LAYOUT_CUSTOMSELECTFOCUS = 62;
    private static final int LAYOUT_CUSTOMSELECTINSTRUCTORS = 63;
    private static final int LAYOUT_CUSTOMSELECTLANGUAGE = 64;
    private static final int LAYOUT_CUSTOMTAB = 65;
    private static final int LAYOUT_DIALOGCLUBFILTERDURATIONBOTTOMSHEET = 66;
    private static final int LAYOUT_DIALOGCLUBFILTEREQUIPMENTBOTTOMSHEET = 67;
    private static final int LAYOUT_DIALOGCLUBFILTERFORMATBOTTOMSHEET = 68;
    private static final int LAYOUT_DIALOGCLUBFILTERTARGETBOTTOMSHEET = 69;
    private static final int LAYOUT_DIALOGCLUBSELECTEVENTTYPEBOTTOMSHEET = 70;
    private static final int LAYOUT_DIALOGIOSALERTACTIONSHEET = 71;
    private static final int LAYOUT_DIALOGIOSONEPICKERBOTTOMSHEET = 72;
    private static final int LAYOUT_DIALOGSUBSCRIPTIONVIASNCAMERA = 73;
    private static final int LAYOUT_FRAGMENTACTIVITYMAIN = 74;
    private static final int LAYOUT_FRAGMENTBANNER = 75;
    private static final int LAYOUT_FRAGMENTCANCELSUBSCRIPTION = 76;
    private static final int LAYOUT_FRAGMENTCHOOSE = 77;
    private static final int LAYOUT_FRAGMENTCLASSESMAIN = 78;
    private static final int LAYOUT_FRAGMENTCLUBALLEVENTS = 79;
    private static final int LAYOUT_FRAGMENTCLUBEDITFORM = 80;
    private static final int LAYOUT_FRAGMENTCLUBEVENTDETAIL = 81;
    private static final int LAYOUT_FRAGMENTCLUBJOINEVENT = 82;
    private static final int LAYOUT_FRAGMENTCLUBMAIN = 83;
    private static final int LAYOUT_FRAGMENTCLUBMEMBERSCORE = 84;
    private static final int LAYOUT_FRAGMENTCLUBMYEVENTS = 85;
    private static final int LAYOUT_FRAGMENTCLUBRACE = 86;
    private static final int LAYOUT_FRAGMENTCLUBSCOREBOARDLIST = 87;
    private static final int LAYOUT_FRAGMENTCLUBSEARCHEVENT = 88;
    private static final int LAYOUT_FRAGMENTCONNECTDEVICE = 89;
    private static final int LAYOUT_FRAGMENTCONNECTEDITPROGRAM = 90;
    private static final int LAYOUT_FRAGMENTCONNECTEDPAGE = 92;
    private static final int LAYOUT_FRAGMENTCONNECTPROGRAM = 91;
    private static final int LAYOUT_FRAGMENTDISPLAYDASHBOARD = 93;
    private static final int LAYOUT_FRAGMENTDISPLAYDASHBOARDP1 = 94;
    private static final int LAYOUT_FRAGMENTDISPLAYDASHBOARDP2 = 95;
    private static final int LAYOUT_FRAGMENTDISPLAYDASHBOARDP3 = 96;
    private static final int LAYOUT_FRAGMENTDISPLAYSETTINGS = 97;
    private static final int LAYOUT_FRAGMENTEDITPROFILE = 98;
    private static final int LAYOUT_FRAGMENTGARMINCONNECT = 99;
    private static final int LAYOUT_FRAGMENTGOALSCREATE = 100;
    private static final int LAYOUT_FRAGMENTGOALSMAIN = 101;
    private static final int LAYOUT_FRAGMENTHEARTRATEMONITOR = 102;
    private static final int LAYOUT_FRAGMENTHISTORY = 103;
    private static final int LAYOUT_FRAGMENTHISTORYWORKOUT = 104;
    private static final int LAYOUT_FRAGMENTHOMEMAIN = 105;
    private static final int LAYOUT_FRAGMENTHOWTOLINKPROFILE = 106;
    private static final int LAYOUT_FRAGMENTINBOX = 107;
    private static final int LAYOUT_FRAGMENTINBOXMSG = 108;
    private static final int LAYOUT_FRAGMENTLOGIN = 109;
    private static final int LAYOUT_FRAGMENTLOGO = 110;
    private static final int LAYOUT_FRAGMENTMYDEVICES = 111;
    private static final int LAYOUT_FRAGMENTMYFAVORITES = 112;
    private static final int LAYOUT_FRAGMENTONBOARDING = 113;
    private static final int LAYOUT_FRAGMENTPAIRDEVICE = 114;
    private static final int LAYOUT_FRAGMENTPAIRDEVICEPAGEITEM = 115;
    private static final int LAYOUT_FRAGMENTPAYWALL = 116;
    private static final int LAYOUT_FRAGMENTPERSONALBEST = 117;
    private static final int LAYOUT_FRAGMENTQRCODE = 118;
    private static final int LAYOUT_FRAGMENTREMATCH = 119;
    private static final int LAYOUT_FRAGMENTRESETPASSWORD = 120;
    private static final int LAYOUT_FRAGMENTSELECTICON = 121;
    private static final int LAYOUT_FRAGMENTSETTINGPROFILE = 122;
    private static final int LAYOUT_FRAGMENTSETTINGSAPPS = 123;
    private static final int LAYOUT_FRAGMENTSETTINGSMAIN = 124;
    private static final int LAYOUT_FRAGMENTSIGNUP = 125;
    private static final int LAYOUT_FRAGMENTSUBSCRIPTIONBLUETOOTH = 126;
    private static final int LAYOUT_FRAGMENTSUBSCRIPTIONPAYWEB = 127;
    private static final int LAYOUT_FRAGMENTTRENDCHART = 128;
    private static final int LAYOUT_FRAGMENTUSERSUBSCRIPTION = 129;
    private static final int LAYOUT_FRAGMENTVERIFYEMAIL = 130;
    private static final int LAYOUT_FRAGMENTWORKOUTSETTINGS = 131;
    private static final int LAYOUT_POPUPITEMLAYOUT = 132;
    private static final int LAYOUT_SHAREDPROCESSBAR = 133;
    private static final int LAYOUT_VIEWDISPLAYDASHBOARDITEM = 134;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(134);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_main, 1);
        sparseIntArray.put(R.layout.adapter_category_item, 2);
        sparseIntArray.put(R.layout.adapter_classes_end, 3);
        sparseIntArray.put(R.layout.adapter_classes_quick_picks, 4);
        sparseIntArray.put(R.layout.adapter_classes_results, 5);
        sparseIntArray.put(R.layout.adapter_classes_sessions, 6);
        sparseIntArray.put(R.layout.adapter_club_avatar_item, 7);
        sparseIntArray.put(R.layout.adapter_club_edit_privacy_item, 8);
        sparseIntArray.put(R.layout.adapter_club_edit_score_item, 9);
        sparseIntArray.put(R.layout.adapter_club_list_item, 10);
        sparseIntArray.put(R.layout.adapter_club_member_score_item, 11);
        sparseIntArray.put(R.layout.adapter_club_ongiong_item, 12);
        sparseIntArray.put(R.layout.adapter_club_scoreboard_item, 13);
        sparseIntArray.put(R.layout.adapter_club_search_item, 14);
        sparseIntArray.put(R.layout.adapter_collections_item, 15);
        sparseIntArray.put(R.layout.adapter_connect_device_item, 16);
        sparseIntArray.put(R.layout.adapter_connect_edit_program_item, 17);
        sparseIntArray.put(R.layout.adapter_connect_hrm_item, 18);
        sparseIntArray.put(R.layout.adapter_connect_page_category_item, 19);
        sparseIntArray.put(R.layout.adapter_connect_page_item, 20);
        sparseIntArray.put(R.layout.adapter_display_dashboard_item, 21);
        sparseIntArray.put(R.layout.adapter_display_stats_select_item, 22);
        sparseIntArray.put(R.layout.adapter_favorites_item, 23);
        sparseIntArray.put(R.layout.adapter_followed_collection_item, 24);
        sparseIntArray.put(R.layout.adapter_goals_item, 25);
        sparseIntArray.put(R.layout.adapter_goals_main_item, 26);
        sparseIntArray.put(R.layout.adapter_goals_top_item, 27);
        sparseIntArray.put(R.layout.adapter_history_activitytype_item, 28);
        sparseIntArray.put(R.layout.adapter_history_header_item, 29);
        sparseIntArray.put(R.layout.adapter_history_item, 30);
        sparseIntArray.put(R.layout.adapter_history_workout_item, 31);
        sparseIntArray.put(R.layout.adapter_home_connect_item, 32);
        sparseIntArray.put(R.layout.adapter_inbox_item, 33);
        sparseIntArray.put(R.layout.adapter_ios_alert_action_sheet_dialog, 34);
        sparseIntArray.put(R.layout.adapter_language_settings, 35);
        sparseIntArray.put(R.layout.adapter_my_devices_item, 36);
        sparseIntArray.put(R.layout.adapter_my_favorites_item, 37);
        sparseIntArray.put(R.layout.adapter_pay_wall_item, 38);
        sparseIntArray.put(R.layout.adapter_personal_best_year_item, 39);
        sparseIntArray.put(R.layout.adapter_pick_for_you_item, 40);
        sparseIntArray.put(R.layout.adapter_quick_pick_item, 41);
        sparseIntArray.put(R.layout.adapter_running_trends_item, 42);
        sparseIntArray.put(R.layout.adapter_select_duration_item, 43);
        sparseIntArray.put(R.layout.adapter_select_focus_item, 44);
        sparseIntArray.put(R.layout.adapter_select_icon_item, 45);
        sparseIntArray.put(R.layout.adapter_select_instructor_item, 46);
        sparseIntArray.put(R.layout.bottom_sheet_display_mode_adjust, 47);
        sparseIntArray.put(R.layout.bottom_sheet_goals_detail, 48);
        sparseIntArray.put(R.layout.bottom_sheet_goals_edit_target, 49);
        sparseIntArray.put(R.layout.custom_bottom_dialog, 50);
        sparseIntArray.put(R.layout.custom_dashboard_chart, 51);
        sparseIntArray.put(R.layout.custom_display_stats_select, 52);
        sparseIntArray.put(R.layout.custom_history_workout_chart_item, 53);
        sparseIntArray.put(R.layout.custom_history_workout_item, 54);
        sparseIntArray.put(R.layout.custom_pairing_dialog, 55);
        sparseIntArray.put(R.layout.custom_program_sliderview, 56);
        sparseIntArray.put(R.layout.custom_section_item_view, 57);
        sparseIntArray.put(R.layout.custom_select_activity, 58);
        sparseIntArray.put(R.layout.custom_select_ble_connect, 59);
        sparseIntArray.put(R.layout.custom_select_duration, 60);
        sparseIntArray.put(R.layout.custom_select_fitness_level, 61);
        sparseIntArray.put(R.layout.custom_select_focus, 62);
        sparseIntArray.put(R.layout.custom_select_instructors, 63);
        sparseIntArray.put(R.layout.custom_select_language, 64);
        sparseIntArray.put(R.layout.custom_tab, 65);
        sparseIntArray.put(R.layout.dialog_club_filter_duration_bottom_sheet, 66);
        sparseIntArray.put(R.layout.dialog_club_filter_equipment_bottom_sheet, 67);
        sparseIntArray.put(R.layout.dialog_club_filter_format_bottom_sheet, 68);
        sparseIntArray.put(R.layout.dialog_club_filter_target_bottom_sheet, 69);
        sparseIntArray.put(R.layout.dialog_club_select_event_type_bottom_sheet, 70);
        sparseIntArray.put(R.layout.dialog_ios_alert_action_sheet, 71);
        sparseIntArray.put(R.layout.dialog_ios_one_picker_bottom_sheet, 72);
        sparseIntArray.put(R.layout.dialog_subscription_via_sn_camera, 73);
        sparseIntArray.put(R.layout.fragment_activity_main, 74);
        sparseIntArray.put(R.layout.fragment_banner, 75);
        sparseIntArray.put(R.layout.fragment_cancel_subscription, 76);
        sparseIntArray.put(R.layout.fragment_choose, 77);
        sparseIntArray.put(R.layout.fragment_classes_main, 78);
        sparseIntArray.put(R.layout.fragment_club_all_events, 79);
        sparseIntArray.put(R.layout.fragment_club_edit_form, 80);
        sparseIntArray.put(R.layout.fragment_club_event_detail, 81);
        sparseIntArray.put(R.layout.fragment_club_join_event, 82);
        sparseIntArray.put(R.layout.fragment_club_main, 83);
        sparseIntArray.put(R.layout.fragment_club_member_score, 84);
        sparseIntArray.put(R.layout.fragment_club_my_events, 85);
        sparseIntArray.put(R.layout.fragment_club_race, 86);
        sparseIntArray.put(R.layout.fragment_club_scoreboard_list, 87);
        sparseIntArray.put(R.layout.fragment_club_search_event, 88);
        sparseIntArray.put(R.layout.fragment_connect_device, 89);
        sparseIntArray.put(R.layout.fragment_connect_edit_program, 90);
        sparseIntArray.put(R.layout.fragment_connect_program, 91);
        sparseIntArray.put(R.layout.fragment_connected_page, 92);
        sparseIntArray.put(R.layout.fragment_display_dashboard, 93);
        sparseIntArray.put(R.layout.fragment_display_dashboard_p1, 94);
        sparseIntArray.put(R.layout.fragment_display_dashboard_p2, 95);
        sparseIntArray.put(R.layout.fragment_display_dashboard_p3, 96);
        sparseIntArray.put(R.layout.fragment_display_settings, 97);
        sparseIntArray.put(R.layout.fragment_edit_profile, 98);
        sparseIntArray.put(R.layout.fragment_garmin_connect, 99);
        sparseIntArray.put(R.layout.fragment_goals_create, 100);
        sparseIntArray.put(R.layout.fragment_goals_main, 101);
        sparseIntArray.put(R.layout.fragment_heart_rate_monitor, 102);
        sparseIntArray.put(R.layout.fragment_history, 103);
        sparseIntArray.put(R.layout.fragment_history_workout, 104);
        sparseIntArray.put(R.layout.fragment_home_main, 105);
        sparseIntArray.put(R.layout.fragment_how_to_link_profile, 106);
        sparseIntArray.put(R.layout.fragment_inbox, 107);
        sparseIntArray.put(R.layout.fragment_inbox_msg, 108);
        sparseIntArray.put(R.layout.fragment_login, 109);
        sparseIntArray.put(R.layout.fragment_logo, 110);
        sparseIntArray.put(R.layout.fragment_my_devices, 111);
        sparseIntArray.put(R.layout.fragment_my_favorites, 112);
        sparseIntArray.put(R.layout.fragment_onboarding, 113);
        sparseIntArray.put(R.layout.fragment_pair_device, 114);
        sparseIntArray.put(R.layout.fragment_pair_device_page_item, 115);
        sparseIntArray.put(R.layout.fragment_paywall, 116);
        sparseIntArray.put(R.layout.fragment_personal_best, 117);
        sparseIntArray.put(R.layout.fragment_qrcode, 118);
        sparseIntArray.put(R.layout.fragment_rematch, 119);
        sparseIntArray.put(R.layout.fragment_reset_password, 120);
        sparseIntArray.put(R.layout.fragment_select_icon, 121);
        sparseIntArray.put(R.layout.fragment_setting_profile, 122);
        sparseIntArray.put(R.layout.fragment_settings_apps, 123);
        sparseIntArray.put(R.layout.fragment_settings_main, 124);
        sparseIntArray.put(R.layout.fragment_sign_up, 125);
        sparseIntArray.put(R.layout.fragment_subscription_bluetooth, 126);
        sparseIntArray.put(R.layout.fragment_subscription_pay_web, 127);
        sparseIntArray.put(R.layout.fragment_trend_chart, 128);
        sparseIntArray.put(R.layout.fragment_user_subscription, 129);
        sparseIntArray.put(R.layout.fragment_verify_email, 130);
        sparseIntArray.put(R.layout.fragment_workout_settings, 131);
        sparseIntArray.put(R.layout.popup_item_layout, 132);
        sparseIntArray.put(R.layout.shared_process_bar, 133);
        sparseIntArray.put(R.layout.view_display_dashboard_item, 134);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/activity_main_0".equals(tag)) {
                    return new ActivityMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
            case 2:
                if ("layout/adapter_category_item_0".equals(tag)) {
                    return new AdapterCategoryItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_category_item is invalid. Received: " + tag);
            case 3:
                if ("layout/adapter_classes_end_0".equals(tag)) {
                    return new AdapterClassesEndBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_classes_end is invalid. Received: " + tag);
            case 4:
                if ("layout/adapter_classes_quick_picks_0".equals(tag)) {
                    return new AdapterClassesQuickPicksBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_classes_quick_picks is invalid. Received: " + tag);
            case 5:
                if ("layout/adapter_classes_results_0".equals(tag)) {
                    return new AdapterClassesResultsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_classes_results is invalid. Received: " + tag);
            case 6:
                if ("layout/adapter_classes_sessions_0".equals(tag)) {
                    return new AdapterClassesSessionsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_classes_sessions is invalid. Received: " + tag);
            case 7:
                if ("layout/adapter_club_avatar_item_0".equals(tag)) {
                    return new AdapterClubAvatarItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_avatar_item is invalid. Received: " + tag);
            case 8:
                if ("layout/adapter_club_edit_privacy_item_0".equals(tag)) {
                    return new AdapterClubEditPrivacyItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_edit_privacy_item is invalid. Received: " + tag);
            case 9:
                if ("layout/adapter_club_edit_score_item_0".equals(tag)) {
                    return new AdapterClubEditScoreItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_edit_score_item is invalid. Received: " + tag);
            case 10:
                if ("layout/adapter_club_list_item_0".equals(tag)) {
                    return new AdapterClubListItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_list_item is invalid. Received: " + tag);
            case 11:
                if ("layout/adapter_club_member_score_item_0".equals(tag)) {
                    return new AdapterClubMemberScoreItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_member_score_item is invalid. Received: " + tag);
            case 12:
                if ("layout/adapter_club_ongiong_item_0".equals(tag)) {
                    return new AdapterClubOngiongItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_ongiong_item is invalid. Received: " + tag);
            case 13:
                if ("layout/adapter_club_scoreboard_item_0".equals(tag)) {
                    return new AdapterClubScoreboardItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_scoreboard_item is invalid. Received: " + tag);
            case 14:
                if ("layout/adapter_club_search_item_0".equals(tag)) {
                    return new AdapterClubSearchItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_club_search_item is invalid. Received: " + tag);
            case 15:
                if ("layout/adapter_collections_item_0".equals(tag)) {
                    return new AdapterCollectionsItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_collections_item is invalid. Received: " + tag);
            case 16:
                if ("layout/adapter_connect_device_item_0".equals(tag)) {
                    return new AdapterConnectDeviceItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_connect_device_item is invalid. Received: " + tag);
            case 17:
                if ("layout/adapter_connect_edit_program_item_0".equals(tag)) {
                    return new AdapterConnectEditProgramItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_connect_edit_program_item is invalid. Received: " + tag);
            case 18:
                if ("layout/adapter_connect_hrm_item_0".equals(tag)) {
                    return new AdapterConnectHrmItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_connect_hrm_item is invalid. Received: " + tag);
            case 19:
                if ("layout/adapter_connect_page_category_item_0".equals(tag)) {
                    return new AdapterConnectPageCategoryItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_connect_page_category_item is invalid. Received: " + tag);
            case 20:
                if ("layout/adapter_connect_page_item_0".equals(tag)) {
                    return new AdapterConnectPageItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_connect_page_item is invalid. Received: " + tag);
            case 21:
                if ("layout/adapter_display_dashboard_item_0".equals(tag)) {
                    return new AdapterDisplayDashboardItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_display_dashboard_item is invalid. Received: " + tag);
            case 22:
                if ("layout/adapter_display_stats_select_item_0".equals(tag)) {
                    return new AdapterDisplayStatsSelectItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_display_stats_select_item is invalid. Received: " + tag);
            case 23:
                if ("layout/adapter_favorites_item_0".equals(tag)) {
                    return new AdapterFavoritesItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_favorites_item is invalid. Received: " + tag);
            case 24:
                if ("layout/adapter_followed_collection_item_0".equals(tag)) {
                    return new AdapterFollowedCollectionItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_followed_collection_item is invalid. Received: " + tag);
            case 25:
                if ("layout/adapter_goals_item_0".equals(tag)) {
                    return new AdapterGoalsItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_goals_item is invalid. Received: " + tag);
            case 26:
                if ("layout/adapter_goals_main_item_0".equals(tag)) {
                    return new AdapterGoalsMainItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_goals_main_item is invalid. Received: " + tag);
            case 27:
                if ("layout/adapter_goals_top_item_0".equals(tag)) {
                    return new AdapterGoalsTopItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_goals_top_item is invalid. Received: " + tag);
            case 28:
                if ("layout/adapter_history_activitytype_item_0".equals(tag)) {
                    return new AdapterHistoryActivitytypeItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_history_activitytype_item is invalid. Received: " + tag);
            case 29:
                if ("layout/adapter_history_header_item_0".equals(tag)) {
                    return new AdapterHistoryHeaderItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_history_header_item is invalid. Received: " + tag);
            case 30:
                if ("layout/adapter_history_item_0".equals(tag)) {
                    return new AdapterHistoryItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_history_item is invalid. Received: " + tag);
            case 31:
                if ("layout/adapter_history_workout_item_0".equals(tag)) {
                    return new AdapterHistoryWorkoutItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_history_workout_item is invalid. Received: " + tag);
            case 32:
                if ("layout/adapter_home_connect_item_0".equals(tag)) {
                    return new AdapterHomeConnectItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_home_connect_item is invalid. Received: " + tag);
            case 33:
                if ("layout/adapter_inbox_item_0".equals(tag)) {
                    return new AdapterInboxItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_inbox_item is invalid. Received: " + tag);
            case 34:
                if ("layout/adapter_ios_alert_action_sheet_dialog_0".equals(tag)) {
                    return new AdapterIosAlertActionSheetDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_ios_alert_action_sheet_dialog is invalid. Received: " + tag);
            case 35:
                if ("layout/adapter_language_settings_0".equals(tag)) {
                    return new AdapterLanguageSettingsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_language_settings is invalid. Received: " + tag);
            case 36:
                if ("layout/adapter_my_devices_item_0".equals(tag)) {
                    return new AdapterMyDevicesItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_my_devices_item is invalid. Received: " + tag);
            case 37:
                if ("layout/adapter_my_favorites_item_0".equals(tag)) {
                    return new AdapterMyFavoritesItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_my_favorites_item is invalid. Received: " + tag);
            case 38:
                if ("layout/adapter_pay_wall_item_0".equals(tag)) {
                    return new AdapterPayWallItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_pay_wall_item is invalid. Received: " + tag);
            case 39:
                if ("layout/adapter_personal_best_year_item_0".equals(tag)) {
                    return new AdapterPersonalBestYearItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_personal_best_year_item is invalid. Received: " + tag);
            case 40:
                if ("layout/adapter_pick_for_you_item_0".equals(tag)) {
                    return new AdapterPickForYouItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_pick_for_you_item is invalid. Received: " + tag);
            case 41:
                if ("layout/adapter_quick_pick_item_0".equals(tag)) {
                    return new AdapterQuickPickItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_quick_pick_item is invalid. Received: " + tag);
            case 42:
                if ("layout/adapter_running_trends_item_0".equals(tag)) {
                    return new AdapterRunningTrendsItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_running_trends_item is invalid. Received: " + tag);
            case 43:
                if ("layout/adapter_select_duration_item_0".equals(tag)) {
                    return new AdapterSelectDurationItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_select_duration_item is invalid. Received: " + tag);
            case 44:
                if ("layout/adapter_select_focus_item_0".equals(tag)) {
                    return new AdapterSelectFocusItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_select_focus_item is invalid. Received: " + tag);
            case 45:
                if ("layout/adapter_select_icon_item_0".equals(tag)) {
                    return new AdapterSelectIconItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_select_icon_item is invalid. Received: " + tag);
            case 46:
                if ("layout/adapter_select_instructor_item_0".equals(tag)) {
                    return new AdapterSelectInstructorItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for adapter_select_instructor_item is invalid. Received: " + tag);
            case 47:
                if ("layout/bottom_sheet_display_mode_adjust_0".equals(tag)) {
                    return new BottomSheetDisplayModeAdjustBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bottom_sheet_display_mode_adjust is invalid. Received: " + tag);
            case 48:
                if ("layout/bottom_sheet_goals_detail_0".equals(tag)) {
                    return new BottomSheetGoalsDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bottom_sheet_goals_detail is invalid. Received: " + tag);
            case 49:
                if ("layout/bottom_sheet_goals_edit_target_0".equals(tag)) {
                    return new BottomSheetGoalsEditTargetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bottom_sheet_goals_edit_target is invalid. Received: " + tag);
            case 50:
                if ("layout/custom_bottom_dialog_0".equals(tag)) {
                    return new CustomBottomDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_bottom_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/custom_dashboard_chart_0".equals(tag)) {
                    return new CustomDashboardChartBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_dashboard_chart is invalid. Received: " + tag);
            case 52:
                if ("layout/custom_display_stats_select_0".equals(tag)) {
                    return new CustomDisplayStatsSelectBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_display_stats_select is invalid. Received: " + tag);
            case 53:
                if ("layout/custom_history_workout_chart_item_0".equals(tag)) {
                    return new CustomHistoryWorkoutChartItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_history_workout_chart_item is invalid. Received: " + tag);
            case 54:
                if ("layout/custom_history_workout_item_0".equals(tag)) {
                    return new CustomHistoryWorkoutItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_history_workout_item is invalid. Received: " + tag);
            case 55:
                if ("layout/custom_pairing_dialog_0".equals(tag)) {
                    return new CustomPairingDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_pairing_dialog is invalid. Received: " + tag);
            case 56:
                if ("layout/custom_program_sliderview_0".equals(tag)) {
                    return new CustomProgramSliderviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_program_sliderview is invalid. Received: " + tag);
            case 57:
                if ("layout/custom_section_item_view_0".equals(tag)) {
                    return new CustomSectionItemViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_section_item_view is invalid. Received: " + tag);
            case 58:
                if ("layout/custom_select_activity_0".equals(tag)) {
                    return new CustomSelectActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_activity is invalid. Received: " + tag);
            case 59:
                if ("layout/custom_select_ble_connect_0".equals(tag)) {
                    return new CustomSelectBleConnectBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_ble_connect is invalid. Received: " + tag);
            case 60:
                if ("layout/custom_select_duration_0".equals(tag)) {
                    return new CustomSelectDurationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_duration is invalid. Received: " + tag);
            case 61:
                if ("layout/custom_select_fitness_level_0".equals(tag)) {
                    return new CustomSelectFitnessLevelBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_fitness_level is invalid. Received: " + tag);
            case 62:
                if ("layout/custom_select_focus_0".equals(tag)) {
                    return new CustomSelectFocusBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_focus is invalid. Received: " + tag);
            case 63:
                if ("layout/custom_select_instructors_0".equals(tag)) {
                    return new CustomSelectInstructorsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_instructors is invalid. Received: " + tag);
            case 64:
                if ("layout/custom_select_language_0".equals(tag)) {
                    return new CustomSelectLanguageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_select_language is invalid. Received: " + tag);
            case 65:
                if ("layout/custom_tab_0".equals(tag)) {
                    return new CustomTabBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_tab is invalid. Received: " + tag);
            case 66:
                if ("layout/dialog_club_filter_duration_bottom_sheet_0".equals(tag)) {
                    return new DialogClubFilterDurationBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_club_filter_duration_bottom_sheet is invalid. Received: " + tag);
            case 67:
                if ("layout/dialog_club_filter_equipment_bottom_sheet_0".equals(tag)) {
                    return new DialogClubFilterEquipmentBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_club_filter_equipment_bottom_sheet is invalid. Received: " + tag);
            case 68:
                if ("layout/dialog_club_filter_format_bottom_sheet_0".equals(tag)) {
                    return new DialogClubFilterFormatBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_club_filter_format_bottom_sheet is invalid. Received: " + tag);
            case 69:
                if ("layout/dialog_club_filter_target_bottom_sheet_0".equals(tag)) {
                    return new DialogClubFilterTargetBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_club_filter_target_bottom_sheet is invalid. Received: " + tag);
            case 70:
                if ("layout/dialog_club_select_event_type_bottom_sheet_0".equals(tag)) {
                    return new DialogClubSelectEventTypeBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_club_select_event_type_bottom_sheet is invalid. Received: " + tag);
            case 71:
                if ("layout/dialog_ios_alert_action_sheet_0".equals(tag)) {
                    return new DialogIosAlertActionSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_ios_alert_action_sheet is invalid. Received: " + tag);
            case 72:
                if ("layout/dialog_ios_one_picker_bottom_sheet_0".equals(tag)) {
                    return new DialogIosOnePickerBottomSheetBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_ios_one_picker_bottom_sheet is invalid. Received: " + tag);
            case 73:
                if ("layout/dialog_subscription_via_sn_camera_0".equals(tag)) {
                    return new DialogSubscriptionViaSnCameraBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_subscription_via_sn_camera is invalid. Received: " + tag);
            case 74:
                if ("layout/fragment_activity_main_0".equals(tag)) {
                    return new FragmentActivityMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_activity_main is invalid. Received: " + tag);
            case 75:
                if ("layout/fragment_banner_0".equals(tag)) {
                    return new FragmentBannerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_banner is invalid. Received: " + tag);
            case 76:
                if ("layout/fragment_cancel_subscription_0".equals(tag)) {
                    return new FragmentCancelSubscriptionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cancel_subscription is invalid. Received: " + tag);
            case 77:
                if ("layout/fragment_choose_0".equals(tag)) {
                    return new FragmentChooseBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_choose is invalid. Received: " + tag);
            case 78:
                if ("layout/fragment_classes_main_0".equals(tag)) {
                    return new FragmentClassesMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_classes_main is invalid. Received: " + tag);
            case 79:
                if ("layout/fragment_club_all_events_0".equals(tag)) {
                    return new FragmentClubAllEventsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_all_events is invalid. Received: " + tag);
            case 80:
                if ("layout/fragment_club_edit_form_0".equals(tag)) {
                    return new FragmentClubEditFormBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_edit_form is invalid. Received: " + tag);
            case 81:
                if ("layout/fragment_club_event_detail_0".equals(tag)) {
                    return new FragmentClubEventDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_event_detail is invalid. Received: " + tag);
            case 82:
                if ("layout/fragment_club_join_event_0".equals(tag)) {
                    return new FragmentClubJoinEventBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_join_event is invalid. Received: " + tag);
            case 83:
                if ("layout/fragment_club_main_0".equals(tag)) {
                    return new FragmentClubMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_main is invalid. Received: " + tag);
            case 84:
                if ("layout/fragment_club_member_score_0".equals(tag)) {
                    return new FragmentClubMemberScoreBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_member_score is invalid. Received: " + tag);
            case 85:
                if ("layout/fragment_club_my_events_0".equals(tag)) {
                    return new FragmentClubMyEventsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_my_events is invalid. Received: " + tag);
            case 86:
                if ("layout-land/fragment_club_race_0".equals(tag)) {
                    return new FragmentClubRaceBindingLandImpl(component, view);
                }
                if ("layout/fragment_club_race_0".equals(tag)) {
                    return new FragmentClubRaceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_race is invalid. Received: " + tag);
            case 87:
                if ("layout/fragment_club_scoreboard_list_0".equals(tag)) {
                    return new FragmentClubScoreboardListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_scoreboard_list is invalid. Received: " + tag);
            case 88:
                if ("layout/fragment_club_search_event_0".equals(tag)) {
                    return new FragmentClubSearchEventBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_club_search_event is invalid. Received: " + tag);
            case 89:
                if ("layout/fragment_connect_device_0".equals(tag)) {
                    return new FragmentConnectDeviceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_connect_device is invalid. Received: " + tag);
            case 90:
                if ("layout/fragment_connect_edit_program_0".equals(tag)) {
                    return new FragmentConnectEditProgramBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_connect_edit_program is invalid. Received: " + tag);
            case 91:
                if ("layout/fragment_connect_program_0".equals(tag)) {
                    return new FragmentConnectProgramBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_connect_program is invalid. Received: " + tag);
            case 92:
                if ("layout/fragment_connected_page_0".equals(tag)) {
                    return new FragmentConnectedPageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_connected_page is invalid. Received: " + tag);
            case 93:
                if ("layout/fragment_display_dashboard_0".equals(tag)) {
                    return new FragmentDisplayDashboardBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_display_dashboard is invalid. Received: " + tag);
            case 94:
                if ("layout/fragment_display_dashboard_p1_0".equals(tag)) {
                    return new FragmentDisplayDashboardP1BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_display_dashboard_p1 is invalid. Received: " + tag);
            case 95:
                if ("layout/fragment_display_dashboard_p2_0".equals(tag)) {
                    return new FragmentDisplayDashboardP2BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_display_dashboard_p2 is invalid. Received: " + tag);
            case 96:
                if ("layout/fragment_display_dashboard_p3_0".equals(tag)) {
                    return new FragmentDisplayDashboardP3BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_display_dashboard_p3 is invalid. Received: " + tag);
            case 97:
                if ("layout/fragment_display_settings_0".equals(tag)) {
                    return new FragmentDisplaySettingsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_display_settings is invalid. Received: " + tag);
            case 98:
                if ("layout/fragment_edit_profile_0".equals(tag)) {
                    return new FragmentEditProfileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_edit_profile is invalid. Received: " + tag);
            case 99:
                if ("layout/fragment_garmin_connect_0".equals(tag)) {
                    return new FragmentGarminConnectBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_garmin_connect is invalid. Received: " + tag);
            case 100:
                if ("layout/fragment_goals_create_0".equals(tag)) {
                    return new FragmentGoalsCreateBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_goals_create is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 101:
                if ("layout/fragment_goals_main_0".equals(tag)) {
                    return new FragmentGoalsMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_goals_main is invalid. Received: " + tag);
            case 102:
                if ("layout/fragment_heart_rate_monitor_0".equals(tag)) {
                    return new FragmentHeartRateMonitorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_heart_rate_monitor is invalid. Received: " + tag);
            case 103:
                if ("layout/fragment_history_0".equals(tag)) {
                    return new FragmentHistoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_history is invalid. Received: " + tag);
            case 104:
                if ("layout/fragment_history_workout_0".equals(tag)) {
                    return new FragmentHistoryWorkoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_history_workout is invalid. Received: " + tag);
            case 105:
                if ("layout/fragment_home_main_0".equals(tag)) {
                    return new FragmentHomeMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home_main is invalid. Received: " + tag);
            case 106:
                if ("layout/fragment_how_to_link_profile_0".equals(tag)) {
                    return new FragmentHowToLinkProfileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_how_to_link_profile is invalid. Received: " + tag);
            case 107:
                if ("layout/fragment_inbox_0".equals(tag)) {
                    return new FragmentInboxBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_inbox is invalid. Received: " + tag);
            case 108:
                if ("layout/fragment_inbox_msg_0".equals(tag)) {
                    return new FragmentInboxMsgBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_inbox_msg is invalid. Received: " + tag);
            case 109:
                if ("layout/fragment_login_0".equals(tag)) {
                    return new FragmentLoginBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
            case 110:
                if ("layout/fragment_logo_0".equals(tag)) {
                    return new FragmentLogoBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_logo is invalid. Received: " + tag);
            case 111:
                if ("layout/fragment_my_devices_0".equals(tag)) {
                    return new FragmentMyDevicesBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_my_devices is invalid. Received: " + tag);
            case 112:
                if ("layout/fragment_my_favorites_0".equals(tag)) {
                    return new FragmentMyFavoritesBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_my_favorites is invalid. Received: " + tag);
            case 113:
                if ("layout/fragment_onboarding_0".equals(tag)) {
                    return new FragmentOnboardingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_onboarding is invalid. Received: " + tag);
            case 114:
                if ("layout/fragment_pair_device_0".equals(tag)) {
                    return new FragmentPairDeviceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_pair_device is invalid. Received: " + tag);
            case 115:
                if ("layout/fragment_pair_device_page_item_0".equals(tag)) {
                    return new FragmentPairDevicePageItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_pair_device_page_item is invalid. Received: " + tag);
            case 116:
                if ("layout/fragment_paywall_0".equals(tag)) {
                    return new FragmentPaywallBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_paywall is invalid. Received: " + tag);
            case 117:
                if ("layout/fragment_personal_best_0".equals(tag)) {
                    return new FragmentPersonalBestBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_personal_best is invalid. Received: " + tag);
            case 118:
                if ("layout/fragment_qrcode_0".equals(tag)) {
                    return new FragmentQrcodeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_qrcode is invalid. Received: " + tag);
            case 119:
                if ("layout/fragment_rematch_0".equals(tag)) {
                    return new FragmentRematchBindingImpl(component, view);
                }
                if ("layout-land/fragment_rematch_0".equals(tag)) {
                    return new FragmentRematchBindingLandImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_rematch is invalid. Received: " + tag);
            case 120:
                if ("layout/fragment_reset_password_0".equals(tag)) {
                    return new FragmentResetPasswordBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_reset_password is invalid. Received: " + tag);
            case 121:
                if ("layout/fragment_select_icon_0".equals(tag)) {
                    return new FragmentSelectIconBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_select_icon is invalid. Received: " + tag);
            case 122:
                if ("layout/fragment_setting_profile_0".equals(tag)) {
                    return new FragmentSettingProfileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_setting_profile is invalid. Received: " + tag);
            case 123:
                if ("layout/fragment_settings_apps_0".equals(tag)) {
                    return new FragmentSettingsAppsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_settings_apps is invalid. Received: " + tag);
            case 124:
                if ("layout/fragment_settings_main_0".equals(tag)) {
                    return new FragmentSettingsMainBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_settings_main is invalid. Received: " + tag);
            case 125:
                if ("layout/fragment_sign_up_0".equals(tag)) {
                    return new FragmentSignUpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
            case 126:
                if ("layout/fragment_subscription_bluetooth_0".equals(tag)) {
                    return new FragmentSubscriptionBluetoothBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_subscription_bluetooth is invalid. Received: " + tag);
            case 127:
                if ("layout/fragment_subscription_pay_web_0".equals(tag)) {
                    return new FragmentSubscriptionPayWebBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_subscription_pay_web is invalid. Received: " + tag);
            case 128:
                if ("layout/fragment_trend_chart_0".equals(tag)) {
                    return new FragmentTrendChartBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_trend_chart is invalid. Received: " + tag);
            case 129:
                if ("layout/fragment_user_subscription_0".equals(tag)) {
                    return new FragmentUserSubscriptionBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_user_subscription is invalid. Received: " + tag);
            case 130:
                if ("layout/fragment_verify_email_0".equals(tag)) {
                    return new FragmentVerifyEmailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_verify_email is invalid. Received: " + tag);
            case 131:
                if ("layout/fragment_workout_settings_0".equals(tag)) {
                    return new FragmentWorkoutSettingsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_workout_settings is invalid. Received: " + tag);
            case 132:
                if ("layout/popup_item_layout_0".equals(tag)) {
                    return new PopupItemLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for popup_item_layout is invalid. Received: " + tag);
            case 133:
                if ("layout/shared_process_bar_0".equals(tag)) {
                    return new SharedProcessBarBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for shared_process_bar is invalid. Received: " + tag);
            case 134:
                if ("layout/view_display_dashboard_item_0".equals(tag)) {
                    return new ViewDisplayDashboardItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_display_dashboard_item is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (i <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i2 = (i - 1) / 50;
        if (i2 == 0) {
            return internalGetViewDataBinding0(component, view, i, tag);
        }
        if (i2 == 1) {
            return internalGetViewDataBinding1(component, view, i, tag);
        }
        if (i2 != 2) {
            return null;
        }
        return internalGetViewDataBinding2(component, view, i, tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return InnerBrLookup.sKeys.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(136);
            sKeys = map;
            map.put("layout/activity_main_0", Integer.valueOf(R.layout.activity_main));
            map.put("layout/adapter_category_item_0", Integer.valueOf(R.layout.adapter_category_item));
            map.put("layout/adapter_classes_end_0", Integer.valueOf(R.layout.adapter_classes_end));
            map.put("layout/adapter_classes_quick_picks_0", Integer.valueOf(R.layout.adapter_classes_quick_picks));
            map.put("layout/adapter_classes_results_0", Integer.valueOf(R.layout.adapter_classes_results));
            map.put("layout/adapter_classes_sessions_0", Integer.valueOf(R.layout.adapter_classes_sessions));
            map.put("layout/adapter_club_avatar_item_0", Integer.valueOf(R.layout.adapter_club_avatar_item));
            map.put("layout/adapter_club_edit_privacy_item_0", Integer.valueOf(R.layout.adapter_club_edit_privacy_item));
            map.put("layout/adapter_club_edit_score_item_0", Integer.valueOf(R.layout.adapter_club_edit_score_item));
            map.put("layout/adapter_club_list_item_0", Integer.valueOf(R.layout.adapter_club_list_item));
            map.put("layout/adapter_club_member_score_item_0", Integer.valueOf(R.layout.adapter_club_member_score_item));
            map.put("layout/adapter_club_ongiong_item_0", Integer.valueOf(R.layout.adapter_club_ongiong_item));
            map.put("layout/adapter_club_scoreboard_item_0", Integer.valueOf(R.layout.adapter_club_scoreboard_item));
            map.put("layout/adapter_club_search_item_0", Integer.valueOf(R.layout.adapter_club_search_item));
            map.put("layout/adapter_collections_item_0", Integer.valueOf(R.layout.adapter_collections_item));
            map.put("layout/adapter_connect_device_item_0", Integer.valueOf(R.layout.adapter_connect_device_item));
            map.put("layout/adapter_connect_edit_program_item_0", Integer.valueOf(R.layout.adapter_connect_edit_program_item));
            map.put("layout/adapter_connect_hrm_item_0", Integer.valueOf(R.layout.adapter_connect_hrm_item));
            map.put("layout/adapter_connect_page_category_item_0", Integer.valueOf(R.layout.adapter_connect_page_category_item));
            map.put("layout/adapter_connect_page_item_0", Integer.valueOf(R.layout.adapter_connect_page_item));
            map.put("layout/adapter_display_dashboard_item_0", Integer.valueOf(R.layout.adapter_display_dashboard_item));
            map.put("layout/adapter_display_stats_select_item_0", Integer.valueOf(R.layout.adapter_display_stats_select_item));
            map.put("layout/adapter_favorites_item_0", Integer.valueOf(R.layout.adapter_favorites_item));
            map.put("layout/adapter_followed_collection_item_0", Integer.valueOf(R.layout.adapter_followed_collection_item));
            map.put("layout/adapter_goals_item_0", Integer.valueOf(R.layout.adapter_goals_item));
            map.put("layout/adapter_goals_main_item_0", Integer.valueOf(R.layout.adapter_goals_main_item));
            map.put("layout/adapter_goals_top_item_0", Integer.valueOf(R.layout.adapter_goals_top_item));
            map.put("layout/adapter_history_activitytype_item_0", Integer.valueOf(R.layout.adapter_history_activitytype_item));
            map.put("layout/adapter_history_header_item_0", Integer.valueOf(R.layout.adapter_history_header_item));
            map.put("layout/adapter_history_item_0", Integer.valueOf(R.layout.adapter_history_item));
            map.put("layout/adapter_history_workout_item_0", Integer.valueOf(R.layout.adapter_history_workout_item));
            map.put("layout/adapter_home_connect_item_0", Integer.valueOf(R.layout.adapter_home_connect_item));
            map.put("layout/adapter_inbox_item_0", Integer.valueOf(R.layout.adapter_inbox_item));
            map.put("layout/adapter_ios_alert_action_sheet_dialog_0", Integer.valueOf(R.layout.adapter_ios_alert_action_sheet_dialog));
            map.put("layout/adapter_language_settings_0", Integer.valueOf(R.layout.adapter_language_settings));
            map.put("layout/adapter_my_devices_item_0", Integer.valueOf(R.layout.adapter_my_devices_item));
            map.put("layout/adapter_my_favorites_item_0", Integer.valueOf(R.layout.adapter_my_favorites_item));
            map.put("layout/adapter_pay_wall_item_0", Integer.valueOf(R.layout.adapter_pay_wall_item));
            map.put("layout/adapter_personal_best_year_item_0", Integer.valueOf(R.layout.adapter_personal_best_year_item));
            map.put("layout/adapter_pick_for_you_item_0", Integer.valueOf(R.layout.adapter_pick_for_you_item));
            map.put("layout/adapter_quick_pick_item_0", Integer.valueOf(R.layout.adapter_quick_pick_item));
            map.put("layout/adapter_running_trends_item_0", Integer.valueOf(R.layout.adapter_running_trends_item));
            map.put("layout/adapter_select_duration_item_0", Integer.valueOf(R.layout.adapter_select_duration_item));
            map.put("layout/adapter_select_focus_item_0", Integer.valueOf(R.layout.adapter_select_focus_item));
            map.put("layout/adapter_select_icon_item_0", Integer.valueOf(R.layout.adapter_select_icon_item));
            map.put("layout/adapter_select_instructor_item_0", Integer.valueOf(R.layout.adapter_select_instructor_item));
            map.put("layout/bottom_sheet_display_mode_adjust_0", Integer.valueOf(R.layout.bottom_sheet_display_mode_adjust));
            map.put("layout/bottom_sheet_goals_detail_0", Integer.valueOf(R.layout.bottom_sheet_goals_detail));
            map.put("layout/bottom_sheet_goals_edit_target_0", Integer.valueOf(R.layout.bottom_sheet_goals_edit_target));
            map.put("layout/custom_bottom_dialog_0", Integer.valueOf(R.layout.custom_bottom_dialog));
            map.put("layout/custom_dashboard_chart_0", Integer.valueOf(R.layout.custom_dashboard_chart));
            map.put("layout/custom_display_stats_select_0", Integer.valueOf(R.layout.custom_display_stats_select));
            map.put("layout/custom_history_workout_chart_item_0", Integer.valueOf(R.layout.custom_history_workout_chart_item));
            map.put("layout/custom_history_workout_item_0", Integer.valueOf(R.layout.custom_history_workout_item));
            map.put("layout/custom_pairing_dialog_0", Integer.valueOf(R.layout.custom_pairing_dialog));
            map.put("layout/custom_program_sliderview_0", Integer.valueOf(R.layout.custom_program_sliderview));
            map.put("layout/custom_section_item_view_0", Integer.valueOf(R.layout.custom_section_item_view));
            map.put("layout/custom_select_activity_0", Integer.valueOf(R.layout.custom_select_activity));
            map.put("layout/custom_select_ble_connect_0", Integer.valueOf(R.layout.custom_select_ble_connect));
            map.put("layout/custom_select_duration_0", Integer.valueOf(R.layout.custom_select_duration));
            map.put("layout/custom_select_fitness_level_0", Integer.valueOf(R.layout.custom_select_fitness_level));
            map.put("layout/custom_select_focus_0", Integer.valueOf(R.layout.custom_select_focus));
            map.put("layout/custom_select_instructors_0", Integer.valueOf(R.layout.custom_select_instructors));
            map.put("layout/custom_select_language_0", Integer.valueOf(R.layout.custom_select_language));
            map.put("layout/custom_tab_0", Integer.valueOf(R.layout.custom_tab));
            map.put("layout/dialog_club_filter_duration_bottom_sheet_0", Integer.valueOf(R.layout.dialog_club_filter_duration_bottom_sheet));
            map.put("layout/dialog_club_filter_equipment_bottom_sheet_0", Integer.valueOf(R.layout.dialog_club_filter_equipment_bottom_sheet));
            map.put("layout/dialog_club_filter_format_bottom_sheet_0", Integer.valueOf(R.layout.dialog_club_filter_format_bottom_sheet));
            map.put("layout/dialog_club_filter_target_bottom_sheet_0", Integer.valueOf(R.layout.dialog_club_filter_target_bottom_sheet));
            map.put("layout/dialog_club_select_event_type_bottom_sheet_0", Integer.valueOf(R.layout.dialog_club_select_event_type_bottom_sheet));
            map.put("layout/dialog_ios_alert_action_sheet_0", Integer.valueOf(R.layout.dialog_ios_alert_action_sheet));
            map.put("layout/dialog_ios_one_picker_bottom_sheet_0", Integer.valueOf(R.layout.dialog_ios_one_picker_bottom_sheet));
            map.put("layout/dialog_subscription_via_sn_camera_0", Integer.valueOf(R.layout.dialog_subscription_via_sn_camera));
            map.put("layout/fragment_activity_main_0", Integer.valueOf(R.layout.fragment_activity_main));
            map.put("layout/fragment_banner_0", Integer.valueOf(R.layout.fragment_banner));
            map.put("layout/fragment_cancel_subscription_0", Integer.valueOf(R.layout.fragment_cancel_subscription));
            map.put("layout/fragment_choose_0", Integer.valueOf(R.layout.fragment_choose));
            map.put("layout/fragment_classes_main_0", Integer.valueOf(R.layout.fragment_classes_main));
            map.put("layout/fragment_club_all_events_0", Integer.valueOf(R.layout.fragment_club_all_events));
            map.put("layout/fragment_club_edit_form_0", Integer.valueOf(R.layout.fragment_club_edit_form));
            map.put("layout/fragment_club_event_detail_0", Integer.valueOf(R.layout.fragment_club_event_detail));
            map.put("layout/fragment_club_join_event_0", Integer.valueOf(R.layout.fragment_club_join_event));
            map.put("layout/fragment_club_main_0", Integer.valueOf(R.layout.fragment_club_main));
            map.put("layout/fragment_club_member_score_0", Integer.valueOf(R.layout.fragment_club_member_score));
            map.put("layout/fragment_club_my_events_0", Integer.valueOf(R.layout.fragment_club_my_events));
            map.put("layout-land/fragment_club_race_0", Integer.valueOf(R.layout.fragment_club_race));
            map.put("layout/fragment_club_race_0", Integer.valueOf(R.layout.fragment_club_race));
            map.put("layout/fragment_club_scoreboard_list_0", Integer.valueOf(R.layout.fragment_club_scoreboard_list));
            map.put("layout/fragment_club_search_event_0", Integer.valueOf(R.layout.fragment_club_search_event));
            map.put("layout/fragment_connect_device_0", Integer.valueOf(R.layout.fragment_connect_device));
            map.put("layout/fragment_connect_edit_program_0", Integer.valueOf(R.layout.fragment_connect_edit_program));
            map.put("layout/fragment_connect_program_0", Integer.valueOf(R.layout.fragment_connect_program));
            map.put("layout/fragment_connected_page_0", Integer.valueOf(R.layout.fragment_connected_page));
            map.put("layout/fragment_display_dashboard_0", Integer.valueOf(R.layout.fragment_display_dashboard));
            map.put("layout/fragment_display_dashboard_p1_0", Integer.valueOf(R.layout.fragment_display_dashboard_p1));
            map.put("layout/fragment_display_dashboard_p2_0", Integer.valueOf(R.layout.fragment_display_dashboard_p2));
            map.put("layout/fragment_display_dashboard_p3_0", Integer.valueOf(R.layout.fragment_display_dashboard_p3));
            map.put("layout/fragment_display_settings_0", Integer.valueOf(R.layout.fragment_display_settings));
            map.put("layout/fragment_edit_profile_0", Integer.valueOf(R.layout.fragment_edit_profile));
            map.put("layout/fragment_garmin_connect_0", Integer.valueOf(R.layout.fragment_garmin_connect));
            map.put("layout/fragment_goals_create_0", Integer.valueOf(R.layout.fragment_goals_create));
            map.put("layout/fragment_goals_main_0", Integer.valueOf(R.layout.fragment_goals_main));
            map.put("layout/fragment_heart_rate_monitor_0", Integer.valueOf(R.layout.fragment_heart_rate_monitor));
            map.put("layout/fragment_history_0", Integer.valueOf(R.layout.fragment_history));
            map.put("layout/fragment_history_workout_0", Integer.valueOf(R.layout.fragment_history_workout));
            map.put("layout/fragment_home_main_0", Integer.valueOf(R.layout.fragment_home_main));
            map.put("layout/fragment_how_to_link_profile_0", Integer.valueOf(R.layout.fragment_how_to_link_profile));
            map.put("layout/fragment_inbox_0", Integer.valueOf(R.layout.fragment_inbox));
            map.put("layout/fragment_inbox_msg_0", Integer.valueOf(R.layout.fragment_inbox_msg));
            map.put("layout/fragment_login_0", Integer.valueOf(R.layout.fragment_login));
            map.put("layout/fragment_logo_0", Integer.valueOf(R.layout.fragment_logo));
            map.put("layout/fragment_my_devices_0", Integer.valueOf(R.layout.fragment_my_devices));
            map.put("layout/fragment_my_favorites_0", Integer.valueOf(R.layout.fragment_my_favorites));
            map.put("layout/fragment_onboarding_0", Integer.valueOf(R.layout.fragment_onboarding));
            map.put("layout/fragment_pair_device_0", Integer.valueOf(R.layout.fragment_pair_device));
            map.put("layout/fragment_pair_device_page_item_0", Integer.valueOf(R.layout.fragment_pair_device_page_item));
            map.put("layout/fragment_paywall_0", Integer.valueOf(R.layout.fragment_paywall));
            map.put("layout/fragment_personal_best_0", Integer.valueOf(R.layout.fragment_personal_best));
            map.put("layout/fragment_qrcode_0", Integer.valueOf(R.layout.fragment_qrcode));
            map.put("layout/fragment_rematch_0", Integer.valueOf(R.layout.fragment_rematch));
            map.put("layout-land/fragment_rematch_0", Integer.valueOf(R.layout.fragment_rematch));
            map.put("layout/fragment_reset_password_0", Integer.valueOf(R.layout.fragment_reset_password));
            map.put("layout/fragment_select_icon_0", Integer.valueOf(R.layout.fragment_select_icon));
            map.put("layout/fragment_setting_profile_0", Integer.valueOf(R.layout.fragment_setting_profile));
            map.put("layout/fragment_settings_apps_0", Integer.valueOf(R.layout.fragment_settings_apps));
            map.put("layout/fragment_settings_main_0", Integer.valueOf(R.layout.fragment_settings_main));
            map.put("layout/fragment_sign_up_0", Integer.valueOf(R.layout.fragment_sign_up));
            map.put("layout/fragment_subscription_bluetooth_0", Integer.valueOf(R.layout.fragment_subscription_bluetooth));
            map.put("layout/fragment_subscription_pay_web_0", Integer.valueOf(R.layout.fragment_subscription_pay_web));
            map.put("layout/fragment_trend_chart_0", Integer.valueOf(R.layout.fragment_trend_chart));
            map.put("layout/fragment_user_subscription_0", Integer.valueOf(R.layout.fragment_user_subscription));
            map.put("layout/fragment_verify_email_0", Integer.valueOf(R.layout.fragment_verify_email));
            map.put("layout/fragment_workout_settings_0", Integer.valueOf(R.layout.fragment_workout_settings));
            map.put("layout/popup_item_layout_0", Integer.valueOf(R.layout.popup_item_layout));
            map.put("layout/shared_process_bar_0", Integer.valueOf(R.layout.shared_process_bar));
            map.put("layout/view_display_dashboard_item_0", Integer.valueOf(R.layout.view_display_dashboard_item));
        }
    }
}
