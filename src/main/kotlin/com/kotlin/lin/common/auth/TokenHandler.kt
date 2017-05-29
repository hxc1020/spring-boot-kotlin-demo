package com.kotlin.lin.common.auth

import com.kotlin.lin.entity.MyUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
interface TokenHandler {

    fun parseUserFromToken(token: String): UserDetails
    fun createTokenForUser(user: MyUser): String

}
