package com.example.exam_compose.model.repository

import com.example.exam_compose.model.dao.UserDao
import com.example.exam_compose.model.entities.User

class UserRepository(val dao:UserDao):IUserRepository {
    override fun getUserByBasicAuthentication(username: String, password: String): User = dao.getUserByBasicAuthentication(username, password)

    override suspend fun insert(user: User) = dao.insert(user)
}