package com.example.springredisstudy.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PhoneAuthTest {

    @Test
    @DisplayName("auth code test")
    fun authCodeTest() {
        //given

        //when

        //then
        for (i in 1..10000) {
            val phone = PhoneAuth.createPhoneAuth("01012341234")
            val authCode = phone.authCode
            if (authCode.startsWith("0")) {
                println("authCode = ${authCode}")
            }
            Assertions.assertEquals(6,authCode.length)
        }
    }
}
