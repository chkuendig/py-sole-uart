package com.dyaco.sole.notification;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class TagAliasOperatorHelper {
    public static final int ACTION_ADD = 1;
    public static final int ACTION_CHECK = 6;
    public static final int ACTION_CLEAN = 4;
    public static final int ACTION_DELETE = 3;
    public static final int ACTION_GET = 5;
    public static final int ACTION_SET = 2;
    public static final int DELAY_SEND_ACTION = 1;
    public static final int DELAY_SET_MOBILE_NUMBER_ACTION = 2;
    private static final String TAG = "JIGUANG-TagAliasHelper";
    private static TagAliasOperatorHelper mInstance = null;
    public static int sequence = 1;
    private Context context;
    private SparseArray<Object> setActionCache = new SparseArray<>();
    private Handler delaySendHandler = new Handler() { // from class: com.dyaco.sole.notification.TagAliasOperatorHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                if (message.obj != null && (message.obj instanceof TagAliasBean)) {
                    Log.i(TagAliasOperatorHelper.TAG, "on delay time");
                    TagAliasOperatorHelper.sequence++;
                    TagAliasBean tagAliasBean = (TagAliasBean) message.obj;
                    TagAliasOperatorHelper.this.setActionCache.put(TagAliasOperatorHelper.sequence, tagAliasBean);
                    if (TagAliasOperatorHelper.this.context != null) {
                        TagAliasOperatorHelper tagAliasOperatorHelper = TagAliasOperatorHelper.this;
                        tagAliasOperatorHelper.handleAction(tagAliasOperatorHelper.context, TagAliasOperatorHelper.sequence, tagAliasBean);
                        return;
                    } else {
                        Log.e(TagAliasOperatorHelper.TAG, "#unexcepted - context was null");
                        return;
                    }
                }
                Log.w(TagAliasOperatorHelper.TAG, "#unexcepted - msg obj was incorrect");
                return;
            }
            if (i != 2) {
                return;
            }
            if (message.obj != null && (message.obj instanceof String)) {
                Log.i(TagAliasOperatorHelper.TAG, "retry set mobile number");
                TagAliasOperatorHelper.sequence++;
                String str = (String) message.obj;
                TagAliasOperatorHelper.this.setActionCache.put(TagAliasOperatorHelper.sequence, str);
                if (TagAliasOperatorHelper.this.context != null) {
                    TagAliasOperatorHelper tagAliasOperatorHelper2 = TagAliasOperatorHelper.this;
                    tagAliasOperatorHelper2.handleAction(tagAliasOperatorHelper2.context, TagAliasOperatorHelper.sequence, str);
                    return;
                } else {
                    Log.e(TagAliasOperatorHelper.TAG, "#unexcepted - context was null");
                    return;
                }
            }
            Log.w(TagAliasOperatorHelper.TAG, "#unexcepted - msg obj was incorrect");
        }
    };

    private String getActionStr(int i) {
        switch (i) {
            case 1:
                return "add";
            case 2:
                return "set";
            case 3:
                return "delete";
            case 4:
                return "clean";
            case 5:
                return "get";
            case 6:
                return "check";
            default:
                return "unkonw operation";
        }
    }

    private TagAliasOperatorHelper() {
    }

    public static TagAliasOperatorHelper getInstance() {
        if (mInstance == null) {
            synchronized (TagAliasOperatorHelper.class) {
                if (mInstance == null) {
                    mInstance = new TagAliasOperatorHelper();
                }
            }
        }
        return mInstance;
    }

    public void init(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public Object get(int i) {
        return this.setActionCache.get(i);
    }

    public Object remove(int i) {
        return this.setActionCache.get(i);
    }

    public void put(int i, Object obj) {
        this.setActionCache.put(i, obj);
    }

    public void handleAction(Context context, int i, String str) {
        put(i, str);
        Log.e(TAG, "sequence:" + i + ",mobileNumber:" + str);
    }

    public void handleAction(Context context, int i, TagAliasBean tagAliasBean) {
        init(context);
        if (tagAliasBean == null) {
            Log.w(TAG, "tagAliasBean was null");
        }
        put(i, tagAliasBean);
        if (tagAliasBean.isAliasAction) {
            int i2 = tagAliasBean.action;
            if (i2 == 2 || i2 == 3 || i2 == 5) {
                return;
            }
            Log.w(TAG, "unsupport alias action type");
            return;
        }
        switch (tagAliasBean.action) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
                break;
            default:
                Log.w(TAG, "unsupport tag action type");
                break;
        }
    }

    private boolean RetryActionIfNeeded(int i, TagAliasBean tagAliasBean) {
        if (!ExampleUtil.isConnected(this.context)) {
            Log.w(TAG, "no network");
            return false;
        }
        if (i != 6002 && i != 6014) {
            return false;
        }
        Log.e(TAG, "need retry");
        if (tagAliasBean == null) {
            return false;
        }
        Message message = new Message();
        message.what = 1;
        message.obj = tagAliasBean;
        this.delaySendHandler.sendMessageDelayed(message, 60000L);
        ExampleUtil.showToast(getRetryStr(tagAliasBean.isAliasAction, tagAliasBean.action, i), this.context);
        return true;
    }

    private boolean RetrySetMObileNumberActionIfNeeded(int i, String str) {
        if (!ExampleUtil.isConnected(this.context)) {
            Log.w(TAG, "no network");
            return false;
        }
        if (i != 6002 && i != 6024) {
            return false;
        }
        Log.d(TAG, "need retry");
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.delaySendHandler.sendMessageDelayed(message, 60000L);
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[1];
        objArr[0] = i == 6002 ? "timeout" : "server internal error”";
        ExampleUtil.showToast(String.format(locale, "Failed to set mobile number due to %s. Try again after 60s.", objArr), this.context);
        return true;
    }

    private String getRetryStr(boolean z, int i, int i2) {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[3];
        objArr[0] = getActionStr(i);
        objArr[1] = z ? "alias" : " tags";
        objArr[2] = i2 == 6002 ? "timeout" : "server too busy";
        return String.format(locale, "Failed to %s %s due to %s. Try again after 60s.", objArr);
    }

    public static class TagAliasBean {
        int action;
        String alias;
        boolean isAliasAction;
        Set<String> tags;

        public String toString() {
            return "TagAliasBean{action=" + this.action + ", tags=" + this.tags + ", alias='" + this.alias + "', isAliasAction=" + this.isAliasAction + '}';
        }
    }
}
