package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class TimeProto {

    public interface TimeSpecOrBuilder extends MessageLiteOrBuilder {
        String getEndLocalDateTime();

        ByteString getEndLocalDateTimeBytes();

        long getEndTimeEpochMs();

        String getStartLocalDateTime();

        ByteString getStartLocalDateTimeBytes();

        long getStartTimeEpochMs();

        boolean hasEndLocalDateTime();

        boolean hasEndTimeEpochMs();

        boolean hasStartLocalDateTime();

        boolean hasStartTimeEpochMs();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private TimeProto() {
    }

    public static final class TimeSpec extends GeneratedMessageLite<TimeSpec, Builder> implements TimeSpecOrBuilder {
        private static final TimeSpec DEFAULT_INSTANCE;
        public static final int END_LOCAL_DATE_TIME_FIELD_NUMBER = 4;
        public static final int END_TIME_EPOCH_MS_FIELD_NUMBER = 2;
        private static volatile Parser<TimeSpec> PARSER = null;
        public static final int START_LOCAL_DATE_TIME_FIELD_NUMBER = 3;
        public static final int START_TIME_EPOCH_MS_FIELD_NUMBER = 1;
        private int bitField0_;
        private long endTimeEpochMs_;
        private long startTimeEpochMs_;
        private String startLocalDateTime_ = "";
        private String endLocalDateTime_ = "";

        private TimeSpec() {
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasStartTimeEpochMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public long getStartTimeEpochMs() {
            return this.startTimeEpochMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeEpochMs(long j) {
            this.bitField0_ |= 1;
            this.startTimeEpochMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeEpochMs() {
            this.bitField0_ &= -2;
            this.startTimeEpochMs_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasEndTimeEpochMs() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public long getEndTimeEpochMs() {
            return this.endTimeEpochMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTimeEpochMs(long j) {
            this.bitField0_ |= 2;
            this.endTimeEpochMs_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTimeEpochMs() {
            this.bitField0_ &= -3;
            this.endTimeEpochMs_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasStartLocalDateTime() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public String getStartLocalDateTime() {
            return this.startLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public ByteString getStartLocalDateTimeBytes() {
            return ByteString.copyFromUtf8(this.startLocalDateTime_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartLocalDateTime(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.startLocalDateTime_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartLocalDateTime() {
            this.bitField0_ &= -5;
            this.startLocalDateTime_ = getDefaultInstance().getStartLocalDateTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartLocalDateTimeBytes(ByteString byteString) {
            this.startLocalDateTime_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasEndLocalDateTime() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public String getEndLocalDateTime() {
            return this.endLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public ByteString getEndLocalDateTimeBytes() {
            return ByteString.copyFromUtf8(this.endLocalDateTime_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndLocalDateTime(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.endLocalDateTime_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndLocalDateTime() {
            this.bitField0_ &= -9;
            this.endLocalDateTime_ = getDefaultInstance().getEndLocalDateTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndLocalDateTimeBytes(ByteString byteString) {
            this.endLocalDateTime_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        public static TimeSpec parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static TimeSpec parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TimeSpec parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TimeSpec parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TimeSpec parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TimeSpec parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TimeSpec parseFrom(InputStream inputStream) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TimeSpec parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TimeSpec parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TimeSpec) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TimeSpec parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TimeSpec) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TimeSpec parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TimeSpec parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TimeSpec timeSpec) {
            return DEFAULT_INSTANCE.createBuilder(timeSpec);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TimeSpec, Builder> implements TimeSpecOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(TimeSpec.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasStartTimeEpochMs() {
                return ((TimeSpec) this.instance).hasStartTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public long getStartTimeEpochMs() {
                return ((TimeSpec) this.instance).getStartTimeEpochMs();
            }

            public Builder setStartTimeEpochMs(long j) {
                copyOnWrite();
                ((TimeSpec) this.instance).setStartTimeEpochMs(j);
                return this;
            }

            public Builder clearStartTimeEpochMs() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearStartTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasEndTimeEpochMs() {
                return ((TimeSpec) this.instance).hasEndTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public long getEndTimeEpochMs() {
                return ((TimeSpec) this.instance).getEndTimeEpochMs();
            }

            public Builder setEndTimeEpochMs(long j) {
                copyOnWrite();
                ((TimeSpec) this.instance).setEndTimeEpochMs(j);
                return this;
            }

            public Builder clearEndTimeEpochMs() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearEndTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasStartLocalDateTime() {
                return ((TimeSpec) this.instance).hasStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public String getStartLocalDateTime() {
                return ((TimeSpec) this.instance).getStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public ByteString getStartLocalDateTimeBytes() {
                return ((TimeSpec) this.instance).getStartLocalDateTimeBytes();
            }

            public Builder setStartLocalDateTime(String str) {
                copyOnWrite();
                ((TimeSpec) this.instance).setStartLocalDateTime(str);
                return this;
            }

            public Builder clearStartLocalDateTime() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearStartLocalDateTime();
                return this;
            }

            public Builder setStartLocalDateTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((TimeSpec) this.instance).setStartLocalDateTimeBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasEndLocalDateTime() {
                return ((TimeSpec) this.instance).hasEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public String getEndLocalDateTime() {
                return ((TimeSpec) this.instance).getEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public ByteString getEndLocalDateTimeBytes() {
                return ((TimeSpec) this.instance).getEndLocalDateTimeBytes();
            }

            public Builder setEndLocalDateTime(String str) {
                copyOnWrite();
                ((TimeSpec) this.instance).setEndLocalDateTime(str);
                return this;
            }

            public Builder clearEndLocalDateTime() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearEndLocalDateTime();
                return this;
            }

            public Builder setEndLocalDateTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((TimeSpec) this.instance).setEndLocalDateTimeBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TimeSpec();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"bitField0_", "startTimeEpochMs_", "endTimeEpochMs_", "startLocalDateTime_", "endLocalDateTime_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TimeSpec> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (TimeSpec.class) {
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
            TimeSpec timeSpec = new TimeSpec();
            DEFAULT_INSTANCE = timeSpec;
            GeneratedMessageLite.registerDefaultInstance(TimeSpec.class, timeSpec);
        }

        public static TimeSpec getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TimeSpec> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: androidx.health.platform.client.proto.TimeProto$1, reason: invalid class name */
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
