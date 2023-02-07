package com.example.inventory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

/**
 * 建立Table實體資料
 * */

@Entity(tableName = "item") //創建項目實體
data class Item(
    @PrimaryKey(autoGenerate = true)    //主鍵(Key)
    val id: Int = 0,

    //表格項目名稱
    @ColumnInfo(name = "item_name")
    val itemName: String,
    @ColumnInfo(name = "item_price")
    val itemPrice: Double,
    @ColumnInfo(name = "quantity")
    val quantityInStack: Int
)
fun Item.getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(itemPrice)
