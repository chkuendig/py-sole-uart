package com.sun.jna.platform.win32.COM;

import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import java.util.Date;

/* loaded from: classes4.dex */
public class COMLateBindingObject extends COMBindingBaseObject {
    public COMLateBindingObject(IDispatch iDispatch) {
        super(iDispatch);
    }

    public COMLateBindingObject(Guid.CLSID clsid, boolean z) {
        super(clsid, z);
    }

    public COMLateBindingObject(String str, boolean z) throws COMException {
        super(str, z);
    }

    protected IDispatch getAutomationProperty(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return (IDispatch) byReference.getValue();
    }

    protected IDispatch getAutomationProperty(String str, Variant.VARIANT variant) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str, variant);
        return (IDispatch) byReference.getValue();
    }

    @Deprecated
    protected IDispatch getAutomationProperty(String str, COMLateBindingObject cOMLateBindingObject) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return (IDispatch) byReference.getValue();
    }

    @Deprecated
    protected IDispatch getAutomationProperty(String str, COMLateBindingObject cOMLateBindingObject, Variant.VARIANT variant) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str, variant);
        return (IDispatch) byReference.getValue();
    }

    @Deprecated
    protected IDispatch getAutomationProperty(String str, IDispatch iDispatch) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return (IDispatch) byReference.getValue();
    }

    protected boolean getBooleanProperty(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return byReference.booleanValue();
    }

    protected Date getDateProperty(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return byReference.dateValue();
    }

    protected int getIntProperty(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return byReference.intValue();
    }

    protected short getShortProperty(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        return byReference.shortValue();
    }

    protected String getStringProperty(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(2, byReference, str);
        String strStringValue = byReference.stringValue();
        OleAuto.INSTANCE.VariantClear(byReference);
        return strStringValue;
    }

    protected Variant.VARIANT invoke(String str) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(1, byReference, str);
        return byReference;
    }

    protected Variant.VARIANT invoke(String str, Variant.VARIANT variant) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(1, byReference, str, variant);
        return byReference;
    }

    protected Variant.VARIANT invoke(String str, Variant.VARIANT[] variantArr) {
        Variant.VARIANT.ByReference byReference = new Variant.VARIANT.ByReference();
        oleMethod(1, byReference, str, variantArr);
        return byReference;
    }

    protected Variant.VARIANT invoke(String str, Variant.VARIANT variant, Variant.VARIANT variant2) {
        return invoke(str, new Variant.VARIANT[]{variant, variant2});
    }

    protected Variant.VARIANT invoke(String str, Variant.VARIANT variant, Variant.VARIANT variant2, Variant.VARIANT variant3) {
        return invoke(str, new Variant.VARIANT[]{variant, variant2, variant3});
    }

    protected Variant.VARIANT invoke(String str, Variant.VARIANT variant, Variant.VARIANT variant2, Variant.VARIANT variant3, Variant.VARIANT variant4) {
        return invoke(str, new Variant.VARIANT[]{variant, variant2, variant3, variant4});
    }

    @Deprecated
    protected void invokeNoReply(String str, IDispatch iDispatch) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, iDispatch, str);
    }

    @Deprecated
    protected void invokeNoReply(String str, COMLateBindingObject cOMLateBindingObject) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, cOMLateBindingObject.getIDispatch(), str);
    }

    protected void invokeNoReply(String str, Variant.VARIANT variant) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, str, variant);
    }

    @Deprecated
    protected void invokeNoReply(String str, IDispatch iDispatch, Variant.VARIANT variant) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, iDispatch, str, variant);
    }

    @Deprecated
    protected void invokeNoReply(String str, IDispatch iDispatch, Variant.VARIANT variant, Variant.VARIANT variant2) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, iDispatch, str, new Variant.VARIANT[]{variant, variant2});
    }

    @Deprecated
    protected void invokeNoReply(String str, COMLateBindingObject cOMLateBindingObject, Variant.VARIANT variant, Variant.VARIANT variant2) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, cOMLateBindingObject.getIDispatch(), str, new Variant.VARIANT[]{variant, variant2});
    }

    protected void invokeNoReply(String str, COMLateBindingObject cOMLateBindingObject, Variant.VARIANT variant) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, cOMLateBindingObject.getIDispatch(), str, variant);
    }

    @Deprecated
    protected void invokeNoReply(String str, IDispatch iDispatch, Variant.VARIANT[] variantArr) {
        oleMethod(1, (Variant.VARIANT.ByReference) null, iDispatch, str, variantArr);
    }

    protected void invokeNoReply(String str) {
        oleMethod(1, new Variant.VARIANT.ByReference(), str);
    }

    protected void invokeNoReply(String str, Variant.VARIANT[] variantArr) {
        oleMethod(1, new Variant.VARIANT.ByReference(), str, variantArr);
    }

    protected void invokeNoReply(String str, Variant.VARIANT variant, Variant.VARIANT variant2) {
        invokeNoReply(str, new Variant.VARIANT[]{variant, variant2});
    }

    protected void invokeNoReply(String str, Variant.VARIANT variant, Variant.VARIANT variant2, Variant.VARIANT variant3) {
        invokeNoReply(str, new Variant.VARIANT[]{variant, variant2, variant3});
    }

    protected void invokeNoReply(String str, Variant.VARIANT variant, Variant.VARIANT variant2, Variant.VARIANT variant3, Variant.VARIANT variant4) {
        invokeNoReply(str, new Variant.VARIANT[]{variant, variant2, variant3, variant4});
    }

    protected void setProperty(String str, boolean z) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(z));
    }

    protected void setProperty(String str, Date date) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(date));
    }

    protected void setProperty(String str, Dispatch dispatch) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(dispatch));
    }

    @Deprecated
    protected void setProperty(String str, IDispatch iDispatch) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(iDispatch));
    }

    protected void setProperty(String str, int i) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(i));
    }

    protected void setProperty(String str, short s) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(s));
    }

    protected void setProperty(String str, String str2) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, new Variant.VARIANT(str2));
    }

    protected void setProperty(String str, Variant.VARIANT variant) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, str, variant);
    }

    @Deprecated
    protected void setProperty(String str, IDispatch iDispatch, Variant.VARIANT variant) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, iDispatch, str, variant);
    }

    @Deprecated
    protected void setProperty(String str, COMLateBindingObject cOMLateBindingObject, Variant.VARIANT variant) {
        oleMethod(4, (Variant.VARIANT.ByReference) null, cOMLateBindingObject.getIDispatch(), str, variant);
    }

    public Variant.VARIANT toVariant() {
        return new Variant.VARIANT(getIDispatch());
    }
}
