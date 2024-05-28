package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0

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

    fun clear() {
        posts = emptyArray()
        id = 0
    }

}