package com.nikunj.mockapp.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ClassesEntity(
    val dose: String,
    val name: String ,
    val strength: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}