package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.ChangeProto;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ResponseProto {

    public interface AggregateDataResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.AggregateDataRow getRows(int i);

        int getRowsCount();

        List<DataProto.AggregateDataRow> getRowsList();
    }

    public interface GetChangesResponseOrBuilder extends MessageLiteOrBuilder {
        ChangeProto.DataChange getChanges(int i);

        int getChangesCount();

        List<ChangeProto.DataChange> getChangesList();

        boolean getChangesTokenExpired();

        boolean getHasMore();

        String getNextChangesToken();

        ByteString getNextChangesTokenBytes();

        boolean hasChangesTokenExpired();

        boolean hasHasMore();

        boolean hasNextChangesToken();
    }

    public interface GetChangesTokenResponseOrBuilder extends MessageLiteOrBuilder {
        String getChangesToken();

        ByteString getChangesTokenBytes();

        boolean hasChangesToken();
    }

    public interface InsertDataResponseOrBuilder extends MessageLiteOrBuilder {
        String getDataPointUid(int i);

        ByteString getDataPointUidBytes(int i);

        int getDataPointUidCount();

        List<String> getDataPointUidList();
    }

    public interface ReadDataPointResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getData();

        boolean hasData();
    }

    public interface ReadDataRangeResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint(int i);

        int getDataPointCount();

        List<DataProto.DataPoint> getDataPointList();

        String getPageToken();

        ByteString getPageTokenBytes();

        boolean hasPageToken();
    }

    public interface ReadDataResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint();

        boolean hasDataPoint();
    }

    public interface ReadExerciseRouteResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint();

        boolean hasDataPoint();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ResponseProto() {
    }

    public static final class ReadDataPointResponse extends GeneratedMessageLite<ReadDataPointResponse, Builder> implements ReadDataPointResponseOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final ReadDataPointResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataPointResponse> PARSER;
        private int bitField0_;
        private DataProto.DataPoint data_;

        private ReadDataPointResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
        public boolean hasData() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
        public DataProto.DataPoint getData() {
            DataProto.DataPoint dataPoint = this.data_;
            return dataPoint == null ? DataProto.DataPoint.getDefaultInstance() : dataPoint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            this.data_ = dataPoint;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeData(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            DataProto.DataPoint dataPoint2 = this.data_;
            if (dataPoint2 != null && dataPoint2 != DataProto.DataPoint.getDefaultInstance()) {
                this.data_ = DataProto.DataPoint.newBuilder(this.data_).mergeFrom((DataProto.DataPoint.Builder) dataPoint).buildPartial();
            } else {
                this.data_ = dataPoint;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = null;
            this.bitField0_ &= -2;
        }

        public static ReadDataPointResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDataPointResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDataPointResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDataPointResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDataPointResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDataPointResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDataPointResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataPointResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataPointResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDataPointResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataPointResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataPointResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataPointResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDataPointResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataPointResponse readDataPointResponse) {
            return DEFAULT_INSTANCE.createBuilder(readDataPointResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataPointResponse, Builder> implements ReadDataPointResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDataPointResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
            public boolean hasData() {
                return ((ReadDataPointResponse) this.instance).hasData();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
            public DataProto.DataPoint getData() {
                return ((ReadDataPointResponse) this.instance).getData();
            }

            public Builder setData(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).setData(dataPoint);
                return this;
            }

            public Builder setData(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).setData(builder.build());
                return this;
            }

            public Builder mergeData(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).mergeData(dataPoint);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).clearData();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDataPointResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDataPointResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadDataPointResponse.class) {
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
            ReadDataPointResponse readDataPointResponse = new ReadDataPointResponse();
            DEFAULT_INSTANCE = readDataPointResponse;
            GeneratedMessageLite.registerDefaultInstance(ReadDataPointResponse.class, readDataPointResponse);
        }

        public static ReadDataPointResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataPointResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: androidx.health.platform.client.proto.ResponseProto$1, reason: invalid class name */
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

    public static final class InsertDataResponse extends GeneratedMessageLite<InsertDataResponse, Builder> implements InsertDataResponseOrBuilder {
        public static final int DATA_POINT_UID_FIELD_NUMBER = 1;
        private static final InsertDataResponse DEFAULT_INSTANCE;
        private static volatile Parser<InsertDataResponse> PARSER;
        private Internal.ProtobufList<String> dataPointUid_ = GeneratedMessageLite.emptyProtobufList();

        private InsertDataResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public List<String> getDataPointUidList() {
            return this.dataPointUid_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public int getDataPointUidCount() {
            return this.dataPointUid_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public String getDataPointUid(int i) {
            return this.dataPointUid_.get(i);
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public ByteString getDataPointUidBytes(int i) {
            return ByteString.copyFromUtf8(this.dataPointUid_.get(i));
        }

        private void ensureDataPointUidIsMutable() {
            Internal.ProtobufList<String> protobufList = this.dataPointUid_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataPointUid_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataPointUid(int i, String str) {
            str.getClass();
            ensureDataPointUidIsMutable();
            this.dataPointUid_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPointUid(String str) {
            str.getClass();
            ensureDataPointUidIsMutable();
            this.dataPointUid_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataPointUid(Iterable<String> iterable) {
            ensureDataPointUidIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataPointUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataPointUid() {
            this.dataPointUid_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPointUidBytes(ByteString byteString) {
            ensureDataPointUidIsMutable();
            this.dataPointUid_.add(byteString.toStringUtf8());
        }

        public static InsertDataResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static InsertDataResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static InsertDataResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static InsertDataResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static InsertDataResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static InsertDataResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static InsertDataResponse parseFrom(InputStream inputStream) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InsertDataResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InsertDataResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (InsertDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InsertDataResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InsertDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static InsertDataResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static InsertDataResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(InsertDataResponse insertDataResponse) {
            return DEFAULT_INSTANCE.createBuilder(insertDataResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<InsertDataResponse, Builder> implements InsertDataResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(InsertDataResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public List<String> getDataPointUidList() {
                return Collections.unmodifiableList(((InsertDataResponse) this.instance).getDataPointUidList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public int getDataPointUidCount() {
                return ((InsertDataResponse) this.instance).getDataPointUidCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public String getDataPointUid(int i) {
                return ((InsertDataResponse) this.instance).getDataPointUid(i);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public ByteString getDataPointUidBytes(int i) {
                return ((InsertDataResponse) this.instance).getDataPointUidBytes(i);
            }

            public Builder setDataPointUid(int i, String str) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).setDataPointUid(i, str);
                return this;
            }

            public Builder addDataPointUid(String str) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).addDataPointUid(str);
                return this;
            }

            public Builder addAllDataPointUid(Iterable<String> iterable) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).addAllDataPointUid(iterable);
                return this;
            }

            public Builder clearDataPointUid() {
                copyOnWrite();
                ((InsertDataResponse) this.instance).clearDataPointUid();
                return this;
            }

            public Builder addDataPointUidBytes(ByteString byteString) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).addDataPointUidBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new InsertDataResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"dataPointUid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<InsertDataResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (InsertDataResponse.class) {
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
            InsertDataResponse insertDataResponse = new InsertDataResponse();
            DEFAULT_INSTANCE = insertDataResponse;
            GeneratedMessageLite.registerDefaultInstance(InsertDataResponse.class, insertDataResponse);
        }

        public static InsertDataResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InsertDataResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataResponse extends GeneratedMessageLite<ReadDataResponse, Builder> implements ReadDataResponseOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final ReadDataResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataResponse> PARSER;
        private int bitField0_;
        private DataProto.DataPoint dataPoint_;

        private ReadDataResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
        public boolean hasDataPoint() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
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

        public static ReadDataResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDataResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDataResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDataResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDataResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDataResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDataResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDataResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataResponse readDataResponse) {
            return DEFAULT_INSTANCE.createBuilder(readDataResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataResponse, Builder> implements ReadDataResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDataResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
            public boolean hasDataPoint() {
                return ((ReadDataResponse) this.instance).hasDataPoint();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
            public DataProto.DataPoint getDataPoint() {
                return ((ReadDataResponse) this.instance).getDataPoint();
            }

            public Builder setDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataResponse) this.instance).setDataPoint(dataPoint);
                return this;
            }

            public Builder setDataPoint(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((ReadDataResponse) this.instance).setDataPoint(builder.build());
                return this;
            }

            public Builder mergeDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataResponse) this.instance).mergeDataPoint(dataPoint);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((ReadDataResponse) this.instance).clearDataPoint();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDataResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "dataPoint_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDataResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadDataResponse.class) {
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
            ReadDataResponse readDataResponse = new ReadDataResponse();
            DEFAULT_INSTANCE = readDataResponse;
            GeneratedMessageLite.registerDefaultInstance(ReadDataResponse.class, readDataResponse);
        }

        public static ReadDataResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataRangeResponse extends GeneratedMessageLite<ReadDataRangeResponse, Builder> implements ReadDataRangeResponseOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final ReadDataRangeResponse DEFAULT_INSTANCE;
        public static final int PAGE_TOKEN_FIELD_NUMBER = 2;
        private static volatile Parser<ReadDataRangeResponse> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<DataProto.DataPoint> dataPoint_ = emptyProtobufList();
        private String pageToken_ = "";

        private ReadDataRangeResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public List<DataProto.DataPoint> getDataPointList() {
            return this.dataPoint_;
        }

        public List<? extends DataProto.DataPointOrBuilder> getDataPointOrBuilderList() {
            return this.dataPoint_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public int getDataPointCount() {
            return this.dataPoint_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
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

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public boolean hasPageToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public String getPageToken() {
            return this.pageToken_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public ByteString getPageTokenBytes() {
            return ByteString.copyFromUtf8(this.pageToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageToken(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.pageToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageToken() {
            this.bitField0_ &= -2;
            this.pageToken_ = getDefaultInstance().getPageToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageTokenBytes(ByteString byteString) {
            this.pageToken_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static ReadDataRangeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDataRangeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDataRangeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDataRangeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDataRangeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDataRangeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDataRangeResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataRangeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataRangeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDataRangeResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDataRangeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRangeResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDataRangeResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDataRangeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataRangeResponse readDataRangeResponse) {
            return DEFAULT_INSTANCE.createBuilder(readDataRangeResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataRangeResponse, Builder> implements ReadDataRangeResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDataRangeResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public List<DataProto.DataPoint> getDataPointList() {
                return Collections.unmodifiableList(((ReadDataRangeResponse) this.instance).getDataPointList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public int getDataPointCount() {
                return ((ReadDataRangeResponse) this.instance).getDataPointCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public DataProto.DataPoint getDataPoint(int i) {
                return ((ReadDataRangeResponse) this.instance).getDataPoint(i);
            }

            public Builder setDataPoint(int i, DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setDataPoint(i, dataPoint);
                return this;
            }

            public Builder setDataPoint(int i, DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setDataPoint(i, builder.build());
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(dataPoint);
                return this;
            }

            public Builder addDataPoint(int i, DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(i, dataPoint);
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(builder.build());
                return this;
            }

            public Builder addDataPoint(int i, DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(i, builder.build());
                return this;
            }

            public Builder addAllDataPoint(Iterable<? extends DataProto.DataPoint> iterable) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addAllDataPoint(iterable);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).clearDataPoint();
                return this;
            }

            public Builder removeDataPoint(int i) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).removeDataPoint(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public boolean hasPageToken() {
                return ((ReadDataRangeResponse) this.instance).hasPageToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public String getPageToken() {
                return ((ReadDataRangeResponse) this.instance).getPageToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public ByteString getPageTokenBytes() {
                return ((ReadDataRangeResponse) this.instance).getPageTokenBytes();
            }

            public Builder setPageToken(String str) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setPageToken(str);
                return this;
            }

            public Builder clearPageToken() {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).clearPageToken();
                return this;
            }

            public Builder setPageTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setPageTokenBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDataRangeResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"bitField0_", "dataPoint_", DataProto.DataPoint.class, "pageToken_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDataRangeResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadDataRangeResponse.class) {
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
            ReadDataRangeResponse readDataRangeResponse = new ReadDataRangeResponse();
            DEFAULT_INSTANCE = readDataRangeResponse;
            GeneratedMessageLite.registerDefaultInstance(ReadDataRangeResponse.class, readDataRangeResponse);
        }

        public static ReadDataRangeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataRangeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadExerciseRouteResponse extends GeneratedMessageLite<ReadExerciseRouteResponse, Builder> implements ReadExerciseRouteResponseOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final ReadExerciseRouteResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadExerciseRouteResponse> PARSER;
        private int bitField0_;
        private DataProto.DataPoint dataPoint_;

        private ReadExerciseRouteResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
        public boolean hasDataPoint() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
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

        public static ReadExerciseRouteResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadExerciseRouteResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadExerciseRouteResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadExerciseRouteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadExerciseRouteResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadExerciseRouteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadExerciseRouteResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadExerciseRouteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadExerciseRouteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadExerciseRouteResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadExerciseRouteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadExerciseRouteResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadExerciseRouteResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadExerciseRouteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadExerciseRouteResponse readExerciseRouteResponse) {
            return DEFAULT_INSTANCE.createBuilder(readExerciseRouteResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadExerciseRouteResponse, Builder> implements ReadExerciseRouteResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadExerciseRouteResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
            public boolean hasDataPoint() {
                return ((ReadExerciseRouteResponse) this.instance).hasDataPoint();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
            public DataProto.DataPoint getDataPoint() {
                return ((ReadExerciseRouteResponse) this.instance).getDataPoint();
            }

            public Builder setDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).setDataPoint(dataPoint);
                return this;
            }

            public Builder setDataPoint(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).setDataPoint(builder.build());
                return this;
            }

            public Builder mergeDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).mergeDataPoint(dataPoint);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).clearDataPoint();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadExerciseRouteResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "dataPoint_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadExerciseRouteResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (ReadExerciseRouteResponse.class) {
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
            ReadExerciseRouteResponse readExerciseRouteResponse = new ReadExerciseRouteResponse();
            DEFAULT_INSTANCE = readExerciseRouteResponse;
            GeneratedMessageLite.registerDefaultInstance(ReadExerciseRouteResponse.class, readExerciseRouteResponse);
        }

        public static ReadExerciseRouteResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadExerciseRouteResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateDataResponse extends GeneratedMessageLite<AggregateDataResponse, Builder> implements AggregateDataResponseOrBuilder {
        private static final AggregateDataResponse DEFAULT_INSTANCE;
        private static volatile Parser<AggregateDataResponse> PARSER = null;
        public static final int ROWS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<DataProto.AggregateDataRow> rows_ = emptyProtobufList();

        private AggregateDataResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
        public List<DataProto.AggregateDataRow> getRowsList() {
            return this.rows_;
        }

        public List<? extends DataProto.AggregateDataRowOrBuilder> getRowsOrBuilderList() {
            return this.rows_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
        public int getRowsCount() {
            return this.rows_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
        public DataProto.AggregateDataRow getRows(int i) {
            return this.rows_.get(i);
        }

        public DataProto.AggregateDataRowOrBuilder getRowsOrBuilder(int i) {
            return this.rows_.get(i);
        }

        private void ensureRowsIsMutable() {
            Internal.ProtobufList<DataProto.AggregateDataRow> protobufList = this.rows_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.rows_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRows(int i, DataProto.AggregateDataRow aggregateDataRow) {
            aggregateDataRow.getClass();
            ensureRowsIsMutable();
            this.rows_.set(i, aggregateDataRow);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRows(DataProto.AggregateDataRow aggregateDataRow) {
            aggregateDataRow.getClass();
            ensureRowsIsMutable();
            this.rows_.add(aggregateDataRow);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRows(int i, DataProto.AggregateDataRow aggregateDataRow) {
            aggregateDataRow.getClass();
            ensureRowsIsMutable();
            this.rows_.add(i, aggregateDataRow);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRows(Iterable<? extends DataProto.AggregateDataRow> iterable) {
            ensureRowsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.rows_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRows() {
            this.rows_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRows(int i) {
            ensureRowsIsMutable();
            this.rows_.remove(i);
        }

        public static AggregateDataResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AggregateDataResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AggregateDataResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AggregateDataResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AggregateDataResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AggregateDataResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AggregateDataResponse parseFrom(InputStream inputStream) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateDataResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateDataResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AggregateDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateDataResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateDataResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AggregateDataResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateDataResponse aggregateDataResponse) {
            return DEFAULT_INSTANCE.createBuilder(aggregateDataResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateDataResponse, Builder> implements AggregateDataResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(AggregateDataResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
            public List<DataProto.AggregateDataRow> getRowsList() {
                return Collections.unmodifiableList(((AggregateDataResponse) this.instance).getRowsList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
            public int getRowsCount() {
                return ((AggregateDataResponse) this.instance).getRowsCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
            public DataProto.AggregateDataRow getRows(int i) {
                return ((AggregateDataResponse) this.instance).getRows(i);
            }

            public Builder setRows(int i, DataProto.AggregateDataRow aggregateDataRow) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).setRows(i, aggregateDataRow);
                return this;
            }

            public Builder setRows(int i, DataProto.AggregateDataRow.Builder builder) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).setRows(i, builder.build());
                return this;
            }

            public Builder addRows(DataProto.AggregateDataRow aggregateDataRow) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(aggregateDataRow);
                return this;
            }

            public Builder addRows(int i, DataProto.AggregateDataRow aggregateDataRow) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(i, aggregateDataRow);
                return this;
            }

            public Builder addRows(DataProto.AggregateDataRow.Builder builder) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(builder.build());
                return this;
            }

            public Builder addRows(int i, DataProto.AggregateDataRow.Builder builder) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(i, builder.build());
                return this;
            }

            public Builder addAllRows(Iterable<? extends DataProto.AggregateDataRow> iterable) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addAllRows(iterable);
                return this;
            }

            public Builder clearRows() {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).clearRows();
                return this;
            }

            public Builder removeRows(int i) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).removeRows(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AggregateDataResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"rows_", DataProto.AggregateDataRow.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AggregateDataResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AggregateDataResponse.class) {
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
            AggregateDataResponse aggregateDataResponse = new AggregateDataResponse();
            DEFAULT_INSTANCE = aggregateDataResponse;
            GeneratedMessageLite.registerDefaultInstance(AggregateDataResponse.class, aggregateDataResponse);
        }

        public static AggregateDataResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateDataResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesTokenResponse extends GeneratedMessageLite<GetChangesTokenResponse, Builder> implements GetChangesTokenResponseOrBuilder {
        public static final int CHANGES_TOKEN_FIELD_NUMBER = 1;
        private static final GetChangesTokenResponse DEFAULT_INSTANCE;
        private static volatile Parser<GetChangesTokenResponse> PARSER;
        private int bitField0_;
        private String changesToken_ = "";

        private GetChangesTokenResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
        public boolean hasChangesToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
        public String getChangesToken() {
            return this.changesToken_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
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

        public static GetChangesTokenResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GetChangesTokenResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetChangesTokenResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetChangesTokenResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetChangesTokenResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetChangesTokenResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetChangesTokenResponse parseFrom(InputStream inputStream) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesTokenResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesTokenResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetChangesTokenResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesTokenResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesTokenResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesTokenResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetChangesTokenResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesTokenResponse getChangesTokenResponse) {
            return DEFAULT_INSTANCE.createBuilder(getChangesTokenResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesTokenResponse, Builder> implements GetChangesTokenResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(GetChangesTokenResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
            public boolean hasChangesToken() {
                return ((GetChangesTokenResponse) this.instance).hasChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
            public String getChangesToken() {
                return ((GetChangesTokenResponse) this.instance).getChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
            public ByteString getChangesTokenBytes() {
                return ((GetChangesTokenResponse) this.instance).getChangesTokenBytes();
            }

            public Builder setChangesToken(String str) {
                copyOnWrite();
                ((GetChangesTokenResponse) this.instance).setChangesToken(str);
                return this;
            }

            public Builder clearChangesToken() {
                copyOnWrite();
                ((GetChangesTokenResponse) this.instance).clearChangesToken();
                return this;
            }

            public Builder setChangesTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((GetChangesTokenResponse) this.instance).setChangesTokenBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetChangesTokenResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "changesToken_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetChangesTokenResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (GetChangesTokenResponse.class) {
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
            GetChangesTokenResponse getChangesTokenResponse = new GetChangesTokenResponse();
            DEFAULT_INSTANCE = getChangesTokenResponse;
            GeneratedMessageLite.registerDefaultInstance(GetChangesTokenResponse.class, getChangesTokenResponse);
        }

        public static GetChangesTokenResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesTokenResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesResponse extends GeneratedMessageLite<GetChangesResponse, Builder> implements GetChangesResponseOrBuilder {
        public static final int CHANGES_FIELD_NUMBER = 1;
        public static final int CHANGES_TOKEN_EXPIRED_FIELD_NUMBER = 4;
        private static final GetChangesResponse DEFAULT_INSTANCE;
        public static final int HAS_MORE_FIELD_NUMBER = 2;
        public static final int NEXT_CHANGES_TOKEN_FIELD_NUMBER = 3;
        private static volatile Parser<GetChangesResponse> PARSER;
        private int bitField0_;
        private boolean changesTokenExpired_;
        private boolean hasMore_;
        private Internal.ProtobufList<ChangeProto.DataChange> changes_ = emptyProtobufList();
        private String nextChangesToken_ = "";

        private GetChangesResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public List<ChangeProto.DataChange> getChangesList() {
            return this.changes_;
        }

        public List<? extends ChangeProto.DataChangeOrBuilder> getChangesOrBuilderList() {
            return this.changes_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public int getChangesCount() {
            return this.changes_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public ChangeProto.DataChange getChanges(int i) {
            return this.changes_.get(i);
        }

        public ChangeProto.DataChangeOrBuilder getChangesOrBuilder(int i) {
            return this.changes_.get(i);
        }

        private void ensureChangesIsMutable() {
            Internal.ProtobufList<ChangeProto.DataChange> protobufList = this.changes_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.changes_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanges(int i, ChangeProto.DataChange dataChange) {
            dataChange.getClass();
            ensureChangesIsMutable();
            this.changes_.set(i, dataChange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(ChangeProto.DataChange dataChange) {
            dataChange.getClass();
            ensureChangesIsMutable();
            this.changes_.add(dataChange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(int i, ChangeProto.DataChange dataChange) {
            dataChange.getClass();
            ensureChangesIsMutable();
            this.changes_.add(i, dataChange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChanges(Iterable<? extends ChangeProto.DataChange> iterable) {
            ensureChangesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.changes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChanges() {
            this.changes_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeChanges(int i) {
            ensureChangesIsMutable();
            this.changes_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean hasHasMore() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean getHasMore() {
            return this.hasMore_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasMore(boolean z) {
            this.bitField0_ |= 1;
            this.hasMore_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasMore() {
            this.bitField0_ &= -2;
            this.hasMore_ = false;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean hasNextChangesToken() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public String getNextChangesToken() {
            return this.nextChangesToken_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public ByteString getNextChangesTokenBytes() {
            return ByteString.copyFromUtf8(this.nextChangesToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesToken(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.nextChangesToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNextChangesToken() {
            this.bitField0_ &= -3;
            this.nextChangesToken_ = getDefaultInstance().getNextChangesToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesTokenBytes(ByteString byteString) {
            this.nextChangesToken_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean hasChangesTokenExpired() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean getChangesTokenExpired() {
            return this.changesTokenExpired_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChangesTokenExpired(boolean z) {
            this.bitField0_ |= 4;
            this.changesTokenExpired_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChangesTokenExpired() {
            this.bitField0_ &= -5;
            this.changesTokenExpired_ = false;
        }

        public static GetChangesResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static GetChangesResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GetChangesResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetChangesResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GetChangesResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetChangesResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GetChangesResponse parseFrom(InputStream inputStream) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetChangesResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetChangesResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GetChangesResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GetChangesResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesResponse getChangesResponse) {
            return DEFAULT_INSTANCE.createBuilder(getChangesResponse);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesResponse, Builder> implements GetChangesResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(GetChangesResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public List<ChangeProto.DataChange> getChangesList() {
                return Collections.unmodifiableList(((GetChangesResponse) this.instance).getChangesList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public int getChangesCount() {
                return ((GetChangesResponse) this.instance).getChangesCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public ChangeProto.DataChange getChanges(int i) {
                return ((GetChangesResponse) this.instance).getChanges(i);
            }

            public Builder setChanges(int i, ChangeProto.DataChange dataChange) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setChanges(i, dataChange);
                return this;
            }

            public Builder setChanges(int i, ChangeProto.DataChange.Builder builder) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setChanges(i, builder.build());
                return this;
            }

            public Builder addChanges(ChangeProto.DataChange dataChange) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(dataChange);
                return this;
            }

            public Builder addChanges(int i, ChangeProto.DataChange dataChange) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(i, dataChange);
                return this;
            }

            public Builder addChanges(ChangeProto.DataChange.Builder builder) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(builder.build());
                return this;
            }

            public Builder addChanges(int i, ChangeProto.DataChange.Builder builder) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(i, builder.build());
                return this;
            }

            public Builder addAllChanges(Iterable<? extends ChangeProto.DataChange> iterable) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addAllChanges(iterable);
                return this;
            }

            public Builder clearChanges() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearChanges();
                return this;
            }

            public Builder removeChanges(int i) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).removeChanges(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean hasHasMore() {
                return ((GetChangesResponse) this.instance).hasHasMore();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean getHasMore() {
                return ((GetChangesResponse) this.instance).getHasMore();
            }

            public Builder setHasMore(boolean z) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setHasMore(z);
                return this;
            }

            public Builder clearHasMore() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearHasMore();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean hasNextChangesToken() {
                return ((GetChangesResponse) this.instance).hasNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public String getNextChangesToken() {
                return ((GetChangesResponse) this.instance).getNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public ByteString getNextChangesTokenBytes() {
                return ((GetChangesResponse) this.instance).getNextChangesTokenBytes();
            }

            public Builder setNextChangesToken(String str) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setNextChangesToken(str);
                return this;
            }

            public Builder clearNextChangesToken() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearNextChangesToken();
                return this;
            }

            public Builder setNextChangesTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setNextChangesTokenBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean hasChangesTokenExpired() {
                return ((GetChangesResponse) this.instance).hasChangesTokenExpired();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean getChangesTokenExpired() {
                return ((GetChangesResponse) this.instance).getChangesTokenExpired();
            }

            public Builder setChangesTokenExpired(boolean z) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setChangesTokenExpired(z);
                return this;
            }

            public Builder clearChangesTokenExpired() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearChangesTokenExpired();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetChangesResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဈ\u0001\u0004ဇ\u0002", new Object[]{"bitField0_", "changes_", ChangeProto.DataChange.class, "hasMore_", "nextChangesToken_", "changesTokenExpired_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GetChangesResponse> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (GetChangesResponse.class) {
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
            GetChangesResponse getChangesResponse = new GetChangesResponse();
            DEFAULT_INSTANCE = getChangesResponse;
            GeneratedMessageLite.registerDefaultInstance(GetChangesResponse.class, getChangesResponse);
        }

        public static GetChangesResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
