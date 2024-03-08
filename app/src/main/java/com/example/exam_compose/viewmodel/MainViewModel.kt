package com.example.exam_compose.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.exam_compose.model.AviaDatabase
import com.example.exam_compose.model.entities.Avia
import com.example.exam_compose.model.entities.User
import com.example.exam_compose.model.repository.AviaRepository
import com.example.exam_compose.model.repository.FavoriteRepository
import com.example.exam_compose.model.repository.IAviaRepository
import com.example.exam_compose.model.repository.IFavoriteRepository
import com.example.exam_compose.model.repository.IUserRepository
import com.example.exam_compose.model.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class MainViewModel(application: Application):ViewModel() {
    val allAvia: Flow<List<Avia>>
    lateinit var favorite: Flow<List<Avia>>
    lateinit var currentUser:User

    val aviaRepository:IAviaRepository
    val userRepository:IUserRepository
    val favoriteRepository:IFavoriteRepository

    init {
        val db = AviaDatabase.getDb(application.applicationContext)
        val aviaDao = db.getAviaDao()
        val userDao = db.getUserDao()
        val favoriteDao = db.getFavoriteDao()

        aviaRepository = AviaRepository(aviaDao)
        userRepository = UserRepository(userDao)
        favoriteRepository = FavoriteRepository(favoriteDao)

        allAvia = aviaRepository.getAll()
    }

    suspend fun login(username:String, password:String){
        currentUser = userRepository.getUserByBasicAuthentication(username, password)

        val listFavorite = favoriteRepository.getById(currentUser.id)

        listFavorite.collect{list->
            for (item in list){
                favorite.collect{list->
                    for(item in list){
                        favorite.flatMapConcat { originalList->
                            originalList.map {
                                flowOf(
                                    aviaRepository.getAvia(
                                        item.searchToken
                                    )
                                )
                            }.asFlow()
                        }
                    }
                }
            }
        }
    }
}