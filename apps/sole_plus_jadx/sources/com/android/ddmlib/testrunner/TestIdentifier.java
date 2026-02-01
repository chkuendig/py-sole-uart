package com.android.ddmlib.testrunner;

/* loaded from: classes3.dex */
public class TestIdentifier {
    private final String mClassName;
    private final int mTestIndex;
    private final String mTestName;

    public TestIdentifier(String className, String testName) {
        this(className, testName, -1);
    }

    public TestIdentifier(String className, String testName, int testIndex) {
        if (className == null || testName == null) {
            throw new IllegalArgumentException("className and testName must be non-null");
        }
        this.mClassName = className;
        this.mTestName = testName;
        this.mTestIndex = testIndex;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public String getTestName() {
        return this.mTestName;
    }

    public int getTestIndex() {
        return this.mTestIndex;
    }

    public int hashCode() {
        String str = this.mClassName;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.mTestName;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mTestIndex;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestIdentifier testIdentifier = (TestIdentifier) obj;
        String str = this.mClassName;
        if (str == null) {
            if (testIdentifier.mClassName != null) {
                return false;
            }
        } else if (!str.equals(testIdentifier.mClassName)) {
            return false;
        }
        String str2 = this.mTestName;
        if (str2 == null) {
            if (testIdentifier.mTestName != null) {
                return false;
            }
        } else if (!str2.equals(testIdentifier.mTestName)) {
            return false;
        }
        return this.mTestIndex == testIdentifier.mTestIndex;
    }

    public String toString() {
        return String.format("%s#%s", getClassName(), getTestName());
    }
}
