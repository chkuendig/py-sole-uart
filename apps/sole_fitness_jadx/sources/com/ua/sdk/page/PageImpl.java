package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.UaLog;
import com.ua.sdk.actigraphy.Actigraphy;
import com.ua.sdk.actigraphy.ActigraphyTransferObject;
import com.ua.sdk.activitystory.ActivityStory;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.LinkListRef;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.location.Location;
import com.ua.sdk.page.association.PageAssociation;
import com.ua.sdk.page.follow.PageFollow;
import com.ua.sdk.user.User;
import com.ua.sdk.workout.Workout;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class PageImpl extends ApiTransferObject implements Page, Parcelable {
    public static Parcelable.Creator<PageImpl> CREATOR = new Parcelable.Creator<PageImpl>() { // from class: com.ua.sdk.page.PageImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageImpl createFromParcel(Parcel parcel) {
            return new PageImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageImpl[] newArray(int i) {
            return new PageImpl[i];
        }
    };
    protected static final String REF_PAGE_TYPE = "privacy";
    private EntityListRef<Actigraphy> actigraphyRef;
    private EntityListRef<ActivityStory> activityFeedRef;
    private String alias;
    private ImageUrl coverPhoto;
    private EntityListRef<ActivityStory> featuredFeedRef;
    private Integer followerCount;
    private EntityListRef<PageFollow> followerRef;
    private Integer followingCount;
    private EntityListRef<PageFollow> followingRef;
    private Integer fromPageAssociationCount;
    private EntityListRef<PageAssociation> fromPageAssociationRef;
    private String headline;
    private Location location;
    private String pageDescription;
    private EntityRef<PageFollow> pageFollowRef;
    private EntityRef<Page> pageRef;
    private PageSetting pageSetting;
    private EntityRef<PageType> pageTypeRef;
    private EntityRef<PageFollow> pageUnfollowRef;
    private ImageUrl profilePhoto;
    private String title;
    private EntityListRef<PageAssociation> toPageAssocationRef;
    private Integer toPageAssociationCount;
    private URI url;
    private EntityRef<User> userRef;
    private URI website;
    private EntityListRef<Workout> workoutsRef;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    PageImpl() {
        this.profilePhoto = new ImageUrlImpl();
        this.coverPhoto = new ImageUrlImpl();
    }

    PageImpl(Page page) throws NullPointerException {
        this.profilePhoto = new ImageUrlImpl();
        this.coverPhoto = new ImageUrlImpl();
        Precondition.isNotNull(page);
        this.alias = page.getAlias();
        this.title = page.getTitle();
        this.pageDescription = page.getDescription();
        this.url = page.getUrl();
        this.website = page.getWebsite();
        this.location = page.getLocation();
        this.userRef = page.getUserRef();
        this.pageRef = page.getRef();
        this.pageTypeRef = page.getPageTypeRef();
        this.pageFollowRef = page.getPageFollowRef();
        this.pageUnfollowRef = page.getPageUnfollowRef();
        this.workoutsRef = page.getWorkoutsRef();
        this.actigraphyRef = page.getActigraphyRef();
        this.fromPageAssociationRef = page.getFromPageAssociationsRef();
        this.toPageAssocationRef = page.getToPageAssociationsRef();
        this.followerRef = page.getFollowersRef();
        this.activityFeedRef = page.getActivityFeedRef();
        this.featuredFeedRef = page.getFeaturedFeedRef();
        this.followerCount = page.getFollowerCount();
        this.fromPageAssociationCount = page.getFromPageAssociationCount();
        this.toPageAssociationCount = page.getToPageAssociationCount();
        this.profilePhoto = page.getProfilePhoto();
        this.coverPhoto = page.getCoverPhoto();
        this.headline = page.getHeadline();
        this.pageSetting = page.getPageSetting();
        this.followingCount = page.getFollowingCount();
        this.followingRef = page.getFollowingRef();
        if (page instanceof PageImpl) {
            copyLinkMap(((PageImpl) page).getLinkMap());
        }
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<Page> getRef() {
        ArrayList<Link> links;
        if (this.pageRef == null && (links = getLinks("self")) != null) {
            this.pageRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.pageRef;
    }

    @Override // com.ua.sdk.page.Page
    public URI getWebsite() {
        return this.website;
    }

    @Override // com.ua.sdk.page.Page
    public String getDescription() {
        return this.pageDescription;
    }

    @Override // com.ua.sdk.page.Page
    public String getTitle() {
        return this.title;
    }

    @Override // com.ua.sdk.page.Page
    public URI getUrl() {
        return this.url;
    }

    @Override // com.ua.sdk.page.Page
    public String getAlias() {
        return this.alias;
    }

    @Override // com.ua.sdk.page.Page
    public Location getLocation() {
        return this.location;
    }

    @Override // com.ua.sdk.page.Page
    public Integer getFollowerCount() {
        if (this.followerCount == null) {
            parseFollowersLink();
        }
        return this.followerCount;
    }

    @Override // com.ua.sdk.page.Page
    public Integer getFollowingCount() {
        if (this.followingCount == null) {
            parseFollowersLink();
        }
        return this.followingCount;
    }

    @Override // com.ua.sdk.page.Page
    public String getHeadline() {
        return this.headline;
    }

    @Override // com.ua.sdk.page.Page
    public PageSetting getPageSetting() {
        return this.pageSetting;
    }

    @Override // com.ua.sdk.page.Page
    public Integer getFromPageAssociationCount() {
        if (this.fromPageAssociationCount == null) {
            parseAssociationsLink();
        }
        return this.fromPageAssociationCount;
    }

    @Override // com.ua.sdk.page.Page
    public Integer getToPageAssociationCount() {
        if (this.toPageAssociationCount == null) {
            parseAssociationsLink();
        }
        return this.toPageAssociationCount;
    }

    @Override // com.ua.sdk.page.Page
    public PageTypeEnum getPageType() {
        if (getPageTypeRef() != null) {
            return PageTypeEnum.getById(this.pageTypeRef.getId());
        }
        return null;
    }

    @Override // com.ua.sdk.page.Page
    public EntityRef<User> getUserRef() {
        ArrayList<Link> links;
        if (this.userRef == null && (links = getLinks("user")) != null) {
            this.userRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.userRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityRef<PageType> getPageTypeRef() {
        ArrayList<Link> links;
        if (this.pageTypeRef == null && (links = getLinks("page_type")) != null) {
            this.pageTypeRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.pageTypeRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityRef<PageFollow> getPageFollowRef() {
        ArrayList<Link> links;
        if (this.pageFollowRef == null && (links = getLinks("follow")) != null) {
            this.pageFollowRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.pageFollowRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityRef<PageFollow> getPageUnfollowRef() {
        ArrayList<Link> links;
        if (this.pageUnfollowRef == null && (links = getLinks("unfollow")) != null) {
            this.pageUnfollowRef = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.pageUnfollowRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<Workout> getWorkoutsRef() {
        ArrayList<Link> links;
        if (this.workoutsRef == null && (links = getLinks("workouts")) != null) {
            this.workoutsRef = new LinkListRef(links.get(0).getHref());
        }
        return this.workoutsRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<Actigraphy> getActigraphyRef() {
        ArrayList<Link> links;
        if (this.actigraphyRef == null && (links = getLinks(ActigraphyTransferObject.KEY_ACTIGRAPHY)) != null) {
            this.actigraphyRef = new LinkListRef(links.get(0).getHref());
        }
        return this.actigraphyRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<PageAssociation> getFromPageAssociationsRef() {
        if (this.fromPageAssociationRef == null) {
            parseAssociationsLink();
        }
        return this.fromPageAssociationRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<PageAssociation> getToPageAssociationsRef() {
        if (this.toPageAssocationRef == null) {
            parseAssociationsLink();
        }
        return this.toPageAssocationRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<PageFollow> getFollowersRef() {
        if (this.followerRef == null) {
            parseFollowersLink();
        }
        return this.followerRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<PageFollow> getFollowingRef() {
        if (this.followingRef == null) {
            parseFollowersLink();
        }
        return this.followingRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<ActivityStory> getActivityFeedRef() {
        Link link;
        if (this.activityFeedRef == null && (link = getLink("activity_feed", "activity_feed")) != null) {
            this.activityFeedRef = new LinkListRef(link.getHref());
        }
        return this.activityFeedRef;
    }

    @Override // com.ua.sdk.page.Page
    public EntityListRef<ActivityStory> getFeaturedFeedRef() {
        Link link;
        if (this.featuredFeedRef == null && (link = getLink("activity_feed", "featured")) != null) {
            this.featuredFeedRef = new LinkListRef(link.getHref());
        }
        return this.featuredFeedRef;
    }

    private void parseFollowersLink() {
        ArrayList<Link> links = getLinks("followers");
        if (links != null) {
            for (Link link : links) {
                if (link.getName().equals("followers")) {
                    this.followerRef = new LinkListRef(link.getHref());
                    this.followerCount = link.getCount();
                } else if (link.getName().equals("following")) {
                    this.followingRef = new LinkListRef(link.getHref());
                    this.followingCount = link.getCount();
                }
            }
        }
    }

    private void parseAssociationsLink() {
        ArrayList<Link> links = getLinks("associations");
        if (links == null) {
            return;
        }
        for (Link link : links) {
            if (link.getName().equals("from")) {
                this.fromPageAssociationRef = new LinkListRef(link.getHref());
                this.fromPageAssociationCount = link.getCount();
            } else if (link.getName().equals("to")) {
                this.toPageAssocationRef = new LinkListRef(link.getHref());
                this.toPageAssociationCount = link.getCount();
            }
        }
    }

    void setAlias(String str) {
        this.alias = str;
    }

    void setTitle(String str) {
        this.title = str;
    }

    void setPageDescription(String str) {
        this.pageDescription = str;
    }

    void setUrl(URI uri) {
        this.url = uri;
    }

    void setWebsite(URI uri) {
        this.website = uri;
    }

    void setLocation(Location location) {
        this.location = location;
    }

    void setUserRef(EntityRef<User> entityRef) {
        this.userRef = entityRef;
    }

    void setPageRef(EntityRef<Page> entityRef) {
        this.pageRef = entityRef;
    }

    void setPageTypeRef(EntityRef<PageType> entityRef) {
        this.pageTypeRef = entityRef;
    }

    void setPageFollowRef(EntityRef<PageFollow> entityRef) {
        this.pageFollowRef = entityRef;
    }

    void setPageUnfollowRef(EntityRef<PageFollow> entityRef) {
        this.pageUnfollowRef = entityRef;
    }

    void setWorkoutsRef(EntityListRef<Workout> entityListRef) {
        this.workoutsRef = entityListRef;
    }

    void setActigraphyRef(EntityListRef<Actigraphy> entityListRef) {
        this.actigraphyRef = entityListRef;
    }

    void setFromPageAssociationRef(EntityListRef<PageAssociation> entityListRef) {
        this.fromPageAssociationRef = entityListRef;
    }

    void setToPageAssociationRef(EntityListRef<PageAssociation> entityListRef) {
        this.toPageAssocationRef = entityListRef;
    }

    void setFollowerRef(EntityListRef<PageFollow> entityListRef) {
        this.followerRef = entityListRef;
    }

    void setFollowingRef(EntityListRef<PageFollow> entityListRef) {
        this.followingRef = entityListRef;
    }

    void setActivityFeedRef(EntityListRef<ActivityStory> entityListRef) {
        this.activityFeedRef = entityListRef;
    }

    void setFeaturedFeedRef(EntityListRef<ActivityStory> entityListRef) {
        this.featuredFeedRef = entityListRef;
    }

    void setFollowerCount(Integer num) {
        this.followerCount = num;
    }

    void setFollowingCount(Integer num) {
        this.followingCount = num;
    }

    void setFromPageAssociationCount(Integer num) {
        this.fromPageAssociationCount = num;
    }

    void setToPageAssociationCount(Integer num) {
        this.toPageAssociationCount = num;
    }

    void setHeadline(String str) {
        this.headline = str;
    }

    void setPageSetting(PageSetting pageSetting) {
        this.pageSetting = pageSetting;
    }

    @Override // com.ua.sdk.page.Page
    public ImageUrl getProfilePhoto() {
        return this.profilePhoto;
    }

    public void setProfilePhoto(ImageUrlImpl imageUrlImpl) {
        this.profilePhoto = imageUrlImpl;
    }

    @Override // com.ua.sdk.page.Page
    public ImageUrl getCoverPhoto() {
        return this.coverPhoto;
    }

    public void setCoverPhoto(ImageUrlImpl imageUrlImpl) {
        this.coverPhoto = imageUrlImpl;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.alias);
        parcel.writeString(this.title);
        parcel.writeString(this.pageDescription);
        URI uri = this.url;
        if (uri == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(uri.toString());
        }
        URI uri2 = this.website;
        if (uri2 == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(uri2.toString());
        }
        parcel.writeParcelable(this.location, 0);
        parcel.writeParcelable(this.userRef, 0);
        parcel.writeParcelable(this.pageRef, 0);
        parcel.writeParcelable(this.pageTypeRef, 0);
        parcel.writeParcelable(this.pageFollowRef, 0);
        parcel.writeParcelable(this.pageUnfollowRef, 0);
        parcel.writeParcelable(this.workoutsRef, 0);
        parcel.writeParcelable(this.actigraphyRef, 0);
        parcel.writeParcelable(this.fromPageAssociationRef, 0);
        parcel.writeParcelable(this.toPageAssocationRef, 0);
        parcel.writeParcelable(this.followerRef, 0);
        parcel.writeParcelable(this.activityFeedRef, 0);
        parcel.writeParcelable(this.featuredFeedRef, 0);
        parcel.writeValue(this.followerCount);
        parcel.writeValue(this.fromPageAssociationCount);
        parcel.writeValue(this.toPageAssociationCount);
        parcel.writeParcelable(this.coverPhoto, 0);
        parcel.writeParcelable(this.profilePhoto, 0);
        parcel.writeString(this.headline);
        parcel.writeParcelable(this.pageSetting, 0);
        parcel.writeParcelable(this.followingRef, 0);
        parcel.writeValue(this.followingCount);
    }

    private PageImpl(Parcel parcel) {
        super(parcel);
        this.profilePhoto = new ImageUrlImpl();
        this.coverPhoto = new ImageUrlImpl();
        this.alias = parcel.readString();
        this.title = parcel.readString();
        this.pageDescription = parcel.readString();
        String string = parcel.readString();
        if (string.equals("")) {
            this.url = null;
        } else {
            try {
                this.url = new URI(string);
            } catch (URISyntaxException e) {
                UaLog.error("Error unparceling Page URL: " + string, (Throwable) e);
            }
        }
        String string2 = parcel.readString();
        if (string2.equals("")) {
            this.website = null;
        } else {
            try {
                this.website = new URI(string2);
            } catch (URISyntaxException e2) {
                UaLog.error("Error unparceling Page website: " + string2, (Throwable) e2);
            }
        }
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.userRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.pageRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.pageTypeRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.pageFollowRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.pageUnfollowRef = (EntityRef) parcel.readParcelable(LinkEntityRef.class.getClassLoader());
        this.workoutsRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.actigraphyRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.fromPageAssociationRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.toPageAssocationRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.followerRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.activityFeedRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.featuredFeedRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.followerCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.fromPageAssociationCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.toPageAssociationCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.coverPhoto = (ImageUrl) parcel.readParcelable(ImageUrl.class.getClassLoader());
        this.profilePhoto = (ImageUrl) parcel.readParcelable(ImageUrl.class.getClassLoader());
        this.headline = parcel.readString();
        this.pageSetting = (PageSetting) parcel.readParcelable(PageSetting.class.getClassLoader());
        this.followingRef = (EntityListRef) parcel.readParcelable(LinkListRef.class.getClassLoader());
        this.followingCount = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
