package com.kotlin.lin.repository

import com.kotlin.lin.entity.MyUser
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by 林皓 on 2017/5/1 0001.
 */

interface MyUserRepository :JpaRepository<MyUser,Long>{
    fun findByName(name: String): MyUser?
}