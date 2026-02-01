package com.ua.sdk.remoteconnection;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ua.sdk.CreateCallback;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityRef;
import com.ua.sdk.FetchCallback;
import com.ua.sdk.Request;
import com.ua.sdk.UaException;
import com.ua.sdk.actigraphysettings.ActigraphySettings;
import com.ua.sdk.internal.Link;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class RemoteConnectionTypeManagerDummyImpl implements RemoteConnectionTypeManager {
    private RemoteConnectionTypePageImpl mRemoteConnectionTypePage;

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request fetchRemoteConnectionPriorities(FetchCallback<ActigraphySettings> fetchCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public ActigraphySettings fetchRemoteConnectionPriorities() throws UaException {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request fetchRemoteConnectionType(EntityRef<RemoteConnectionType> entityRef, FetchCallback<RemoteConnectionType> fetchCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request fetchRemoteConnectionTypeList(FetchCallback<EntityList<RemoteConnectionType>> fetchCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request updateActivityConnectionPriorities(EntityRef<RemoteConnectionType> entityRef, CreateCallback<ActigraphySettings> createCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public void updateActivityConnectionPriorities(EntityRef<RemoteConnectionType> entityRef) throws UaException {
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public Request updateSleepConnectionPriorities(EntityRef<RemoteConnectionType> entityRef, CreateCallback<ActigraphySettings> createCallback) {
        return null;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public void updateSleepConnectionPriorities(EntityRef<RemoteConnectionType> entityRef) throws UaException {
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public RemoteConnectionTypePageImpl fetchRemoteConnectionTypeList() throws UaException {
        if (this.mRemoteConnectionTypePage == null) {
            RemoteConnectionTypePageImpl remoteConnectionTypePageImpl = new RemoteConnectionTypePageImpl();
            this.mRemoteConnectionTypePage = remoteConnectionTypePageImpl;
            remoteConnectionTypePageImpl.add(createRemoteConnectionType(1));
            this.mRemoteConnectionTypePage.add(createRemoteConnectionType(2));
            this.mRemoteConnectionTypePage.add(createRemoteConnectionType(3));
        }
        return this.mRemoteConnectionTypePage;
    }

    @Override // com.ua.sdk.remoteconnection.RemoteConnectionTypeManager
    public RemoteConnectionType fetchRemoteConnectionType(EntityRef<RemoteConnectionType> entityRef) throws UaException {
        return createRemoteConnectionType(Integer.valueOf(entityRef.getId()).intValue());
    }

    public RemoteConnectionTypeImpl createRemoteConnectionType(int i) {
        RemoteConnectionTypeImpl remoteConnectionTypeImpl = new RemoteConnectionTypeImpl();
        ArrayList<Link> arrayList = new ArrayList<>();
        if (i == 1) {
            remoteConnectionTypeImpl.setRecorderTypeKey("fitbit");
            remoteConnectionTypeImpl.setDisconnectCancelStr("No, keep it linked");
            remoteConnectionTypeImpl.setName("Fitbit");
            remoteConnectionTypeImpl.setLogoLink("http://d2i3r43q6ffvz8.cloudfront.net/prod/hashed/8fe4f617a43cf64cc9d1a76f38254e42394b12d9.png");
            remoteConnectionTypeImpl.setOAuthLink("/remote/connect/?remote_code=fitbit");
            remoteConnectionTypeImpl.setDisconnectConfirmStr("Yes, I'm sure");
            remoteConnectionTypeImpl.setDisconnectStr("Are you sure you want to disconnect your Fitbit account from MapMyFitness?");
            remoteConnectionTypeImpl.setIntroHeadingStr("To get started, log into your account.");
            remoteConnectionTypeImpl.setType("fitbit");
            remoteConnectionTypeImpl.setIntroBodyStr("On initial registration, 1 month of your Fitbit history will be imported. Subsequent updates will automatically occur whenever you sync your device with your Fitbit account as normal.");
            arrayList.add(new Link("/vx/remoteconnectiontype/1/", AppEventsConstants.EVENT_PARAM_VALUE_YES));
            remoteConnectionTypeImpl.setLinksForRelation("self", arrayList);
        } else if (i == 2) {
            remoteConnectionTypeImpl.setRecorderTypeKey("jawboneupmoves");
            remoteConnectionTypeImpl.setDisconnectCancelStr("No, keep it linked");
            remoteConnectionTypeImpl.setName("Jawbone");
            remoteConnectionTypeImpl.setLogoLink("http://d2i3r43q6ffvz8.cloudfront.net/prod/hashed/65db9f887364d4d031b004656c519bc11055b5f2.png");
            remoteConnectionTypeImpl.setOAuthLink("/remote/connect/?remote_code=jawboneup");
            remoteConnectionTypeImpl.setDisconnectConfirmStr("Yes, I'm sure");
            remoteConnectionTypeImpl.setDisconnectStr("Are you sure you want to disconnect your Jawbone account from MapMyFitness?");
            remoteConnectionTypeImpl.setIntroHeadingStr("To get started, log into your account.");
            remoteConnectionTypeImpl.setType("jawboneup");
            remoteConnectionTypeImpl.setIntroBodyStr("On initial registration, 1 month of your Jawbone history will be imported. Subsequent updates will automatically occur whenever you sync your device with your Jawbone account as normal.");
            arrayList.add(new Link("/vx/remoteconnectiontype/2/", ExifInterface.GPS_MEASUREMENT_2D));
            remoteConnectionTypeImpl.setLinksForRelation("self", arrayList);
        } else {
            remoteConnectionTypeImpl.setRecorderTypeKey("withings");
            remoteConnectionTypeImpl.setDisconnectCancelStr("No, keep it linked");
            remoteConnectionTypeImpl.setName("Withings");
            remoteConnectionTypeImpl.setLogoLink("http://d2i3r43q6ffvz8.cloudfront.net/prod/hashed/1f4ee8da8a4f54872e14abaad2632721827695fb.png");
            remoteConnectionTypeImpl.setOAuthLink("/remote/connect/?remote_code=withings");
            remoteConnectionTypeImpl.setDisconnectConfirmStr("Yes, I'm sure");
            remoteConnectionTypeImpl.setDisconnectStr("Are you sure you want to disconnect your Withings account from MapMyFitness?");
            remoteConnectionTypeImpl.setIntroHeadingStr("To get started, log into your account.");
            remoteConnectionTypeImpl.setType("withings");
            remoteConnectionTypeImpl.setIntroBodyStr("On initial registration, 1 month of your Withings history will be imported. Subsequent updates will automatically occur whenever you sync your device with your Withings account as normal.");
            arrayList.add(new Link("/vx/remoteconnectiontype/3/", ExifInterface.GPS_MEASUREMENT_3D));
            remoteConnectionTypeImpl.setLinksForRelation("self", arrayList);
        }
        return remoteConnectionTypeImpl;
    }
}
