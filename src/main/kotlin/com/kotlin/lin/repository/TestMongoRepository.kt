package com.kotlin.lin.repository

import com.kotlin.lin.entity.TestMongo
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * Created by 林皓 on 2017/5/30 0030.
 */

interface TestMongoRepository: MongoRepository<TestMongo, String>