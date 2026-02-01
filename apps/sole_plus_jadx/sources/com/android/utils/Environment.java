package com.android.utils;

import com.android.utils.Environment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComputerArchUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u000bH&R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/android/utils/Environment;", "", "()V", "isRosetta", "", "()Z", "getSystemProperty", "", "name", "Lcom/android/utils/Environment$SystemProperty;", "getVariable", "Lcom/android/utils/Environment$EnvironmentVariable;", "Companion", "EnvironmentVariable", "SystemProperty", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Environment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Environment SYSTEM;
    private static boolean initialized;
    private static Environment instance;

    @JvmStatic
    public static final void initialize(Environment environment) {
        INSTANCE.initialize(environment);
    }

    public abstract String getVariable(EnvironmentVariable name);

    /* compiled from: ComputerArchUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/utils/Environment$EnvironmentVariable;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "HOST_TYPE", "PROCESSOR_ARCHITEW6432", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum EnvironmentVariable {
        HOST_TYPE("HOSTTYPE"),
        PROCESSOR_ARCHITEW6432("PROCESSOR_ARCHITEW6432");

        private final String key;

        EnvironmentVariable(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* compiled from: ComputerArchUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/utils/Environment$SystemProperty;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "OS_ARCH", "OS_NAME", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum SystemProperty {
        OS_ARCH("os.arch"),
        OS_NAME("os.name");

        private final String key;

        SystemProperty(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public String getSystemProperty(SystemProperty name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return System.getProperty(name.getKey());
    }

    public boolean isRosetta() {
        return ComputerArchUtilsKt.computeIsRosetta();
    }

    /* compiled from: ComputerArchUtils.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/android/utils/Environment$Companion;", "", "()V", "SYSTEM", "Lcom/android/utils/Environment;", "getSYSTEM", "()Lcom/android/utils/Environment;", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "instance", "getInstance", "setInstance", "(Lcom/android/utils/Environment;)V", "initialize", "", "customEnvironment", "common"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Environment getSYSTEM() {
            return Environment.SYSTEM;
        }

        public final Environment getInstance() {
            return Environment.instance;
        }

        public final void setInstance(Environment environment) {
            Intrinsics.checkNotNullParameter(environment, "<set-?>");
            Environment.instance = environment;
        }

        public final boolean getInitialized() {
            return Environment.initialized;
        }

        public final void setInitialized(boolean z) {
            Environment.initialized = z;
        }

        public static /* synthetic */ void initialize$default(Companion companion, Environment environment, int i, Object obj) {
            if ((i & 1) != 0) {
                environment = null;
            }
            companion.initialize(environment);
        }

        @JvmStatic
        public final void initialize(Environment customEnvironment) {
            setInitialized(true);
            if (customEnvironment == null) {
                return;
            }
            Environment.INSTANCE.setInstance(customEnvironment);
        }
    }

    static {
        Environment environment = new Environment() { // from class: com.android.utils.Environment$Companion$SYSTEM$1
            @Override // com.android.utils.Environment
            public String getVariable(Environment.EnvironmentVariable name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return System.getenv(name.getKey());
            }

            @Override // com.android.utils.Environment
            public boolean isRosetta() {
                return ComputerArchUtilsKt.computeIsRosetta();
            }
        };
        SYSTEM = environment;
        instance = environment;
    }
}
