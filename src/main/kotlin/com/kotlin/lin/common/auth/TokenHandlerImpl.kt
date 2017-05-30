package com.kotlin.lin.common.auth

import com.kotlin.lin.entity.MyUser
import com.kotlin.lin.repository.MyUserRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import java.util.*

@Component
class TokenHandlerImpl(
        @param:Value("\${app.jwt.secret}")
        private val secret: String,
        private val myUserRepository: MyUserRepository
) : TokenHandler {

    override fun parseUserFromToken(token: String): UserDetails {
        val userId = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .body
                .subject
                .toLong()

        return myUserRepository.findOne(userId).let { UserDataFactory(it).userDetail() }
    }

    override fun createTokenForUser(user: MyUser): String {
        val afterOneWeek = ZonedDateTime.now().plusWeeks(1)

        return Jwts.builder()
                .setSubject(user.id.toString())
                .setClaims(mutableMapOf("userName" to user.name, "userId" to user.id) as Map<String, Any>?)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact()
    }

}

