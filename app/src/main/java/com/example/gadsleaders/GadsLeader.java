package com.example.gadsleaders;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;


public class GadsLeader implements Parcelable {
    private String name;
    public static final Creator<GadsLeader> CREATOR = new Creator<GadsLeader>() {
        @Override
        public GadsLeader createFromParcel(Parcel in) {
            return new GadsLeader(in);
        }

        @Override
        public GadsLeader[] newArray(int size) {
            return new GadsLeader[size];
        }
    };
    private String country;
    private String badgeUrl;
    private String hours;

    public GadsLeader(String name, String hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    protected GadsLeader(Parcel in) {
        name = in.readString();
        hours = in.readString();
        country = in.readString();
        badgeUrl = in.readString();
    }

    public String getName() {
        return name;
    }

    public String getHours() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    @Override
    public String toString() {
        return "GadsLeader{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", country='" + country + '\'' +
                ", badgeUrl=" + badgeUrl +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(hours);
        parcel.writeString(country);
        parcel.writeString(badgeUrl);
    }
}
