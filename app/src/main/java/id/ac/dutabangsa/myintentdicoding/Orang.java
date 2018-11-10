package id.ac.dutabangsa.myintentdicoding;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Triyono on 11/10/2018.
 */
public class Orang implements Parcelable {
    private String nama;
    private int umur;
    private String email;
    private String Kota;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKota() {
        return Kota;
    }

    public void setKota(String kota) {
        Kota = kota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.umur);
        dest.writeString(this.email);
        dest.writeString(this.Kota);
    }

    public Orang() {
    }

    protected Orang(Parcel in) {
        this.nama = in.readString();
        this.umur = in.readInt();
        this.email = in.readString();
        this.Kota = in.readString();
    }

    public static final Parcelable.Creator<Orang> CREATOR = new Parcelable.Creator<Orang>() {
        @Override
        public Orang createFromParcel(Parcel source) {
            return new Orang(source);
        }

        @Override
        public Orang[] newArray(int size) {
            return new Orang[size];
        }
    };
}
