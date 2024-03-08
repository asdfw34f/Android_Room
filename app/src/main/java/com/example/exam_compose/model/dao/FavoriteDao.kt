package com.example.exam_compose.model.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.model.entities.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteDao {
    @Query("SELECT * FROM Favorite WHERE userId LIKE (:userId)")
    fun getById(userId:Int): Flow<List<Favorite>>

    @Insert
    suspend fun insert(favorite: Favorite)

    @Delete
    suspend fun deleteById(id:Int)

}