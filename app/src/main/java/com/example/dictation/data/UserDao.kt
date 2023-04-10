package com.example.dictation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictation.domain.User
//
//@Dao
//interface UserDao {
//    @Query("SELECT * FROM User")
//    fun getAll(): List<User>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(user: User)
//
//}