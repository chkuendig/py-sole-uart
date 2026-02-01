package io.ktor.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: StatelessHmacNonceManager.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\nB1\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lio/ktor/util/StatelessHmacNonceManager;", "Lio/ktor/util/NonceManager;", "key", "", "algorithm", "", "timeoutMillis", "", "nonceGenerator", "Lkotlin/Function0;", "([BLjava/lang/String;JLkotlin/jvm/functions/Function0;)V", "keySpec", "Ljavax/crypto/spec/SecretKeySpec;", "(Ljavax/crypto/spec/SecretKeySpec;Ljava/lang/String;JLkotlin/jvm/functions/Function0;)V", "getAlgorithm", "()Ljava/lang/String;", "getKeySpec", "()Ljavax/crypto/spec/SecretKeySpec;", "macLength", "", "getNonceGenerator", "()Lkotlin/jvm/functions/Function0;", "getTimeoutMillis", "()J", "newNonce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyNonce", "", "nonce", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StatelessHmacNonceManager implements NonceManager {
    private final String algorithm;
    private final SecretKeySpec keySpec;
    private final int macLength;
    private final Function0<String> nonceGenerator;
    private final long timeoutMillis;

    public StatelessHmacNonceManager(SecretKeySpec keySpec, String algorithm, long j, Function0<String> nonceGenerator) throws NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(keySpec, "keySpec");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(nonceGenerator, "nonceGenerator");
        this.keySpec = keySpec;
        this.algorithm = algorithm;
        this.timeoutMillis = j;
        this.nonceGenerator = nonceGenerator;
        Mac mac = Mac.getInstance(algorithm);
        mac.init(keySpec);
        this.macLength = mac.getMacLength();
    }

    public final SecretKeySpec getKeySpec() {
        return this.keySpec;
    }

    public /* synthetic */ StatelessHmacNonceManager(SecretKeySpec secretKeySpec, String str, long j, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(secretKeySpec, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (Function0<String>) ((i & 8) != 0 ? new Function0<String>() { // from class: io.ktor.util.StatelessHmacNonceManager.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CryptoKt.generateNonce();
            }
        } : anonymousClass1));
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public final Function0<String> getNonceGenerator() {
        return this.nonceGenerator;
    }

    public /* synthetic */ StatelessHmacNonceManager(byte[] bArr, String str, long j, AnonymousClass2 anonymousClass2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? "HmacSHA256" : str, (i & 4) != 0 ? 60000L : j, (Function0<String>) ((i & 8) != 0 ? new Function0<String>() { // from class: io.ktor.util.StatelessHmacNonceManager.2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CryptoKt.generateNonce();
            }
        } : anonymousClass2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatelessHmacNonceManager(byte[] key, String algorithm, long j, Function0<String> nonceGenerator) {
        this(new SecretKeySpec(key, algorithm), algorithm, j, nonceGenerator);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(nonceGenerator, "nonceGenerator");
    }

    @Override // io.ktor.util.NonceManager
    public Object newNonce(Continuation<? super String> continuation) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        String strInvoke = this.nonceGenerator.invoke();
        String string = Long.toString(System.nanoTime(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        String strPadStart = StringsKt.padStart(string, 16, '0');
        Mac mac = Mac.getInstance(this.algorithm);
        mac.init(this.keySpec);
        byte[] bytes = (strInvoke + ':' + strPadStart).getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        mac.update(bytes);
        byte[] bArrDoFinal = mac.doFinal();
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "getInstance(algorithm).a…)\n            }.doFinal()");
        return strInvoke + SignatureVisitor.EXTENDS + strPadStart + SignatureVisitor.EXTENDS + CryptoKt.hex(bArrDoFinal);
    }

    @Override // io.ktor.util.NonceManager
    public Object verifyNonce(String str, Continuation<? super Boolean> continuation) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{SignatureVisitor.EXTENDS}, false, 0, 6, (Object) null);
        if (listSplit$default.size() != 3) {
            return Boxing.boxBoolean(false);
        }
        String str2 = (String) listSplit$default.get(0);
        String str3 = (String) listSplit$default.get(1);
        String str4 = (String) listSplit$default.get(2);
        if (str2.length() >= 8 && str4.length() == this.macLength * 2 && str3.length() == 16 && Long.parseLong(str3, CharsKt.checkRadix(16)) + TimeUnit.MILLISECONDS.toNanos(this.timeoutMillis) >= System.nanoTime()) {
            Mac mac = Mac.getInstance(this.algorithm);
            mac.init(this.keySpec);
            byte[] bytes = (str2 + ':' + str3).getBytes(Charsets.ISO_8859_1);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            mac.update(bytes);
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "getInstance(algorithm).a…)\n            }.doFinal()");
            String strHex = CryptoKt.hex(bArrDoFinal);
            int iMin = Math.min(strHex.length(), str4.length());
            int i = 0;
            for (int i2 = 0; i2 < iMin; i2++) {
                if (strHex.charAt(i2) == str4.charAt(i2)) {
                    i++;
                }
            }
            return Boxing.boxBoolean(i == this.macLength * 2);
        }
        return Boxing.boxBoolean(false);
    }
}
