import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/5/26.
 */
public class ProxyTest {

    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserServiceHandler handler = new UserServiceHandler(target);
        UserService proxy = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        proxy.sayHello("xiaobao");
    }
}
