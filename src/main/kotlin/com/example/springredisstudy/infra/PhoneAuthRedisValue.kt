package com.example.springredisstudy.infra

import com.example.springredisstudy.domain.PhoneAuth

data class PhoneAuthRedisValue(
    val phone: String,
    val authCode: String,
    val requestCount: Int,
) {

    companion object {
        fun PhoneAuth.toValue() : PhoneAuthRedisValue{
            return PhoneAuthRedisValue(
                phone = phone,
                authCode = authCode,
                requestCount = requestCount,
            )
        }
    }

    fun toDomain() : PhoneAuth{
        return PhoneAuth(
            phone = phone,
            authCode = authCode,
            requestCount = requestCount,
        )
    }
}
