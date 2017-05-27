import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win10 on 2017/5/27.
 */
public class SharedApp {
    public static void main(String[] args) {
        List<JedisShardInfo> shards=new ArrayList<JedisShardInfo>();
        JedisShardInfo s1=new JedisShardInfo("127.0.0.1",6379);
//        s1.setPassword("");
        shards.add(s1);
        JedisShardInfo s2=new JedisShardInfo("127.0.0.1",6379);
        shards.add(s2);

        //方式1，直接使用分片
        ShardedJedis shardedJedis=new ShardedJedis(shards);
        shardedJedis.set("name","xuzz");
        System.out.println(shardedJedis.get("name"));

        //方式2，使用分片连接池
        JedisPoolConfig config =new JedisPoolConfig();//Jedis池配置
        config.setMaxTotal(500);//最大活动的对象个数
        config.setMaxIdle(1000 * 60);//对象最大空闲时间
        config.setMaxWaitMillis(1000 * 10);//获取对象时最大等待时间
        config.setTestOnBorrow(true);
        ShardedJedisPool shardedJedisPool=new ShardedJedisPool(config,shards);
        ShardedJedis shardedJedis2=shardedJedisPool.getResource();
        shardedJedis2.set("name","xuzz2");
        System.out.println(shardedJedis2.get("name"));
    }
}
