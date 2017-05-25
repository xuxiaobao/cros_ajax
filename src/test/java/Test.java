import com.cros.Application;
import com.cros.event.MailSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xxb on 2017/5/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
    @Autowired
    private MailSender mailSender;

    public void test() {
        mailSender.sendMail("2209649004@qq.com");
    }

    @org.junit.Test
    public void testRunnable() {
        new Thread(new MyRunnable("hao")).start();
    }

}
