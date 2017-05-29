package com.kotlin.lin.common.auth

import com.kotlin.lin.entity.MyUser


interface SecurityContextService {
    fun currentUser(): MyUser?
}
