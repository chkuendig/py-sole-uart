package com.android.utils;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Enums;
import java.lang.Enum;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/* loaded from: classes3.dex */
public class HelpfulEnumConverter<T extends Enum<T>> extends Converter<String, T> {
    private final Converter<String, T> delegate;
    private final Class<T> klass;

    public HelpfulEnumConverter(Class<T> cls) {
        this.klass = cls;
        this.delegate = (Converter<String, T>) CaseFormat.LOWER_UNDERSCORE.converterTo(CaseFormat.UPPER_UNDERSCORE).andThen(Enums.stringConverter(cls));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Converter
    public T doForward(String value) {
        try {
            return this.delegate.convert(value);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException(String.format("Unknown %s value '%s'. Possible values are %s.", this.klass.getSimpleName(), value, Arrays.stream(this.klass.getEnumConstants()).map(new Function() { // from class: com.android.utils.HelpfulEnumConverter$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return HelpfulEnumConverter.lambda$doForward$0((Enum) obj);
                }
            }).collect(Collectors.joining(", "))));
        }
    }

    static /* synthetic */ String lambda$doForward$0(Enum r2) {
        return "'" + r2.name().toLowerCase() + "'";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.Converter
    public String doBackward(T anEnum) {
        return this.delegate.reverse().convert(anEnum);
    }
}
