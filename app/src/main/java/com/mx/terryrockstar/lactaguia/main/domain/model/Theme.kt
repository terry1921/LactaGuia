package com.mx.terryrockstar.lactaguia.main.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Theme(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: Int,
    @SerializedName("subtitle") val subtitle: Int,
    @SerializedName("image") val image: Int,
    @SerializedName("text") val text: Int): Parcelable
