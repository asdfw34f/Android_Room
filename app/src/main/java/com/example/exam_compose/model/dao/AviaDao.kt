package com.example.exam_compose.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exam_compose.model.entities.Avia

@Dao
interface AviaDao {
    @Query("SELECT * FROM Avia")
    fun getAll():List<Avia>

    @Query("SELECT * FROM Avia WHERE searchToken LIKE (:search)")
    fun getAvia(search:String):Avia

    @Insert
    fun insert(vararg avia: Avia)
}