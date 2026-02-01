package org.joda.time.convert;

/* loaded from: classes2.dex */
class ConverterSet {
    private final Converter[] iConverters;
    private Entry[] iSelectEntries = new Entry[16];

    ConverterSet(Converter[] converterArr) {
        this.iConverters = converterArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x000e, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0054, code lost:
    
        r7 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Converter select(Class<?> cls) throws IllegalStateException {
        int iHashCode;
        int iHashCode2;
        Entry[] entryArr = this.iSelectEntries;
        int length = entryArr.length;
        if (cls != null) {
            iHashCode = cls.hashCode() & (length - 1);
            while (true) {
                Entry entry = entryArr[iHashCode];
                if (entry != null) {
                    if (entry.iType == cls) {
                        return entry.iConverter;
                    }
                    iHashCode++;
                    if (iHashCode >= length) {
                    }
                } else {
                    Converter converterSelectSlow = selectSlow(this, cls);
                    Entry entry2 = new Entry(cls, converterSelectSlow);
                    Entry[] entryArr2 = (Entry[]) entryArr.clone();
                    entryArr2[iHashCode] = entry2;
                    for (int i = 0; i < length; i++) {
                        if (entryArr2[i] == null) {
                            this.iSelectEntries = entryArr2;
                            return converterSelectSlow;
                        }
                    }
                    int i2 = length << 1;
                    Entry[] entryArr3 = new Entry[i2];
                    for (int i3 = 0; i3 < length; i3++) {
                        Entry entry3 = entryArr2[i3];
                        Class<?> cls2 = entry3.iType;
                        if (cls2 != null) {
                            iHashCode2 = cls2.hashCode() & (i2 - 1);
                            while (entryArr3[iHashCode2] != null) {
                                iHashCode2++;
                                if (iHashCode2 >= i2) {
                                }
                            }
                            entryArr3[iHashCode2] = entry3;
                        }
                        iHashCode2 = 0;
                    }
                    this.iSelectEntries = entryArr3;
                    return converterSelectSlow;
                }
            }
        }
        iHashCode = 0;
    }

    int size() {
        return this.iConverters.length;
    }

    void copyInto(Converter[] converterArr) {
        Converter[] converterArr2 = this.iConverters;
        System.arraycopy(converterArr2, 0, converterArr, 0, converterArr2.length);
    }

    ConverterSet add(Converter converter, Converter[] converterArr) {
        Converter[] converterArr2 = this.iConverters;
        int length = converterArr2.length;
        for (int i = 0; i < length; i++) {
            Converter converter2 = converterArr2[i];
            if (converter.equals(converter2)) {
                if (converterArr != null) {
                    converterArr[0] = null;
                }
                return this;
            }
            if (converter.getSupportedType() == converter2.getSupportedType()) {
                Converter[] converterArr3 = new Converter[length];
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 != i) {
                        converterArr3[i2] = converterArr2[i2];
                    } else {
                        converterArr3[i2] = converter;
                    }
                }
                if (converterArr != null) {
                    converterArr[0] = converter2;
                }
                return new ConverterSet(converterArr3);
            }
        }
        Converter[] converterArr4 = new Converter[length + 1];
        System.arraycopy(converterArr2, 0, converterArr4, 0, length);
        converterArr4[length] = converter;
        if (converterArr != null) {
            converterArr[0] = null;
        }
        return new ConverterSet(converterArr4);
    }

    ConverterSet remove(Converter converter, Converter[] converterArr) {
        Converter[] converterArr2 = this.iConverters;
        int length = converterArr2.length;
        for (int i = 0; i < length; i++) {
            if (converter.equals(converterArr2[i])) {
                return remove(i, converterArr);
            }
        }
        if (converterArr != null) {
            converterArr[0] = null;
        }
        return this;
    }

    ConverterSet remove(int i, Converter[] converterArr) {
        Converter[] converterArr2 = this.iConverters;
        int length = converterArr2.length;
        if (i >= length) {
            throw new IndexOutOfBoundsException();
        }
        if (converterArr != null) {
            converterArr[0] = converterArr2[i];
        }
        Converter[] converterArr3 = new Converter[length - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != i) {
                converterArr3[i2] = converterArr2[i3];
                i2++;
            }
        }
        return new ConverterSet(converterArr3);
    }

    private static Converter selectSlow(ConverterSet converterSet, Class<?> cls) {
        Converter[] converterArr = converterSet.iConverters;
        int length = converterArr.length;
        int length2 = length;
        while (true) {
            length--;
            if (length < 0) {
                if (cls == null || length2 == 0) {
                    return null;
                }
                if (length2 == 1) {
                    return converterArr[0];
                }
                int i = length2;
                while (true) {
                    length2--;
                    if (length2 < 0) {
                        break;
                    }
                    Class<?> supportedType = converterArr[length2].getSupportedType();
                    int length3 = i;
                    while (true) {
                        i--;
                        if (i >= 0) {
                            if (i != length2 && converterArr[i].getSupportedType().isAssignableFrom(supportedType)) {
                                converterSet = converterSet.remove(i, (Converter[]) null);
                                converterArr = converterSet.iConverters;
                                length3 = converterArr.length;
                                length2 = length3 - 1;
                            }
                        }
                    }
                    i = length3;
                }
                if (i == 1) {
                    return converterArr[0];
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to find best converter for type \"");
                sb.append(cls.getName());
                sb.append("\" from remaining set: ");
                for (int i2 = 0; i2 < i; i2++) {
                    Converter converter = converterArr[i2];
                    Class<?> supportedType2 = converter.getSupportedType();
                    sb.append(converter.getClass().getName());
                    sb.append('[');
                    sb.append(supportedType2 == null ? null : supportedType2.getName());
                    sb.append("], ");
                }
                throw new IllegalStateException(sb.toString());
            }
            Converter converter2 = converterArr[length];
            Class<?> supportedType3 = converter2.getSupportedType();
            if (supportedType3 == cls) {
                return converter2;
            }
            if (supportedType3 == null || (cls != null && !supportedType3.isAssignableFrom(cls))) {
                converterSet = converterSet.remove(length, (Converter[]) null);
                converterArr = converterSet.iConverters;
                length2 = converterArr.length;
            }
        }
    }

    static class Entry {
        final Converter iConverter;
        final Class<?> iType;

        Entry(Class<?> cls, Converter converter) {
            this.iType = cls;
            this.iConverter = converter;
        }
    }
}
