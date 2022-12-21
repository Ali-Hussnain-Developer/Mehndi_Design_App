package com.example.mehndidesignapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.mehndidesignapp.data.dataManager.DataManager
import com.example.mehndidesignapp.model.HomePageModelClass


class HomePageViewModel : ViewModel() {

    var homePageListData: ArrayList<HomePageModelClass>
    var dataManager = DataManager

    init {
        homePageListData = dataManager.getAllDataHomePage()
    }


}
