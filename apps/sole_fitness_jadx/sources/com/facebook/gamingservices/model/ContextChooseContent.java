package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ContextChooseContent implements ShareModel {
    private final List<String> filters;
    private final Integer maxSize;
    private final Integer minSize;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private ContextChooseContent(Builder builder) {
        this.filters = builder.filters;
        this.maxSize = builder.maxSize;
        this.minSize = builder.minSize;
    }

    ContextChooseContent(Parcel parcel) {
        this.filters = parcel.createStringArrayList();
        this.maxSize = Integer.valueOf(parcel.readInt());
        this.minSize = Integer.valueOf(parcel.readInt());
    }

    public List<String> getFilters() {
        List<String> list = this.filters;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return null;
    }

    public Integer getMaxSize() {
        return this.maxSize;
    }

    public Integer getMinSize() {
        return this.minSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.filters);
        parcel.writeInt(this.maxSize.intValue());
        parcel.writeInt(this.minSize.intValue());
    }

    public static class Builder implements ShareModelBuilder<ContextChooseContent, Builder> {
        private List<String> filters;
        private Integer maxSize;
        private Integer minSize;

        public Builder setFilters(List<String> list) {
            this.filters = list;
            return this;
        }

        public Builder setMaxSize(Integer num) {
            this.maxSize = num;
            return this;
        }

        public Builder setMinSize(Integer num) {
            this.minSize = num;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ContextChooseContent build() {
            return new ContextChooseContent(this);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ContextChooseContent contextChooseContent) {
            return contextChooseContent == null ? this : setFilters(contextChooseContent.getFilters()).setMaxSize(contextChooseContent.getMaxSize()).setMinSize(contextChooseContent.getMinSize());
        }

        Builder readFrom(Parcel parcel) {
            return readFrom((ContextChooseContent) parcel.readParcelable(ContextChooseContent.class.getClassLoader()));
        }
    }
}
