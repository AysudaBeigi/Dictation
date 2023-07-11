package com.example.dictation.data

import androidx.room.*
import com.example.dictation.domain.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getUser(): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
}
