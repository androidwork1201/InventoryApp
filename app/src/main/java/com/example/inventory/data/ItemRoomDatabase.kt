package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 建立數據庫實例*/

/**
 * entities:指定data作為唯一實體
 * version:版本，更改database模式時需要增加
 * exportSchema: 是否保留版本歷史備份*/
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase: RoomDatabase() {

    /**聲明Dao，可有多個加入*/
    abstract fun itemDao(): ItemDao

    /**訪問創建或護取資料庫方法*/
    companion object {

        @Volatile //始終保持最新
        private var INSTANCE: ItemRoomDatabase? = null

        //如INSTANCE為空值則執行初始化，掛上synchronized同步執行
        fun getDatabase(context: Context): ItemRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}