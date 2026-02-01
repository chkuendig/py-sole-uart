package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class PermissionProto {

    public interface PermissionOrBuilder extends MessageLiteOrBuilder {
        AccessType getAccessType();

        DataProto.DataType getDataType();

        String getPermission();

        ByteString getPermissionBytes();

        boolean hasAccessType();

        boolean hasDataType();

        boolean hasPermission();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private PermissionProto() {
    }

    public enum AccessType implements Internal.EnumLite {
        ACCESS_TYPE_UNKNOWN(0),
        ACCESS_TYPE_READ(1),
        ACCESS_TYPE_WRITE(2);

        public static final int ACCESS_TYPE_READ_VALUE = 1;
        public static final int ACCESS_TYPE_UNKNOWN_VALUE = 0;
        public static final int ACCESS_TYPE_WRITE_VALUE = 2;
        private static final Internal.EnumLiteMap<AccessType> internalValueMap = new Internal.EnumLiteMap<AccessType>() { // from class: androidx.health.platform.client.proto.PermissionProto.AccessType.1
            @Override // androidx.health.platform.client.proto.Internal.EnumLiteMap
            public AccessType findValueByNumber(int i) {
                return AccessType.forNumber(i);
            }
        };
        private final int value;

        @Override // androidx.health.platform.client.proto.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static AccessType valueOf(int i) {
            return forNumber(i);
        }

        public static AccessType forNumber(int i) {
            if (i == 0) {
                return ACCESS_TYPE_UNKNOWN;
            }
            if (i == 1) {
                return ACCESS_TYPE_READ;
            }
            if (i != 2) {
                return null;
            }
            return ACCESS_TYPE_WRITE;
        }

        public static Internal.EnumLiteMap<AccessType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return AccessTypeVerifier.INSTANCE;
        }

        private static final class AccessTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new AccessTypeVerifier();

            private AccessTypeVerifier() {
            }

            @Override // androidx.health.platform.client.proto.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return AccessType.forNumber(i) != null;
            }
        }

        AccessType(int i) {
            this.value = i;
        }
    }

    public static final class Permission extends GeneratedMessageLite<Permission, Builder> implements PermissionOrBuilder {
        public static final int ACCESS_TYPE_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final Permission DEFAULT_INSTANCE;
        private static volatile Parser<Permission> PARSER = null;
        public static final int PERMISSION_FIELD_NUMBER = 3;
        private int accessType_;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private String permission_ = "";

        private Permission() {
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public DataProto.DataType getDataType() {
            DataProto.DataType dataType = this.dataType_;
            return dataType == null ? DataProto.DataType.getDefaultInstance() : dataType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataProto.DataType dataType) {
            dataType.getClass();
            this.dataType_ = dataType;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataType(DataProto.DataType dataType) {
            dataType.getClass();
            DataProto.DataType dataType2 = this.dataType_;
            if (dataType2 != null && dataType2 != DataProto.DataType.getDefaultInstance()) {
                this.dataType_ = DataProto.DataType.newBuilder(this.dataType_).mergeFrom((DataProto.DataType.Builder) dataType).buildPartial();
            } else {
                this.dataType_ = dataType;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public boolean hasAccessType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public AccessType getAccessType() {
            AccessType accessTypeForNumber = AccessType.forNumber(this.accessType_);
            return accessTypeForNumber == null ? AccessType.ACCESS_TYPE_UNKNOWN : accessTypeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccessType(AccessType accessType) {
            this.accessType_ = accessType.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAccessType() {
            this.bitField0_ &= -3;
            this.accessType_ = 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public boolean hasPermission() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public String getPermission() {
            return this.permission_;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public ByteString getPermissionBytes() {
            return ByteString.copyFromUtf8(this.permission_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermission(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.permission_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPermission() {
            this.bitField0_ &= -5;
            this.permission_ = getDefaultInstance().getPermission();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermissionBytes(ByteString byteString) {
            this.permission_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static Permission parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Permission parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Permission parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Permission parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Permission parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Permission parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Permission parseFrom(InputStream inputStream) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Permission parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Permission parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Permission) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Permission parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Permission) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Permission parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Permission parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Permission permission) {
            return DEFAULT_INSTANCE.createBuilder(permission);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Permission, Builder> implements PermissionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Permission.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public boolean hasDataType() {
                return ((Permission) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public DataProto.DataType getDataType() {
                return ((Permission) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((Permission) this.instance).setDataType(dataType);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((Permission) this.instance).setDataType(builder.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((Permission) this.instance).mergeDataType(dataType);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((Permission) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public boolean hasAccessType() {
                return ((Permission) this.instance).hasAccessType();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public AccessType getAccessType() {
                return ((Permission) this.instance).getAccessType();
            }

            public Builder setAccessType(AccessType accessType) {
                copyOnWrite();
                ((Permission) this.instance).setAccessType(accessType);
                return this;
            }

            public Builder clearAccessType() {
                copyOnWrite();
                ((Permission) this.instance).clearAccessType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public boolean hasPermission() {
                return ((Permission) this.instance).hasPermission();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public String getPermission() {
                return ((Permission) this.instance).getPermission();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public ByteString getPermissionBytes() {
                return ((Permission) this.instance).getPermissionBytes();
            }

            public Builder setPermission(String str) {
                copyOnWrite();
                ((Permission) this.instance).setPermission(str);
                return this;
            }

            public Builder clearPermission() {
                copyOnWrite();
                ((Permission) this.instance).clearPermission();
                return this;
            }

            public Builder setPermissionBytes(ByteString byteString) {
                copyOnWrite();
                ((Permission) this.instance).setPermissionBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Permission();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "dataType_", "accessType_", AccessType.internalGetVerifier(), "permission_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Permission> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Permission.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Permission permission = new Permission();
            DEFAULT_INSTANCE = permission;
            GeneratedMessageLite.registerDefaultInstance(Permission.class, permission);
        }

        public static Permission getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Permission> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: androidx.health.platform.client.proto.PermissionProto$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
