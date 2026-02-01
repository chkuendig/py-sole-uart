package com.android.tools.proguard;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ProguardMap {
    private static final String ARRAY_SYMBOL = "[]";
    private Map<String, ClassData> mClassesFromClearName = new HashMap();
    private Map<String, ClassData> mClassesFromObfuscatedName = new HashMap();

    private static class FrameData {
        public String clearMethodName;
        public int lineDelta;

        public FrameData(String clearMethodName, int lineDelta) {
            this.clearMethodName = clearMethodName;
            this.lineDelta = lineDelta;
        }
    }

    private static class ClassData {
        private String mClearName;
        private Map<String, String> mFields = new HashMap();
        private Map<String, FrameData> mFrames = new HashMap();

        public ClassData(String clearName) {
            this.mClearName = clearName;
        }

        public String getClearName() {
            return this.mClearName;
        }

        public void addField(String obfuscatedName, String clearName) {
            this.mFields.put(obfuscatedName, clearName);
        }

        public String getField(String obfuscatedName) {
            String str = this.mFields.get(obfuscatedName);
            return str == null ? obfuscatedName : str;
        }

        public void addFrame(String obfuscatedMethodName, String clearMethodName, String clearSignature, int obfuscatedLine, int clearLine) {
            this.mFrames.put(obfuscatedMethodName + clearSignature, new FrameData(clearMethodName, obfuscatedLine - clearLine));
        }

        public Frame getFrame(String clearClassName, String obfuscatedMethodName, String clearSignature, String obfuscatedFilename, int obfuscatedLine) {
            FrameData frameData = this.mFrames.get(obfuscatedMethodName + clearSignature);
            if (frameData == null) {
                frameData = new FrameData(obfuscatedMethodName, 0);
            }
            return new Frame(frameData.clearMethodName, clearSignature, ProguardMap.getFileName(clearClassName), obfuscatedLine - frameData.lineDelta);
        }
    }

    public static class Frame {
        public final String filename;
        public final int line;
        public final String methodName;
        public final String signature;

        public Frame(String methodName, String signature, String filename, int line) {
            this.methodName = methodName;
            this.signature = signature;
            this.filename = filename;
            this.line = line;
        }
    }

    private static void parseException(String msg) throws ParseException {
        throw new ParseException(msg, 0);
    }

    public void readFromFile(File mapFile) throws IOException, NumberFormatException, ParseException {
        readFromReader(new FileReader(mapFile));
    }

    public void readFromReader(Reader mapReader) throws IOException, NumberFormatException, ParseException {
        int i;
        int i2;
        BufferedReader bufferedReader = new BufferedReader(mapReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String strTrim = line.trim();
            if (strTrim.isEmpty() || strTrim.startsWith("#")) {
                line = bufferedReader.readLine();
            } else {
                int iIndexOf = line.indexOf(" -> ");
                int i3 = -1;
                if (iIndexOf == -1 || iIndexOf + 5 >= line.length()) {
                    parseException("Error parsing class line: '" + line + "'");
                }
                int i4 = 0;
                String strSubstring = line.substring(0, iIndexOf);
                String strSubstring2 = line.substring(iIndexOf + 4, line.length() - 1);
                ClassData classData = new ClassData(strSubstring);
                this.mClassesFromClearName.put(strSubstring, classData);
                this.mClassesFromObfuscatedName.put(strSubstring2, classData);
                line = bufferedReader.readLine();
                while (line != null) {
                    String strTrim2 = line.trim();
                    if (strTrim2.isEmpty() || strTrim2.startsWith("#")) {
                        line = bufferedReader.readLine();
                    } else {
                        if (!line.startsWith("    ")) {
                            break;
                        }
                        int iIndexOf2 = strTrim2.indexOf(32);
                        int iIndexOf3 = strTrim2.indexOf(" -> ");
                        if (iIndexOf2 == i3 || iIndexOf3 == i3) {
                            parseException("Error parse field/method line: '" + line + "'");
                        }
                        String strSubstring3 = strTrim2.substring(i4, iIndexOf2);
                        String strSubstring4 = strTrim2.substring(iIndexOf2 + 1, iIndexOf3);
                        String strSubstring5 = strTrim2.substring(iIndexOf3 + 4, strTrim2.length());
                        if (strSubstring4.indexOf(40) == i3) {
                            classData.addField(strSubstring5, strSubstring4);
                        } else {
                            int iIndexOf4 = strSubstring3.indexOf(58);
                            if (iIndexOf4 != i3) {
                                int i5 = Integer.parseInt(strSubstring3.substring(i4, iIndexOf4));
                                strSubstring3 = strSubstring3.substring(iIndexOf4 + 1);
                                i = i5;
                            } else {
                                i = i4;
                            }
                            int iIndexOf5 = strSubstring3.indexOf(58);
                            if (iIndexOf5 != i3) {
                                strSubstring3 = strSubstring3.substring(iIndexOf5 + 1);
                            }
                            int iIndexOf6 = strSubstring4.indexOf(40);
                            int iIndexOf7 = strSubstring4.indexOf(41);
                            if (iIndexOf6 == i3 || iIndexOf7 == i3) {
                                parseException("Error parse method line: '" + line + "'");
                            }
                            String strSubstring6 = strSubstring4.substring(iIndexOf6, iIndexOf7 + 1);
                            int iLastIndexOf = strSubstring4.lastIndexOf(58);
                            if (iLastIndexOf != -1) {
                                i2 = Integer.parseInt(strSubstring4.substring(iLastIndexOf + 1));
                                i4 = 0;
                                strSubstring4 = strSubstring4.substring(0, iLastIndexOf);
                            } else {
                                i4 = 0;
                                i2 = i;
                            }
                            int iLastIndexOf2 = strSubstring4.lastIndexOf(58);
                            if (iLastIndexOf2 != -1) {
                                i2 = Integer.parseInt(strSubstring4.substring(iLastIndexOf2 + 1));
                                strSubstring4 = strSubstring4.substring(i4, iLastIndexOf2);
                            }
                            i3 = -1;
                            classData.addFrame(strSubstring5, strSubstring4.substring(i4, iIndexOf6), fromProguardSignature(strSubstring6 + strSubstring3), i, i2);
                        }
                        line = bufferedReader.readLine();
                    }
                }
            }
        }
        bufferedReader.close();
    }

    public String getClassName(String obfuscatedClassName) {
        String str = "";
        while (obfuscatedClassName.endsWith("[]")) {
            str = str + "[]";
            obfuscatedClassName = obfuscatedClassName.substring(0, obfuscatedClassName.length() - "[]".length());
        }
        ClassData classData = this.mClassesFromObfuscatedName.get(obfuscatedClassName);
        if (classData != null) {
            obfuscatedClassName = classData.getClearName();
        }
        return obfuscatedClassName + str;
    }

    public String getFieldName(String clearClass, String obfuscatedField) {
        ClassData classData = this.mClassesFromClearName.get(clearClass);
        return classData == null ? obfuscatedField : classData.getField(obfuscatedField);
    }

    public Frame getFrame(String clearClassName, String obfuscatedMethodName, String obfuscatedSignature, String obfuscatedFilename, int obfuscatedLine) {
        String signature = getSignature(obfuscatedSignature);
        ClassData classData = this.mClassesFromClearName.get(clearClassName);
        if (classData == null) {
            return new Frame(obfuscatedMethodName, signature, obfuscatedFilename, obfuscatedLine);
        }
        return classData.getFrame(clearClassName, obfuscatedMethodName, signature, obfuscatedFilename, obfuscatedLine);
    }

    private static String fromProguardSignature(String sig) throws ParseException {
        if (sig.startsWith("(")) {
            int iIndexOf = sig.indexOf(41);
            if (iIndexOf == -1) {
                parseException("Error parsing signature: " + sig);
            }
            StringBuilder sb = new StringBuilder("(");
            if (iIndexOf > 1) {
                for (String str : sig.substring(1, iIndexOf).split(",")) {
                    sb.append(fromProguardSignature(str));
                }
            }
            sb.append(')');
            sb.append(fromProguardSignature(sig.substring(iIndexOf + 1)));
            return sb.toString();
        }
        if (sig.endsWith("[]")) {
            return "[" + fromProguardSignature(sig.substring(0, sig.length() - 2));
        }
        if (sig.equals(TypedValues.Custom.S_BOOLEAN)) {
            return "Z";
        }
        if (sig.equals("byte")) {
            return "B";
        }
        if (sig.equals("char")) {
            return "C";
        }
        if (sig.equals("short")) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (sig.equals("int")) {
            return "I";
        }
        if (sig.equals("long")) {
            return "J";
        }
        if (sig.equals(TypedValues.Custom.S_FLOAT)) {
            return "F";
        }
        if (sig.equals("double")) {
            return "D";
        }
        if (sig.equals("void")) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        return "L" + sig.replace('.', '/') + ";";
    }

    private String getSignature(String obfuscatedSig) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < obfuscatedSig.length()) {
            if (obfuscatedSig.charAt(i) == 'L') {
                int iIndexOf = obfuscatedSig.indexOf(59, i);
                sb.append('L');
                sb.append(getClassName(obfuscatedSig.substring(i + 1, iIndexOf).replace('/', '.')).replace('.', '/'));
                sb.append(';');
                i = iIndexOf;
            } else {
                sb.append(obfuscatedSig.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFileName(String clearClass) {
        int iLastIndexOf = clearClass.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            clearClass = clearClass.substring(iLastIndexOf + 1);
        }
        int iIndexOf = clearClass.indexOf(36);
        if (iIndexOf != -1) {
            clearClass = clearClass.substring(0, iIndexOf);
        }
        return clearClass + SdkConstants.DOT_JAVA;
    }
}
