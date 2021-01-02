package com.nytimesarticles.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Media(

	@SerializedName("type") val type: String?,
	@SerializedName("subtype") val subtype: String?,
	@SerializedName("caption") val caption: String?,
	@SerializedName("copyright") val copyright: String?,
	@SerializedName("approved_for_syndication") val approved_for_syndication: Int,
	@SerializedName("media-metadata") val media_metadata: List<MediaMetadata>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readInt(),
		parcel.createTypedArrayList(MediaMetadata)
	) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(subtype)
        parcel.writeString(caption)
        parcel.writeString(copyright)
        parcel.writeInt(approved_for_syndication)
        parcel.writeTypedList(media_metadata)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}