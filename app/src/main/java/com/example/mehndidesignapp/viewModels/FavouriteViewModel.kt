package com.example.mehndidesignapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mehndidesignapp.data.dataManager.DataManager
import com.example.mehndidesignapp.model.SelectedDesignModelClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FavouriteViewModel() : ViewModel() {
    var allUserFavouriteData: LiveData<List<SelectedDesignModelClass>>
    var dataManager = DataManager

    init {
        allUserFavouriteData = dataManager.getAllFavouriteData()
    }

    fun insertRecord(selectedDesignModelClass: SelectedDesignModelClass) =
        viewModelScope.launch(Dispatchers.IO) {
            dataManager.insertRecord(selectedDesignModelClass)
        }
}
