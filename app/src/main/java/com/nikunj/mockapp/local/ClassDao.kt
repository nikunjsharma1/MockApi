package com.nikunj.mockapp.local

import androidx.room.*

@Dao
interface ClassDao {
    @Insert
    suspend fun addClass(classesEntity: ClassesEntity)

    @Query("SELECT * FROM ClassesEntity ORDER BY id DESC")
    fun getAllClass(): List<ClassesEntity>

    @Delete
  fun deleteClass(classesEntity: ClassesEntity)
}