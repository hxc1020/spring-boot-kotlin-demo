package com.kotlin.lin.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by 林皓 on 2017/5/30 0030.
 */

@Document(collection = "testmongo")
data class TestMongo(
        @Id
        val userId: String?,
        val userName: String?
)