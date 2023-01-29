package com.example.springredisstudy.domain

import java.util.concurrent.ThreadLocalRandom

const val MAX_REQUEST_COUNT = 5

data class PhoneAuth(
    val phone: String,
    val authCode: String,
    val requestCount: Int,
) {

    val authCodeMessage: String
        get() = """
            인증코드 : [${this.authCode}]
        """.trimIndent()

    fun createNewPhoneAuth(): PhoneAuth {
        check(isTooManyRequest()) { "$MAX_REQUEST_COUNT 회 이상 동일 휴대전화로 요청할 수 없습니다." }
        return this.copy(authCode = createAuthCode(), requestCount = this.requestCount + 1)
    }

    fun isTooManyRequest(): Boolean {
        return requestCount < MAX_REQUEST_COUNT
    }

    companion object {

        fun createPhoneAuth(phone: String): PhoneAuth {
            return PhoneAuth(
                phone,
                createAuthCode(),
                requestCount = 1,
            )
        }

        private fun createAuthCode(): String {
            return ThreadLocalRandom.current().nextInt(100000, 1000000).toString()
        }
    }
}
