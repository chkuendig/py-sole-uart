package com.ua.sdk.page.follow;

import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.Reference;
import com.ua.sdk.UaException;
import com.ua.sdk.UaLog;
import com.ua.sdk.authentication.AuthenticationManager;
import com.ua.sdk.internal.AbstractResourceService;
import com.ua.sdk.internal.ConnectionFactory;
import com.ua.sdk.internal.JsonParser;
import com.ua.sdk.internal.JsonWriter;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.UrlBuilder;
import java.io.InterruptedIOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;

/* loaded from: classes2.dex */
public class PageFollowService extends AbstractResourceService<PageFollow> {
    public PageFollowService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<PageFollow> jsonParser, JsonParser<EntityList<PageFollow>> jsonParser2, JsonWriter<PageFollow> jsonWriter) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreatePageFollowUrl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(PageFollow pageFollow) {
        throw new UnsupportedOperationException("Update PageFollow is unsupported.");
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        return this.urlBuilder.buildDeletePageFollowUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        return this.urlBuilder.buildGetPageFollowUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<PageFollow> entityListRef) {
        return this.urlBuilder.buildGetPageFollowPageUrl(entityListRef);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        return this.urlBuilder.buildPatchPageFollowUrl(reference);
    }

    protected EntityList<PageFollow> patch(PageFollow pageFollow) throws UaException, NullPointerException {
        Precondition.isNotNull(this.jsonWriter, "jsonWriter");
        Precondition.isNotNull(this.jsonPageParser, "jsonPageParser");
        try {
            HttpsURLConnection sslConnection = this.connFactory.getSslConnection(getPatchUrl(null));
            try {
                this.authManager.sign(sslConnection, getPatchAuthenticationType());
                sslConnection.setRequestMethod(HttpPost.METHOD_NAME);
                sslConnection.setDoOutput(true);
                sslConnection.setUseCaches(false);
                sslConnection.addRequestProperty("X-HTTP-Method-Override", HttpPatch.METHOD_NAME);
                this.jsonWriter.write(pageFollow, sslConnection.getOutputStream());
                Precondition.isResponseSuccess(sslConnection);
                return (EntityList) this.jsonPageParser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            UaLog.debug("Multi patch cancelled.");
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (Throwable th) {
            UaLog.error("Unable to multi patch page follows.", th);
            throw new UaException("Unable to multi patch page follows.", th);
        }
    }
}
