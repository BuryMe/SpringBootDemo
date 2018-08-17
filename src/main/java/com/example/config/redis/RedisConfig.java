package com.example.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1.cacheManger 緩存管理器
 * 2.key值序列化
 * 3.cacheManager工厂类，加载redis的相关配置属性
 * 4.具体操作实现类(这里略，具体参照redisServiceImpl)
 * <p>
 * cache 参数配置
 *
 * @Author constanting_f
 */
@EnableCaching
@Configuration
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * Redis服务器地址
     */
    @Value("${redis.host}")

    private String host;
    /**
     * Redis服务器连接端口
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
     * 连接池最大连接数（使用负值表示没有限制）
     */
    @Value("${redis.jedis.pool.max-active}")

    private int maxTotal;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${redis.jedis.pool.max-wait}")

    private int maxWaitMillis;
    /**
     * 连接池中的最大空闲连接
     */
    @Value("${redis.jedis.pool.max-idle}")

    private int maxIdle;
    /**
     * 连接池中的最小空闲连接
     */
    @Value("${redis.jedis.pool.min-idle}")
    private int minIdle;

    @Autowired
    private DemoKeyGenerator demoKeyGenerator;

    /**
     * redis连接池工厂
     */
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 连接池参数
     *
     * @return
     */
    @Bean(name = "jedisPoolConfig")
    @ConditionalOnMissingBean
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
     *
     * @return
     */
    @Bean(name = "redisConfiguration")
    @ConditionalOnMissingBean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setPassword(RedisPassword.of(this.password));
        redisStandaloneConfiguration.setHostName(this.host);
        redisStandaloneConfiguration.setDatabase(this.database);
        redisStandaloneConfiguration.setPort(this.port);
        return redisStandaloneConfiguration;
    }

    /**
     * redis连接池对象
     *
     * @param poolConfig
     * @return
     */
    @Bean(name = "jedisConnectionFactory")
    @ConditionalOnMissingBean
    public RedisConnectionFactory jedisConnectionFactory(@Qualifier(value = "jedisPoolConfig") JedisPoolConfig poolConfig,
                                                         @Qualifier(value = "redisConfiguration") RedisStandaloneConfiguration redisStandaloneConfiguration) {
        log.info("初始化RedisConnectionFactory");
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpb =
                (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        jpb.poolConfig(poolConfig);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration, jpb.build());
        return jedisConnectionFactory;
    }

    /**
     * 自定义 key 值序列化方法
     * <p>
     * TODO 自定义 key 值序列化方法这个方法也可以不定义，springBoot本身会提供默认key值序列化方法
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return demoKeyGenerator;
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
    @ConditionalOnMissingBean
    public RedisTemplate<String, Object> redisTemplate(@Qualifier(value = "jedisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        log.info("redisTemplate初始化开始");
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key值序列化
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        //value值序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        this.redisConnectionFactory = redisConnectionFactory;
        log.info("redisTemplate初始化结束");
        return redisTemplate;
    }

    /**
     * RedisCacheManager cacheManager 的构造
     * spring Boot 1.0 :spring.cacheManager为RedisCacheManager 表示 redis作为缓存管理。
     * spring Boot 2.0 :通过Spring提供的RedisCacheConfiguration类，构造一个自己的redis配置类
     * 这里为2.0
     * 注意:redis缓存和EhCache缓存不能同时存在
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        log.info("RedisCacheManager初始化开始");
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        //不缓存空值
        configuration.disableCachingNullValues();
        //设置默认存储时间为30分钟
        configuration.entryTtl(Duration.ofMinutes(30));
        //设置一个初始化的缓存空间set集合
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("demo1");
        cacheNames.add("demo2");
        //为每个缓存空间对应不同的配置信息
        Map<String, RedisCacheConfiguration> cacheConfidMap = new HashMap<>(2);
        cacheConfidMap.put("demo1", configuration);
        cacheConfidMap.put("demo2", configuration.entryTtl(Duration.ofMinutes(60)));
        //构造RedisCacheManager
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(cacheConfidMap)
                .build();
        log.info("RedisCacheManager初始化结束");
        return redisCacheManager;
    }

}