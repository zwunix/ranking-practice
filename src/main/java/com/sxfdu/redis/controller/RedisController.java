package com.sxfdu.redis.controller;

import com.sxfdu.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxu93@163.com
 * @date 19/7/4/004 21:11
 */
@RestController

public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisService redisService;
    /**
     * 测试redis是否可用
     * <p>
     * 导入依赖
     * 创建redisTemplate
     * 拿到方法类
     * 进行get,set并返回
     *
     * @param key
     * @param value
     * @return
     */

    @RequestMapping("/setAndGetKeyValue")
    @ResponseBody
    public String setAndGetKeyValue(String key, String value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
        Object o = valueOperations.get(key);

        
        return o.toString();
    }

    @RequestMapping("/setAndGetKeyValueService")
    @ResponseBody
    public String setAndGetKeyValueService(String key, String value) {
        redisService.set(key, value);
        Object o = redisService.get(key);
        return o.toString();
    }


}
