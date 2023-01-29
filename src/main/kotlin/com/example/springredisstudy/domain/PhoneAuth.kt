package com.example.springredisstudy.domain

import java.util.concurrent.ThreadLocalRandom

data class PhoneAuth(
    val phone: String,
    val authCode: String,
    val requestCount: Int,
) {

    companion object {

        fun createPhoneAuth(phone: String): PhoneAuth {
            return PhoneAuth(
                phone,
                createAuthCode(),
                requestCount = 1
            )
        }

        private fun createAuthCode(): String {
            return ThreadLocalRandom.current().nextInt(100000, 1000000).toString()
        }
    }
}
