package com.example.springredisstudy.infra

import com.example.springredisstudy.domain.PhoneAuth
import com.example.springredisstudy.domain.PhoneAuthRepository
import com.example.springredisstudy.infra.PhoneAuthRedisValue.Companion.toValue
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Repository
import java.time.Duration

@Repository
class PhoneAuthRepositoryRedisImpl(
    val redisTemplate: RedisTemplate<String, Any>,
    val objectMapper: ObjectMapper,
) : PhoneAuthRepository {

    override fun save(phoneAuth: PhoneAuth): PhoneAuth {
        val opsForValue: ValueOperations<String, Any> = redisTemplate.opsForValue()
        val json: String = objectMapper.writeValueAsString(phoneAuth.toValue())
        opsForValue.set(phoneAuth.phone, json, Duration.ofSeconds(60 * 3))
        return phoneAuth
    }

    override fun findByPhone(phone: String): PhoneAuth? {
        val value: Any? = redisTemplate.opsForValue().get(phone)
        return objectMapper.readValue(value.toString(), PhoneAuthRedisValue::class.java)
            ?.toDomain()
    }
}
