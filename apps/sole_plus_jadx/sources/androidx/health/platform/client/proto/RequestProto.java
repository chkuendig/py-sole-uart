package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import androidx.health.platform.client.proto.TimeProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class RequestProto {

    public interface AggregateDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataOrigin getDataOrigin(int i);

        int getDataOriginCount();

        List<DataProto.DataOrigin> getDataOriginList();

        AggregateMetricSpec getMetricSpec(int i);

        int getMetricSpecCount();

        List<AggregateMetricSpec> getMetricSpecList();

        long getSliceDurationMillis();

        String getSlicePeriod();

        ByteString getSlicePeriodBytes();

        TimeProto.TimeSpec getTimeSpec();

        boolean hasSliceDurationMillis();

        boolean hasSlicePeriod();

        boolean hasTimeSpec();
    }

    public interface AggregateMetricSpecOrBuilder extends MessageLiteOrBuilder {
        String getAggregationType();

        ByteString getAggregationTypeBytes();

        String getDataTypeName();

        ByteString getDataTypeNameBytes();

        String getFieldName();

        ByteString getFieldNameBytes();

        boolean hasAggregationType();

        boolean hasDataTypeName();

        boolean hasFieldName();
    }

    public interface DataTypeIdPairOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataType getDataType();

        String getId();

        ByteString getIdBytes();

        boolean hasDataType();

        boolean hasId();
    }

    public interface DeleteDataRangeRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataType getDataType(int i);

        int getDataTypeCount();

        List<DataProto.DataType> getDataTypeList();

        TimeProto.TimeSpec getTimeSpec();

        boolean hasTimeSpec();
    }

    public interface DeleteDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataTypeIdPair getClientIds(int i);

        int getClientIdsCount();

        List<DataTypeIdPair> getClientIdsList();

        DataTypeIdPair getUids(int i);

        int getUidsCount();

        List<DataTypeIdPair> getUidsList();
    }

    public interface GetChangesRequestOrBuilder extends MessageLiteOrBuilder {
        String getChangesToken();

        ByteString getChangesTokenBytes();

        boolean hasChangesToken();
    }

    public interface GetChangesTokenRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataOrigin getDataOriginFilters(int i);

        int getDataOriginFiltersCount();

        List<DataProto.DataOrigin> getDataOriginFiltersList();

        DataProto.DataType getDataType(int i);

        int getDataTypeCount();

        List<DataProto.DataType> getDataTypeList();
    }

    public interface ReadDataPointRequestOrBuilder extends MessageLiteOrBuilder {
        String getClientId();

        ByteString getClientIdBytes();

        DataProto.DataType getDataType();

        String getUid();

        ByteString getUidBytes();

        boolean hasClientId();

        boolean hasDataType();

        boolean hasUid();
    }

    public interface ReadDataRangeRequestOrBuilder extends MessageLiteOrBuilder {
        boolean getAscOrdering();

        DataProto.DataOrigin getDataOriginFilters(int i);

        int getDataOriginFiltersCount();

        List<DataProto.DataOrigin> getDataOriginFiltersList();

        DataProto.DataType getDataType();

        int getLimit();

        int getPageSize();

        String getPageToken();

        ByteString getPageTokenBytes();

        TimeProto.TimeSpec getTimeSpec();

        boolean hasAscOrdering();

        boolean hasDataType();

        boolean hasLimit();

        boolean hasPageSize();

        boolean hasPageToken();

        boolean hasTimeSpec();
    }

    public interface ReadDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataTypeIdPair getDataTypeIdPair();

        boolean hasDataTypeIdPair();
    }

    public interface ReadExerciseRouteRequestOrBuilder extends MessageLiteOrBuilder {
        String getSessionUid();

        ByteString getSessionUidBytes();

        boolean hasSessionUid();
    }

    public interface RegisterForDataNotificationsRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataType getDataTypes(int i);

        int getDataTypesCount();

        List<DataProto.DataType> getDataTypesList();

        String getNotificationIntentAction();

        ByteString getNotificationIntentActionBytes();

        boolean hasNotificationIntentAction();
    }

    public interface RequestContextOrBuilder extends MessageLiteOrBuilder {
        String getCallingPackage();

        ByteString getCallingPackageBytes();

        boolean getIsInForeground();

        String getPermissionToken();

        ByteString getPermissionTokenBytes();

        int getSdkVersion();

        boolean hasCallingPackage();

        boolean hasIsInForeground();

        boolean hasPermissionToken();

        boolean hasSdkVersion();
    }

    public interface SimpleDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint();

        boolean hasDataPoint();
    }

    public interface UnregisterFromDataNotificationsRequestOrBuilder extends MessageLiteOrBuilder {
        String getNotificationIntentAction();

        ByteString getNotificationIntentActionBytes();

        boolean hasNotificationIntentAction();
    }

    public interface UpsertDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint(int i);

        int getDataPointCount();

        List<DataProto.DataPoint> getDataPointList();
    }

    public interface UpsertExerciseRouteRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getExerciseRoute();

        String getSessionUid();

        ByteString getSessionUidBytes();

        boolean hasExerciseRoute();

        boolean hasSessionUid();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private RequestProto() {
    }

    public static final class SimpleDataRequest extends GeneratedMessageLite<SimpleDataRequest, Builder> implements SimpleDataRequestOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final SimpleDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<SimpleDataRequest> PARSER;
        private int bitField0_;
        private DataProto.DataPoint dataPoint_;

        private SimpleDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
        public boolean hasDataPoint() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
        public DataProto.DataPoint getDataPoint() {
            DataProto.DataPoint dataPoint = this.dataPoint_;
            return dataPoint == null ? DataProto.DataPoint.getDefaultInstance() : dataPoint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataPoint(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            this.dataPoint_ = dataPoint;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataPoint(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            DataProto.DataPoint dataPoint2 = this.dataPoint_;
            if (dataPoint2 != null && dataPoint2 != DataProto.DataPoint.getDefaultInstance()) {
                this.dataPoint_ = DataProto.DataPoint.newBuilder(this.dataPoint_).mergeFrom((DataProto.DataPoint.Builder) dataPoint).buildPartial();
            } else {
                this.dataPoint_ = dataPoint;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataPoint() {
            this.dataPoint_ = null;
            this.bitField0_ &= -2;
        }

        public static SimpleDataRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SimpleDataRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SimpleDataRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SimpleDataRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SimpleDataRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SimpleDataRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SimpleDataRequest parseFrom(InputStream inputStream) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SimpleDataRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SimpleDataRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SimpleDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SimpleDataRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SimpleDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SimpleDataRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SimpleDataRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SimpleDataRequest simpleDataRequest) {
            return DEFAULT_INSTANCE.createBuilder(simpleDataRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SimpleDataRequest, Builder> implements SimpleDataRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SimpleDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
            public boolean hasDataPoint() {
                return ((SimpleDataRequest) this.instance).hasDataPoint();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
            public DataProto.DataPoint getDataPoint() {
                return ((SimpleDataRequest) this.instance).getDataPoint();
            }

            public Builder setDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).setDataPoint(dataPoint);
                return this;
            }

            public Builder setDataPoint(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).setDataPoint(builder.build());
                return this;
            }

            public Builder mergeDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).mergeDataPoint(dataPoint);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).clearDataPoint();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SimpleDataRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "dataPoint_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SimpleDataRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SimpleDataRequest.class) {
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
            SimpleDataRequest simpleDataRequest = new SimpleDataRequest();
            DEFAULT_INSTANCE = simpleDataRequest;
            GeneratedMessageLite.registerDefaultInstance(SimpleDataRequest.class, simpleDataRequest);
        }

        public static SimpleDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SimpleDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: androidx.health.platform.client.proto.RequestProto$1, reason: invalid class name */
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

    public static final class ReadDataPointRequest extends GeneratedMessageLite<ReadDataPointRequest, Builder> implements ReadDataPointRequestOrBuilder {
        public static final int CLIENT_ID_FIELD_NUMBER = 3;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final ReadDataPointRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataPointRequest> PARSER = null;
        public static final int UID_FIELD_NUMBER = 2;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private String uid_ = "";
        private String clientId_ = "";

        private ReadDataPointRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
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

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public String getUid() {
            return this.uid_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public ByteString getUidBytes() {
            return ByteString.copyFromUtf8(this.uid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUid(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.uid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUid() {
            this.bitField0_ &= -3;
            this.uid_ = getDefaultInstance().getUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUidBytes(ByteString byteString) {
            this.uid_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public boolean hasClientId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public String getClientId() {
            return this.clientId_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public ByteString getClientIdBytes() {
            return ByteString.copyFromUtf8(this.clientId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientId(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.clientId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientId() {
            this.bitField0_ &= -5;
            this.clientId_ = getDefaultInstance().getClientId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIdBytes(ByteString byteString) {
            this.clientId_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static ReadDataPointRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDataPointRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDataPointRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDataPointRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDataPointRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDataPointRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDataPointRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataPointRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataPointRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDataPointRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataPointRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataPointRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataPointRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDataPointRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataPointRequest readDataPointRequest) {
            return DEFAULT_INSTANCE.createBuilder(readDataPointRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataPointRequest, Builder> implements ReadDataPointRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDataPointRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public boolean hasDataType() {
                return ((ReadDataPointRequest) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public DataProto.DataType getDataType() {
                return ((ReadDataPointRequest) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setDataType(dataType);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setDataType(builder.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).mergeDataType(dataType);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public boolean hasUid() {
                return ((ReadDataPointRequest) this.instance).hasUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public String getUid() {
                return ((ReadDataPointRequest) this.instance).getUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public ByteString getUidBytes() {
                return ((ReadDataPointRequest) this.instance).getUidBytes();
            }

            public Builder setUid(String str) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setUid(str);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).clearUid();
                return this;
            }

            public Builder setUidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setUidBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public boolean hasClientId() {
                return ((ReadDataPointRequest) this.instance).hasClientId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public String getClientId() {
                return ((ReadDataPointRequest) this.instance).getClientId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public ByteString getClientIdBytes() {
                return ((ReadDataPointRequest) this.instance).getClientIdBytes();
            }

            public Builder setClientId(String str) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setClientId(str);
                return this;
            }

            public Builder clearClientId() {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).clearClientId();
                return this;
            }

            public Builder setClientIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setClientIdBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDataPointRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "dataType_", "uid_", "clientId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDataPointRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadDataPointRequest.class) {
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
            ReadDataPointRequest readDataPointRequest = new ReadDataPointRequest();
            DEFAULT_INSTANCE = readDataPointRequest;
            GeneratedMessageLite.registerDefaultInstance(ReadDataPointRequest.class, readDataPointRequest);
        }

        public static ReadDataPointRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataPointRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RequestContext extends GeneratedMessageLite<RequestContext, Builder> implements RequestContextOrBuilder {
        public static final int CALLING_PACKAGE_FIELD_NUMBER = 1;
        private static final RequestContext DEFAULT_INSTANCE;
        public static final int IS_IN_FOREGROUND_FIELD_NUMBER = 4;
        private static volatile Parser<RequestContext> PARSER = null;
        public static final int PERMISSION_TOKEN_FIELD_NUMBER = 3;
        public static final int SDK_VERSION_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean isInForeground_;
        private int sdkVersion_;
        private String callingPackage_ = "";
        private String permissionToken_ = "";

        private RequestContext() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasCallingPackage() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public String getCallingPackage() {
            return this.callingPackage_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public ByteString getCallingPackageBytes() {
            return ByteString.copyFromUtf8(this.callingPackage_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallingPackage(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.callingPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallingPackage() {
            this.bitField0_ &= -2;
            this.callingPackage_ = getDefaultInstance().getCallingPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallingPackageBytes(ByteString byteString) {
            this.callingPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasSdkVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public int getSdkVersion() {
            return this.sdkVersion_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersion(int i) {
            this.bitField0_ |= 2;
            this.sdkVersion_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkVersion() {
            this.bitField0_ &= -3;
            this.sdkVersion_ = 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasPermissionToken() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public String getPermissionToken() {
            return this.permissionToken_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public ByteString getPermissionTokenBytes() {
            return ByteString.copyFromUtf8(this.permissionToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermissionToken(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.permissionToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPermissionToken() {
            this.bitField0_ &= -5;
            this.permissionToken_ = getDefaultInstance().getPermissionToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermissionTokenBytes(ByteString byteString) {
            this.permissionToken_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasIsInForeground() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean getIsInForeground() {
            return this.isInForeground_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsInForeground(boolean z) {
            this.bitField0_ |= 8;
            this.isInForeground_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsInForeground() {
            this.bitField0_ &= -9;
            this.isInForeground_ = false;
        }

        public static RequestContext parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RequestContext parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RequestContext parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RequestContext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RequestContext parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RequestContext parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RequestContext parseFrom(InputStream inputStream) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RequestContext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RequestContext parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RequestContext) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RequestContext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestContext) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RequestContext parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RequestContext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RequestContext requestContext) {
            return DEFAULT_INSTANCE.createBuilder(requestContext);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RequestContext, Builder> implements RequestContextOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(RequestContext.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasCallingPackage() {
                return ((RequestContext) this.instance).hasCallingPackage();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public String getCallingPackage() {
                return ((RequestContext) this.instance).getCallingPackage();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public ByteString getCallingPackageBytes() {
                return ((RequestContext) this.instance).getCallingPackageBytes();
            }

            public Builder setCallingPackage(String str) {
                copyOnWrite();
                ((RequestContext) this.instance).setCallingPackage(str);
                return this;
            }

            public Builder clearCallingPackage() {
                copyOnWrite();
                ((RequestContext) this.instance).clearCallingPackage();
                return this;
            }

            public Builder setCallingPackageBytes(ByteString byteString) {
                copyOnWrite();
                ((RequestContext) this.instance).setCallingPackageBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasSdkVersion() {
                return ((RequestContext) this.instance).hasSdkVersion();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public int getSdkVersion() {
                return ((RequestContext) this.instance).getSdkVersion();
            }

            public Builder setSdkVersion(int i) {
                copyOnWrite();
                ((RequestContext) this.instance).setSdkVersion(i);
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((RequestContext) this.instance).clearSdkVersion();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasPermissionToken() {
                return ((RequestContext) this.instance).hasPermissionToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public String getPermissionToken() {
                return ((RequestContext) this.instance).getPermissionToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public ByteString getPermissionTokenBytes() {
                return ((RequestContext) this.instance).getPermissionTokenBytes();
            }

            public Builder setPermissionToken(String str) {
                copyOnWrite();
                ((RequestContext) this.instance).setPermissionToken(str);
                return this;
            }

            public Builder clearPermissionToken() {
                copyOnWrite();
                ((RequestContext) this.instance).clearPermissionToken();
                return this;
            }

            public Builder setPermissionTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((RequestContext) this.instance).setPermissionTokenBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasIsInForeground() {
                return ((RequestContext) this.instance).hasIsInForeground();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean getIsInForeground() {
                return ((RequestContext) this.instance).getIsInForeground();
            }

            public Builder setIsInForeground(boolean z) {
                copyOnWrite();
                ((RequestContext) this.instance).setIsInForeground(z);
                return this;
            }

            public Builder clearIsInForeground() {
                copyOnWrite();
                ((RequestContext) this.instance).clearIsInForeground();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new RequestContext();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဇ\u0003", new Object[]{"bitField0_", "callingPackage_", "sdkVersion_", "permissionToken_", "isInForeground_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RequestContext> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (RequestContext.class) {
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
            RequestContext requestContext = new RequestContext();
            DEFAULT_INSTANCE = requestContext;
            GeneratedMessageLite.registerDefaultInstance(RequestContext.class, requestContext);
        }

        public static RequestContext getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RequestContext> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UpsertDataRequest extends GeneratedMessageLite<UpsertDataRequest, Builder> implements UpsertDataRequestOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final UpsertDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<UpsertDataRequest> PARSER;
        private Internal.ProtobufList<DataProto.DataPoint> dataPoint_ = emptyProtobufList();

        private UpsertDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
        public List<DataProto.DataPoint> getDataPointList() {
            return this.dataPoint_;
        }

        public List<? extends DataProto.DataPointOrBuilder> getDataPointOrBuilderList() {
            return this.dataPoint_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
        public int getDataPointCount() {
            return this.dataPoint_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
        public DataProto.DataPoint getDataPoint(int i) {
            return this.dataPoint_.get(i);
        }

        public DataProto.DataPointOrBuilder getDataPointOrBuilder(int i) {
            return this.dataPoint_.get(i);
        }

        private void ensureDataPointIsMutable() {
            Internal.ProtobufList<DataProto.DataPoint> protobufList = this.dataPoint_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataPoint_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataPoint(int i, DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            ensureDataPointIsMutable();
            this.dataPoint_.set(i, dataPoint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPoint(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            ensureDataPointIsMutable();
            this.dataPoint_.add(dataPoint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPoint(int i, DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            ensureDataPointIsMutable();
            this.dataPoint_.add(i, dataPoint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataPoint(Iterable<? extends DataProto.DataPoint> iterable) {
            ensureDataPointIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataPoint_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataPoint() {
            this.dataPoint_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataPoint(int i) {
            ensureDataPointIsMutable();
            this.dataPoint_.remove(i);
        }

        public static UpsertDataRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UpsertDataRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UpsertDataRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UpsertDataRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UpsertDataRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UpsertDataRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UpsertDataRequest parseFrom(InputStream inputStream) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpsertDataRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UpsertDataRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UpsertDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpsertDataRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UpsertDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UpsertDataRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UpsertDataRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UpsertDataRequest upsertDataRequest) {
            return DEFAULT_INSTANCE.createBuilder(upsertDataRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UpsertDataRequest, Builder> implements UpsertDataRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UpsertDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
            public List<DataProto.DataPoint> getDataPointList() {
                return Collections.unmodifiableList(((UpsertDataRequest) this.instance).getDataPointList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
            public int getDataPointCount() {
                return ((UpsertDataRequest) this.instance).getDataPointCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
            public DataProto.DataPoint getDataPoint(int i) {
                return ((UpsertDataRequest) this.instance).getDataPoint(i);
            }

            public Builder setDataPoint(int i, DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).setDataPoint(i, dataPoint);
                return this;
            }

            public Builder setDataPoint(int i, DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).setDataPoint(i, builder.build());
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(dataPoint);
                return this;
            }

            public Builder addDataPoint(int i, DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(i, dataPoint);
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(builder.build());
                return this;
            }

            public Builder addDataPoint(int i, DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(i, builder.build());
                return this;
            }

            public Builder addAllDataPoint(Iterable<? extends DataProto.DataPoint> iterable) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addAllDataPoint(iterable);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).clearDataPoint();
                return this;
            }

            public Builder removeDataPoint(int i) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).removeDataPoint(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UpsertDataRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"dataPoint_", DataProto.DataPoint.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UpsertDataRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (UpsertDataRequest.class) {
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
            UpsertDataRequest upsertDataRequest = new UpsertDataRequest();
            DEFAULT_INSTANCE = upsertDataRequest;
            GeneratedMessageLite.registerDefaultInstance(UpsertDataRequest.class, upsertDataRequest);
        }

        public static UpsertDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpsertDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DataTypeIdPair extends GeneratedMessageLite<DataTypeIdPair, Builder> implements DataTypeIdPairOrBuilder {
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final DataTypeIdPair DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 2;
        private static volatile Parser<DataTypeIdPair> PARSER;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private String id_ = "";

        private DataTypeIdPair() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
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

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public boolean hasId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.id_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.bitField0_ &= -3;
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString byteString) {
            this.id_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        public static DataTypeIdPair parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DataTypeIdPair parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DataTypeIdPair parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DataTypeIdPair parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DataTypeIdPair parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DataTypeIdPair parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DataTypeIdPair parseFrom(InputStream inputStream) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataTypeIdPair parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataTypeIdPair parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DataTypeIdPair) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataTypeIdPair parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataTypeIdPair) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataTypeIdPair parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DataTypeIdPair parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataTypeIdPair dataTypeIdPair) {
            return DEFAULT_INSTANCE.createBuilder(dataTypeIdPair);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataTypeIdPair, Builder> implements DataTypeIdPairOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DataTypeIdPair.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public boolean hasDataType() {
                return ((DataTypeIdPair) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public DataProto.DataType getDataType() {
                return ((DataTypeIdPair) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setDataType(dataType);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setDataType(builder.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).mergeDataType(dataType);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public boolean hasId() {
                return ((DataTypeIdPair) this.instance).hasId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public String getId() {
                return ((DataTypeIdPair) this.instance).getId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public ByteString getIdBytes() {
                return ((DataTypeIdPair) this.instance).getIdBytes();
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setId(str);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).clearId();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setIdBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DataTypeIdPair();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001", new Object[]{"bitField0_", "dataType_", "id_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DataTypeIdPair> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (DataTypeIdPair.class) {
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
            DataTypeIdPair dataTypeIdPair = new DataTypeIdPair();
            DEFAULT_INSTANCE = dataTypeIdPair;
            GeneratedMessageLite.registerDefaultInstance(DataTypeIdPair.class, dataTypeIdPair);
        }

        public static DataTypeIdPair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataTypeIdPair> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DeleteDataRequest extends GeneratedMessageLite<DeleteDataRequest, Builder> implements DeleteDataRequestOrBuilder {
        public static final int CLIENT_IDS_FIELD_NUMBER = 2;
        private static final DeleteDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<DeleteDataRequest> PARSER = null;
        public static final int UIDS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<DataTypeIdPair> uids_ = emptyProtobufList();
        private Internal.ProtobufList<DataTypeIdPair> clientIds_ = emptyProtobufList();

        private DeleteDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public List<DataTypeIdPair> getUidsList() {
            return this.uids_;
        }

        public List<? extends DataTypeIdPairOrBuilder> getUidsOrBuilderList() {
            return this.uids_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public int getUidsCount() {
            return this.uids_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public DataTypeIdPair getUids(int i) {
            return this.uids_.get(i);
        }

        public DataTypeIdPairOrBuilder getUidsOrBuilder(int i) {
            return this.uids_.get(i);
        }

        private void ensureUidsIsMutable() {
            Internal.ProtobufList<DataTypeIdPair> protobufList = this.uids_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.uids_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUids(int i, DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            ensureUidsIsMutable();
            this.uids_.set(i, dataTypeIdPair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUids(DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            ensureUidsIsMutable();
            this.uids_.add(dataTypeIdPair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUids(int i, DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            ensureUidsIsMutable();
            this.uids_.add(i, dataTypeIdPair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUids(Iterable<? extends DataTypeIdPair> iterable) {
            ensureUidsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.uids_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUids() {
            this.uids_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUids(int i) {
            ensureUidsIsMutable();
            this.uids_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public List<DataTypeIdPair> getClientIdsList() {
            return this.clientIds_;
        }

        public List<? extends DataTypeIdPairOrBuilder> getClientIdsOrBuilderList() {
            return this.clientIds_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public int getClientIdsCount() {
            return this.clientIds_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public DataTypeIdPair getClientIds(int i) {
            return this.clientIds_.get(i);
        }

        public DataTypeIdPairOrBuilder getClientIdsOrBuilder(int i) {
            return this.clientIds_.get(i);
        }

        private void ensureClientIdsIsMutable() {
            Internal.ProtobufList<DataTypeIdPair> protobufList = this.clientIds_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.clientIds_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIds(int i, DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            ensureClientIdsIsMutable();
            this.clientIds_.set(i, dataTypeIdPair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClientIds(DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            ensureClientIdsIsMutable();
            this.clientIds_.add(dataTypeIdPair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClientIds(int i, DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            ensureClientIdsIsMutable();
            this.clientIds_.add(i, dataTypeIdPair);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllClientIds(Iterable<? extends DataTypeIdPair> iterable) {
            ensureClientIdsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.clientIds_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientIds() {
            this.clientIds_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeClientIds(int i) {
            ensureClientIdsIsMutable();
            this.clientIds_.remove(i);
        }

        public static DeleteDataRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeleteDataRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeleteDataRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeleteDataRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeleteDataRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeleteDataRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeleteDataRequest parseFrom(InputStream inputStream) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteDataRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteDataRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeleteDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteDataRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteDataRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeleteDataRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeleteDataRequest deleteDataRequest) {
            return DEFAULT_INSTANCE.createBuilder(deleteDataRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeleteDataRequest, Builder> implements DeleteDataRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DeleteDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public List<DataTypeIdPair> getUidsList() {
                return Collections.unmodifiableList(((DeleteDataRequest) this.instance).getUidsList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public int getUidsCount() {
                return ((DeleteDataRequest) this.instance).getUidsCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public DataTypeIdPair getUids(int i) {
                return ((DeleteDataRequest) this.instance).getUids(i);
            }

            public Builder setUids(int i, DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setUids(i, dataTypeIdPair);
                return this;
            }

            public Builder setUids(int i, DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setUids(i, builder.build());
                return this;
            }

            public Builder addUids(DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(dataTypeIdPair);
                return this;
            }

            public Builder addUids(int i, DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(i, dataTypeIdPair);
                return this;
            }

            public Builder addUids(DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(builder.build());
                return this;
            }

            public Builder addUids(int i, DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(i, builder.build());
                return this;
            }

            public Builder addAllUids(Iterable<? extends DataTypeIdPair> iterable) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addAllUids(iterable);
                return this;
            }

            public Builder clearUids() {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).clearUids();
                return this;
            }

            public Builder removeUids(int i) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).removeUids(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public List<DataTypeIdPair> getClientIdsList() {
                return Collections.unmodifiableList(((DeleteDataRequest) this.instance).getClientIdsList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public int getClientIdsCount() {
                return ((DeleteDataRequest) this.instance).getClientIdsCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public DataTypeIdPair getClientIds(int i) {
                return ((DeleteDataRequest) this.instance).getClientIds(i);
            }

            public Builder setClientIds(int i, DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setClientIds(i, dataTypeIdPair);
                return this;
            }

            public Builder setClientIds(int i, DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setClientIds(i, builder.build());
                return this;
            }

            public Builder addClientIds(DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(dataTypeIdPair);
                return this;
            }

            public Builder addClientIds(int i, DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(i, dataTypeIdPair);
                return this;
            }

            public Builder addClientIds(DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(builder.build());
                return this;
            }

            public Builder addClientIds(int i, DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(i, builder.build());
                return this;
            }

            public Builder addAllClientIds(Iterable<? extends DataTypeIdPair> iterable) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addAllClientIds(iterable);
                return this;
            }

            public Builder clearClientIds() {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).clearClientIds();
                return this;
            }

            public Builder removeClientIds(int i) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).removeClientIds(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeleteDataRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"uids_", DataTypeIdPair.class, "clientIds_", DataTypeIdPair.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeleteDataRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (DeleteDataRequest.class) {
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
            DeleteDataRequest deleteDataRequest = new DeleteDataRequest();
            DEFAULT_INSTANCE = deleteDataRequest;
            GeneratedMessageLite.registerDefaultInstance(DeleteDataRequest.class, deleteDataRequest);
        }

        public static DeleteDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeleteDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DeleteDataRangeRequest extends GeneratedMessageLite<DeleteDataRangeRequest, Builder> implements DeleteDataRangeRequestOrBuilder {
        public static final int DATA_TYPE_FIELD_NUMBER = 2;
        private static final DeleteDataRangeRequest DEFAULT_INSTANCE;
        private static volatile Parser<DeleteDataRangeRequest> PARSER = null;
        public static final int TIME_SPEC_FIELD_NUMBER = 1;
        private int bitField0_;
        private Internal.ProtobufList<DataProto.DataType> dataType_ = emptyProtobufList();
        private TimeProto.TimeSpec timeSpec_;

        private DeleteDataRangeRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public boolean hasTimeSpec() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public TimeProto.TimeSpec getTimeSpec() {
            TimeProto.TimeSpec timeSpec = this.timeSpec_;
            return timeSpec == null ? TimeProto.TimeSpec.getDefaultInstance() : timeSpec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeSpec(TimeProto.TimeSpec timeSpec) {
            timeSpec.getClass();
            this.timeSpec_ = timeSpec;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimeSpec(TimeProto.TimeSpec timeSpec) {
            timeSpec.getClass();
            TimeProto.TimeSpec timeSpec2 = this.timeSpec_;
            if (timeSpec2 != null && timeSpec2 != TimeProto.TimeSpec.getDefaultInstance()) {
                this.timeSpec_ = TimeProto.TimeSpec.newBuilder(this.timeSpec_).mergeFrom((TimeProto.TimeSpec.Builder) timeSpec).buildPartial();
            } else {
                this.timeSpec_ = timeSpec;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeSpec() {
            this.timeSpec_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public List<DataProto.DataType> getDataTypeList() {
            return this.dataType_;
        }

        public List<? extends DataProto.DataTypeOrBuilder> getDataTypeOrBuilderList() {
            return this.dataType_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public int getDataTypeCount() {
            return this.dataType_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public DataProto.DataType getDataType(int i) {
            return this.dataType_.get(i);
        }

        public DataProto.DataTypeOrBuilder getDataTypeOrBuilder(int i) {
            return this.dataType_.get(i);
        }

        private void ensureDataTypeIsMutable() {
            Internal.ProtobufList<DataProto.DataType> protobufList = this.dataType_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataType_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(int i, DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.set(i, dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(int i, DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(i, dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataType(Iterable<? extends DataProto.DataType> iterable) {
            ensureDataTypeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataType(int i) {
            ensureDataTypeIsMutable();
            this.dataType_.remove(i);
        }

        public static DeleteDataRangeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeleteDataRangeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeleteDataRangeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeleteDataRangeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeleteDataRangeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeleteDataRangeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeleteDataRangeRequest parseFrom(InputStream inputStream) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteDataRangeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteDataRangeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeleteDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeleteDataRangeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeleteDataRangeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeleteDataRangeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeleteDataRangeRequest deleteDataRangeRequest) {
            return DEFAULT_INSTANCE.createBuilder(deleteDataRangeRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeleteDataRangeRequest, Builder> implements DeleteDataRangeRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DeleteDataRangeRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public boolean hasTimeSpec() {
                return ((DeleteDataRangeRequest) this.instance).hasTimeSpec();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public TimeProto.TimeSpec getTimeSpec() {
                return ((DeleteDataRangeRequest) this.instance).getTimeSpec();
            }

            public Builder setTimeSpec(TimeProto.TimeSpec timeSpec) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setTimeSpec(timeSpec);
                return this;
            }

            public Builder setTimeSpec(TimeProto.TimeSpec.Builder builder) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setTimeSpec(builder.build());
                return this;
            }

            public Builder mergeTimeSpec(TimeProto.TimeSpec timeSpec) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).mergeTimeSpec(timeSpec);
                return this;
            }

            public Builder clearTimeSpec() {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).clearTimeSpec();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public List<DataProto.DataType> getDataTypeList() {
                return Collections.unmodifiableList(((DeleteDataRangeRequest) this.instance).getDataTypeList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public int getDataTypeCount() {
                return ((DeleteDataRangeRequest) this.instance).getDataTypeCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public DataProto.DataType getDataType(int i) {
                return ((DeleteDataRangeRequest) this.instance).getDataType(i);
            }

            public Builder setDataType(int i, DataProto.DataType dataType) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setDataType(i, dataType);
                return this;
            }

            public Builder setDataType(int i, DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setDataType(i, builder.build());
                return this;
            }

            public Builder addDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(dataType);
                return this;
            }

            public Builder addDataType(int i, DataProto.DataType dataType) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(i, dataType);
                return this;
            }

            public Builder addDataType(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(builder.build());
                return this;
            }

            public Builder addDataType(int i, DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(i, builder.build());
                return this;
            }

            public Builder addAllDataType(Iterable<? extends DataProto.DataType> iterable) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addAllDataType(iterable);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).clearDataType();
                return this;
            }

            public Builder removeDataType(int i) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).removeDataType(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeleteDataRangeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "timeSpec_", "dataType_", DataProto.DataType.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeleteDataRangeRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (DeleteDataRangeRequest.class) {
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
            DeleteDataRangeRequest deleteDataRangeRequest = new DeleteDataRangeRequest();
            DEFAULT_INSTANCE = deleteDataRangeRequest;
            GeneratedMessageLite.registerDefaultInstance(DeleteDataRangeRequest.class, deleteDataRangeRequest);
        }

        public static DeleteDataRangeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeleteDataRangeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataRequest extends GeneratedMessageLite<ReadDataRequest, Builder> implements ReadDataRequestOrBuilder {
        public static final int DATA_TYPE_ID_PAIR_FIELD_NUMBER = 1;
        private static final ReadDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataRequest> PARSER;
        private int bitField0_;
        private DataTypeIdPair dataTypeIdPair_;

        private ReadDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
        public boolean hasDataTypeIdPair() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
        public DataTypeIdPair getDataTypeIdPair() {
            DataTypeIdPair dataTypeIdPair = this.dataTypeIdPair_;
            return dataTypeIdPair == null ? DataTypeIdPair.getDefaultInstance() : dataTypeIdPair;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypeIdPair(DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            this.dataTypeIdPair_ = dataTypeIdPair;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataTypeIdPair(DataTypeIdPair dataTypeIdPair) {
            dataTypeIdPair.getClass();
            DataTypeIdPair dataTypeIdPair2 = this.dataTypeIdPair_;
            if (dataTypeIdPair2 != null && dataTypeIdPair2 != DataTypeIdPair.getDefaultInstance()) {
                this.dataTypeIdPair_ = DataTypeIdPair.newBuilder(this.dataTypeIdPair_).mergeFrom((DataTypeIdPair.Builder) dataTypeIdPair).buildPartial();
            } else {
                this.dataTypeIdPair_ = dataTypeIdPair;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataTypeIdPair() {
            this.dataTypeIdPair_ = null;
            this.bitField0_ &= -2;
        }

        public static ReadDataRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDataRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDataRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDataRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDataRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDataRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDataRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDataRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataRequest readDataRequest) {
            return DEFAULT_INSTANCE.createBuilder(readDataRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataRequest, Builder> implements ReadDataRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
            public boolean hasDataTypeIdPair() {
                return ((ReadDataRequest) this.instance).hasDataTypeIdPair();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
            public DataTypeIdPair getDataTypeIdPair() {
                return ((ReadDataRequest) this.instance).getDataTypeIdPair();
            }

            public Builder setDataTypeIdPair(DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((ReadDataRequest) this.instance).setDataTypeIdPair(dataTypeIdPair);
                return this;
            }

            public Builder setDataTypeIdPair(DataTypeIdPair.Builder builder) {
                copyOnWrite();
                ((ReadDataRequest) this.instance).setDataTypeIdPair(builder.build());
                return this;
            }

            public Builder mergeDataTypeIdPair(DataTypeIdPair dataTypeIdPair) {
                copyOnWrite();
                ((ReadDataRequest) this.instance).mergeDataTypeIdPair(dataTypeIdPair);
                return this;
            }

            public Builder clearDataTypeIdPair() {
                copyOnWrite();
                ((ReadDataRequest) this.instance).clearDataTypeIdPair();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDataRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "dataTypeIdPair_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDataRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadDataRequest.class) {
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
            ReadDataRequest readDataRequest = new ReadDataRequest();
            DEFAULT_INSTANCE = readDataRequest;
            GeneratedMessageLite.registerDefaultInstance(ReadDataRequest.class, readDataRequest);
        }

        public static ReadDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataRangeRequest extends GeneratedMessageLite<ReadDataRangeRequest, Builder> implements ReadDataRangeRequestOrBuilder {
        public static final int ASC_ORDERING_FIELD_NUMBER = 7;
        public static final int DATA_ORIGIN_FILTERS_FIELD_NUMBER = 3;
        public static final int DATA_TYPE_FIELD_NUMBER = 2;
        private static final ReadDataRangeRequest DEFAULT_INSTANCE;
        public static final int LIMIT_FIELD_NUMBER = 4;
        public static final int PAGE_SIZE_FIELD_NUMBER = 5;
        public static final int PAGE_TOKEN_FIELD_NUMBER = 6;
        private static volatile Parser<ReadDataRangeRequest> PARSER = null;
        public static final int TIME_SPEC_FIELD_NUMBER = 1;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private int limit_;
        private int pageSize_;
        private TimeProto.TimeSpec timeSpec_;
        private Internal.ProtobufList<DataProto.DataOrigin> dataOriginFilters_ = emptyProtobufList();
        private boolean ascOrdering_ = true;
        private String pageToken_ = "";

        private ReadDataRangeRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasTimeSpec() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public TimeProto.TimeSpec getTimeSpec() {
            TimeProto.TimeSpec timeSpec = this.timeSpec_;
            return timeSpec == null ? TimeProto.TimeSpec.getDefaultInstance() : timeSpec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeSpec(TimeProto.TimeSpec timeSpec) {
            timeSpec.getClass();
            this.timeSpec_ = timeSpec;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimeSpec(TimeProto.TimeSpec timeSpec) {
            timeSpec.getClass();
            TimeProto.TimeSpec timeSpec2 = this.timeSpec_;
            if (timeSpec2 != null && timeSpec2 != TimeProto.TimeSpec.getDefaultInstance()) {
                this.timeSpec_ = TimeProto.TimeSpec.newBuilder(this.timeSpec_).mergeFrom((TimeProto.TimeSpec.Builder) timeSpec).buildPartial();
            } else {
                this.timeSpec_ = timeSpec;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeSpec() {
            this.timeSpec_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public DataProto.DataType getDataType() {
            DataProto.DataType dataType = this.dataType_;
            return dataType == null ? DataProto.DataType.getDefaultInstance() : dataType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataProto.DataType dataType) {
            dataType.getClass();
            this.dataType_ = dataType;
            this.bitField0_ |= 2;
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
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = null;
            this.bitField0_ &= -3;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public List<DataProto.DataOrigin> getDataOriginFiltersList() {
            return this.dataOriginFilters_;
        }

        public List<? extends DataProto.DataOriginOrBuilder> getDataOriginFiltersOrBuilderList() {
            return this.dataOriginFilters_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public int getDataOriginFiltersCount() {
            return this.dataOriginFilters_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public DataProto.DataOrigin getDataOriginFilters(int i) {
            return this.dataOriginFilters_.get(i);
        }

        public DataProto.DataOriginOrBuilder getDataOriginFiltersOrBuilder(int i) {
            return this.dataOriginFilters_.get(i);
        }

        private void ensureDataOriginFiltersIsMutable() {
            Internal.ProtobufList<DataProto.DataOrigin> protobufList = this.dataOriginFilters_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataOriginFilters_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.set(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> iterable) {
            ensureDataOriginFiltersIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataOriginFilters_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOriginFilters() {
            this.dataOriginFilters_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOriginFilters(int i) {
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasAscOrdering() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean getAscOrdering() {
            return this.ascOrdering_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAscOrdering(boolean z) {
            this.bitField0_ |= 4;
            this.ascOrdering_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAscOrdering() {
            this.bitField0_ &= -5;
            this.ascOrdering_ = true;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasLimit() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int i) {
            this.bitField0_ |= 8;
            this.limit_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.bitField0_ &= -9;
            this.limit_ = 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasPageSize() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public int getPageSize() {
            return this.pageSize_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageSize(int i) {
            this.bitField0_ |= 16;
            this.pageSize_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageSize() {
            this.bitField0_ &= -17;
            this.pageSize_ = 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasPageToken() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public String getPageToken() {
            return this.pageToken_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public ByteString getPageTokenBytes() {
            return ByteString.copyFromUtf8(this.pageToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageToken(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.pageToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageToken() {
            this.bitField0_ &= -33;
            this.pageToken_ = getDefaultInstance().getPageToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageTokenBytes(ByteString byteString) {
            this.pageToken_ = byteString.toStringUtf8();
            this.bitField0_ |= 32;
        }

        public static ReadDataRangeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDataRangeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDataRangeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDataRangeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDataRangeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDataRangeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDataRangeRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataRangeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataRangeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataRangeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataRangeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDataRangeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataRangeRequest readDataRangeRequest) {
            return DEFAULT_INSTANCE.createBuilder(readDataRangeRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataRangeRequest, Builder> implements ReadDataRangeRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDataRangeRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasTimeSpec() {
                return ((ReadDataRangeRequest) this.instance).hasTimeSpec();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public TimeProto.TimeSpec getTimeSpec() {
                return ((ReadDataRangeRequest) this.instance).getTimeSpec();
            }

            public Builder setTimeSpec(TimeProto.TimeSpec timeSpec) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setTimeSpec(timeSpec);
                return this;
            }

            public Builder setTimeSpec(TimeProto.TimeSpec.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setTimeSpec(builder.build());
                return this;
            }

            public Builder mergeTimeSpec(TimeProto.TimeSpec timeSpec) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).mergeTimeSpec(timeSpec);
                return this;
            }

            public Builder clearTimeSpec() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearTimeSpec();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasDataType() {
                return ((ReadDataRangeRequest) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public DataProto.DataType getDataType() {
                return ((ReadDataRangeRequest) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataType(dataType);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataType(builder.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).mergeDataType(dataType);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public List<DataProto.DataOrigin> getDataOriginFiltersList() {
                return Collections.unmodifiableList(((ReadDataRangeRequest) this.instance).getDataOriginFiltersList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public int getDataOriginFiltersCount() {
                return ((ReadDataRangeRequest) this.instance).getDataOriginFiltersCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public DataProto.DataOrigin getDataOriginFilters(int i) {
                return ((ReadDataRangeRequest) this.instance).getDataOriginFilters(i);
            }

            public Builder setDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataOriginFilters(i, dataOrigin);
                return this;
            }

            public Builder setDataOriginFilters(int i, DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataOriginFilters(i, builder.build());
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(dataOrigin);
                return this;
            }

            public Builder addDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(i, dataOrigin);
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(builder.build());
                return this;
            }

            public Builder addDataOriginFilters(int i, DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(i, builder.build());
                return this;
            }

            public Builder addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> iterable) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addAllDataOriginFilters(iterable);
                return this;
            }

            public Builder clearDataOriginFilters() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearDataOriginFilters();
                return this;
            }

            public Builder removeDataOriginFilters(int i) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).removeDataOriginFilters(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasAscOrdering() {
                return ((ReadDataRangeRequest) this.instance).hasAscOrdering();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean getAscOrdering() {
                return ((ReadDataRangeRequest) this.instance).getAscOrdering();
            }

            public Builder setAscOrdering(boolean z) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setAscOrdering(z);
                return this;
            }

            public Builder clearAscOrdering() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearAscOrdering();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasLimit() {
                return ((ReadDataRangeRequest) this.instance).hasLimit();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public int getLimit() {
                return ((ReadDataRangeRequest) this.instance).getLimit();
            }

            public Builder setLimit(int i) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setLimit(i);
                return this;
            }

            public Builder clearLimit() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearLimit();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasPageSize() {
                return ((ReadDataRangeRequest) this.instance).hasPageSize();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public int getPageSize() {
                return ((ReadDataRangeRequest) this.instance).getPageSize();
            }

            public Builder setPageSize(int i) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setPageSize(i);
                return this;
            }

            public Builder clearPageSize() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearPageSize();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasPageToken() {
                return ((ReadDataRangeRequest) this.instance).hasPageToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public String getPageToken() {
                return ((ReadDataRangeRequest) this.instance).getPageToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public ByteString getPageTokenBytes() {
                return ((ReadDataRangeRequest) this.instance).getPageTokenBytes();
            }

            public Builder setPageToken(String str) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setPageToken(str);
                return this;
            }

            public Builder clearPageToken() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearPageToken();
                return this;
            }

            public Builder setPageTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setPageTokenBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDataRangeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007ဇ\u0002", new Object[]{"bitField0_", "timeSpec_", "dataType_", "dataOriginFilters_", DataProto.DataOrigin.class, "limit_", "pageSize_", "pageToken_", "ascOrdering_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDataRangeRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadDataRangeRequest.class) {
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
            ReadDataRangeRequest readDataRangeRequest = new ReadDataRangeRequest();
            DEFAULT_INSTANCE = readDataRangeRequest;
            GeneratedMessageLite.registerDefaultInstance(ReadDataRangeRequest.class, readDataRangeRequest);
        }

        public static ReadDataRangeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataRangeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateMetricSpec extends GeneratedMessageLite<AggregateMetricSpec, Builder> implements AggregateMetricSpecOrBuilder {
        public static final int AGGREGATION_TYPE_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_NAME_FIELD_NUMBER = 1;
        private static final AggregateMetricSpec DEFAULT_INSTANCE;
        public static final int FIELD_NAME_FIELD_NUMBER = 3;
        private static volatile Parser<AggregateMetricSpec> PARSER;
        private int bitField0_;
        private String dataTypeName_ = "";
        private String aggregationType_ = "";
        private String fieldName_ = "";

        private AggregateMetricSpec() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public boolean hasDataTypeName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public String getDataTypeName() {
            return this.dataTypeName_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public ByteString getDataTypeNameBytes() {
            return ByteString.copyFromUtf8(this.dataTypeName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypeName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.dataTypeName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataTypeName() {
            this.bitField0_ &= -2;
            this.dataTypeName_ = getDefaultInstance().getDataTypeName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypeNameBytes(ByteString byteString) {
            this.dataTypeName_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public boolean hasAggregationType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public String getAggregationType() {
            return this.aggregationType_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public ByteString getAggregationTypeBytes() {
            return ByteString.copyFromUtf8(this.aggregationType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregationType(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.aggregationType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAggregationType() {
            this.bitField0_ &= -3;
            this.aggregationType_ = getDefaultInstance().getAggregationType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregationTypeBytes(ByteString byteString) {
            this.aggregationType_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public boolean hasFieldName() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public String getFieldName() {
            return this.fieldName_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public ByteString getFieldNameBytes() {
            return ByteString.copyFromUtf8(this.fieldName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldName(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.fieldName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFieldName() {
            this.bitField0_ &= -5;
            this.fieldName_ = getDefaultInstance().getFieldName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldNameBytes(ByteString byteString) {
            this.fieldName_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static AggregateMetricSpec parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AggregateMetricSpec parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AggregateMetricSpec parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AggregateMetricSpec parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AggregateMetricSpec parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AggregateMetricSpec parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AggregateMetricSpec parseFrom(InputStream inputStream) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateMetricSpec parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateMetricSpec parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AggregateMetricSpec) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateMetricSpec parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateMetricSpec) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateMetricSpec parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AggregateMetricSpec parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateMetricSpec aggregateMetricSpec) {
            return DEFAULT_INSTANCE.createBuilder(aggregateMetricSpec);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateMetricSpec, Builder> implements AggregateMetricSpecOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(AggregateMetricSpec.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public boolean hasDataTypeName() {
                return ((AggregateMetricSpec) this.instance).hasDataTypeName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public String getDataTypeName() {
                return ((AggregateMetricSpec) this.instance).getDataTypeName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public ByteString getDataTypeNameBytes() {
                return ((AggregateMetricSpec) this.instance).getDataTypeNameBytes();
            }

            public Builder setDataTypeName(String str) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setDataTypeName(str);
                return this;
            }

            public Builder clearDataTypeName() {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).clearDataTypeName();
                return this;
            }

            public Builder setDataTypeNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setDataTypeNameBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public boolean hasAggregationType() {
                return ((AggregateMetricSpec) this.instance).hasAggregationType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public String getAggregationType() {
                return ((AggregateMetricSpec) this.instance).getAggregationType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public ByteString getAggregationTypeBytes() {
                return ((AggregateMetricSpec) this.instance).getAggregationTypeBytes();
            }

            public Builder setAggregationType(String str) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setAggregationType(str);
                return this;
            }

            public Builder clearAggregationType() {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).clearAggregationType();
                return this;
            }

            public Builder setAggregationTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setAggregationTypeBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public boolean hasFieldName() {
                return ((AggregateMetricSpec) this.instance).hasFieldName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public String getFieldName() {
                return ((AggregateMetricSpec) this.instance).getFieldName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public ByteString getFieldNameBytes() {
                return ((AggregateMetricSpec) this.instance).getFieldNameBytes();
            }

            public Builder setFieldName(String str) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setFieldName(str);
                return this;
            }

            public Builder clearFieldName() {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).clearFieldName();
                return this;
            }

            public Builder setFieldNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setFieldNameBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AggregateMetricSpec();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "dataTypeName_", "aggregationType_", "fieldName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AggregateMetricSpec> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AggregateMetricSpec.class) {
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
            AggregateMetricSpec aggregateMetricSpec = new AggregateMetricSpec();
            DEFAULT_INSTANCE = aggregateMetricSpec;
            GeneratedMessageLite.registerDefaultInstance(AggregateMetricSpec.class, aggregateMetricSpec);
        }

        public static AggregateMetricSpec getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateMetricSpec> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateDataRequest extends GeneratedMessageLite<AggregateDataRequest, Builder> implements AggregateDataRequestOrBuilder {
        public static final int DATA_ORIGIN_FIELD_NUMBER = 3;
        private static final AggregateDataRequest DEFAULT_INSTANCE;
        public static final int METRIC_SPEC_FIELD_NUMBER = 2;
        private static volatile Parser<AggregateDataRequest> PARSER = null;
        public static final int SLICE_DURATION_MILLIS_FIELD_NUMBER = 4;
        public static final int SLICE_PERIOD_FIELD_NUMBER = 5;
        public static final int TIME_SPEC_FIELD_NUMBER = 1;
        private int bitField0_;
        private long sliceDurationMillis_;
        private TimeProto.TimeSpec timeSpec_;
        private Internal.ProtobufList<AggregateMetricSpec> metricSpec_ = emptyProtobufList();
        private Internal.ProtobufList<DataProto.DataOrigin> dataOrigin_ = emptyProtobufList();
        private String slicePeriod_ = "";

        private AggregateDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public boolean hasTimeSpec() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public TimeProto.TimeSpec getTimeSpec() {
            TimeProto.TimeSpec timeSpec = this.timeSpec_;
            return timeSpec == null ? TimeProto.TimeSpec.getDefaultInstance() : timeSpec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeSpec(TimeProto.TimeSpec timeSpec) {
            timeSpec.getClass();
            this.timeSpec_ = timeSpec;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimeSpec(TimeProto.TimeSpec timeSpec) {
            timeSpec.getClass();
            TimeProto.TimeSpec timeSpec2 = this.timeSpec_;
            if (timeSpec2 != null && timeSpec2 != TimeProto.TimeSpec.getDefaultInstance()) {
                this.timeSpec_ = TimeProto.TimeSpec.newBuilder(this.timeSpec_).mergeFrom((TimeProto.TimeSpec.Builder) timeSpec).buildPartial();
            } else {
                this.timeSpec_ = timeSpec;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeSpec() {
            this.timeSpec_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public List<AggregateMetricSpec> getMetricSpecList() {
            return this.metricSpec_;
        }

        public List<? extends AggregateMetricSpecOrBuilder> getMetricSpecOrBuilderList() {
            return this.metricSpec_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public int getMetricSpecCount() {
            return this.metricSpec_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public AggregateMetricSpec getMetricSpec(int i) {
            return this.metricSpec_.get(i);
        }

        public AggregateMetricSpecOrBuilder getMetricSpecOrBuilder(int i) {
            return this.metricSpec_.get(i);
        }

        private void ensureMetricSpecIsMutable() {
            Internal.ProtobufList<AggregateMetricSpec> protobufList = this.metricSpec_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.metricSpec_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetricSpec(int i, AggregateMetricSpec aggregateMetricSpec) {
            aggregateMetricSpec.getClass();
            ensureMetricSpecIsMutable();
            this.metricSpec_.set(i, aggregateMetricSpec);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetricSpec(AggregateMetricSpec aggregateMetricSpec) {
            aggregateMetricSpec.getClass();
            ensureMetricSpecIsMutable();
            this.metricSpec_.add(aggregateMetricSpec);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetricSpec(int i, AggregateMetricSpec aggregateMetricSpec) {
            aggregateMetricSpec.getClass();
            ensureMetricSpecIsMutable();
            this.metricSpec_.add(i, aggregateMetricSpec);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMetricSpec(Iterable<? extends AggregateMetricSpec> iterable) {
            ensureMetricSpecIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.metricSpec_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetricSpec() {
            this.metricSpec_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMetricSpec(int i) {
            ensureMetricSpecIsMutable();
            this.metricSpec_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public List<DataProto.DataOrigin> getDataOriginList() {
            return this.dataOrigin_;
        }

        public List<? extends DataProto.DataOriginOrBuilder> getDataOriginOrBuilderList() {
            return this.dataOrigin_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public int getDataOriginCount() {
            return this.dataOrigin_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public DataProto.DataOrigin getDataOrigin(int i) {
            return this.dataOrigin_.get(i);
        }

        public DataProto.DataOriginOrBuilder getDataOriginOrBuilder(int i) {
            return this.dataOrigin_.get(i);
        }

        private void ensureDataOriginIsMutable() {
            Internal.ProtobufList<DataProto.DataOrigin> protobufList = this.dataOrigin_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataOrigin_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOrigin(int i, DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginIsMutable();
            this.dataOrigin_.set(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigin(DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginIsMutable();
            this.dataOrigin_.add(dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigin(int i, DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginIsMutable();
            this.dataOrigin_.add(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOrigin(Iterable<? extends DataProto.DataOrigin> iterable) {
            ensureDataOriginIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataOrigin_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOrigin() {
            this.dataOrigin_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOrigin(int i) {
            ensureDataOriginIsMutable();
            this.dataOrigin_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public boolean hasSliceDurationMillis() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public long getSliceDurationMillis() {
            return this.sliceDurationMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSliceDurationMillis(long j) {
            this.bitField0_ |= 2;
            this.sliceDurationMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSliceDurationMillis() {
            this.bitField0_ &= -3;
            this.sliceDurationMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public boolean hasSlicePeriod() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public String getSlicePeriod() {
            return this.slicePeriod_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public ByteString getSlicePeriodBytes() {
            return ByteString.copyFromUtf8(this.slicePeriod_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlicePeriod(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.slicePeriod_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSlicePeriod() {
            this.bitField0_ &= -5;
            this.slicePeriod_ = getDefaultInstance().getSlicePeriod();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlicePeriodBytes(ByteString byteString) {
            this.slicePeriod_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static AggregateDataRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AggregateDataRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AggregateDataRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AggregateDataRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AggregateDataRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AggregateDataRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AggregateDataRequest parseFrom(InputStream inputStream) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateDataRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateDataRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AggregateDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateDataRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateDataRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AggregateDataRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateDataRequest aggregateDataRequest) {
            return DEFAULT_INSTANCE.createBuilder(aggregateDataRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateDataRequest, Builder> implements AggregateDataRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(AggregateDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public boolean hasTimeSpec() {
                return ((AggregateDataRequest) this.instance).hasTimeSpec();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public TimeProto.TimeSpec getTimeSpec() {
                return ((AggregateDataRequest) this.instance).getTimeSpec();
            }

            public Builder setTimeSpec(TimeProto.TimeSpec timeSpec) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setTimeSpec(timeSpec);
                return this;
            }

            public Builder setTimeSpec(TimeProto.TimeSpec.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setTimeSpec(builder.build());
                return this;
            }

            public Builder mergeTimeSpec(TimeProto.TimeSpec timeSpec) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).mergeTimeSpec(timeSpec);
                return this;
            }

            public Builder clearTimeSpec() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearTimeSpec();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public List<AggregateMetricSpec> getMetricSpecList() {
                return Collections.unmodifiableList(((AggregateDataRequest) this.instance).getMetricSpecList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public int getMetricSpecCount() {
                return ((AggregateDataRequest) this.instance).getMetricSpecCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public AggregateMetricSpec getMetricSpec(int i) {
                return ((AggregateDataRequest) this.instance).getMetricSpec(i);
            }

            public Builder setMetricSpec(int i, AggregateMetricSpec aggregateMetricSpec) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setMetricSpec(i, aggregateMetricSpec);
                return this;
            }

            public Builder setMetricSpec(int i, AggregateMetricSpec.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setMetricSpec(i, builder.build());
                return this;
            }

            public Builder addMetricSpec(AggregateMetricSpec aggregateMetricSpec) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(aggregateMetricSpec);
                return this;
            }

            public Builder addMetricSpec(int i, AggregateMetricSpec aggregateMetricSpec) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(i, aggregateMetricSpec);
                return this;
            }

            public Builder addMetricSpec(AggregateMetricSpec.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(builder.build());
                return this;
            }

            public Builder addMetricSpec(int i, AggregateMetricSpec.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(i, builder.build());
                return this;
            }

            public Builder addAllMetricSpec(Iterable<? extends AggregateMetricSpec> iterable) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addAllMetricSpec(iterable);
                return this;
            }

            public Builder clearMetricSpec() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearMetricSpec();
                return this;
            }

            public Builder removeMetricSpec(int i) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).removeMetricSpec(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public List<DataProto.DataOrigin> getDataOriginList() {
                return Collections.unmodifiableList(((AggregateDataRequest) this.instance).getDataOriginList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public int getDataOriginCount() {
                return ((AggregateDataRequest) this.instance).getDataOriginCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public DataProto.DataOrigin getDataOrigin(int i) {
                return ((AggregateDataRequest) this.instance).getDataOrigin(i);
            }

            public Builder setDataOrigin(int i, DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setDataOrigin(i, dataOrigin);
                return this;
            }

            public Builder setDataOrigin(int i, DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setDataOrigin(i, builder.build());
                return this;
            }

            public Builder addDataOrigin(DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(dataOrigin);
                return this;
            }

            public Builder addDataOrigin(int i, DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(i, dataOrigin);
                return this;
            }

            public Builder addDataOrigin(DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(builder.build());
                return this;
            }

            public Builder addDataOrigin(int i, DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(i, builder.build());
                return this;
            }

            public Builder addAllDataOrigin(Iterable<? extends DataProto.DataOrigin> iterable) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addAllDataOrigin(iterable);
                return this;
            }

            public Builder clearDataOrigin() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearDataOrigin();
                return this;
            }

            public Builder removeDataOrigin(int i) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).removeDataOrigin(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public boolean hasSliceDurationMillis() {
                return ((AggregateDataRequest) this.instance).hasSliceDurationMillis();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public long getSliceDurationMillis() {
                return ((AggregateDataRequest) this.instance).getSliceDurationMillis();
            }

            public Builder setSliceDurationMillis(long j) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setSliceDurationMillis(j);
                return this;
            }

            public Builder clearSliceDurationMillis() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearSliceDurationMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public boolean hasSlicePeriod() {
                return ((AggregateDataRequest) this.instance).hasSlicePeriod();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public String getSlicePeriod() {
                return ((AggregateDataRequest) this.instance).getSlicePeriod();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public ByteString getSlicePeriodBytes() {
                return ((AggregateDataRequest) this.instance).getSlicePeriodBytes();
            }

            public Builder setSlicePeriod(String str) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setSlicePeriod(str);
                return this;
            }

            public Builder clearSlicePeriod() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearSlicePeriod();
                return this;
            }

            public Builder setSlicePeriodBytes(ByteString byteString) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setSlicePeriodBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AggregateDataRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဈ\u0002", new Object[]{"bitField0_", "timeSpec_", "metricSpec_", AggregateMetricSpec.class, "dataOrigin_", DataProto.DataOrigin.class, "sliceDurationMillis_", "slicePeriod_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AggregateDataRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AggregateDataRequest.class) {
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
            AggregateDataRequest aggregateDataRequest = new AggregateDataRequest();
            DEFAULT_INSTANCE = aggregateDataRequest;
            GeneratedMessageLite.registerDefaultInstance(AggregateDataRequest.class, aggregateDataRequest);
        }

        public static AggregateDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesTokenRequest extends GeneratedMessageLite<GetChangesTokenRequest, Builder> implements GetChangesTokenRequestOrBuilder {
        public static final int DATA_ORIGIN_FILTERS_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final GetChangesTokenRequest DEFAULT_INSTANCE;
        private static volatile Parser<GetChangesTokenRequest> PARSER;
        private Internal.ProtobufList<DataProto.DataType> dataType_ = emptyProtobufList();
        private Internal.ProtobufList<DataProto.DataOrigin> dataOriginFilters_ = emptyProtobufList();

        private GetChangesTokenRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public List<DataProto.DataType> getDataTypeList() {
            return this.dataType_;
        }

        public List<? extends DataProto.DataTypeOrBuilder> getDataTypeOrBuilderList() {
            return this.dataType_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public int getDataTypeCount() {
            return this.dataType_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public DataProto.DataType getDataType(int i) {
            return this.dataType_.get(i);
        }

        public DataProto.DataTypeOrBuilder getDataTypeOrBuilder(int i) {
            return this.dataType_.get(i);
        }

        private void ensureDataTypeIsMutable() {
            Internal.ProtobufList<DataProto.DataType> protobufList = this.dataType_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataType_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(int i, DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.set(i, dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(int i, DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(i, dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataType(Iterable<? extends DataProto.DataType> iterable) {
            ensureDataTypeIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataType(int i) {
            ensureDataTypeIsMutable();
            this.dataType_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public List<DataProto.DataOrigin> getDataOriginFiltersList() {
            return this.dataOriginFilters_;
        }

        public List<? extends DataProto.DataOriginOrBuilder> getDataOriginFiltersOrBuilderList() {
            return this.dataOriginFilters_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public int getDataOriginFiltersCount() {
            return this.dataOriginFilters_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public DataProto.DataOrigin getDataOriginFilters(int i) {
            return this.dataOriginFilters_.get(i);
        }

        public DataProto.DataOriginOrBuilder getDataOriginFiltersOrBuilder(int i) {
            return this.dataOriginFilters_.get(i);
        }

        private void ensureDataOriginFiltersIsMutable() {
            Internal.ProtobufList<DataProto.DataOrigin> protobufList = this.dataOriginFilters_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataOriginFilters_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.set(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> iterable) {
            ensureDataOriginFiltersIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataOriginFilters_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOriginFilters() {
            this.dataOriginFilters_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOriginFilters(int i) {
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.remove(i);
        }

        public static GetChangesTokenRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GetChangesTokenRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetChangesTokenRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetChangesTokenRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetChangesTokenRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetChangesTokenRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetChangesTokenRequest parseFrom(InputStream inputStream) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesTokenRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesTokenRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetChangesTokenRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesTokenRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesTokenRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesTokenRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetChangesTokenRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesTokenRequest getChangesTokenRequest) {
            return DEFAULT_INSTANCE.createBuilder(getChangesTokenRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesTokenRequest, Builder> implements GetChangesTokenRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(GetChangesTokenRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public List<DataProto.DataType> getDataTypeList() {
                return Collections.unmodifiableList(((GetChangesTokenRequest) this.instance).getDataTypeList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public int getDataTypeCount() {
                return ((GetChangesTokenRequest) this.instance).getDataTypeCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public DataProto.DataType getDataType(int i) {
                return ((GetChangesTokenRequest) this.instance).getDataType(i);
            }

            public Builder setDataType(int i, DataProto.DataType dataType) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataType(i, dataType);
                return this;
            }

            public Builder setDataType(int i, DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataType(i, builder.build());
                return this;
            }

            public Builder addDataType(DataProto.DataType dataType) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(dataType);
                return this;
            }

            public Builder addDataType(int i, DataProto.DataType dataType) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(i, dataType);
                return this;
            }

            public Builder addDataType(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(builder.build());
                return this;
            }

            public Builder addDataType(int i, DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(i, builder.build());
                return this;
            }

            public Builder addAllDataType(Iterable<? extends DataProto.DataType> iterable) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addAllDataType(iterable);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).clearDataType();
                return this;
            }

            public Builder removeDataType(int i) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).removeDataType(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public List<DataProto.DataOrigin> getDataOriginFiltersList() {
                return Collections.unmodifiableList(((GetChangesTokenRequest) this.instance).getDataOriginFiltersList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public int getDataOriginFiltersCount() {
                return ((GetChangesTokenRequest) this.instance).getDataOriginFiltersCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public DataProto.DataOrigin getDataOriginFilters(int i) {
                return ((GetChangesTokenRequest) this.instance).getDataOriginFilters(i);
            }

            public Builder setDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataOriginFilters(i, dataOrigin);
                return this;
            }

            public Builder setDataOriginFilters(int i, DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataOriginFilters(i, builder.build());
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(dataOrigin);
                return this;
            }

            public Builder addDataOriginFilters(int i, DataProto.DataOrigin dataOrigin) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(i, dataOrigin);
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(builder.build());
                return this;
            }

            public Builder addDataOriginFilters(int i, DataProto.DataOrigin.Builder builder) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(i, builder.build());
                return this;
            }

            public Builder addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> iterable) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addAllDataOriginFilters(iterable);
                return this;
            }

            public Builder clearDataOriginFilters() {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).clearDataOriginFilters();
                return this;
            }

            public Builder removeDataOriginFilters(int i) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).removeDataOriginFilters(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetChangesTokenRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"dataType_", DataProto.DataType.class, "dataOriginFilters_", DataProto.DataOrigin.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetChangesTokenRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (GetChangesTokenRequest.class) {
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
            GetChangesTokenRequest getChangesTokenRequest = new GetChangesTokenRequest();
            DEFAULT_INSTANCE = getChangesTokenRequest;
            GeneratedMessageLite.registerDefaultInstance(GetChangesTokenRequest.class, getChangesTokenRequest);
        }

        public static GetChangesTokenRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesTokenRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesRequest extends GeneratedMessageLite<GetChangesRequest, Builder> implements GetChangesRequestOrBuilder {
        public static final int CHANGES_TOKEN_FIELD_NUMBER = 1;
        private static final GetChangesRequest DEFAULT_INSTANCE;
        private static volatile Parser<GetChangesRequest> PARSER;
        private int bitField0_;
        private String changesToken_ = "";

        private GetChangesRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
        public boolean hasChangesToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
        public String getChangesToken() {
            return this.changesToken_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
        public ByteString getChangesTokenBytes() {
            return ByteString.copyFromUtf8(this.changesToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChangesToken(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.changesToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChangesToken() {
            this.bitField0_ &= -2;
            this.changesToken_ = getDefaultInstance().getChangesToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChangesTokenBytes(ByteString byteString) {
            this.changesToken_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static GetChangesRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GetChangesRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetChangesRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetChangesRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetChangesRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetChangesRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetChangesRequest parseFrom(InputStream inputStream) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetChangesRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetChangesRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesRequest getChangesRequest) {
            return DEFAULT_INSTANCE.createBuilder(getChangesRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesRequest, Builder> implements GetChangesRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(GetChangesRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
            public boolean hasChangesToken() {
                return ((GetChangesRequest) this.instance).hasChangesToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
            public String getChangesToken() {
                return ((GetChangesRequest) this.instance).getChangesToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
            public ByteString getChangesTokenBytes() {
                return ((GetChangesRequest) this.instance).getChangesTokenBytes();
            }

            public Builder setChangesToken(String str) {
                copyOnWrite();
                ((GetChangesRequest) this.instance).setChangesToken(str);
                return this;
            }

            public Builder clearChangesToken() {
                copyOnWrite();
                ((GetChangesRequest) this.instance).clearChangesToken();
                return this;
            }

            public Builder setChangesTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((GetChangesRequest) this.instance).setChangesTokenBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetChangesRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "changesToken_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetChangesRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (GetChangesRequest.class) {
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
            GetChangesRequest getChangesRequest = new GetChangesRequest();
            DEFAULT_INSTANCE = getChangesRequest;
            GeneratedMessageLite.registerDefaultInstance(GetChangesRequest.class, getChangesRequest);
        }

        public static GetChangesRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RegisterForDataNotificationsRequest extends GeneratedMessageLite<RegisterForDataNotificationsRequest, Builder> implements RegisterForDataNotificationsRequestOrBuilder {
        public static final int DATA_TYPES_FIELD_NUMBER = 2;
        private static final RegisterForDataNotificationsRequest DEFAULT_INSTANCE;
        public static final int NOTIFICATIONINTENTACTION_FIELD_NUMBER = 1;
        private static volatile Parser<RegisterForDataNotificationsRequest> PARSER;
        private int bitField0_;
        private String notificationIntentAction_ = "";
        private Internal.ProtobufList<DataProto.DataType> dataTypes_ = emptyProtobufList();

        private RegisterForDataNotificationsRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public boolean hasNotificationIntentAction() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public String getNotificationIntentAction() {
            return this.notificationIntentAction_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public ByteString getNotificationIntentActionBytes() {
            return ByteString.copyFromUtf8(this.notificationIntentAction_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentAction(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.notificationIntentAction_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNotificationIntentAction() {
            this.bitField0_ &= -2;
            this.notificationIntentAction_ = getDefaultInstance().getNotificationIntentAction();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentActionBytes(ByteString byteString) {
            this.notificationIntentAction_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public List<DataProto.DataType> getDataTypesList() {
            return this.dataTypes_;
        }

        public List<? extends DataProto.DataTypeOrBuilder> getDataTypesOrBuilderList() {
            return this.dataTypes_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public int getDataTypesCount() {
            return this.dataTypes_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public DataProto.DataType getDataTypes(int i) {
            return this.dataTypes_.get(i);
        }

        public DataProto.DataTypeOrBuilder getDataTypesOrBuilder(int i) {
            return this.dataTypes_.get(i);
        }

        private void ensureDataTypesIsMutable() {
            Internal.ProtobufList<DataProto.DataType> protobufList = this.dataTypes_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataTypes_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypes(int i, DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypesIsMutable();
            this.dataTypes_.set(i, dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataTypes(DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypesIsMutable();
            this.dataTypes_.add(dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataTypes(int i, DataProto.DataType dataType) {
            dataType.getClass();
            ensureDataTypesIsMutable();
            this.dataTypes_.add(i, dataType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataTypes(Iterable<? extends DataProto.DataType> iterable) {
            ensureDataTypesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataTypes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataTypes() {
            this.dataTypes_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataTypes(int i) {
            ensureDataTypesIsMutable();
            this.dataTypes_.remove(i);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RegisterForDataNotificationsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RegisterForDataNotificationsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RegisterForDataNotificationsRequest parseFrom(InputStream inputStream) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RegisterForDataNotificationsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RegisterForDataNotificationsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RegisterForDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RegisterForDataNotificationsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterForDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RegisterForDataNotificationsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RegisterForDataNotificationsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RegisterForDataNotificationsRequest registerForDataNotificationsRequest) {
            return DEFAULT_INSTANCE.createBuilder(registerForDataNotificationsRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RegisterForDataNotificationsRequest, Builder> implements RegisterForDataNotificationsRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(RegisterForDataNotificationsRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public boolean hasNotificationIntentAction() {
                return ((RegisterForDataNotificationsRequest) this.instance).hasNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public String getNotificationIntentAction() {
                return ((RegisterForDataNotificationsRequest) this.instance).getNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public ByteString getNotificationIntentActionBytes() {
                return ((RegisterForDataNotificationsRequest) this.instance).getNotificationIntentActionBytes();
            }

            public Builder setNotificationIntentAction(String str) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setNotificationIntentAction(str);
                return this;
            }

            public Builder clearNotificationIntentAction() {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).clearNotificationIntentAction();
                return this;
            }

            public Builder setNotificationIntentActionBytes(ByteString byteString) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setNotificationIntentActionBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public List<DataProto.DataType> getDataTypesList() {
                return Collections.unmodifiableList(((RegisterForDataNotificationsRequest) this.instance).getDataTypesList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public int getDataTypesCount() {
                return ((RegisterForDataNotificationsRequest) this.instance).getDataTypesCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public DataProto.DataType getDataTypes(int i) {
                return ((RegisterForDataNotificationsRequest) this.instance).getDataTypes(i);
            }

            public Builder setDataTypes(int i, DataProto.DataType dataType) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setDataTypes(i, dataType);
                return this;
            }

            public Builder setDataTypes(int i, DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setDataTypes(i, builder.build());
                return this;
            }

            public Builder addDataTypes(DataProto.DataType dataType) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(dataType);
                return this;
            }

            public Builder addDataTypes(int i, DataProto.DataType dataType) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(i, dataType);
                return this;
            }

            public Builder addDataTypes(DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(builder.build());
                return this;
            }

            public Builder addDataTypes(int i, DataProto.DataType.Builder builder) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(i, builder.build());
                return this;
            }

            public Builder addAllDataTypes(Iterable<? extends DataProto.DataType> iterable) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addAllDataTypes(iterable);
                return this;
            }

            public Builder clearDataTypes() {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).clearDataTypes();
                return this;
            }

            public Builder removeDataTypes(int i) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).removeDataTypes(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new RegisterForDataNotificationsRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"bitField0_", "notificationIntentAction_", "dataTypes_", DataProto.DataType.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RegisterForDataNotificationsRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (RegisterForDataNotificationsRequest.class) {
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
            RegisterForDataNotificationsRequest registerForDataNotificationsRequest = new RegisterForDataNotificationsRequest();
            DEFAULT_INSTANCE = registerForDataNotificationsRequest;
            GeneratedMessageLite.registerDefaultInstance(RegisterForDataNotificationsRequest.class, registerForDataNotificationsRequest);
        }

        public static RegisterForDataNotificationsRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RegisterForDataNotificationsRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UnregisterFromDataNotificationsRequest extends GeneratedMessageLite<UnregisterFromDataNotificationsRequest, Builder> implements UnregisterFromDataNotificationsRequestOrBuilder {
        private static final UnregisterFromDataNotificationsRequest DEFAULT_INSTANCE;
        public static final int NOTIFICATIONINTENTACTION_FIELD_NUMBER = 1;
        private static volatile Parser<UnregisterFromDataNotificationsRequest> PARSER;
        private int bitField0_;
        private String notificationIntentAction_ = "";

        private UnregisterFromDataNotificationsRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
        public boolean hasNotificationIntentAction() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
        public String getNotificationIntentAction() {
            return this.notificationIntentAction_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
        public ByteString getNotificationIntentActionBytes() {
            return ByteString.copyFromUtf8(this.notificationIntentAction_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentAction(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.notificationIntentAction_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNotificationIntentAction() {
            this.bitField0_ &= -2;
            this.notificationIntentAction_ = getDefaultInstance().getNotificationIntentAction();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentActionBytes(ByteString byteString) {
            this.notificationIntentAction_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(InputStream inputStream) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnregisterFromDataNotificationsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UnregisterFromDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UnregisterFromDataNotificationsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnregisterFromDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UnregisterFromDataNotificationsRequest unregisterFromDataNotificationsRequest) {
            return DEFAULT_INSTANCE.createBuilder(unregisterFromDataNotificationsRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UnregisterFromDataNotificationsRequest, Builder> implements UnregisterFromDataNotificationsRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UnregisterFromDataNotificationsRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
            public boolean hasNotificationIntentAction() {
                return ((UnregisterFromDataNotificationsRequest) this.instance).hasNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
            public String getNotificationIntentAction() {
                return ((UnregisterFromDataNotificationsRequest) this.instance).getNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
            public ByteString getNotificationIntentActionBytes() {
                return ((UnregisterFromDataNotificationsRequest) this.instance).getNotificationIntentActionBytes();
            }

            public Builder setNotificationIntentAction(String str) {
                copyOnWrite();
                ((UnregisterFromDataNotificationsRequest) this.instance).setNotificationIntentAction(str);
                return this;
            }

            public Builder clearNotificationIntentAction() {
                copyOnWrite();
                ((UnregisterFromDataNotificationsRequest) this.instance).clearNotificationIntentAction();
                return this;
            }

            public Builder setNotificationIntentActionBytes(ByteString byteString) {
                copyOnWrite();
                ((UnregisterFromDataNotificationsRequest) this.instance).setNotificationIntentActionBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UnregisterFromDataNotificationsRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "notificationIntentAction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UnregisterFromDataNotificationsRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (UnregisterFromDataNotificationsRequest.class) {
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
            UnregisterFromDataNotificationsRequest unregisterFromDataNotificationsRequest = new UnregisterFromDataNotificationsRequest();
            DEFAULT_INSTANCE = unregisterFromDataNotificationsRequest;
            GeneratedMessageLite.registerDefaultInstance(UnregisterFromDataNotificationsRequest.class, unregisterFromDataNotificationsRequest);
        }

        public static UnregisterFromDataNotificationsRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnregisterFromDataNotificationsRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UpsertExerciseRouteRequest extends GeneratedMessageLite<UpsertExerciseRouteRequest, Builder> implements UpsertExerciseRouteRequestOrBuilder {
        private static final UpsertExerciseRouteRequest DEFAULT_INSTANCE;
        public static final int EXERCISEROUTE_FIELD_NUMBER = 2;
        private static volatile Parser<UpsertExerciseRouteRequest> PARSER = null;
        public static final int SESSIONUID_FIELD_NUMBER = 1;
        private int bitField0_;
        private DataProto.DataPoint exerciseRoute_;
        private String sessionUid_ = "";

        private UpsertExerciseRouteRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public boolean hasSessionUid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public String getSessionUid() {
            return this.sessionUid_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public ByteString getSessionUidBytes() {
            return ByteString.copyFromUtf8(this.sessionUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.sessionUid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionUid() {
            this.bitField0_ &= -2;
            this.sessionUid_ = getDefaultInstance().getSessionUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUidBytes(ByteString byteString) {
            this.sessionUid_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public boolean hasExerciseRoute() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public DataProto.DataPoint getExerciseRoute() {
            DataProto.DataPoint dataPoint = this.exerciseRoute_;
            return dataPoint == null ? DataProto.DataPoint.getDefaultInstance() : dataPoint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExerciseRoute(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            this.exerciseRoute_ = dataPoint;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExerciseRoute(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            DataProto.DataPoint dataPoint2 = this.exerciseRoute_;
            if (dataPoint2 != null && dataPoint2 != DataProto.DataPoint.getDefaultInstance()) {
                this.exerciseRoute_ = DataProto.DataPoint.newBuilder(this.exerciseRoute_).mergeFrom((DataProto.DataPoint.Builder) dataPoint).buildPartial();
            } else {
                this.exerciseRoute_ = dataPoint;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExerciseRoute() {
            this.exerciseRoute_ = null;
            this.bitField0_ &= -3;
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UpsertExerciseRouteRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UpsertExerciseRouteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UpsertExerciseRouteRequest parseFrom(InputStream inputStream) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpsertExerciseRouteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UpsertExerciseRouteRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UpsertExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpsertExerciseRouteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UpsertExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UpsertExerciseRouteRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UpsertExerciseRouteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UpsertExerciseRouteRequest upsertExerciseRouteRequest) {
            return DEFAULT_INSTANCE.createBuilder(upsertExerciseRouteRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UpsertExerciseRouteRequest, Builder> implements UpsertExerciseRouteRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(UpsertExerciseRouteRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public boolean hasSessionUid() {
                return ((UpsertExerciseRouteRequest) this.instance).hasSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public String getSessionUid() {
                return ((UpsertExerciseRouteRequest) this.instance).getSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public ByteString getSessionUidBytes() {
                return ((UpsertExerciseRouteRequest) this.instance).getSessionUidBytes();
            }

            public Builder setSessionUid(String str) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setSessionUid(str);
                return this;
            }

            public Builder clearSessionUid() {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).clearSessionUid();
                return this;
            }

            public Builder setSessionUidBytes(ByteString byteString) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setSessionUidBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public boolean hasExerciseRoute() {
                return ((UpsertExerciseRouteRequest) this.instance).hasExerciseRoute();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public DataProto.DataPoint getExerciseRoute() {
                return ((UpsertExerciseRouteRequest) this.instance).getExerciseRoute();
            }

            public Builder setExerciseRoute(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setExerciseRoute(dataPoint);
                return this;
            }

            public Builder setExerciseRoute(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setExerciseRoute(builder.build());
                return this;
            }

            public Builder mergeExerciseRoute(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).mergeExerciseRoute(dataPoint);
                return this;
            }

            public Builder clearExerciseRoute() {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).clearExerciseRoute();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UpsertExerciseRouteRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "sessionUid_", "exerciseRoute_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UpsertExerciseRouteRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (UpsertExerciseRouteRequest.class) {
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
            UpsertExerciseRouteRequest upsertExerciseRouteRequest = new UpsertExerciseRouteRequest();
            DEFAULT_INSTANCE = upsertExerciseRouteRequest;
            GeneratedMessageLite.registerDefaultInstance(UpsertExerciseRouteRequest.class, upsertExerciseRouteRequest);
        }

        public static UpsertExerciseRouteRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpsertExerciseRouteRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadExerciseRouteRequest extends GeneratedMessageLite<ReadExerciseRouteRequest, Builder> implements ReadExerciseRouteRequestOrBuilder {
        private static final ReadExerciseRouteRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadExerciseRouteRequest> PARSER = null;
        public static final int SESSIONUID_FIELD_NUMBER = 1;
        private int bitField0_;
        private String sessionUid_ = "";

        private ReadExerciseRouteRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
        public boolean hasSessionUid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
        public String getSessionUid() {
            return this.sessionUid_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
        public ByteString getSessionUidBytes() {
            return ByteString.copyFromUtf8(this.sessionUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.sessionUid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionUid() {
            this.bitField0_ &= -2;
            this.sessionUid_ = getDefaultInstance().getSessionUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUidBytes(ByteString byteString) {
            this.sessionUid_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static ReadExerciseRouteRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadExerciseRouteRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadExerciseRouteRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadExerciseRouteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadExerciseRouteRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadExerciseRouteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadExerciseRouteRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadExerciseRouteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadExerciseRouteRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadExerciseRouteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadExerciseRouteRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadExerciseRouteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadExerciseRouteRequest readExerciseRouteRequest) {
            return DEFAULT_INSTANCE.createBuilder(readExerciseRouteRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadExerciseRouteRequest, Builder> implements ReadExerciseRouteRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadExerciseRouteRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
            public boolean hasSessionUid() {
                return ((ReadExerciseRouteRequest) this.instance).hasSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
            public String getSessionUid() {
                return ((ReadExerciseRouteRequest) this.instance).getSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
            public ByteString getSessionUidBytes() {
                return ((ReadExerciseRouteRequest) this.instance).getSessionUidBytes();
            }

            public Builder setSessionUid(String str) {
                copyOnWrite();
                ((ReadExerciseRouteRequest) this.instance).setSessionUid(str);
                return this;
            }

            public Builder clearSessionUid() {
                copyOnWrite();
                ((ReadExerciseRouteRequest) this.instance).clearSessionUid();
                return this;
            }

            public Builder setSessionUidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadExerciseRouteRequest) this.instance).setSessionUidBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadExerciseRouteRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "sessionUid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadExerciseRouteRequest> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadExerciseRouteRequest.class) {
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
            ReadExerciseRouteRequest readExerciseRouteRequest = new ReadExerciseRouteRequest();
            DEFAULT_INSTANCE = readExerciseRouteRequest;
            GeneratedMessageLite.registerDefaultInstance(ReadExerciseRouteRequest.class, readExerciseRouteRequest);
        }

        public static ReadExerciseRouteRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadExerciseRouteRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
