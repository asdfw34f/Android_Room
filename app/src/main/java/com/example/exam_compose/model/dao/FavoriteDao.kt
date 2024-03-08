package com.example.exam_compose.model.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.model.entities.Favorite

interface FavoriteDao {
    @Query("SELECT * FROM Favorite WHERE userId LIKE (:userId)")
    fun getById(userId:Int):List<Favorite>

    @Insert
    fun insert(favorite: Favorite)

    @Delete
    fun deleteById(id:Int)

}