package com.zhoujin.test;

import com.zhoujin.pojo.User;
import com.zhoujin.springbootdataredis.SpringbootDataRedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootDataRedisApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("key", "钢铁侠");
    }

    @Test
    public void testGet() {
        Object key = redisTemplate.opsForValue().get("key");
        System.out.println(key);
    }

    @Test
    public void testUser() {

//        User u = new User();
////        u.setId(12);
////        u.setName("张三");
////        u.setAge(15);
////
////        //重新设置序列化器
////        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
////        redisTemplate.opsForValue().set("user",u);

        //获取数据
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Object key = redisTemplate.opsForValue().get("user");
        System.out.println(key);

    }

    /**
     * 使用json格式存取数据
     */
    @Test
    public void testJson() {
//        User user = new User();
//       user.setAge(18);
//       user.setName("李四");
//       user.setId(23);
//
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
//        redisTemplate.opsForValue().set("user_json",user);

        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        Object user_json = redisTemplate.opsForValue().get("user_json");
        System.out.println(user_json);
    }

}
