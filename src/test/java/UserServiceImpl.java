/**
 * Created by Administrator on 2017/5/26.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello "+ name + "!");
    }
}
