package com.google.zxing.oned;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
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
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, 379}, "FR");
            add(new int[]{380}, "BG");
            add(new int[]{383}, "SI");
            add(new int[]{385}, "HR");
            add(new int[]{387}, "BA");
            add(new int[]{400, 440}, "DE");
            add(new int[]{450, 459}, "JP");
            add(new int[]{460, 469}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{474}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{476}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{479}, "LK");
            add(new int[]{480}, "PH");
            add(new int[]{481}, "BY");
            add(new int[]{482}, "UA");
            add(new int[]{484}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{WinError.ERROR_INVALID_ADDRESS}, "KZ");
            add(new int[]{489}, "HK");
            add(new int[]{490, 499}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{520}, "GR");
            add(new int[]{528}, ExpandedProductParsedResult.POUND);
            add(new int[]{529}, "CY");
            add(new int[]{531}, "MK");
            add(new int[]{WinError.ERROR_PIPE_CONNECTED}, "MT");
            add(new int[]{WinError.ERROR_WX86_WARNING}, "IE");
            add(new int[]{WinError.ERROR_WX86_ERROR, 549}, "BE/LU");
            add(new int[]{WinError.ERROR_NO_GUID_TRANSLATION}, "PT");
            add(new int[]{WinError.ERROR_SYNCHRONIZATION_REQUIRED}, "IS");
            add(new int[]{WinError.ERROR_NET_OPEN_FAILED, WinError.ERROR_ILLEGAL_FLOAT_CONTEXT}, "DK");
            add(new int[]{WinError.ERROR_DEBUG_ATTACH_FAILED}, "PL");
            add(new int[]{WinError.ERROR_DRIVER_CANCEL_TIMEOUT}, "RO");
            add(new int[]{WinError.ERROR_STACK_OVERFLOW_READ}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{608}, "BH");
            add(new int[]{609}, "MU");
            add(new int[]{611}, "MA");
            add(new int[]{WinError.ERROR_REGISTRY_QUOTA_LIMIT}, "DZ");
            add(new int[]{WinError.ERROR_PWD_TOO_RECENT}, "KE");
            add(new int[]{WinError.ERROR_UNSUPPORTED_COMPRESSION}, "CI");
            add(new int[]{WinError.ERROR_INVALID_HW_PROFILE}, "TN");
            add(new int[]{WinError.ERROR_QUOTA_LIST_INCONSISTENT}, "SY");
            add(new int[]{WinError.ERROR_EVALUATION_EXPIRATION}, "EG");
            add(new int[]{WinError.ERROR_DLL_INIT_FAILED_LOGOFF}, "LY");
            add(new int[]{WinError.ERROR_VALIDATE_CONTINUE}, "JO");
            add(new int[]{WinError.ERROR_NO_MORE_MATCHES}, "IR");
            add(new int[]{WinError.ERROR_RANGE_LIST_CONFLICT}, "KW");
            add(new int[]{WinError.ERROR_SERVER_SID_MISMATCH}, "SA");
            add(new int[]{WinError.ERROR_CANT_ENABLE_DENY_ONLY}, "AE");
            add(new int[]{WinError.ERROR_MULTIPLE_FAULT_VIOLATION, WinError.ERROR_MOUNT_POINT_NOT_RESOLVED}, "FI");
            add(new int[]{WinError.ERROR_DBG_UNABLE_TO_PROVIDE_HANDLE, WinError.ERROR_DBG_RIPEXCEPTION}, "CN");
            add(new int[]{700, WinError.ERROR_RECEIVE_PARTIAL_EXPEDITED}, "NO");
            add(new int[]{WinError.ERROR_DRIVERS_LEAKING_LOCKED_PAGES}, "IL");
            add(new int[]{WinError.ERROR_WAKE_SYSTEM, WinError.ERROR_ALERTED}, "SE");
            add(new int[]{WinError.ERROR_ELEVATION_REQUIRED}, "GT");
            add(new int[]{WinError.ERROR_REPARSE}, "SV");
            add(new int[]{WinError.ERROR_OPLOCK_BREAK_IN_PROGRESS}, "HN");
            add(new int[]{WinError.ERROR_VOLUME_MOUNTED}, "NI");
            add(new int[]{WinError.ERROR_RXACT_COMMITTED}, "CR");
            add(new int[]{WinError.ERROR_NOTIFY_CLEANUP}, "PA");
            add(new int[]{WinError.ERROR_PRIMARY_TRANSPORT_CONNECT_FAILED}, "DO");
            add(new int[]{WinError.ERROR_PAGE_FAULT_GUARD_PAGE}, "MX");
            add(new int[]{WinError.ERROR_BUFFER_ALL_ZEROS, WinError.ERROR_REPARSE_OBJECT}, "CA");
            add(new int[]{WinError.ERROR_PROCESS_NOT_IN_JOB}, "VE");
            add(new int[]{WinError.ERROR_PROCESS_IN_JOB, WinError.ERROR_COMPRESSION_DISABLED}, "CH");
            add(new int[]{WinError.ERROR_CANTFETCHBACKWARDS}, "CO");
            add(new int[]{WinError.ERROR_BAD_ACCESSOR_FLAGS}, "UY");
            add(new int[]{WinError.ERROR_NOT_CAPABLE}, "PE");
            add(new int[]{WinError.ERROR_VERSION_PARSE_ERROR}, "BO");
            add(new int[]{WinError.ERROR_MEMORY_HARDWARE}, "AR");
            add(new int[]{WinError.ERROR_DISK_REPAIR_DISABLED}, "CL");
            add(new int[]{WinError.ERROR_MCA_EXCEPTION}, "PY");
            add(new int[]{WinError.ERROR_ACCESS_AUDIT_BY_POLICY}, "PE");
            add(new int[]{786}, "EC");
            add(new int[]{WinError.ERROR_LOST_WRITEBEHIND_DATA_NETWORK_SERVER_ERROR, WinError.ERROR_LOST_WRITEBEHIND_DATA_LOCAL_DISK_ERROR}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{850}, "CU");
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{860}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{867}, "KP");
            add(new int[]{868, 869}, "TR");
            add(new int[]{870, 879}, "NL");
            add(new int[]{880}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{888}, "SG");
            add(new int[]{890}, "IN");
            add(new int[]{893}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{899}, "ID");
            add(new int[]{TypedValues.Custom.TYPE_INT, 919}, "AT");
            add(new int[]{930, 939}, "AU");
            add(new int[]{940, 949}, "AZ");
            add(new int[]{955}, "MY");
            add(new int[]{958}, "MO");
        }
    }
}
