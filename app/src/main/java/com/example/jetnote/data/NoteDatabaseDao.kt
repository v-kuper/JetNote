
/**
 * Data Access Object (DAO) для работы с таблицей заметок в базе данных Room.
 * Этот интерфейс определяет методы для получения, вставки, обновления и удаления заметок.
 */
package com.example.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    /**
     * Получение списка всех заметок из таблицы notes_tbl.
     * @return Список всех заметок.
     */
    @Query("SELECT * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    /**
     * Получение заметки по её уникальному идентификатору.
     * @param id Уникальный идентификатор заметки.
     * @return Заметка с указанным id.
     */
    @Query("SELECT *from notes_tbl where id =:id")
    suspend fun getNoteById(id: String): Note

    /**
     * Вставка новой заметки в базу данных или замена существующей при конфликте.
     * @param note Заметка для вставки или замены.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    /**
     * Обновление существующей заметки в базе данных, заменяя при конфликте.
     * @param note Заметка для обновления.
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    /**
     * Удаление всех заметок из таблицы notes_tbl.
     */
    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()

    /**
     * Удаление одной заметки из базы данных.
     * @param note Заметка для удаления.
     */
    @Delete
    suspend fun deleteNote(note: Note)
}