package com.mx.terryrockstar.lactaguia.main.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Topic(
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: Int,
        @SerializedName("image") val image: Int,
        @SerializedName("subtopics") val subtopics: MutableList<SubTopic>,
        @SerializedName("text") val text: Int): Parcelable

@Parcelize
data class SubTopic(
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: Int,
        @SerializedName("text") val text: Int): Parcelable
