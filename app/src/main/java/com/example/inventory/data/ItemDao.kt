package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


/**
 * 建立數據訪問對象(資料庫操作(新增、查詢或刪除))
 * */

@Dao
interface ItemDao {

    /**
     * 自訂資料資料庫操作規則
     * */

    //查詢所有值併按名稱排列 ASC升冪排列 DESC降冪排列
    @Query("SELECT * FROM item ORDER BY item_name ASC")
    fun gatItems(): Flow<List<Item>>

    //單筆檢索
    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    //新增資料，並掛上suspend在單獨線程工作，onConflict如果Key已在資料庫中則忽略操作
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    //更新資料
    @Update
    suspend fun update(item: Item)

    //刪除資料
    @Delete
    suspend fun delete(item: Item)







}