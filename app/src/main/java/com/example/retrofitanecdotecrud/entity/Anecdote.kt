package com.example.retrofitanecdotecrud.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Anecdote (
    val site: String,
    val name: String,
    val desc: String,
    val link: String?,
    val elementPureHtml: String,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
) : Parcelable