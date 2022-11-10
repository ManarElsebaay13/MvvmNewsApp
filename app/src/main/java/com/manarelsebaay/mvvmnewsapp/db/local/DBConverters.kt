package com.manarelsebaay.mvvmnewsapp.db.local

import androidx.room.TypeConverter
import com.manarelsebaay.mvvmnewsapp.model.Source


 class DBConverters {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }


}