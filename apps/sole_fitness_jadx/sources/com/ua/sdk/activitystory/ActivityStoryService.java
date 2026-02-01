package com.ua.sdk.activitystory;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.net.URL;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class ActivityStoryService extends AbstractResourceService<ActivityStory> {
    public ActivityStoryService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<? extends EntityList<ActivityStory>> jsonParser, JsonParser<ActivityStory> jsonParser2, JsonWriter<ActivityStory> jsonWriter) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser2, jsonWriter, jsonParser);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public Callable<ActivityStory> getSaveCallable(final ActivityStory activityStory) throws UaException {
        return new Callable<ActivityStory>() { // from class: com.ua.sdk.activitystory.ActivityStoryService.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ActivityStory call() throws Exception {
                HttpsURLConnection sslConnection = ActivityStoryService.this.connFactory.getSslConnection(ActivityStoryService.this.getSaveUrl(activityStory));
                try {
                    ActivityStoryService.this.authManager.sign(sslConnection, ActivityStoryService.this.getSaveAuthenticationType());
                    sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    sslConnection.setDoOutput(true);
                    sslConnection.setUseCaches(false);
                    ActivityStoryService.this.jsonWriter.write(activityStory, sslConnection.getOutputStream());
                    Precondition.isExpectedResponse(sslConnection, 204);
                    return activityStory;
                } finally {
                    sslConnection.disconnect();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(ActivityStory activityStory) {
        return this.urlBuilder.buildRpcPatchActivityStoryUrl(activityStory.getRef());
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        return this.urlBuilder.buildGetActivityStoryUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreateActivityStoryUrl();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<ActivityStory> entityListRef) {
        return this.urlBuilder.buildGetActivityFeedUrl(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetActivityStoryUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        return this.urlBuilder.buildGetActivityStoryUrl(reference);
    }
}
