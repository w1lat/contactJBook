package vi.talya.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vitalii on 11.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class AppConfigurationTest {

    @Test
    public void contextLoads() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context.xml");
        assertThat(applicationContext, is(notNullValue()));
    }
}
