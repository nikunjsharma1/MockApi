package com.nikunj.mockapp.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ClassDatabaseTest : TestCase(){
    private lateinit var db :ClassDatabase
    private lateinit var dao: ClassDao

    @Before
   public override fun setUp() {
        val context =ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, ClassDatabase::class.java).build()
        dao = db.getClassDao()
    }
    @After
    fun closeDb(){
       db.close()
    }


    @Test
     fun writeAndRead()= runBlocking{
          val classesEntity=ClassesEntity("22mg","dhdhhd","high")
        dao.addClass(classesEntity)
        val entitys=dao.getAllClass()
        assertThat(entitys.contains(classesEntity)).isTrue()
    }

    @Test
    fun writeAndReadEmpty()= runBlocking{
        val classesEntity=ClassesEntity("","","")
        dao.addClass(classesEntity)
        val entitys=dao.getAllClass()
        assertThat(entitys.contains(classesEntity)).isTrue()
    }
}