package org.slf4j.spi;

import java.util.Iterator;
import java.util.function.Supplier;
import org.objectweb.asm.signature.SignatureVisitor;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.DefaultLoggingEvent;
import org.slf4j.event.KeyValuePair;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;

/* loaded from: classes6.dex */
public class DefaultLoggingEventBuilder implements LoggingEventBuilder, CallerBoundaryAware {
    static String DLEB_FQCN = "org.slf4j.spi.DefaultLoggingEventBuilder";
    protected Logger logger;
    protected DefaultLoggingEvent loggingEvent;

    public DefaultLoggingEventBuilder(Logger logger, Level level) {
        this.logger = logger;
        this.loggingEvent = new DefaultLoggingEvent(level, logger);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addMarker(Marker marker) {
        this.loggingEvent.addMarker(marker);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder setCause(Throwable th) {
        this.loggingEvent.setThrowable(th);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addArgument(Object obj) {
        this.loggingEvent.addArgument(obj);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addArgument(Supplier<?> supplier) {
        this.loggingEvent.addArgument(supplier.get());
        return this;
    }

    @Override // org.slf4j.spi.CallerBoundaryAware
    public void setCallerBoundary(String str) {
        this.loggingEvent.setCallerBoundary(str);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log() {
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder setMessage(String str) {
        this.loggingEvent.setMessage(str);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder setMessage(Supplier<String> supplier) {
        this.loggingEvent.setMessage(supplier.get());
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str) {
        this.loggingEvent.setMessage(str);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str, Object obj) {
        this.loggingEvent.setMessage(str);
        this.loggingEvent.addArgument(obj);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str, Object obj, Object obj2) {
        this.loggingEvent.setMessage(str);
        this.loggingEvent.addArgument(obj);
        this.loggingEvent.addArgument(obj2);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(String str, Object... objArr) {
        this.loggingEvent.setMessage(str);
        this.loggingEvent.addArguments(objArr);
        log(this.loggingEvent);
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public void log(Supplier<String> supplier) {
        if (supplier == null) {
            log((String) null);
        } else {
            log(supplier.get());
        }
    }

    protected void log(LoggingEvent loggingEvent) {
        setCallerBoundary(DLEB_FQCN);
        Logger logger = this.logger;
        if (logger instanceof LoggingEventAware) {
            ((LoggingEventAware) logger).log(loggingEvent);
        } else {
            logViaPublicSLF4JLoggerAPI(loggingEvent);
        }
    }

    private void logViaPublicSLF4JLoggerAPI(LoggingEvent loggingEvent) {
        Object[] argumentArray = loggingEvent.getArgumentArray();
        int length = argumentArray == null ? 0 : argumentArray.length;
        Throwable throwable = loggingEvent.getThrowable();
        int i = throwable == null ? 0 : 1;
        String message = loggingEvent.getMessage();
        Object[] objArr = new Object[i + length];
        if (argumentArray != null) {
            System.arraycopy(argumentArray, 0, objArr, 0, length);
        }
        if (throwable != null) {
            objArr[length] = throwable;
        }
        String strMergeMarkersAndKeyValuePairs = mergeMarkersAndKeyValuePairs(loggingEvent, message);
        int i2 = AnonymousClass1.$SwitchMap$org$slf4j$event$Level[loggingEvent.getLevel().ordinal()];
        if (i2 == 1) {
            this.logger.trace(strMergeMarkersAndKeyValuePairs, objArr);
            return;
        }
        if (i2 == 2) {
            this.logger.debug(strMergeMarkersAndKeyValuePairs, objArr);
            return;
        }
        if (i2 == 3) {
            this.logger.info(strMergeMarkersAndKeyValuePairs, objArr);
        } else if (i2 == 4) {
            this.logger.warn(strMergeMarkersAndKeyValuePairs, objArr);
        } else {
            if (i2 != 5) {
                return;
            }
            this.logger.error(strMergeMarkersAndKeyValuePairs, objArr);
        }
    }

    /* renamed from: org.slf4j.spi.DefaultLoggingEventBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$slf4j$event$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$org$slf4j$event$Level = iArr;
            try {
                iArr[Level.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$slf4j$event$Level[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private String mergeMarkersAndKeyValuePairs(LoggingEvent loggingEvent, String str) {
        StringBuilder sb;
        if (loggingEvent.getMarkers() != null) {
            sb = new StringBuilder();
            Iterator<Marker> it = loggingEvent.getMarkers().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(' ');
            }
        } else {
            sb = null;
        }
        if (loggingEvent.getKeyValuePairs() != null) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            for (KeyValuePair keyValuePair : loggingEvent.getKeyValuePairs()) {
                sb.append(keyValuePair.key);
                sb.append(SignatureVisitor.INSTANCEOF);
                sb.append(keyValuePair.value);
                sb.append(' ');
            }
        }
        if (sb == null) {
            return str;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addKeyValue(String str, Object obj) {
        this.loggingEvent.addKeyValue(str, obj);
        return this;
    }

    @Override // org.slf4j.spi.LoggingEventBuilder
    public LoggingEventBuilder addKeyValue(String str, Supplier<Object> supplier) {
        this.loggingEvent.addKeyValue(str, supplier.get());
        return this;
    }
}
