package com.example.handleliste

import android.os.Parcel
import android.os.Parcelable

data class Tjeneste(val image:Int , val name:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tjeneste> {
        override fun createFromParcel(parcel: Parcel): Tjeneste {
            return Tjeneste(parcel)
        }

        override fun newArray(size: Int): Array<Tjeneste?> {
            return arrayOfNulls(size)
        }
    }
}
