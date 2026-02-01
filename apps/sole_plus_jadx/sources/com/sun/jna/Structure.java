package com.sun.jna;

import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class Structure {
    public static final int ALIGN_DEFAULT = 0;
    public static final int ALIGN_GNUC = 2;
    public static final int ALIGN_MSVC = 3;
    public static final int ALIGN_NONE = 1;
    protected static final int CALCULATE_SIZE = -1;
    private int actualAlignType;
    private int alignType;
    private Structure[] array;
    private boolean autoRead;
    private boolean autoWrite;
    private String encoding;
    private Pointer memory;
    private final Map<String, Object> nativeStrings;
    private boolean readCalled;
    private int size;
    private int structAlignment;
    private Map<String, StructField> structFields;
    private long typeInfo;
    private TypeMapper typeMapper;
    private static final Logger LOG = Logger.getLogger(Structure.class.getName());
    static final Map<Class<?>, LayoutInfo> layoutInfo = new WeakHashMap();
    static final Map<Class<?>, List<String>> fieldOrder = new WeakHashMap();
    private static final ThreadLocal<Map<Pointer, Structure>> reads = new ThreadLocal<Map<Pointer, Structure>>() { // from class: com.sun.jna.Structure.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public synchronized Map<Pointer, Structure> initialValue() {
            return new HashMap();
        }
    };
    private static final ThreadLocal<Set<Structure>> busy = new ThreadLocal<Set<Structure>>() { // from class: com.sun.jna.Structure.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public synchronized Set<Structure> initialValue() {
            return new StructureSet();
        }
    };
    private static final Pointer PLACEHOLDER_MEMORY = new Pointer(0) { // from class: com.sun.jna.Structure.3
        @Override // com.sun.jna.Pointer
        public Pointer share(long j, long j2) {
            return this;
        }
    };

    public interface ByReference {
    }

    public interface ByValue {
    }

    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldOrder {
        String[] value();
    }

    protected Structure() {
        this(0);
    }

    protected Structure(TypeMapper typeMapper) {
        this(null, 0, typeMapper);
    }

    protected Structure(int i) {
        this((Pointer) null, i);
    }

    protected Structure(int i, TypeMapper typeMapper) {
        this(null, i, typeMapper);
    }

    protected Structure(Pointer pointer) {
        this(pointer, 0);
    }

    protected Structure(Pointer pointer, int i) {
        this(pointer, i, null);
    }

    protected Structure(Pointer pointer, int i, TypeMapper typeMapper) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        this.size = -1;
        this.nativeStrings = new HashMap();
        this.autoRead = true;
        this.autoWrite = true;
        setAlignType(i);
        setStringEncoding(Native.getStringEncoding(getClass()));
        initializeTypeMapper(typeMapper);
        validateFields();
        if (pointer != null) {
            useMemory(pointer, 0, true);
        } else {
            allocateMemory(-1);
        }
        initializeFields();
    }

    Map<String, StructField> fields() {
        return this.structFields;
    }

    TypeMapper getTypeMapper() {
        return this.typeMapper;
    }

    private void initializeTypeMapper(TypeMapper typeMapper) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (typeMapper == null) {
            typeMapper = Native.getTypeMapper(getClass());
        }
        this.typeMapper = typeMapper;
        layoutChanged();
    }

    private void layoutChanged() throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.size != -1) {
            this.size = -1;
            if (this.memory instanceof AutoAllocated) {
                this.memory = null;
            }
            ensureAllocated();
        }
    }

    protected void setStringEncoding(String str) {
        this.encoding = str;
    }

    protected String getStringEncoding() {
        return this.encoding;
    }

    protected void setAlignType(int i) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        this.alignType = i;
        if (i == 0 && (i = Native.getStructureAlignment(getClass())) == 0) {
            i = Platform.isWindows() ? 3 : 2;
        }
        this.actualAlignType = i;
        layoutChanged();
    }

    protected Memory autoAllocate(int i) {
        return new AutoAllocated(i);
    }

    protected void useMemory(Pointer pointer) {
        useMemory(pointer, 0);
    }

    protected void useMemory(Pointer pointer, int i) {
        useMemory(pointer, i, false);
    }

    void useMemory(Pointer pointer, int i, boolean z) {
        try {
            this.nativeStrings.clear();
            if ((this instanceof ByValue) && !z) {
                int size = size();
                byte[] bArr = new byte[size];
                pointer.read(0L, bArr, 0, size);
                this.memory.write(0L, bArr, 0, size);
            } else {
                long j = i;
                this.memory = pointer.share(j);
                if (this.size == -1) {
                    this.size = calculateSize(false);
                }
                int i2 = this.size;
                if (i2 != -1) {
                    this.memory = pointer.share(j, i2);
                }
            }
            this.array = null;
            this.readCalled = false;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Structure exceeds provided memory bounds", e);
        }
    }

    protected void ensureAllocated() throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureAllocated(boolean z) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.memory == null) {
            allocateMemory(z);
            return;
        }
        if (this.size == -1) {
            int iCalculateSize = calculateSize(true, z);
            this.size = iCalculateSize;
            Pointer pointer = this.memory;
            if (pointer instanceof AutoAllocated) {
                return;
            }
            try {
                this.memory = pointer.share(0L, iCalculateSize);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Structure exceeds provided memory bounds", e);
            }
        }
    }

    protected void allocateMemory() {
        allocateMemory(false);
    }

    private void allocateMemory(boolean z) {
        allocateMemory(calculateSize(true, z));
    }

    protected void allocateMemory(int i) {
        if (i == -1) {
            i = calculateSize(false);
        } else if (i <= 0) {
            throw new IllegalArgumentException("Structure size must be greater than zero: " + i);
        }
        if (i != -1) {
            Pointer pointer = this.memory;
            if (pointer == null || (pointer instanceof AutoAllocated)) {
                this.memory = autoAllocate(i);
            }
            this.size = i;
        }
    }

    public int size() throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        return this.size;
    }

    public void clear() throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        this.memory.clear(size());
    }

    public Pointer getPointer() throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        return this.memory;
    }

    static class StructureSet extends AbstractCollection<Structure> implements Set<Structure> {
        private int count;
        Structure[] elements;

        StructureSet() {
        }

        private void ensureCapacity(int i) {
            Structure[] structureArr = this.elements;
            if (structureArr == null) {
                this.elements = new Structure[(i * 3) / 2];
            } else if (structureArr.length < i) {
                Structure[] structureArr2 = new Structure[(i * 3) / 2];
                System.arraycopy(structureArr, 0, structureArr2, 0, structureArr.length);
                this.elements = structureArr2;
            }
        }

        public Structure[] getElements() {
            return this.elements;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.count;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return indexOf((Structure) obj) != -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Structure structure) {
            if (!contains(structure)) {
                ensureCapacity(this.count + 1);
                Structure[] structureArr = this.elements;
                int i = this.count;
                this.count = i + 1;
                structureArr[i] = structure;
            }
            return true;
        }

        private int indexOf(Structure structure) {
            for (int i = 0; i < this.count; i++) {
                Structure structure2 = this.elements[i];
                if (structure == structure2 || (structure.getClass() == structure2.getClass() && structure.size() == structure2.size() && structure.getPointer().equals(structure2.getPointer()))) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iIndexOf = indexOf((Structure) obj);
            if (iIndexOf == -1) {
                return false;
            }
            int i = this.count - 1;
            this.count = i;
            if (i >= 0) {
                Structure[] structureArr = this.elements;
                structureArr[iIndexOf] = structureArr[i];
                structureArr[i] = null;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Structure> iterator() {
            int i = this.count;
            Structure[] structureArr = new Structure[i];
            if (i > 0) {
                System.arraycopy(this.elements, 0, structureArr, 0, i);
            }
            return Arrays.asList(structureArr).iterator();
        }
    }

    static Set<Structure> busy() {
        return busy.get();
    }

    static Map<Pointer, Structure> reading() {
        return reads.get();
    }

    void conditionalAutoRead() {
        if (this.readCalled) {
            return;
        }
        autoRead();
    }

    public void read() {
        if (this.memory == PLACEHOLDER_MEMORY) {
            return;
        }
        this.readCalled = true;
        ensureAllocated();
        if (busy().contains(this)) {
            return;
        }
        busy().add(this);
        if (this instanceof ByReference) {
            reading().put(getPointer(), this);
        }
        try {
            Iterator<StructField> it = fields().values().iterator();
            while (it.hasNext()) {
                readField(it.next());
            }
        } finally {
            busy().remove(this);
            if (reading().get(getPointer()) == this) {
                reading().remove(getPointer());
            }
        }
    }

    protected int fieldOffset(String str) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + str);
        }
        return structField.offset;
    }

    public Object readField(String str) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + str);
        }
        return readField(structField);
    }

    Object getFieldValue(Field field) {
        try {
            return field.get(this);
        } catch (Exception e) {
            throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), e);
        }
    }

    void setFieldValue(Field field, Object obj) throws IllegalAccessException, IllegalArgumentException {
        setFieldValue(field, obj, false);
    }

    private void setFieldValue(Field field, Object obj, boolean z) throws IllegalAccessException, IllegalArgumentException {
        try {
            field.set(this, obj);
        } catch (IllegalAccessException e) {
            if (!Modifier.isFinal(field.getModifiers())) {
                throw new Error("Unexpectedly unable to write to field '" + field.getName() + "' within " + getClass(), e);
            }
            if (z) {
                throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + field.getName() + "' within " + getClass() + ")", e);
            }
            throw new UnsupportedOperationException("Attempt to write to read-only field '" + field.getName() + "' within " + getClass(), e);
        }
    }

    static <T extends Structure> T updateStructureByReference(Class<T> cls, T t, Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        if (t == null || !pointer.equals(t.getPointer())) {
            T t2 = (T) reading().get(pointer);
            if (t2 != null && cls.equals(t2.getClass())) {
                t2.autoRead();
                return t2;
            }
            T t3 = (T) newInstance(cls, pointer);
            t3.conditionalAutoRead();
            return t3;
        }
        t.autoRead();
        return t;
    }

    protected Object readField(StructField structField) throws IllegalAccessException, IllegalArgumentException {
        int i = structField.offset;
        Class<?> clsNativeType = structField.type;
        FromNativeConverter fromNativeConverter = structField.readConverter;
        if (fromNativeConverter != null) {
            clsNativeType = fromNativeConverter.nativeType();
        }
        Object value = null;
        Object fieldValue = (Structure.class.isAssignableFrom(clsNativeType) || Callback.class.isAssignableFrom(clsNativeType) || (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(clsNativeType)) || Pointer.class.isAssignableFrom(clsNativeType) || NativeMapped.class.isAssignableFrom(clsNativeType) || clsNativeType.isArray()) ? getFieldValue(structField.field) : null;
        if (clsNativeType == String.class) {
            Pointer pointer = this.memory.getPointer(i);
            if (pointer != null) {
                value = pointer.getString(0L, this.encoding);
            }
        } else {
            value = this.memory.getValue(i, clsNativeType, fieldValue);
        }
        if (fromNativeConverter != null) {
            Object objFromNative = fromNativeConverter.fromNative(value, structField.context);
            if (fieldValue == null || !fieldValue.equals(objFromNative)) {
                fieldValue = objFromNative;
            }
        } else {
            fieldValue = value;
        }
        if (clsNativeType.equals(String.class) || clsNativeType.equals(WString.class)) {
            this.nativeStrings.put(structField.name + ".ptr", this.memory.getPointer(i));
            this.nativeStrings.put(structField.name + ".val", fieldValue);
        }
        setFieldValue(structField.field, fieldValue, true);
        return fieldValue;
    }

    public void write() {
        if (this.memory == PLACEHOLDER_MEMORY) {
            return;
        }
        ensureAllocated();
        if (this instanceof ByValue) {
            getTypeInfo();
        }
        if (busy().contains(this)) {
            return;
        }
        busy().add(this);
        try {
            for (StructField structField : fields().values()) {
                if (!structField.isVolatile) {
                    writeField(structField);
                }
            }
        } finally {
            busy().remove(this);
        }
    }

    public void writeField(String str) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + str);
        }
        writeField(structField);
    }

    public void writeField(String str, Object obj) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField == null) {
            throw new IllegalArgumentException("No such field: " + str);
        }
        setFieldValue(structField.field, obj);
        writeField(structField);
    }

    protected void writeField(StructField structField) {
        NativeString nativeString;
        if (structField.isReadOnly) {
            return;
        }
        int i = structField.offset;
        Object fieldValue = getFieldValue(structField.field);
        Class<?> clsNativeType = structField.type;
        ToNativeConverter toNativeConverter = structField.writeConverter;
        if (toNativeConverter != null) {
            fieldValue = toNativeConverter.toNative(fieldValue, new StructureWriteContext(this, structField.field));
            clsNativeType = toNativeConverter.nativeType();
        }
        if (String.class == clsNativeType || WString.class == clsNativeType) {
            boolean z = clsNativeType == WString.class;
            if (fieldValue != null) {
                if (this.nativeStrings.containsKey(structField.name + ".ptr") && fieldValue.equals(this.nativeStrings.get(structField.name + ".val"))) {
                    return;
                }
                if (z) {
                    nativeString = new NativeString(fieldValue.toString(), true);
                } else {
                    nativeString = new NativeString(fieldValue.toString(), this.encoding);
                }
                this.nativeStrings.put(structField.name, nativeString);
                fieldValue = nativeString.getPointer();
            } else {
                this.nativeStrings.remove(structField.name);
            }
            this.nativeStrings.remove(structField.name + ".ptr");
            this.nativeStrings.remove(structField.name + ".val");
        }
        try {
            this.memory.setValue(i, fieldValue, clsNativeType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Structure field \"" + structField.name + "\" was declared as " + structField.type + (structField.type == clsNativeType ? "" : " (native type " + clsNativeType + ")") + ", which is not supported within a Structure", e);
        }
    }

    protected List<String> getFieldOrder() {
        LinkedList linkedList = new LinkedList();
        for (Class<?> superclass = getClass(); superclass != Structure.class; superclass = superclass.getSuperclass()) {
            FieldOrder fieldOrder2 = (FieldOrder) superclass.getAnnotation(FieldOrder.class);
            if (fieldOrder2 != null) {
                linkedList.addAll(0, Arrays.asList(fieldOrder2.value()));
            }
        }
        return Collections.unmodifiableList(linkedList);
    }

    protected void sortFields(List<Field> list, List<String> list2) {
        for (int i = 0; i < list2.size(); i++) {
            String str = list2.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                if (str.equals(list.get(i2).getName())) {
                    Collections.swap(list, i, i2);
                    break;
                }
                i2++;
            }
        }
    }

    protected List<Field> getFieldList() {
        ArrayList arrayList = new ArrayList();
        for (Class<?> superclass = getClass(); !superclass.equals(Structure.class); superclass = superclass.getSuperclass()) {
            ArrayList arrayList2 = new ArrayList();
            Field[] declaredFields = superclass.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                int modifiers = declaredFields[i].getModifiers();
                if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
                    arrayList2.add(declaredFields[i]);
                }
            }
            arrayList.addAll(0, arrayList2);
        }
        return arrayList;
    }

    private List<String> fieldOrder() {
        List<String> fieldOrder2;
        Class<?> cls = getClass();
        Map<Class<?>, List<String>> map = fieldOrder;
        synchronized (map) {
            fieldOrder2 = map.get(cls);
            if (fieldOrder2 == null) {
                fieldOrder2 = getFieldOrder();
                map.put(cls, fieldOrder2);
            }
        }
        return fieldOrder2;
    }

    public static List<String> createFieldsOrder(List<String> list, String... strArr) {
        return createFieldsOrder(list, (List<String>) Arrays.asList(strArr));
    }

    public static List<String> createFieldsOrder(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return Collections.unmodifiableList(arrayList);
    }

    public static List<String> createFieldsOrder(String str) {
        return Collections.unmodifiableList(Collections.singletonList(str));
    }

    public static List<String> createFieldsOrder(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    private static <T extends Comparable<T>> List<T> sort(Collection<? extends T> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList);
        return arrayList;
    }

    protected List<Field> getFields(boolean z) {
        List<Field> fieldList = getFieldList();
        HashSet hashSet = new HashSet();
        Iterator<Field> it = fieldList.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        List<String> listFieldOrder = fieldOrder();
        if (listFieldOrder.size() != fieldList.size() && fieldList.size() > 1) {
            if (z) {
                throw new Error("Structure.getFieldOrder() on " + getClass() + (listFieldOrder.size() < fieldList.size() ? " does not provide enough" : " provides too many") + " names [" + listFieldOrder.size() + "] (" + sort(listFieldOrder) + ") to match declared fields [" + fieldList.size() + "] (" + sort(hashSet) + ")");
            }
            return null;
        }
        if (!new HashSet(listFieldOrder).equals(hashSet)) {
            throw new Error("Structure.getFieldOrder() on " + getClass() + " returns names (" + sort(listFieldOrder) + ") which do not match declared field names (" + sort(hashSet) + ")");
        }
        sortFields(fieldList, listFieldOrder);
        return fieldList;
    }

    protected int calculateSize(boolean z) {
        return calculateSize(z, false);
    }

    static int size(Class<? extends Structure> cls) {
        return size(cls, null);
    }

    static <T extends Structure> int size(Class<T> cls, T t) {
        LayoutInfo layoutInfo2;
        Map<Class<?>, LayoutInfo> map = layoutInfo;
        synchronized (map) {
            layoutInfo2 = map.get(cls);
        }
        int i = (layoutInfo2 == null || layoutInfo2.variable) ? -1 : layoutInfo2.size;
        if (i != -1) {
            return i;
        }
        if (t == null) {
            t = (T) newInstance(cls, PLACEHOLDER_MEMORY);
        }
        return t.size();
    }

    int calculateSize(boolean z, boolean z2) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        LayoutInfo layoutInfoDeriveLayout;
        Class<?> cls = getClass();
        Map<Class<?>, LayoutInfo> map = layoutInfo;
        synchronized (map) {
            layoutInfoDeriveLayout = map.get(cls);
        }
        if (layoutInfoDeriveLayout == null || this.alignType != layoutInfoDeriveLayout.alignType || this.typeMapper != layoutInfoDeriveLayout.typeMapper) {
            layoutInfoDeriveLayout = deriveLayout(z, z2);
        }
        if (layoutInfoDeriveLayout == null) {
            return -1;
        }
        this.structAlignment = layoutInfoDeriveLayout.alignment;
        this.structFields = layoutInfoDeriveLayout.fields;
        if (!layoutInfoDeriveLayout.variable) {
            synchronized (map) {
                if (!map.containsKey(cls) || this.alignType != 0 || this.typeMapper != null) {
                    map.put(cls, layoutInfoDeriveLayout);
                }
            }
        }
        return layoutInfoDeriveLayout.size;
    }

    private static class LayoutInfo {
        private int alignType;
        private int alignment;
        private final Map<String, StructField> fields;
        private int size;
        private TypeMapper typeMapper;
        private boolean variable;

        private LayoutInfo() {
            this.size = -1;
            this.alignment = 1;
            this.fields = Collections.synchronizedMap(new LinkedHashMap());
            this.alignType = 0;
        }
    }

    private void validateField(String str, Class<?> cls) {
        ToNativeConverter toNativeConverter;
        TypeMapper typeMapper = this.typeMapper;
        if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
            validateField(str, toNativeConverter.nativeType());
        } else {
            if (cls.isArray()) {
                validateField(str, cls.getComponentType());
                return;
            }
            try {
                getNativeSize(cls);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + str + "' (" + cls + "): " + e.getMessage(), e);
            }
        }
    }

    private void validateFields() {
        for (Field field : getFieldList()) {
            validateField(field.getName(), field.getType());
        }
    }

    private LayoutInfo deriveLayout(boolean z, boolean z2) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Class<?> clsNativeType;
        List<Field> fields = getFields(z);
        if (fields == null) {
            return null;
        }
        LayoutInfo layoutInfo2 = new LayoutInfo();
        layoutInfo2.alignType = this.alignType;
        layoutInfo2.typeMapper = this.typeMapper;
        boolean z3 = true;
        boolean z4 = true;
        int iMax = 0;
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            Class<?> type = field.getType();
            if (type.isArray()) {
                layoutInfo2.variable = z3;
            }
            StructField structField = new StructField();
            structField.isVolatile = Modifier.isVolatile(modifiers);
            structField.isReadOnly = Modifier.isFinal(modifiers);
            if (structField.isReadOnly) {
                if (!Platform.RO_FIELDS) {
                    throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field.getName() + "' within " + getClass() + ")");
                }
                field.setAccessible(z3);
            }
            structField.field = field;
            structField.name = field.getName();
            structField.type = type;
            if (Callback.class.isAssignableFrom(type) && !type.isInterface()) {
                throw new IllegalArgumentException("Structure Callback field '" + field.getName() + "' must be an interface");
            }
            if (type.isArray() && Structure.class.equals(type.getComponentType())) {
                throw new IllegalArgumentException("Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined");
            }
            if (Modifier.isPublic(field.getModifiers())) {
                Object fieldValue = getFieldValue(structField.field);
                if (fieldValue == null && type.isArray()) {
                    if (z) {
                        throw new IllegalStateException("Array fields must be initialized");
                    }
                    return null;
                }
                if (NativeMapped.class.isAssignableFrom(type)) {
                    NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(type);
                    clsNativeType = nativeMappedConverter.nativeType();
                    structField.writeConverter = nativeMappedConverter;
                    structField.readConverter = nativeMappedConverter;
                    structField.context = new StructureReadContext(this, field);
                } else {
                    TypeMapper typeMapper = this.typeMapper;
                    if (typeMapper != null) {
                        ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(type);
                        FromNativeConverter fromNativeConverter = this.typeMapper.getFromNativeConverter(type);
                        if (toNativeConverter == null || fromNativeConverter == null) {
                            if (toNativeConverter != null || fromNativeConverter != null) {
                                throw new IllegalArgumentException("Structures require bidirectional type conversion for " + type);
                            }
                            clsNativeType = type;
                        } else {
                            fieldValue = toNativeConverter.toNative(fieldValue, new StructureWriteContext(this, structField.field));
                            Class cls = fieldValue != null ? fieldValue.getClass() : Pointer.class;
                            structField.writeConverter = toNativeConverter;
                            structField.readConverter = fromNativeConverter;
                            structField.context = new StructureReadContext(this, field);
                            clsNativeType = cls;
                        }
                    } else {
                        clsNativeType = type;
                    }
                }
                if (fieldValue == null) {
                    fieldValue = initializeField(structField.field, type);
                }
                try {
                    structField.size = getNativeSize(clsNativeType, fieldValue);
                    int nativeAlignment = getNativeAlignment(clsNativeType, fieldValue, z4);
                    if (nativeAlignment != 0) {
                        layoutInfo2.alignment = Math.max(layoutInfo2.alignment, nativeAlignment);
                        int i = iMax % nativeAlignment;
                        if (i != 0) {
                            iMax += nativeAlignment - i;
                        }
                        if (this instanceof Union) {
                            structField.offset = 0;
                            iMax = Math.max(iMax, structField.size);
                        } else {
                            structField.offset = iMax;
                            iMax += structField.size;
                        }
                        layoutInfo2.fields.put(structField.name, structField);
                    } else {
                        throw new Error("Field alignment is zero for field '" + structField.name + "' within " + getClass());
                    }
                } catch (IllegalArgumentException e) {
                    if (z || this.typeMapper != null) {
                        throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + structField.name + "' (" + structField.type + "): " + e.getMessage(), e);
                    }
                    return null;
                }
            }
            z4 = false;
            z3 = true;
        }
        if (iMax > 0) {
            int iAddPadding = addPadding(iMax, layoutInfo2.alignment);
            if ((this instanceof ByValue) && !z2) {
                getTypeInfo();
            }
            layoutInfo2.size = iAddPadding;
            return layoutInfo2;
        }
        throw new IllegalArgumentException("Structure " + getClass() + " has unknown or zero size (ensure all fields are public)");
    }

    private void initializeFields() {
        for (Field field : getFieldList()) {
            try {
                if (field.get(this) == null) {
                    initializeField(field, field.getType());
                }
            } catch (Exception e) {
                throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), e);
            }
        }
    }

    private Object initializeField(Field field, Class<?> cls) throws IllegalAccessException, IllegalArgumentException {
        if (Structure.class.isAssignableFrom(cls) && !ByReference.class.isAssignableFrom(cls)) {
            try {
                Structure structureNewInstance = newInstance((Class<Structure>) cls, PLACEHOLDER_MEMORY);
                setFieldValue(field, structureNewInstance);
                return structureNewInstance;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Can't determine size of nested structure", e);
            }
        }
        if (!NativeMapped.class.isAssignableFrom(cls)) {
            return null;
        }
        NativeMapped nativeMappedDefaultValue = NativeMappedConverter.getInstance(cls).defaultValue();
        setFieldValue(field, nativeMappedDefaultValue);
        return nativeMappedDefaultValue;
    }

    private int addPadding(int i) {
        return addPadding(i, this.structAlignment);
    }

    private int addPadding(int i, int i2) {
        int i3;
        return (this.actualAlignType == 1 || (i3 = i % i2) == 0) ? i : i + (i2 - i3);
    }

    protected int getStructAlignment() {
        if (this.size == -1) {
            calculateSize(true);
        }
        return this.structAlignment;
    }

    protected int getNativeAlignment(Class<?> cls, Object obj, boolean z) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            Class<?> clsNativeType = nativeMappedConverter.nativeType();
            obj = nativeMappedConverter.toNative(obj, new ToNativeContext());
            cls = clsNativeType;
        }
        int nativeSize = Native.getNativeSize(cls, obj);
        if (!cls.isPrimitive() && Long.class != cls && Integer.class != cls && Short.class != cls && Character.class != cls && Byte.class != cls && Boolean.class != cls && Float.class != cls && Double.class != cls) {
            if ((Pointer.class.isAssignableFrom(cls) && !Function.class.isAssignableFrom(cls)) || ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Callback.class.isAssignableFrom(cls) || WString.class == cls || String.class == cls)) {
                nativeSize = Native.POINTER_SIZE;
            } else if (Structure.class.isAssignableFrom(cls)) {
                if (ByReference.class.isAssignableFrom(cls)) {
                    nativeSize = Native.POINTER_SIZE;
                } else {
                    if (obj == null) {
                        obj = newInstance(cls, PLACEHOLDER_MEMORY);
                    }
                    nativeSize = ((Structure) obj).getStructAlignment();
                }
            } else if (cls.isArray()) {
                nativeSize = getNativeAlignment(cls.getComponentType(), null, z);
            } else {
                throw new IllegalArgumentException("Type " + cls + " has unknown native alignment");
            }
        }
        int i = this.actualAlignType;
        if (i == 1) {
            return 1;
        }
        if (i == 3) {
            return Math.min(8, nativeSize);
        }
        if (i != 2) {
            return nativeSize;
        }
        if (!z || !Platform.isMac() || !Platform.isPPC()) {
            nativeSize = Math.min(Native.MAX_ALIGNMENT, nativeSize);
        }
        if (z || !Platform.isAIX()) {
            return nativeSize;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return 4;
        }
        return nativeSize;
    }

    public String toString() {
        return toString(Boolean.getBoolean("jna.dump_memory"));
    }

    public String toString(boolean z) {
        return toString(0, true, z);
    }

    private String format(Class<?> cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    private String toString(int i, boolean z, boolean z2) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        String str;
        String str2;
        String str3;
        ensureAllocated();
        String property = System.getProperty("line.separator");
        String str4 = format(getClass()) + "(" + getPointer() + ")";
        if (!(getPointer() instanceof Memory)) {
            str4 = str4 + " (" + size() + " bytes)";
        }
        String str5 = "";
        for (int i2 = 0; i2 < i; i2++) {
            str5 = str5 + "  ";
        }
        if (!z) {
            str = "...}";
        } else {
            Iterator<StructField> it = fields().values().iterator();
            String str6 = property;
            while (it.hasNext()) {
                StructField next = it.next();
                Object fieldValue = getFieldValue(next.field);
                String str7 = format(next.type);
                String str8 = str6 + str5;
                if (!next.type.isArray() || fieldValue == null) {
                    str2 = "";
                } else {
                    str7 = format(next.type.getComponentType());
                    str2 = "[" + Array.getLength(fieldValue) + "]";
                }
                String str9 = str8 + String.format("  %s %s%s@0x%X", str7, next.name, str2, Integer.valueOf(next.offset));
                if (fieldValue instanceof Structure) {
                    fieldValue = ((Structure) fieldValue).toString(i + 1, !(fieldValue instanceof ByReference), z2);
                }
                String str10 = str9 + "=";
                if (fieldValue instanceof Long) {
                    str3 = str10 + String.format("0x%08X", (Long) fieldValue);
                } else if (fieldValue instanceof Integer) {
                    str3 = str10 + String.format("0x%04X", (Integer) fieldValue);
                } else if (fieldValue instanceof Short) {
                    str3 = str10 + String.format("0x%02X", (Short) fieldValue);
                } else if (fieldValue instanceof Byte) {
                    str3 = str10 + String.format("0x%01X", (Byte) fieldValue);
                } else {
                    str3 = str10 + String.valueOf(fieldValue).trim();
                }
                String str11 = str3 + property;
                if (!it.hasNext()) {
                    str11 = str11 + str5 + SdkConstants.MANIFEST_PLACEHOLDER_SUFFIX;
                }
                str6 = str11;
            }
            str = str6;
        }
        if (i == 0 && z2) {
            String str12 = str + property + "memory dump" + property;
            byte[] byteArray = getPointer().getByteArray(0L, size());
            for (int i3 = 0; i3 < byteArray.length; i3++) {
                int i4 = i3 % 4;
                if (i4 == 0) {
                    str12 = str12 + "[";
                }
                byte b = byteArray[i3];
                if (b >= 0 && b < 16) {
                    str12 = str12 + "0";
                }
                str12 = str12 + Integer.toHexString(byteArray[i3] & 255);
                if (i4 == 3 && i3 < byteArray.length - 1) {
                    str12 = str12 + "]" + property;
                }
            }
            str = str12 + "]";
        }
        return str4 + " {" + str;
    }

    public Structure[] toArray(Structure[] structureArr) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ensureAllocated();
        Pointer pointer = this.memory;
        if (pointer instanceof AutoAllocated) {
            int length = structureArr.length * size();
            if (((Memory) pointer).size() < length) {
                useMemory(autoAllocate(length));
            }
        }
        structureArr[0] = this;
        int size = size();
        for (int i = 1; i < structureArr.length; i++) {
            Structure structureNewInstance = newInstance((Class<Structure>) getClass(), this.memory.share(i * size, size));
            structureArr[i] = structureNewInstance;
            structureNewInstance.conditionalAutoRead();
        }
        if (!(this instanceof ByValue)) {
            this.array = structureArr;
        }
        return structureArr;
    }

    public Structure[] toArray(int i) {
        return toArray((Structure[]) Array.newInstance(getClass(), i));
    }

    private Class<?> baseClass() {
        if (((this instanceof ByReference) || (this instanceof ByValue)) && Structure.class.isAssignableFrom(getClass().getSuperclass())) {
            return getClass().getSuperclass();
        }
        return getClass();
    }

    public boolean dataEquals(Structure structure) {
        return dataEquals(structure, false);
    }

    public boolean dataEquals(Structure structure, boolean z) {
        if (z) {
            structure.getPointer().clear(structure.size());
            structure.write();
            getPointer().clear(size());
            write();
        }
        byte[] byteArray = structure.getPointer().getByteArray(0L, structure.size());
        byte[] byteArray2 = getPointer().getByteArray(0L, size());
        if (byteArray.length != byteArray2.length) {
            return false;
        }
        for (int i = 0; i < byteArray.length; i++) {
            if (byteArray[i] != byteArray2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Structure) && obj.getClass() == getClass() && ((Structure) obj).getPointer().equals(getPointer());
    }

    public int hashCode() {
        if (getPointer() != null) {
            return getPointer().hashCode();
        }
        return getClass().hashCode();
    }

    protected void cacheTypeInfo(Pointer pointer) {
        this.typeInfo = pointer.peer;
    }

    FFIType getFieldTypeInfo(StructField structField) {
        ToNativeConverter toNativeConverter;
        Class<?> clsNativeType = structField.type;
        Object fieldValue = getFieldValue(structField.field);
        TypeMapper typeMapper = this.typeMapper;
        if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(clsNativeType)) != null) {
            clsNativeType = toNativeConverter.nativeType();
            fieldValue = toNativeConverter.toNative(fieldValue, new ToNativeContext());
        }
        return FFIType.get(fieldValue, clsNativeType);
    }

    Pointer getTypeInfo() {
        Pointer pointer = getTypeInfo(this).getPointer();
        cacheTypeInfo(pointer);
        return pointer;
    }

    public void setAutoSynch(boolean z) {
        setAutoRead(z);
        setAutoWrite(z);
    }

    public void setAutoRead(boolean z) {
        this.autoRead = z;
    }

    public boolean getAutoRead() {
        return this.autoRead;
    }

    public void setAutoWrite(boolean z) {
        this.autoWrite = z;
    }

    public boolean getAutoWrite() {
        return this.autoWrite;
    }

    static FFIType getTypeInfo(Object obj) {
        return FFIType.get(obj);
    }

    private static <T extends Structure> T newInstance(Class<T> cls, long j) {
        try {
            T t = (T) newInstance(cls, j == 0 ? PLACEHOLDER_MEMORY : new Pointer(j));
            if (j != 0) {
                t.conditionalAutoRead();
            }
            return t;
        } catch (Throwable th) {
            LOG.log(Level.WARNING, "JNA: Error creating structure", th);
            return null;
        }
    }

    public static <T extends Structure> T newInstance(Class<T> cls, Pointer pointer) throws IllegalArgumentException {
        try {
            Constructor pointerConstructor = getPointerConstructor(cls);
            if (pointerConstructor != null) {
                return (T) pointerConstructor.newInstance(pointer);
            }
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Instantiation of " + cls + " (Pointer) not allowed, is it public?", e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException("Can't instantiate " + cls, e2);
        } catch (SecurityException unused) {
        } catch (InvocationTargetException e3) {
            throw new IllegalArgumentException("Exception thrown while instantiating an instance of " + cls, e3);
        }
        T t = (T) newInstance(cls);
        if (pointer != PLACEHOLDER_MEMORY) {
            t.useMemory(pointer);
        }
        return t;
    }

    public static <T extends Structure> T newInstance(Class<T> cls) throws IllegalArgumentException {
        T t = (T) Klass.newInstance(cls);
        if (t instanceof ByValue) {
            t.allocateMemory();
        }
        return t;
    }

    private static <T> Constructor<T> getPointerConstructor(Class<T> cls) throws SecurityException {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(Pointer.class)) {
                return constructor;
            }
        }
        return null;
    }

    protected static class StructField {
        public FromNativeContext context;
        public Field field;
        public boolean isReadOnly;
        public boolean isVolatile;
        public String name;
        public FromNativeConverter readConverter;
        public Class<?> type;
        public ToNativeConverter writeConverter;
        public int size = -1;
        public int offset = -1;

        protected StructField() {
        }

        public String toString() {
            return this.name + SdkConstants.PREFIX_RESOURCE_REF + this.offset + "[" + this.size + "] (" + this.type + ")";
        }
    }

    @FieldOrder({ContentDisposition.Parameters.Size, "alignment", "type", "elements"})
    static class FFIType extends Structure {
        private static final int FFI_TYPE_STRUCT = 13;
        private static final Map<Pointer, FFIType> ffiTypeInfo;
        private static final Map<Class, FFIType> typeInfoMap = new WeakHashMap();
        private static final Map<Class, FFIType> unionHelper = new WeakHashMap();
        public short alignment;
        public Pointer elements;
        public size_t size;
        public short type;

        public static class size_t extends IntegerType {
            private static final long serialVersionUID = 1;

            public size_t() {
                this(0L);
            }

            public size_t(long j) {
                super(Native.SIZE_T_SIZE, j);
            }
        }

        static {
            HashMap map = new HashMap();
            ffiTypeInfo = map;
            if (Native.POINTER_SIZE != 0) {
                if (FFITypes.ffi_type_void != null) {
                    map.put(FFITypes.ffi_type_void, Structure.newInstance(FFIType.class, FFITypes.ffi_type_void));
                    map.put(FFITypes.ffi_type_float, Structure.newInstance(FFIType.class, FFITypes.ffi_type_float));
                    map.put(FFITypes.ffi_type_double, Structure.newInstance(FFIType.class, FFITypes.ffi_type_double));
                    map.put(FFITypes.ffi_type_longdouble, Structure.newInstance(FFIType.class, FFITypes.ffi_type_longdouble));
                    map.put(FFITypes.ffi_type_uint8, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint8));
                    map.put(FFITypes.ffi_type_sint8, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint8));
                    map.put(FFITypes.ffi_type_uint16, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint16));
                    map.put(FFITypes.ffi_type_sint16, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint16));
                    map.put(FFITypes.ffi_type_uint32, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint32));
                    map.put(FFITypes.ffi_type_sint32, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint32));
                    map.put(FFITypes.ffi_type_uint64, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint64));
                    map.put(FFITypes.ffi_type_sint64, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint64));
                    map.put(FFITypes.ffi_type_pointer, Structure.newInstance(FFIType.class, FFITypes.ffi_type_pointer));
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        ((FFIType) it.next()).read();
                    }
                    Map<Class, FFIType> map2 = typeInfoMap;
                    Class cls = Void.TYPE;
                    Map<Pointer, FFIType> map3 = ffiTypeInfo;
                    map2.put(cls, map3.get(FFITypes.ffi_type_void));
                    map2.put(Void.class, map3.get(FFITypes.ffi_type_void));
                    map2.put(Float.TYPE, map3.get(FFITypes.ffi_type_float));
                    map2.put(Float.class, map3.get(FFITypes.ffi_type_float));
                    map2.put(Double.TYPE, map3.get(FFITypes.ffi_type_double));
                    map2.put(Double.class, map3.get(FFITypes.ffi_type_double));
                    map2.put(Long.TYPE, map3.get(FFITypes.ffi_type_sint64));
                    map2.put(Long.class, map3.get(FFITypes.ffi_type_sint64));
                    map2.put(Integer.TYPE, map3.get(FFITypes.ffi_type_sint32));
                    map2.put(Integer.class, map3.get(FFITypes.ffi_type_sint32));
                    map2.put(Short.TYPE, map3.get(FFITypes.ffi_type_sint16));
                    map2.put(Short.class, map3.get(FFITypes.ffi_type_sint16));
                    FFIType fFIType = map3.get(Native.WCHAR_SIZE == 2 ? FFITypes.ffi_type_uint16 : FFITypes.ffi_type_uint32);
                    map2.put(Character.TYPE, fFIType);
                    map2.put(Character.class, fFIType);
                    map2.put(Byte.TYPE, map3.get(FFITypes.ffi_type_sint8));
                    map2.put(Byte.class, map3.get(FFITypes.ffi_type_sint8));
                    map2.put(Pointer.class, map3.get(FFITypes.ffi_type_pointer));
                    map2.put(String.class, map3.get(FFITypes.ffi_type_pointer));
                    map2.put(WString.class, map3.get(FFITypes.ffi_type_pointer));
                    map2.put(Boolean.TYPE, map3.get(FFITypes.ffi_type_uint32));
                    map2.put(Boolean.class, map3.get(FFITypes.ffi_type_uint32));
                    return;
                }
                throw new Error("FFI types not initialized");
            }
            throw new Error("Native library not initialized");
        }

        private static class FFITypes {
            private static Pointer ffi_type_double;
            private static Pointer ffi_type_float;
            private static Pointer ffi_type_longdouble;
            private static Pointer ffi_type_pointer;
            private static Pointer ffi_type_sint16;
            private static Pointer ffi_type_sint32;
            private static Pointer ffi_type_sint64;
            private static Pointer ffi_type_sint8;
            private static Pointer ffi_type_uint16;
            private static Pointer ffi_type_uint32;
            private static Pointer ffi_type_uint64;
            private static Pointer ffi_type_uint8;
            private static Pointer ffi_type_void;

            private FFITypes() {
            }
        }

        private static boolean isIntegerType(FFIType fFIType) {
            Pointer pointer = fFIType.getPointer();
            return pointer.equals(FFITypes.ffi_type_uint8) || pointer.equals(FFITypes.ffi_type_sint8) || pointer.equals(FFITypes.ffi_type_uint16) || pointer.equals(FFITypes.ffi_type_sint16) || pointer.equals(FFITypes.ffi_type_uint32) || pointer.equals(FFITypes.ffi_type_sint32) || pointer.equals(FFITypes.ffi_type_uint64) || pointer.equals(FFITypes.ffi_type_sint64) || pointer.equals(FFITypes.ffi_type_pointer);
        }

        private static boolean isFloatType(FFIType fFIType) {
            Pointer pointer = fFIType.getPointer();
            return pointer.equals(FFITypes.ffi_type_float) || pointer.equals(FFITypes.ffi_type_double);
        }

        public FFIType(FFIType fFIType) {
            this.type = (short) 13;
            this.size = fFIType.size;
            this.alignment = fFIType.alignment;
            this.type = fFIType.type;
            this.elements = fFIType.elements;
        }

        public FFIType() {
            this.type = (short) 13;
        }

        public FFIType(Structure structure) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
            Pointer[] pointerArr;
            this.type = (short) 13;
            structure.ensureAllocated(true);
            int i = 0;
            if (structure instanceof Union) {
                int i2 = 0;
                boolean z = false;
                FFIType fFIType = null;
                for (StructField structField : structure.fields().values()) {
                    FFIType fieldTypeInfo = structure.getFieldTypeInfo(structField);
                    z = isIntegerType(fieldTypeInfo) ? true : z;
                    if (fFIType == null || i2 < structField.size || (i2 == structField.size && Structure.class.isAssignableFrom(structField.type))) {
                        i2 = structField.size;
                        fFIType = fieldTypeInfo;
                    }
                }
                if (!Platform.isWindows() && (((Platform.isIntel() && Platform.is64Bit()) || Platform.isARM()) && z && isFloatType(fFIType))) {
                    FFIType fFIType2 = new FFIType(fFIType);
                    if (fFIType2.size.intValue() == 4) {
                        fFIType2.type = ffiTypeInfo.get(FFITypes.ffi_type_uint32).type;
                    } else if (fFIType2.size.intValue() == 8) {
                        fFIType2.type = ffiTypeInfo.get(FFITypes.ffi_type_uint64).type;
                    }
                    fFIType2.write();
                    fFIType = fFIType2;
                }
                pointerArr = new Pointer[]{fFIType.getPointer(), null};
                unionHelper.put(structure.getClass(), fFIType);
            } else {
                pointerArr = new Pointer[structure.fields().size() + 1];
                Iterator<StructField> it = structure.fields().values().iterator();
                while (it.hasNext()) {
                    pointerArr[i] = structure.getFieldTypeInfo(it.next()).getPointer();
                    i++;
                }
            }
            init(pointerArr);
            write();
        }

        public FFIType(Object obj, Class<?> cls) {
            this.type = (short) 13;
            int length = Array.getLength(obj);
            Pointer[] pointerArr = new Pointer[length + 1];
            Pointer pointer = get(null, cls.getComponentType()).getPointer();
            for (int i = 0; i < length; i++) {
                pointerArr[i] = pointer;
            }
            init(pointerArr);
            write();
        }

        private void init(Pointer[] pointerArr) {
            Memory memory = new Memory(Native.POINTER_SIZE * pointerArr.length);
            this.elements = memory;
            memory.write(0L, pointerArr, 0, pointerArr.length);
            write();
        }

        static FFIType get(Object obj) {
            if (obj == null) {
                return typeInfoMap.get(Pointer.class);
            }
            if (obj instanceof Class) {
                return get(null, (Class) obj);
            }
            return get(obj, obj.getClass());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static FFIType get(Object obj, Class<?> cls) {
            ToNativeConverter toNativeConverter;
            TypeMapper typeMapper = Native.getTypeMapper(cls);
            if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
                cls = toNativeConverter.nativeType();
            }
            Map<Class, FFIType> map = typeInfoMap;
            synchronized (map) {
                FFIType fFIType = map.get(cls);
                if (fFIType != null) {
                    return fFIType;
                }
                if ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Callback.class.isAssignableFrom(cls)) {
                    map.put(cls, map.get(Pointer.class));
                    return map.get(Pointer.class);
                }
                if (Structure.class.isAssignableFrom(cls)) {
                    if (obj == null) {
                        obj = newInstance(cls, Structure.PLACEHOLDER_MEMORY);
                    }
                    if (ByReference.class.isAssignableFrom(cls)) {
                        map.put(cls, map.get(Pointer.class));
                        return map.get(Pointer.class);
                    }
                    FFIType fFIType2 = new FFIType((Structure) obj);
                    map.put(cls, fFIType2);
                    return fFIType2;
                }
                if (NativeMapped.class.isAssignableFrom(cls)) {
                    NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
                    return get(nativeMappedConverter.toNative(obj, new ToNativeContext()), nativeMappedConverter.nativeType());
                }
                if (cls.isArray()) {
                    FFIType fFIType3 = new FFIType(obj, cls);
                    map.put(cls, fFIType3);
                    return fFIType3;
                }
                throw new IllegalArgumentException("Unsupported type " + cls);
            }
        }
    }

    private static class AutoAllocated extends Memory {
        public AutoAllocated(int i) {
            super(i);
            super.clear();
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return "auto-" + super.toString();
        }
    }

    private static void structureArrayCheck(Structure[] structureArr) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (ByReference[].class.isAssignableFrom(structureArr.getClass())) {
            return;
        }
        Pointer pointer = structureArr[0].getPointer();
        int size = structureArr[0].size();
        for (int i = 1; i < structureArr.length; i++) {
            if (structureArr[i].getPointer().peer != pointer.peer + (size * i)) {
                throw new IllegalArgumentException("Structure array elements must use contiguous memory (bad backing address at Structure array index " + i + ")");
            }
        }
    }

    public static void autoRead(Structure[] structureArr) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        structureArrayCheck(structureArr);
        Structure structure = structureArr[0];
        if (structure.array == structureArr) {
            structure.autoRead();
            return;
        }
        for (Structure structure2 : structureArr) {
            if (structure2 != null) {
                structure2.autoRead();
            }
        }
    }

    public void autoRead() {
        if (!getAutoRead()) {
            return;
        }
        read();
        if (this.array == null) {
            return;
        }
        int i = 1;
        while (true) {
            Structure[] structureArr = this.array;
            if (i >= structureArr.length) {
                return;
            }
            structureArr[i].autoRead();
            i++;
        }
    }

    public static void autoWrite(Structure[] structureArr) throws IllegalAccessException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        structureArrayCheck(structureArr);
        Structure structure = structureArr[0];
        if (structure.array == structureArr) {
            structure.autoWrite();
            return;
        }
        for (Structure structure2 : structureArr) {
            if (structure2 != null) {
                structure2.autoWrite();
            }
        }
    }

    public void autoWrite() {
        if (!getAutoWrite()) {
            return;
        }
        write();
        if (this.array == null) {
            return;
        }
        int i = 1;
        while (true) {
            Structure[] structureArr = this.array;
            if (i >= structureArr.length) {
                return;
            }
            structureArr[i].autoWrite();
            i++;
        }
    }

    protected int getNativeSize(Class<?> cls) {
        return getNativeSize(cls, null);
    }

    protected int getNativeSize(Class<?> cls, Object obj) {
        return Native.getNativeSize(cls, obj);
    }

    static void validate(Class<? extends Structure> cls) throws NoSuchMethodException, SecurityException {
        try {
            cls.getConstructor(new Class[0]);
        } catch (NoSuchMethodException | SecurityException unused) {
            throw new IllegalArgumentException("No suitable constructor found for class: " + cls.getName());
        }
    }
}
