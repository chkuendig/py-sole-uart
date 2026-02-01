package com.android.ddmlib.logcat;

import com.android.ddmlib.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes3.dex */
public final class LogCatFilter {
    private static final String APP_KEYWORD = "app:";
    private static final String PID_KEYWORD = "pid:";
    private static final String TAG_KEYWORD = "tag:";
    private static final String TEXT_KEYWORD = "text:";
    private final String mAppName;
    private Pattern mAppNamePattern;
    private boolean mCheckAppName;
    private boolean mCheckPid;
    private boolean mCheckTag;
    private boolean mCheckText;
    private final Log.LogLevel mLogLevel;
    private final String mName;
    private final String mPid;
    private final String mTag;
    private Pattern mTagPattern;
    private final String mText;
    private Pattern mTextPattern;

    public LogCatFilter(String name, String tag, String text, String pid, String appName, Log.LogLevel logLevel) {
        this.mName = name.trim();
        this.mTag = tag.trim();
        this.mText = text.trim();
        this.mPid = pid.trim();
        String strTrim = appName.trim();
        this.mAppName = strTrim;
        this.mLogLevel = logLevel;
        this.mCheckPid = !r1.isEmpty();
        if (!strTrim.isEmpty()) {
            try {
                this.mAppNamePattern = Pattern.compile(strTrim, getPatternCompileFlags(strTrim));
                this.mCheckAppName = true;
            } catch (PatternSyntaxException unused) {
                this.mCheckAppName = false;
            }
        }
        if (!this.mTag.isEmpty()) {
            try {
                String str = this.mTag;
                this.mTagPattern = Pattern.compile(str, getPatternCompileFlags(str));
                this.mCheckTag = true;
            } catch (PatternSyntaxException unused2) {
                this.mCheckTag = false;
            }
        }
        if (this.mText.isEmpty()) {
            return;
        }
        try {
            String str2 = this.mText;
            this.mTextPattern = Pattern.compile(str2, getPatternCompileFlags(str2));
            this.mCheckText = true;
        } catch (PatternSyntaxException unused3) {
            this.mCheckText = false;
        }
    }

    private int getPatternCompileFlags(String regex) {
        for (char c : regex.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return 0;
            }
        }
        return 2;
    }

    public static List<LogCatFilter> fromString(String query, Log.LogLevel minLevel) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        String strSubstring4;
        ArrayList arrayList = new ArrayList();
        for (String str : query.trim().split(" ")) {
            if (str.startsWith(PID_KEYWORD)) {
                strSubstring3 = str.substring(PID_KEYWORD.length());
                strSubstring2 = "";
                strSubstring = strSubstring2;
                strSubstring4 = strSubstring;
            } else if (str.startsWith("app:")) {
                strSubstring4 = str.substring("app:".length());
                strSubstring2 = "";
                strSubstring = strSubstring2;
                strSubstring3 = strSubstring;
            } else {
                if (str.startsWith(TAG_KEYWORD)) {
                    strSubstring2 = str.substring(TAG_KEYWORD.length());
                    strSubstring = "";
                    strSubstring3 = strSubstring;
                } else {
                    strSubstring = str.startsWith(TEXT_KEYWORD) ? str.substring(TEXT_KEYWORD.length()) : str;
                    strSubstring2 = "";
                    strSubstring3 = strSubstring2;
                }
                strSubstring4 = strSubstring3;
            }
            arrayList.add(new LogCatFilter("livefilter-" + str, strSubstring2, strSubstring, strSubstring3, strSubstring4, minLevel));
        }
        return arrayList;
    }

    public String getName() {
        return this.mName;
    }

    public String getTag() {
        return this.mTag;
    }

    public String getText() {
        return this.mText;
    }

    public String getPid() {
        return this.mPid;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public Log.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    public boolean matches(LogCatMessage message) {
        LogCatHeader header = message.getHeader();
        if (header.getLogLevel().getPriority() < this.mLogLevel.getPriority()) {
            return false;
        }
        if (this.mCheckPid && !Integer.toString(header.getPid()).equals(this.mPid)) {
            return false;
        }
        if (this.mCheckAppName && !this.mAppNamePattern.matcher(header.getAppName()).find()) {
            return false;
        }
        if (!this.mCheckTag || this.mTagPattern.matcher(header.getTag()).find()) {
            return !this.mCheckText || this.mTextPattern.matcher(message.getMessage()).find();
        }
        return false;
    }
}
