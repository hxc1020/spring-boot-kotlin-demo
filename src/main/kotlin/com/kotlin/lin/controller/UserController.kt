package com.kotlin.lin.controller

import com.kotlin.lin.entity.MyUser
import com.kotlin.lin.repository.MyUserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by 林皓 on 2017/5/1 0001.
 */
@RestController
class UserController(val myUserRepository: MyUserRepository) {

    @GetMapping("/user")
    fun findAll(): List<MyUser> = myUserRepository.findAll()

    @PostMapping("/myUser")
    fun saveUser(@RequestBody myUser: MyUser):String{
        try {
            myUserRepository.save(myUser)
            return "success"
        } catch(e: Exception) {
            e.printStackTrace()
            return "false"
        }
    }
}