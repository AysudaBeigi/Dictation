package com.example.dictation.data

import androidx.room.*
import com.example.dictation.domain.Word

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dictation.domain.Level

@Dao
interface WordsDao {
    @Query("SELECT * FROM word")
    fun getAll(): List<Word>

    @Query("SELECT * FROM word where level==:selectedLevel")
    fun getSelectedLevelWords(selectedLevel: Level): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateAll(words: List<Word>)

}

@Database(
    entities = [Word::class],
    version = 1, exportSchema = false
)
@TypeConverters(WordEntityConverter::class)
abstract class DictationDatabase : RoomDatabase() {
    abstract val wordsDao: WordsDao
}
