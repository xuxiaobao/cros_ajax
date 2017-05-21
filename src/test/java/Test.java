import com.cros.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xxb on 2017/5/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;

    @org.junit.Test
    public void test() {
        System.out.println(userName);
        System.out.println(password);
    }

}
