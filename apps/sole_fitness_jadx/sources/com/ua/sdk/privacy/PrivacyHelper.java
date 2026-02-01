package com.ua.sdk.privacy;

import com.ua.sdk.UaLog;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.privacy.Privacy;

/* loaded from: classes2.dex */
public class PrivacyHelper {
    public static final String DESC_FRIENDS = "Friends. Share With All My Friend";
    public static final String DESC_PRIVATE = "Private. Do Not Share";
    public static final String DESC_PUBLIC = "Public. Share With Everyone";

    /* renamed from: com.ua.sdk.privacy.PrivacyHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ua$sdk$privacy$Privacy$Level;

        static {
            int[] iArr = new int[Privacy.Level.values().length];
            $SwitchMap$com$ua$sdk$privacy$Privacy$Level = iArr;
            try {
                iArr[Privacy.Level.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ua$sdk$privacy$Privacy$Level[Privacy.Level.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ua$sdk$privacy$Privacy$Level[Privacy.Level.PUBLIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PrivacyImpl getPrivacy(Privacy.Level level) {
        int i = AnonymousClass1.$SwitchMap$com$ua$sdk$privacy$Privacy$Level[level.ordinal()];
        if (i == 1) {
            return new PrivacyImpl(Privacy.Level.PRIVATE, DESC_PRIVATE);
        }
        if (i == 2) {
            return new PrivacyImpl(Privacy.Level.FRIENDS, DESC_FRIENDS);
        }
        if (i == 3) {
            return new PrivacyImpl(Privacy.Level.PUBLIC, DESC_PUBLIC);
        }
        UaLog.error("This state is not supported.");
        return null;
    }

    public static Privacy.Level getLevelFromId(int i) {
        if (i == 0) {
            return Privacy.Level.PRIVATE;
        }
        if (i == 1) {
            return Privacy.Level.FRIENDS;
        }
        if (i == 3) {
            return Privacy.Level.PUBLIC;
        }
        UaLog.error("This ID is not supported.");
        return null;
    }

    public static Privacy getPrivacyFromId(int i) {
        Privacy.Level levelFromId = getLevelFromId(i);
        if (levelFromId != null) {
            return getPrivacy(levelFromId);
        }
        return null;
    }

    public static Link toLink(Privacy.Level level, String str) {
        return new Link(String.format(UrlBuilderImpl.GET_PRIVACY_URL, Integer.valueOf(level.id)), String.valueOf(level.id), str);
    }

    public static Link toLink(Privacy.Level level) {
        return new Link(String.format(UrlBuilderImpl.GET_PRIVACY_URL, Integer.valueOf(level.id)), String.valueOf(level.id));
    }
}
