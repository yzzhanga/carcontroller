package xyz.yzzhanga.carcontroller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CarcontrollerApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testOptKey() {
        Boolean hasKey =    redisTemplate.hasKey("aaa");
        assertTrue(!hasKey);
        redisTemplate.opsForValue().set("aaa", "I am HelloWorld!");
        Boolean hasKey1 =    redisTemplate.hasKey("aaa");
        assertTrue(hasKey1);
        redisTemplate.delete("aaa");
    }
    @Test
    public void testOptList() {
        ListOperations<String, Object> queue = redisTemplate.opsForList();
        queue.leftPush("car_order_queue", "w");
        queue.leftPush("car_order_queue","a");
        queue.leftPush("car_order_queue", "d");
        queue.leftPush("car_order_queue", "p");
        System.out.println("队列已经推送完毕");
//        long size  = queue.size("a");
//        Assert.assertEquals(3, size);
//        while (queue.size("a")>=0) {
//          String v = (String) queue.rightPop("a");
//          if (v!=null)
//            System.out.println(v);

//        }

    }



}

