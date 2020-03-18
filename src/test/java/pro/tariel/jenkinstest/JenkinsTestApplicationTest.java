package pro.tariel.jenkinstest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsTestApplicationTest {

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected JenkinsTestApplication cxt;

    @Test
    public void contextLoads() {
        assertNotNull(wac.getServletContext());
        assertNotNull(cxt);

    }
}
