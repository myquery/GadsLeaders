package com.example.gadsleaders;

import android.os.Parcel;
import android.os.Parcelable;

public class SkillLeader implements Parcelable {

    public static final Creator<SkillLeader> CREATOR = new Creator<SkillLeader>() {
        @Override
        public SkillLeader createFromParcel(Parcel in) {
            return new SkillLeader(in);
        }

        @Override
        public SkillLeader[] newArray(int size) {
            return new SkillLeader[size];
        }
    };
    private String name;
    private int score;
    private String country;
    private String badgeUrl;

    public SkillLeader(String name, int hours, String country, String badgeUrl) {
        this.name = name;
        this.score = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }


    protected SkillLeader(Parcel in) {
        name = in.readString();
        score = in.readInt();
        country = in.readString();
        badgeUrl = in.readString();
    }

    public static Creator<SkillLeader> getCREATOR() {
        return CREATOR;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(score);
        parcel.writeString(country);
        parcel.writeString(badgeUrl);
    }
}
