package com.example.mati.parceablesearializable;

/**
 * Created by mati on 11/02/16.
 */
import android.os.Parcel;
import android.os.Parcelable;


public class ClaseParceable implements Parcelable{
    private String nombre;
    private int id;





    public static final Parcelable.Creator<ClaseParceable> CREATOR = new Parcelable.Creator<ClaseParceable>() {
        @Override
        public ClaseParceable createFromParcel(Parcel source) {
            ClaseParceable obj = new ClaseParceable();
            obj.nombre = source.readString();
            obj.id = source.readInt();

            return obj;
        }

        @Override
        public ClaseParceable[] newArray(int size) {
            return new ClaseParceable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(id);
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
}