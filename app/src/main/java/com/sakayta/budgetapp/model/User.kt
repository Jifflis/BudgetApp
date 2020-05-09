package com.sakayta.budgetapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user")
class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "email")
    var email:String,

    @ColumnInfo(name="username")
    var username:String,

    @ColumnInfo(name = "pic_path")
    var pic_path:String

) : Parcelable {

    override fun toString(): String {
        return "User(id=$id, email='$email', username='$username', pic_path='$pic_path')"
    }
}