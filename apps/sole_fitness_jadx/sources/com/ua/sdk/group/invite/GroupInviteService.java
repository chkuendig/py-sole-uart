package com.ua.sdk.group.invite;

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
public class GroupInviteService extends AbstractResourceService<GroupInvite> {
    public GroupInviteService(ConnectionFactory connectionFactory, AuthenticationManager authenticationManager, UrlBuilder urlBuilder, JsonParser<GroupInvite> jsonParser, JsonWriter<GroupInvite> jsonWriter, JsonParser<? extends EntityList<GroupInvite>> jsonParser2) {
        super(connectionFactory, authenticationManager, urlBuilder, jsonParser, jsonWriter, jsonParser2);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getCreateUrl() {
        return this.urlBuilder.buildCreateGroupInviteUrl();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchUrl(Reference reference) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ua.sdk.internal.AbstractResourceService
    public URL getSaveUrl(GroupInvite groupInvite) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getDeleteUrl(Reference reference) {
        return this.urlBuilder.buildDeleteGroupInviteUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getPatchUrl(Reference reference) {
        return this.urlBuilder.buildPatchGroupInviteUrl(reference);
    }

    @Override // com.ua.sdk.internal.AbstractResourceService
    protected URL getFetchPageUrl(EntityListRef<GroupInvite> entityListRef) {
        return this.urlBuilder.buildGetGroupInviteUrl(entityListRef);
    }

    protected EntityList<GroupInvite> patch(GroupInvite groupInvite) throws UaException, NullPointerException {
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
                this.jsonWriter.write(groupInvite, sslConnection.getOutputStream());
                Precondition.isResponseSuccess(sslConnection);
                return (EntityList) this.jsonPageParser.parse(sslConnection.getInputStream());
            } finally {
                sslConnection.disconnect();
            }
        } catch (InterruptedIOException e) {
            UaLog.debug("Multi patch cancelled.");
            throw new UaException(UaException.Code.CANCELED, e);
        } catch (Throwable th) {
            UaLog.error("Unable to multi patch group invites.", th);
            throw new UaException("Unable to multi patch group invites.", th);
        }
    }
}
