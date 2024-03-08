package com.example.exam_compose.model.repository

import com.example.exam_compose.model.dao.FavoriteDao
import com.example.exam_compose.model.entities.Favorite
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(val dao:FavoriteDao):IFavoriteRepository {
    override fun getById(userId: Int): Flow<List<Favorite>> = dao.getById(userId)

    override suspend fun insert(favorite: Favorite) = dao.insert(favorite)

    override suspend fun delete(id: Int) = dao.deleteById(id)
}