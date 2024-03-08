package com.example.exam_compose.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val searchToken:String,
    val userId:Int
)
