package com.example.exam_compose.model.repository

import com.example.exam_compose.model.entities.Favorite
import kotlinx.coroutines.flow.Flow

interface IFavoriteRepository {
    fun getById(userId:Int): Flow<List<Favorite>>

    suspend fun insert(favorite: Favorite)

    suspend fun delete(id:Int)
}