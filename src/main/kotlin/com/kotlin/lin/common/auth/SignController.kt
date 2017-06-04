package com.kotlin.lin.common.auth

import com.kotlin.lin.common.bean.ResponseData
import com.kotlin.lin.entity.MyUser
import com.kotlin.lin.repository.MyUserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

/**
 * 注册登录
 * Created by 林皓 on 2017/5/28 0028.
 */
@RestController
@RequestMapping("/sign")
class SignController(
        private var myUserRepository: MyUserRepository,
        private val authenticationManager: AuthenticationManager,
        private val tokenHandler: TokenHandler,
        private val securityContextService: SecurityContextService
) {
    @PostMapping("/in")
    fun signIn(@RequestBody myUser: MyUser): AuthResponse? {
        return sign(myUser.name, myUser.password)
    }

    @PostMapping("/up")
    fun signUp(@RequestBody myUser: MyUser): AuthResponse? {
        if (!checkUser(myUser.name)) {
            return null
        }
        val encoder = BCryptPasswordEncoder()
        val pass = String().plus(myUser.password) // 备份用户登录密码
        myUser.password = encoder.encode(myUser.password)
        try {
            myUserRepository.save(myUser)
            return sign(myUser.name, pass) //登录时不能使用已经加密过的密码
        } catch(e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    @GetMapping("/check/{userName}")
    fun checkMyUser(@PathVariable("userName") userName: String): ResponseData {
        return ResponseData(checkUser(userName), null, null)
    }

    private fun checkUser(userName: String):Boolean = myUserRepository.findByName(userName) == null

    private fun sign(userName: String, password: String): AuthResponse {
        val userToken: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userName, password)
        val authenticate = authenticationManager.authenticate(userToken)
        SecurityContextHolder.getContext().authentication = authenticate

        return securityContextService.currentUser()
                .let { requireNotNull(it) }
                .let { tokenHandler.createTokenForUser(it).let(::AuthResponse) }
    }

    data class AuthResponse(val token: String)
}