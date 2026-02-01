package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: classes4.dex */
public class AdaptationSet {
    public static final long ID_UNSET = -1;
    public final List<Descriptor> accessibilityDescriptors;
    public final List<Descriptor> essentialProperties;

    /* renamed from: id, reason: collision with root package name */
    public final long f171id;
    public final List<Representation> representations;
    public final List<Descriptor> supplementalProperties;
    public final int type;

    public AdaptationSet(long j, int i, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        this.f171id = j;
        this.type = i;
        this.representations = Collections.unmodifiableList(list);
        this.accessibilityDescriptors = Collections.unmodifiableList(list2);
        this.essentialProperties = Collections.unmodifiableList(list3);
        this.supplementalProperties = Collections.unmodifiableList(list4);
    }
}
