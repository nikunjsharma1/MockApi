package com.nikunj.mockapp.ui.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikunj.mockapp.local.ClassDatabase
import com.nikunj.mockapp.local.ClassesEntity
import com.nikunj.mockapp.model.ClassesName
import com.nikunj.mockapp.model.MedicationsClasse
import com.nikunj.mockapp.service.NetworkService
import com.nikunj.mockapp.util.ResponseWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val classList: MutableLiveData<ResponseWrapper<List<ClassesName>>> = MutableLiveData()

    val savedClassList: MutableLiveData<List<ClassesEntity>> = MutableLiveData()

    init {
        getAllClass()
    }

    fun getAllClasses(context: Context) {
        CoroutineScope(IO).launch {
            savedClassList.postValue(ClassDatabase(context).getClassDao().getAllClass())
        }
    }




    private fun getAllClass()
        = viewModelScope.launch{
        classList.postValue(ResponseWrapper.Loading())
            try {
                val response = NetworkService().getResults()
                when{
                    response.isSuccessful->{
                        response.body()?.let {
                            Log.d("mainview",it.toString())
                            classList.postValue(ResponseWrapper.Success(it))
                        }
                    }
                    else -> {
                        classList.postValue(ResponseWrapper.Error(response.message()))
                    }
                }
            } catch (e: Exception){
                classList.postValue(ResponseWrapper.Error("Something went Wrong :"+e.message))
            }

        }

}
