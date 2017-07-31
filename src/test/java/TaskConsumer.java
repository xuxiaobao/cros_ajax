import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * 使用redis模拟消费者
 * Created by xuxiaobao on 2017/7/24.
 */
public class TaskConsumer implements Runnable {
    Jedis jedis = new Jedis("127.0.0.1",6379);
    @Override
    public void run() {
        while (true) {
            String task_id = jedis.rpoplpush("task-queue", "tmp-queue");
            if (StringUtils.isEmpty(task_id)) continue;
            System.out.println("消费者获取任务："+task_id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务处理成功！");
        }
    }
}
