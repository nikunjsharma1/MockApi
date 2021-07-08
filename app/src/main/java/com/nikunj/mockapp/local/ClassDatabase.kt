package com.nikunj.mockapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [ClassesEntity::class],
    version = 1
)
abstract class ClassDatabase: RoomDatabase() {
    abstract  fun getClassDao():ClassDao
    companion object{
        @Volatile private var instance : ClassDatabase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance=it
            }

        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            ClassDatabase::class.java,
            "notedatabase"
        ).build()
    }
}