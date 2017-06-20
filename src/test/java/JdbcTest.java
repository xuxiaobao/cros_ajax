import com.cros.Application;
import com.cros.pojo.Person;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class JdbcTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @org.junit.Test
    public void test(final List<Person> personList) {
        System.out.println(jdbcTemplate.getDataSource());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "";
        jdbcTemplate.update(sql, keyHolder);
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement statement, int i) throws SQLException {
                Person person = personList.get(i);
                ResultSet rs = statement.getGeneratedKeys();

            }

            @Override
            public int getBatchSize() {
                return personList.size();
            }
        });
    }
}
