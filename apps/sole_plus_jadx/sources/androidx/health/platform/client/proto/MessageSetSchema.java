package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.FieldSet;
import androidx.health.platform.client.proto.LazyField;
import androidx.health.platform.client.proto.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes2.dex */
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(defaultInstance);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = defaultInstance;
    }

    static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite defaultInstance) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, defaultInstance);
    }

    @Override // androidx.health.platform.client.proto.Schema
    public T newInstance() {
        MessageLite messageLite = this.defaultInstance;
        if (messageLite instanceof GeneratedMessageLite) {
            return (T) ((GeneratedMessageLite) messageLite).newMutableInstance();
        }
        return (T) messageLite.newBuilderForType().buildPartial();
    }

    @Override // androidx.health.platform.client.proto.Schema
    public boolean equals(T message, T other) {
        if (!this.unknownFieldSchema.getFromMessage(message).equals(this.unknownFieldSchema.getFromMessage(other))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(message).equals(this.extensionSchema.getExtensions(other));
        }
        return true;
    }

    @Override // androidx.health.platform.client.proto.Schema
    public int hashCode(T message) {
        int iHashCode = this.unknownFieldSchema.getFromMessage(message).hashCode();
        return this.hasExtensions ? (iHashCode * 53) + this.extensionSchema.getExtensions(message).hashCode() : iHashCode;
    }

    @Override // androidx.health.platform.client.proto.Schema
    public void mergeFrom(T message, T other) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, message, other);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, message, other);
        }
    }

    @Override // androidx.health.platform.client.proto.Schema
    public void writeTo(T message, Writer writer) throws IOException {
        Iterator it = this.extensionSchema.getExtensions(message).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) entry.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) entry).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), entry.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, message, writer);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, T message, Writer writer) throws IOException {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(message), writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb A[EDGE_INSN: B:58:0x00cb->B:34:0x00cb BREAK  A[LOOP:1: B:18:0x006d->B:61:0x006d], SYNTHETIC] */
    @Override // androidx.health.platform.client.proto.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, androidx.health.platform.client.proto.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            androidx.health.platform.client.proto.GeneratedMessageLite r0 = (androidx.health.platform.client.proto.GeneratedMessageLite) r0
            androidx.health.platform.client.proto.UnknownFieldSetLite r1 = r0.unknownFields
            androidx.health.platform.client.proto.UnknownFieldSetLite r2 = androidx.health.platform.client.proto.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L11
            androidx.health.platform.client.proto.UnknownFieldSetLite r1 = androidx.health.platform.client.proto.UnknownFieldSetLite.newInstance()
            r0.unknownFields = r1
        L11:
            androidx.health.platform.client.proto.GeneratedMessageLite$ExtendableMessage r11 = (androidx.health.platform.client.proto.GeneratedMessageLite.ExtendableMessage) r11
            androidx.health.platform.client.proto.FieldSet r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = androidx.health.platform.client.proto.ArrayDecoders.decodeVarint32(r12, r13, r15)
            int r13 = r15.int1
            int r3 = androidx.health.platform.client.proto.WireFormat.MESSAGE_SET_ITEM_TAG
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = androidx.health.platform.client.proto.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L66
            androidx.health.platform.client.proto.ExtensionSchema<?> r2 = r10.extensionSchema
            androidx.health.platform.client.proto.ExtensionRegistryLite r3 = r15.extensionRegistry
            androidx.health.platform.client.proto.MessageLite r5 = r10.defaultInstance
            int r6 = androidx.health.platform.client.proto.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.findExtensionByNumber(r3, r5, r6)
            r8 = r2
            androidx.health.platform.client.proto.GeneratedMessageLite$GeneratedExtension r8 = (androidx.health.platform.client.proto.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L5b
            androidx.health.platform.client.proto.Protobuf r13 = androidx.health.platform.client.proto.Protobuf.getInstance()
            androidx.health.platform.client.proto.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            androidx.health.platform.client.proto.Schema r13 = r13.schemaFor(r2)
            int r13 = androidx.health.platform.client.proto.ArrayDecoders.decodeMessageField(r13, r12, r4, r14, r15)
            androidx.health.platform.client.proto.GeneratedMessageLite$ExtensionDescriptor r2 = r8.descriptor
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
            goto L64
        L5b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = androidx.health.platform.client.proto.ArrayDecoders.decodeUnknownField(r2, r3, r4, r5, r6, r7)
        L64:
            r2 = r8
            goto L19
        L66:
            int r13 = androidx.health.platform.client.proto.ArrayDecoders.skipField(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = androidx.health.platform.client.proto.ArrayDecoders.decodeVarint32(r12, r4, r15)
            int r6 = r15.int1
            int r7 = androidx.health.platform.client.proto.WireFormat.getTagFieldNumber(r6)
            int r8 = androidx.health.platform.client.proto.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            androidx.health.platform.client.proto.Protobuf r6 = androidx.health.platform.client.proto.Protobuf.getInstance()
            androidx.health.platform.client.proto.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            androidx.health.platform.client.proto.Schema r6 = r6.schemaFor(r7)
            int r4 = androidx.health.platform.client.proto.ArrayDecoders.decodeMessageField(r6, r12, r4, r14, r15)
            androidx.health.platform.client.proto.GeneratedMessageLite$ExtensionDescriptor r6 = r2.descriptor
            java.lang.Object r7 = r15.object1
            r11.setField(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = androidx.health.platform.client.proto.ArrayDecoders.decodeBytes(r12, r4, r15)
            java.lang.Object r3 = r15.object1
            androidx.health.platform.client.proto.ByteString r3 = (androidx.health.platform.client.proto.ByteString) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = androidx.health.platform.client.proto.ArrayDecoders.decodeVarint32(r12, r4, r15)
            int r13 = r15.int1
            androidx.health.platform.client.proto.ExtensionSchema<?> r2 = r10.extensionSchema
            androidx.health.platform.client.proto.ExtensionRegistryLite r6 = r15.extensionRegistry
            androidx.health.platform.client.proto.MessageLite r7 = r10.defaultInstance
            java.lang.Object r2 = r2.findExtensionByNumber(r6, r7, r13)
            androidx.health.platform.client.proto.GeneratedMessageLite$GeneratedExtension r2 = (androidx.health.platform.client.proto.GeneratedMessageLite.GeneratedExtension) r2
            goto L6d
        Lc1:
            int r7 = androidx.health.platform.client.proto.WireFormat.MESSAGE_SET_ITEM_END_TAG
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = androidx.health.platform.client.proto.ArrayDecoders.skipField(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = androidx.health.platform.client.proto.WireFormat.makeTag(r13, r5)
            r1.storeField(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            androidx.health.platform.client.proto.InvalidProtocolBufferException r11 = androidx.health.platform.client.proto.InvalidProtocolBufferException.parseFailure()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.health.platform.client.proto.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, androidx.health.platform.client.proto.ArrayDecoders$Registers):void");
    }

    @Override // androidx.health.platform.client.proto.Schema
    public void mergeFrom(T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, message, reader, extensionRegistry);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T message, Reader reader, ExtensionRegistryLite extensionRegistry) throws IOException {
        UB builderFromMessage = unknownFieldSchema.getBuilderFromMessage(message);
        FieldSet<ET> mutableExtensions = extensionSchema.getMutableExtensions(message);
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                if (!parseMessageSetItemOrUnknownField(reader, extensionRegistry, extensionSchema, mutableExtensions, unknownFieldSchema, builderFromMessage)) {
                    return;
                }
            } finally {
                unknownFieldSchema.setBuilderToMessage(message, builderFromMessage);
            }
        }
    }

    @Override // androidx.health.platform.client.proto.Schema
    public void makeImmutable(T message) {
        this.unknownFieldSchema.makeImmutable(message);
        this.extensionSchema.makeImmutable(message);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistry, ExtensionSchema<ET> extensionSchema, FieldSet<ET> extensions, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB unknownFields) throws IOException {
        int tag = reader.getTag();
        if (tag != WireFormat.MESSAGE_SET_ITEM_TAG) {
            if (WireFormat.getTagWireType(tag) == 2) {
                Object objFindExtensionByNumber = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
                if (objFindExtensionByNumber != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, objFindExtensionByNumber, extensionRegistry, extensions);
                    return true;
                }
                return unknownFieldSchema.mergeOneFieldFrom(unknownFields, reader);
            }
            return reader.skipField();
        }
        Object objFindExtensionByNumber2 = null;
        int uInt32 = 0;
        ByteString bytes = null;
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = reader.getTag();
            if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = reader.readUInt32();
                objFindExtensionByNumber2 = extensionSchema.findExtensionByNumber(extensionRegistry, this.defaultInstance, uInt32);
            } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (objFindExtensionByNumber2 != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, objFindExtensionByNumber2, extensionRegistry, extensions);
                } else {
                    bytes = reader.readBytes();
                }
            } else if (!reader.skipField()) {
                break;
            }
        }
        if (reader.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        if (bytes != null) {
            if (objFindExtensionByNumber2 != null) {
                extensionSchema.parseMessageSetItem(bytes, objFindExtensionByNumber2, extensionRegistry, extensions);
            } else {
                unknownFieldSchema.addLengthDelimited(unknownFields, uInt32, bytes);
            }
        }
        return true;
    }

    @Override // androidx.health.platform.client.proto.Schema
    public final boolean isInitialized(T message) {
        return this.extensionSchema.getExtensions(message).isInitialized();
    }

    @Override // androidx.health.platform.client.proto.Schema
    public int getSerializedSize(T message) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, message);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(message).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> schema, T message) {
        return schema.getSerializedSizeAsMessageSet(schema.getFromMessage(message));
    }
}
