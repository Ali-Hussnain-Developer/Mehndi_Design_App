package com.example.mehndidesignapp.data.dataManager


import androidx.lifecycle.LiveData
import com.example.mehndidesignapp.R
import com.example.mehndidesignapp.contextClass.ContextClass
import com.example.mehndidesignapp.data.localRepository.AppDatabase
import com.example.mehndidesignapp.model.HomePageModelClass
import com.example.mehndidesignapp.model.SelectedDesignModelClass

object DataManager : DataManagerImp {
    override fun insertRecord(selectedDesignModelClass: SelectedDesignModelClass) {
        AppDatabase.getDatabase().userDao().insertRecord(selectedDesignModelClass)
    }

    override fun getAllFavouriteData(): LiveData<List<SelectedDesignModelClass>> {
        val list: LiveData<List<SelectedDesignModelClass>>
        list = AppDatabase.getDatabase().userDao().getAllData()
        return list
    }

    override fun getAllDataHomePage(): ArrayList<HomePageModelClass> {
        val homePageDataList = ArrayList<HomePageModelClass>()
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_back_hand),
            R.drawable.back_hand_seven))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_front_hand),
            R.drawable.front_hand_one))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_Gol_Tikki),
            R.drawable.gol_tikki_eight))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_finger),
            R.drawable.finger_seven))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_arm),
            R.drawable.arm_five))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_foot),
            R.drawable.foot_six))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_wedding),
            R.drawable.wedding_six))
        homePageDataList.add(HomePageModelClass(ContextClass.getContext()
            .getString(R.string.txt_eid_special),
            R.drawable.eid_one))
        return homePageDataList

    }

    override fun getAllDataBackHand(): ArrayList<SelectedDesignModelClass> {
        val backHandDataList = ArrayList<SelectedDesignModelClass>()
        backHandDataList.add(SelectedDesignModelClass(0, R.drawable.back_hand_pic_one))
        backHandDataList.add(SelectedDesignModelClass(0, R.drawable.back_hand_pic_two))
        backHandDataList.add(SelectedDesignModelClass(0, R.drawable.back_hand_three))
        backHandDataList.add(SelectedDesignModelClass(0, R.drawable.back_hand_four))
        backHandDataList.add(SelectedDesignModelClass(0, R.drawable.back_hand_five))
        backHandDataList.add(SelectedDesignModelClass(0, R.drawable.back_hand_six))



        return backHandDataList

    }

    override fun getAllDataArm(): ArrayList<SelectedDesignModelClass> {
        val armDataList = ArrayList<SelectedDesignModelClass>()
        armDataList.add(SelectedDesignModelClass(0, R.drawable.arm_four))
        armDataList.add(SelectedDesignModelClass(0, R.drawable.arm_three))
        armDataList.add(SelectedDesignModelClass(0, R.drawable.arm_two))
        armDataList.add(SelectedDesignModelClass(0, R.drawable.arm_one))
        armDataList.add(SelectedDesignModelClass(0, R.drawable.arm_six))




        return armDataList
    }

    override fun getAllDataFrontHand(): ArrayList<SelectedDesignModelClass> {
        val frontHandDataList = ArrayList<SelectedDesignModelClass>()
        frontHandDataList.add(SelectedDesignModelClass(0, R.drawable.front_hand_one))
        frontHandDataList.add(SelectedDesignModelClass(0, R.drawable.front_hand_two))
        frontHandDataList.add(SelectedDesignModelClass(0, R.drawable.front_hand_three))
        frontHandDataList.add(SelectedDesignModelClass(0, R.drawable.front_hand_four))
        frontHandDataList.add(SelectedDesignModelClass(0, R.drawable.front_hand_five))
        frontHandDataList.add(SelectedDesignModelClass(0, R.drawable.front_hand_six))

        return frontHandDataList
    }

    override fun getAllDataGolTikki(): ArrayList<SelectedDesignModelClass> {
        val golTikkiDataList = ArrayList<SelectedDesignModelClass>()
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_one))
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_two))
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_three))
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_six))
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_seven))
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_eight))
        golTikkiDataList.add(SelectedDesignModelClass(0, R.drawable.gol_tikki_nine))

        return golTikkiDataList
    }

    override fun getAllDataFinger(): ArrayList<SelectedDesignModelClass> {
        val fingerDataList = ArrayList<SelectedDesignModelClass>()
        fingerDataList.add(SelectedDesignModelClass(0, R.drawable.finger_one))
        fingerDataList.add(SelectedDesignModelClass(0, R.drawable.finger_two))
        fingerDataList.add(SelectedDesignModelClass(0, R.drawable.finger_three))
        fingerDataList.add(SelectedDesignModelClass(0, R.drawable.finger_six))
        fingerDataList.add(SelectedDesignModelClass(0, R.drawable.finger_seven))

        return fingerDataList
    }

    override fun getAllDataFoot(): ArrayList<SelectedDesignModelClass> {
        val footDataList = ArrayList<SelectedDesignModelClass>()
        footDataList.add(SelectedDesignModelClass(0, R.drawable.foot_one))
        footDataList.add(SelectedDesignModelClass(0, R.drawable.foot_two))
        footDataList.add(SelectedDesignModelClass(0, R.drawable.foot_three))
        footDataList.add(SelectedDesignModelClass(0, R.drawable.foot_four))
        footDataList.add(SelectedDesignModelClass(0, R.drawable.foot_five))
        return footDataList
    }

    override fun getAllDataWedding(): ArrayList<SelectedDesignModelClass> {
        val weddingDataList = ArrayList<SelectedDesignModelClass>()
        weddingDataList.add(SelectedDesignModelClass(0, R.drawable.wedding_one))
        weddingDataList.add(SelectedDesignModelClass(0, R.drawable.wedding_two))
        weddingDataList.add(SelectedDesignModelClass(0, R.drawable.wedding_three))
        weddingDataList.add(SelectedDesignModelClass(0, R.drawable.wedding_seven))
        weddingDataList.add(SelectedDesignModelClass(0, R.drawable.wedding_six))
        weddingDataList.add(SelectedDesignModelClass(0, R.drawable.wedding_eight))
        return weddingDataList
    }

    override fun getAllDataEidSpecial(): ArrayList<SelectedDesignModelClass> {
        val eidSpecialDataList = ArrayList<SelectedDesignModelClass>()
        eidSpecialDataList.add(SelectedDesignModelClass(0, R.drawable.eid_one))
        eidSpecialDataList.add(SelectedDesignModelClass(0, R.drawable.eid_two))
        eidSpecialDataList.add(SelectedDesignModelClass(0, R.drawable.eid_three))
        eidSpecialDataList.add(SelectedDesignModelClass(0, R.drawable.eid_six))
        eidSpecialDataList.add(SelectedDesignModelClass(0, R.drawable.eid_seven))
        return eidSpecialDataList
    }


}







