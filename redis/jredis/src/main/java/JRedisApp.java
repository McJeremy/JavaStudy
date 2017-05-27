import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by win10 on 2017/5/27.
 */
public class JRedisApp {
    public static void main(String[] args)
    {
        Jedis redis=new Jedis("127.0.0.1",6379);
//        jedis.auth("");
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
