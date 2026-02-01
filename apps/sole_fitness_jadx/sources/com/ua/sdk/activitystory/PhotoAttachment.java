package com.ua.sdk.activitystory;

import android.os.Parcelable;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.activitystory.Attachment;

/* loaded from: classes2.dex */
public interface PhotoAttachment extends Attachment, Parcelable {
    ImageUrl getImageUrl();

    @Override // com.ua.sdk.activitystory.Attachment
    Attachment.Type getType();
}
