package com.example.exam_compose.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = Avia::class,
            parentColumns = ["searchToken"],
            childColumns = ["searchToken"]
        )
    ]
)
data class Favorite(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val searchToken:String,
    val userId:Int
)
