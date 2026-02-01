package com.sun.jna.platform.win32;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.DsGetDC;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.LMAccess;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class Netapi32Util {

    public static class DomainController {
        public String address;
        public int addressType;
        public String clientSiteName;
        public String dnsForestName;
        public Guid.GUID domainGuid;
        public String domainName;
        public int flags;
        public String name;
    }

    public static class Group {
        public String name;
    }

    public static class LocalGroup extends Group {
        public String comment;
    }

    public static class User {
        public String comment;
        public String name;
    }

    public static class UserInfo extends User {
        public int flags;
        public String fullName;
        public WinNT.PSID sid;
        public String sidString;
    }

    public static String getDCName() {
        return getDCName(null, null);
    }

    public static String getDCName(String str, String str2) {
        PointerByReference pointerByReference = new PointerByReference();
        try {
            int iNetGetDCName = Netapi32.INSTANCE.NetGetDCName(str2, str, pointerByReference);
            if (iNetGetDCName != 0) {
                throw new Win32Exception(iNetGetDCName);
            }
            String wideString = pointerByReference.getValue().getWideString(0L);
            if (Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()) == 0) {
                return wideString;
            }
            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
        } catch (Throwable th) {
            if (Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue()) != 0) {
                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
            }
            throw th;
        }
    }

    public static int getJoinStatus() {
        return getJoinStatus(null);
    }

    public static int getJoinStatus(String str) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int iNetGetJoinInformation = Netapi32.INSTANCE.NetGetJoinInformation(str, pointerByReference, intByReference);
            if (iNetGetJoinInformation != 0) {
                throw new Win32Exception(iNetGetJoinInformation);
            }
            int value = intByReference.getValue();
            if (pointerByReference.getPointer() == null || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return value;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getPointer() != null && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static String getDomainName(String str) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        try {
            int iNetGetJoinInformation = Netapi32.INSTANCE.NetGetJoinInformation(str, pointerByReference, new IntByReference());
            if (iNetGetJoinInformation != 0) {
                throw new Win32Exception(iNetGetJoinInformation);
            }
            String wideString = pointerByReference.getValue().getWideString(0L);
            if (pointerByReference.getPointer() == null || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return wideString;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getPointer() != null && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static LocalGroup[] getLocalGroups() {
        return getLocalGroups(null);
    }

    public static LocalGroup[] getLocalGroups(String str) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int iNetLocalGroupEnum = Netapi32.INSTANCE.NetLocalGroupEnum(str, 1, pointerByReference, -1, intByReference, new IntByReference(), null);
            if (iNetLocalGroupEnum != 0 || pointerByReference.getValue() == Pointer.NULL) {
                throw new Win32Exception(iNetLocalGroupEnum);
            }
            ArrayList arrayList = new ArrayList();
            if (intByReference.getValue() > 0) {
                for (LMAccess.LOCALGROUP_INFO_1 localgroup_info_1 : (LMAccess.LOCALGROUP_INFO_1[]) new LMAccess.LOCALGROUP_INFO_1(pointerByReference.getValue()).toArray(intByReference.getValue())) {
                    LocalGroup localGroup = new LocalGroup();
                    localGroup.name = localgroup_info_1.lgrui1_name;
                    localGroup.comment = localgroup_info_1.lgrui1_comment;
                    arrayList.add(localGroup);
                }
            }
            LocalGroup[] localGroupArr = (LocalGroup[]) arrayList.toArray(new LocalGroup[0]);
            if (pointerByReference.getValue() == Pointer.NULL || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return localGroupArr;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getValue() != Pointer.NULL && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static Group[] getGlobalGroups() {
        return getGlobalGroups(null);
    }

    public static Group[] getGlobalGroups(String str) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int iNetGroupEnum = Netapi32.INSTANCE.NetGroupEnum(str, 1, pointerByReference, -1, intByReference, new IntByReference(), null);
            if (iNetGroupEnum != 0 || pointerByReference.getValue() == Pointer.NULL) {
                throw new Win32Exception(iNetGroupEnum);
            }
            ArrayList arrayList = new ArrayList();
            if (intByReference.getValue() > 0) {
                for (LMAccess.GROUP_INFO_1 group_info_1 : (LMAccess.GROUP_INFO_1[]) new LMAccess.GROUP_INFO_1(pointerByReference.getValue()).toArray(intByReference.getValue())) {
                    LocalGroup localGroup = new LocalGroup();
                    localGroup.name = group_info_1.grpi1_name;
                    localGroup.comment = group_info_1.grpi1_comment;
                    arrayList.add(localGroup);
                }
            }
            Group[] groupArr = (Group[]) arrayList.toArray(new LocalGroup[0]);
            if (pointerByReference.getValue() == Pointer.NULL || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return groupArr;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getValue() != Pointer.NULL && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static User[] getUsers() {
        return getUsers(null);
    }

    public static User[] getUsers(String str) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int iNetUserEnum = Netapi32.INSTANCE.NetUserEnum(str, 1, 0, pointerByReference, -1, intByReference, new IntByReference(), null);
            if (iNetUserEnum != 0 || pointerByReference.getValue() == Pointer.NULL) {
                throw new Win32Exception(iNetUserEnum);
            }
            ArrayList arrayList = new ArrayList();
            if (intByReference.getValue() > 0) {
                for (LMAccess.USER_INFO_1 user_info_1 : (LMAccess.USER_INFO_1[]) new LMAccess.USER_INFO_1(pointerByReference.getValue()).toArray(intByReference.getValue())) {
                    User user = new User();
                    if (user_info_1.usri1_name != null) {
                        user.name = user_info_1.usri1_name;
                    }
                    arrayList.add(user);
                }
            }
            User[] userArr = (User[]) arrayList.toArray(new User[0]);
            if (pointerByReference.getValue() == Pointer.NULL || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return userArr;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getValue() != Pointer.NULL && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static Group[] getCurrentUserLocalGroups() {
        return getUserLocalGroups(Secur32Util.getUserNameEx(2));
    }

    public static Group[] getUserLocalGroups(String str) {
        return getUserLocalGroups(str, null);
    }

    public static Group[] getUserLocalGroups(String str, String str2) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int iNetUserGetLocalGroups = Netapi32.INSTANCE.NetUserGetLocalGroups(str2, str, 0, 0, pointerByReference, -1, intByReference, new IntByReference());
            if (iNetUserGetLocalGroups != 0) {
                throw new Win32Exception(iNetUserGetLocalGroups);
            }
            ArrayList arrayList = new ArrayList();
            if (intByReference.getValue() > 0) {
                for (LMAccess.LOCALGROUP_USERS_INFO_0 localgroup_users_info_0 : (LMAccess.LOCALGROUP_USERS_INFO_0[]) new LMAccess.LOCALGROUP_USERS_INFO_0(pointerByReference.getValue()).toArray(intByReference.getValue())) {
                    LocalGroup localGroup = new LocalGroup();
                    if (localgroup_users_info_0.lgrui0_name != null) {
                        localGroup.name = localgroup_users_info_0.lgrui0_name;
                    }
                    arrayList.add(localGroup);
                }
            }
            Group[] groupArr = (Group[]) arrayList.toArray(new Group[0]);
            if (pointerByReference.getValue() == Pointer.NULL || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return groupArr;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getValue() != Pointer.NULL && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static Group[] getUserGroups(String str) {
        return getUserGroups(str, null);
    }

    public static Group[] getUserGroups(String str, String str2) {
        int iNetApiBufferFree;
        int iNetApiBufferFree2;
        PointerByReference pointerByReference = new PointerByReference();
        IntByReference intByReference = new IntByReference();
        try {
            int iNetUserGetGroups = Netapi32.INSTANCE.NetUserGetGroups(str2, str, 0, pointerByReference, -1, intByReference, new IntByReference());
            if (iNetUserGetGroups != 0) {
                throw new Win32Exception(iNetUserGetGroups);
            }
            ArrayList arrayList = new ArrayList();
            if (intByReference.getValue() > 0) {
                for (LMAccess.GROUP_USERS_INFO_0 group_users_info_0 : (LMAccess.GROUP_USERS_INFO_0[]) new LMAccess.GROUP_USERS_INFO_0(pointerByReference.getValue()).toArray(intByReference.getValue())) {
                    Group group = new Group();
                    if (group_users_info_0.grui0_name != null) {
                        group.name = group_users_info_0.grui0_name;
                    }
                    arrayList.add(group);
                }
            }
            Group[] groupArr = (Group[]) arrayList.toArray(new Group[0]);
            if (pointerByReference.getValue() == Pointer.NULL || (iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) == 0) {
                return groupArr;
            }
            throw new Win32Exception(iNetApiBufferFree2);
        } catch (Throwable th) {
            if (pointerByReference.getValue() != Pointer.NULL && (iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue())) != 0) {
                throw new Win32Exception(iNetApiBufferFree);
            }
            throw th;
        }
    }

    public static DomainController getDC() {
        DsGetDC.PDOMAIN_CONTROLLER_INFO pdomain_controller_info = new DsGetDC.PDOMAIN_CONTROLLER_INFO();
        int iDsGetDcName = Netapi32.INSTANCE.DsGetDcName(null, null, null, null, 0, pdomain_controller_info);
        if (iDsGetDcName != 0) {
            throw new Win32Exception(iDsGetDcName);
        }
        DomainController domainController = new DomainController();
        domainController.address = pdomain_controller_info.dci.DomainControllerAddress;
        domainController.addressType = pdomain_controller_info.dci.DomainControllerAddressType;
        domainController.clientSiteName = pdomain_controller_info.dci.ClientSiteName;
        domainController.dnsForestName = pdomain_controller_info.dci.DnsForestName;
        domainController.domainGuid = pdomain_controller_info.dci.DomainGuid;
        domainController.domainName = pdomain_controller_info.dci.DomainName;
        domainController.flags = pdomain_controller_info.dci.Flags;
        domainController.name = pdomain_controller_info.dci.DomainControllerName;
        int iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pdomain_controller_info.dci.getPointer());
        if (iNetApiBufferFree == 0) {
            return domainController;
        }
        throw new Win32Exception(iNetApiBufferFree);
    }

    public static class DomainTrust {
        public String DnsDomainName;
        public Guid.GUID DomainGuid;
        public String DomainGuidString;
        public WinNT.PSID DomainSid;
        public String DomainSidString;
        public String NetbiosDomainName;
        private int flags;

        public boolean isInForest() {
            return (this.flags & 1) != 0;
        }

        public boolean isOutbound() {
            return (this.flags & 2) != 0;
        }

        public boolean isRoot() {
            return (this.flags & 4) != 0;
        }

        public boolean isPrimary() {
            return (this.flags & 8) != 0;
        }

        public boolean isNativeMode() {
            return (this.flags & 16) != 0;
        }

        public boolean isInbound() {
            return (this.flags & 32) != 0;
        }
    }

    public static DomainTrust[] getDomainTrusts() {
        return getDomainTrusts(null);
    }

    public static DomainTrust[] getDomainTrusts(String str) {
        IntByReference intByReference = new IntByReference();
        PointerByReference pointerByReference = new PointerByReference();
        int iDsEnumerateDomainTrusts = Netapi32.INSTANCE.DsEnumerateDomainTrusts(str, 63, pointerByReference, intByReference);
        if (iDsEnumerateDomainTrusts != 0) {
            throw new Win32Exception(iDsEnumerateDomainTrusts);
        }
        try {
            ArrayList arrayList = new ArrayList(intByReference.getValue());
            if (intByReference.getValue() > 0) {
                for (DsGetDC.DS_DOMAIN_TRUSTS ds_domain_trusts : (DsGetDC.DS_DOMAIN_TRUSTS[]) new DsGetDC.DS_DOMAIN_TRUSTS(pointerByReference.getValue()).toArray(new DsGetDC.DS_DOMAIN_TRUSTS[intByReference.getValue()])) {
                    DomainTrust domainTrust = new DomainTrust();
                    if (ds_domain_trusts.DnsDomainName != null) {
                        domainTrust.DnsDomainName = ds_domain_trusts.DnsDomainName;
                    }
                    if (ds_domain_trusts.NetbiosDomainName != null) {
                        domainTrust.NetbiosDomainName = ds_domain_trusts.NetbiosDomainName;
                    }
                    domainTrust.DomainSid = ds_domain_trusts.DomainSid;
                    if (ds_domain_trusts.DomainSid != null) {
                        domainTrust.DomainSidString = Advapi32Util.convertSidToStringSid(ds_domain_trusts.DomainSid);
                    }
                    domainTrust.DomainGuid = ds_domain_trusts.DomainGuid;
                    if (ds_domain_trusts.DomainGuid != null) {
                        domainTrust.DomainGuidString = Ole32Util.getStringFromGUID(ds_domain_trusts.DomainGuid);
                    }
                    domainTrust.flags = ds_domain_trusts.Flags;
                    arrayList.add(domainTrust);
                }
            }
            DomainTrust[] domainTrustArr = (DomainTrust[]) arrayList.toArray(new DomainTrust[0]);
            int iNetApiBufferFree = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
            if (iNetApiBufferFree == 0) {
                return domainTrustArr;
            }
            throw new Win32Exception(iNetApiBufferFree);
        } catch (Throwable th) {
            int iNetApiBufferFree2 = Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
            if (iNetApiBufferFree2 != 0) {
                throw new Win32Exception(iNetApiBufferFree2);
            }
            throw th;
        }
    }

    public static UserInfo getUserInfo(String str) {
        return getUserInfo(str, getDCName());
    }

    public static UserInfo getUserInfo(String str, String str2) {
        PointerByReference pointerByReference = new PointerByReference();
        try {
            int iNetUserGetInfo = Netapi32.INSTANCE.NetUserGetInfo(str2, str, 23, pointerByReference);
            if (iNetUserGetInfo == 0) {
                LMAccess.USER_INFO_23 user_info_23 = new LMAccess.USER_INFO_23(pointerByReference.getValue());
                UserInfo userInfo = new UserInfo();
                userInfo.comment = user_info_23.usri23_comment;
                userInfo.flags = user_info_23.usri23_flags;
                userInfo.fullName = user_info_23.usri23_full_name;
                userInfo.name = user_info_23.usri23_name;
                if (user_info_23.usri23_user_sid != null) {
                    userInfo.sidString = Advapi32Util.convertSidToStringSid(user_info_23.usri23_user_sid);
                }
                userInfo.sid = user_info_23.usri23_user_sid;
                return userInfo;
            }
            throw new Win32Exception(iNetUserGetInfo);
        } finally {
            if (pointerByReference.getValue() != Pointer.NULL) {
                Netapi32.INSTANCE.NetApiBufferFree(pointerByReference.getValue());
            }
        }
    }
}
