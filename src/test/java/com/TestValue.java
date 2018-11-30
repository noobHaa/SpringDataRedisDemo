package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author ll
 * @Date 2018/11/15 13:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void  setValue(){
        redisTemplate.boundValueOps("ping").set("tom1");
    }

    @Test
    public void getValue(){
        Object o = redisTemplate.boundValueOps("name").get();
        System.out.println(o);
    }

    @Test
    public void deleteValue(){
        redisTemplate.delete("name");
    }
}
