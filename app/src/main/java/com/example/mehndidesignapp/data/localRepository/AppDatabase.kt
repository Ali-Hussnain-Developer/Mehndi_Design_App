package com.example.mehndidesignapp.data.localRepository

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mehndidesignapp.constants.Constants
import com.example.mehndidesignapp.contextClass.ContextClass
import com.example.mehndidesignapp.model.SelectedDesignModelClass


@Database(entities = [SelectedDesignModelClass::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ContextClass.getContext(),
                    AppDatabase::class.java,
                    Constants.ROOM_DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}