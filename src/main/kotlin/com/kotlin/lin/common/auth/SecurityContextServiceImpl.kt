package com.kotlin.lin.common.auth

import com.kotlin.lin.entity.MyUser
import com.kotlin.lin.repository.MyUserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service

@Service
class SecurityContextServiceImpl(
        private val myUserRepository: MyUserRepository
) : SecurityContextService {

    @Suppress("unused")
    private val logger = LoggerFactory.getLogger(SecurityContextServiceImpl::class.java)

    override fun currentUser(): MyUser? {
        return SecurityContextHolder
                .getContext()
                .authentication
                .principal
                .let {
                    when (it) {
                        is User -> myUserRepository.findByName(it.username)
                        else -> null
                    }
                }
    }

}
