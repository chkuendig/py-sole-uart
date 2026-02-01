package com.github.gzuliyujiang.wheelpicker.impl;

import androidx.exifinterface.media.ExifInterface;
import com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class CarPlateProvider implements LinkageProvider {
    private static final String[] ABBREVIATIONS = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public int findThirdIndex(int i, int i2, Object obj) {
        return 0;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public boolean firstLevelVisible() {
        return true;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public boolean thirdLevelVisible() {
        return false;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public List<String> provideFirstData() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, ABBREVIATIONS);
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> linkageSecondData(int i) {
        ArrayList arrayList = new ArrayList();
        char c = 0;
        int i2 = i;
        if (i2 == -1) {
            i2 = 0;
        }
        String str = provideFirstData().get(i2);
        str.hashCode();
        switch (str.hashCode()) {
            case 20113:
                if (!str.equals("云")) {
                    c = 65535;
                    break;
                }
                break;
            case 20140:
                if (str.equals("京")) {
                    c = 1;
                    break;
                }
                break;
            case 20864:
                if (str.equals("冀")) {
                    c = 2;
                    break;
                }
                break;
            case 21513:
                if (str.equals("吉")) {
                    c = 3;
                    break;
                }
                break;
            case 23425:
                if (str.equals("宁")) {
                    c = 4;
                    break;
                }
                break;
            case 24029:
                if (str.equals("川")) {
                    c = 5;
                    break;
                }
                break;
            case 26032:
                if (str.equals("新")) {
                    c = 6;
                    break;
                }
                break;
            case 26187:
                if (str.equals("晋")) {
                    c = 7;
                    break;
                }
                break;
            case 26690:
                if (str.equals("桂")) {
                    c = '\b';
                    break;
                }
                break;
            case 27818:
                if (str.equals("沪")) {
                    c = '\t';
                    break;
                }
                break;
            case 27941:
                if (str.equals("津")) {
                    c = '\n';
                    break;
                }
                break;
            case 27993:
                if (str.equals("浙")) {
                    c = 11;
                    break;
                }
                break;
            case 28189:
                if (str.equals("渝")) {
                    c = '\f';
                    break;
                }
                break;
            case 28248:
                if (str.equals("湘")) {
                    c = '\r';
                    break;
                }
                break;
            case 29756:
                if (str.equals("琼")) {
                    c = 14;
                    break;
                }
                break;
            case 29976:
                if (str.equals("甘")) {
                    c = 15;
                    break;
                }
                break;
            case 30358:
                if (str.equals("皖")) {
                    c = 16;
                    break;
                }
                break;
            case 31908:
                if (str.equals("粤")) {
                    c = 17;
                    break;
                }
                break;
            case 33487:
                if (str.equals("苏")) {
                    c = 18;
                    break;
                }
                break;
            case 33945:
                if (str.equals("蒙")) {
                    c = 19;
                    break;
                }
                break;
            case 34255:
                if (str.equals("藏")) {
                    c = 20;
                    break;
                }
                break;
            case 35947:
                if (str.equals("豫")) {
                    c = 21;
                    break;
                }
                break;
            case 36149:
                if (str.equals("贵")) {
                    c = 22;
                    break;
                }
                break;
            case 36195:
                if (str.equals("赣")) {
                    c = 23;
                    break;
                }
                break;
            case 36797:
                if (str.equals("辽")) {
                    c = 24;
                    break;
                }
                break;
            case 37122:
                if (str.equals("鄂")) {
                    c = 25;
                    break;
                }
                break;
            case 38397:
                if (str.equals("闽")) {
                    c = 26;
                    break;
                }
                break;
            case 38485:
                if (str.equals("陕")) {
                    c = 27;
                    break;
                }
                break;
            case 38738:
                if (str.equals("青")) {
                    c = 28;
                    break;
                }
                break;
            case 40065:
                if (str.equals("鲁")) {
                    c = 29;
                    break;
                }
                break;
            case 40657:
                if (str.equals("黑")) {
                    c = 30;
                    break;
                }
                break;
        }
        char c2 = 'A';
        switch (c) {
            case 0:
                arrayList.add("A-V");
                while (c2 <= 'S') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("B");
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 1:
                while (c2 <= 'M') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.add("Y");
                return arrayList;
            case 2:
                while (c2 <= 'H') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.add("J");
                arrayList.add("R");
                arrayList.add(ExifInterface.LATITUDE_SOUTH);
                arrayList.add(ExifInterface.GPS_DIRECTION_TRUE);
                return arrayList;
            case 3:
            case 26:
                while (c2 <= 'K') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                return arrayList;
            case 4:
            case 14:
                while (c2 <= 'E') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                return arrayList;
            case 5:
                while (c2 <= 'Z') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("G");
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 6:
            case 30:
                while (c2 <= 'R') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 7:
                while (c2 <= 'M') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("G");
                arrayList.remove("I");
                return arrayList;
            case '\b':
                while (c2 <= 'P') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("R");
                return arrayList;
            case '\t':
                while (c2 <= 'D') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.add("R");
                return arrayList;
            case '\n':
            case 28:
                while (c2 <= 'H') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                return arrayList;
            case 11:
                while (c2 <= 'L') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                return arrayList;
            case '\f':
                while (c2 <= 'D') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("D");
                arrayList.remove(ExifInterface.LONGITUDE_EAST);
                return arrayList;
            case '\r':
                while (c2 <= 'N') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("U");
                return arrayList;
            case 15:
            case 24:
                while (c2 <= 'P') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 16:
            case 25:
                while (c2 <= 'S') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 17:
                while (c2 <= 'Z') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 18:
                while (c2 <= 'N') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                return arrayList;
            case 19:
            case 23:
                while (c2 <= 'M') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                return arrayList;
            case 20:
            case 22:
                while (c2 <= 'J') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                return arrayList;
            case 21:
                while (c2 <= 'U') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                return arrayList;
            case 27:
                while (c2 <= 'K') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.add(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                return arrayList;
            case 29:
                while (c2 <= 'V') {
                    arrayList.add(String.valueOf(c2));
                    c2 = (char) (c2 + 1);
                }
                arrayList.remove("I");
                arrayList.remove("O");
                arrayList.add("Y");
                return arrayList;
            default:
                return arrayList;
        }
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public List<?> linkageThirdData(int i, int i2) {
        return new ArrayList();
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public int findFirstIndex(Object obj) {
        if (obj == null) {
            return -1;
        }
        int length = ABBREVIATIONS.length;
        for (int i = 0; i < length; i++) {
            if (ABBREVIATIONS[i].equals(obj.toString())) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.contract.LinkageProvider
    public int findSecondIndex(int i, Object obj) {
        if (obj == null) {
            return -1;
        }
        List<String> listLinkageSecondData = linkageSecondData(i);
        int size = listLinkageSecondData.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (listLinkageSecondData.get(i2).equals(obj.toString())) {
                return i2;
            }
        }
        return -1;
    }
}
