package com.example.springredisstudy.infra

import com.example.springredisstudy.domain.PhoneAuth
import com.example.springredisstudy.domain.PhoneAuthRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Repository

@Repository
class PhoneAuthRepositoryRedisImpl(
    val redisTemplate: RedisTemplate<String, Any>,
    val objectMapper: ObjectMapper
) : PhoneAuthRepository {

    override fun save(phoneAuth: PhoneAuth): PhoneAuth {
        val opsForValue: ValueOperations<String, Any> = redisTemplate.opsForValue()
        val json: String = objectMapper.writeValueAsString(phoneAuth)
        opsForValue.set(phoneAuth.phone, json)
        return  phoneAuth
    }
}
