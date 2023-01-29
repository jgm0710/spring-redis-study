package com.example.springredisstudy.application

import com.example.springredisstudy.application.command.SendAuthCodeCommand
import com.example.springredisstudy.application.command.ValidateAuthCodeCommand
import com.example.springredisstudy.domain.PhoneAuth
import org.junit.jupiter.api.Assertions.*
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

    @Test
    @DisplayName("sam")
    fun sam() {
        //given
        val sendAuthCode: PhoneAuth = phoneAuthAplService.sendAuthCode(SendAuthCodeCommand("01012341234"))

        val validateAuthCodeCommand = ValidateAuthCodeCommand(
            sendAuthCode.phone,
            sendAuthCode.authCode
        )

        //when

        //then
        assertDoesNotThrow { phoneAuthAplService.validateAuthCode(validateAuthCodeCommand) }
    }
}
