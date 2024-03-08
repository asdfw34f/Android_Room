package com.example.exam_compose.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exam_compose.model.dao.AviaDao
import com.example.exam_compose.model.dao.FavoriteDao
import com.example.exam_compose.model.dao.UserDao
import com.example.exam_compose.model.entities.Avia
import com.example.exam_compose.model.entities.Favorite
import com.example.exam_compose.model.entities.User

@Database(
    entities = [Avia::class, User::class, Favorite::class],
    version = 1
)
abstract class AviaDatabase: RoomDatabase() {
    abstract fun getUserDao():UserDao
    abstract fun getFavoriteDao():FavoriteDao
    abstract fun getAviaDao():AviaDao
    companion object{
        fun getDb(context:Context):AviaDatabase{
            val db = Room.databaseBuilder(
                context.applicationContext,
                AviaDatabase::class.java,
                "test1.db"
            ).build()
            return db
        }


    }
}