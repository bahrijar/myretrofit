package com.bahrijar.myretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable {

    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("foto")
    private String foto;
    @SerializedName("id_admin")
    private Integer idAdmin;
    @SerializedName("id_carousel")
    private Integer idCarousel;
    @SerializedName("id_user")
    private Integer idUser;
    @SerializedName("is_aktif")
    private Integer isAktif;
    @SerializedName("judul")
    private String judul;
    @SerializedName("nama_user")
    private String namaUser;
    @SerializedName("status")
    private Integer status;

    protected Data(Parcel in) {
        deskripsi = in.readString();
        foto = in.readString();
        if (in.readByte() == 0) {
            idAdmin = null;
        } else {
            idAdmin = in.readInt();
        }
        if (in.readByte() == 0) {
            idCarousel = null;
        } else {
            idCarousel = in.readInt();
        }
        if (in.readByte() == 0) {
            idUser = null;
        } else {
            idUser = in.readInt();
        }
        if (in.readByte() == 0) {
            isAktif = null;
        } else {
            isAktif = in.readInt();
        }
        judul = in.readString();
        namaUser = in.readString();
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        tanggal = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdCarousel() {
        return idCarousel;
    }

    public void setIdCarousel(Integer idCarousel) {
        this.idCarousel = idCarousel;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIsAktif() {
        return isAktif;
    }

    public void setIsAktif(Integer isAktif) {
        this.isAktif = isAktif;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Data(String deskripsi, String foto, Integer idAdmin, Integer idCarousel, Integer idUser, Integer isAktif, String judul, String namaUser, Integer status, String tanggal) {
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.idAdmin = idAdmin;
        this.idCarousel = idCarousel;
        this.idUser = idUser;
        this.isAktif = isAktif;
        this.judul = judul;
        this.namaUser = namaUser;
        this.status = status;
        this.tanggal = tanggal;
    }

    @SerializedName("tanggal")
    private String tanggal;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(deskripsi);
        parcel.writeString(foto);
        if (idAdmin == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(idAdmin);
        }
        if (idCarousel == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(idCarousel);
        }
        if (idUser == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(idUser);
        }
        if (isAktif == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(isAktif);
        }
        parcel.writeString(judul);
        parcel.writeString(namaUser);
        if (status == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(status);
        }
        parcel.writeString(tanggal);
    }
}
