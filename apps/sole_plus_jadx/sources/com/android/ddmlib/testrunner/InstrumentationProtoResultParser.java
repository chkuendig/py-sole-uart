package com.android.ddmlib.testrunner;

import com.android.commands.am.InstrumentationData;
import com.android.ddmlib.Log;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class InstrumentationProtoResultParser implements IInstrumentationResultParser {
    private static final String LOG_TAG = "InstrumentationProtoResultParser";
    private final Collection<ITestRunListener> mListeners;
    private final String mRunName;
    private InstrumentationProtoResultParserState mState = InstrumentationProtoResultParserState.NOT_STARTED;
    private ByteArrayOutputStream mPendingData = new ByteArrayOutputStream();
    private final LinkedHashMap<TestIdentifier, TestStatus> mTestStatuses = new LinkedHashMap<>();
    private final Pattern mTimePattern = Pattern.compile("Time: \\s*([\\d\\,]*[\\d\\.]+)");

    static /* synthetic */ Map.Entry lambda$updateState$2(Map.Entry entry, Map.Entry entry2) {
        return entry2;
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void flush() {
    }

    private enum InstrumentationProtoResultParserState {
        NOT_STARTED(false),
        RUNNING(false),
        FINISHED(true),
        CANCELLED(true);

        private final boolean mIsTerminalState;

        InstrumentationProtoResultParserState(boolean isTerminalState) {
            this.mIsTerminalState = isTerminalState;
        }

        public boolean isTerminalState() {
            return this.mIsTerminalState;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class TestStatus {
        private static final int MAX_LOGCAT_LENGTH = 10000;
        private StringBuilder mLogcat = new StringBuilder();
        private final LinkedHashMap<String, String> mTestMetrics = new LinkedHashMap<>();
        private int mTestResultCode;

        public TestStatus(int testResultCode) {
            this.mTestResultCode = testResultCode;
        }

        public void setTestResultCode(int testResultCode) {
            this.mTestResultCode = testResultCode;
        }

        public int getTestResultCode() {
            return this.mTestResultCode;
        }

        public void appendLogcat(String logcat) {
            if (this.mLogcat.length() >= 10000) {
                return;
            }
            if (this.mLogcat.length() + logcat.length() < 10000) {
                this.mLogcat.append(logcat);
            } else {
                StringBuilder sb = this.mLogcat;
                sb.append(logcat.subSequence(0, 10000 - sb.length()));
            }
        }

        public void clearLogcat() {
            this.mLogcat = new StringBuilder();
        }

        public String getLogcat() {
            return this.mLogcat.toString();
        }

        public void putTestMetrics(String key, String value) {
            this.mTestMetrics.put(key, value);
        }

        public void putAllTestMetrics(Map<String, String> testMetrics) {
            this.mTestMetrics.putAll(testMetrics);
        }

        public Map<String, String> getTestMetrics() {
            return ImmutableMap.copyOf((Map) this.mTestMetrics);
        }
    }

    public InstrumentationProtoResultParser(String runName, Collection<ITestRunListener> listeners) {
        this.mRunName = runName;
        this.mListeners = listeners;
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void addOutput(byte[] data, int offset, int length) {
        if (this.mState.isTerminalState()) {
            return;
        }
        this.mPendingData.write(data, offset, length);
        try {
            InstrumentationData.Session from = InstrumentationData.Session.parseFrom(this.mPendingData.toByteArray());
            this.mPendingData.reset();
            updateState(from);
        } catch (InvalidProtocolBufferException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateState(com.android.commands.am.InstrumentationData.Session r18) {
        /*
            Method dump skipped, instructions count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.ddmlib.testrunner.InstrumentationProtoResultParser.updateState(com.android.commands.am.InstrumentationData$Session):void");
    }

    /* renamed from: com.android.ddmlib.testrunner.InstrumentationProtoResultParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$commands$am$InstrumentationData$SessionStatusCode;

        static {
            int[] iArr = new int[InstrumentationData.SessionStatusCode.values().length];
            $SwitchMap$com$android$commands$am$InstrumentationData$SessionStatusCode = iArr;
            try {
                iArr[InstrumentationData.SessionStatusCode.SESSION_ABORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$commands$am$InstrumentationData$SessionStatusCode[InstrumentationData.SessionStatusCode.SESSION_FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static String getResultsEntryBundleValueInString(InstrumentationData.ResultsBundleEntry entry) {
        return entry.hasValueString() ? entry.getValueString() : entry.hasValueInt() ? String.valueOf(entry.getValueInt()) : entry.hasValueLong() ? String.valueOf(entry.getValueLong()) : entry.hasValueFloat() ? String.valueOf(entry.getValueFloat()) : entry.hasValueDouble() ? String.valueOf(entry.getValueDouble()) : entry.hasValueBytes() ? entry.getValueBytes().toString() : entry.hasValueBundle() ? entry.getValueBundle().toString() : "";
    }

    private void updateTestState(String testClassName, String testMethodName, int currentTestIndex, int testResultCode, String logcat, String stackTrace, LinkedHashMap<String, String> testMetrics) {
        final TestIdentifier testIdentifier = new TestIdentifier(testClassName, testMethodName, currentTestIndex);
        TestStatus testStatusComputeIfAbsent = this.mTestStatuses.computeIfAbsent(testIdentifier, new Function() { // from class: com.android.ddmlib.testrunner.InstrumentationProtoResultParser$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m7990xc41a3e50(testIdentifier, (TestIdentifier) obj);
            }
        });
        testStatusComputeIfAbsent.appendLogcat(logcat);
        testStatusComputeIfAbsent.putAllTestMetrics(testMetrics);
        if (testStatusComputeIfAbsent.getTestResultCode() == testResultCode) {
            return;
        }
        testStatusComputeIfAbsent.setTestResultCode(testResultCode);
        if (testResultCode == -4) {
            Iterator<ITestRunListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().testAssumptionFailure(testIdentifier, stackTrace);
            }
        } else if (testResultCode == -3) {
            Iterator<ITestRunListener> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                it2.next().testIgnored(testIdentifier);
            }
            testStatusComputeIfAbsent.clearLogcat();
        } else if (testResultCode == -2 || testResultCode == -1) {
            Iterator<ITestRunListener> it3 = this.mListeners.iterator();
            while (it3.hasNext()) {
                it3.next().testFailed(testIdentifier, stackTrace);
            }
        }
        if (IInstrumentationResultParser.StatusCodes.isTerminalState(testResultCode)) {
            testStatusComputeIfAbsent.putTestMetrics(IInstrumentationResultParser.StatusKeys.DDMLIB_LOGCAT, testStatusComputeIfAbsent.getLogcat());
            Iterator<ITestRunListener> it4 = this.mListeners.iterator();
            while (it4.hasNext()) {
                it4.next().testEnded(testIdentifier, testStatusComputeIfAbsent.getTestMetrics());
            }
        }
    }

    /* renamed from: lambda$updateTestState$5$com-android-ddmlib-testrunner-InstrumentationProtoResultParser, reason: not valid java name */
    /* synthetic */ TestStatus m7990xc41a3e50(TestIdentifier testIdentifier, TestIdentifier testIdentifier2) {
        Iterator<ITestRunListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().testStarted(testIdentifier);
        }
        return new TestStatus(1);
    }

    private Optional<Long> findElapsedTime(InstrumentationData.SessionStatus sessionStatus) {
        String str = (String) sessionStatus.getResults().getEntriesList().stream().filter(new Predicate() { // from class: com.android.ddmlib.testrunner.InstrumentationProtoResultParser$$ExternalSyntheticLambda5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InstrumentationData.ResultsBundleEntry) obj).getKey().equals(IInstrumentationResultParser.StatusKeys.STREAM);
            }
        }).map(new Function() { // from class: com.android.ddmlib.testrunner.InstrumentationProtoResultParser$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((InstrumentationData.ResultsBundleEntry) obj).getValueString();
            }
        }).findFirst().orElse(null);
        if (Strings.isNullOrEmpty(str)) {
            return Optional.empty();
        }
        Matcher matcher = this.mTimePattern.matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            try {
                return Optional.of(Long.valueOf((long) (NumberFormat.getInstance().parse(strGroup).floatValue() * 1000.0f)));
            } catch (ParseException unused) {
                Log.w(LOG_TAG, String.format("Unexpected time format %1$s", strGroup));
            }
        }
        Log.w(LOG_TAG, String.format("Elapsed time is missing: %1$s", str));
        return Optional.empty();
    }

    @Override // com.android.ddmlib.testrunner.IInstrumentationResultParser
    public void handleTestRunFailed(String errorMsg) {
        if (this.mState.isTerminalState()) {
            return;
        }
        this.mState = InstrumentationProtoResultParserState.FINISHED;
        Iterator<ITestRunListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().testRunFailed(errorMsg);
        }
        Iterator<ITestRunListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().testRunEnded(0L, ImmutableMap.of());
        }
    }

    @Override // com.android.ddmlib.testrunner.IInstrumentationResultParser
    public void cancel() {
        this.mState = InstrumentationProtoResultParserState.CANCELLED;
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public boolean isCancelled() {
        return this.mState == InstrumentationProtoResultParserState.CANCELLED;
    }
}
