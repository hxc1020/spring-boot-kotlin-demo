package com.kotlin.lin.config

/**
 * Created by 林皓 on 2017/5/26 0026.
 */
import com.kotlin.lin.repository.MyUserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class UserDetailsServiceImpl(
        private val myUserRepository: MyUserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return myUserRepository.findByName(username)
                .let { requireNotNull(it) }
                .let { User(it.name, it.password, listOf(it.auth.let(::SimpleGrantedAuthority))) }
    }


}
