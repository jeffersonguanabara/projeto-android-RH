package br.com.unipe.projetoAndroid.appRH.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pessoa")
class Pessoa() :Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
    var cpf : String? = null
    var nome : String? = null
    var email : String? = null
    var userName : String? = null
    var senha : String? = null
    var ehAdmin: Long = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        cpf = parcel.readString()
        nome = parcel.readString()
        email = parcel.readString()
        userName = parcel.readString()
        senha = parcel.readString()
        ehAdmin = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(cpf)
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeString(userName)
        parcel.writeString(senha)
        parcel.writeLong(ehAdmin)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pessoa> {
        override fun createFromParcel(parcel: Parcel): Pessoa {
            return Pessoa(parcel)
        }

        override fun newArray(size: Int): Array<Pessoa?> {
            return arrayOfNulls(size)
        }
    }


}