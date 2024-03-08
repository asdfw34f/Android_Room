package com.example.exam_compose.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Avia(
    @PrimaryKey(autoGenerate = false) val searchToken:String,
    val startCity:String,
    val startCityCode:String,
    val endCity:String,
    val endCityCode: String,
    val startDate: String,
    val endDate: String,
    val price:Int
)
