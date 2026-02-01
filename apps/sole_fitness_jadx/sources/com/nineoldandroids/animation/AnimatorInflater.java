package com.nineoldandroids.animation;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class AnimatorInflater {
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int[] AnimatorSet = {R.attr.ordering};
    private static final int[] PropertyAnimator = {R.attr.propertyName};
    private static final int[] Animator = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};

    public static Animator loadAnimator(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                animation = context.getResources().getAnimation(i);
                return createAnimatorFromXml(context, animation);
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (animation != null) {
                animation.close();
            }
        }
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        if (r12 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        if (r2 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
    
        r9 = new com.nineoldandroids.animation.Animator[r2.size()];
        r10 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a0, code lost:
    
        if (r10.hasNext() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
    
        r9[r6] = (com.nineoldandroids.animation.Animator) r10.next();
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        if (r13 != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
    
        r12.playTogether(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b4, code lost:
    
        r12.playSequentially(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b7, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        Animator animatorLoadAnimator = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorLoadAnimator = loadObjectAnimator(context, attributeSet);
                } else if (name.equals("animator")) {
                    animatorLoadAnimator = loadAnimator(context, attributeSet, null);
                } else if (name.equals("set")) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                    TypedValue typedValue = new TypedValue();
                    typedArrayObtainStyledAttributes.getValue(0, typedValue);
                    createAnimatorFromXml(context, xmlPullParser, attributeSet, animatorSet2, typedValue.type == 16 ? typedValue.data : 0);
                    typedArrayObtainStyledAttributes.recycle();
                    animatorLoadAnimator = animatorSet2;
                } else {
                    throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                }
                if (animatorSet != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(animatorLoadAnimator);
                }
            }
        }
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
        return objectAnimator;
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        int i;
        int color;
        int color2;
        int color3;
        float dimension;
        float dimension2;
        float dimension3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Animator);
        long j = typedArrayObtainStyledAttributes.getInt(1, 0);
        long j2 = typedArrayObtainStyledAttributes.getInt(2, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        boolean z = i2 == 0;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(5);
        boolean z2 = typedValuePeekValue != null;
        int i3 = z2 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
        boolean z3 = typedValuePeekValue2 != null;
        int i4 = z3 ? typedValuePeekValue2.type : 0;
        if ((z2 && i3 >= 28 && i3 <= 31) || (z3 && i4 >= 28 && i4 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            z = false;
        }
        if (!z) {
            i = 0;
            if (z2) {
                if (i3 == 5) {
                    color2 = (int) typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
                } else if (i3 >= 28 && i3 <= 31) {
                    color2 = typedArrayObtainStyledAttributes.getColor(5, 0);
                } else {
                    color2 = typedArrayObtainStyledAttributes.getInt(5, 0);
                }
                if (z3) {
                    if (i4 == 5) {
                        color3 = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i4 >= 28 && i4 <= 31) {
                        color3 = typedArrayObtainStyledAttributes.getColor(6, 0);
                    } else {
                        color3 = typedArrayObtainStyledAttributes.getInt(6, 0);
                    }
                    valueAnimator2.setIntValues(color2, color3);
                } else {
                    valueAnimator2.setIntValues(color2);
                }
            } else if (z3) {
                if (i4 == 5) {
                    color = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i4 >= 28 && i4 <= 31) {
                    color = typedArrayObtainStyledAttributes.getColor(6, 0);
                } else {
                    color = typedArrayObtainStyledAttributes.getInt(6, 0);
                }
                valueAnimator2.setIntValues(color);
            }
        } else if (z2) {
            if (i3 == 5) {
                dimension2 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
            } else {
                dimension2 = typedArrayObtainStyledAttributes.getFloat(5, 0.0f);
            }
            if (z3) {
                if (i4 == 5) {
                    dimension3 = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    dimension3 = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
                }
                i = 0;
                valueAnimator2.setFloatValues(dimension2, dimension3);
            } else {
                i = 0;
                valueAnimator2.setFloatValues(dimension2);
            }
        } else {
            i = 0;
            if (i4 == 5) {
                dimension = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
            } else {
                dimension = typedArrayObtainStyledAttributes.getFloat(6, 0.0f);
            }
            valueAnimator2.setFloatValues(dimension);
        }
        valueAnimator2.setDuration(j);
        valueAnimator2.setStartDelay(j2);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(typedArrayObtainStyledAttributes.getInt(3, i));
        }
        if (typedArrayObtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(typedArrayObtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(i, i);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        typedArrayObtainStyledAttributes.recycle();
        return valueAnimator2;
    }
}
