package com.android.server.adb.protos;

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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class AppProcessesProto {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"src/main/proto/app_processes.proto\u0012\tadb.proto\"Z\n\fProcessEntry\u0012\u000b\n\u0003pid\u0018\u0001 \u0001(\u0003\u0012\u0012\n\ndebuggable\u0018\u0002 \u0001(\b\u0012\u0013\n\u000bprofileable\u0018\u0003 \u0001(\b\u0012\u0014\n\farchitecture\u0018\u0004 \u0001(\t\"8\n\fAppProcesses\u0012(\n\u0007process\u0018\u0001 \u0003(\u000b2\u0017.adb.proto.ProcessEntryB2\n\u001dcom.android.server.adb.protosB\u0011AppProcessesProtob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_adb_proto_AppProcesses_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_adb_proto_AppProcesses_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_adb_proto_ProcessEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_adb_proto_ProcessEntry_fieldAccessorTable;

    public interface AppProcessesOrBuilder extends MessageOrBuilder {
        ProcessEntry getProcess(int index);

        int getProcessCount();

        List<ProcessEntry> getProcessList();

        ProcessEntryOrBuilder getProcessOrBuilder(int index);

        List<? extends ProcessEntryOrBuilder> getProcessOrBuilderList();
    }

    public interface ProcessEntryOrBuilder extends MessageOrBuilder {
        String getArchitecture();

        ByteString getArchitectureBytes();

        boolean getDebuggable();

        long getPid();

        boolean getProfileable();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AppProcessesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    public static final class ProcessEntry extends GeneratedMessageV3 implements ProcessEntryOrBuilder {
        public static final int ARCHITECTURE_FIELD_NUMBER = 4;
        public static final int DEBUGGABLE_FIELD_NUMBER = 2;
        private static final ProcessEntry DEFAULT_INSTANCE = new ProcessEntry();
        private static final Parser<ProcessEntry> PARSER = new AbstractParser<ProcessEntry>() { // from class: com.android.server.adb.protos.AppProcessesProto.ProcessEntry.1
            @Override // com.google.protobuf.Parser
            public ProcessEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ProcessEntry(input, extensionRegistry);
            }
        };
        public static final int PID_FIELD_NUMBER = 1;
        public static final int PROFILEABLE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object architecture_;
        private boolean debuggable_;
        private byte memoizedIsInitialized;
        private long pid_;
        private boolean profileable_;

        private ProcessEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ProcessEntry() {
            this.memoizedIsInitialized = (byte) -1;
            this.architecture_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ProcessEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ProcessEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.pid_ = input.readInt64();
                            } else if (tag == 16) {
                                this.debuggable_ = input.readBool();
                            } else if (tag == 24) {
                                this.profileable_ = input.readBool();
                            } else if (tag == 34) {
                                this.architecture_ = input.readStringRequireUtf8();
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
            return AppProcessesProto.internal_static_adb_proto_ProcessEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AppProcessesProto.internal_static_adb_proto_ProcessEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(ProcessEntry.class, Builder.class);
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
        public long getPid() {
            return this.pid_;
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
        public boolean getDebuggable() {
            return this.debuggable_;
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
        public boolean getProfileable() {
            return this.profileable_;
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
        public String getArchitecture() {
            Object obj = this.architecture_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.architecture_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
        public ByteString getArchitectureBytes() {
            Object obj = this.architecture_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.architecture_ = byteStringCopyFromUtf8;
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
            long j = this.pid_;
            if (j != 0) {
                output.writeInt64(1, j);
            }
            boolean z = this.debuggable_;
            if (z) {
                output.writeBool(2, z);
            }
            boolean z2 = this.profileable_;
            if (z2) {
                output.writeBool(3, z2);
            }
            if (!getArchitectureBytes().isEmpty()) {
                GeneratedMessageV3.writeString(output, 4, this.architecture_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.pid_;
            int iComputeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            boolean z = this.debuggable_;
            if (z) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(2, z);
            }
            boolean z2 = this.profileable_;
            if (z2) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(3, z2);
            }
            if (!getArchitectureBytes().isEmpty()) {
                iComputeInt64Size += GeneratedMessageV3.computeStringSize(4, this.architecture_);
            }
            int serializedSize = iComputeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ProcessEntry)) {
                return super.equals(obj);
            }
            ProcessEntry processEntry = (ProcessEntry) obj;
            return getPid() == processEntry.getPid() && getDebuggable() == processEntry.getDebuggable() && getProfileable() == processEntry.getProfileable() && getArchitecture().equals(processEntry.getArchitecture()) && this.unknownFields.equals(processEntry.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = ((((((((((((((((((WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getPid())) * 37) + 2) * 53) + Internal.hashBoolean(getDebuggable())) * 37) + 3) * 53) + Internal.hashBoolean(getProfileable())) * 37) + 4) * 53) + getArchitecture().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode;
            return iHashCode;
        }

        public static ProcessEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProcessEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProcessEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProcessEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProcessEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ProcessEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ProcessEntry parseFrom(InputStream input) throws IOException {
            return (ProcessEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProcessEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProcessEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProcessEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (ProcessEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ProcessEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProcessEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ProcessEntry parseFrom(CodedInputStream input) throws IOException {
            return (ProcessEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ProcessEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ProcessEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ProcessEntry prototype) {
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ProcessEntryOrBuilder {
            private Object architecture_;
            private boolean debuggable_;
            private long pid_;
            private boolean profileable_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AppProcessesProto.internal_static_adb_proto_ProcessEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AppProcessesProto.internal_static_adb_proto_ProcessEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(ProcessEntry.class, Builder.class);
            }

            private Builder() {
                this.architecture_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.architecture_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ProcessEntry.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.pid_ = 0L;
                this.debuggable_ = false;
                this.profileable_ = false;
                this.architecture_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AppProcessesProto.internal_static_adb_proto_ProcessEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ProcessEntry getDefaultInstanceForType() {
                return ProcessEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProcessEntry build() {
                ProcessEntry processEntryBuildPartial = buildPartial();
                if (processEntryBuildPartial.isInitialized()) {
                    return processEntryBuildPartial;
                }
                throw newUninitializedMessageException((Message) processEntryBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ProcessEntry buildPartial() {
                ProcessEntry processEntry = new ProcessEntry(this);
                processEntry.pid_ = this.pid_;
                processEntry.debuggable_ = this.debuggable_;
                processEntry.profileable_ = this.profileable_;
                processEntry.architecture_ = this.architecture_;
                onBuilt();
                return processEntry;
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
                if (other instanceof ProcessEntry) {
                    return mergeFrom((ProcessEntry) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ProcessEntry other) {
                if (other == ProcessEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.getPid() != 0) {
                    setPid(other.getPid());
                }
                if (other.getDebuggable()) {
                    setDebuggable(other.getDebuggable());
                }
                if (other.getProfileable()) {
                    setProfileable(other.getProfileable());
                }
                if (!other.getArchitecture().isEmpty()) {
                    this.architecture_ = other.architecture_;
                    onChanged();
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.server.adb.protos.AppProcessesProto.ProcessEntry.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.android.server.adb.protos.AppProcessesProto.ProcessEntry.access$1100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.android.server.adb.protos.AppProcessesProto$ProcessEntry r3 = (com.android.server.adb.protos.AppProcessesProto.ProcessEntry) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.android.server.adb.protos.AppProcessesProto$ProcessEntry r4 = (com.android.server.adb.protos.AppProcessesProto.ProcessEntry) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.server.adb.protos.AppProcessesProto.ProcessEntry.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.server.adb.protos.AppProcessesProto$ProcessEntry$Builder");
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
            public long getPid() {
                return this.pid_;
            }

            public Builder setPid(long value) {
                this.pid_ = value;
                onChanged();
                return this;
            }

            public Builder clearPid() {
                this.pid_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
            public boolean getDebuggable() {
                return this.debuggable_;
            }

            public Builder setDebuggable(boolean value) {
                this.debuggable_ = value;
                onChanged();
                return this;
            }

            public Builder clearDebuggable() {
                this.debuggable_ = false;
                onChanged();
                return this;
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
            public boolean getProfileable() {
                return this.profileable_;
            }

            public Builder setProfileable(boolean value) {
                this.profileable_ = value;
                onChanged();
                return this;
            }

            public Builder clearProfileable() {
                this.profileable_ = false;
                onChanged();
                return this;
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
            public String getArchitecture() {
                Object obj = this.architecture_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.architecture_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.ProcessEntryOrBuilder
            public ByteString getArchitectureBytes() {
                Object obj = this.architecture_;
                if (obj instanceof String) {
                    ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.architecture_ = byteStringCopyFromUtf8;
                    return byteStringCopyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setArchitecture(String value) {
                value.getClass();
                this.architecture_ = value;
                onChanged();
                return this;
            }

            public Builder clearArchitecture() {
                this.architecture_ = ProcessEntry.getDefaultInstance().getArchitecture();
                onChanged();
                return this;
            }

            public Builder setArchitectureBytes(ByteString value) {
                value.getClass();
                ProcessEntry.checkByteStringIsUtf8(value);
                this.architecture_ = value;
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

        public static ProcessEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ProcessEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ProcessEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ProcessEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AppProcesses extends GeneratedMessageV3 implements AppProcessesOrBuilder {
        private static final AppProcesses DEFAULT_INSTANCE = new AppProcesses();
        private static final Parser<AppProcesses> PARSER = new AbstractParser<AppProcesses>() { // from class: com.android.server.adb.protos.AppProcessesProto.AppProcesses.1
            @Override // com.google.protobuf.Parser
            public AppProcesses parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AppProcesses(input, extensionRegistry);
            }
        };
        public static final int PROCESS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private List<ProcessEntry> process_;

        private AppProcesses(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AppProcesses() {
            this.memoizedIsInitialized = (byte) -1;
            this.process_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AppProcesses();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AppProcesses(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            extensionRegistry.getClass();
            UnknownFieldSet.Builder builderNewBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        try {
                            int tag = input.readTag();
                            if (tag != 0) {
                                if (tag == 10) {
                                    if (!z2) {
                                        this.process_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.process_.add((ProcessEntry) input.readMessage(ProcessEntry.parser(), extensionRegistry));
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
                    if (z2) {
                        this.process_ = Collections.unmodifiableList(this.process_);
                    }
                    this.unknownFields = builderNewBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AppProcessesProto.internal_static_adb_proto_AppProcesses_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AppProcessesProto.internal_static_adb_proto_AppProcesses_fieldAccessorTable.ensureFieldAccessorsInitialized(AppProcesses.class, Builder.class);
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
        public List<ProcessEntry> getProcessList() {
            return this.process_;
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
        public List<? extends ProcessEntryOrBuilder> getProcessOrBuilderList() {
            return this.process_;
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
        public int getProcessCount() {
            return this.process_.size();
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
        public ProcessEntry getProcess(int index) {
            return this.process_.get(index);
        }

        @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
        public ProcessEntryOrBuilder getProcessOrBuilder(int index) {
            return this.process_.get(index);
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
            for (int i = 0; i < this.process_.size(); i++) {
                output.writeMessage(1, this.process_.get(i));
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
            for (int i2 = 0; i2 < this.process_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.process_.get(i2));
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
            if (!(obj instanceof AppProcesses)) {
                return super.equals(obj);
            }
            AppProcesses appProcesses = (AppProcesses) obj;
            return getProcessList().equals(appProcesses.getProcessList()) && this.unknownFields.equals(appProcesses.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int iHashCode = WinError.ERROR_MEMORY_HARDWARE + getDescriptor().hashCode();
            if (getProcessCount() > 0) {
                iHashCode = (((iHashCode * 37) + 1) * 53) + getProcessList().hashCode();
            }
            int iHashCode2 = (iHashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = iHashCode2;
            return iHashCode2;
        }

        public static AppProcesses parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AppProcesses parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AppProcesses parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AppProcesses parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AppProcesses parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AppProcesses parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AppProcesses parseFrom(InputStream input) throws IOException {
            return (AppProcesses) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AppProcesses parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AppProcesses) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AppProcesses parseDelimitedFrom(InputStream input) throws IOException {
            return (AppProcesses) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AppProcesses parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AppProcesses) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AppProcesses parseFrom(CodedInputStream input) throws IOException {
            return (AppProcesses) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AppProcesses parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AppProcesses) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AppProcesses prototype) {
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppProcessesOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> processBuilder_;
            private List<ProcessEntry> process_;

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AppProcessesProto.internal_static_adb_proto_AppProcesses_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AppProcessesProto.internal_static_adb_proto_AppProcesses_fieldAccessorTable.ensureFieldAccessorsInitialized(AppProcesses.class, Builder.class);
            }

            private Builder() {
                this.process_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.process_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AppProcesses.alwaysUseFieldBuilders) {
                    getProcessFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.process_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AppProcessesProto.internal_static_adb_proto_AppProcesses_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AppProcesses getDefaultInstanceForType() {
                return AppProcesses.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AppProcesses build() {
                AppProcesses appProcessesBuildPartial = buildPartial();
                if (appProcessesBuildPartial.isInitialized()) {
                    return appProcessesBuildPartial;
                }
                throw newUninitializedMessageException((Message) appProcessesBuildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AppProcesses buildPartial() {
                AppProcesses appProcesses = new AppProcesses(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.process_ = Collections.unmodifiableList(this.process_);
                        this.bitField0_ &= -2;
                    }
                    appProcesses.process_ = this.process_;
                } else {
                    appProcesses.process_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return appProcesses;
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
                if (other instanceof AppProcesses) {
                    return mergeFrom((AppProcesses) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AppProcesses other) {
                if (other == AppProcesses.getDefaultInstance()) {
                    return this;
                }
                if (this.processBuilder_ == null) {
                    if (!other.process_.isEmpty()) {
                        if (this.process_.isEmpty()) {
                            this.process_ = other.process_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureProcessIsMutable();
                            this.process_.addAll(other.process_);
                        }
                        onChanged();
                    }
                } else if (!other.process_.isEmpty()) {
                    if (!this.processBuilder_.isEmpty()) {
                        this.processBuilder_.addAllMessages(other.process_);
                    } else {
                        this.processBuilder_.dispose();
                        this.processBuilder_ = null;
                        this.process_ = other.process_;
                        this.bitField0_ &= -2;
                        this.processBuilder_ = AppProcesses.alwaysUseFieldBuilders ? getProcessFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.android.server.adb.protos.AppProcessesProto.AppProcesses.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.android.server.adb.protos.AppProcessesProto.AppProcesses.access$2300()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.android.server.adb.protos.AppProcessesProto$AppProcesses r3 = (com.android.server.adb.protos.AppProcessesProto.AppProcesses) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.android.server.adb.protos.AppProcessesProto$AppProcesses r4 = (com.android.server.adb.protos.AppProcessesProto.AppProcesses) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.server.adb.protos.AppProcessesProto.AppProcesses.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.android.server.adb.protos.AppProcessesProto$AppProcesses$Builder");
            }

            private void ensureProcessIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.process_ = new ArrayList(this.process_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
            public List<ProcessEntry> getProcessList() {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.process_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
            public int getProcessCount() {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.process_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
            public ProcessEntry getProcess(int index) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.process_.get(index);
                }
                return (ProcessEntry) repeatedFieldBuilderV3.getMessage(index);
            }

            public Builder setProcess(int index, ProcessEntry value) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureProcessIsMutable();
                    this.process_.set(index, value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(index, value);
                }
                return this;
            }

            public Builder setProcess(int index, ProcessEntry.Builder builderForValue) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProcessIsMutable();
                    this.process_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addProcess(ProcessEntry value) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureProcessIsMutable();
                    this.process_.add(value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(value);
                }
                return this;
            }

            public Builder addProcess(int index, ProcessEntry value) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    value.getClass();
                    ensureProcessIsMutable();
                    this.process_.add(index, value);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(index, value);
                }
                return this;
            }

            public Builder addProcess(ProcessEntry.Builder builderForValue) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProcessIsMutable();
                    this.process_.add(builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addProcess(int index, ProcessEntry.Builder builderForValue) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProcessIsMutable();
                    this.process_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllProcess(Iterable<? extends ProcessEntry> values) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProcessIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.process_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(values);
                }
                return this;
            }

            public Builder clearProcess() {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.process_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder removeProcess(int index) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureProcessIsMutable();
                    this.process_.remove(index);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(index);
                }
                return this;
            }

            public ProcessEntry.Builder getProcessBuilder(int index) {
                return (ProcessEntry.Builder) getProcessFieldBuilder().getBuilder(index);
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
            public ProcessEntryOrBuilder getProcessOrBuilder(int index) {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.process_.get(index);
                }
                return (ProcessEntryOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(index);
            }

            @Override // com.android.server.adb.protos.AppProcessesProto.AppProcessesOrBuilder
            public List<? extends ProcessEntryOrBuilder> getProcessOrBuilderList() {
                RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> repeatedFieldBuilderV3 = this.processBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.process_);
            }

            public ProcessEntry.Builder addProcessBuilder() {
                return (ProcessEntry.Builder) getProcessFieldBuilder().addBuilder(ProcessEntry.getDefaultInstance());
            }

            public ProcessEntry.Builder addProcessBuilder(int index) {
                return (ProcessEntry.Builder) getProcessFieldBuilder().addBuilder(index, ProcessEntry.getDefaultInstance());
            }

            public List<ProcessEntry.Builder> getProcessBuilderList() {
                return getProcessFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ProcessEntry, ProcessEntry.Builder, ProcessEntryOrBuilder> getProcessFieldBuilder() {
                if (this.processBuilder_ == null) {
                    this.processBuilder_ = new RepeatedFieldBuilderV3<>(this.process_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.process_ = null;
                }
                return this.processBuilder_;
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

        public static AppProcesses getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AppProcesses> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AppProcesses> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AppProcesses getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_adb_proto_ProcessEntry_descriptor = descriptor2;
        internal_static_adb_proto_ProcessEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Pid", "Debuggable", "Profileable", "Architecture"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_adb_proto_AppProcesses_descriptor = descriptor3;
        internal_static_adb_proto_AppProcesses_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Process"});
    }
}
