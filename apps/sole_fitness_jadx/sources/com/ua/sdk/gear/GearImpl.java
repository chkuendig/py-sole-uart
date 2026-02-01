package com.ua.sdk.gear;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dyaco.sole.database.UserData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class GearImpl extends ApiTransferObject implements Gear {
    public static final Parcelable.Creator<GearImpl> CREATOR = new Parcelable.Creator<GearImpl>() { // from class: com.ua.sdk.gear.GearImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearImpl createFromParcel(Parcel parcel) {
            return new GearImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GearImpl[] newArray(int i) {
            return new GearImpl[i];
        }
    };
    public static final String REF_SELF = "self";

    @SerializedName("age_group")
    String ageGroup;

    @SerializedName("available")
    Boolean available;

    @SerializedName("brand")
    String brand;

    @SerializedName("category")
    String category;

    @SerializedName(TypedValues.Custom.S_COLOR)
    String color;

    @SerializedName("department")
    String department;

    @SerializedName("description")
    String description;

    @SerializedName("detail_photo_url")
    String detailPhotoUrl;

    @SerializedName(UserData.GENDER)
    String gender;

    @SerializedName("keywords")
    String keywords;

    @SerializedName("mid_level_product_type")
    String midLevelProductType;

    @SerializedName("model")
    String model;

    @SerializedName("msrp")
    String msrp;

    @SerializedName("photo_url")
    String photoUrl;

    @SerializedName(FirebaseAnalytics.Param.PRICE)
    String price;

    @SerializedName("product_type")
    String productType;

    @SerializedName("product_url")
    String productUrl;

    @SerializedName("purchase_url")
    String purchaseUrl;

    @SerializedName("size")
    String size;

    @SerializedName("sku")
    String sku;

    @SerializedName("source")
    String source;

    @SerializedName("styleid")
    String styleId;

    @SerializedName("style_number")
    String styleNumber;

    @SerializedName("thumbnail_url")
    String thumbnailUrl;

    @SerializedName("upc")
    Long upc;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GearImpl() {
    }

    @Override // com.ua.sdk.gear.Gear
    public String getStyleNumber() {
        return this.styleNumber;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getColor() {
        return this.color;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getProductUrl() {
        return this.productUrl;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getKeywords() {
        return this.keywords;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getAgeGroup() {
        return this.ageGroup;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getSize() {
        return this.size;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getSku() {
        return this.sku;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getSource() {
        return this.source;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getDepartment() {
        return this.department;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getBrand() {
        return this.brand;
    }

    @Override // com.ua.sdk.gear.Gear
    public Boolean getAvailable() {
        return this.available;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getCategory() {
        return this.category;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getDescription() {
        return this.description;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getPrice() {
        return this.price;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getPurchaseUrl() {
        return this.purchaseUrl;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getMidLevelProductType() {
        return this.midLevelProductType;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getPhotoUrl() {
        return this.photoUrl;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getDetailPhotoUrl() {
        return this.detailPhotoUrl;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getProductType() {
        return this.productType;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getGender() {
        return this.gender;
    }

    @Override // com.ua.sdk.gear.Gear
    public Long getUpc() {
        return this.upc;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getStyleId() {
        return this.styleId;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getModel() {
        return this.model;
    }

    @Override // com.ua.sdk.gear.Gear
    public String getMsrp() {
        return this.msrp;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.styleNumber);
        parcel.writeString(this.color);
        parcel.writeString(this.productUrl);
        parcel.writeString(this.keywords);
        parcel.writeString(this.ageGroup);
        parcel.writeString(this.size);
        parcel.writeString(this.sku);
        parcel.writeString(this.source);
        parcel.writeString(this.department);
        parcel.writeString(this.brand);
        parcel.writeValue(this.available);
        parcel.writeString(this.category);
        parcel.writeString(this.description);
        parcel.writeString(this.price);
        parcel.writeString(this.purchaseUrl);
        parcel.writeString(this.midLevelProductType);
        parcel.writeString(this.photoUrl);
        parcel.writeString(this.detailPhotoUrl);
        parcel.writeString(this.productType);
        parcel.writeString(this.gender);
        parcel.writeValue(this.upc);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeString(this.styleId);
        parcel.writeString(this.model);
        parcel.writeString(this.msrp);
    }

    private GearImpl(Parcel parcel) {
        super(parcel);
        this.styleNumber = parcel.readString();
        this.color = parcel.readString();
        this.productUrl = parcel.readString();
        this.keywords = parcel.readString();
        this.ageGroup = parcel.readString();
        this.size = parcel.readString();
        this.sku = parcel.readString();
        this.source = parcel.readString();
        this.department = parcel.readString();
        this.brand = parcel.readString();
        this.available = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.category = parcel.readString();
        this.description = parcel.readString();
        this.price = parcel.readString();
        this.purchaseUrl = parcel.readString();
        this.midLevelProductType = parcel.readString();
        this.photoUrl = parcel.readString();
        this.detailPhotoUrl = parcel.readString();
        this.productType = parcel.readString();
        this.gender = parcel.readString();
        this.upc = (Long) parcel.readValue(Long.class.getClassLoader());
        this.thumbnailUrl = parcel.readString();
        this.styleId = parcel.readString();
        this.model = parcel.readString();
        this.msrp = parcel.readString();
    }
}
