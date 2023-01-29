package com.example.springredisstudy.domain.exception

import com.example.springredisstudy.global.exception.AbstractHttpStatusException
import org.springframework.http.HttpStatus

class PhoneAuthUnauthorizedException :
    AbstractHttpStatusException(HttpStatus.UNAUTHORIZED, "전화번호 인증 정보가 유효하지 않습니다.")
