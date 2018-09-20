package com.example.ashish.task.model

import android.os.Parcel
import android.os.Parcelable

class RowData() : Parcelable {


    var title: String = ""
    var description: String = ""
    var imageHref: String = ""

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        description = parcel.readString()
        imageHref = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(imageHref)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RowData> {
        override fun createFromParcel(parcel: Parcel): RowData {
            return RowData(parcel)
        }

        override fun newArray(size: Int): Array<RowData?> {
            return arrayOf(RowData())
        }


    }


}