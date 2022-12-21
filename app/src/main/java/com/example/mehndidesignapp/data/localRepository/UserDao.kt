package com.example.mehndidesignapp.data.localRepository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mehndidesignapp.model.SelectedDesignModelClass

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(selectedDesignModelClass: SelectedDesignModelClass)

    @Query("SELECT *FROM userTable")
    fun getAllData(): LiveData<List<SelectedDesignModelClass>>

}