
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

@Dao
interface NoteDatabaseDao {

    /**
     * Получение списка всех заметок из таблицы notes_tbl.
     * @return Список всех заметок.
     */
    @Query("SELECT * from notes_tbl")
    fun getNotes(): List<Note>

    /**
     * Получение заметки по её уникальному идентификатору.
     * @param id Уникальный идентификатор заметки.
     * @return Заметка с указанным id.
     */
    @Query("SELECT *from notes_tbl where id =:id")
    fun getNoteById(id: String): Note

    /**
     * Вставка новой заметки в базу данных или замена существующей при конфликте.
     * @param note Заметка для вставки или замены.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    /**
     * Обновление существующей заметки в базе данных, заменяя при конфликте.
     * @param note Заметка для обновления.
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    /**
     * Удаление всех заметок из таблицы notes_tbl.
     */
    @Query("DELETE from notes_tbl")
    fun deleteAll()

    /**
     * Удаление одной заметки из базы данных.
     * @param note Заметка для удаления.
     */
    @Delete
    fun deleteNote(note: Note)
}