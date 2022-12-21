package com.example.mehndidesignapp.viewModels

import androidx.lifecycle.ViewModel
import com.example.mehndidesignapp.data.dataManager.DataManager
import com.example.mehndidesignapp.model.HomePageModelClass
import com.example.mehndidesignapp.model.SelectedDesignModelClass

class SelectedDesignViewModel : ViewModel() {

    var selectedDesignListData: ArrayList<HomePageModelClass>
    var backHandListData: ArrayList<SelectedDesignModelClass>
    var frontHandListData: ArrayList<SelectedDesignModelClass>
    var armListData: ArrayList<SelectedDesignModelClass>
    var weddingListData: ArrayList<SelectedDesignModelClass>
    var eidSpecialListData: ArrayList<SelectedDesignModelClass>
    var golTikkiListData: ArrayList<SelectedDesignModelClass>
    var fingerListData: ArrayList<SelectedDesignModelClass>
    var footListData: ArrayList<SelectedDesignModelClass>

    var dataManager = DataManager

    init {
        selectedDesignListData = dataManager.getAllDataHomePage()
        backHandListData = dataManager.getAllDataBackHand()
        frontHandListData = dataManager.getAllDataFrontHand()
        armListData = dataManager.getAllDataArm()
        weddingListData = dataManager.getAllDataWedding()
        eidSpecialListData = dataManager.getAllDataEidSpecial()
        golTikkiListData = dataManager.getAllDataGolTikki()
        fingerListData = dataManager.getAllDataFinger()
        footListData = dataManager.getAllDataFoot()


    }


}
