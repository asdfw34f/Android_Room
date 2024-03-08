package com.example.exam_compose.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.model.entities.Avia
import kotlinx.coroutines.flow.Flow

@Dao
interface AviaDao {
    @Query("SELECT * FROM Avia")
    fun getAll(): Flow<List<Avia>>

    @Query("SELECT * FROM Avia WHERE searchToken LIKE (:search)")
    fun getAvia(search:String):Avia

    @Insert
    suspend fun insert(avia: Avia)
}