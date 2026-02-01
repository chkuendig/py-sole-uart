package com.android.commands.am;

import androidx.camera.video.AudioStats;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class InstrumentationData {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)src/main/proto/instrumentation-data.proto\u0012\nandroid.am\"Ï\u0001\n\u0012ResultsBundleEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\u0014\n\fvalue_string\u0018\u0002 \u0001(\t\u0012\u0011\n\tvalue_int\u0018\u0003 \u0001(\u0011\u0012\u0013\n\u000bvalue_float\u0018\u0004 \u0001(\u0002\u0012\u0014\n\fvalue_double\u0018\u0005 \u0001(\u0001\u0012\u0012\n\nvalue_long\u0018\u0006 \u0001(\u0012\u0012/\n\fvalue_bundle\u0018\u0007 \u0001(\u000b2\u0019.android.am.ResultsBundle\u0012\u0013\n\u000bvalue_bytes\u0018\b \u0001(\f\"@\n\rResultsBundle\u0012/\n\u0007entries\u0018\u0001 \u0003(\u000b2\u001e.android.am.ResultsBundleEntry\"]\n\nTestStatus\u0012\u0013\n\u000bresult_code\u0018\u0003 \u0001(\u0011\u0012*\n\u0007results\u0018\u0004 \u0001(\u000b2\u0019.android.am.ResultsBundle\u0012\u000e\n\u0006logcat\u0018\u0005 \u0001(\t\"\u0098\u0001\n\rSessionStatus\u00122\n\u000bstatus_code\u0018\u0001 \u0001(\u000e2\u001d.android.am.SessionStatusCode\u0012\u0012\n\nerror_text\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bresult_code\u0018\u0003 \u0001(\u0011\u0012*\n\u0007results\u0018\u0004 \u0001(\u000b2\u0019.android.am.ResultsBundle\"i\n\u0007Session\u0012+\n\u000btest_status\u0018\u0001 \u0003(\u000b2\u0016.android.am.TestStatus\u00121\n\u000esession_status\u0018\u0002 \u0001(\u000b2\u0019.android.am.SessionStatus*>\n\u0011SessionStatusCode\u0012\u0014\n\u0010SESSION_FINISHED\u0010\u0000\u0012\u0013\n\u000fSESSION_ABORTED\u0010\u0001B\u0019\n\u0017com.android.commands.am"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_android_am_ResultsBundleEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_android_am_ResultsBundleEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_android_am_ResultsBundle_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_android_am_ResultsBundle_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_android_am_SessionStatus_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_android_am_SessionStatus_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_android_am_Session_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_android_am_Session_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_android_am_TestStatus_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_android_am_TestStatus_fieldAccessorTable;

    public interface ResultsBundleEntryOrBuilder extends MessageOrBuilder {
        String getKey();

        ByteString getKeyBytes();

        ResultsBundle getValueBundle();

        ResultsBundleOrBuilder getValueBundleOrBuilder();

        ByteString getValueBytes();

        double getValueDouble();

        float getValueFloat();

        int getValueInt();

        long getValueLong();

        String getValueString();

        ByteString getValueStringBytes();

        boolean hasKey();

        boolean hasValueBundle();

        boolean hasValueBytes();

        boolean hasValueDouble();

        boolean hasValueFloat();

        boolean hasValueInt();

        boolean hasValueLong();

        boolean hasValueString();
    }

    public interface ResultsBundleOrBuilder extends MessageOrBuilder {
        ResultsBundleEntry getEntries(int index);

        int getEntriesCount();

        List<ResultsBundleEntry> getEntriesList();

        ResultsBundleEntryOrBuilder getEntriesOrBuilder(int index);

        List<? extends ResultsBundleEntryOrBuilder> getEntriesOrBuilderList();
    }

    public interface SessionOrBuilder extends MessageOrBuilder {
        SessionStatus getSessionStatus();

        SessionStatusOrBuilder getSessionStatusOrBuilder();

        TestStatus getTestStatus(int index);

        int getTestStatusCount();

        List<TestStatus> getTestStatusList();

        TestStatusOrBuilder getTestStatusOrBuilder(int index);

        List<? extends TestStatusOrBuilder> getTestStatusOrBuilderList();

        boolean hasSessionStatus();
    }

    public interface SessionStatusOrBuilder extends MessageOrBuilder {
        String getErrorText();

        ByteString getErrorTextBytes();

        int getResultCode();

        ResultsBundle getResults();

        ResultsBundleOrBuilder getResultsOrBuilder();

        SessionStatusCode getStatusCode();

        boolean hasErrorText();

        boolean hasResultCode();

        boolean hasResults();

        boolean hasStatusCode();
    }

    public interface TestStatusOrBuilder extends MessageOrBuilder {
        String getLogcat();

        ByteString getLogcatBytes();

        int getResultCode();

        ResultsBundle getResults();

        ResultsBundleOrBuilder getResultsOrBuilder();

        boolean hasLogcat();

        boolean hasResultCode();

        boolean hasResults();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private InstrumentationData() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    public enum SessionStatusCode implements ProtocolMessageEnum {
        SESSION_FINISHED(0),
        SESSION_ABORTED(1);

        public static final int SESSION_ABORTED_VALUE = 1;
        public static final int SESSION_FINISHED_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<SessionStatusCode> internalValueMap = new Internal.EnumLiteMap<SessionStatusCode>() { // from class: com.android.commands.am.InstrumentationData.SessionStatusCode.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SessionStatusCode findValueByNumber(int number) {
                return SessionStatusCode.forNumber(number);
            }
        };
        private static final SessionStatusCode[] VALUES = values();

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static SessionStatusCode valueOf(int value) {
            return forNumber(value);
        }

        public static SessionStatusCode forNumber(int value) {
            if (value == 0) {
                return SESSION_FINISHED;
            }
            if (value != 1) {
                return null;
            }
            return SESSION_ABORTED;
        }

        public static Internal.EnumLiteMap<SessionStatusCode> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return InstrumentationData.getDescriptor().getEnumTypes().get(0);
        }

        public static SessionStatusCode valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            return VALUES[desc.getIndex()];
        }

        SessionStatusCode(int value) {
            this.value = value;
        }
    }

    public static final class ResultsBundleEntry extends GeneratedMessageV3 implements ResultsBundleEntryOrBuilder {
        public static final int KEY_FIELD_NUMBER = 1;
        public static final int VALUE_BUNDLE_FIELD_NUMBER = 7;
        public static final int VALUE_BYTES_FIELD_NUMBER = 8;
        public static final int VALUE_DOUBLE_FIELD_NUMBER = 5;
        public static final int VALUE_FLOAT_FIELD_NUMBER = 4;
        public static final int VALUE_INT_FIELD_NUMBER = 3;
        public static final int VALUE_LONG_FIELD_NUMBER = 6;
        public static final int VALUE_STRING_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object key_;
        private byte memoizedIsInitialized;
        private ResultsBundle valueBundle_;
        private ByteString valueBytes_;
        private double valueDouble_;
        private float valueFloat_;
        private int valueInt_;
        private long valueLong_;
        private volatile Object valueString_;
        private static final ResultsBundleEntry DEFAULT_INSTANCE = new ResultsBundleEntry();

        @Deprecated
        public static final Parser<ResultsBundleEntry> PARSER = new AbstractParser<ResultsBundleEntry>() { // from class: com.android.commands.am.InstrumentationData.ResultsBundleEntry.1
            @Override // com.google.protobuf.Parser
            public ResultsBundleEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResultsBundleEntry(input, extensionRegistry);
            }
        };

        private ResultsBundleEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ResultsBundleEntry() {
            this.memoizedIsInitialized = (byte) -1;
            this.key_ = "";
            this.valueString_ = "";
            this.valueBytes_ = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ResultsBundleEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ResultsBundleEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            extensionRegistry.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = input.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                ByteString bytes = input.readBytes();
                                this.bitField0_ = 1 | this.bitField0_;
                                this.key_ = bytes;
                            } else if (tag == 18) {
                                ByteString bytes2 = input.readBytes();
                                this.bitField0_ |= 2;
                                this.valueString_ = bytes2;
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.valueInt_ = input.readSInt32();
                            } else if (tag == 37) {
                                this.bitField0_ |= 8;
                                this.valueFloat_ = input.readFloat();
                            } else if (tag == 41) {
                                this.bitField0_ |= 16;
                                this.valueDouble_ = input.readDouble();
                            } else if (tag == 48) {
                                this.bitField0_ |= 32;
                                this.valueLong_ = input.readSInt64();
                            } else if (tag == 58) {
                                ResultsBundle.Builder builder = (this.bitField0_ & 64) != 0 ? this.valueBundle_.toBuilder() : null;
                                ResultsBundle resultsBundle = (ResultsBundle) input.readMessage(ResultsBundle.PARSER, extensionRegistry);
                                this.valueBundle_ = resultsBundle;
                                if (builder != null) {
                                    builder.mergeFrom(resultsBundle);
                                    this.valueBundle_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 64;
                            } else if (tag == 66) {
                                this.bitField0_ |= 128;
                                this.valueBytes_ = input.readBytes();
                            } else if (!parseUnknownField(input, builderNewBuilder, extensionRegistry, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstrumentationData.internal_static_android_am_ResultsBundleEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstrumentationData.internal_static_android_am_ResultsBundleEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(ResultsBundleEntry.class, Builder.class);
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasKey() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public String getKey() {
            Object obj = this.key_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.key_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public ByteString getKeyBytes() {
            Object obj = this.key_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.key_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueString() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public String getValueString() {
            Object obj = this.valueString_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.valueString_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public ByteString getValueStringBytes() {
            Object obj = this.valueString_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.valueString_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueInt() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public int getValueInt() {
            return this.valueInt_;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueFloat() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public float getValueFloat() {
            return this.valueFloat_;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueDouble() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public double getValueDouble() {
            return this.valueDouble_;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueLong() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public long getValueLong() {
            return this.valueLong_;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueBundle() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public ResultsBundle getValueBundle() {
            ResultsBundle resultsBundle = this.valueBundle_;
            return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public ResultsBundleOrBuilder getValueBundleOrBuilder() {
            ResultsBundle resultsBundle = this.valueBundle_;
            return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public boolean hasValueBytes() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
        public ByteString getValueBytes() {
            return this.valueBytes_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                GeneratedMessageV3.writeString(output, 1, this.key_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(output, 2, this.valueString_);
            }
            if ((this.bitField0_ & 4) != 0) {
                output.writeSInt32(3, this.valueInt_);
            }
            if ((this.bitField0_ & 8) != 0) {
                output.writeFloat(4, this.valueFloat_);
            }
            if ((this.bitField0_ & 16) != 0) {
                output.writeDouble(5, this.valueDouble_);
            }
            if ((this.bitField0_ & 32) != 0) {
                output.writeSInt64(6, this.valueLong_);
            }
            if ((this.bitField0_ & 64) != 0) {
                output.writeMessage(7, getValueBundle());
            }
            if ((this.bitField0_ & 128) != 0) {
                output.writeBytes(8, this.valueBytes_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeStringSize = (this.bitField0_ & 1) != 0 ? GeneratedMessageV3.computeStringSize(1, this.key_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeStringSize += GeneratedMessageV3.computeStringSize(2, this.valueString_);
            }
            if ((this.bitField0_ & 4) != 0) {
                iComputeStringSize += CodedOutputStream.computeSInt32Size(3, this.valueInt_);
            }
            if ((this.bitField0_ & 8) != 0) {
                iComputeStringSize += CodedOutputStream.computeFloatSize(4, this.valueFloat_);
            }
            if ((this.bitField0_ & 16) != 0) {
                iComputeStringSize += CodedOutputStream.computeDoubleSize(5, this.valueDouble_);
            }
            if ((this.bitField0_ & 32) != 0) {
                iComputeStringSize += CodedOutputStream.computeSInt64Size(6, this.valueLong_);
            }
            if ((this.bitField0_ & 64) != 0) {
                iComputeStringSize += CodedOutputStream.computeMessageSize(7, getValueBundle());
            }
            if ((this.bitField0_ & 128) != 0) {
                iComputeStringSize += CodedOutputStream.computeBytesSize(8, this.valueBytes_);
            }
            int serializedSize = iComputeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResultsBundleEntry)) {
                return super.equals(obj);
            }
            ResultsBundleEntry resultsBundleEntry = (ResultsBundleEntry) obj;
            if (hasKey() != resultsBundleEntry.hasKey()) {
                return false;
            }
            if ((hasKey() && !getKey().equals(resultsBundleEntry.getKey())) || hasValueString() != resultsBundleEntry.hasValueString()) {
                return false;
            }
            if ((hasValueString() && !getValueString().equals(resultsBundleEntry.getValueString())) || hasValueInt() != resultsBundleEntry.hasValueInt()) {
                return false;
            }
            if ((hasValueInt() && getValueInt() != resultsBundleEntry.getValueInt()) || hasValueFloat() != resultsBundleEntry.hasValueFloat()) {
                return false;
            }
            if ((hasValueFloat() && Float.floatToIntBits(getValueFloat()) != Float.floatToIntBits(resultsBundleEntry.getValueFloat())) || hasValueDouble() != resultsBundleEntry.hasValueDouble()) {
                return false;
            }
            if ((hasValueDouble() && Double.doubleToLongBits(getValueDouble()) != Double.doubleToLongBits(resultsBundleEntry.getValueDouble())) || hasValueLong() != resultsBundleEntry.hasValueLong()) {
                return false;
            }
            if ((hasValueLong() && getValueLong() != resultsBundleEntry.getValueLong()) || hasValueBundle() != resultsBundleEntry.hasValueBundle()) {
                return false;
            }
            if ((!hasValueBundle() || getValueBundle().equals(resultsBundleEntry.getValueBundle())) && hasValueBytes() == resultsBundleEntry.hasValueBytes()) {
                return (!hasValueBytes() || getValueBytes().equals(resultsBundleEntry.getValueBytes())) && this.unknownFields.equals(resultsBundleEntry.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode();
            if (hasKey()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getKey().hashCode();
            }
            if (hasValueString()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getValueString().hashCode();
            }
            if (hasValueInt()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getValueInt();
            }
            if (hasValueFloat()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + Float.floatToIntBits(getValueFloat());
            }
            if (hasValueDouble()) {
                iHashCode = (((iHashCode * 37) + 5) * 53) + Internal.hashLong(Double.doubleToLongBits(getValueDouble()));
            }
            if (hasValueLong()) {
                iHashCode = (((iHashCode * 37) + 6) * 53) + Internal.hashLong(getValueLong());
            }
            if (hasValueBundle()) {
                iHashCode = (((iHashCode * 37) + 7) * 53) + getValueBundle().hashCode();
            }
            if (hasValueBytes()) {
                iHashCode = (((iHashCode * 37) + 8) * 53) + getValueBytes().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static ResultsBundleEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResultsBundleEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResultsBundleEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResultsBundleEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResultsBundleEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResultsBundleEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResultsBundleEntry parseFrom(InputStream input) throws IOException {
            return (ResultsBundleEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResultsBundleEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResultsBundleEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResultsBundleEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (ResultsBundleEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ResultsBundleEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResultsBundleEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResultsBundleEntry parseFrom(CodedInputStream input) throws IOException {
            return (ResultsBundleEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResultsBundleEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResultsBundleEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ResultsBundleEntry prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResultsBundleEntryOrBuilder {
            private int bitField0_;
            private Object key_;
            private SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> valueBundleBuilder_;
            private ResultsBundle valueBundle_;
            private ByteString valueBytes_;
            private double valueDouble_;
            private float valueFloat_;
            private int valueInt_;
            private long valueLong_;
            private Object valueString_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return InstrumentationData.internal_static_android_am_ResultsBundleEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstrumentationData.internal_static_android_am_ResultsBundleEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(ResultsBundleEntry.class, Builder.class);
            }

            private Builder() {
                this.key_ = "";
                this.valueString_ = "";
                this.valueBytes_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.key_ = "";
                this.valueString_ = "";
                this.valueBytes_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResultsBundleEntry.alwaysUseFieldBuilders) {
                    getValueBundleFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.key_ = "";
                int i = this.bitField0_;
                this.valueString_ = "";
                this.valueInt_ = 0;
                this.valueFloat_ = 0.0f;
                this.valueDouble_ = AudioStats.AUDIO_AMPLITUDE_NONE;
                this.valueLong_ = 0L;
                this.bitField0_ = i & (-64);
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.valueBundle_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -65;
                this.valueBytes_ = ByteString.EMPTY;
                this.bitField0_ &= -129;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstrumentationData.internal_static_android_am_ResultsBundleEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ResultsBundleEntry getDefaultInstanceForType() {
                return ResultsBundleEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResultsBundleEntry build() {
                ResultsBundleEntry resultsBundleEntryBuildPartial = buildPartial();
                if (resultsBundleEntryBuildPartial.isInitialized()) {
                    return resultsBundleEntryBuildPartial;
                }
                throw newUninitializedMessageException((Message) resultsBundleEntryBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResultsBundleEntry buildPartial() {
                ResultsBundleEntry resultsBundleEntry = new ResultsBundleEntry(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 0 ? 1 : 0;
                resultsBundleEntry.key_ = this.key_;
                if ((i & 2) != 0) {
                    i2 |= 2;
                }
                resultsBundleEntry.valueString_ = this.valueString_;
                if ((i & 4) != 0) {
                    resultsBundleEntry.valueInt_ = this.valueInt_;
                    i2 |= 4;
                }
                if ((i & 8) != 0) {
                    resultsBundleEntry.valueFloat_ = this.valueFloat_;
                    i2 |= 8;
                }
                if ((i & 16) != 0) {
                    resultsBundleEntry.valueDouble_ = this.valueDouble_;
                    i2 |= 16;
                }
                if ((i & 32) != 0) {
                    resultsBundleEntry.valueLong_ = this.valueLong_;
                    i2 |= 32;
                }
                if ((i & 64) != 0) {
                    SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        resultsBundleEntry.valueBundle_ = this.valueBundle_;
                    } else {
                        resultsBundleEntry.valueBundle_ = (ResultsBundle) singleFieldBuilderV3.build();
                    }
                    i2 |= 64;
                }
                if ((i & 128) != 0) {
                    i2 |= 128;
                }
                resultsBundleEntry.valueBytes_ = this.valueBytes_;
                resultsBundleEntry.bitField0_ = i2;
                onBuilt();
                return resultsBundleEntry;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo7987clone() {
                return (Builder) super.mo7987clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof ResultsBundleEntry) {
                    return mergeFrom((ResultsBundleEntry) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResultsBundleEntry other) {
                if (other == ResultsBundleEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.hasKey()) {
                    this.bitField0_ |= 1;
                    this.key_ = other.key_;
                    onChanged();
                }
                if (other.hasValueString()) {
                    this.bitField0_ |= 2;
                    this.valueString_ = other.valueString_;
                    onChanged();
                }
                if (other.hasValueInt()) {
                    setValueInt(other.getValueInt());
                }
                if (other.hasValueFloat()) {
                    setValueFloat(other.getValueFloat());
                }
                if (other.hasValueDouble()) {
                    setValueDouble(other.getValueDouble());
                }
                if (other.hasValueLong()) {
                    setValueLong(other.getValueLong());
                }
                if (other.hasValueBundle()) {
                    mergeValueBundle(other.getValueBundle());
                }
                if (other.hasValueBytes()) {
                    setValueBytes(other.getValueBytes());
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.commands.am.InstrumentationData.ResultsBundleEntry.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.android.commands.am.InstrumentationData$ResultsBundleEntry> r1 = com.android.commands.am.InstrumentationData.ResultsBundleEntry.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.android.commands.am.InstrumentationData$ResultsBundleEntry r3 = (com.android.commands.am.InstrumentationData.ResultsBundleEntry) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.android.commands.am.InstrumentationData$ResultsBundleEntry r4 = (com.android.commands.am.InstrumentationData.ResultsBundleEntry) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.commands.am.InstrumentationData.ResultsBundleEntry.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.commands.am.InstrumentationData$ResultsBundleEntry$Builder");
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasKey() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public String getKey() {
                Object obj = this.key_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.key_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public ByteString getKeyBytes() {
                Object obj = this.key_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.key_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setKey(String value) {
                value.getClass();
                this.bitField0_ |= 1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -2;
                this.key_ = ResultsBundleEntry.getDefaultInstance().getKey();
                onChanged();
                return this;
            }

            public Builder setKeyBytes(ByteString value) {
                value.getClass();
                this.bitField0_ |= 1;
                this.key_ = value;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueString() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public String getValueString() {
                Object obj = this.valueString_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.valueString_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public ByteString getValueStringBytes() {
                Object obj = this.valueString_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.valueString_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setValueString(String value) {
                value.getClass();
                this.bitField0_ |= 2;
                this.valueString_ = value;
                onChanged();
                return this;
            }

            public Builder clearValueString() {
                this.bitField0_ &= -3;
                this.valueString_ = ResultsBundleEntry.getDefaultInstance().getValueString();
                onChanged();
                return this;
            }

            public Builder setValueStringBytes(ByteString value) {
                value.getClass();
                this.bitField0_ |= 2;
                this.valueString_ = value;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueInt() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public int getValueInt() {
                return this.valueInt_;
            }

            public Builder setValueInt(int value) {
                this.bitField0_ |= 4;
                this.valueInt_ = value;
                onChanged();
                return this;
            }

            public Builder clearValueInt() {
                this.bitField0_ &= -5;
                this.valueInt_ = 0;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueFloat() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public float getValueFloat() {
                return this.valueFloat_;
            }

            public Builder setValueFloat(float value) {
                this.bitField0_ |= 8;
                this.valueFloat_ = value;
                onChanged();
                return this;
            }

            public Builder clearValueFloat() {
                this.bitField0_ &= -9;
                this.valueFloat_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueDouble() {
                return (this.bitField0_ & 16) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public double getValueDouble() {
                return this.valueDouble_;
            }

            public Builder setValueDouble(double value) {
                this.bitField0_ |= 16;
                this.valueDouble_ = value;
                onChanged();
                return this;
            }

            public Builder clearValueDouble() {
                this.bitField0_ &= -17;
                this.valueDouble_ = AudioStats.AUDIO_AMPLITUDE_NONE;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueLong() {
                return (this.bitField0_ & 32) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public long getValueLong() {
                return this.valueLong_;
            }

            public Builder setValueLong(long value) {
                this.bitField0_ |= 32;
                this.valueLong_ = value;
                onChanged();
                return this;
            }

            public Builder clearValueLong() {
                this.bitField0_ &= -33;
                this.valueLong_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueBundle() {
                return (this.bitField0_ & 64) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public ResultsBundle getValueBundle() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    ResultsBundle resultsBundle = this.valueBundle_;
                    return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
                }
                return (ResultsBundle) singleFieldBuilderV3.getMessage();
            }

            public Builder setValueBundle(ResultsBundle value) {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    value.getClass();
                    this.valueBundle_ = value;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(value);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setValueBundle(ResultsBundle.Builder builderForValue) {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.valueBundle_ = builderForValue.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeValueBundle(ResultsBundle value) {
                ResultsBundle resultsBundle;
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 64) != 0 && (resultsBundle = this.valueBundle_) != null && resultsBundle != ResultsBundle.getDefaultInstance()) {
                        this.valueBundle_ = ResultsBundle.newBuilder(this.valueBundle_).mergeFrom(value).buildPartial();
                    } else {
                        this.valueBundle_ = value;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(value);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder clearValueBundle() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.valueBundle_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public ResultsBundle.Builder getValueBundleBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return (ResultsBundle.Builder) getValueBundleFieldBuilder().getBuilder();
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public ResultsBundleOrBuilder getValueBundleOrBuilder() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.valueBundleBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (ResultsBundleOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                ResultsBundle resultsBundle = this.valueBundle_;
                return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
            }

            private SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> getValueBundleFieldBuilder() {
                if (this.valueBundleBuilder_ == null) {
                    this.valueBundleBuilder_ = new SingleFieldBuilderV3<>(getValueBundle(), getParentForChildren(), isClean());
                    this.valueBundle_ = null;
                }
                return this.valueBundleBuilder_;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public boolean hasValueBytes() {
                return (this.bitField0_ & 128) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleEntryOrBuilder
            public ByteString getValueBytes() {
                return this.valueBytes_;
            }

            public Builder setValueBytes(ByteString value) {
                value.getClass();
                this.bitField0_ |= 128;
                this.valueBytes_ = value;
                onChanged();
                return this;
            }

            public Builder clearValueBytes() {
                this.bitField0_ &= -129;
                this.valueBytes_ = ResultsBundleEntry.getDefaultInstance().getValueBytes();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        public static ResultsBundleEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ResultsBundleEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ResultsBundleEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResultsBundleEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class ResultsBundle extends GeneratedMessageV3 implements ResultsBundleOrBuilder {
        public static final int ENTRIES_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<ResultsBundleEntry> entries_;
        private byte memoizedIsInitialized;
        private static final ResultsBundle DEFAULT_INSTANCE = new ResultsBundle();

        @Deprecated
        public static final Parser<ResultsBundle> PARSER = new AbstractParser<ResultsBundle>() { // from class: com.android.commands.am.InstrumentationData.ResultsBundle.1
            @Override // com.google.protobuf.Parser
            public ResultsBundle parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResultsBundle(input, extensionRegistry);
            }
        };

        private ResultsBundle(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ResultsBundle() {
            this.memoizedIsInitialized = (byte) -1;
            this.entries_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ResultsBundle();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ResultsBundle(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            extensionRegistry.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int tag = input.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if (!z2) {
                                    this.entries_ = new ArrayList();
                                    z2 = true;
                                }
                                this.entries_.add((ResultsBundleEntry) input.readMessage(ResultsBundleEntry.PARSER, extensionRegistry));
                            } else if (!parseUnknownField(input, builderNewBuilder, extensionRegistry, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2) {
                        this.entries_ = Collections.unmodifiableList(this.entries_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstrumentationData.internal_static_android_am_ResultsBundle_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstrumentationData.internal_static_android_am_ResultsBundle_fieldAccessorTable.ensureFieldAccessorsInitialized(ResultsBundle.class, Builder.class);
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
        public List<ResultsBundleEntry> getEntriesList() {
            return this.entries_;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
        public List<? extends ResultsBundleEntryOrBuilder> getEntriesOrBuilderList() {
            return this.entries_;
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
        public int getEntriesCount() {
            return this.entries_.size();
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
        public ResultsBundleEntry getEntries(int index) {
            return this.entries_.get(index);
        }

        @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
        public ResultsBundleEntryOrBuilder getEntriesOrBuilder(int index) {
            return this.entries_.get(index);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.entries_.size(); i++) {
                output.writeMessage(1, this.entries_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.entries_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.entries_.get(i2));
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ResultsBundle)) {
                return super.equals(obj);
            }
            ResultsBundle resultsBundle = (ResultsBundle) obj;
            return getEntriesList().equals(resultsBundle.getEntriesList()) && this.unknownFields.equals(resultsBundle.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode();
            if (getEntriesCount() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getEntriesList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static ResultsBundle parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResultsBundle parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResultsBundle parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResultsBundle parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResultsBundle parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResultsBundle parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResultsBundle parseFrom(InputStream input) throws IOException {
            return (ResultsBundle) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResultsBundle parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResultsBundle) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResultsBundle parseDelimitedFrom(InputStream input) throws IOException {
            return (ResultsBundle) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ResultsBundle parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResultsBundle) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResultsBundle parseFrom(CodedInputStream input) throws IOException {
            return (ResultsBundle) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResultsBundle parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResultsBundle) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ResultsBundle prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResultsBundleOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> entriesBuilder_;
            private List<ResultsBundleEntry> entries_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return InstrumentationData.internal_static_android_am_ResultsBundle_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstrumentationData.internal_static_android_am_ResultsBundle_fieldAccessorTable.ensureFieldAccessorsInitialized(ResultsBundle.class, Builder.class);
            }

            private Builder() {
                this.entries_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.entries_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResultsBundle.alwaysUseFieldBuilders) {
                    getEntriesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.entries_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstrumentationData.internal_static_android_am_ResultsBundle_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ResultsBundle getDefaultInstanceForType() {
                return ResultsBundle.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResultsBundle build() {
                ResultsBundle resultsBundleBuildPartial = buildPartial();
                if (resultsBundleBuildPartial.isInitialized()) {
                    return resultsBundleBuildPartial;
                }
                throw newUninitializedMessageException((Message) resultsBundleBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResultsBundle buildPartial() {
                ResultsBundle resultsBundle = new ResultsBundle(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.entries_ = Collections.unmodifiableList(this.entries_);
                        this.bitField0_ &= -2;
                    }
                    resultsBundle.entries_ = this.entries_;
                } else {
                    resultsBundle.entries_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return resultsBundle;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone, reason: merged with bridge method [inline-methods] */
            public Builder mo7987clone() {
                return (Builder) super.mo7987clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof ResultsBundle) {
                    return mergeFrom((ResultsBundle) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResultsBundle other) {
                if (other == ResultsBundle.getDefaultInstance()) {
                    return this;
                }
                if (this.entriesBuilder_ == null) {
                    if (!other.entries_.isEmpty()) {
                        if (this.entries_.isEmpty()) {
                            this.entries_ = other.entries_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureEntriesIsMutable();
                            this.entries_.addAll(other.entries_);
                        }
                        onChanged();
                    }
                } else if (!other.entries_.isEmpty()) {
                    if (!this.entriesBuilder_.isEmpty()) {
                        this.entriesBuilder_.addAllMessages(other.entries_);
                    } else {
                        this.entriesBuilder_.dispose();
                        this.entriesBuilder_ = null;
                        this.entries_ = other.entries_;
                        this.bitField0_ &= -2;
                        this.entriesBuilder_ = ResultsBundle.alwaysUseFieldBuilders ? getEntriesFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.commands.am.InstrumentationData.ResultsBundle.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.android.commands.am.InstrumentationData$ResultsBundle> r1 = com.android.commands.am.InstrumentationData.ResultsBundle.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.android.commands.am.InstrumentationData$ResultsBundle r3 = (com.android.commands.am.InstrumentationData.ResultsBundle) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.android.commands.am.InstrumentationData$ResultsBundle r4 = (com.android.commands.am.InstrumentationData.ResultsBundle) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.commands.am.InstrumentationData.ResultsBundle.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.commands.am.InstrumentationData$ResultsBundle$Builder");
            }

            private void ensureEntriesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.entries_ = new ArrayList(this.entries_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
            public List<ResultsBundleEntry> getEntriesList() {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.entries_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
            public int getEntriesCount() {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.entries_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
            public ResultsBundleEntry getEntries(int index) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.entries_.get(index);
                }
                return (ResultsBundleEntry) repeatedFieldBuilderV3.getMessage(index);
            }

            public Builder setEntries(int index, ResultsBundleEntry value) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureEntriesIsMutable();
                    this.entries_.set(index, value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(index, value);
                }
                return this;
            }

            public Builder setEntries(int index, ResultsBundleEntry.Builder builderForValue) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEntriesIsMutable();
                    this.entries_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEntries(ResultsBundleEntry value) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureEntriesIsMutable();
                    this.entries_.add(value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(value);
                }
                return this;
            }

            public Builder addEntries(int index, ResultsBundleEntry value) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureEntriesIsMutable();
                    this.entries_.add(index, value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(index, value);
                }
                return this;
            }

            public Builder addEntries(ResultsBundleEntry.Builder builderForValue) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEntriesIsMutable();
                    this.entries_.add(builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEntries(int index, ResultsBundleEntry.Builder builderForValue) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEntriesIsMutable();
                    this.entries_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEntries(Iterable<? extends ResultsBundleEntry> values) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEntriesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.entries_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEntries() {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.entries_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeEntries(int index) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureEntriesIsMutable();
                    this.entries_.remove(index);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(index);
                }
                return this;
            }

            public ResultsBundleEntry.Builder getEntriesBuilder(int index) {
                return (ResultsBundleEntry.Builder) getEntriesFieldBuilder().getBuilder(index);
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
            public ResultsBundleEntryOrBuilder getEntriesOrBuilder(int index) {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.entries_.get(index);
                }
                return (ResultsBundleEntryOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(index);
            }

            @Override // com.android.commands.am.InstrumentationData.ResultsBundleOrBuilder
            public List<? extends ResultsBundleEntryOrBuilder> getEntriesOrBuilderList() {
                RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> repeatedFieldBuilderV3 = this.entriesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.entries_);
            }

            public ResultsBundleEntry.Builder addEntriesBuilder() {
                return (ResultsBundleEntry.Builder) getEntriesFieldBuilder().addBuilder(ResultsBundleEntry.getDefaultInstance());
            }

            public ResultsBundleEntry.Builder addEntriesBuilder(int index) {
                return (ResultsBundleEntry.Builder) getEntriesFieldBuilder().addBuilder(index, ResultsBundleEntry.getDefaultInstance());
            }

            public List<ResultsBundleEntry.Builder> getEntriesBuilderList() {
                return getEntriesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ResultsBundleEntry, ResultsBundleEntry.Builder, ResultsBundleEntryOrBuilder> getEntriesFieldBuilder() {
                if (this.entriesBuilder_ == null) {
                    this.entriesBuilder_ = new RepeatedFieldBuilderV3<>(this.entries_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.entries_ = null;
                }
                return this.entriesBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        public static ResultsBundle getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ResultsBundle> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ResultsBundle> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResultsBundle getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class TestStatus extends GeneratedMessageV3 implements TestStatusOrBuilder {
        public static final int LOGCAT_FIELD_NUMBER = 5;
        public static final int RESULTS_FIELD_NUMBER = 4;
        public static final int RESULT_CODE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object logcat_;
        private byte memoizedIsInitialized;
        private int resultCode_;
        private ResultsBundle results_;
        private static final TestStatus DEFAULT_INSTANCE = new TestStatus();

        @Deprecated
        public static final Parser<TestStatus> PARSER = new AbstractParser<TestStatus>() { // from class: com.android.commands.am.InstrumentationData.TestStatus.1
            @Override // com.google.protobuf.Parser
            public TestStatus parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TestStatus(input, extensionRegistry);
            }
        };

        private TestStatus(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private TestStatus() {
            this.memoizedIsInitialized = (byte) -1;
            this.logcat_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TestStatus();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TestStatus(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            extensionRegistry.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = input.readTag();
                            if (tag != 0) {
                                if (tag == 24) {
                                    this.bitField0_ |= 1;
                                    this.resultCode_ = input.readSInt32();
                                } else if (tag == 34) {
                                    ResultsBundle.Builder builder = (this.bitField0_ & 2) != 0 ? this.results_.toBuilder() : null;
                                    ResultsBundle resultsBundle = (ResultsBundle) input.readMessage(ResultsBundle.PARSER, extensionRegistry);
                                    this.results_ = resultsBundle;
                                    if (builder != null) {
                                        builder.mergeFrom(resultsBundle);
                                        this.results_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (tag == 42) {
                                    ByteString bytes = input.readBytes();
                                    this.bitField0_ |= 4;
                                    this.logcat_ = bytes;
                                } else if (!parseUnknownField(input, builderNewBuilder, extensionRegistry, tag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstrumentationData.internal_static_android_am_TestStatus_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstrumentationData.internal_static_android_am_TestStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(TestStatus.class, Builder.class);
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public boolean hasResultCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public int getResultCode() {
            return this.resultCode_;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public boolean hasResults() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public ResultsBundle getResults() {
            ResultsBundle resultsBundle = this.results_;
            return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public ResultsBundleOrBuilder getResultsOrBuilder() {
            ResultsBundle resultsBundle = this.results_;
            return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public boolean hasLogcat() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public String getLogcat() {
            Object obj = this.logcat_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.logcat_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
        public ByteString getLogcatBytes() {
            Object obj = this.logcat_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.logcat_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                output.writeSInt32(3, this.resultCode_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeMessage(4, getResults());
            }
            if ((this.bitField0_ & 4) != 0) {
                GeneratedMessageV3.writeString(output, 5, this.logcat_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeSInt32Size = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeSInt32Size(3, this.resultCode_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeSInt32Size += CodedOutputStream.computeMessageSize(4, getResults());
            }
            if ((this.bitField0_ & 4) != 0) {
                iComputeSInt32Size += GeneratedMessageV3.computeStringSize(5, this.logcat_);
            }
            int serializedSize = iComputeSInt32Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TestStatus)) {
                return super.equals(obj);
            }
            TestStatus testStatus = (TestStatus) obj;
            if (hasResultCode() != testStatus.hasResultCode()) {
                return false;
            }
            if ((hasResultCode() && getResultCode() != testStatus.getResultCode()) || hasResults() != testStatus.hasResults()) {
                return false;
            }
            if ((!hasResults() || getResults().equals(testStatus.getResults())) && hasLogcat() == testStatus.hasLogcat()) {
                return (!hasLogcat() || getLogcat().equals(testStatus.getLogcat())) && this.unknownFields.equals(testStatus.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode();
            if (hasResultCode()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getResultCode();
            }
            if (hasResults()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getResults().hashCode();
            }
            if (hasLogcat()) {
                iHashCode = (((iHashCode * 37) + 5) * 53) + getLogcat().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static TestStatus parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TestStatus parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TestStatus parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TestStatus parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TestStatus parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TestStatus parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TestStatus parseFrom(InputStream input) throws IOException {
            return (TestStatus) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TestStatus parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TestStatus) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TestStatus parseDelimitedFrom(InputStream input) throws IOException {
            return (TestStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TestStatus parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TestStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TestStatus parseFrom(CodedInputStream input) throws IOException {
            return (TestStatus) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TestStatus parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TestStatus) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TestStatus prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TestStatusOrBuilder {
            private int bitField0_;
            private Object logcat_;
            private int resultCode_;
            private SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> resultsBuilder_;
            private ResultsBundle results_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return InstrumentationData.internal_static_android_am_TestStatus_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstrumentationData.internal_static_android_am_TestStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(TestStatus.class, Builder.class);
            }

            private Builder() {
                this.logcat_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.logcat_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TestStatus.alwaysUseFieldBuilders) {
                    getResultsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.resultCode_ = 0;
                this.bitField0_ &= -2;
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.results_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                int i = this.bitField0_;
                this.logcat_ = "";
                this.bitField0_ = i & (-7);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstrumentationData.internal_static_android_am_TestStatus_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TestStatus getDefaultInstanceForType() {
                return TestStatus.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TestStatus build() {
                TestStatus testStatusBuildPartial = buildPartial();
                if (testStatusBuildPartial.isInitialized()) {
                    return testStatusBuildPartial;
                }
                throw newUninitializedMessageException((Message) testStatusBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TestStatus buildPartial() {
                int i;
                TestStatus testStatus = new TestStatus(this);
                int i2 = this.bitField0_;
                if ((i2 & 1) != 0) {
                    testStatus.resultCode_ = this.resultCode_;
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i2 & 2) != 0) {
                    SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        testStatus.results_ = this.results_;
                    } else {
                        testStatus.results_ = (ResultsBundle) singleFieldBuilderV3.build();
                    }
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    i |= 4;
                }
                testStatus.logcat_ = this.logcat_;
                testStatus.bitField0_ = i;
                onBuilt();
                return testStatus;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo7987clone() {
                return (Builder) super.mo7987clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof TestStatus) {
                    return mergeFrom((TestStatus) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TestStatus other) {
                if (other == TestStatus.getDefaultInstance()) {
                    return this;
                }
                if (other.hasResultCode()) {
                    setResultCode(other.getResultCode());
                }
                if (other.hasResults()) {
                    mergeResults(other.getResults());
                }
                if (other.hasLogcat()) {
                    this.bitField0_ |= 4;
                    this.logcat_ = other.logcat_;
                    onChanged();
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.commands.am.InstrumentationData.TestStatus.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.android.commands.am.InstrumentationData$TestStatus> r1 = com.android.commands.am.InstrumentationData.TestStatus.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.android.commands.am.InstrumentationData$TestStatus r3 = (com.android.commands.am.InstrumentationData.TestStatus) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.android.commands.am.InstrumentationData$TestStatus r4 = (com.android.commands.am.InstrumentationData.TestStatus) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.commands.am.InstrumentationData.TestStatus.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.commands.am.InstrumentationData$TestStatus$Builder");
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public boolean hasResultCode() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public int getResultCode() {
                return this.resultCode_;
            }

            public Builder setResultCode(int value) {
                this.bitField0_ |= 1;
                this.resultCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearResultCode() {
                this.bitField0_ &= -2;
                this.resultCode_ = 0;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public boolean hasResults() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public ResultsBundle getResults() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    ResultsBundle resultsBundle = this.results_;
                    return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
                }
                return (ResultsBundle) singleFieldBuilderV3.getMessage();
            }

            public Builder setResults(ResultsBundle value) {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    value.getClass();
                    this.results_ = value;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(value);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setResults(ResultsBundle.Builder builderForValue) {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.results_ = builderForValue.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeResults(ResultsBundle value) {
                ResultsBundle resultsBundle;
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0 && (resultsBundle = this.results_) != null && resultsBundle != ResultsBundle.getDefaultInstance()) {
                        this.results_ = ResultsBundle.newBuilder(this.results_).mergeFrom(value).buildPartial();
                    } else {
                        this.results_ = value;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(value);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearResults() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.results_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public ResultsBundle.Builder getResultsBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return (ResultsBundle.Builder) getResultsFieldBuilder().getBuilder();
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public ResultsBundleOrBuilder getResultsOrBuilder() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (ResultsBundleOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                ResultsBundle resultsBundle = this.results_;
                return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
            }

            private SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> getResultsFieldBuilder() {
                if (this.resultsBuilder_ == null) {
                    this.resultsBuilder_ = new SingleFieldBuilderV3<>(getResults(), getParentForChildren(), isClean());
                    this.results_ = null;
                }
                return this.resultsBuilder_;
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public boolean hasLogcat() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public String getLogcat() {
                Object obj = this.logcat_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.logcat_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.commands.am.InstrumentationData.TestStatusOrBuilder
            public ByteString getLogcatBytes() {
                Object obj = this.logcat_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.logcat_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setLogcat(String value) {
                value.getClass();
                this.bitField0_ |= 4;
                this.logcat_ = value;
                onChanged();
                return this;
            }

            public Builder clearLogcat() {
                this.bitField0_ &= -5;
                this.logcat_ = TestStatus.getDefaultInstance().getLogcat();
                onChanged();
                return this;
            }

            public Builder setLogcatBytes(ByteString value) {
                value.getClass();
                this.bitField0_ |= 4;
                this.logcat_ = value;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        public static TestStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TestStatus> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TestStatus> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TestStatus getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class SessionStatus extends GeneratedMessageV3 implements SessionStatusOrBuilder {
        public static final int ERROR_TEXT_FIELD_NUMBER = 2;
        public static final int RESULTS_FIELD_NUMBER = 4;
        public static final int RESULT_CODE_FIELD_NUMBER = 3;
        public static final int STATUS_CODE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object errorText_;
        private byte memoizedIsInitialized;
        private int resultCode_;
        private ResultsBundle results_;
        private int statusCode_;
        private static final SessionStatus DEFAULT_INSTANCE = new SessionStatus();

        @Deprecated
        public static final Parser<SessionStatus> PARSER = new AbstractParser<SessionStatus>() { // from class: com.android.commands.am.InstrumentationData.SessionStatus.1
            @Override // com.google.protobuf.Parser
            public SessionStatus parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SessionStatus(input, extensionRegistry);
            }
        };

        private SessionStatus(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SessionStatus() {
            this.memoizedIsInitialized = (byte) -1;
            this.statusCode_ = 0;
            this.errorText_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SessionStatus();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SessionStatus(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            extensionRegistry.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int tag = input.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                int i = input.readEnum();
                                if (SessionStatusCode.valueOf(i) == null) {
                                    builderNewBuilder.mergeVarintField(1, i);
                                } else {
                                    this.bitField0_ = 1 | this.bitField0_;
                                    this.statusCode_ = i;
                                }
                            } else if (tag == 18) {
                                ByteString bytes = input.readBytes();
                                this.bitField0_ |= 2;
                                this.errorText_ = bytes;
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.resultCode_ = input.readSInt32();
                            } else if (tag == 34) {
                                ResultsBundle.Builder builder = (this.bitField0_ & 8) != 0 ? this.results_.toBuilder() : null;
                                ResultsBundle resultsBundle = (ResultsBundle) input.readMessage(ResultsBundle.PARSER, extensionRegistry);
                                this.results_ = resultsBundle;
                                if (builder != null) {
                                    builder.mergeFrom(resultsBundle);
                                    this.results_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            } else if (!parseUnknownField(input, builderNewBuilder, extensionRegistry, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstrumentationData.internal_static_android_am_SessionStatus_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstrumentationData.internal_static_android_am_SessionStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionStatus.class, Builder.class);
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public boolean hasStatusCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public SessionStatusCode getStatusCode() {
            SessionStatusCode sessionStatusCodeValueOf = SessionStatusCode.valueOf(this.statusCode_);
            return sessionStatusCodeValueOf == null ? SessionStatusCode.SESSION_FINISHED : sessionStatusCodeValueOf;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public boolean hasErrorText() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public String getErrorText() {
            Object obj = this.errorText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.errorText_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public ByteString getErrorTextBytes() {
            Object obj = this.errorText_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errorText_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public boolean hasResultCode() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public int getResultCode() {
            return this.resultCode_;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public boolean hasResults() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public ResultsBundle getResults() {
            ResultsBundle resultsBundle = this.results_;
            return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
        public ResultsBundleOrBuilder getResultsOrBuilder() {
            ResultsBundle resultsBundle = this.results_;
            return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if ((this.bitField0_ & 1) != 0) {
                output.writeEnum(1, this.statusCode_);
            }
            if ((this.bitField0_ & 2) != 0) {
                GeneratedMessageV3.writeString(output, 2, this.errorText_);
            }
            if ((this.bitField0_ & 4) != 0) {
                output.writeSInt32(3, this.resultCode_);
            }
            if ((this.bitField0_ & 8) != 0) {
                output.writeMessage(4, getResults());
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = (this.bitField0_ & 1) != 0 ? CodedOutputStream.computeEnumSize(1, this.statusCode_) : 0;
            if ((this.bitField0_ & 2) != 0) {
                iComputeEnumSize += GeneratedMessageV3.computeStringSize(2, this.errorText_);
            }
            if ((this.bitField0_ & 4) != 0) {
                iComputeEnumSize += CodedOutputStream.computeSInt32Size(3, this.resultCode_);
            }
            if ((this.bitField0_ & 8) != 0) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(4, getResults());
            }
            int serializedSize = iComputeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SessionStatus)) {
                return super.equals(obj);
            }
            SessionStatus sessionStatus = (SessionStatus) obj;
            if (hasStatusCode() != sessionStatus.hasStatusCode()) {
                return false;
            }
            if ((hasStatusCode() && this.statusCode_ != sessionStatus.statusCode_) || hasErrorText() != sessionStatus.hasErrorText()) {
                return false;
            }
            if ((hasErrorText() && !getErrorText().equals(sessionStatus.getErrorText())) || hasResultCode() != sessionStatus.hasResultCode()) {
                return false;
            }
            if ((!hasResultCode() || getResultCode() == sessionStatus.getResultCode()) && hasResults() == sessionStatus.hasResults()) {
                return (!hasResults() || getResults().equals(sessionStatus.getResults())) && this.unknownFields.equals(sessionStatus.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode();
            if (hasStatusCode()) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + this.statusCode_;
            }
            if (hasErrorText()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getErrorText().hashCode();
            }
            if (hasResultCode()) {
                iHashCode = (((iHashCode * 37) + 3) * 53) + getResultCode();
            }
            if (hasResults()) {
                iHashCode = (((iHashCode * 37) + 4) * 53) + getResults().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static SessionStatus parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SessionStatus parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SessionStatus parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SessionStatus parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SessionStatus parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SessionStatus parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SessionStatus parseFrom(InputStream input) throws IOException {
            return (SessionStatus) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SessionStatus parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SessionStatus) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SessionStatus parseDelimitedFrom(InputStream input) throws IOException {
            return (SessionStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SessionStatus parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SessionStatus) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SessionStatus parseFrom(CodedInputStream input) throws IOException {
            return (SessionStatus) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SessionStatus parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SessionStatus) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SessionStatus prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionStatusOrBuilder {
            private int bitField0_;
            private Object errorText_;
            private int resultCode_;
            private SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> resultsBuilder_;
            private ResultsBundle results_;
            private int statusCode_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return InstrumentationData.internal_static_android_am_SessionStatus_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstrumentationData.internal_static_android_am_SessionStatus_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionStatus.class, Builder.class);
            }

            private Builder() {
                this.statusCode_ = 0;
                this.errorText_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.statusCode_ = 0;
                this.errorText_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SessionStatus.alwaysUseFieldBuilders) {
                    getResultsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.statusCode_ = 0;
                int i = this.bitField0_;
                this.errorText_ = "";
                this.resultCode_ = 0;
                this.bitField0_ = i & (-8);
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.results_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstrumentationData.internal_static_android_am_SessionStatus_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SessionStatus getDefaultInstanceForType() {
                return SessionStatus.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SessionStatus build() {
                SessionStatus sessionStatusBuildPartial = buildPartial();
                if (sessionStatusBuildPartial.isInitialized()) {
                    return sessionStatusBuildPartial;
                }
                throw newUninitializedMessageException((Message) sessionStatusBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SessionStatus buildPartial() {
                SessionStatus sessionStatus = new SessionStatus(this);
                int i = this.bitField0_;
                int i2 = (i & 1) != 0 ? 1 : 0;
                sessionStatus.statusCode_ = this.statusCode_;
                if ((i & 2) != 0) {
                    i2 |= 2;
                }
                sessionStatus.errorText_ = this.errorText_;
                if ((i & 4) != 0) {
                    sessionStatus.resultCode_ = this.resultCode_;
                    i2 |= 4;
                }
                if ((i & 8) != 0) {
                    SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        sessionStatus.results_ = this.results_;
                    } else {
                        sessionStatus.results_ = (ResultsBundle) singleFieldBuilderV3.build();
                    }
                    i2 |= 8;
                }
                sessionStatus.bitField0_ = i2;
                onBuilt();
                return sessionStatus;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo7987clone() {
                return (Builder) super.mo7987clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof SessionStatus) {
                    return mergeFrom((SessionStatus) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SessionStatus other) {
                if (other == SessionStatus.getDefaultInstance()) {
                    return this;
                }
                if (other.hasStatusCode()) {
                    setStatusCode(other.getStatusCode());
                }
                if (other.hasErrorText()) {
                    this.bitField0_ |= 2;
                    this.errorText_ = other.errorText_;
                    onChanged();
                }
                if (other.hasResultCode()) {
                    setResultCode(other.getResultCode());
                }
                if (other.hasResults()) {
                    mergeResults(other.getResults());
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.commands.am.InstrumentationData.SessionStatus.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.android.commands.am.InstrumentationData$SessionStatus> r1 = com.android.commands.am.InstrumentationData.SessionStatus.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.android.commands.am.InstrumentationData$SessionStatus r3 = (com.android.commands.am.InstrumentationData.SessionStatus) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.android.commands.am.InstrumentationData$SessionStatus r4 = (com.android.commands.am.InstrumentationData.SessionStatus) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.commands.am.InstrumentationData.SessionStatus.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.commands.am.InstrumentationData$SessionStatus$Builder");
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public boolean hasStatusCode() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public SessionStatusCode getStatusCode() {
                SessionStatusCode sessionStatusCodeValueOf = SessionStatusCode.valueOf(this.statusCode_);
                return sessionStatusCodeValueOf == null ? SessionStatusCode.SESSION_FINISHED : sessionStatusCodeValueOf;
            }

            public Builder setStatusCode(SessionStatusCode value) {
                value.getClass();
                this.bitField0_ |= 1;
                this.statusCode_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStatusCode() {
                this.bitField0_ &= -2;
                this.statusCode_ = 0;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public boolean hasErrorText() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public String getErrorText() {
                Object obj = this.errorText_;
                if (!(obj instanceof String)) {
                    ByteString byteString = (ByteString) obj;
                    String stringUtf8 = byteString.toStringUtf8();
                    if (byteString.isValidUtf8()) {
                        this.errorText_ = stringUtf8;
                    }
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public ByteString getErrorTextBytes() {
                Object obj = this.errorText_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.errorText_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setErrorText(String value) {
                value.getClass();
                this.bitField0_ |= 2;
                this.errorText_ = value;
                onChanged();
                return this;
            }

            public Builder clearErrorText() {
                this.bitField0_ &= -3;
                this.errorText_ = SessionStatus.getDefaultInstance().getErrorText();
                onChanged();
                return this;
            }

            public Builder setErrorTextBytes(ByteString value) {
                value.getClass();
                this.bitField0_ |= 2;
                this.errorText_ = value;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public boolean hasResultCode() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public int getResultCode() {
                return this.resultCode_;
            }

            public Builder setResultCode(int value) {
                this.bitField0_ |= 4;
                this.resultCode_ = value;
                onChanged();
                return this;
            }

            public Builder clearResultCode() {
                this.bitField0_ &= -5;
                this.resultCode_ = 0;
                onChanged();
                return this;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public boolean hasResults() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public ResultsBundle getResults() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    ResultsBundle resultsBundle = this.results_;
                    return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
                }
                return (ResultsBundle) singleFieldBuilderV3.getMessage();
            }

            public Builder setResults(ResultsBundle value) {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    value.getClass();
                    this.results_ = value;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setResults(ResultsBundle.Builder builderForValue) {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.results_ = builderForValue.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeResults(ResultsBundle value) {
                ResultsBundle resultsBundle;
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 8) != 0 && (resultsBundle = this.results_) != null && resultsBundle != ResultsBundle.getDefaultInstance()) {
                        this.results_ = ResultsBundle.newBuilder(this.results_).mergeFrom(value).buildPartial();
                    } else {
                        this.results_ = value;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearResults() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.results_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public ResultsBundle.Builder getResultsBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return (ResultsBundle.Builder) getResultsFieldBuilder().getBuilder();
            }

            @Override // com.android.commands.am.InstrumentationData.SessionStatusOrBuilder
            public ResultsBundleOrBuilder getResultsOrBuilder() {
                SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> singleFieldBuilderV3 = this.resultsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (ResultsBundleOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                ResultsBundle resultsBundle = this.results_;
                return resultsBundle == null ? ResultsBundle.getDefaultInstance() : resultsBundle;
            }

            private SingleFieldBuilderV3<ResultsBundle, ResultsBundle.Builder, ResultsBundleOrBuilder> getResultsFieldBuilder() {
                if (this.resultsBuilder_ == null) {
                    this.resultsBuilder_ = new SingleFieldBuilderV3<>(getResults(), getParentForChildren(), isClean());
                    this.results_ = null;
                }
                return this.resultsBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        public static SessionStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SessionStatus> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SessionStatus> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SessionStatus getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Session extends GeneratedMessageV3 implements SessionOrBuilder {
        private static final Session DEFAULT_INSTANCE = new Session();

        @Deprecated
        public static final Parser<Session> PARSER = new AbstractParser<Session>() { // from class: com.android.commands.am.InstrumentationData.Session.1
            @Override // com.google.protobuf.Parser
            public Session parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Session(input, extensionRegistry);
            }
        };
        public static final int SESSION_STATUS_FIELD_NUMBER = 2;
        public static final int TEST_STATUS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private SessionStatus sessionStatus_;
        private List<TestStatus> testStatus_;

        private Session(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Session() {
            this.memoizedIsInitialized = (byte) -1;
            this.testStatus_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Session();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Session(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            extensionRegistry.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int tag = input.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if (!z2) {
                                    this.testStatus_ = new ArrayList();
                                    z2 = true;
                                }
                                this.testStatus_.add((TestStatus) input.readMessage(TestStatus.PARSER, extensionRegistry));
                            } else if (tag == 18) {
                                SessionStatus.Builder builder = (this.bitField0_ & 1) != 0 ? this.sessionStatus_.toBuilder() : null;
                                SessionStatus sessionStatus = (SessionStatus) input.readMessage(SessionStatus.PARSER, extensionRegistry);
                                this.sessionStatus_ = sessionStatus;
                                if (builder != null) {
                                    builder.mergeFrom(sessionStatus);
                                    this.sessionStatus_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (!parseUnknownField(input, builderNewBuilder, extensionRegistry, tag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    if (z2) {
                        this.testStatus_ = Collections.unmodifiableList(this.testStatus_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstrumentationData.internal_static_android_am_Session_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstrumentationData.internal_static_android_am_Session_fieldAccessorTable.ensureFieldAccessorsInitialized(Session.class, Builder.class);
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public List<TestStatus> getTestStatusList() {
            return this.testStatus_;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public List<? extends TestStatusOrBuilder> getTestStatusOrBuilderList() {
            return this.testStatus_;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public int getTestStatusCount() {
            return this.testStatus_.size();
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public TestStatus getTestStatus(int index) {
            return this.testStatus_.get(index);
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public TestStatusOrBuilder getTestStatusOrBuilder(int index) {
            return this.testStatus_.get(index);
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public boolean hasSessionStatus() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public SessionStatus getSessionStatus() {
            SessionStatus sessionStatus = this.sessionStatus_;
            return sessionStatus == null ? SessionStatus.getDefaultInstance() : sessionStatus;
        }

        @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
        public SessionStatusOrBuilder getSessionStatusOrBuilder() {
            SessionStatus sessionStatus = this.sessionStatus_;
            return sessionStatus == null ? SessionStatus.getDefaultInstance() : sessionStatus;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.testStatus_.size(); i++) {
                output.writeMessage(1, this.testStatus_.get(i));
            }
            if ((this.bitField0_ & 1) != 0) {
                output.writeMessage(2, getSessionStatus());
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.testStatus_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.testStatus_.get(i2));
            }
            if ((this.bitField0_ & 1) != 0) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, getSessionStatus());
            }
            int serializedSize = iComputeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Session)) {
                return super.equals(obj);
            }
            Session session = (Session) obj;
            if (getTestStatusList().equals(session.getTestStatusList()) && hasSessionStatus() == session.hasSessionStatus()) {
                return (!hasSessionStatus() || getSessionStatus().equals(session.getSessionStatus())) && this.unknownFields.equals(session.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode();
            if (getTestStatusCount() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getTestStatusList().hashCode();
            }
            if (hasSessionStatus()) {
                iHashCode = (((iHashCode * 37) + 2) * 53) + getSessionStatus().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static Session parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Session parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Session parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Session parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Session parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Session parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Session parseFrom(InputStream input) throws IOException {
            return (Session) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Session parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Session) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Session parseDelimitedFrom(InputStream input) throws IOException {
            return (Session) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Session parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Session) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Session parseFrom(CodedInputStream input) throws IOException {
            return (Session) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Session parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Session) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Session prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> sessionStatusBuilder_;
            private SessionStatus sessionStatus_;
            private RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> testStatusBuilder_;
            private List<TestStatus> testStatus_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return InstrumentationData.internal_static_android_am_Session_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstrumentationData.internal_static_android_am_Session_fieldAccessorTable.ensureFieldAccessorsInitialized(Session.class, Builder.class);
            }

            private Builder() {
                this.testStatus_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.testStatus_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Session.alwaysUseFieldBuilders) {
                    getTestStatusFieldBuilder();
                    getSessionStatusFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.testStatus_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.sessionStatus_ = null;
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstrumentationData.internal_static_android_am_Session_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Session getDefaultInstanceForType() {
                return Session.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Session build() {
                Session sessionBuildPartial = buildPartial();
                if (sessionBuildPartial.isInitialized()) {
                    return sessionBuildPartial;
                }
                throw newUninitializedMessageException((Message) sessionBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Session buildPartial() {
                int i;
                Session session = new Session(this);
                int i2 = this.bitField0_;
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i2 & 1) != 0) {
                        this.testStatus_ = Collections.unmodifiableList(this.testStatus_);
                        this.bitField0_ &= -2;
                    }
                    session.testStatus_ = this.testStatus_;
                } else {
                    session.testStatus_ = repeatedFieldBuilderV3.build();
                }
                if ((i2 & 2) != 0) {
                    SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        session.sessionStatus_ = this.sessionStatus_;
                    } else {
                        session.sessionStatus_ = (SessionStatus) singleFieldBuilderV3.build();
                    }
                    i = 1;
                } else {
                    i = 0;
                }
                session.bitField0_ = i;
                onBuilt();
                return session;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo7987clone() {
                return (Builder) super.mo7987clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof Session) {
                    return mergeFrom((Session) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Session other) {
                if (other == Session.getDefaultInstance()) {
                    return this;
                }
                if (this.testStatusBuilder_ == null) {
                    if (!other.testStatus_.isEmpty()) {
                        if (this.testStatus_.isEmpty()) {
                            this.testStatus_ = other.testStatus_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTestStatusIsMutable();
                            this.testStatus_.addAll(other.testStatus_);
                        }
                        onChanged();
                    }
                } else if (!other.testStatus_.isEmpty()) {
                    if (!this.testStatusBuilder_.isEmpty()) {
                        this.testStatusBuilder_.addAllMessages(other.testStatus_);
                    } else {
                        this.testStatusBuilder_.dispose();
                        this.testStatusBuilder_ = null;
                        this.testStatus_ = other.testStatus_;
                        this.bitField0_ &= -2;
                        this.testStatusBuilder_ = Session.alwaysUseFieldBuilders ? getTestStatusFieldBuilder() : null;
                    }
                }
                if (other.hasSessionStatus()) {
                    mergeSessionStatus(other.getSessionStatus());
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.commands.am.InstrumentationData.Session.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser<com.android.commands.am.InstrumentationData$Session> r1 = com.android.commands.am.InstrumentationData.Session.PARSER     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    com.android.commands.am.InstrumentationData$Session r3 = (com.android.commands.am.InstrumentationData.Session) r3     // Catch: java.lang.Throwable -> Lf com.google.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.mergeFrom(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    com.android.commands.am.InstrumentationData$Session r4 = (com.android.commands.am.InstrumentationData.Session) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.mergeFrom(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.commands.am.InstrumentationData.Session.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.commands.am.InstrumentationData$Session$Builder");
            }

            private void ensureTestStatusIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.testStatus_ = new ArrayList(this.testStatus_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public List<TestStatus> getTestStatusList() {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.testStatus_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public int getTestStatusCount() {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.testStatus_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public TestStatus getTestStatus(int index) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.testStatus_.get(index);
                }
                return (TestStatus) repeatedFieldBuilderV3.getMessage(index);
            }

            public Builder setTestStatus(int index, TestStatus value) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureTestStatusIsMutable();
                    this.testStatus_.set(index, value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(index, value);
                }
                return this;
            }

            public Builder setTestStatus(int index, TestStatus.Builder builderForValue) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTestStatusIsMutable();
                    this.testStatus_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTestStatus(TestStatus value) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureTestStatusIsMutable();
                    this.testStatus_.add(value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(value);
                }
                return this;
            }

            public Builder addTestStatus(int index, TestStatus value) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureTestStatusIsMutable();
                    this.testStatus_.add(index, value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(index, value);
                }
                return this;
            }

            public Builder addTestStatus(TestStatus.Builder builderForValue) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTestStatusIsMutable();
                    this.testStatus_.add(builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTestStatus(int index, TestStatus.Builder builderForValue) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTestStatusIsMutable();
                    this.testStatus_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTestStatus(Iterable<? extends TestStatus> values) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTestStatusIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.testStatus_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTestStatus() {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.testStatus_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeTestStatus(int index) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureTestStatusIsMutable();
                    this.testStatus_.remove(index);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(index);
                }
                return this;
            }

            public TestStatus.Builder getTestStatusBuilder(int index) {
                return (TestStatus.Builder) getTestStatusFieldBuilder().getBuilder(index);
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public TestStatusOrBuilder getTestStatusOrBuilder(int index) {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.testStatus_.get(index);
                }
                return (TestStatusOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(index);
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public List<? extends TestStatusOrBuilder> getTestStatusOrBuilderList() {
                RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> repeatedFieldBuilderV3 = this.testStatusBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.testStatus_);
            }

            public TestStatus.Builder addTestStatusBuilder() {
                return (TestStatus.Builder) getTestStatusFieldBuilder().addBuilder(TestStatus.getDefaultInstance());
            }

            public TestStatus.Builder addTestStatusBuilder(int index) {
                return (TestStatus.Builder) getTestStatusFieldBuilder().addBuilder(index, TestStatus.getDefaultInstance());
            }

            public List<TestStatus.Builder> getTestStatusBuilderList() {
                return getTestStatusFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TestStatus, TestStatus.Builder, TestStatusOrBuilder> getTestStatusFieldBuilder() {
                if (this.testStatusBuilder_ == null) {
                    this.testStatusBuilder_ = new RepeatedFieldBuilderV3<>(this.testStatus_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.testStatus_ = null;
                }
                return this.testStatusBuilder_;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public boolean hasSessionStatus() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public SessionStatus getSessionStatus() {
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    SessionStatus sessionStatus = this.sessionStatus_;
                    return sessionStatus == null ? SessionStatus.getDefaultInstance() : sessionStatus;
                }
                return (SessionStatus) singleFieldBuilderV3.getMessage();
            }

            public Builder setSessionStatus(SessionStatus value) {
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    value.getClass();
                    this.sessionStatus_ = value;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(value);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setSessionStatus(SessionStatus.Builder builderForValue) {
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.sessionStatus_ = builderForValue.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder mergeSessionStatus(SessionStatus value) {
                SessionStatus sessionStatus;
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0 && (sessionStatus = this.sessionStatus_) != null && sessionStatus != SessionStatus.getDefaultInstance()) {
                        this.sessionStatus_ = SessionStatus.newBuilder(this.sessionStatus_).mergeFrom(value).buildPartial();
                    } else {
                        this.sessionStatus_ = value;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(value);
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder clearSessionStatus() {
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.sessionStatus_ = null;
                    onChanged();
                } else {
                    singleFieldBuilderV3.clear();
                }
                this.bitField0_ &= -3;
                return this;
            }

            public SessionStatus.Builder getSessionStatusBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return (SessionStatus.Builder) getSessionStatusFieldBuilder().getBuilder();
            }

            @Override // com.android.commands.am.InstrumentationData.SessionOrBuilder
            public SessionStatusOrBuilder getSessionStatusOrBuilder() {
                SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> singleFieldBuilderV3 = this.sessionStatusBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (SessionStatusOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                SessionStatus sessionStatus = this.sessionStatus_;
                return sessionStatus == null ? SessionStatus.getDefaultInstance() : sessionStatus;
            }

            private SingleFieldBuilderV3<SessionStatus, SessionStatus.Builder, SessionStatusOrBuilder> getSessionStatusFieldBuilder() {
                if (this.sessionStatusBuilder_ == null) {
                    this.sessionStatusBuilder_ = new SingleFieldBuilderV3<>(getSessionStatus(), getParentForChildren(), isClean());
                    this.sessionStatus_ = null;
                }
                return this.sessionStatusBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(final UnknownFieldSet unknownFields) {
                return (Builder) super.mergeUnknownFields(unknownFields);
            }
        }

        public static Session getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Session> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Session> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Session getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_android_am_ResultsBundleEntry_descriptor = descriptor2;
        internal_static_android_am_ResultsBundleEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Key", "ValueString", "ValueInt", "ValueFloat", "ValueDouble", "ValueLong", "ValueBundle", "ValueBytes"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_android_am_ResultsBundle_descriptor = descriptor3;
        internal_static_android_am_ResultsBundle_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Entries"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_android_am_TestStatus_descriptor = descriptor4;
        internal_static_android_am_TestStatus_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"ResultCode", "Results", "Logcat"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_android_am_SessionStatus_descriptor = descriptor5;
        internal_static_android_am_SessionStatus_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"StatusCode", "ErrorText", "ResultCode", "Results"});
        Descriptors.Descriptor descriptor6 = getDescriptor().getMessageTypes().get(4);
        internal_static_android_am_Session_descriptor = descriptor6;
        internal_static_android_am_Session_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"TestStatus", "SessionStatus"});
    }
}
