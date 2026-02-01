package com.android.ddmlib.testrunner;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.IShellEnabledDevice;
import com.android.ddmlib.Log;
import com.android.ddmlib.ShellCommandUnresponsiveException;
import com.android.ddmlib.TimeoutException;
import com.android.ddmlib.testrunner.IRemoteAndroidTestRunner;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/* loaded from: classes3.dex */
public class RemoteAndroidTestRunner implements IRemoteAndroidTestRunner {
    private static final String CLASS_ARG_NAME = "class";
    private static final char CLASS_SEPARATOR = ',';
    private static final String COVERAGE_ARG_NAME = "coverage";
    private static final String DEBUG_ARG_NAME = "debug";
    private static final String DEFAULT_RUNNER_NAME = "android.test.InstrumentationTestRunner";
    private static final String DELAY_MSEC_ARG_NAME = "delay_msec";
    private static final String LOG_ARG_NAME = "log";
    private static final String LOG_TAG = "RemoteAndroidTest";
    private static final char METHOD_SEPARATOR = '#';
    private static final String PACKAGE_ARG_NAME = "package";
    private static final char RUNNER_SEPARATOR = '/';
    private static final String SIZE_ARG_NAME = "size";
    private static final int TEST_COLLECTION_TIMEOUT = 120000;
    private Map<String, String> mArgMap;
    private long mMaxTimeToOutputResponseMs;
    private long mMaxTimeoutMs;
    private final String mPackageName;
    private IInstrumentationResultParser mParser;
    private IShellEnabledDevice mRemoteDevice;
    private String mRunName;
    private String mRunOptions;
    private final String mRunnerName;
    private final StatusReporterMode mStatusReporterMode;

    public enum StatusReporterMode {
        RAW_TEXT("-r", 0, new BiFunction() { // from class: com.android.ddmlib.testrunner.RemoteAndroidTestRunner$StatusReporterMode$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return new InstrumentationResultParser((String) obj, (Collection<ITestRunListener>) obj2);
            }
        }),
        PROTO_STD("-m", 26, new BiFunction() { // from class: com.android.ddmlib.testrunner.RemoteAndroidTestRunner$StatusReporterMode$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return new InstrumentationProtoResultParser((String) obj, (Collection) obj2);
            }
        });

        private final String amInstrumentCommandArg;
        private final int minApiLevel;
        private final BiFunction<String, Collection<ITestRunListener>, IInstrumentationResultParser> parserFactory;

        StatusReporterMode(String amInstrumentCommandArg, int minApiLevel, BiFunction parserFactory) {
            this.amInstrumentCommandArg = amInstrumentCommandArg;
            this.minApiLevel = minApiLevel;
            this.parserFactory = parserFactory;
        }

        public String getAmInstrumentCommandArg() {
            return this.amInstrumentCommandArg;
        }

        public int getMinimumApiLevel() {
            return this.minApiLevel;
        }

        public IInstrumentationResultParser createInstrumentationResultParser(String runName, Collection<ITestRunListener> listeners) {
            return this.parserFactory.apply(runName, listeners);
        }
    }

    public RemoteAndroidTestRunner(String packageName, String runnerName, IShellEnabledDevice remoteDevice, StatusReporterMode statusReporterMode) {
        this.mMaxTimeoutMs = 0L;
        this.mMaxTimeToOutputResponseMs = 0L;
        this.mRunName = null;
        this.mRunOptions = "";
        this.mPackageName = packageName;
        this.mRunnerName = runnerName;
        this.mRemoteDevice = remoteDevice;
        this.mStatusReporterMode = statusReporterMode;
        this.mArgMap = new Hashtable();
    }

    public RemoteAndroidTestRunner(String packageName, String runnerName, IShellEnabledDevice remoteDevice) {
        this(packageName, runnerName, remoteDevice, StatusReporterMode.RAW_TEXT);
    }

    public RemoteAndroidTestRunner(String packageName, IShellEnabledDevice remoteDevice) {
        this(packageName, null, remoteDevice);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public String getRunnerName() {
        String str = this.mRunnerName;
        return str == null ? "android.test.InstrumentationTestRunner" : str;
    }

    protected String getRunnerPath() {
        return getPackageName() + RUNNER_SEPARATOR + getRunnerName();
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setClassName(String className) {
        addInstrumentationArg("class", "'" + className + "'");
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setClassNames(String[] classNames) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < classNames.length; i++) {
            if (i != 0) {
                sb.append(',');
            }
            sb.append(classNames[i]);
        }
        setClassName(sb.toString());
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setMethodName(String className, String testName) {
        setClassName(className + METHOD_SEPARATOR + testName);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setTestPackageName(String packageName) {
        addInstrumentationArg("package", packageName);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void addInstrumentationArg(String name, String value) {
        if (name == null || value == null) {
            throw new IllegalArgumentException("name or value arguments cannot be null");
        }
        this.mArgMap.put(name, value);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void removeInstrumentationArg(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name argument cannot be null");
        }
        this.mArgMap.remove(name);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void addBooleanArg(String name, boolean value) {
        addInstrumentationArg(name, Boolean.toString(value));
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setLogOnly(boolean logOnly) {
        addBooleanArg(LOG_ARG_NAME, logOnly);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setDebug(boolean debug) {
        addBooleanArg(DEBUG_ARG_NAME, debug);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setAdditionalTestOutputLocation(String additionalTestDataPath) {
        addInstrumentationArg("additionalTestOutputDir", additionalTestDataPath);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setCoverage(boolean coverage) {
        addBooleanArg(COVERAGE_ARG_NAME, coverage);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setCoverageReportLocation(String reportPath) {
        addInstrumentationArg("coverageFile", reportPath);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public IRemoteAndroidTestRunner.CoverageOutput getCoverageOutputType() {
        return IRemoteAndroidTestRunner.CoverageOutput.FILE;
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setTestSize(IRemoteAndroidTestRunner.TestSize size) {
        addInstrumentationArg("size", size.getRunnerValue());
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setTestCollection(boolean collect) {
        if (collect) {
            setLogOnly(true);
            setMaxTimeToOutputResponse(120000L, TimeUnit.MILLISECONDS);
            if (getApiLevel() < 16) {
                addInstrumentationArg(DELAY_MSEC_ARG_NAME, "15");
                return;
            }
            return;
        }
        setLogOnly(false);
        setMaxTimeToOutputResponse(this.mMaxTimeToOutputResponseMs, TimeUnit.MILLISECONDS);
        if (getApiLevel() < 16) {
            removeInstrumentationArg(DELAY_MSEC_ARG_NAME);
        }
    }

    private int getApiLevel() {
        try {
            return Integer.parseInt(this.mRemoteDevice.getSystemProperty("ro.build.version.sdk").get());
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    @Deprecated
    public void setMaxtimeToOutputResponse(int maxTimeToOutputResponse) {
        setMaxTimeToOutputResponse(maxTimeToOutputResponse, TimeUnit.MILLISECONDS);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setMaxTimeToOutputResponse(long maxTimeToOutputResponse, TimeUnit maxTimeUnits) {
        this.mMaxTimeToOutputResponseMs = maxTimeUnits.toMillis(maxTimeToOutputResponse);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setMaxTimeout(long maxTimeout, TimeUnit maxTimeUnits) {
        this.mMaxTimeoutMs = maxTimeUnits.toMillis(maxTimeout);
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setRunName(String runName) {
        this.mRunName = runName;
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void run(ITestRunListener... listeners) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
        run(Arrays.asList(listeners));
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void run(Collection<ITestRunListener> listeners) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException {
        String amInstrumentCommand = getAmInstrumentCommand();
        Log.i(LOG_TAG, String.format("Running %1$s on %2$s", amInstrumentCommand, this.mRemoteDevice.getName()));
        String str = this.mRunName;
        if (str == null) {
            str = this.mPackageName;
        }
        IInstrumentationResultParser iInstrumentationResultParserCreateParser = createParser(str, listeners);
        this.mParser = iInstrumentationResultParserCreateParser;
        try {
            this.mRemoteDevice.executeShellCommand(amInstrumentCommand, iInstrumentationResultParserCreateParser, this.mMaxTimeoutMs, this.mMaxTimeToOutputResponseMs, TimeUnit.MILLISECONDS);
        } catch (AdbCommandRejectedException e) {
            Log.w(LOG_TAG, String.format("AdbCommandRejectedException %1$s when running tests %2$s on %3$s", e.toString(), getPackageName(), this.mRemoteDevice.getName()));
            this.mParser.handleTestRunFailed(e.toString());
            throw e;
        } catch (ShellCommandUnresponsiveException e2) {
            Log.w(LOG_TAG, String.format("ShellCommandUnresponsiveException %1$s when running tests %2$s on %3$s", e2.toString(), getPackageName(), this.mRemoteDevice.getName()));
            this.mParser.handleTestRunFailed(String.format("Failed to receive adb shell test output within %1$d ms. Test may have timed out, or adb connection to device became unresponsive", Long.valueOf(this.mMaxTimeToOutputResponseMs)));
            throw e2;
        } catch (TimeoutException e3) {
            Log.w(LOG_TAG, String.format("TimeoutException when running tests %1$s on %2$s", getPackageName(), this.mRemoteDevice.getName()));
            this.mParser.handleTestRunFailed(e3.toString());
            throw e3;
        } catch (IOException e4) {
            Log.w(LOG_TAG, String.format("IOException %1$s when running tests %2$s on %3$s", e4.toString(), getPackageName(), this.mRemoteDevice.getName()));
            this.mParser.handleTestRunFailed(e4.toString());
            throw e4;
        }
    }

    public IInstrumentationResultParser createParser(String runName, Collection<ITestRunListener> listeners) {
        return this.mStatusReporterMode.createInstrumentationResultParser(runName, listeners);
    }

    public String getAmInstrumentCommand() {
        return String.format("am instrument -w %1$s %2$s %3$s %4$s", this.mStatusReporterMode.getAmInstrumentCommandArg(), getRunOptions(), getArgsCommand(), getRunnerPath());
    }

    public String getRunOptions() {
        return this.mRunOptions;
    }

    public void setRunOptions(String options) {
        this.mRunOptions = options;
    }

    @Override // com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void cancel() {
        IInstrumentationResultParser iInstrumentationResultParser = this.mParser;
        if (iInstrumentationResultParser != null) {
            iInstrumentationResultParser.cancel();
        }
    }

    protected String getArgsCommand() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mArgMap.entrySet()) {
            sb.append(String.format(" -e %1$s %2$s", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
