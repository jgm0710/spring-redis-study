package com.example.springredisstudy.application

import com.example.springredisstudy.application.command.SendAuthCodeCommand
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PhoneAuthAplServiceTest @Autowired constructor(val phoneAuthAplService: PhoneAuthAplService) {

    @Test
    @DisplayName("sendAuthCode sample test")
    fun sendAuthCodeSampleTest() {
        //given

        //when
        val sendResult = phoneAuthAplService.sendAuthCode(SendAuthCodeCommand("01012341234"))

        //then
        println("sendResult = ${sendResult}")
    }
}
