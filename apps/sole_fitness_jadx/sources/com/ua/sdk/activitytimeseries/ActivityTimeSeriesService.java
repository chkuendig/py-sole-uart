package com.ua.sdk.activitytimeseries;

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
import org.apache.http.client.methods.HttpPut;

/* loaded from: classes2.dex */
public class ActivityTimeSeriesService extends AbstractResourceService<ActivityTimeSeries> {
    public ActivityTimeSeriesService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonWriter<ActivityTimeSeries> jsonWriter, JsonParser<ActivityTimeSeries> jsonParser) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, null);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreateActivityTimeSeriesUrl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public Callable<ActivityTimeSeries> getCreateCallable(final ActivityTimeSeries activityTimeSeries) throws UaException {
        return new Callable<ActivityTimeSeries>() { // from class: com.ua.sdk.activitytimeseries.ActivityTimeSeriesService.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public ActivityTimeSeries call() throws Exception {
                HttpsURLConnection sslConnection = ActivityTimeSeriesService.this.connFactory.getSslConnection(ActivityTimeSeriesService.this.getCreateUrl());
                Precondition.isAuthenticated(ActivityTimeSeriesService.this.authManager);
                try {
                    ActivityTimeSeriesService.this.authManager.sign(sslConnection, ActivityTimeSeriesService.this.getCreateAuthenticationType());
                    sslConnection.setRequestMethod(HttpPut.METHOD_NAME);
                    sslConnection.setDoOutput(true);
                    sslConnection.setUseCaches(false);
                    ActivityTimeSeriesService.this.jsonWriter.write(activityTimeSeries, sslConnection.getOutputStream());
                    Precondition.isExpectedResponse(sslConnection, 204);
                    return activityTimeSeries;
                } finally {
                    sslConnection.disconnect();
                }
            }
        };
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        throw new UnsupportedOperationException("Fetch ActivityTimeSeries is unsupported.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(ActivityTimeSeries activityTimeSeries) {
        throw new UnsupportedOperationException("Save ActivityTimeSeries is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        throw new UnsupportedOperationException("Delete ActivityTimeSeries is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        throw new UnsupportedOperationException("Patch ActivityTimeSeries is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<ActivityTimeSeries> entityListRef) {
        throw new UnsupportedOperationException("Fetch ActivityTimeSeries Page is unsupported.");
    }
}
