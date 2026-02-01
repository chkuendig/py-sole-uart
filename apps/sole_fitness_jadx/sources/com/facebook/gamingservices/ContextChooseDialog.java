package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextChooseContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ContextChooseDialog extends FacebookDialogBase<ContextChooseContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
    private FacebookCallback mCallback;

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public boolean canShow(ContextChooseContent contextChooseContent) {
        return true;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return null;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<ContextChooseContent, Result>.ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    public ContextChooseDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public ContextChooseDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ContextChooseDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ContextChooseDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(ContextChooseContent contextChooseContent, Object obj) throws JSONException {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(contextChooseContent, obj);
        }
    }

    private void showForCloud(ContextChooseContent contextChooseContent, Object obj) throws JSONException {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open ContextChooseContent with an invalid access token");
        }
        DaemonRequest.Callback callback = new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.ContextChooseDialog.1
            @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                if (ContextChooseDialog.this.mCallback != null) {
                    if (graphResponse.getError() != null) {
                        ContextChooseDialog.this.mCallback.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
                    } else {
                        ContextChooseDialog.this.mCallback.onSuccess(new Result(graphResponse));
                    }
                }
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filters", contextChooseContent.getFilters());
            jSONObject.put(SDKConstants.PARAM_CONTEXT_MIN_SIZE, contextChooseContent.getMinSize());
            List<String> filters = contextChooseContent.getFilters();
            if (filters != null && !filters.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < filters.size(); i++) {
                    jSONArray.put(filters.get(i));
                }
                jSONObject.put("filters", jSONArray);
            }
            DaemonRequest.executeAsync(activityContext, jSONObject, callback, SDKMessageEnum.CONTEXT_CHOOSE);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Context Choose Dialog"));
            }
        }
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        this.mCallback = facebookCallback;
        final ResultProcessor resultProcessor = facebookCallback == null ? null : new ResultProcessor(facebookCallback) { // from class: com.facebook.gamingservices.ContextChooseDialog.2
            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle bundle) {
                if (bundle != null) {
                    facebookCallback.onSuccess(new Result(bundle));
                } else {
                    onCancel(appCall);
                }
            }
        };
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.ContextChooseDialog.3
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(ContextChooseDialog.this.getRequestCode(), i, intent, resultProcessor);
            }
        });
    }

    public static final class Result {
        String contextID;

        private Result(Bundle bundle) {
            this.contextID = bundle.getString("id");
        }

        private Result(GraphResponse graphResponse) {
            try {
                JSONObject graphObject = graphResponse.getGraphObject();
                if (graphObject == null) {
                    this.contextID = null;
                } else {
                    JSONObject jSONObjectOptJSONObject = graphObject.optJSONObject("data");
                    this.contextID = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.getString("id") : null;
                }
            } catch (JSONException unused) {
                this.contextID = null;
            }
        }

        public String getContextID() {
            return this.contextID;
        }
    }
}
