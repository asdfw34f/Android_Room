package com.example.exam_compose.model.repository

import com.example.exam_compose.model.entities.User

interface IUserRepository {

    fun getUserByBasicAuthentication(username:String, password:String):User

    suspend fun insert(user:User)
}