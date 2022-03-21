package xyz.yzzhanga.carcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisQueUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void pushQ(String command){
        ListOperations<String, Object> queue = redisTemplate.opsForList();
        queue.leftPush("car_order_queue", command);
        System.out.println("指令已经推送完毕:"+command);
    }


}
