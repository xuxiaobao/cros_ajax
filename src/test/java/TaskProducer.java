import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;

/**
 * 使用redis模拟生产者
 * Created by xuxiaobao on 2017/7/24.
 */
public class TaskProducer implements Runnable {
    Jedis jedis = new Jedis("127.0.0.1",6379);
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(600);
                String task_id = UUID.randomUUID().toString();
                jedis.lpush("task-queue", task_id);
                System.out.println("插入了一个新任务");
            } catch (Exception e) {
                System.out.println("插入新任务失败:"+e.getMessage());
            }
        }
    }
}
