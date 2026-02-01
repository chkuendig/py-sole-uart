package io.ktor.serialization.kotlinx;

import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: SerializerLookup.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001\"\b\b\u0000\u0010\t*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\t0\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\r"}, d2 = {"guessSerializer", "Lkotlinx/serialization/KSerializer;", "", "value", SdkConstants.TAG_MODULE, "Lkotlinx/serialization/modules/SerializersModule;", "elementSerializer", "", "maybeNullable", ExifInterface.GPS_DIRECTION_TRUE, "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "serializerForTypeInfo", "ktor-serialization-kotlinx"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SerializerLookupKt {
    @ExperimentalSerializationApi
    @InternalSerializationApi
    public static final KSerializer<?> serializerForTypeInfo(SerializersModule serializersModule, TypeInfo typeInfo) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        KType kotlinType = typeInfo.getKotlinType();
        if (kotlinType != null) {
            KSerializer<?> kSerializerSerializerOrNull = kotlinType.getArguments().isEmpty() ? null : SerializersKt.serializerOrNull(serializersModule, kotlinType);
            if (kSerializerSerializerOrNull != null) {
                return kSerializerSerializerOrNull;
            }
        }
        KSerializer contextual$default = SerializersModule.getContextual$default(serializersModule, typeInfo.getType(), null, 2, null);
        return contextual$default != null ? maybeNullable(contextual$default, typeInfo) : maybeNullable(SerializersKt.serializer(typeInfo.getType()), typeInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> KSerializer<?> maybeNullable(KSerializer<T> kSerializer, TypeInfo typeInfo) {
        KType kotlinType = typeInfo.getKotlinType();
        return (kotlinType == null || !kotlinType.isMarkedNullable()) ? kSerializer : BuiltinSerializersKt.getNullable(kSerializer);
    }

    public static final KSerializer<Object> guessSerializer(Object obj, SerializersModule module) {
        KSerializer<Object> kSerializerSerializer;
        Intrinsics.checkNotNullParameter(module, "module");
        if (obj == null) {
            kSerializerSerializer = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        } else if (obj instanceof List) {
            kSerializerSerializer = BuiltinSerializersKt.ListSerializer(elementSerializer((Collection) obj, module));
        } else if (obj instanceof Object[]) {
            Object objFirstOrNull = ArraysKt.firstOrNull((Object[]) obj);
            if (objFirstOrNull == null || (kSerializerSerializer = guessSerializer(objFirstOrNull, module)) == null) {
                kSerializerSerializer = BuiltinSerializersKt.ListSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
            }
        } else if (obj instanceof Set) {
            kSerializerSerializer = BuiltinSerializersKt.SetSerializer(elementSerializer((Collection) obj, module));
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            kSerializerSerializer = BuiltinSerializersKt.MapSerializer(elementSerializer(map.keySet(), module), elementSerializer(map.values(), module));
        } else {
            KSerializer<Object> contextual$default = SerializersModule.getContextual$default(module, Reflection.getOrCreateKotlinClass(obj.getClass()), null, 2, null);
            kSerializerSerializer = contextual$default == null ? SerializersKt.serializer(Reflection.getOrCreateKotlinClass(obj.getClass())) : contextual$default;
        }
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        return kSerializerSerializer;
    }

    private static final KSerializer<?> elementSerializer(Collection<?> collection, SerializersModule serializersModule) {
        Collection<?> collection2 = collection;
        List listFilterNotNull = CollectionsKt.filterNotNull(collection2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
        Iterator it = listFilterNotNull.iterator();
        while (it.hasNext()) {
            arrayList.add(guessSerializer(it.next(), serializersModule));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(((KSerializer) obj).getDescriptor().getSerialName())) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.size() > 1) {
            StringBuilder sb = new StringBuilder("Serializing collections of different element types is not yet supported. Selected serializers: ");
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                arrayList5.add(((KSerializer) it2.next()).getDescriptor().getSerialName());
            }
            throw new IllegalStateException(sb.append(arrayList5).toString().toString());
        }
        KSerializer<String> kSerializerSerializer = (KSerializer) CollectionsKt.singleOrNull((List) arrayList3);
        if (kSerializerSerializer == null) {
            kSerializerSerializer = BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE);
        }
        if (kSerializerSerializer.getDescriptor().isNullable()) {
            return kSerializerSerializer;
        }
        Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it3 = collection2.iterator();
            while (it3.hasNext()) {
                if (it3.next() == null) {
                    return BuiltinSerializersKt.getNullable(kSerializerSerializer);
                }
            }
        }
        return kSerializerSerializer;
    }
}
