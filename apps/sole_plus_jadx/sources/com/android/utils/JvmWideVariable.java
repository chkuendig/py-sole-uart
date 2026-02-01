package com.android.utils;

import com.android.SdkConstants;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import java.lang.management.ManagementFactory;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

/* loaded from: classes3.dex */
public final class JvmWideVariable<T> {
    private static final Pattern VALID_NAME_PATTERN = Pattern.compile("[^\\s:=,]+");
    private static final ConcurrentMap<String, AtomicReference<Object>> variableTable = createVariableTableIfNotExists();
    private final String fullName;
    private boolean unregistered;

    public interface ValueWrapperMBean<T> {
        public static final String VALUE_PROPERTY = "Value";

        T getValue();
    }

    /* renamed from: $r8$lambda$znRyf6kne0NrjeIup9_jtclKd-0, reason: not valid java name */
    public static /* synthetic */ ConcurrentHashMap m8002$r8$lambda$znRyf6kne0NrjeIup9_jtclKd0() {
        return new ConcurrentHashMap();
    }

    static /* synthetic */ Object lambda$new$1(Object obj) {
        return obj;
    }

    public JvmWideVariable(String group, String name, String tag, TypeToken<T> typeToken, final Supplier<T> initialValueSupplier) {
        String fullName = getFullName(group, name, tag);
        verifyBootstrapLoadedType(typeToken.getType(), fullName);
        this.fullName = fullName;
        this.unregistered = false;
        variableTable.computeIfAbsent(fullName, new Function() { // from class: com.android.utils.JvmWideVariable$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return JvmWideVariable.lambda$new$0(initialValueSupplier, (String) obj);
            }
        });
    }

    static /* synthetic */ AtomicReference lambda$new$0(Supplier supplier, String str) {
        return new AtomicReference(supplier.get());
    }

    public JvmWideVariable(Class<?> definingClass, String name, Class<T> type, final T initialValue) {
        this(definingClass.getName(), name, type.getName(), TypeToken.of((Class) type), new Supplier() { // from class: com.android.utils.JvmWideVariable$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return JvmWideVariable.lambda$new$1(initialValue);
            }
        });
    }

    public JvmWideVariable(Class<?> definingClass, String name, TypeToken<T> typeToken, Supplier<T> initialValueSupplier) {
        this(definingClass.getName(), name, (String) collectComponentClasses(typeToken.getType()).stream().map(new JvmWideVariable$$ExternalSyntheticLambda1()).collect(Collectors.joining(SdkConstants.RES_QUALIFIER_SEP)), typeToken, initialValueSupplier);
    }

    public JvmWideVariable(String group, String name, TypeToken<T> typeToken, Supplier<T> initialValueSupplier) {
        this(group, name, (String) collectComponentClasses(typeToken.getType()).stream().map(new JvmWideVariable$$ExternalSyntheticLambda1()).collect(Collectors.joining(SdkConstants.RES_QUALIFIER_SEP)), typeToken, initialValueSupplier);
    }

    static String getFullName(String group, String name, String tag) {
        Pattern pattern = VALID_NAME_PATTERN;
        Preconditions.checkArgument(pattern.matcher(group).matches());
        Preconditions.checkArgument(pattern.matcher(name).matches());
        Preconditions.checkArgument(pattern.matcher(tag).matches());
        return group + ":name=" + name + ",tag=" + tag;
    }

    private static void verifyBootstrapLoadedType(Type type, String variable) {
        for (Class<?> cls : collectComponentClasses(type)) {
            Verify.verify(cls.getClassLoader() == null, "Type %s used to define JVM-wide variable %s must be loaded by the bootstrap class loader but is loaded by %s", cls, variable, cls.getClassLoader());
        }
    }

    static Collection<Class<?>> collectComponentClasses(Type type) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        doCollectComponentClasses(type, builder);
        return builder.build();
    }

    private static void doCollectComponentClasses(Type type, ImmutableSet.Builder<Class<?>> builder) {
        if (type instanceof Class) {
            builder.add((ImmutableSet.Builder<Class<?>>) type);
            return;
        }
        int i = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            doCollectComponentClasses(parameterizedType.getRawType(), builder);
            if (parameterizedType.getOwnerType() != null) {
                doCollectComponentClasses(parameterizedType.getOwnerType(), builder);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i < length) {
                doCollectComponentClasses(actualTypeArguments[i], builder);
                i++;
            }
            return;
        }
        if (type instanceof GenericArrayType) {
            doCollectComponentClasses(((GenericArrayType) type).getGenericComponentType(), builder);
            return;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            for (Type type2 : wildcardType.getLowerBounds()) {
                doCollectComponentClasses(type2, builder);
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            int length2 = upperBounds.length;
            while (i < length2) {
                doCollectComponentClasses(upperBounds[i], builder);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Type " + type + " is not yet supported");
    }

    private static ConcurrentMap<String, AtomicReference<Object>> createVariableTableIfNotExists() {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            ObjectName objectName = new ObjectName(getFullName("JvmWideVariable", "variableTable", (String) collectComponentClasses(new TypeToken<ConcurrentMap<String, AtomicReference<Object>>>() { // from class: com.android.utils.JvmWideVariable.1
            }.getType()).stream().map(new JvmWideVariable$$ExternalSyntheticLambda1()).collect(Collectors.joining(SdkConstants.RES_QUALIFIER_SEP))));
            synchronized (platformMBeanServer) {
                if (!platformMBeanServer.isRegistered(objectName)) {
                    try {
                        platformMBeanServer.registerMBean(new ValueWrapper(new ConcurrentHashMap()), objectName);
                    } catch (InstanceAlreadyExistsException | NotCompliantMBeanException | MBeanRegistrationException e) {
                        throw new RuntimeException((Throwable) e);
                    }
                }
            }
            try {
                return (ConcurrentMap) Verify.verifyNotNull((ConcurrentMap) platformMBeanServer.getAttribute(objectName, ValueWrapperMBean.VALUE_PROPERTY));
            } catch (MBeanException | ReflectionException | AttributeNotFoundException | InstanceNotFoundException e2) {
                throw new RuntimeException((Throwable) e2);
            }
        } catch (MalformedObjectNameException e3) {
            throw new RuntimeException((Throwable) e3);
        }
    }

    private AtomicReference<T> getVariable() {
        Verify.verify(!this.unregistered, String.format("This JwmWideVariable instance was used to access JVM-wide variable %s, but has already been unregistered", this.fullName), new Object[0]);
        return (AtomicReference) Verify.verifyNotNull(variableTable.get(this.fullName), String.format("JVM-wide variable %s has already been unregistered", this.fullName), new Object[0]);
    }

    public T get() {
        return getVariable().get();
    }

    public void set(T value) {
        getVariable().set(value);
    }

    public <V> V executeCallableSynchronously(Callable<V> action) throws ExecutionException {
        V vCall;
        synchronized (getVariable()) {
            try {
                try {
                    vCall = action.call();
                } catch (Exception e) {
                    throw new ExecutionException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return vCall;
    }

    public <V> V executeSupplierSynchronously(final Supplier<V> supplier) {
        try {
            Objects.requireNonNull(supplier);
            return (V) executeCallableSynchronously(new Callable() { // from class: com.android.utils.JvmWideVariable$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return supplier.get();
                }
            });
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeRunnableSynchronously(final Runnable action) {
        executeSupplierSynchronously(new Supplier() { // from class: com.android.utils.JvmWideVariable$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return JvmWideVariable.lambda$executeRunnableSynchronously$2(action);
            }
        });
    }

    static /* synthetic */ Object lambda$executeRunnableSynchronously$2(Runnable runnable) {
        runnable.run();
        return null;
    }

    public void unregister() {
        Verify.verify(!this.unregistered, String.format("This JwmWideVariable instance was used to access JVM-wide variable %s, but has already been unregistered", this.fullName), new Object[0]);
        Verify.verifyNotNull(variableTable.remove(this.fullName), String.format("JVM-wide variable %s has already been unregistered", this.fullName), new Object[0]);
        this.unregistered = true;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("fullName", this.fullName).add("unregistered", this.unregistered).toString();
    }

    public static <K, V> V getJvmWideObjectPerKey(Class<?> cls, String str, TypeToken<K> typeToken, TypeToken<V> typeToken2, K k, final Supplier<V> supplier) {
        return (V) ((ConcurrentMap) Verify.verifyNotNull((ConcurrentMap) new JvmWideVariable(cls, str, new TypeToken<ConcurrentMap<K, V>>() { // from class: com.android.utils.JvmWideVariable.4
        }.where(new TypeParameter<K>() { // from class: com.android.utils.JvmWideVariable.3
        }, typeToken).where(new TypeParameter<V>() { // from class: com.android.utils.JvmWideVariable.2
        }, typeToken2), new Supplier() { // from class: com.android.utils.JvmWideVariable$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return JvmWideVariable.m8002$r8$lambda$znRyf6kne0NrjeIup9_jtclKd0();
            }
        }).get())).computeIfAbsent(k, new Function() { // from class: com.android.utils.JvmWideVariable$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Verify.verifyNotNull(supplier.get());
            }
        });
    }

    private static final class ValueWrapper<T> implements ValueWrapperMBean<T> {
        private final T value;

        public ValueWrapper(T value) {
            this.value = value;
        }

        @Override // com.android.utils.JvmWideVariable.ValueWrapperMBean
        public T getValue() {
            return this.value;
        }
    }
}
