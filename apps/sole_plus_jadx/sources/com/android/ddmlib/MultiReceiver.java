package com.android.ddmlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public class MultiReceiver implements IShellOutputReceiver {
    private final ArrayList<IShellOutputReceiver> myReceivers;

    public MultiReceiver(IShellOutputReceiver... receivers) {
        this.myReceivers = new ArrayList<>(Arrays.asList(receivers));
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void addOutput(byte[] data, int offset, int length) {
        updateReceiverList();
        Iterator<IShellOutputReceiver> it = this.myReceivers.iterator();
        while (it.hasNext()) {
            it.next().addOutput(data, offset, length);
        }
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public void flush() {
        updateReceiverList();
        Iterator<IShellOutputReceiver> it = this.myReceivers.iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
        this.myReceivers.clear();
    }

    @Override // com.android.ddmlib.IShellOutputReceiver
    public boolean isCancelled() {
        updateReceiverList();
        return this.myReceivers.isEmpty();
    }

    private void updateReceiverList() {
        this.myReceivers.removeIf(new Predicate() { // from class: com.android.ddmlib.MultiReceiver$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((IShellOutputReceiver) obj).isCancelled();
            }
        });
    }
}
