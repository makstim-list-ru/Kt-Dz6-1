package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0
    private var comments = emptyArray<Comment>()
    private var notes = mutableListOf<Note>()
    private var noteId = 0
    private var commentsToNote = mutableListOf<CommentToNote>()
    private var commentToNoteId = 0


    fun notesCreateComment(
        noteId1: String, //Идентификатор заметки. Обязательный параметр
        message: String, //Текст комментария. //Обязательный параметр
        ownerId: Int = 0, //Идентификатор владельца заметки.
        replyTo: Int = 0, //Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий (не передаётся, если комментарий не является ответом).
        guid: String = ""//Уникальный идентификатор, предназначенный для предотвращения повторной отправки одинакового комментария.
    ): Int {
        val id: Int = commentToNoteId + 1
        commentsToNote.add(
            CommentToNote(
                noteId = noteId1,
                commentId = id,
                guid = guid,
                message = message,
                ownerId = ownerId,
                replyTo = replyTo
            )
        )
        commentToNoteId++
        return id
    }

    fun notesDeleteComment(
        commentId: Int, //Идентификатор комментария.Обязательный параметр
        ownerId: Int = 0, //Идентификатор владельца заметки.
    ): Int {
        commentsToNote.forEach {
            if (it.commentId == commentId) {
                val commentTmp = it.copy(commentId = -it.commentId)
                commentsToNote.remove(it)
                commentsToNote.add(commentTmp)
                return 1
            }
        }
        return 180 //Результат После успешного выполнения возвращает 1. Коды ошибок 180 Note not found
    }

    fun notesEditComment(
        commentId: Int, //Идентификатор комментария. Обязательный параметр
        message: String, //Новый текст комментария. Мин. длина = 2
        ownerId: Int = 0, // Идентификатор владельца заметки.
    ): Int {
        commentsToNote.forEach {
            if (it.commentId == commentId) {
                val commentTmp = it.copy(
                    message = message,
                    ownerId = if (ownerId == 0) it.ownerId else ownerId,
                )
                commentsToNote.remove(it)
                commentsToNote.add(commentTmp)
                return 1
            }
        }
        return 183 //Результат После успешного выполнения возвращает 1. Коды ошибок 183 Access to comment denied
    }

    fun notesGetComments(
        commentId: Int
    ): CommentToNote? {
        commentsToNote.forEach {
            if (it.commentId == commentId) return it
        }
        return null
    }

    fun notesGetComments(): MutableList<CommentToNote> {
        return commentsToNote
    }

    fun notesRestoreComment(
        commentId: Int, //Идентификатор удаленного комментария. Обязательный параметр
        ownerId: Int = 0 //Идентификатор владельца заметки.
    ): Int {
        commentsToNote.forEach {
            if (it.commentId == commentId) {
                val commentTmp = it.copy(commentId = -it.commentId)
                commentsToNote.remove(it)
                commentsToNote.add(commentTmp)
                return 1
            }
        }
        return 183 //Результат После успешного выполнения возвращает 1. Коды ошибок 183 Access to comment denied
    }

//
//    ***********************
//

    fun notesAdd(
        title: String,      //Заголовок заметки. Обязательный параметр
        text: String,       //Текст заметки. Обязательный параметр
        privacy: Int = 0,       //Уровень доступа к заметке. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
        commentPrivacy: Int = 0,   //Уровень доступа к комментированию заметки. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
        privacyView: String = "",   //Настройки приватности просмотра заметки в специальном формате.
        privacyComment: String = ""    //Настройки приватности комментирования заметки в специальном формате.
    ): Int {
        val id: Int = noteId + 1
        notes.add(
            Note(
                noteId = id.toString(),
                title = title,
                text = text,
                privacy = privacy,
                commentPrivacy = commentPrivacy,
                privacyView = privacyView,
                privacyComment = privacyComment
            )
        )
        noteId++
        return id       //Результат После успешного выполнения возвращает идентификатор созданной заметки (nid).
    }


    fun notesDelete(
        noteId: String //Идентификатор заметки.Обязательный параметр
    ): Int {
//        val noteIdInt = noteId.toInt()
        notes.forEach {
            if (it.noteId == noteId) {
                notes.remove(it)
                return 1
            }
        }
        return 180 //Результат После успешного выполнения возвращает 1. Коды ошибок 180 Note not found
    }


    fun notesEdit(
        noteId: String, //Идентификатор заметки. Обязательный параметр
        title: String,      //Заголовок заметки. Обязательный параметр
        text: String,       //Текст заметки. Обязательный параметр
        privacy: Int = 0,       //Уровень доступа к заметке. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
        commentPrivacy: Int = 0,   //Уровень доступа к комментированию заметки. Возможные значения: 0 — все пользователи, 1 — только друзья, 2 — друзья и друзья друзей, 3 — только пользователь.
        privacyView: String = "",   //Настройки приватности просмотра заметки в специальном формате.
        privacyComment: String = ""    //Настройки приватности комментирования заметки в специальном формате.
    ): Int {
//        val noteIdInt = noteId.toInt()
        notes.forEach {
            if (it.noteId == noteId) {
                val noteTmp = it.copy(
                    title = title,
                    text = text,
                    privacy = if (privacy == 0) it.privacy else privacy,
                    commentPrivacy = if (commentPrivacy == 0) it.commentPrivacy else commentPrivacy,
                    privacyView = if (privacyView == "") it.privacyView else privacyView,
                    privacyComment = if (privacyComment == "") it.privacyComment else privacyComment
                )
                notes.remove(it)
                notes.add(noteTmp)
                return 1
            }
        }
        return 180 //Результат После успешного выполнения возвращает 1. Коды ошибок 180 Note not found
    }

    fun notesGet(): MutableList<Note> {
        return notes
    }

    fun notesGet(
        note_ids: String, //Идентификаторы заметок, информацию о которых необходимо получить.
        user_id: Int = 0, //Идентификатор пользователя, информацию о заметках которого требуется получить.
        offset: Int = 0, //Смещение, необходимое для выборки определенного подмножества заметок.
        count: Int = 0, //Количество заметок, информацию о которых необходимо получить.
        sort: Int = 0, //Сортировка результатов (0 — по дате создания в порядке убывания, 1 - по дате создания в порядке возрастания).

    ): MutableList<Note> {
        var notesRequested = mutableListOf<Note>()
        TODO()
        //Результат После успешного выполнения возвращает список объектов заметок.
        return notesRequested
    }

    fun notesGetById(
        noteId: String //positive Идентификатор заметки. Обязательный параметр
    ): Note? {
        notes.forEach {
            if (it.noteId == noteId) return it
        }
        return null
    }


    fun add(post: Post): Post {
        posts += post.copy(id = id)
        id++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postTry) in posts.withIndex()) {
            if (postTry.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, postTry) in posts.withIndex()) {
            if (postTry.id == postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("PostNotFoundException with ID=$postId")
    }

    fun clear() {
        posts = emptyArray()
        id = 0
    }

}