package com.example.exam_compose.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val login:String,
    val password:String
)
