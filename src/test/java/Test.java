import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/18.
 */
public class Test {
    public static void main(String[] args) {
        fastJson();
    }

    /**
     * Json序列化和反序列化
     */
    public static void fastJson() {
        String json = "{'person':{'name':'xxb'}}";
        JSONObject object = JSON.parseObject(json);
        for (Map.Entry<String, Object> entry : object.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
	    System.out.println("test");
        }
    }
}
