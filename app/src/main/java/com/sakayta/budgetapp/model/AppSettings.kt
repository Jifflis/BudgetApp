package com.sakayta.budgetapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "app_settings")
class AppSettings(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name =  "reresh_date")
    var refresh_date:String
) : Parcelable {
    override fun toString(): String {
        return "AppSettings(id=$id, refresh_date='$refresh_date')"
    }
}