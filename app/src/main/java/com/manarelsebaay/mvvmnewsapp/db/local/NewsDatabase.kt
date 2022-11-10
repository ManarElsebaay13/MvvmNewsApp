package com.manarelsebaay.mvvmnewsapp.db.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manarelsebaay.mvvmnewsapp.model.Article


@Database (
    entities = [Article::class],
    version = 1
        )

@TypeConverters ( DBConverters::class)

abstract class NewsDatabase  : RoomDatabase(){

     // GET DAO
    abstract fun getNewsDAO () : NewsDAO


    companion object{

        //GET DB INSTANCE
        @Volatile
        private var instance: NewsDatabase? = null


        //Syncronize DB calling

        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }


        //  CREATE DB
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "news_db.db"
            ).build() }


}





