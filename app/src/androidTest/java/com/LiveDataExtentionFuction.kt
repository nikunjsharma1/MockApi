package com

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun<T> MutableLiveData<T>.getOrAwait(): T {
    var data : T ? =null
    val latch =CountDownLatch(1)

    val observer =object :Observer<T>{
        override fun onChanged(t: T) {
            data = t
            this@getOrAwait.removeObserver(this)
            latch.countDown()
        }

    }
    this.observeForever(observer)
    try{
    if(!latch.await(2,TimeUnit.SECONDS)){
        throw TimeoutException("Live data never get value")
    }
        }finally {
            this.removeObserver(observer)
        }
    return data as T
}