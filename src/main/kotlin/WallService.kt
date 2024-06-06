package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0
    private var comments = emptyArray<Comment>()


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