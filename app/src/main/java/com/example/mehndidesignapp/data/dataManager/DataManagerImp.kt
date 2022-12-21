package com.example.mehndidesignapp.data.dataManager

import androidx.lifecycle.LiveData
import com.example.mehndidesignapp.model.HomePageModelClass
import com.example.mehndidesignapp.model.SelectedDesignModelClass


interface DataManagerImp {
    fun getAllFavouriteData(): LiveData<List<SelectedDesignModelClass>>
    fun insertRecord(selectedDesignModelClass: SelectedDesignModelClass)
    fun getAllDataHomePage(): ArrayList<HomePageModelClass>
    fun getAllDataBackHand(): ArrayList<SelectedDesignModelClass>
    fun getAllDataArm(): ArrayList<SelectedDesignModelClass>
    fun getAllDataFrontHand(): ArrayList<SelectedDesignModelClass>
    fun getAllDataGolTikki(): ArrayList<SelectedDesignModelClass>
    fun getAllDataFinger(): ArrayList<SelectedDesignModelClass>
    fun getAllDataFoot(): ArrayList<SelectedDesignModelClass>
    fun getAllDataWedding(): ArrayList<SelectedDesignModelClass>
    fun getAllDataEidSpecial(): ArrayList<SelectedDesignModelClass>


}
