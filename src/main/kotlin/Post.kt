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
    val copyright: ObjTBD = ObjTBD(),
    val likes: ObjTBD = ObjTBD(),
    val reposts: ObjTBD = ObjTBD(),
    val views: ObjTBD = ObjTBD(),
    val postType: String = "",
    val postSource: ObjTBD = ObjTBD(),
    val attachments: Array<String> = emptyArray<String>(),
    val geo: ObjTBD = ObjTBD(),
    val signerId: Int = 0,
    val copyHistory: Array<String> = emptyArray<String>(),
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: ObjTBD = ObjTBD(),
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