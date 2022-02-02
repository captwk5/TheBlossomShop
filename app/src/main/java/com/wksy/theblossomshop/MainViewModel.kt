package com.wksy.theblossomshop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var dataLoader = MutableLiveData<ArrayList<ThumbNail>>()

    fun loadDatas(){
        val datas = ArrayList<ThumbNail>()
        datas.add(ThumbNail("test1"))
        datas.add(ThumbNail("test2"))
        datas.add(ThumbNail("test3"))
        dataLoader.postValue(datas)
    }
}