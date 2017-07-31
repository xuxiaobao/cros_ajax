import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18.
 */
public class Test {
    public static void main(String[] args) {
        testJerseyUpload();
    }

    /**
     * Json序列化和反序列化
     */
    public static void fastJson() {
        String json = "{'person':{'name':'xxb'}}";
        JSONObject object = JSON.parseObject(json);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
	    System.out.println("developer test");
        }
    }

    public static void redisProduceAndConsumer() {
        try {
            new Thread(new TaskProducer()).start();
            Thread.sleep(150);
            new Thread(new TaskConsumer()).start();
            //Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定长度的字符串，不足用0补全
     */
    public static void testStringBuilderReplace() {
        StringBuilder sb = new StringBuilder();
        sb.append("('123',");
        sb.replace(sb.length()-1, sb.length(), ")");
        System.out.println(sb.toString());
    }

    /**
     * jersey上传文件到远程服务器
     */
    public static void testJerseyUpload() {
        try {
            FileInputStream stream = FileUtils.openInputStream(new File("/Users/xuxiaobao/Downloads/ab0014b35e1da5fd12fae5a1da7ce3ff.jpeg"));
            String path = "ab0014b35e1da5fd12fae5a1da7ce3ff.jpeg";
            Client client = new Client();
            System.out.println("http://www.bossbao.img/"+path);
            WebResource resource = client.resource("http://www.bossbao.img/"+path);
            resource.put(String.class, stream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
