package ru.netology

data class Comment(
    val id: Int = -1,               //integer Идентификатор комментария
    val fromId: Int = -1,           //integer Идентификатор автора комментария.
    val date: Int = -1,             //integer Дата создания комментария в формате Unixtime.
    val text: String = "",          //string Текст комментария.
    val donut: Boolean = false,     //is_don (boolean) — является ли комментатор подписчиком VK Donut.
    val replyToUser: Int = -1,      //integer Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    val replyToComment: Int = -1,   //integer Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments: Attachment? = null, //object Медиавложения комментария (фотографии, ссылки и т.п.).
    val parentsStack: Array<Int>? = null,  //array Массив идентификаторов родительских комментариев.
    val thread: ObjTBD = ObjTBD(), //object Информация о вложенной ветке комментариев, объект с полями:
                        //count (integer) — количество комментариев в ветке.
                        //items (array) — массив объектов комментариев к записи (только для метода wall.getComments).
                        //can_post (boolean) – может ли текущий пользователь оставлять комментарии в этой ветке.
                        //show_reply_button (boolean) – нужно ли отображать кнопку «ответить» в ветке.
                        //groups_can_post (boolean) – могут ли сообщества оставлять комментарии в ветке.
)
