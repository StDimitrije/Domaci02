package com.example.domaci02;

public class User {

    private int mId;
    private String mFname;
    private String mImgUrl;

    public User (int id, String first_name) {

        this(id, first_name, "https://picsum.photos/300/300/?random");
    }

    public User(int id, String first_name, String imgUrl) {
        mId=id;
        mFname=first_name;
        mImgUrl=imgUrl;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public void setmImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmFname() {
        return mFname;
    }

    public void setmFname(String mFname) {
        this.mFname = mFname;
    }

}

