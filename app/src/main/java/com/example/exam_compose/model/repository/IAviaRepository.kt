package com.example.exam_compose.model.repository

import com.example.exam_compose.model.entities.Avia
import kotlinx.coroutines.flow.Flow

interface IAviaRepository {
    fun getAll(): Flow<List<Avia>>

    fun getAvia(search:String):Avia

    suspend fun insert(avia: Avia)
}