package com.example.springredisstudy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpringRedisStudyApplication

fun main(args: Array<String>) {
    runApplication<SpringRedisStudyApplication>(*args)
}
