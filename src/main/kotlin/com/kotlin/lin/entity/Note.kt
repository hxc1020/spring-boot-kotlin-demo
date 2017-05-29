package com.kotlin.lin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by 林皓 on 2017/5/29 0029.
 */
@Entity
data class Note(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = 0,
        val title: String? = "",
        val content: String? = ""
)