package com.example.springredisstudy.global.exception

import org.springframework.http.HttpStatus

abstract class AbstractHttpStatusException(
    val httpStatus: HttpStatus,
    override val message: String,
) : RuntimeException()
