package com.shellcore.android.kotlinapplication.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by MOGC on 29/01/2018.
 */
data class Student (var name: String,
                    var lastName : String,
                    var age: Int,
                    var developer: Boolean = true): Parcelable {

    constructor(parcel: Parcel): this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(lastName)
        dest.writeInt(age)
        dest.writeByte(if (developer) 1 else 0)
    }

    override fun describeContents() = 0

    companion object CREATOR: Parcelable.Creator<Student> {

        override fun createFromParcel(source: Parcel) = Student(source)

        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)

    }
}