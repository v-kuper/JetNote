package com.example.jetnote.data

import com.example.jetnote.model.Note

class NotesDataSource {
        fun loadNotes(): List<Note> {
            return listOf(
                Note(title = "Покупки", description = "Купить молоко, хлеб и сыр"),
                Note(title = "Идея проекта", description = "Сделать приложение для заметок с голосовым вводом"),
                Note(title = "Звонок", description = "Позвонить бабушке в воскресенье в 18:00"),
                Note(title = "Книга", description = "Дочитать 'Преступление и наказание' до конца недели"),
                Note(title = "Фитнес", description = "Тренировка ног и пресса в четверг"),
                Note(title = "Работа", description = "Подготовить презентацию к понедельнику"),
                Note(title = "Путешествие", description = "Запланировать поездку в Стамбул на октябрь"),
                Note(title = "Фильм", description = "Посмотреть 'Интерстеллар' на выходных"),
                Note(title = "Медитация", description = "Сделать 10 минут медитации утром"),
                Note(title = "Курс", description = "Пройти следующий модуль курса по Jetpack Compose")
            )
        }
}