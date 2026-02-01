package com.dyaco.sole.database;

/* loaded from: classes.dex */
public class PostData {
    public static final String POST_DATA = "post_data";
    public static final String POST_ID = "post_id";
    public static final String POST_TB_NAME = "post";
    public static final String POST_TYPE = "post_type";
    private String postData;
    private int postId;
    private int postType;

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int i) {
        this.postId = i;
    }

    public int getPostType() {
        return this.postType;
    }

    public void setPostType(int i) {
        this.postType = i;
    }

    public String getPostData() {
        return this.postData;
    }

    public void setPostData(String str) {
        this.postData = str;
    }
}
