package com.kotlin.lin

import com.mongodb.Mongo
import com.mongodb.MongoClient
import com.mongodb.ServerAddress
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by 林皓 on 2017/5/30 0030.
 */

@Configuration
@EnableMongoRepositories(basePackages = arrayOf("com.**.repository"))
class MongoDataSourceConfig(
) : AbstractMongoConfiguration() {

    @Bean
    override fun mongo(): Mongo {
        val serverAddress = ServerAddress()
//        val credentials: List<MongoCredential> = listOf()
        return MongoClient(serverAddress)
    }

    override fun getDatabaseName(): String {
        return "test"
    }

}