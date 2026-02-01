package io.ktor.util.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ConversionServiceJvm.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\t"}, d2 = {"convertSimpleTypes", "", "value", "", "klass", "Lkotlin/reflect/KClass;", "platformDefaultFromValues", "platformDefaultToValues", "", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ConversionServiceJvmKt {
    public static final Object platformDefaultFromValues(String value, KClass<?> klass) throws DataConversionException {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Object objConvertSimpleTypes = convertSimpleTypes(value, klass);
        if (objConvertSimpleTypes != null) {
            return objConvertSimpleTypes;
        }
        Object obj = null;
        if (!JvmClassMappingKt.getJavaClass((KClass) klass).isEnum()) {
            return null;
        }
        Object[] enumConstants = JvmClassMappingKt.getJavaClass((KClass) klass).getEnumConstants();
        if (enumConstants != null) {
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = enumConstants[i];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                if (Intrinsics.areEqual(((Enum) obj2).name(), value)) {
                    obj = obj2;
                    break;
                }
                i++;
            }
            if (obj != null) {
                return obj;
            }
        }
        throw new DataConversionException("Value " + value + " is not a enum member name of " + klass);
    }

    private static final Object convertSimpleTypes(String str, KClass<?> kClass) {
        Object bigInteger;
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Float.class))) {
            return Float.valueOf(Float.parseFloat(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Double.class))) {
            return Double.valueOf(Double.parseDouble(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Long.class))) {
            return Long.valueOf(Long.parseLong(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Short.class))) {
            return Short.valueOf(Short.parseShort(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Boolean.class))) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            return str;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Character.class))) {
            return Character.valueOf(str.charAt(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigDecimal.class))) {
            bigInteger = new BigDecimal(str);
        } else {
            if (!Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(BigInteger.class))) {
                if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(UUID.class))) {
                    return UUID.fromString(str);
                }
                return null;
            }
            bigInteger = new BigInteger(str);
        }
        return bigInteger;
    }

    public static final List<String> platformDefaultToValues(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Enum) {
            return CollectionsKt.listOf(((Enum) value).name());
        }
        if ((value instanceof Integer) || (value instanceof Float) || (value instanceof Double) || (value instanceof Long) || (value instanceof Boolean) || (value instanceof Short) || (value instanceof String) || (value instanceof Character) || (value instanceof BigDecimal) || (value instanceof BigInteger) || (value instanceof UUID)) {
            return CollectionsKt.listOf(value.toString());
        }
        return null;
    }
}
