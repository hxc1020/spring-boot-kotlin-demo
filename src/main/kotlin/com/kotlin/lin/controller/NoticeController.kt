package com.kotlin.lin.controller

import com.kotlin.lin.common.bean.ResponseData
import com.kotlin.lin.entity.Note
import com.kotlin.lin.repository.NoteRepository
import org.springframework.web.bind.annotation.*

/**
 * Created by 林皓 on 2017/5/29 0029.
 */
@RestController
class NoticeController(
        private val noteRepository: NoteRepository
) {
    @PostMapping("/notice")
    fun add(@RequestBody note: Note): ResponseData {
        try {
            noteRepository.save(note)
            return ResponseData(null, "success", "添加成功！")
        } catch(e: Exception) {
            return ResponseData(null, "error", "添加失败！")
        }
    }

    @GetMapping("/notice/{noteId}")
    fun getOne(@PathVariable("noteId") noteId: Long): ResponseData {
        return noteRepository.findOne(noteId).let { ResponseData(it, null, null) }
    }
}