package com.example.booksaplicationkotlin.model
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Books")
@Parcelize
data class Record(
    @SerializedName("author_name")
    var authorName: String?,
    @SerializedName("category")
    var category: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("edition")
    var edition: String?,
    @SerializedName("faculty")
    var faculty: String?,
    @SerializedName("ISBN")
    @PrimaryKey
    @NonNull
    var iSBN: String,
    @SerializedName("image")
    var image: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("publisher")
    var publisher: String?,
    @SerializedName("publishing_year")
    var publishingYear: String?,
    @SerializedName("rating")
    var rating: Double?,
    @SerializedName("status")
    var status: String?
):Parcelable/* {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}*/