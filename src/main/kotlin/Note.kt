package ru.netology

data class Note(
    val noteId: String = "", //Идентификатор заметки. Обязательный параметр
    val title: String = "", //Заголовок заметки. Обязательный параметр
    val text: String = "", //Текст заметки. //Обязательный параметр
    val privacy: Int = 0, //Уровень доступа к заметке. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
    val commentPrivacy: Int = 0, //Уровень доступа к комментированию заметки. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
    val privacyView: String = "", //Настройки приватности просмотра заметки в специальном формате.
    val privacyComment: String = "", //Настройки приватности комментирования заметки в специальном формате.
)
