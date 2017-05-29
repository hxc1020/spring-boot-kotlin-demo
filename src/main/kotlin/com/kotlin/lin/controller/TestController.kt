package com.kotlin.lin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by 林皓 on 2017/5/1 0001.
 */
@RestController
class TestController{
    @GetMapping("/hello")
    fun hello() = "hello controller"
}