package com.ua.sdk.internal;

import android.os.Parcel;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.Resource;
import com.ua.sdk.cache.EntityDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class AbstractEntityList<T extends Resource> extends ApiTransferObject implements EntityList<T> {
    private transient ArrayList<T> mElements;

    @SerializedName("_embedded")
    Map<String, ArrayList<T>> mEmbedded;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    Integer mTotalCount;

    public int describeContents() {
        return 0;
    }

    protected abstract String getListKey();

    public boolean preparePartials(Reference reference) {
        return false;
    }

    public AbstractEntityList() {
    }

    @Override // com.ua.sdk.EntityList
    public int getSize() {
        return getElements().size();
    }

    @Override // com.ua.sdk.EntityList
    public T get(int i) {
        Precondition.isValidIndex(getElements(), i);
        return getElements().get(i);
    }

    public ArrayList<T> getElements() {
        if (this.mElements == null) {
            if (this.mEmbedded == null) {
                this.mEmbedded = new HashMap(1);
            }
            ArrayList<T> arrayList = this.mEmbedded.get(getListKey());
            this.mElements = arrayList;
            if (arrayList == null) {
                this.mElements = new ArrayList<>(0);
                this.mEmbedded.put(getListKey(), this.mElements);
            }
        }
        return this.mElements;
    }

    @Override // com.ua.sdk.EntityList
    public List<T> getAll() {
        return Collections.unmodifiableList(getElements());
    }

    @Override // com.ua.sdk.EntityList
    public boolean isEmpty() {
        return getElements() == null || getElements().size() == 0;
    }

    @Override // com.ua.sdk.EntityList
    public boolean hasPrevious() {
        return getLink("prev") != null;
    }

    @Override // com.ua.sdk.EntityList
    public boolean hasNext() {
        return getLink("next") != null;
    }

    @Override // com.ua.sdk.EntityList
    public int getTotalCount() {
        Integer num = this.mTotalCount;
        return num == null ? getSize() : num.intValue();
    }

    public void setTotalCount(int i) {
        this.mTotalCount = Integer.valueOf(i);
    }

    public void add(T t) {
        getElements().add(t);
    }

    @Override // com.ua.sdk.EntityList
    public T remove(int i) {
        Integer num;
        if (i < 0 || i >= getElements().size()) {
            return null;
        }
        T tRemove = getElements().remove(i);
        if (tRemove != null && (num = this.mTotalCount) != null) {
            this.mTotalCount = Integer.valueOf(num.intValue() - 1);
        }
        return tRemove;
    }

    @Override // com.ua.sdk.EntityList
    public EntityListRef<T> getPreviousPage() {
        Link link = getLink("prev");
        if (link == null) {
            return null;
        }
        return new LinkListRef(link.getHref());
    }

    @Override // com.ua.sdk.EntityList
    public EntityListRef<T> getNextPage() {
        Link link = getLink("next");
        if (link == null) {
            return null;
        }
        return new LinkListRef(link.getHref());
    }

    @Override // com.ua.sdk.Resource
    public EntityListRef<T> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkListRef(link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.mTotalCount);
        parcel.writeList(getElements());
    }

    protected AbstractEntityList(Parcel parcel) {
        super(parcel);
        this.mTotalCount = (Integer) parcel.readValue(Long.class.getClassLoader());
        ArrayList<T> arrayList = new ArrayList<>();
        this.mElements = arrayList;
        parcel.readList(arrayList, Resource.class.getClassLoader());
        HashMap map = new HashMap(1);
        this.mEmbedded = map;
        map.put(getListKey(), this.mElements);
    }

    @Override // com.ua.sdk.EntityList
    public void set(int i, T t) {
        getElements().set(i, t);
    }
}
