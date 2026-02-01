package org.slf4j;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOP_FallbackServiceProvider;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteServiceProvider;
import org.slf4j.helpers.Util;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes6.dex */
public final class LoggerFactory {
    static final String CODES_PREFIX = "https://www.slf4j.org/codes.html";
    static final int FAILED_INITIALIZATION = 2;
    static final String IGNORED_BINDINGS_URL = "https://www.slf4j.org/codes.html#ignoredBindings";
    static volatile int INITIALIZATION_STATE = 0;
    static final String JAVA_VENDOR_PROPERTY = "java.vendor.url";
    static final String LOGGER_NAME_MISMATCH_URL = "https://www.slf4j.org/codes.html#loggerNameMismatch";
    static final String MULTIPLE_BINDINGS_URL = "https://www.slf4j.org/codes.html#multiple_bindings";
    static final int NOP_FALLBACK_INITIALIZATION = 4;
    static final String NO_PROVIDERS_URL = "https://www.slf4j.org/codes.html#noProviders";
    static final int ONGOING_INITIALIZATION = 1;
    static volatile SLF4JServiceProvider PROVIDER = null;
    public static final String PROVIDER_PROPERTY_KEY = "slf4j.provider";
    static final String REPLAY_URL = "https://www.slf4j.org/codes.html#replay";
    private static final String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    static final String SUBSTITUTE_LOGGER_URL = "https://www.slf4j.org/codes.html#substituteLogger";
    static final int SUCCESSFUL_INITIALIZATION = 3;
    static final int UNINITIALIZED = 0;
    static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String UNSUCCESSFUL_INIT_URL = "https://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String VERSION_MISMATCH = "https://www.slf4j.org/codes.html#version_mismatch";
    static final SubstituteServiceProvider SUBST_PROVIDER = new SubstituteServiceProvider();
    static final NOP_FallbackServiceProvider NOP_FALLBACK_SERVICE_PROVIDER = new NOP_FallbackServiceProvider();
    static final String DETECT_LOGGER_NAME_MISMATCH_PROPERTY = "slf4j.detectLoggerNameMismatch";
    static boolean DETECT_LOGGER_NAME_MISMATCH = Util.safeGetBooleanSystemProperty(DETECT_LOGGER_NAME_MISMATCH_PROPERTY);
    private static final String[] API_COMPATIBILITY_LIST = {"2.0"};

    static List<SLF4JServiceProvider> findServiceProviders() {
        ArrayList arrayList = new ArrayList();
        ClassLoader classLoader = LoggerFactory.class.getClassLoader();
        SLF4JServiceProvider sLF4JServiceProviderLoadExplicitlySpecified = loadExplicitlySpecified(classLoader);
        if (sLF4JServiceProviderLoadExplicitlySpecified != null) {
            arrayList.add(sLF4JServiceProviderLoadExplicitlySpecified);
            return arrayList;
        }
        Iterator<SLF4JServiceProvider> it = getServiceLoader(classLoader).iterator();
        while (it.hasNext()) {
            safelyInstantiate(arrayList, it);
        }
        return arrayList;
    }

    private static ServiceLoader<SLF4JServiceProvider> getServiceLoader(final ClassLoader classLoader) {
        if (System.getSecurityManager() == null) {
            return ServiceLoader.load(SLF4JServiceProvider.class, classLoader);
        }
        return (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.slf4j.LoggerFactory$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ServiceLoader.load(SLF4JServiceProvider.class, classLoader);
            }
        });
    }

    private static void safelyInstantiate(List<SLF4JServiceProvider> list, Iterator<SLF4JServiceProvider> it) {
        try {
            list.add(it.next());
        } catch (ServiceConfigurationError e) {
            Util.report("A SLF4J service provider failed to instantiate:\n" + e.getMessage());
        }
    }

    private LoggerFactory() {
    }

    static void reset() {
        INITIALIZATION_STATE = 0;
    }

    private static final void performInitialization() {
        bind();
        if (INITIALIZATION_STATE == 3) {
            versionSanityCheck();
        }
    }

    private static final void bind() {
        try {
            List<SLF4JServiceProvider> listFindServiceProviders = findServiceProviders();
            reportMultipleBindingAmbiguity(listFindServiceProviders);
            if (listFindServiceProviders != null && !listFindServiceProviders.isEmpty()) {
                PROVIDER = listFindServiceProviders.get(0);
                PROVIDER.initialize();
                INITIALIZATION_STATE = 3;
                reportActualBinding(listFindServiceProviders);
            } else {
                INITIALIZATION_STATE = 4;
                Util.report("No SLF4J providers were found.");
                Util.report("Defaulting to no-operation (NOP) logger implementation");
                Util.report("See https://www.slf4j.org/codes.html#noProviders for further details.");
                reportIgnoredStaticLoggerBinders(findPossibleStaticLoggerBinderPathSet());
            }
            postBindCleanUp();
        } catch (Exception e) {
            failedBinding(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        }
    }

    static SLF4JServiceProvider loadExplicitlySpecified(ClassLoader classLoader) {
        String property = System.getProperty(PROVIDER_PROPERTY_KEY);
        if (property != null && !property.isEmpty()) {
            try {
                Util.report(String.format("Attempting to load provider \"%s\" specified via \"%s\" system property", property, PROVIDER_PROPERTY_KEY));
                return (SLF4JServiceProvider) classLoader.loadClass(property).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassCastException e) {
                Util.report(String.format("Specified SLF4JServiceProvider (%s) does not implement SLF4JServiceProvider interface", property), e);
                return null;
            } catch (ClassNotFoundException e2) {
                e = e2;
                Util.report(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (IllegalAccessException e3) {
                e = e3;
                Util.report(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (InstantiationException e4) {
                e = e4;
                Util.report(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (NoSuchMethodException e5) {
                e = e5;
                Util.report(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            } catch (InvocationTargetException e6) {
                e = e6;
                Util.report(String.format("Failed to instantiate the specified SLF4JServiceProvider (%s)", property), e);
                return null;
            }
        }
        return null;
    }

    private static void reportIgnoredStaticLoggerBinders(Set<URL> set) {
        if (set.isEmpty()) {
            return;
        }
        Util.report("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator<URL> it = set.iterator();
        while (it.hasNext()) {
            Util.report("Ignoring binding found at [" + it.next() + "]");
        }
        Util.report("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    static Set<URL> findPossibleStaticLoggerBinderPathSet() throws IOException {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
            } else {
                resources = classLoader.getResources(STATIC_LOGGER_BINDER_PATH);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e) {
            Util.report("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    private static void postBindCleanUp() {
        fixSubstituteLoggers();
        replayEvents();
        SUBST_PROVIDER.getSubstituteLoggerFactory().clear();
    }

    private static void fixSubstituteLoggers() {
        SubstituteServiceProvider substituteServiceProvider = SUBST_PROVIDER;
        synchronized (substituteServiceProvider) {
            substituteServiceProvider.getSubstituteLoggerFactory().postInitialization();
            for (SubstituteLogger substituteLogger : substituteServiceProvider.getSubstituteLoggerFactory().getLoggers()) {
                substituteLogger.setDelegate(getLogger(substituteLogger.getName()));
            }
        }
    }

    static void failedBinding(Throwable th) {
        INITIALIZATION_STATE = 2;
        Util.report("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static void replayEvents() {
        LinkedBlockingQueue<SubstituteLoggingEvent> eventQueue = SUBST_PROVIDER.getSubstituteLoggerFactory().getEventQueue();
        int size = eventQueue.size();
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList(128);
        int i = 0;
        while (eventQueue.drainTo(arrayList, 128) != 0) {
            for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
                replaySingleEvent(substituteLoggingEvent);
                int i2 = i + 1;
                if (i == 0) {
                    emitReplayOrSubstituionWarning(substituteLoggingEvent, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    private static void emitReplayOrSubstituionWarning(SubstituteLoggingEvent substituteLoggingEvent, int i) {
        if (substituteLoggingEvent.getLogger().isDelegateEventAware()) {
            emitReplayWarning(i);
        } else {
            if (substituteLoggingEvent.getLogger().isDelegateNOP()) {
                return;
            }
            emitSubstitutionWarning();
        }
    }

    private static void replaySingleEvent(SubstituteLoggingEvent substituteLoggingEvent) {
        if (substituteLoggingEvent == null) {
            return;
        }
        SubstituteLogger logger = substituteLoggingEvent.getLogger();
        String name = logger.getName();
        if (logger.isDelegateNull()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (logger.isDelegateNOP()) {
            return;
        }
        if (logger.isDelegateEventAware()) {
            if (logger.isEnabledForLevel(substituteLoggingEvent.getLevel())) {
                logger.log(substituteLoggingEvent);
                return;
            }
            return;
        }
        Util.report(name);
    }

    private static void emitSubstitutionWarning() {
        Util.report("The following set of substitute loggers may have been accessed");
        Util.report("during the initialization phase. Logging calls during this");
        Util.report("phase were not honored. However, subsequent logging calls to these");
        Util.report("loggers will work as normally expected.");
        Util.report("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    private static void emitReplayWarning(int i) {
        Util.report("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Util.report("See also https://www.slf4j.org/codes.html#replay");
    }

    private static final void versionSanityCheck() {
        try {
            String requestedApiVersion = PROVIDER.getRequestedApiVersion();
            boolean z = false;
            for (String str : API_COMPATIBILITY_LIST) {
                if (requestedApiVersion.startsWith(str)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Util.report("The requested version " + requestedApiVersion + " by your slf4j provider is not compatible with " + Arrays.asList(API_COMPATIBILITY_LIST).toString());
            Util.report("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            Util.report("Unexpected problem occurred during version sanity check", th);
        }
    }

    private static boolean isAmbiguousProviderList(List<SLF4JServiceProvider> list) {
        return list.size() > 1;
    }

    private static void reportMultipleBindingAmbiguity(List<SLF4JServiceProvider> list) {
        if (isAmbiguousProviderList(list)) {
            Util.report("Class path contains multiple SLF4J providers.");
            Iterator<SLF4JServiceProvider> it = list.iterator();
            while (it.hasNext()) {
                Util.report("Found provider [" + it.next() + "]");
            }
            Util.report("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void reportActualBinding(List<SLF4JServiceProvider> list) {
        if (list.isEmpty() || !isAmbiguousProviderList(list)) {
            return;
        }
        Util.report("Actual provider is of type [" + list.get(0) + "]");
    }

    public static Logger getLogger(String str) {
        return getILoggerFactory().getLogger(str);
    }

    public static Logger getLogger(Class<?> cls) {
        Class<?> callingClass;
        Logger logger = getLogger(cls.getName());
        if (DETECT_LOGGER_NAME_MISMATCH && (callingClass = Util.getCallingClass()) != null && nonMatchingClasses(cls, callingClass)) {
            Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", logger.getName(), callingClass.getName()));
            Util.report("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return logger;
    }

    private static boolean nonMatchingClasses(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    public static ILoggerFactory getILoggerFactory() {
        return getProvider().getLoggerFactory();
    }

    static SLF4JServiceProvider getProvider() {
        if (INITIALIZATION_STATE == 0) {
            synchronized (LoggerFactory.class) {
                if (INITIALIZATION_STATE == 0) {
                    INITIALIZATION_STATE = 1;
                    performInitialization();
                }
            }
        }
        int i = INITIALIZATION_STATE;
        if (i == 1) {
            return SUBST_PROVIDER;
        }
        if (i == 2) {
            throw new IllegalStateException(UNSUCCESSFUL_INIT_MSG);
        }
        if (i == 3) {
            return PROVIDER;
        }
        if (i == 4) {
            return NOP_FALLBACK_SERVICE_PROVIDER;
        }
        throw new IllegalStateException("Unreachable code");
    }
}
