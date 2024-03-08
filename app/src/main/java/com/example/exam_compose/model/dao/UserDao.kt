package com.example.exam_compose.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.model.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE login LIKE (:username) AND password LIKE (:password)")
    fun getUserByBasicAuthentication(username:String, password:String): User

    @Insert
    fun insert(user:User)

}