package com.android.ddmlib.testrunner;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.ShellCommandUnresponsiveException;
import com.android.ddmlib.TimeoutException;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public interface IRemoteAndroidTestRunner {

    public enum CoverageOutput {
        DIR,
        FILE
    }

    void addBooleanArg(String name, boolean value);

    void addInstrumentationArg(String name, String value);

    void cancel();

    CoverageOutput getCoverageOutputType();

    String getPackageName();

    String getRunnerName();

    void removeInstrumentationArg(String name);

    void run(Collection<ITestRunListener> listeners) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    void run(ITestRunListener... listeners) throws IOException, TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException;

    void setAdditionalTestOutputLocation(String additionalTestDataPath);

    void setClassName(String className);

    void setClassNames(String[] classNames);

    void setCoverage(boolean coverage);

    void setCoverageReportLocation(String reportPath);

    void setDebug(boolean debug);

    void setLogOnly(boolean logOnly);

    void setMaxTimeToOutputResponse(long maxTimeToOutputResponse, TimeUnit maxTimeUnits);

    void setMaxTimeout(long maxTimeout, TimeUnit maxTimeUnits);

    @Deprecated
    void setMaxtimeToOutputResponse(int maxTimeToOutputResponse);

    void setMethodName(String className, String testName);

    void setRunName(String runName);

    void setTestCollection(boolean collection);

    void setTestPackageName(String packageName);

    void setTestSize(TestSize size);

    public enum TestSize {
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large");

        private String mRunnerValue;

        TestSize(String runnerValue) {
            this.mRunnerValue = runnerValue;
        }

        String getRunnerValue() {
            return this.mRunnerValue;
        }

        public static TestSize getTestSize(String value) {
            StringBuilder sb = new StringBuilder("Unknown TestSize ");
            sb.append(value);
            sb.append(", Must be one of ");
            for (TestSize testSize : values()) {
                if (testSize.getRunnerValue().equals(value)) {
                    return testSize;
                }
                sb.append(testSize.getRunnerValue());
                sb.append(", ");
            }
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
