import com.cros.pojo.Person;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxb on 2017/6/1.
 */
public class XStreamTest {

    private static XStream xStream;
    static {
        xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
    }
    public static void main(String[] args) {

        Person person = new Person();
        Person.User user1 = new Person.User();
        user1.setUserName("x1");
        user1.setPassword("p1");
        Person.User user2 = new Person.User();
        user2.setUserName("x2");
        user2.setPassword("p2");

        List<Person.User> users = new ArrayList<Person.User>();
        users.add(user1);
        users.add(user2);

        person.setArea("beijing");
        person.setTotal(2);
        person.setUsers(users);

        String xml = xStream.toXML(person);
        System.out.println(xml);

        Person p = (Person) xStream.fromXML(xml);
        System.out.println(p);
    }
}
