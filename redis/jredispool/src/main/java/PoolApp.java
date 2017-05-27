import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by win10 on 2017/5/27.
 */
public class PoolApp {
    public static void main(String[] args)
    {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("redis");
        JedisPoolConfig redisPoolConfig=new JedisPoolConfig();
        redisPoolConfig.setMaxIdle(Integer.valueOf(resourceBundle.getString("redis.pool.maxIdle")));
        redisPoolConfig.setMaxTotal(Integer.valueOf(resourceBundle.getString("redis.pool.maxActive")));
        redisPoolConfig.setMaxWaitMillis(Integer.valueOf(resourceBundle.getString("redis.pool.maxWait")));
        redisPoolConfig.setTestOnBorrow(Boolean.valueOf(resourceBundle.getString("redis.pool.testOnBorrow")));
        redisPoolConfig.setTestOnReturn(Boolean.valueOf(resourceBundle.getString("redis.pool.testOnReturn")));

        JedisPool pool = new JedisPool(redisPoolConfig,resourceBundle.getString("redis.ip"),Integer.valueOf(resourceBundle.getString("redis.port")));

        Jedis redis=pool.getResource();
        redis.del("name");
        System.out.println("获取到的name:"+redis.get("name"));
        redis.set("name","xuzz");
        redis.set("name", "xuzz111");
        System.out.println("获取到的name:"+redis.get("name"));
        redis.set("id", "123456");
        redis.set("address", "chengdu");
//SETEX key seconds value将值value关联到key，并将key的生存时间设为seconds(以秒为单位)。
        redis.setex("foo", 5, "haha");
//MSET key value [key value ...]同时设置一个或多个key-value对。
        redis.mset("haha","111","xixi","222");
//redis.flushAll();清空所有的key
        System.out.println(redis.dbSize());//dbSize是多少个key的个数
//APPEND key value如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
        redis.append("foo", "00");//如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
//GET key 返回key所关联的字符串值
        redis.get("foo");
//MGET key [key ...] 返回所有(一个或多个)给定key的值
        List list = redis.mget("haha","xixi");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
