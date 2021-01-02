package com.nytimesarticles.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MediaMetadata(

	@SerializedName("url") val url: String?,
	@SerializedName("format") val format: String?,
	@SerializedName("height") val height: Int,
	@SerializedName("width") val width: Int

) : Parcelable {
    constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readInt(),
		parcel.readInt()
	) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(format)
        parcel.writeInt(height)
        parcel.writeInt(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MediaMetadata> {
        override fun createFromParcel(parcel: Parcel): MediaMetadata {
            return MediaMetadata(parcel)
        }

        override fun newArray(size: Int): Array<MediaMetadata?> {
            return arrayOfNulls(size)
        }
    }
}