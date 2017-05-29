package com.kotlin.lin.repository

import com.kotlin.lin.entity.Note
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by 林皓 on 2017/5/29 0029.
 */
interface NoteRepository:JpaRepository<Note,Long>