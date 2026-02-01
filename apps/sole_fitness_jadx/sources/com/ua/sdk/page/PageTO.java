package com.ua.sdk.page;

import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.location.LocationImpl;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes2.dex */
public class PageTO extends ApiTransferObject {

    @SerializedName("alias")
    String alias;

    @SerializedName("cover_photo")
    Photo coverPhoto;

    @SerializedName("description")
    String description;

    @SerializedName("headline")
    String headline;

    @SerializedName("location")
    LocationImpl location;

    @SerializedName("profile_photo")
    Photo profilePhoto;

    @SerializedName("settings")
    PageSettingImpl setting;

    @SerializedName("title")
    String title;

    @SerializedName("url")
    String url;

    @SerializedName("website")
    String website;

    public static PageImpl toPageImpl(PageTO pageTO) throws UaException {
        String str;
        String str2;
        if (pageTO == null) {
            return null;
        }
        PageImpl pageImpl = new PageImpl();
        if (pageTO.website != null) {
            try {
                pageImpl.setWebsite(new URI(pageTO.website));
            } catch (URISyntaxException e) {
                UaLog.error("Website could not put into URI Object: " + pageTO.website, (Throwable) e);
            }
        }
        pageImpl.setPageDescription(pageTO.description);
        pageImpl.setTitle(pageTO.title);
        if (pageTO.url != null) {
            try {
                pageImpl.setUrl(new URI(pageTO.url));
            } catch (URISyntaxException e2) {
                UaLog.error("Url could not put into URI Object: " + pageTO.url, (Throwable) e2);
            }
        }
        pageImpl.setAlias(pageTO.alias);
        pageImpl.setLocation(pageTO.location);
        Photo photo = pageTO.profilePhoto;
        if (photo != null && (str2 = photo.template) != null) {
            pageImpl.setProfilePhoto(ImageUrlImpl.getBuilder().setUri(pageTO.profilePhoto.uri).setTemplate(str2).build());
        }
        Photo photo2 = pageTO.coverPhoto;
        if (photo2 != null && (str = photo2.template) != null) {
            pageImpl.setCoverPhoto(ImageUrlImpl.getBuilder().setUri(pageTO.coverPhoto.uri).setTemplate(str).build());
        }
        pageImpl.setHeadline(pageTO.headline);
        pageImpl.setPageSetting(pageTO.setting);
        for (String str3 : pageTO.getLinkKeys()) {
            pageImpl.setLinksForRelation(str3, pageTO.getLinks(str3));
        }
        return pageImpl;
    }

    static class Photo {

        @SerializedName("template")
        String template;

        @SerializedName(ShareConstants.MEDIA_URI)
        String uri;

        Photo() {
        }
    }
}
