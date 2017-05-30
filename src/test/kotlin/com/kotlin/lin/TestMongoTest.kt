package com.kotlin.lin

import com.kotlin.lin.entity.TestMongo
import com.kotlin.lin.repository.TestMongoRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper
import org.springframework.test.context.BootstrapWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by 林皓 on 2017/5/30 0030.
 */

@RunWith(SpringRunner::class)
@BootstrapWith(SpringBootTestContextBootstrapper::class)
@ContextConfiguration(classes = arrayOf(MongoDataSourceConfig::class))
class TestMongoTest {

    @Autowired
    lateinit var testMongoRepository: TestMongoRepository

    @Test
    fun test01() {
        testMongoRepository.save(TestMongo(null, "lin"))
        println(testMongoRepository.findAll())
    }

}