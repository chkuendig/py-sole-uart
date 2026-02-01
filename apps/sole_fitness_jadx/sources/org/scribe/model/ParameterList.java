package org.scribe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/* loaded from: classes2.dex */
public class ParameterList {
    private static final String EMPTY_STRING = "";
    private static final String PAIR_SEPARATOR = "=";
    private static final String PARAM_SEPARATOR = "&";
    private static final char QUERY_STRING_SEPARATOR = '?';
    private final List<Parameter> params;

    public ParameterList() {
        this.params = new ArrayList();
    }

    ParameterList(List<Parameter> list) {
        this.params = new ArrayList(list);
    }

    public ParameterList(Map<String, String> map) {
        this();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.params.add(new Parameter(entry.getKey(), entry.getValue()));
        }
    }

    public void add(String str, String str2) {
        this.params.add(new Parameter(str, str2));
    }

    public String appendTo(String str) {
        Preconditions.checkNotNull(str, "Cannot append to null URL");
        String strAsFormUrlEncodedString = asFormUrlEncodedString();
        if (strAsFormUrlEncodedString.equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) != -1 ? PARAM_SEPARATOR : Character.valueOf(QUERY_STRING_SEPARATOR));
        return sb.toString() + strAsFormUrlEncodedString;
    }

    public String asOauthBaseString() {
        return OAuthEncoder.encode(asFormUrlEncodedString());
    }

    public String asFormUrlEncodedString() {
        if (this.params.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Parameter parameter : this.params) {
            sb.append(Typography.amp);
            sb.append(parameter.asUrlEncodedPair());
        }
        return sb.toString().substring(1);
    }

    public void addAll(ParameterList parameterList) {
        this.params.addAll(parameterList.params);
    }

    public void addQuerystring(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        for (String str2 : str.split(PARAM_SEPARATOR)) {
            String[] strArrSplit = str2.split(PAIR_SEPARATOR);
            this.params.add(new Parameter(OAuthEncoder.decode(strArrSplit[0]), strArrSplit.length > 1 ? OAuthEncoder.decode(strArrSplit[1]) : ""));
        }
    }

    public boolean contains(Parameter parameter) {
        return this.params.contains(parameter);
    }

    public int size() {
        return this.params.size();
    }

    public ParameterList sort() {
        ParameterList parameterList = new ParameterList(this.params);
        Collections.sort(parameterList.params);
        return parameterList;
    }
}
