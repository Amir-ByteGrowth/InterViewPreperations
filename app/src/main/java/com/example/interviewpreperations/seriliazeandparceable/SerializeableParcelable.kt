//package com.example.interviewpreperations.seriliazeandparceable
//
//import android.os.Parcel
//import android.os.Parcelable
////import kotlinx.android.parcel.Parcelize
//import java.io.Serializable
//
//class SerializeableParcelable : Serializable {
//}
//
//data class Aclass(val name: String) : Serializable
//
////@Parcelize
//class Item(
//    val title: String,
//    val details: String,
//    val price: Double,
//    val category: String
//) : Parcelable {
//
//    companion object {
//        @JvmField
//        val CREATOR = object : Parcelable.Creator<Item> {
//            override fun createFromParcel(parcel: Parcel) = Item(parcel)
//            override fun newArray(size: Int) = arrayOfNulls<Item>(size)
//        }
//    }
//
//    private constructor(parcel: Parcel) : this(
//        title = parcel.readString()!!,
//        details = parcel.readString()!!,
//        price = parcel.readDouble(),
//        category = parcel.readString()!!
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(title)
//        parcel.writeString(details)
//        parcel.writeDouble(price)
//        parcel.writeString(category)
//    }
//
//    override fun describeContents() = 0
//}