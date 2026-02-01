package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinCrypt;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

/* loaded from: classes4.dex */
public interface Crypt32 extends StdCallLibrary {
    public static final Crypt32 INSTANCE = (Crypt32) Native.load("Crypt32", Crypt32.class, W32APIOptions.DEFAULT_OPTIONS);

    boolean CertAddEncodedCertificateToSystemStore(String str, Pointer pointer, int i);

    boolean CertCloseStore(WinCrypt.HCERTSTORE hcertstore, int i);

    WinCrypt.CERT_CONTEXT.ByReference CertFindCertificateInStore(WinCrypt.HCERTSTORE hcertstore, int i, int i2, int i3, Pointer pointer, WinCrypt.CERT_CONTEXT cert_context);

    void CertFreeCertificateChain(WinCrypt.CERT_CHAIN_CONTEXT cert_chain_context);

    boolean CertFreeCertificateContext(WinCrypt.CERT_CONTEXT cert_context);

    boolean CertGetCertificateChain(WinCrypt.HCERTCHAINENGINE hcertchainengine, WinCrypt.CERT_CONTEXT cert_context, WinBase.FILETIME filetime, WinCrypt.HCERTSTORE hcertstore, WinCrypt.CERT_CHAIN_PARA cert_chain_para, int i, Pointer pointer, PointerByReference pointerByReference);

    int CertNameToStr(int i, WinCrypt.DATA_BLOB data_blob, int i2, Pointer pointer, int i3);

    WinCrypt.HCERTSTORE CertOpenSystemStore(Pointer pointer, String str);

    boolean CertVerifyCertificateChainPolicy(WTypes.LPSTR lpstr, WinCrypt.CERT_CHAIN_CONTEXT cert_chain_context, WinCrypt.CERT_CHAIN_POLICY_PARA cert_chain_policy_para, WinCrypt.CERT_CHAIN_POLICY_STATUS cert_chain_policy_status);

    boolean CryptProtectData(WinCrypt.DATA_BLOB data_blob, String str, WinCrypt.DATA_BLOB data_blob2, Pointer pointer, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT cryptprotect_promptstruct, int i, WinCrypt.DATA_BLOB data_blob3);

    boolean CryptSignMessage(WinCrypt.CRYPT_SIGN_MESSAGE_PARA crypt_sign_message_para, boolean z, int i, Pointer[] pointerArr, int[] iArr, Pointer pointer, IntByReference intByReference);

    boolean CryptUnprotectData(WinCrypt.DATA_BLOB data_blob, PointerByReference pointerByReference, WinCrypt.DATA_BLOB data_blob2, Pointer pointer, WinCrypt.CRYPTPROTECT_PROMPTSTRUCT cryptprotect_promptstruct, int i, WinCrypt.DATA_BLOB data_blob3);

    boolean CryptVerifyMessageSignature(WinCrypt.CRYPT_VERIFY_MESSAGE_PARA crypt_verify_message_para, int i, Pointer pointer, int i2, Pointer pointer2, IntByReference intByReference, PointerByReference pointerByReference);

    WinCrypt.HCERTSTORE PFXImportCertStore(WinCrypt.DATA_BLOB data_blob, WTypes.LPWSTR lpwstr, int i);
}
