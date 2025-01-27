package com.ussd_demo.demo.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
@EnableCaching
class CacheConfig {
    @Bean
    fun cacheManager(): CaffeineCacheManager {
        val cacheManager = CaffeineCacheManager("sessionCache")
        cacheManager.setCaffeine(caffeineCacheBuilder())
        return cacheManager
    }

    fun caffeineCacheBuilder(): Caffeine<Any, Any> {
        return Caffeine.newBuilder()
            .initialCapacity(100)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .weakKeys()
            .maximumSize(1000)
    }
}