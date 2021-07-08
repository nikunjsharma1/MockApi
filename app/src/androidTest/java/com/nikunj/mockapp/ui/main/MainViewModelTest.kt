package com.nikunj.mockapp.ui.main


import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.getOrAwait
import com.google.common.truth.Truth.assertThat
import com.nikunj.mockapp.local.ClassDao
import com.nikunj.mockapp.local.ClassDatabase
import com.nikunj.mockapp.local.ClassesEntity
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.checkerframework.checker.fenum.qual.AwtAlphaCompositingRule
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Rule

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest : TestCase() {
    private lateinit var db :ClassDatabase
    private lateinit var dao: ClassDao
    private lateinit var viewModel: MainViewModel
    val context =ApplicationProvider.getApplicationContext<Context>()


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
   public override fun setUp() {
        super.setUp()
        viewModel= MainViewModel()
        db = Room.inMemoryDatabaseBuilder(context, ClassDatabase::class.java).build()
        dao = db.getClassDao()
    }
    @Test
    fun testViewModel(){

        viewModel.getAllClasses(context)
       val result= viewModel.savedClassList.getOrAwait().find {
            it.dose == "" && it.name=="asprin" && it.strength == "500 mg"
        }
        assertThat(result!=null).isTrue()
    }
}