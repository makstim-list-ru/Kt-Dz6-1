package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    val audioExmpl1 = Audio(1, 1, "artist1", "title1", 1)
    val videoExmpl1 = Video(11, 11, "video11", "this video11", 11)
    val fileExmpl1 = File(21, 21, "file21", 21, "doc")

    val audioAtt1 = AudioAttachment(audio = audioExmpl1)
    val videoAtt1 = VideoAttachment(video = videoExmpl1)
    val fileAtt1 = FileAttachment(file = fileExmpl1)

    val attachments = arrayOf<Attachment>(audioAtt1, videoAtt1, fileAtt1)
    val attachments2 = Array<Attachment>(2) { audioAtt1 }
    //val attachments3 = Array<Attachment> (2) {audioAtt1, videoAtt2}

    val post1 = Post(id = 1, text = "this is post #1", attachments = attachments)
    val post2 = Post(id = 2, text = "this is post #2")
    val post2New = Post(id = 1, text = "this is post #2NEW")
    val post3 = Post(id = 3, text = "this is post #3")

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun chkCommentsToNotes() {
        val comm1 = WallService.notesCreateComment("aaa", "it's comments-to-note #1")
        val comm2 = WallService.notesCreateComment("bbb", "it's comments-to-note #2")
        val comm3 = WallService.notesCreateComment("ccc", "it's comments-to-note #3")
        assertEquals(6, comm3+comm2+comm1)

        WallService.notesGetComments().forEach {
            println(it)
        }
        println()

        assertEquals(WallService.notesEditComment(2, "new-message-in-comment"),1)

        WallService.notesGetComments().forEach {
            println(it)
        }
        println()

        assertEquals(WallService.notesDeleteComment(3),1)

        WallService.notesGetComments().forEach {
            println(it)
        }
        println()

        assertEquals(WallService.notesRestoreComment(-3),1)

        WallService.notesGetComments().forEach {
            println(it)
        }
        println()
    }


    @Test
    fun chkNote() {
        val Note1 = WallService.notesAdd("title_note1", "text_note1")
        val Note2 = WallService.notesAdd("title_note2", "text_note2")
        val Note3 = WallService.notesAdd("title_note3", "text_note3")
        val Note4 = WallService.notesAdd("title_note4", "text_note4")
        assertEquals(10,Note1+Note2+Note3+Note4)

        WallService.notesGet().forEach {
            println(it)
        }
        println()

        assertEquals(1,WallService.notesEdit("2", "title_note1edited", "text_note1edited"))

        WallService.notesGet().forEach {
            println(it)
        }
        println()

        assertEquals(1,WallService.notesDelete("3"))

        WallService.notesGet().forEach {
            println(it)
        }
        println()


    }


    @Test
    fun add() {
        var tmpPost = WallService.add(post1)
        assertEquals(tmpPost.id, 0)
        assertEquals(tmpPost.text, "this is post #1")

        tmpPost = WallService.add(post2)
        assertEquals(tmpPost.id, 1)
        assertEquals(tmpPost.text, "this is post #2")

        tmpPost = WallService.add(post3)
        assertEquals(tmpPost.id, 2)
        assertEquals(tmpPost.text, "this is post #3")
    }

    @Test
    fun update() {
        WallService.add(post1)
        WallService.add(post2)
        assertEquals(WallService.update(post3), false)
        assertEquals(WallService.update(post2New), true)
    }

    @Test
    fun createComment() {
        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)

        val testComment = Comment()
        assertEquals(WallService.createComment(2, testComment), testComment)
    }


    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(post1)
        WallService.add(post2)

        val testComment = Comment()
        WallService.createComment(2, testComment)
    }

}