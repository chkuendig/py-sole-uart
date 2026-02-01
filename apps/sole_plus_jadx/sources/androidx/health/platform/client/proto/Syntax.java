package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.Internal;

/* loaded from: classes2.dex */
public enum Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);

    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final Internal.EnumLiteMap<Syntax> internalValueMap = new Internal.EnumLiteMap<Syntax>() { // from class: androidx.health.platform.client.proto.Syntax.1
        @Override // androidx.health.platform.client.proto.Internal.EnumLiteMap
        public Syntax findValueByNumber(int number) {
            return Syntax.forNumber(number);
        }
    };
    private final int value;

    @Override // androidx.health.platform.client.proto.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static Syntax valueOf(int value) {
        return forNumber(value);
    }

    public static Syntax forNumber(int value) {
        if (value == 0) {
            return SYNTAX_PROTO2;
        }
        if (value != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.INSTANCE;
    }

    private static final class SyntaxVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // androidx.health.platform.client.proto.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return Syntax.forNumber(number) != null;
        }
    }

    Syntax(int value) {
        this.value = value;
    }
}
