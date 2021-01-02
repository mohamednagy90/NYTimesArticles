package com.nytimesarticles.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Article(

	@SerializedName("uri") val uri: String?,
	@SerializedName("url") val url: String?,
	@SerializedName("id") val id: Long,
	@SerializedName("asset_id") val asset_id: Long,
	@SerializedName("source") val source: String?,
	@SerializedName("published_date") val published_date: String?,
	@SerializedName("updated") val updated: String?,
	@SerializedName("section") val section: String?,
	@SerializedName("subsection") val subsection: String?,
	@SerializedName("nytdsection") val nytdsection: String?,
	@SerializedName("adx_keywords") val adx_adx_keywordswords: String?,
	@SerializedName("column") val column: String?,
	@SerializedName("byline") val byline: String?,
	@SerializedName("type") val type: String?,
	@SerializedName("title") val title: String?,
	@SerializedName("abstract") val abstract: String?,
	@SerializedName("des_facet") val des_facet: List<String>?,
	@SerializedName("org_facet") val org_facet: List<String>?,
	@SerializedName("per_facet") val per_facet: List<String>?,
	@SerializedName("geo_facet") val geo_facet: List<String>?,
	@SerializedName("media") val media: List<Media>?,
	@SerializedName("eta_id") val eta_id: Long
) : Parcelable {
    constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readLong(),
		parcel.readLong(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.createStringArrayList(),
		parcel.createStringArrayList(),
		parcel.createStringArrayList(),
		parcel.createStringArrayList(),
		parcel.createTypedArrayList(Media),
		parcel.readLong()
	) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uri)
        parcel.writeString(url)
        parcel.writeLong(id)
        parcel.writeLong(asset_id)
        parcel.writeString(source)
        parcel.writeString(published_date)
        parcel.writeString(updated)
        parcel.writeString(section)
        parcel.writeString(subsection)
        parcel.writeString(nytdsection)
        parcel.writeString(adx_adx_keywordswords)
        parcel.writeString(column)
        parcel.writeString(byline)
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeString(abstract)
        parcel.writeStringList(des_facet)
        parcel.writeStringList(org_facet)
        parcel.writeStringList(per_facet)
        parcel.writeStringList(geo_facet)
        parcel.writeTypedList(media)
        parcel.writeLong(eta_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}