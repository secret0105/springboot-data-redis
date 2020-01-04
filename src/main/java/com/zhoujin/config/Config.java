package com.zhoujin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 配置类
 *
 */
@Configuration
public class Config {

    /**
     *
     * 配置redis连接池
     */

//    @Bean
//    public JedisPoolConfig jedisPoolConfig(){
//        JedisPoolConfig config = new JedisPoolConfig();
//
//        //最大空闲数
//        config.setMaxIdle(10);
//
//        //最小空闲数
//        config.setMinIdle(5);
//
//        //最大连接数
//        config.setMaxTotal(20);
//
//        return config;
//
//    }
//
//    /**
//     *
//     * 创建jedisConnectionFactory 配置redis连接信息
//     * 直连方式，每次都会创建新的连接，当并发量剧增时，会增加开销
//     */
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//
//        //设置redis 服务器地址
//        redisStandaloneConfiguration.setHostName("192.168.183.255");
//
//        redisStandaloneConfiguration.setPort(6379);
//
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//
//    }

    /**
     * 使用连接池方式
     *
     */

    //--------------------
    /**
     * 创建redistemplate
     *
     */

    @Bean
//    @ConfigurationProperties(prefix = "spring.redis")
    public RedisTemplate<String,Object> redisTemplate(){

        JedisPoolConfig config = new JedisPoolConfig();

        //最大空闲数
        config.setMaxIdle(10);

        //最小空闲数
        config.setMinIdle(5);

        //最大连接数
        config.setMaxTotal(20);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(config);
//        使用配置文件
        factory.setHostName("192.168.183.130");
        factory.setPort(6379);


        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        //为KEY设置序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //为value设置序列化器
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
