package com.example.springredisstudy.domain.message

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MessageSendService {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sendPhoneMessage(phone: String, message: String) {
        log.info("메세지 발송 완료. phone : {}, message : [{}]", phone, message)
    }
}
