package com.android.ddmlib;

import com.android.ddmlib.IDevice;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class IotInstallChecker {
    private static final String DUMP_PACKAGES_CMD = "dumpsys package -f";
    private static final String TAG = "IotInstallChecker";

    public Set<String> getInstalledIotLauncherApps(final IDevice device) {
        return getInstalledIotLauncherApps(device, 1L, TimeUnit.MINUTES);
    }

    public Set<String> getInstalledIotLauncherApps(final IDevice device, long timeout, TimeUnit unit) {
        if (!device.supportsFeature(IDevice.HardwareFeature.EMBEDDED)) {
            return Collections.emptySet();
        }
        LauncherPackagesReceiver launcherPackagesReceiver = new LauncherPackagesReceiver();
        SystemPackagesReceiver systemPackagesReceiver = new SystemPackagesReceiver();
        try {
            device.executeShellCommand(DUMP_PACKAGES_CMD, new CombinedReceiver(launcherPackagesReceiver, systemPackagesReceiver), timeout, unit);
        } catch (Exception e) {
            Log.e(TAG, e);
        }
        HashSet hashSet = new HashSet(launcherPackagesReceiver.getMatchingPackages());
        hashSet.removeAll(systemPackagesReceiver.getMatchingPackages());
        return hashSet;
    }

    static class CombinedReceiver extends MultiLineReceiver {
        private MultiLineReceiver[] receivers;

        public CombinedReceiver(MultiLineReceiver... receivers) {
            this.receivers = receivers;
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void processNewLines(String[] lines) {
            for (MultiLineReceiver multiLineReceiver : this.receivers) {
                multiLineReceiver.processNewLines(lines);
            }
        }

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            for (MultiLineReceiver multiLineReceiver : this.receivers) {
                if (!multiLineReceiver.isCancelled()) {
                    return false;
                }
            }
            return true;
        }
    }

    static class SystemPackagesReceiver extends PackageCollectorReceiver {
        private static final String PackagesPart = "Packages";
        private static final String SYSTEM_FLAG = "SYSTEM";
        private static final Pattern PackagesPackageRegex = Pattern.compile("^Package \\[([\\w\\.]+)\\] \\(\\w+\\):$");
        private static final Pattern FlagsRegex = Pattern.compile("^flags=\\[ ([\\w\\s_]+) \\]$");

        SystemPackagesReceiver() {
            super(PackagesPart, PackagesPackageRegex);
        }

        @Override // com.android.ddmlib.IotInstallChecker.PackageCollectorReceiver
        boolean packageQualifies(String line) {
            Matcher matcher = FlagsRegex.matcher(line);
            if (matcher.matches()) {
                for (String str : matcher.group(1).split(" ")) {
                    if (str.equals(SYSTEM_FLAG)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class LauncherPackagesReceiver extends PackageCollectorReceiver {
        private static final Pattern FiltersPackageRegex = Pattern.compile("^\\w+ ([\\w\\.]+)/\\.\\w+ filter \\w+$");
        private static final String FiltersPart = "android.intent.action.MAIN";
        private static final String IotLauncher = "android.intent.category.IOT_LAUNCHER";

        LauncherPackagesReceiver() {
            super(FiltersPart, FiltersPackageRegex);
        }

        @Override // com.android.ddmlib.IotInstallChecker.PackageCollectorReceiver
        boolean packageQualifies(String line) {
            return line.contains(IotLauncher);
        }
    }

    private static abstract class PackageCollectorReceiver extends MultiLineReceiver {
        private static final Pattern ParagraphRegex = Pattern.compile("^([\\w\\.]+):$");
        private String currentPackage;
        private boolean isCancelled;
        private boolean mainPart;
        private final Set<String> matchingPackages;
        private Pattern packageRegex;
        private String paragraphName;

        abstract boolean packageQualifies(String line);

        private PackageCollectorReceiver(String paragraphName, Pattern packageRegex) {
            this.matchingPackages = new HashSet();
            this.mainPart = false;
            this.isCancelled = false;
            this.paragraphName = paragraphName;
            this.packageRegex = packageRegex;
        }

        @Override // com.android.ddmlib.MultiLineReceiver
        public void processNewLines(String[] lines) {
            for (String str : lines) {
                processNewLine(str);
            }
        }

        private void processNewLine(String line) {
            if (updateCurrentPart(line) || !this.mainPart || updateCurrentPackage(line) || this.matchingPackages.contains(this.currentPackage) || !packageQualifies(line)) {
                return;
            }
            this.matchingPackages.add(this.currentPackage);
        }

        private boolean updateCurrentPart(String line) {
            Matcher matcher = ParagraphRegex.matcher(line);
            if (!matcher.matches() || !matcher.group(1).equals(this.paragraphName)) {
                return false;
            }
            this.mainPart = true;
            return true;
        }

        private boolean updateCurrentPackage(String line) {
            Matcher matcher = this.packageRegex.matcher(line);
            if (!matcher.matches()) {
                return false;
            }
            this.currentPackage = matcher.group(1);
            return true;
        }

        @Override // com.android.ddmlib.IShellOutputReceiver
        public boolean isCancelled() {
            return this.isCancelled;
        }

        public Set<String> getMatchingPackages() {
            return this.matchingPackages;
        }
    }
}
