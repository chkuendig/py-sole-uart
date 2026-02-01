package org.apache.http.client.fluent;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: classes2.dex */
public class Form {
    private final List<NameValuePair> params = new ArrayList();

    public static Form form() {
        return new Form();
    }

    Form() {
    }

    public Form add(String str, String str2) {
        this.params.add(new BasicNameValuePair(str, str2));
        return this;
    }

    public List<NameValuePair> build() {
        return new ArrayList(this.params);
    }
}
