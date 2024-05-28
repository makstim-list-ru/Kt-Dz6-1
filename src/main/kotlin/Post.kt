package ru.netology

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: ObjComments = ObjComments(),
    val copyright: ObjTBD? = null,
    val likes: ObjTBD? = null,
    val reposts: ObjTBD? = null,
    val views: ObjTBD? = null,
    val postType: String = "",
    val postSource: ObjTBD? = null,
    val attachments: Array<Attachment>? = null,
    val geo: ObjTBD? = null,
    val signerId: Int = 0,
    val copyHistory: Array<String>? = null,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: ObjTBD? = null,
    val postponedId: Int = 0
)

data class ObjComments(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class ObjTBD(
    val string: String = ""
)

interface Attachment {
    val type: String
}

class AudioAttachment(override val type: String = "audio", val audio: Audio? = null) : Attachment

data class Audio(
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int = 0
)

class VideoAttachment(override val type: String = "video", val video: Video? = null) : Attachment

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String? = null,
    val description: String? = null,
    val duration: Int = 0
)

class FileAttachment(override val type: String = "file", val file: File? = null) : Attachment

data class File(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String? = null,
    val size: Int = 0,
    val ext: String? = null
)





