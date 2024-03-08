package com.example.exam_compose.model.repository

import com.example.exam_compose.model.dao.AviaDao
import com.example.exam_compose.model.entities.Avia
import kotlinx.coroutines.flow.Flow

class AviaRepository(val dao:AviaDao):IAviaRepository {
    override fun getAll(): Flow<List<Avia>> = dao.getAll()

    override fun getAvia(search: String): Avia = dao.getAvia(search)

    override suspend fun insert(avia: Avia) = dao.insert(avia)
}