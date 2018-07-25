package io.jmdg.jetpackstarterkt.repository.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

/**
 * Room Database
 * @Entity: Creation of table (eg. table of users)
 * @PrimaryKey: Determines the unique & incrementing id in the table
 * @ColumnInfo: Column name of a the specific object field
 *
 * gson Annotations
 * @SerializedName: Maps field specific key from the remote response
 *
 */
@Entity(tableName = "users")
data class User(
        @PrimaryKey
        val uid: Int,
        @ColumnInfo(name = "id")
        @SerializedName("id")
        var id: Int,
        @ColumnInfo(name = "username")
        @SerializedName("username")
        var username: String,
        @ColumnInfo(name = "primary_email")
        @SerializedName("primary_email")
        var primaryEmail: String,
        @ColumnInfo(name = "first_name")
        @SerializedName("first_name")
        var firstName: String,
        @ColumnInfo(name = "last_name")
        @SerializedName("last_name")
        var lastName: String,
        @ColumnInfo(name = "token")
        @SerializedName("token")
        var token: String
)