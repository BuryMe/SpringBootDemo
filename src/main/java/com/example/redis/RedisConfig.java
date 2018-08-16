package com.example.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 配置类
 * @Author constanting_f
 */
@EnableCaching
@Configuration
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {

    /**
     *  Redis服务器地址
     */
    @Value("${redis.host}")

    private String host;
    /**
     *  Redis服务器连接端口
     */
    @Value("${redis.port}")

    private int port;
    /**
     * Redis服务器连接密码（默认为空）
     */
    @Value("${redis.password}")

    private String password;
    /**
     * 连接超时时间（毫秒）
     */
    @Value("${redis.timeout}")

    private int timeout;
    /**
     * 连接超时时间（毫秒）
     */
    @Value("${redis.database}")

    private int database;
    /**
     *  连接池最大连接数（使用负值表示没有限制）
     */
    @Value("${redis.pool.max-active}")

    private int maxTotal;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${redis.pool.max-wait}")

    private int maxWaitMillis;
    /**
     *  连接池中的最大空闲连接
     */
    @Value("${redis.pool.max-idle}")

    private int maxIdle;
    /**
     *  连接池中的最小空闲连接
     */
    @Value("${redis.pool.min-idle}")
    private int minIdle;

    /**
     * 连接池参数
     * @return
     */
    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        log.info("初始化JedisPoolConfig");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(this.maxTotal);
        jedisPoolConfig.setMaxWaitMillis(this.maxWaitMillis);
        jedisPoolConfig.setMaxIdle(this.maxIdle);
        jedisPoolConfig.setMinIdle(this.minIdle);
        return jedisPoolConfig;
    }

    /**
     * redis客户端对象
     * @return
     */
    @Bean(name = "redisConfiguration")
    public RedisStandaloneConfiguration redisStandaloneConfiguration(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setPassword( RedisPassword.of(this.password));
        redisStandaloneConfiguration.setHostName(this.host);
        redisStandaloneConfiguration.setDatabase(this.database);
        redisStandaloneConfiguration.setPort(this.port);
        return redisStandaloneConfiguration;
    }

    /**
     * redis连接池对象
     * @param poolConfig
     * @return
     */
    @Bean(name = "jedisConnectionFactory")
    public RedisConnectionFactory jedisConnectionFactory(@Qualifier(value = "jedisPoolConfig") JedisPoolConfig poolConfig,
                                                         @Qualifier(value = "redisConfiguration")RedisStandaloneConfiguration redisStandaloneConfiguration) {
        log.info("初始化RedisConnectionFactory");
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpb=
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)JedisClientConfiguration.builder();
        jpb.poolConfig( poolConfig );
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration,jpb.build());
        return jedisConnectionFactory;
    }

    /**
     * 初始化RedisTemplate
     * 序列化方法：
     * RedisSerializer redis序列化的接口类
     * OxmSerializer xml到object的序列化/反序列化
     * StringRedisSerializer string字符串的序列化/反序列化
     * JacksonJsonRedisSerializer json到object的序列化/反序列化
     * Jackson2JsonRedisSerializer json到object的序列化/反序列化
     * JdkSerializationRedisSerializer java对象的序列化/反序列化（redisTemplate默认）
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean("redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(@Qualifier(value = "jedisConnectionFactory")RedisConnectionFactory redisConnectionFactory ){
        log.info("初始化redisTemplate");
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key值序列化
        redisTemplate.setKeySerializer( stringRedisSerializer );
        redisTemplate.setHashKeySerializer( stringRedisSerializer );
        //value值序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility( PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper( objectMapper );
        redisTemplate.setDefaultSerializer( jackson2JsonRedisSerializer );
        redisTemplate.setConnectionFactory( redisConnectionFactory );
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
