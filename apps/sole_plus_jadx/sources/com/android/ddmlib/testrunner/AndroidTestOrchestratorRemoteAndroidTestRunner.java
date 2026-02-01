package com.android.ddmlib.testrunner;

import com.android.ddmlib.IShellEnabledDevice;
import com.android.ddmlib.testrunner.IRemoteAndroidTestRunner;
import com.android.support.AndroidxName;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AndroidTestOrchestratorRemoteAndroidTestRunner extends RemoteAndroidTestRunner {
    private final boolean useAndroidx;
    private static final AndroidxName SERVICES_APK_PACKAGE = AndroidxName.of("android.support.test.services.");
    private static final AndroidxName SHELL_MAIN_CLASS = AndroidxName.of("android.support.test.services.shellexecutor.", "ShellMain");
    private static final AndroidxName ORCHESTRATOR_PACKAGE = AndroidxName.of("android.support.test.orchestrator.");
    private static final AndroidxName ORCHESTRATOR_CLASS = AndroidxName.of("android.support.test.orchestrator.", "AndroidTestOrchestrator");

    public AndroidTestOrchestratorRemoteAndroidTestRunner(String applicationId, String instrumentationRunner, IShellEnabledDevice device, boolean useAndroidx) {
        super(applicationId, instrumentationRunner, device);
        this.useAndroidx = useAndroidx;
    }

    @Override // com.android.ddmlib.testrunner.RemoteAndroidTestRunner
    public String getAmInstrumentCommand() {
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        arrayListNewArrayList.add("CLASSPATH=$(pm path " + getPackageName(SERVICES_APK_PACKAGE) + ")");
        arrayListNewArrayList.add("app_process / " + getClassName(SHELL_MAIN_CLASS));
        arrayListNewArrayList.add("am");
        arrayListNewArrayList.add("instrument");
        arrayListNewArrayList.add("-r");
        arrayListNewArrayList.add("-w");
        arrayListNewArrayList.add("-e");
        arrayListNewArrayList.add("targetInstrumentation");
        arrayListNewArrayList.add(getRunnerPath());
        arrayListNewArrayList.add(getRunOptions());
        arrayListNewArrayList.add(getArgsCommand());
        arrayListNewArrayList.add(getPackageName(ORCHESTRATOR_PACKAGE) + "/" + getClassName(ORCHESTRATOR_CLASS));
        return Joiner.on(' ').join(arrayListNewArrayList);
    }

    private String getPackageName(AndroidxName aPackage) {
        return (this.useAndroidx ? aPackage.newName() : aPackage.oldName()).substring(0, r3.length() - 1);
    }

    private String getClassName(AndroidxName name) {
        return this.useAndroidx ? name.newName() : name.oldName();
    }

    @Override // com.android.ddmlib.testrunner.RemoteAndroidTestRunner, com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public void setCoverageReportLocation(String reportPath) {
        addInstrumentationArg("coverageFilePath", reportPath);
    }

    @Override // com.android.ddmlib.testrunner.RemoteAndroidTestRunner, com.android.ddmlib.testrunner.IRemoteAndroidTestRunner
    public IRemoteAndroidTestRunner.CoverageOutput getCoverageOutputType() {
        return IRemoteAndroidTestRunner.CoverageOutput.DIR;
    }
}
