package androidx.health.platform.client.proto;

import androidx.camera.video.AudioStats;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import androidx.health.platform.client.proto.WireFormat;
import com.sun.jna.platform.win32.Ddeml;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DataProto {

    public interface AggregateDataRowOrBuilder extends MessageLiteOrBuilder {
        boolean containsDoubleValues(String str);

        boolean containsLongValues(String str);

        DataOrigin getDataOrigins(int i);

        int getDataOriginsCount();

        List<DataOrigin> getDataOriginsList();

        @Deprecated
        Map<String, Double> getDoubleValues();

        int getDoubleValuesCount();

        Map<String, Double> getDoubleValuesMap();

        double getDoubleValuesOrDefault(String str, double d);

        double getDoubleValuesOrThrow(String str);

        String getEndLocalDateTime();

        ByteString getEndLocalDateTimeBytes();

        long getEndTimeEpochMs();

        @Deprecated
        Map<String, Long> getLongValues();

        int getLongValuesCount();

        Map<String, Long> getLongValuesMap();

        long getLongValuesOrDefault(String str, long j);

        long getLongValuesOrThrow(String str);

        String getStartLocalDateTime();

        ByteString getStartLocalDateTimeBytes();

        long getStartTimeEpochMs();

        int getZoneOffsetSeconds();

        boolean hasEndLocalDateTime();

        boolean hasEndTimeEpochMs();

        boolean hasStartLocalDateTime();

        boolean hasStartTimeEpochMs();

        boolean hasZoneOffsetSeconds();
    }

    public interface AggregatedValueOrBuilder extends MessageLiteOrBuilder {
        boolean containsValues(String str);

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);
    }

    public interface DataOriginOrBuilder extends MessageLiteOrBuilder {
        String getApplicationId();

        ByteString getApplicationIdBytes();

        boolean hasApplicationId();
    }

    public interface DataPointOrBuilder extends MessageLiteOrBuilder {
        boolean containsSubTypeDataLists(String str);

        boolean containsValues(String str);

        AggregatedValue getAvg();

        String getClientId();

        ByteString getClientIdBytes();

        long getClientVersion();

        DataOrigin getDataOrigin();

        DataType getDataType();

        Device getDevice();

        long getEndTimeMillis();

        int getEndZoneOffsetSeconds();

        long getInstantTimeMillis();

        AggregatedValue getMax();

        AggregatedValue getMin();

        String getOriginSampleUid();

        ByteString getOriginSampleUidBytes();

        String getOriginSeriesUid();

        ByteString getOriginSeriesUidBytes();

        int getRecordingMethod();

        SeriesValue getSeriesValues(int i);

        int getSeriesValuesCount();

        List<SeriesValue> getSeriesValuesList();

        long getStartTimeMillis();

        int getStartZoneOffsetSeconds();

        @Deprecated
        Map<String, DataPoint.SubTypeDataList> getSubTypeDataLists();

        int getSubTypeDataListsCount();

        Map<String, DataPoint.SubTypeDataList> getSubTypeDataListsMap();

        DataPoint.SubTypeDataList getSubTypeDataListsOrDefault(String str, DataPoint.SubTypeDataList subTypeDataList);

        DataPoint.SubTypeDataList getSubTypeDataListsOrThrow(String str);

        String getUid();

        ByteString getUidBytes();

        long getUpdateTimeMillis();

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);

        int getZoneOffsetSeconds();

        boolean hasAvg();

        boolean hasClientId();

        boolean hasClientVersion();

        boolean hasDataOrigin();

        boolean hasDataType();

        boolean hasDevice();

        boolean hasEndTimeMillis();

        boolean hasEndZoneOffsetSeconds();

        boolean hasInstantTimeMillis();

        boolean hasMax();

        boolean hasMin();

        boolean hasOriginSampleUid();

        boolean hasOriginSeriesUid();

        boolean hasRecordingMethod();

        boolean hasStartTimeMillis();

        boolean hasStartZoneOffsetSeconds();

        boolean hasUid();

        boolean hasUpdateTimeMillis();

        boolean hasZoneOffsetSeconds();
    }

    public interface DataTypeOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        boolean hasName();
    }

    public interface DeviceOrBuilder extends MessageLiteOrBuilder {
        String getIdentifier();

        ByteString getIdentifierBytes();

        String getManufacturer();

        ByteString getManufacturerBytes();

        String getModel();

        ByteString getModelBytes();

        String getType();

        ByteString getTypeBytes();

        boolean hasIdentifier();

        boolean hasManufacturer();

        boolean hasModel();

        boolean hasType();
    }

    public interface SeriesValueOrBuilder extends MessageLiteOrBuilder {
        boolean containsValues(String str);

        long getInstantTimeMillis();

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);

        boolean hasInstantTimeMillis();
    }

    public interface SubTypeDataValueOrBuilder extends MessageLiteOrBuilder {
        boolean containsValues(String str);

        long getEndTimeMillis();

        long getStartTimeMillis();

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);

        boolean hasEndTimeMillis();

        boolean hasStartTimeMillis();
    }

    public interface ValueOrBuilder extends MessageLiteOrBuilder {
        boolean getBooleanVal();

        double getDoubleVal();

        String getEnumVal();

        ByteString getEnumValBytes();

        long getLongVal();

        String getStringVal();

        ByteString getStringValBytes();

        Value.ValueCase getValueCase();

        boolean hasBooleanVal();

        boolean hasDoubleVal();

        boolean hasEnumVal();

        boolean hasLongVal();

        boolean hasStringVal();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private DataProto() {
    }

    public static final class DataType extends GeneratedMessageLite<DataType, Builder> implements DataTypeOrBuilder {
        private static final DataType DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<DataType> PARSER;
        private int bitField0_;
        private String name_ = "";

        private DataType() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static DataType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DataType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DataType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DataType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DataType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DataType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DataType parseFrom(InputStream inputStream) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataType parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DataType) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataType) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataType parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DataType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataType dataType) {
            return DEFAULT_INSTANCE.createBuilder(dataType);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataType, Builder> implements DataTypeOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DataType.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
            public boolean hasName() {
                return ((DataType) this.instance).hasName();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
            public String getName() {
                return ((DataType) this.instance).getName();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
            public ByteString getNameBytes() {
                return ((DataType) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((DataType) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((DataType) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((DataType) this.instance).setNameBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DataType();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "name_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DataType> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (DataType.class) {
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
            DataType dataType = new DataType();
            DEFAULT_INSTANCE = dataType;
            GeneratedMessageLite.registerDefaultInstance(DataType.class, dataType);
        }

        public static DataType getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataType> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: androidx.health.platform.client.proto.DataProto$1, reason: invalid class name */
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

    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_VAL_FIELD_NUMBER = 5;
        private static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_VAL_FIELD_NUMBER = 2;
        public static final int ENUM_VAL_FIELD_NUMBER = 4;
        public static final int LONG_VAL_FIELD_NUMBER = 1;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_VAL_FIELD_NUMBER = 3;
        private int bitField0_;
        private int valueCase_ = 0;
        private Object value_;

        private Value() {
        }

        public enum ValueCase {
            LONG_VAL(1),
            DOUBLE_VAL(2),
            STRING_VAL(3),
            ENUM_VAL(4),
            BOOLEAN_VAL(5),
            VALUE_NOT_SET(0);

            private final int value;

            ValueCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static ValueCase valueOf(int i) {
                return forNumber(i);
            }

            public static ValueCase forNumber(int i) {
                if (i == 0) {
                    return VALUE_NOT_SET;
                }
                if (i == 1) {
                    return LONG_VAL;
                }
                if (i == 2) {
                    return DOUBLE_VAL;
                }
                if (i == 3) {
                    return STRING_VAL;
                }
                if (i == 4) {
                    return ENUM_VAL;
                }
                if (i != 5) {
                    return null;
                }
                return BOOLEAN_VAL;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.valueCase_ = 0;
            this.value_ = null;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasLongVal() {
            return this.valueCase_ == 1;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public long getLongVal() {
            if (this.valueCase_ == 1) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongVal(long j) {
            this.valueCase_ = 1;
            this.value_ = Long.valueOf(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLongVal() {
            if (this.valueCase_ == 1) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasDoubleVal() {
            return this.valueCase_ == 2;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public double getDoubleVal() {
            return this.valueCase_ == 2 ? ((Double) this.value_).doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoubleVal(double d) {
            this.valueCase_ = 2;
            this.value_ = Double.valueOf(d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoubleVal() {
            if (this.valueCase_ == 2) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasStringVal() {
            return this.valueCase_ == 3;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public String getStringVal() {
            if (this.valueCase_ != 3) {
                return "";
            }
            return (String) this.value_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public ByteString getStringValBytes() {
            String str;
            if (this.valueCase_ != 3) {
                str = "";
            } else {
                str = (String) this.value_;
            }
            return ByteString.copyFromUtf8(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringVal(String str) {
            str.getClass();
            this.valueCase_ = 3;
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStringVal() {
            if (this.valueCase_ == 3) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValBytes(ByteString byteString) {
            this.value_ = byteString.toStringUtf8();
            this.valueCase_ = 3;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasEnumVal() {
            return this.valueCase_ == 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public String getEnumVal() {
            if (this.valueCase_ != 4) {
                return "";
            }
            return (String) this.value_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public ByteString getEnumValBytes() {
            String str;
            if (this.valueCase_ != 4) {
                str = "";
            } else {
                str = (String) this.value_;
            }
            return ByteString.copyFromUtf8(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumVal(String str) {
            str.getClass();
            this.valueCase_ = 4;
            this.value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnumVal() {
            if (this.valueCase_ == 4) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumValBytes(ByteString byteString) {
            this.value_ = byteString.toStringUtf8();
            this.valueCase_ = 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasBooleanVal() {
            return this.valueCase_ == 5;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean getBooleanVal() {
            if (this.valueCase_ == 5) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBooleanVal(boolean z) {
            this.valueCase_ = 5;
            this.value_ = Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBooleanVal() {
            if (this.valueCase_ == 5) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        public static Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Value parseFrom(InputStream inputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Value value) {
            return DEFAULT_INSTANCE.createBuilder(value);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public ValueCase getValueCase() {
                return ((Value) this.instance).getValueCase();
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Value) this.instance).clearValue();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasLongVal() {
                return ((Value) this.instance).hasLongVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public long getLongVal() {
                return ((Value) this.instance).getLongVal();
            }

            public Builder setLongVal(long j) {
                copyOnWrite();
                ((Value) this.instance).setLongVal(j);
                return this;
            }

            public Builder clearLongVal() {
                copyOnWrite();
                ((Value) this.instance).clearLongVal();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasDoubleVal() {
                return ((Value) this.instance).hasDoubleVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public double getDoubleVal() {
                return ((Value) this.instance).getDoubleVal();
            }

            public Builder setDoubleVal(double d) {
                copyOnWrite();
                ((Value) this.instance).setDoubleVal(d);
                return this;
            }

            public Builder clearDoubleVal() {
                copyOnWrite();
                ((Value) this.instance).clearDoubleVal();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasStringVal() {
                return ((Value) this.instance).hasStringVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public String getStringVal() {
                return ((Value) this.instance).getStringVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public ByteString getStringValBytes() {
                return ((Value) this.instance).getStringValBytes();
            }

            public Builder setStringVal(String str) {
                copyOnWrite();
                ((Value) this.instance).setStringVal(str);
                return this;
            }

            public Builder clearStringVal() {
                copyOnWrite();
                ((Value) this.instance).clearStringVal();
                return this;
            }

            public Builder setStringValBytes(ByteString byteString) {
                copyOnWrite();
                ((Value) this.instance).setStringValBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasEnumVal() {
                return ((Value) this.instance).hasEnumVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public String getEnumVal() {
                return ((Value) this.instance).getEnumVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public ByteString getEnumValBytes() {
                return ((Value) this.instance).getEnumValBytes();
            }

            public Builder setEnumVal(String str) {
                copyOnWrite();
                ((Value) this.instance).setEnumVal(str);
                return this;
            }

            public Builder clearEnumVal() {
                copyOnWrite();
                ((Value) this.instance).clearEnumVal();
                return this;
            }

            public Builder setEnumValBytes(ByteString byteString) {
                copyOnWrite();
                ((Value) this.instance).setEnumValBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasBooleanVal() {
                return ((Value) this.instance).hasBooleanVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean getBooleanVal() {
                return ((Value) this.instance).getBooleanVal();
            }

            public Builder setBooleanVal(boolean z) {
                copyOnWrite();
                ((Value) this.instance).setBooleanVal(z);
                return this;
            }

            public Builder clearBooleanVal() {
                copyOnWrite();
                ((Value) this.instance).clearBooleanVal();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Value();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဵ\u0000\u0002ဳ\u0000\u0003ျ\u0000\u0004ျ\u0000\u0005်\u0000", new Object[]{"value_", "valueCase_", "bitField0_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Value> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Value.class) {
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
            Value value = new Value();
            DEFAULT_INSTANCE = value;
            GeneratedMessageLite.registerDefaultInstance(Value.class, value);
        }

        public static Value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Value> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Device extends GeneratedMessageLite<Device, Builder> implements DeviceOrBuilder {
        private static final Device DEFAULT_INSTANCE;
        public static final int IDENTIFIER_FIELD_NUMBER = 1;
        public static final int MANUFACTURER_FIELD_NUMBER = 2;
        public static final int MODEL_FIELD_NUMBER = 3;
        private static volatile Parser<Device> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 4;
        private int bitField0_;
        private String identifier_ = "";
        private String manufacturer_ = "";
        private String model_ = "";
        private String type_ = "";

        private Device() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasIdentifier() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getIdentifier() {
            return this.identifier_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getIdentifierBytes() {
            return ByteString.copyFromUtf8(this.identifier_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifier(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.identifier_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdentifier() {
            this.bitField0_ &= -2;
            this.identifier_ = getDefaultInstance().getIdentifier();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifierBytes(ByteString byteString) {
            this.identifier_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasManufacturer() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getManufacturer() {
            return this.manufacturer_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getManufacturerBytes() {
            return ByteString.copyFromUtf8(this.manufacturer_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setManufacturer(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.manufacturer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearManufacturer() {
            this.bitField0_ &= -3;
            this.manufacturer_ = getDefaultInstance().getManufacturer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setManufacturerBytes(ByteString byteString) {
            this.manufacturer_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasModel() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getModel() {
            return this.model_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getModelBytes() {
            return ByteString.copyFromUtf8(this.model_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModel(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.model_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearModel() {
            this.bitField0_ &= -5;
            this.model_ = getDefaultInstance().getModel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModelBytes(ByteString byteString) {
            this.model_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.type_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = getDefaultInstance().getType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            this.type_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        public static Device parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Device parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Device parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Device parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Device parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Device parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Device parseFrom(InputStream inputStream) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Device parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Device parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Device) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Device parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Device) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Device parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Device parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Device device) {
            return DEFAULT_INSTANCE.createBuilder(device);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Device, Builder> implements DeviceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Device.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasIdentifier() {
                return ((Device) this.instance).hasIdentifier();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getIdentifier() {
                return ((Device) this.instance).getIdentifier();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getIdentifierBytes() {
                return ((Device) this.instance).getIdentifierBytes();
            }

            public Builder setIdentifier(String str) {
                copyOnWrite();
                ((Device) this.instance).setIdentifier(str);
                return this;
            }

            public Builder clearIdentifier() {
                copyOnWrite();
                ((Device) this.instance).clearIdentifier();
                return this;
            }

            public Builder setIdentifierBytes(ByteString byteString) {
                copyOnWrite();
                ((Device) this.instance).setIdentifierBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasManufacturer() {
                return ((Device) this.instance).hasManufacturer();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getManufacturer() {
                return ((Device) this.instance).getManufacturer();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getManufacturerBytes() {
                return ((Device) this.instance).getManufacturerBytes();
            }

            public Builder setManufacturer(String str) {
                copyOnWrite();
                ((Device) this.instance).setManufacturer(str);
                return this;
            }

            public Builder clearManufacturer() {
                copyOnWrite();
                ((Device) this.instance).clearManufacturer();
                return this;
            }

            public Builder setManufacturerBytes(ByteString byteString) {
                copyOnWrite();
                ((Device) this.instance).setManufacturerBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasModel() {
                return ((Device) this.instance).hasModel();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getModel() {
                return ((Device) this.instance).getModel();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getModelBytes() {
                return ((Device) this.instance).getModelBytes();
            }

            public Builder setModel(String str) {
                copyOnWrite();
                ((Device) this.instance).setModel(str);
                return this;
            }

            public Builder clearModel() {
                copyOnWrite();
                ((Device) this.instance).clearModel();
                return this;
            }

            public Builder setModelBytes(ByteString byteString) {
                copyOnWrite();
                ((Device) this.instance).setModelBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasType() {
                return ((Device) this.instance).hasType();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getType() {
                return ((Device) this.instance).getType();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getTypeBytes() {
                return ((Device) this.instance).getTypeBytes();
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((Device) this.instance).setType(str);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Device) this.instance).clearType();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Device) this.instance).setTypeBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Device();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"bitField0_", "identifier_", "manufacturer_", "model_", "type_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Device> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (Device.class) {
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
            Device device = new Device();
            DEFAULT_INSTANCE = device;
            GeneratedMessageLite.registerDefaultInstance(Device.class, device);
        }

        public static Device getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Device> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DataOrigin extends GeneratedMessageLite<DataOrigin, Builder> implements DataOriginOrBuilder {
        public static final int APPLICATION_ID_FIELD_NUMBER = 1;
        private static final DataOrigin DEFAULT_INSTANCE;
        private static volatile Parser<DataOrigin> PARSER;
        private String applicationId_ = "";
        private int bitField0_;

        private DataOrigin() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
        public boolean hasApplicationId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
        public String getApplicationId() {
            return this.applicationId_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
        public ByteString getApplicationIdBytes() {
            return ByteString.copyFromUtf8(this.applicationId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.applicationId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApplicationId() {
            this.bitField0_ &= -2;
            this.applicationId_ = getDefaultInstance().getApplicationId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationIdBytes(ByteString byteString) {
            this.applicationId_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static DataOrigin parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DataOrigin parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DataOrigin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DataOrigin parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DataOrigin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DataOrigin parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DataOrigin parseFrom(InputStream inputStream) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataOrigin parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataOrigin parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DataOrigin) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataOrigin parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataOrigin) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataOrigin parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DataOrigin parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataOrigin dataOrigin) {
            return DEFAULT_INSTANCE.createBuilder(dataOrigin);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataOrigin, Builder> implements DataOriginOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DataOrigin.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
            public boolean hasApplicationId() {
                return ((DataOrigin) this.instance).hasApplicationId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
            public String getApplicationId() {
                return ((DataOrigin) this.instance).getApplicationId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
            public ByteString getApplicationIdBytes() {
                return ((DataOrigin) this.instance).getApplicationIdBytes();
            }

            public Builder setApplicationId(String str) {
                copyOnWrite();
                ((DataOrigin) this.instance).setApplicationId(str);
                return this;
            }

            public Builder clearApplicationId() {
                copyOnWrite();
                ((DataOrigin) this.instance).clearApplicationId();
                return this;
            }

            public Builder setApplicationIdBytes(ByteString byteString) {
                copyOnWrite();
                ((DataOrigin) this.instance).setApplicationIdBytes(byteString);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DataOrigin();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"bitField0_", "applicationId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DataOrigin> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (DataOrigin.class) {
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
            DataOrigin dataOrigin = new DataOrigin();
            DEFAULT_INSTANCE = dataOrigin;
            GeneratedMessageLite.registerDefaultInstance(DataOrigin.class, dataOrigin);
        }

        public static DataOrigin getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataOrigin> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SeriesValue extends GeneratedMessageLite<SeriesValue, Builder> implements SeriesValueOrBuilder {
        private static final SeriesValue DEFAULT_INSTANCE;
        public static final int INSTANT_TIME_MILLIS_FIELD_NUMBER = 2;
        private static volatile Parser<SeriesValue> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 1;
        private int bitField0_;
        private long instantTimeMillis_;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();

        private SeriesValue() {
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public boolean containsValues(String str) {
            str.getClass();
            return internalGetValues().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public Value getValuesOrDefault(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            return mapFieldLiteInternalGetValues.containsKey(str) ? mapFieldLiteInternalGetValues.get(str) : value;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public Value getValuesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            if (!mapFieldLiteInternalGetValues.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetValues.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public boolean hasInstantTimeMillis() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public long getInstantTimeMillis() {
            return this.instantTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstantTimeMillis(long j) {
            this.bitField0_ |= 1;
            this.instantTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstantTimeMillis() {
            this.bitField0_ &= -2;
            this.instantTimeMillis_ = 0L;
        }

        public static SeriesValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SeriesValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SeriesValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SeriesValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SeriesValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SeriesValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SeriesValue parseFrom(InputStream inputStream) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SeriesValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SeriesValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SeriesValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SeriesValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SeriesValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SeriesValue parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SeriesValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SeriesValue seriesValue) {
            return DEFAULT_INSTANCE.createBuilder(seriesValue);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SeriesValue, Builder> implements SeriesValueOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SeriesValue.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public int getValuesCount() {
                return ((SeriesValue) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public boolean containsValues(String str) {
                str.getClass();
                return ((SeriesValue) this.instance).getValuesMap().containsKey(str);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String str) {
                str.getClass();
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((SeriesValue) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public Value getValuesOrDefault(String str, Value value) {
                str.getClass();
                Map<String, Value> valuesMap = ((SeriesValue) this.instance).getValuesMap();
                return valuesMap.containsKey(str) ? valuesMap.get(str) : value;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public Value getValuesOrThrow(String str) {
                str.getClass();
                Map<String, Value> valuesMap = ((SeriesValue) this.instance).getValuesMap();
                if (!valuesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valuesMap.get(str);
            }

            public Builder putValues(String str, Value value) {
                str.getClass();
                value.getClass();
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().put(str, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> map) {
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().putAll(map);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public boolean hasInstantTimeMillis() {
                return ((SeriesValue) this.instance).hasInstantTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public long getInstantTimeMillis() {
                return ((SeriesValue) this.instance).getInstantTimeMillis();
            }

            public Builder setInstantTimeMillis(long j) {
                copyOnWrite();
                ((SeriesValue) this.instance).setInstantTimeMillis(j);
                return this;
            }

            public Builder clearInstantTimeMillis() {
                copyOnWrite();
                ((SeriesValue) this.instance).clearInstantTimeMillis();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SeriesValue();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0001\u0000\u0000\u00012\u0002ဂ\u0000", new Object[]{"bitField0_", "values_", ValuesDefaultEntryHolder.defaultEntry, "instantTimeMillis_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SeriesValue> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SeriesValue.class) {
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
            SeriesValue seriesValue = new SeriesValue();
            DEFAULT_INSTANCE = seriesValue;
            GeneratedMessageLite.registerDefaultInstance(SeriesValue.class, seriesValue);
        }

        public static SeriesValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SeriesValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SubTypeDataValue extends GeneratedMessageLite<SubTypeDataValue, Builder> implements SubTypeDataValueOrBuilder {
        private static final SubTypeDataValue DEFAULT_INSTANCE;
        public static final int END_TIME_MILLIS_FIELD_NUMBER = 3;
        private static volatile Parser<SubTypeDataValue> PARSER = null;
        public static final int START_TIME_MILLIS_FIELD_NUMBER = 2;
        public static final int VALUES_FIELD_NUMBER = 1;
        private int bitField0_;
        private long endTimeMillis_;
        private long startTimeMillis_;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();

        private SubTypeDataValue() {
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public boolean containsValues(String str) {
            str.getClass();
            return internalGetValues().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public Value getValuesOrDefault(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            return mapFieldLiteInternalGetValues.containsKey(str) ? mapFieldLiteInternalGetValues.get(str) : value;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public Value getValuesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            if (!mapFieldLiteInternalGetValues.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetValues.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public boolean hasStartTimeMillis() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public long getStartTimeMillis() {
            return this.startTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeMillis(long j) {
            this.bitField0_ |= 1;
            this.startTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeMillis() {
            this.bitField0_ &= -2;
            this.startTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public boolean hasEndTimeMillis() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public long getEndTimeMillis() {
            return this.endTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTimeMillis(long j) {
            this.bitField0_ |= 2;
            this.endTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTimeMillis() {
            this.bitField0_ &= -3;
            this.endTimeMillis_ = 0L;
        }

        public static SubTypeDataValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SubTypeDataValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SubTypeDataValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SubTypeDataValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SubTypeDataValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SubTypeDataValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SubTypeDataValue parseFrom(InputStream inputStream) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubTypeDataValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubTypeDataValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SubTypeDataValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SubTypeDataValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubTypeDataValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SubTypeDataValue parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SubTypeDataValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SubTypeDataValue subTypeDataValue) {
            return DEFAULT_INSTANCE.createBuilder(subTypeDataValue);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SubTypeDataValue, Builder> implements SubTypeDataValueOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SubTypeDataValue.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public int getValuesCount() {
                return ((SubTypeDataValue) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public boolean containsValues(String str) {
                str.getClass();
                return ((SubTypeDataValue) this.instance).getValuesMap().containsKey(str);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String str) {
                str.getClass();
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((SubTypeDataValue) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public Value getValuesOrDefault(String str, Value value) {
                str.getClass();
                Map<String, Value> valuesMap = ((SubTypeDataValue) this.instance).getValuesMap();
                return valuesMap.containsKey(str) ? valuesMap.get(str) : value;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public Value getValuesOrThrow(String str) {
                str.getClass();
                Map<String, Value> valuesMap = ((SubTypeDataValue) this.instance).getValuesMap();
                if (!valuesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valuesMap.get(str);
            }

            public Builder putValues(String str, Value value) {
                str.getClass();
                value.getClass();
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().put(str, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> map) {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().putAll(map);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public boolean hasStartTimeMillis() {
                return ((SubTypeDataValue) this.instance).hasStartTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public long getStartTimeMillis() {
                return ((SubTypeDataValue) this.instance).getStartTimeMillis();
            }

            public Builder setStartTimeMillis(long j) {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).setStartTimeMillis(j);
                return this;
            }

            public Builder clearStartTimeMillis() {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).clearStartTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public boolean hasEndTimeMillis() {
                return ((SubTypeDataValue) this.instance).hasEndTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public long getEndTimeMillis() {
                return ((SubTypeDataValue) this.instance).getEndTimeMillis();
            }

            public Builder setEndTimeMillis(long j) {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).setEndTimeMillis(j);
                return this;
            }

            public Builder clearEndTimeMillis() {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).clearEndTimeMillis();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SubTypeDataValue();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0000\u00012\u0002ဂ\u0000\u0003ဂ\u0001", new Object[]{"bitField0_", "values_", ValuesDefaultEntryHolder.defaultEntry, "startTimeMillis_", "endTimeMillis_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SubTypeDataValue> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (SubTypeDataValue.class) {
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
            SubTypeDataValue subTypeDataValue = new SubTypeDataValue();
            DEFAULT_INSTANCE = subTypeDataValue;
            GeneratedMessageLite.registerDefaultInstance(SubTypeDataValue.class, subTypeDataValue);
        }

        public static SubTypeDataValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SubTypeDataValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DataPoint extends GeneratedMessageLite<DataPoint, Builder> implements DataPointOrBuilder {
        public static final int AVG_FIELD_NUMBER = 18;
        public static final int CLIENT_ID_FIELD_NUMBER = 11;
        public static final int CLIENT_VERSION_FIELD_NUMBER = 12;
        public static final int DATA_ORIGIN_FIELD_NUMBER = 5;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final DataPoint DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 13;
        public static final int END_TIME_MILLIS_FIELD_NUMBER = 10;
        public static final int END_ZONE_OFFSET_SECONDS_FIELD_NUMBER = 20;
        public static final int INSTANT_TIME_MILLIS_FIELD_NUMBER = 8;
        public static final int MAX_FIELD_NUMBER = 17;
        public static final int MIN_FIELD_NUMBER = 16;
        public static final int ORIGIN_SAMPLE_UID_FIELD_NUMBER = 14;
        public static final int ORIGIN_SERIES_UID_FIELD_NUMBER = 4;
        private static volatile Parser<DataPoint> PARSER = null;
        public static final int RECORDING_METHOD_FIELD_NUMBER = 23;
        public static final int SERIES_VALUES_FIELD_NUMBER = 15;
        public static final int START_TIME_MILLIS_FIELD_NUMBER = 9;
        public static final int START_ZONE_OFFSET_SECONDS_FIELD_NUMBER = 19;
        public static final int SUB_TYPE_DATA_LISTS_FIELD_NUMBER = 22;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int UPDATE_TIME_MILLIS_FIELD_NUMBER = 7;
        public static final int VALUES_FIELD_NUMBER = 2;
        public static final int ZONE_OFFSET_SECONDS_FIELD_NUMBER = 6;
        private AggregatedValue avg_;
        private int bitField0_;
        private long clientVersion_;
        private DataOrigin dataOrigin_;
        private DataType dataType_;
        private Device device_;
        private long endTimeMillis_;
        private int endZoneOffsetSeconds_;
        private long instantTimeMillis_;
        private AggregatedValue max_;
        private AggregatedValue min_;
        private int recordingMethod_;
        private long startTimeMillis_;
        private int startZoneOffsetSeconds_;
        private long updateTimeMillis_;
        private int zoneOffsetSeconds_;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, SubTypeDataList> subTypeDataLists_ = MapFieldLite.emptyMapField();
        private String uid_ = "";
        private String originSeriesUid_ = "";
        private String clientId_ = "";
        private String originSampleUid_ = "";
        private Internal.ProtobufList<SeriesValue> seriesValues_ = emptyProtobufList();

        public interface SubTypeDataListOrBuilder extends MessageLiteOrBuilder {
            SubTypeDataValue getValues(int i);

            int getValuesCount();

            List<SubTypeDataValue> getValuesList();
        }

        private DataPoint() {
        }

        public static final class SubTypeDataList extends GeneratedMessageLite<SubTypeDataList, Builder> implements SubTypeDataListOrBuilder {
            private static final SubTypeDataList DEFAULT_INSTANCE;
            private static volatile Parser<SubTypeDataList> PARSER = null;
            public static final int VALUES_FIELD_NUMBER = 1;
            private Internal.ProtobufList<SubTypeDataValue> values_ = emptyProtobufList();

            private SubTypeDataList() {
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
            public List<SubTypeDataValue> getValuesList() {
                return this.values_;
            }

            public List<? extends SubTypeDataValueOrBuilder> getValuesOrBuilderList() {
                return this.values_;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
            public int getValuesCount() {
                return this.values_.size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
            public SubTypeDataValue getValues(int i) {
                return this.values_.get(i);
            }

            public SubTypeDataValueOrBuilder getValuesOrBuilder(int i) {
                return this.values_.get(i);
            }

            private void ensureValuesIsMutable() {
                Internal.ProtobufList<SubTypeDataValue> protobufList = this.values_;
                if (protobufList.isModifiable()) {
                    return;
                }
                this.values_ = GeneratedMessageLite.mutableCopy(protobufList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setValues(int i, SubTypeDataValue subTypeDataValue) {
                subTypeDataValue.getClass();
                ensureValuesIsMutable();
                this.values_.set(i, subTypeDataValue);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addValues(SubTypeDataValue subTypeDataValue) {
                subTypeDataValue.getClass();
                ensureValuesIsMutable();
                this.values_.add(subTypeDataValue);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addValues(int i, SubTypeDataValue subTypeDataValue) {
                subTypeDataValue.getClass();
                ensureValuesIsMutable();
                this.values_.add(i, subTypeDataValue);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllValues(Iterable<? extends SubTypeDataValue> iterable) {
                ensureValuesIsMutable();
                AbstractMessageLite.addAll((Iterable) iterable, (List) this.values_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearValues() {
                this.values_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeValues(int i) {
                ensureValuesIsMutable();
                this.values_.remove(i);
            }

            public static SubTypeDataList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static SubTypeDataList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static SubTypeDataList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static SubTypeDataList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static SubTypeDataList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static SubTypeDataList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static SubTypeDataList parseFrom(InputStream inputStream) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SubTypeDataList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SubTypeDataList parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (SubTypeDataList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static SubTypeDataList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SubTypeDataList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static SubTypeDataList parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static SubTypeDataList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(SubTypeDataList subTypeDataList) {
                return DEFAULT_INSTANCE.createBuilder(subTypeDataList);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<SubTypeDataList, Builder> implements SubTypeDataListOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                private Builder() {
                    super(SubTypeDataList.DEFAULT_INSTANCE);
                }

                @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
                public List<SubTypeDataValue> getValuesList() {
                    return Collections.unmodifiableList(((SubTypeDataList) this.instance).getValuesList());
                }

                @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
                public int getValuesCount() {
                    return ((SubTypeDataList) this.instance).getValuesCount();
                }

                @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
                public SubTypeDataValue getValues(int i) {
                    return ((SubTypeDataList) this.instance).getValues(i);
                }

                public Builder setValues(int i, SubTypeDataValue subTypeDataValue) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).setValues(i, subTypeDataValue);
                    return this;
                }

                public Builder setValues(int i, SubTypeDataValue.Builder builder) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).setValues(i, builder.build());
                    return this;
                }

                public Builder addValues(SubTypeDataValue subTypeDataValue) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(subTypeDataValue);
                    return this;
                }

                public Builder addValues(int i, SubTypeDataValue subTypeDataValue) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(i, subTypeDataValue);
                    return this;
                }

                public Builder addValues(SubTypeDataValue.Builder builder) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(builder.build());
                    return this;
                }

                public Builder addValues(int i, SubTypeDataValue.Builder builder) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(i, builder.build());
                    return this;
                }

                public Builder addAllValues(Iterable<? extends SubTypeDataValue> iterable) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addAllValues(iterable);
                    return this;
                }

                public Builder clearValues() {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).clearValues();
                    return this;
                }

                public Builder removeValues(int i) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).removeValues(i);
                    return this;
                }
            }

            @Override // androidx.health.platform.client.proto.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new SubTypeDataList();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", SubTypeDataValue.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<SubTypeDataList> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (SubTypeDataList.class) {
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
                SubTypeDataList subTypeDataList = new SubTypeDataList();
                DEFAULT_INSTANCE = subTypeDataList;
                GeneratedMessageLite.registerDefaultInstance(SubTypeDataList.class, subTypeDataList);
            }

            public static SubTypeDataList getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<SubTypeDataList> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public DataType getDataType() {
            DataType dataType = this.dataType_;
            return dataType == null ? DataType.getDefaultInstance() : dataType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataType dataType) {
            dataType.getClass();
            this.dataType_ = dataType;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataType(DataType dataType) {
            dataType.getClass();
            DataType dataType2 = this.dataType_;
            if (dataType2 != null && dataType2 != DataType.getDefaultInstance()) {
                this.dataType_ = DataType.newBuilder(this.dataType_).mergeFrom((DataType.Builder) dataType).buildPartial();
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

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean containsValues(String str) {
            str.getClass();
            return internalGetValues().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Value getValuesOrDefault(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            return mapFieldLiteInternalGetValues.containsKey(str) ? mapFieldLiteInternalGetValues.get(str) : value;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Value getValuesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            if (!mapFieldLiteInternalGetValues.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetValues.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getUid() {
            return this.uid_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
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

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasOriginSeriesUid() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getOriginSeriesUid() {
            return this.originSeriesUid_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getOriginSeriesUidBytes() {
            return ByteString.copyFromUtf8(this.originSeriesUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSeriesUid(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.originSeriesUid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOriginSeriesUid() {
            this.bitField0_ &= -5;
            this.originSeriesUid_ = getDefaultInstance().getOriginSeriesUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSeriesUidBytes(ByteString byteString) {
            this.originSeriesUid_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasDataOrigin() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public DataOrigin getDataOrigin() {
            DataOrigin dataOrigin = this.dataOrigin_;
            return dataOrigin == null ? DataOrigin.getDefaultInstance() : dataOrigin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOrigin(DataOrigin dataOrigin) {
            dataOrigin.getClass();
            this.dataOrigin_ = dataOrigin;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataOrigin(DataOrigin dataOrigin) {
            dataOrigin.getClass();
            DataOrigin dataOrigin2 = this.dataOrigin_;
            if (dataOrigin2 != null && dataOrigin2 != DataOrigin.getDefaultInstance()) {
                this.dataOrigin_ = DataOrigin.newBuilder(this.dataOrigin_).mergeFrom((DataOrigin.Builder) dataOrigin).buildPartial();
            } else {
                this.dataOrigin_ = dataOrigin;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOrigin() {
            this.dataOrigin_ = null;
            this.bitField0_ &= -9;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasZoneOffsetSeconds() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getZoneOffsetSeconds() {
            return this.zoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZoneOffsetSeconds(int i) {
            this.bitField0_ |= 16;
            this.zoneOffsetSeconds_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZoneOffsetSeconds() {
            this.bitField0_ &= -17;
            this.zoneOffsetSeconds_ = 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasUpdateTimeMillis() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getUpdateTimeMillis() {
            return this.updateTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateTimeMillis(long j) {
            this.bitField0_ |= 32;
            this.updateTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateTimeMillis() {
            this.bitField0_ &= -33;
            this.updateTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasInstantTimeMillis() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getInstantTimeMillis() {
            return this.instantTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstantTimeMillis(long j) {
            this.bitField0_ |= 64;
            this.instantTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstantTimeMillis() {
            this.bitField0_ &= -65;
            this.instantTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasStartTimeMillis() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getStartTimeMillis() {
            return this.startTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeMillis(long j) {
            this.bitField0_ |= 128;
            this.startTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeMillis() {
            this.bitField0_ &= -129;
            this.startTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasEndTimeMillis() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getEndTimeMillis() {
            return this.endTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTimeMillis(long j) {
            this.bitField0_ |= 256;
            this.endTimeMillis_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTimeMillis() {
            this.bitField0_ &= -257;
            this.endTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasClientId() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getClientId() {
            return this.clientId_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getClientIdBytes() {
            return ByteString.copyFromUtf8(this.clientId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientId(String str) {
            str.getClass();
            this.bitField0_ |= 512;
            this.clientId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientId() {
            this.bitField0_ &= -513;
            this.clientId_ = getDefaultInstance().getClientId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIdBytes(ByteString byteString) {
            this.clientId_ = byteString.toStringUtf8();
            this.bitField0_ |= 512;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasClientVersion() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getClientVersion() {
            return this.clientVersion_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientVersion(long j) {
            this.bitField0_ |= 1024;
            this.clientVersion_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientVersion() {
            this.bitField0_ &= -1025;
            this.clientVersion_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasDevice() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Device getDevice() {
            Device device = this.device_;
            return device == null ? Device.getDefaultInstance() : device;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(Device device) {
            device.getClass();
            this.device_ = device;
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDevice(Device device) {
            device.getClass();
            Device device2 = this.device_;
            if (device2 != null && device2 != Device.getDefaultInstance()) {
                this.device_ = Device.newBuilder(this.device_).mergeFrom((Device.Builder) device).buildPartial();
            } else {
                this.device_ = device;
            }
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevice() {
            this.device_ = null;
            this.bitField0_ &= -2049;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasOriginSampleUid() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getOriginSampleUid() {
            return this.originSampleUid_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getOriginSampleUidBytes() {
            return ByteString.copyFromUtf8(this.originSampleUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSampleUid(String str) {
            str.getClass();
            this.bitField0_ |= 4096;
            this.originSampleUid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOriginSampleUid() {
            this.bitField0_ &= -4097;
            this.originSampleUid_ = getDefaultInstance().getOriginSampleUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSampleUidBytes(ByteString byteString) {
            this.originSampleUid_ = byteString.toStringUtf8();
            this.bitField0_ |= 4096;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public List<SeriesValue> getSeriesValuesList() {
            return this.seriesValues_;
        }

        public List<? extends SeriesValueOrBuilder> getSeriesValuesOrBuilderList() {
            return this.seriesValues_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getSeriesValuesCount() {
            return this.seriesValues_.size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public SeriesValue getSeriesValues(int i) {
            return this.seriesValues_.get(i);
        }

        public SeriesValueOrBuilder getSeriesValuesOrBuilder(int i) {
            return this.seriesValues_.get(i);
        }

        private void ensureSeriesValuesIsMutable() {
            Internal.ProtobufList<SeriesValue> protobufList = this.seriesValues_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.seriesValues_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSeriesValues(int i, SeriesValue seriesValue) {
            seriesValue.getClass();
            ensureSeriesValuesIsMutable();
            this.seriesValues_.set(i, seriesValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSeriesValues(SeriesValue seriesValue) {
            seriesValue.getClass();
            ensureSeriesValuesIsMutable();
            this.seriesValues_.add(seriesValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSeriesValues(int i, SeriesValue seriesValue) {
            seriesValue.getClass();
            ensureSeriesValuesIsMutable();
            this.seriesValues_.add(i, seriesValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSeriesValues(Iterable<? extends SeriesValue> iterable) {
            ensureSeriesValuesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.seriesValues_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSeriesValues() {
            this.seriesValues_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeSeriesValues(int i) {
            ensureSeriesValuesIsMutable();
            this.seriesValues_.remove(i);
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasMin() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public AggregatedValue getMin() {
            AggregatedValue aggregatedValue = this.min_;
            return aggregatedValue == null ? AggregatedValue.getDefaultInstance() : aggregatedValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMin(AggregatedValue aggregatedValue) {
            aggregatedValue.getClass();
            this.min_ = aggregatedValue;
            this.bitField0_ |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMin(AggregatedValue aggregatedValue) {
            aggregatedValue.getClass();
            AggregatedValue aggregatedValue2 = this.min_;
            if (aggregatedValue2 != null && aggregatedValue2 != AggregatedValue.getDefaultInstance()) {
                this.min_ = AggregatedValue.newBuilder(this.min_).mergeFrom((AggregatedValue.Builder) aggregatedValue).buildPartial();
            } else {
                this.min_ = aggregatedValue;
            }
            this.bitField0_ |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMin() {
            this.min_ = null;
            this.bitField0_ &= Ddeml.DDE_FPOKRESERVED;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasMax() {
            return (this.bitField0_ & 16384) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public AggregatedValue getMax() {
            AggregatedValue aggregatedValue = this.max_;
            return aggregatedValue == null ? AggregatedValue.getDefaultInstance() : aggregatedValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMax(AggregatedValue aggregatedValue) {
            aggregatedValue.getClass();
            this.max_ = aggregatedValue;
            this.bitField0_ |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMax(AggregatedValue aggregatedValue) {
            aggregatedValue.getClass();
            AggregatedValue aggregatedValue2 = this.max_;
            if (aggregatedValue2 != null && aggregatedValue2 != AggregatedValue.getDefaultInstance()) {
                this.max_ = AggregatedValue.newBuilder(this.max_).mergeFrom((AggregatedValue.Builder) aggregatedValue).buildPartial();
            } else {
                this.max_ = aggregatedValue;
            }
            this.bitField0_ |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMax() {
            this.max_ = null;
            this.bitField0_ &= -16385;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasAvg() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public AggregatedValue getAvg() {
            AggregatedValue aggregatedValue = this.avg_;
            return aggregatedValue == null ? AggregatedValue.getDefaultInstance() : aggregatedValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvg(AggregatedValue aggregatedValue) {
            aggregatedValue.getClass();
            this.avg_ = aggregatedValue;
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAvg(AggregatedValue aggregatedValue) {
            aggregatedValue.getClass();
            AggregatedValue aggregatedValue2 = this.avg_;
            if (aggregatedValue2 != null && aggregatedValue2 != AggregatedValue.getDefaultInstance()) {
                this.avg_ = AggregatedValue.newBuilder(this.avg_).mergeFrom((AggregatedValue.Builder) aggregatedValue).buildPartial();
            } else {
                this.avg_ = aggregatedValue;
            }
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAvg() {
            this.avg_ = null;
            this.bitField0_ &= -32769;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasStartZoneOffsetSeconds() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getStartZoneOffsetSeconds() {
            return this.startZoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartZoneOffsetSeconds(int i) {
            this.bitField0_ |= 65536;
            this.startZoneOffsetSeconds_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartZoneOffsetSeconds() {
            this.bitField0_ &= -65537;
            this.startZoneOffsetSeconds_ = 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasEndZoneOffsetSeconds() {
            return (this.bitField0_ & 131072) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getEndZoneOffsetSeconds() {
            return this.endZoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndZoneOffsetSeconds(int i) {
            this.bitField0_ |= 131072;
            this.endZoneOffsetSeconds_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndZoneOffsetSeconds() {
            this.bitField0_ &= -131073;
            this.endZoneOffsetSeconds_ = 0;
        }

        private static final class SubTypeDataListsDefaultEntryHolder {
            static final MapEntryLite<String, SubTypeDataList> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, SubTypeDataList.getDefaultInstance());

            private SubTypeDataListsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, SubTypeDataList> internalGetSubTypeDataLists() {
            return this.subTypeDataLists_;
        }

        private MapFieldLite<String, SubTypeDataList> internalGetMutableSubTypeDataLists() {
            if (!this.subTypeDataLists_.isMutable()) {
                this.subTypeDataLists_ = this.subTypeDataLists_.mutableCopy();
            }
            return this.subTypeDataLists_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getSubTypeDataListsCount() {
            return internalGetSubTypeDataLists().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean containsSubTypeDataLists(String str) {
            str.getClass();
            return internalGetSubTypeDataLists().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        @Deprecated
        public Map<String, SubTypeDataList> getSubTypeDataLists() {
            return getSubTypeDataListsMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Map<String, SubTypeDataList> getSubTypeDataListsMap() {
            return Collections.unmodifiableMap(internalGetSubTypeDataLists());
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public SubTypeDataList getSubTypeDataListsOrDefault(String str, SubTypeDataList subTypeDataList) {
            str.getClass();
            MapFieldLite<String, SubTypeDataList> mapFieldLiteInternalGetSubTypeDataLists = internalGetSubTypeDataLists();
            return mapFieldLiteInternalGetSubTypeDataLists.containsKey(str) ? mapFieldLiteInternalGetSubTypeDataLists.get(str) : subTypeDataList;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public SubTypeDataList getSubTypeDataListsOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, SubTypeDataList> mapFieldLiteInternalGetSubTypeDataLists = internalGetSubTypeDataLists();
            if (!mapFieldLiteInternalGetSubTypeDataLists.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetSubTypeDataLists.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, SubTypeDataList> getMutableSubTypeDataListsMap() {
            return internalGetMutableSubTypeDataLists();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasRecordingMethod() {
            return (this.bitField0_ & 262144) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getRecordingMethod() {
            return this.recordingMethod_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecordingMethod(int i) {
            this.bitField0_ |= 262144;
            this.recordingMethod_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecordingMethod() {
            this.bitField0_ &= -262145;
            this.recordingMethod_ = 0;
        }

        public static DataPoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DataPoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DataPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DataPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DataPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DataPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DataPoint parseFrom(InputStream inputStream) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DataPoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataPoint) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DataPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataPoint dataPoint) {
            return DEFAULT_INSTANCE.createBuilder(dataPoint);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataPoint, Builder> implements DataPointOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DataPoint.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasDataType() {
                return ((DataPoint) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public DataType getDataType() {
                return ((DataPoint) this.instance).getDataType();
            }

            public Builder setDataType(DataType dataType) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataType(dataType);
                return this;
            }

            public Builder setDataType(DataType.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataType(builder.build());
                return this;
            }

            public Builder mergeDataType(DataType dataType) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeDataType(dataType);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((DataPoint) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getValuesCount() {
                return ((DataPoint) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean containsValues(String str) {
                str.getClass();
                return ((DataPoint) this.instance).getValuesMap().containsKey(str);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String str) {
                str.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((DataPoint) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Value getValuesOrDefault(String str, Value value) {
                str.getClass();
                Map<String, Value> valuesMap = ((DataPoint) this.instance).getValuesMap();
                return valuesMap.containsKey(str) ? valuesMap.get(str) : value;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Value getValuesOrThrow(String str) {
                str.getClass();
                Map<String, Value> valuesMap = ((DataPoint) this.instance).getValuesMap();
                if (!valuesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valuesMap.get(str);
            }

            public Builder putValues(String str, Value value) {
                str.getClass();
                value.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().put(str, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> map) {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().putAll(map);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasUid() {
                return ((DataPoint) this.instance).hasUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getUid() {
                return ((DataPoint) this.instance).getUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getUidBytes() {
                return ((DataPoint) this.instance).getUidBytes();
            }

            public Builder setUid(String str) {
                copyOnWrite();
                ((DataPoint) this.instance).setUid(str);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((DataPoint) this.instance).clearUid();
                return this;
            }

            public Builder setUidBytes(ByteString byteString) {
                copyOnWrite();
                ((DataPoint) this.instance).setUidBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasOriginSeriesUid() {
                return ((DataPoint) this.instance).hasOriginSeriesUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getOriginSeriesUid() {
                return ((DataPoint) this.instance).getOriginSeriesUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getOriginSeriesUidBytes() {
                return ((DataPoint) this.instance).getOriginSeriesUidBytes();
            }

            public Builder setOriginSeriesUid(String str) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSeriesUid(str);
                return this;
            }

            public Builder clearOriginSeriesUid() {
                copyOnWrite();
                ((DataPoint) this.instance).clearOriginSeriesUid();
                return this;
            }

            public Builder setOriginSeriesUidBytes(ByteString byteString) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSeriesUidBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasDataOrigin() {
                return ((DataPoint) this.instance).hasDataOrigin();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public DataOrigin getDataOrigin() {
                return ((DataPoint) this.instance).getDataOrigin();
            }

            public Builder setDataOrigin(DataOrigin dataOrigin) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataOrigin(dataOrigin);
                return this;
            }

            public Builder setDataOrigin(DataOrigin.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataOrigin(builder.build());
                return this;
            }

            public Builder mergeDataOrigin(DataOrigin dataOrigin) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeDataOrigin(dataOrigin);
                return this;
            }

            public Builder clearDataOrigin() {
                copyOnWrite();
                ((DataPoint) this.instance).clearDataOrigin();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasZoneOffsetSeconds() {
                return ((DataPoint) this.instance).hasZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getZoneOffsetSeconds() {
                return ((DataPoint) this.instance).getZoneOffsetSeconds();
            }

            public Builder setZoneOffsetSeconds(int i) {
                copyOnWrite();
                ((DataPoint) this.instance).setZoneOffsetSeconds(i);
                return this;
            }

            public Builder clearZoneOffsetSeconds() {
                copyOnWrite();
                ((DataPoint) this.instance).clearZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasUpdateTimeMillis() {
                return ((DataPoint) this.instance).hasUpdateTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getUpdateTimeMillis() {
                return ((DataPoint) this.instance).getUpdateTimeMillis();
            }

            public Builder setUpdateTimeMillis(long j) {
                copyOnWrite();
                ((DataPoint) this.instance).setUpdateTimeMillis(j);
                return this;
            }

            public Builder clearUpdateTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearUpdateTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasInstantTimeMillis() {
                return ((DataPoint) this.instance).hasInstantTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getInstantTimeMillis() {
                return ((DataPoint) this.instance).getInstantTimeMillis();
            }

            public Builder setInstantTimeMillis(long j) {
                copyOnWrite();
                ((DataPoint) this.instance).setInstantTimeMillis(j);
                return this;
            }

            public Builder clearInstantTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearInstantTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasStartTimeMillis() {
                return ((DataPoint) this.instance).hasStartTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getStartTimeMillis() {
                return ((DataPoint) this.instance).getStartTimeMillis();
            }

            public Builder setStartTimeMillis(long j) {
                copyOnWrite();
                ((DataPoint) this.instance).setStartTimeMillis(j);
                return this;
            }

            public Builder clearStartTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearStartTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasEndTimeMillis() {
                return ((DataPoint) this.instance).hasEndTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getEndTimeMillis() {
                return ((DataPoint) this.instance).getEndTimeMillis();
            }

            public Builder setEndTimeMillis(long j) {
                copyOnWrite();
                ((DataPoint) this.instance).setEndTimeMillis(j);
                return this;
            }

            public Builder clearEndTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearEndTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasClientId() {
                return ((DataPoint) this.instance).hasClientId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getClientId() {
                return ((DataPoint) this.instance).getClientId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getClientIdBytes() {
                return ((DataPoint) this.instance).getClientIdBytes();
            }

            public Builder setClientId(String str) {
                copyOnWrite();
                ((DataPoint) this.instance).setClientId(str);
                return this;
            }

            public Builder clearClientId() {
                copyOnWrite();
                ((DataPoint) this.instance).clearClientId();
                return this;
            }

            public Builder setClientIdBytes(ByteString byteString) {
                copyOnWrite();
                ((DataPoint) this.instance).setClientIdBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasClientVersion() {
                return ((DataPoint) this.instance).hasClientVersion();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getClientVersion() {
                return ((DataPoint) this.instance).getClientVersion();
            }

            public Builder setClientVersion(long j) {
                copyOnWrite();
                ((DataPoint) this.instance).setClientVersion(j);
                return this;
            }

            public Builder clearClientVersion() {
                copyOnWrite();
                ((DataPoint) this.instance).clearClientVersion();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasDevice() {
                return ((DataPoint) this.instance).hasDevice();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Device getDevice() {
                return ((DataPoint) this.instance).getDevice();
            }

            public Builder setDevice(Device device) {
                copyOnWrite();
                ((DataPoint) this.instance).setDevice(device);
                return this;
            }

            public Builder setDevice(Device.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setDevice(builder.build());
                return this;
            }

            public Builder mergeDevice(Device device) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeDevice(device);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((DataPoint) this.instance).clearDevice();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasOriginSampleUid() {
                return ((DataPoint) this.instance).hasOriginSampleUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getOriginSampleUid() {
                return ((DataPoint) this.instance).getOriginSampleUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getOriginSampleUidBytes() {
                return ((DataPoint) this.instance).getOriginSampleUidBytes();
            }

            public Builder setOriginSampleUid(String str) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSampleUid(str);
                return this;
            }

            public Builder clearOriginSampleUid() {
                copyOnWrite();
                ((DataPoint) this.instance).clearOriginSampleUid();
                return this;
            }

            public Builder setOriginSampleUidBytes(ByteString byteString) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSampleUidBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public List<SeriesValue> getSeriesValuesList() {
                return Collections.unmodifiableList(((DataPoint) this.instance).getSeriesValuesList());
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getSeriesValuesCount() {
                return ((DataPoint) this.instance).getSeriesValuesCount();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public SeriesValue getSeriesValues(int i) {
                return ((DataPoint) this.instance).getSeriesValues(i);
            }

            public Builder setSeriesValues(int i, SeriesValue seriesValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setSeriesValues(i, seriesValue);
                return this;
            }

            public Builder setSeriesValues(int i, SeriesValue.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setSeriesValues(i, builder.build());
                return this;
            }

            public Builder addSeriesValues(SeriesValue seriesValue) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(seriesValue);
                return this;
            }

            public Builder addSeriesValues(int i, SeriesValue seriesValue) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(i, seriesValue);
                return this;
            }

            public Builder addSeriesValues(SeriesValue.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(builder.build());
                return this;
            }

            public Builder addSeriesValues(int i, SeriesValue.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(i, builder.build());
                return this;
            }

            public Builder addAllSeriesValues(Iterable<? extends SeriesValue> iterable) {
                copyOnWrite();
                ((DataPoint) this.instance).addAllSeriesValues(iterable);
                return this;
            }

            public Builder clearSeriesValues() {
                copyOnWrite();
                ((DataPoint) this.instance).clearSeriesValues();
                return this;
            }

            public Builder removeSeriesValues(int i) {
                copyOnWrite();
                ((DataPoint) this.instance).removeSeriesValues(i);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasMin() {
                return ((DataPoint) this.instance).hasMin();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public AggregatedValue getMin() {
                return ((DataPoint) this.instance).getMin();
            }

            public Builder setMin(AggregatedValue aggregatedValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setMin(aggregatedValue);
                return this;
            }

            public Builder setMin(AggregatedValue.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setMin(builder.build());
                return this;
            }

            public Builder mergeMin(AggregatedValue aggregatedValue) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeMin(aggregatedValue);
                return this;
            }

            public Builder clearMin() {
                copyOnWrite();
                ((DataPoint) this.instance).clearMin();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasMax() {
                return ((DataPoint) this.instance).hasMax();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public AggregatedValue getMax() {
                return ((DataPoint) this.instance).getMax();
            }

            public Builder setMax(AggregatedValue aggregatedValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setMax(aggregatedValue);
                return this;
            }

            public Builder setMax(AggregatedValue.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setMax(builder.build());
                return this;
            }

            public Builder mergeMax(AggregatedValue aggregatedValue) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeMax(aggregatedValue);
                return this;
            }

            public Builder clearMax() {
                copyOnWrite();
                ((DataPoint) this.instance).clearMax();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasAvg() {
                return ((DataPoint) this.instance).hasAvg();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public AggregatedValue getAvg() {
                return ((DataPoint) this.instance).getAvg();
            }

            public Builder setAvg(AggregatedValue aggregatedValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setAvg(aggregatedValue);
                return this;
            }

            public Builder setAvg(AggregatedValue.Builder builder) {
                copyOnWrite();
                ((DataPoint) this.instance).setAvg(builder.build());
                return this;
            }

            public Builder mergeAvg(AggregatedValue aggregatedValue) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeAvg(aggregatedValue);
                return this;
            }

            public Builder clearAvg() {
                copyOnWrite();
                ((DataPoint) this.instance).clearAvg();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasStartZoneOffsetSeconds() {
                return ((DataPoint) this.instance).hasStartZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getStartZoneOffsetSeconds() {
                return ((DataPoint) this.instance).getStartZoneOffsetSeconds();
            }

            public Builder setStartZoneOffsetSeconds(int i) {
                copyOnWrite();
                ((DataPoint) this.instance).setStartZoneOffsetSeconds(i);
                return this;
            }

            public Builder clearStartZoneOffsetSeconds() {
                copyOnWrite();
                ((DataPoint) this.instance).clearStartZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasEndZoneOffsetSeconds() {
                return ((DataPoint) this.instance).hasEndZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getEndZoneOffsetSeconds() {
                return ((DataPoint) this.instance).getEndZoneOffsetSeconds();
            }

            public Builder setEndZoneOffsetSeconds(int i) {
                copyOnWrite();
                ((DataPoint) this.instance).setEndZoneOffsetSeconds(i);
                return this;
            }

            public Builder clearEndZoneOffsetSeconds() {
                copyOnWrite();
                ((DataPoint) this.instance).clearEndZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getSubTypeDataListsCount() {
                return ((DataPoint) this.instance).getSubTypeDataListsMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean containsSubTypeDataLists(String str) {
                str.getClass();
                return ((DataPoint) this.instance).getSubTypeDataListsMap().containsKey(str);
            }

            public Builder clearSubTypeDataLists() {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().clear();
                return this;
            }

            public Builder removeSubTypeDataLists(String str) {
                str.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            @Deprecated
            public Map<String, SubTypeDataList> getSubTypeDataLists() {
                return getSubTypeDataListsMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Map<String, SubTypeDataList> getSubTypeDataListsMap() {
                return Collections.unmodifiableMap(((DataPoint) this.instance).getSubTypeDataListsMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public SubTypeDataList getSubTypeDataListsOrDefault(String str, SubTypeDataList subTypeDataList) {
                str.getClass();
                Map<String, SubTypeDataList> subTypeDataListsMap = ((DataPoint) this.instance).getSubTypeDataListsMap();
                return subTypeDataListsMap.containsKey(str) ? subTypeDataListsMap.get(str) : subTypeDataList;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public SubTypeDataList getSubTypeDataListsOrThrow(String str) {
                str.getClass();
                Map<String, SubTypeDataList> subTypeDataListsMap = ((DataPoint) this.instance).getSubTypeDataListsMap();
                if (!subTypeDataListsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return subTypeDataListsMap.get(str);
            }

            public Builder putSubTypeDataLists(String str, SubTypeDataList subTypeDataList) {
                str.getClass();
                subTypeDataList.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().put(str, subTypeDataList);
                return this;
            }

            public Builder putAllSubTypeDataLists(Map<String, SubTypeDataList> map) {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().putAll(map);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasRecordingMethod() {
                return ((DataPoint) this.instance).hasRecordingMethod();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getRecordingMethod() {
                return ((DataPoint) this.instance).getRecordingMethod();
            }

            public Builder setRecordingMethod(int i) {
                copyOnWrite();
                ((DataPoint) this.instance).setRecordingMethod(i);
                return this;
            }

            public Builder clearRecordingMethod() {
                copyOnWrite();
                ((DataPoint) this.instance).clearRecordingMethod();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DataPoint();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0016\u0000\u0001\u0001\u0017\u0016\u0002\u0001\u0000\u0001ဉ\u0000\u00022\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဉ\u0003\u0006င\u0004\u0007ဂ\u0005\bဂ\u0006\tဂ\u0007\nဂ\b\u000bဈ\t\fဂ\n\rဉ\u000b\u000eဈ\f\u000f\u001b\u0010ဉ\r\u0011ဉ\u000e\u0012ဉ\u000f\u0013င\u0010\u0014င\u0011\u00162\u0017င\u0012", new Object[]{"bitField0_", "dataType_", "values_", ValuesDefaultEntryHolder.defaultEntry, "uid_", "originSeriesUid_", "dataOrigin_", "zoneOffsetSeconds_", "updateTimeMillis_", "instantTimeMillis_", "startTimeMillis_", "endTimeMillis_", "clientId_", "clientVersion_", "device_", "originSampleUid_", "seriesValues_", SeriesValue.class, "min_", "max_", "avg_", "startZoneOffsetSeconds_", "endZoneOffsetSeconds_", "subTypeDataLists_", SubTypeDataListsDefaultEntryHolder.defaultEntry, "recordingMethod_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DataPoint> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (DataPoint.class) {
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
            DataPoint dataPoint = new DataPoint();
            DEFAULT_INSTANCE = dataPoint;
            GeneratedMessageLite.registerDefaultInstance(DataPoint.class, dataPoint);
        }

        public static DataPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataPoint> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregatedValue extends GeneratedMessageLite<AggregatedValue, Builder> implements AggregatedValueOrBuilder {
        private static final AggregatedValue DEFAULT_INSTANCE;
        private static volatile Parser<AggregatedValue> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();

        private AggregatedValue() {
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public boolean containsValues(String str) {
            str.getClass();
            return internalGetValues().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public Value getValuesOrDefault(String str, Value value) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            return mapFieldLiteInternalGetValues.containsKey(str) ? mapFieldLiteInternalGetValues.get(str) : value;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public Value getValuesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Value> mapFieldLiteInternalGetValues = internalGetValues();
            if (!mapFieldLiteInternalGetValues.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetValues.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        public static AggregatedValue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AggregatedValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AggregatedValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AggregatedValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AggregatedValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AggregatedValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AggregatedValue parseFrom(InputStream inputStream) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregatedValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregatedValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AggregatedValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregatedValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregatedValue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregatedValue parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AggregatedValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregatedValue aggregatedValue) {
            return DEFAULT_INSTANCE.createBuilder(aggregatedValue);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregatedValue, Builder> implements AggregatedValueOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(AggregatedValue.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public int getValuesCount() {
                return ((AggregatedValue) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public boolean containsValues(String str) {
                str.getClass();
                return ((AggregatedValue) this.instance).getValuesMap().containsKey(str);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String str) {
                str.getClass();
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((AggregatedValue) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public Value getValuesOrDefault(String str, Value value) {
                str.getClass();
                Map<String, Value> valuesMap = ((AggregatedValue) this.instance).getValuesMap();
                return valuesMap.containsKey(str) ? valuesMap.get(str) : value;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public Value getValuesOrThrow(String str) {
                str.getClass();
                Map<String, Value> valuesMap = ((AggregatedValue) this.instance).getValuesMap();
                if (!valuesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valuesMap.get(str);
            }

            public Builder putValues(String str, Value value) {
                str.getClass();
                value.getClass();
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().put(str, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> map) {
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().putAll(map);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AggregatedValue();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"values_", ValuesDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AggregatedValue> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AggregatedValue.class) {
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
            AggregatedValue aggregatedValue = new AggregatedValue();
            DEFAULT_INSTANCE = aggregatedValue;
            GeneratedMessageLite.registerDefaultInstance(AggregatedValue.class, aggregatedValue);
        }

        public static AggregatedValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregatedValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateDataRow extends GeneratedMessageLite<AggregateDataRow, Builder> implements AggregateDataRowOrBuilder {
        public static final int DATA_ORIGINS_FIELD_NUMBER = 8;
        private static final AggregateDataRow DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUES_FIELD_NUMBER = 6;
        public static final int END_LOCAL_DATE_TIME_FIELD_NUMBER = 4;
        public static final int END_TIME_EPOCH_MS_FIELD_NUMBER = 2;
        public static final int LONG_VALUES_FIELD_NUMBER = 7;
        private static volatile Parser<AggregateDataRow> PARSER = null;
        public static final int START_LOCAL_DATE_TIME_FIELD_NUMBER = 3;
        public static final int START_TIME_EPOCH_MS_FIELD_NUMBER = 1;
        public static final int ZONE_OFFSET_SECONDS_FIELD_NUMBER = 5;
        private int bitField0_;
        private long endTimeEpochMs_;
        private long startTimeEpochMs_;
        private int zoneOffsetSeconds_;
        private MapFieldLite<String, Double> doubleValues_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, Long> longValues_ = MapFieldLite.emptyMapField();
        private String startLocalDateTime_ = "";
        private String endLocalDateTime_ = "";
        private Internal.ProtobufList<DataOrigin> dataOrigins_ = emptyProtobufList();

        private AggregateDataRow() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasStartTimeEpochMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
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

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasEndTimeEpochMs() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
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

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasStartLocalDateTime() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public String getStartLocalDateTime() {
            return this.startLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
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

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasEndLocalDateTime() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public String getEndLocalDateTime() {
            return this.endLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
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

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasZoneOffsetSeconds() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getZoneOffsetSeconds() {
            return this.zoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZoneOffsetSeconds(int i) {
            this.bitField0_ |= 16;
            this.zoneOffsetSeconds_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZoneOffsetSeconds() {
            this.bitField0_ &= -17;
            this.zoneOffsetSeconds_ = 0;
        }

        private static final class DoubleValuesDefaultEntryHolder {
            static final MapEntryLite<String, Double> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.DOUBLE, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));

            private DoubleValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Double> internalGetDoubleValues() {
            return this.doubleValues_;
        }

        private MapFieldLite<String, Double> internalGetMutableDoubleValues() {
            if (!this.doubleValues_.isMutable()) {
                this.doubleValues_ = this.doubleValues_.mutableCopy();
            }
            return this.doubleValues_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getDoubleValuesCount() {
            return internalGetDoubleValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean containsDoubleValues(String str) {
            str.getClass();
            return internalGetDoubleValues().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        @Deprecated
        public Map<String, Double> getDoubleValues() {
            return getDoubleValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public Map<String, Double> getDoubleValuesMap() {
            return Collections.unmodifiableMap(internalGetDoubleValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public double getDoubleValuesOrDefault(String str, double d) {
            str.getClass();
            MapFieldLite<String, Double> mapFieldLiteInternalGetDoubleValues = internalGetDoubleValues();
            return mapFieldLiteInternalGetDoubleValues.containsKey(str) ? mapFieldLiteInternalGetDoubleValues.get(str).doubleValue() : d;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public double getDoubleValuesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Double> mapFieldLiteInternalGetDoubleValues = internalGetDoubleValues();
            if (!mapFieldLiteInternalGetDoubleValues.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetDoubleValues.get(str).doubleValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Double> getMutableDoubleValuesMap() {
            return internalGetMutableDoubleValues();
        }

        private static final class LongValuesDefaultEntryHolder {
            static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

            private LongValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Long> internalGetLongValues() {
            return this.longValues_;
        }

        private MapFieldLite<String, Long> internalGetMutableLongValues() {
            if (!this.longValues_.isMutable()) {
                this.longValues_ = this.longValues_.mutableCopy();
            }
            return this.longValues_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getLongValuesCount() {
            return internalGetLongValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean containsLongValues(String str) {
            str.getClass();
            return internalGetLongValues().containsKey(str);
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        @Deprecated
        public Map<String, Long> getLongValues() {
            return getLongValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public Map<String, Long> getLongValuesMap() {
            return Collections.unmodifiableMap(internalGetLongValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public long getLongValuesOrDefault(String str, long j) {
            str.getClass();
            MapFieldLite<String, Long> mapFieldLiteInternalGetLongValues = internalGetLongValues();
            return mapFieldLiteInternalGetLongValues.containsKey(str) ? mapFieldLiteInternalGetLongValues.get(str).longValue() : j;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public long getLongValuesOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, Long> mapFieldLiteInternalGetLongValues = internalGetLongValues();
            if (!mapFieldLiteInternalGetLongValues.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetLongValues.get(str).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Long> getMutableLongValuesMap() {
            return internalGetMutableLongValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public List<DataOrigin> getDataOriginsList() {
            return this.dataOrigins_;
        }

        public List<? extends DataOriginOrBuilder> getDataOriginsOrBuilderList() {
            return this.dataOrigins_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getDataOriginsCount() {
            return this.dataOrigins_.size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public DataOrigin getDataOrigins(int i) {
            return this.dataOrigins_.get(i);
        }

        public DataOriginOrBuilder getDataOriginsOrBuilder(int i) {
            return this.dataOrigins_.get(i);
        }

        private void ensureDataOriginsIsMutable() {
            Internal.ProtobufList<DataOrigin> protobufList = this.dataOrigins_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.dataOrigins_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOrigins(int i, DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginsIsMutable();
            this.dataOrigins_.set(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigins(DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginsIsMutable();
            this.dataOrigins_.add(dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigins(int i, DataOrigin dataOrigin) {
            dataOrigin.getClass();
            ensureDataOriginsIsMutable();
            this.dataOrigins_.add(i, dataOrigin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOrigins(Iterable<? extends DataOrigin> iterable) {
            ensureDataOriginsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.dataOrigins_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOrigins() {
            this.dataOrigins_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOrigins(int i) {
            ensureDataOriginsIsMutable();
            this.dataOrigins_.remove(i);
        }

        public static AggregateDataRow parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AggregateDataRow parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AggregateDataRow parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AggregateDataRow parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AggregateDataRow parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AggregateDataRow parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AggregateDataRow parseFrom(InputStream inputStream) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateDataRow parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateDataRow parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AggregateDataRow) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AggregateDataRow parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataRow) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AggregateDataRow parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AggregateDataRow parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateDataRow aggregateDataRow) {
            return DEFAULT_INSTANCE.createBuilder(aggregateDataRow);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateDataRow, Builder> implements AggregateDataRowOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(AggregateDataRow.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasStartTimeEpochMs() {
                return ((AggregateDataRow) this.instance).hasStartTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getStartTimeEpochMs() {
                return ((AggregateDataRow) this.instance).getStartTimeEpochMs();
            }

            public Builder setStartTimeEpochMs(long j) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setStartTimeEpochMs(j);
                return this;
            }

            public Builder clearStartTimeEpochMs() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearStartTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasEndTimeEpochMs() {
                return ((AggregateDataRow) this.instance).hasEndTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getEndTimeEpochMs() {
                return ((AggregateDataRow) this.instance).getEndTimeEpochMs();
            }

            public Builder setEndTimeEpochMs(long j) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setEndTimeEpochMs(j);
                return this;
            }

            public Builder clearEndTimeEpochMs() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearEndTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasStartLocalDateTime() {
                return ((AggregateDataRow) this.instance).hasStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public String getStartLocalDateTime() {
                return ((AggregateDataRow) this.instance).getStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public ByteString getStartLocalDateTimeBytes() {
                return ((AggregateDataRow) this.instance).getStartLocalDateTimeBytes();
            }

            public Builder setStartLocalDateTime(String str) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setStartLocalDateTime(str);
                return this;
            }

            public Builder clearStartLocalDateTime() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearStartLocalDateTime();
                return this;
            }

            public Builder setStartLocalDateTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setStartLocalDateTimeBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasEndLocalDateTime() {
                return ((AggregateDataRow) this.instance).hasEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public String getEndLocalDateTime() {
                return ((AggregateDataRow) this.instance).getEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public ByteString getEndLocalDateTimeBytes() {
                return ((AggregateDataRow) this.instance).getEndLocalDateTimeBytes();
            }

            public Builder setEndLocalDateTime(String str) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setEndLocalDateTime(str);
                return this;
            }

            public Builder clearEndLocalDateTime() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearEndLocalDateTime();
                return this;
            }

            public Builder setEndLocalDateTimeBytes(ByteString byteString) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setEndLocalDateTimeBytes(byteString);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasZoneOffsetSeconds() {
                return ((AggregateDataRow) this.instance).hasZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getZoneOffsetSeconds() {
                return ((AggregateDataRow) this.instance).getZoneOffsetSeconds();
            }

            public Builder setZoneOffsetSeconds(int i) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setZoneOffsetSeconds(i);
                return this;
            }

            public Builder clearZoneOffsetSeconds() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getDoubleValuesCount() {
                return ((AggregateDataRow) this.instance).getDoubleValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean containsDoubleValues(String str) {
                str.getClass();
                return ((AggregateDataRow) this.instance).getDoubleValuesMap().containsKey(str);
            }

            public Builder clearDoubleValues() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().clear();
                return this;
            }

            public Builder removeDoubleValues(String str) {
                str.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            @Deprecated
            public Map<String, Double> getDoubleValues() {
                return getDoubleValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public Map<String, Double> getDoubleValuesMap() {
                return Collections.unmodifiableMap(((AggregateDataRow) this.instance).getDoubleValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public double getDoubleValuesOrDefault(String str, double d) {
                str.getClass();
                Map<String, Double> doubleValuesMap = ((AggregateDataRow) this.instance).getDoubleValuesMap();
                return doubleValuesMap.containsKey(str) ? doubleValuesMap.get(str).doubleValue() : d;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public double getDoubleValuesOrThrow(String str) {
                str.getClass();
                Map<String, Double> doubleValuesMap = ((AggregateDataRow) this.instance).getDoubleValuesMap();
                if (!doubleValuesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return doubleValuesMap.get(str).doubleValue();
            }

            public Builder putDoubleValues(String str, double d) {
                str.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().put(str, Double.valueOf(d));
                return this;
            }

            public Builder putAllDoubleValues(Map<String, Double> map) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().putAll(map);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getLongValuesCount() {
                return ((AggregateDataRow) this.instance).getLongValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean containsLongValues(String str) {
                str.getClass();
                return ((AggregateDataRow) this.instance).getLongValuesMap().containsKey(str);
            }

            public Builder clearLongValues() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().clear();
                return this;
            }

            public Builder removeLongValues(String str) {
                str.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().remove(str);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            @Deprecated
            public Map<String, Long> getLongValues() {
                return getLongValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public Map<String, Long> getLongValuesMap() {
                return Collections.unmodifiableMap(((AggregateDataRow) this.instance).getLongValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getLongValuesOrDefault(String str, long j) {
                str.getClass();
                Map<String, Long> longValuesMap = ((AggregateDataRow) this.instance).getLongValuesMap();
                return longValuesMap.containsKey(str) ? longValuesMap.get(str).longValue() : j;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getLongValuesOrThrow(String str) {
                str.getClass();
                Map<String, Long> longValuesMap = ((AggregateDataRow) this.instance).getLongValuesMap();
                if (!longValuesMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return longValuesMap.get(str).longValue();
            }

            public Builder putLongValues(String str, long j) {
                str.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().put(str, Long.valueOf(j));
                return this;
            }

            public Builder putAllLongValues(Map<String, Long> map) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().putAll(map);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public List<DataOrigin> getDataOriginsList() {
                return Collections.unmodifiableList(((AggregateDataRow) this.instance).getDataOriginsList());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getDataOriginsCount() {
                return ((AggregateDataRow) this.instance).getDataOriginsCount();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public DataOrigin getDataOrigins(int i) {
                return ((AggregateDataRow) this.instance).getDataOrigins(i);
            }

            public Builder setDataOrigins(int i, DataOrigin dataOrigin) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setDataOrigins(i, dataOrigin);
                return this;
            }

            public Builder setDataOrigins(int i, DataOrigin.Builder builder) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setDataOrigins(i, builder.build());
                return this;
            }

            public Builder addDataOrigins(DataOrigin dataOrigin) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(dataOrigin);
                return this;
            }

            public Builder addDataOrigins(int i, DataOrigin dataOrigin) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(i, dataOrigin);
                return this;
            }

            public Builder addDataOrigins(DataOrigin.Builder builder) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(builder.build());
                return this;
            }

            public Builder addDataOrigins(int i, DataOrigin.Builder builder) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(i, builder.build());
                return this;
            }

            public Builder addAllDataOrigins(Iterable<? extends DataOrigin> iterable) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addAllDataOrigins(iterable);
                return this;
            }

            public Builder clearDataOrigins() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearDataOrigins();
                return this;
            }

            public Builder removeDataOrigins(int i) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).removeDataOrigins(i);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AggregateDataRow();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0002\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005င\u0004\u00062\u00072\b\u001b", new Object[]{"bitField0_", "startTimeEpochMs_", "endTimeEpochMs_", "startLocalDateTime_", "endLocalDateTime_", "zoneOffsetSeconds_", "doubleValues_", DoubleValuesDefaultEntryHolder.defaultEntry, "longValues_", LongValuesDefaultEntryHolder.defaultEntry, "dataOrigins_", DataOrigin.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AggregateDataRow> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (AggregateDataRow.class) {
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
            AggregateDataRow aggregateDataRow = new AggregateDataRow();
            DEFAULT_INSTANCE = aggregateDataRow;
            GeneratedMessageLite.registerDefaultInstance(AggregateDataRow.class, aggregateDataRow);
        }

        public static AggregateDataRow getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateDataRow> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
