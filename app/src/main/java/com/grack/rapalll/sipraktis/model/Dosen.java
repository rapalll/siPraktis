package com.grack.rapalll.sipraktis.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dosen implements Parcelable {
    private  String  namaDosen, noDosen;
    private int idDosen;

    public Dosen(){

    }

    public int getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(int idDosen) {
        this.idDosen = idDosen;
    }


    public String getNameDosen(){
        return namaDosen;
    }

    public void setNameDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getNoDosen() {
        return noDosen;
    }

    public void setNoDosen(String  noDosen) {
        this.noDosen = noDosen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaDosen);
        dest.writeInt(this.idDosen);
        dest.writeString(this.noDosen);
//        dest.writeString(this.imgSkripsi);

    }

    protected Dosen (Parcel in) {
        this.idDosen = in.readInt();
        this.noDosen = in.readString();
        this.namaDosen = in.readString();
//        this.imgSkripsi = in.readString();
    }

    public static final Creator<Dosen> CREATOR = new Creator<Dosen>() {
        @Override
        public Dosen createFromParcel(Parcel source) {
            return new Dosen(source);
        }

        @Override
        public Dosen[] newArray(int size) {
            return new Dosen[size];
        }
    };


}
