package com.grack.rapalll.sipraktis.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dosen implements Parcelable {

  private String namaDosen, panduanSkripsi;
  private int noDosen;

  public Dosen(String namaDosen, String panduanSkripsi, int noDosen) {
    this.namaDosen = namaDosen;
    this.panduanSkripsi = panduanSkripsi;
    this.noDosen = noDosen;
  }

  public Dosen() {
  }

  protected Dosen(Parcel in) {
    namaDosen = in.readString();
    panduanSkripsi = in.readString();
    noDosen = in.readInt();
  }

  public static final Creator<Dosen> CREATOR = new Creator<Dosen>() {
    @Override
    public Dosen createFromParcel(Parcel in) {
      return new Dosen(in);
    }

    @Override
    public Dosen[] newArray(int size) {
      return new Dosen[size];
    }
  };

  public String getNamaDosen() {
    return namaDosen;
  }

  public void setNamaDosen(String namaDosen) {
    this.namaDosen = namaDosen;
  }

  public String getPanduanSkripsi() {
    return panduanSkripsi;
  }

  public void setPanduanSkripsi(String panduanSkripsi) {
    this.panduanSkripsi = panduanSkripsi;
  }

  public int getNoDosen() {
    return noDosen;
  }

  public void setNoDosen(int noDosen) {
    this.noDosen = noDosen;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(namaDosen);
    dest.writeString(panduanSkripsi);
    dest.writeInt(noDosen);
  }

  //    private  String  namaDosen, noDosen;
//    private int idDosen;
//
//    public Dosen(String namaDosen, String noDosen, int idDosen) {
//        this.namaDosen = namaDosen;
//        this.noDosen = noDosen;
//        this.idDosen = idDosen;
//    }
//
//    public Dosen(){
//
//    }
//
//    public int getIdDosen() {
//        return idDosen;
//    }
//
//    public void setIdDosen(int idDosen) {
//        this.idDosen = idDosen;
//    }
//
//
//    public String getNameDosen(){
//        return namaDosen;
//    }
//
//    public void setNameDosen(String namaDosen) {
//        this.namaDosen = namaDosen;
//    }
//
//    public String getNoDosen() {
//        return noDosen;
//    }
//
//    public void setNoDosen(String  noDosen) {
//        this.noDosen = noDosen;
//    }
//
////    public String getImgSkripsi(){
////        return imgSkripsi;
////    }
////
////    public void setImgSkripsi(String imgSkrips) {
////        this.imgSkripsi = imgSkrips;
////    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(this.namaDosen);
//        dest.writeInt(this.idDosen);
//        dest.writeString(this.noDosen);
////        dest.writeString(this.imgSkripsi);
//
//    }
//
//    protected Dosen (Parcel in) {
//        this.idDosen = in.readInt();
//        this.noDosen = in.readString();
//        this.namaDosen = in.readString();
////        this.imgSkripsi = in.readString();
//    }
//
//    public static final Creator<Dosen> CREATOR = new Creator<Dosen>() {
//        @Override
//        public Dosen createFromParcel(Parcel source) {
//            return new Dosen(source);
//        }
//
//        @Override
//        public Dosen[] newArray(int size) {
//            return new Dosen[size];
//        }
//    };


}
