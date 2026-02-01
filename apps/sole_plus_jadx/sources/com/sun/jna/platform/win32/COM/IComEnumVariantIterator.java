package com.sun.jna.platform.win32.COM;

import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.ptr.PointerByReference;
import java.io.Closeable;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class IComEnumVariantIterator implements Iterable<Variant.VARIANT>, Iterator<Variant.VARIANT>, Closeable {
    private EnumVariant backingIteration;
    private Variant.VARIANT nextValue;

    @Override // java.lang.Iterable
    public Iterator<Variant.VARIANT> iterator() {
        return this;
    }

    public static IComEnumVariantIterator wrap(com.sun.jna.platform.win32.COM.util.IDispatch iDispatch) {
        PointerByReference pointerByReference = new PointerByReference();
        IUnknown iUnknown = (IUnknown) iDispatch.getProperty(IUnknown.class, OaIdl.DISPID_NEWENUM, new Object[0]);
        iUnknown.QueryInterface(EnumVariant.REFIID, pointerByReference);
        iUnknown.Release();
        return new IComEnumVariantIterator(new EnumVariant(pointerByReference.getValue()));
    }

    public IComEnumVariantIterator(EnumVariant enumVariant) {
        this.backingIteration = enumVariant;
        retrieveNext();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextValue != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Variant.VARIANT next() {
        Variant.VARIANT variant = this.nextValue;
        retrieveNext();
        return variant;
    }

    private void retrieveNext() {
        EnumVariant enumVariant = this.backingIteration;
        if (enumVariant == null) {
            return;
        }
        Variant.VARIANT[] variantArrNext = enumVariant.Next(1);
        if (variantArrNext.length == 0) {
            close();
        } else {
            this.nextValue = variantArrNext[0];
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        EnumVariant enumVariant = this.backingIteration;
        if (enumVariant != null) {
            this.nextValue = null;
            enumVariant.Release();
            this.backingIteration = null;
        }
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
