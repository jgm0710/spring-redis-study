package com.example.springredisstudy.infra

import com.example.springredisstudy.domain.PhoneAuth
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PhoneAuthRepositoryRedisImplTest @Autowired constructor(val phoneAuthRepositoryRedisImpl: PhoneAuthRepositoryRedisImpl){

    @Test
    @DisplayName("save and find test")
    fun saveAndFindTest() {
        //given
        val phone = "01012341234"

        val phoneAuth: PhoneAuth = PhoneAuth.createPhoneAuth(phone)

        //when
        phoneAuthRepositoryRedisImpl.save(
            phoneAuth
        )

        //then
        val findPhoneAuth: PhoneAuth? = phoneAuthRepositoryRedisImpl.findByPhone(phone)
        println("findByPhone = $findPhoneAuth")
    }
}
