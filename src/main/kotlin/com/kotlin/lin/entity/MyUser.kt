package com.kotlin.lin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by 林皓 on 2017/5/1 0001.
 */
@Entity
class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
    val name: String = ""
    var password: String = ""
    val auth: String = "ROLE_USER"
}