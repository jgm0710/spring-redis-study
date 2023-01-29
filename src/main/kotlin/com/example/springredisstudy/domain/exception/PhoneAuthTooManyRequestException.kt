package com.example.springredisstudy.domain.exception

import com.example.springredisstudy.global.exception.AbstractHttpStatusException
import org.springframework.http.HttpStatus

class PhoneAuthTooManyRequestException() : AbstractHttpStatusException(
    HttpStatus.TOO_MANY_REQUESTS,
    "The mobile phone number verification code has been sent too many times."
)
