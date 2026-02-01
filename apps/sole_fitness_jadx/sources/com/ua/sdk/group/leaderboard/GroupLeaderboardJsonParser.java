package com.ua.sdk.group.leaderboard;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ua.sdk.UaException;
import com.ua.sdk.internal.AbstractGsonParser;
import com.ua.sdk.net.json.GsonFactory;

/* loaded from: classes2.dex */
public class GroupLeaderboardJsonParser extends AbstractGsonParser<GroupLeaderboard> {
    public GroupLeaderboardJsonParser() {
        super(GsonFactory.newGroupInstance());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.internal.AbstractGsonParser
    public GroupLeaderboard read(Gson gson, JsonReader jsonReader) throws UaException {
        return (GroupLeaderboard) gson.fromJson(jsonReader, GroupLeaderboard.class);
    }
}
