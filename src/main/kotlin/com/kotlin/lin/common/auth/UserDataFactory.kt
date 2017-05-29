package com.kotlin.lin.common.auth

import com.kotlin.lin.entity.MyUser
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 * Created by 林皓 on 2017/5/29 0029.
 */
data class UserDataFactory(val myUser: MyUser)

fun UserDataFactory.userDetail(): User =
        User(myUser.name, myUser.password, mutableListOf(myUser.auth.let(::SimpleGrantedAuthority)))