import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/26.
 */
public class UserServiceHandler implements InvocationHandler {
    private Object target;

    public UserServiceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行!");
        Object obj = method.invoke(target, args);
        System.out.println("执行结束!");
        return obj;
    }
}
