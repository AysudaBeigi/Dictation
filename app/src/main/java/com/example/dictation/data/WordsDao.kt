package com.example.dictation.data

import androidx.room.*
import com.example.dictation.domain.Level
import com.example.dictation.domain.Word

@Dao
interface WordsDao {
    @Query("SELECT * FROM word")
   suspend fun getAll(): List<Word>

    @Query("SELECT * FROM word where level==:selectedLevel")
   suspend fun getSelectedLevelWords(selectedLevel: Level): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateAll(words: List<Word>)

}

@Database(
    entities = [Word::class],
    version = 1, exportSchema = false
)
@TypeConverters(WordEntityConverter::class)
abstract class DictationDatabase : RoomDatabase() {
    abstract val wordsDao: WordsDao
}
