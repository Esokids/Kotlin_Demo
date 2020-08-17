package com.example.mykotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


//data class Person(var name: String, var age: Int) : Serializable

@Parcelize
data class Person(var name: String, var age: Int) : Parcelable