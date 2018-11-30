package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @Author ll
 * @Date 2018/11/15 13:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void set(){
        redisTemplate.boundListOps("nameList").rightPush("刘备");
        redisTemplate.boundListOps("nameList").rightPush("关羽");
        redisTemplate.boundListOps("nameList").rightPush("张飞");
    }

    @Test
    public void get(){
        List nameList = redisTemplate.boundListOps("nameList").range(0, 10);
        System.out.println(nameList.toString());
    }

    @Test
    public void del(){
        redisTemplate.boundListOps("nameList").remove(1,"关羽");
    }

    @Test
    public void search(){
        Object nameList = redisTemplate.boundListOps("nameList").index(1);
        System.out.println(nameList.toString());
    }
}
