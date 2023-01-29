package com.example.springredisstudy.domain.exception

import com.example.springredisstudy.global.exception.AbstractHttpStatusException
import org.springframework.http.HttpStatus

class PhoneAuthTooManyRequestException() : AbstractHttpStatusException(
    HttpStatus.BAD_REQUEST,
    "The mobile phone number verification code has been sent too many times."
)
