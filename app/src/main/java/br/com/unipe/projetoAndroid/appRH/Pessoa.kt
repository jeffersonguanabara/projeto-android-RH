package br.com.unipe.projetoAndroid.appRH

import android.os.Parcel
import android.os.Parcelable



class Pessoa (var cpf : String? = "", var nome : String? = "", var email : String? = " ",
              var userName : String? = "", var senha : String? = "") : Parcelable {

    constructor(parcel : Parcel) : this (
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun toString(): String {
        return "CPF: ${cpf} \n NOME: ${nome} \n EMAIL: ${email} \n USERNAME: ${userName} \n SENHA: ${senha}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cpf)
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeString(userName)
        parcel.writeString(senha)
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