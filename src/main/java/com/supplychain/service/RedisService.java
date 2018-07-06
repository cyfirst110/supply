package com.supplychain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by DQ on 2018/2/3.
 */
@Service
public class RedisService {
    //@Autowired
//    private RedisTemplate redisTemplate;
//    /**
//     * 写入缓存
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(final String key, Object value) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.set(key, value);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//    /**
//     * 写入缓存设置时效时间
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(final String key, Object value, Long expireTime) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.set(key, value);
//            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//    /**
//     * 批量删除对应的value
//     * @param keys
//     */
//    public void remove(final String... keys) {
//        for (String key : keys) {
//            remove(key);
//        }
//    }
//
//    /**
//     * 批量删除key
//     * @param pattern
//     */
//    public void removePattern(final String pattern) {
//        Set<Serializable> keys = redisTemplate.keys(pattern);
//        if (keys.size() > 0)
//            redisTemplate.delete(keys);
//    }
//    /**
//     * 删除对应的value
//     * @param key
//     */
//    public void remove(final String key) {
//        if (exists(key)) {
//            redisTemplate.delete(key);
//        }
//    }
//    /**
//     * 判断缓存中是否有对应的value
//     * @param key
//     * @return
//     */
//    public boolean exists(final String key) {
//        return redisTemplate.hasKey(key);
//    }
//    /**
//     * 读取缓存
//     * @param key
//     * @return
//     */
//    public Object get(final String key) {
//        Object result = null;
//        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//        result = operations.get(key);
//        return result;
//    }
//    /**
//     * 哈希 添加
//     * @param key
//     * @param hashKey
//     * @param value
//     */
//    public void hmSet(String key, Object hashKey, Object value){
//        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//        hash.put(key,hashKey,value);
//    }
//
//    /**
//     * 哈希获取数据
//     * @param key
//     * @param hashKey
//     * @return
//     */
//    public Object hmGet(String key, Object hashKey){
//        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
//        return hash.get(key,hashKey);
//    }
//
//    /**
//     * 列表添加
//     * @param k
//     * @param v
//     */
//    public void lPush(String k,Object v){
//        ListOperations<String, Object> list = redisTemplate.opsForList();
//        list.rightPush(k,v);
//    }
//
//    /**
//     * 列表获取
//     * @param k
//     * @param l
//     * @param l1
//     * @return
//     */
//    public List<Object> lRange(String k, long l, long l1){
//        ListOperations<String, Object> list = redisTemplate.opsForList();
//        return list.range(k,l,l1);
//    }
//
//    /**
//     * 集合添加
//     * @param key
//     * @param value
//     */
//    public void add(String key,Object value){
//        SetOperations<String, Object> set = redisTemplate.opsForSet();
//        set.add(key,value);
//    }
//
//    /**
//     * 集合获取
//     * @param key
//     * @return
//     */
//    public Set<Object> setMembers(String key){
//        SetOperations<String, Object> set = redisTemplate.opsForSet();
//        return set.members(key);
//    }
//
//    /**
//     * 有序集合添加
//     * @param key
//     * @param value
//     * @param scoure
//     */
//    public void zAdd(String key,Object value,double scoure){
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        zset.add(key,value,scoure);
//    }
//
//    /**
//     * 有序集合获取
//     * @param key
//     * @param scoure
//     * @param scoure1
//     * @return
//     */
//    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        return zset.rangeByScore(key, scoure, scoure1);
//    }


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String,String> valueOperationsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object,Object> valueOperationsObj;

    /**
     * 根据指定key获取String
     * @param key
     * @return
     */
    public String getStr(String key){
        return valueOperationsStr.get(key);
    }

    /**
     * 设置String缓存
     * @param key
     * @param val
     */
    public void setStr(String key,String val){
        valueOperationsStr.set(key,val);
    }

    /**
     * 删除
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o){
        return valueOperationsObj.get(o);
    }

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object o1,Object o2){
        valueOperationsObj.set(o1,o2);
    }

    /**
     * 删除
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }




    public static void main(String[] args) {
        Jedis jedis=new Jedis("106.14.20.226",6379);
        System.out.println(jedis.ping());
        jedis.close();
    }

}
