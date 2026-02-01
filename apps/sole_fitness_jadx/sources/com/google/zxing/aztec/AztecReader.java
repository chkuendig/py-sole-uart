package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class AztecReader implements Reader {
    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e A[LOOP:0: B:33:0x005c->B:34:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    @Override // com.google.zxing.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] points;
        ResultPoint[] points2;
        FormatException formatException;
        ResultPoint[] resultPointArr;
        List<byte[]> byteSegments;
        String eCLevel;
        ResultPointCallback resultPointCallback;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        DecoderResult decoderResultDecode = null;
        try {
            AztecDetectorResult aztecDetectorResultDetect = detector.detect(false);
            points = aztecDetectorResultDetect.getPoints();
            try {
                points2 = points;
                formatException = null;
                decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect);
                e = null;
            } catch (FormatException e) {
                e = e;
                points2 = points;
                formatException = e;
                e = null;
                if (decoderResultDecode == null) {
                }
                resultPointArr = points2;
                if (map != null) {
                    while (i < r0) {
                    }
                }
                Result result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), decoderResultDecode.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResultDecode.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResultDecode.getECLevel();
                if (eCLevel != null) {
                }
                return result;
            } catch (NotFoundException e2) {
                e = e2;
                points2 = points;
                formatException = null;
                if (decoderResultDecode == null) {
                }
                resultPointArr = points2;
                if (map != null) {
                }
                Result result2 = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), decoderResultDecode.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResultDecode.getByteSegments();
                if (byteSegments != null) {
                }
                eCLevel = decoderResultDecode.getECLevel();
                if (eCLevel != null) {
                }
                return result2;
            }
        } catch (FormatException e3) {
            e = e3;
            points = null;
        } catch (NotFoundException e4) {
            e = e4;
            points = null;
        }
        if (decoderResultDecode == null) {
            try {
                AztecDetectorResult aztecDetectorResultDetect2 = detector.detect(true);
                points2 = aztecDetectorResultDetect2.getPoints();
                decoderResultDecode = new Decoder().decode(aztecDetectorResultDetect2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        resultPointArr = points2;
        if (map != null && (resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (ResultPoint resultPoint : resultPointArr) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        Result result22 = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), decoderResultDecode.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result22.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result22.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result22;
    }
}
