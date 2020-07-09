package com.example.demoretrofit.retrofit;

import android.os.Parcel;
import android.os.Parcelable;

public class DataParcelable implements Parcelable {
    private String name;
    private String sex;
    private String describe;

    public DataParcelable(String name, String sex, String describe) {
        this.name = name;
        this.sex = sex;
        this.describe = describe;
    }

    protected DataParcelable(Parcel in) {
        name = in.readString();
        sex = in.readString();
        describe = in.readString();
    }

    public static final Creator<DataParcelable> CREATOR = new Creator<DataParcelable>() {
        @Override
        public DataParcelable createFromParcel(Parcel in) {
            return new DataParcelable(in);
        }

        @Override
        public DataParcelable[] newArray(int size) {
            return new DataParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeString(describe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "DataParcelable{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
