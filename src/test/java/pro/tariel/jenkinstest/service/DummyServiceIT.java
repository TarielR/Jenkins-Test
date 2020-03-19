package pro.tariel.jenkinstest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import pro.tariel.jenkinstest.domain.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(DummyService.class)
//@SpringBootTest
class DummyServiceIT {

    @Autowired
    @Qualifier("dummy")
    private ItemService service;

    @Test
    void getItemTest() {
        Item actual = service.getItem();
        assertNotNull(actual);
        assertEquals("First item", actual.getName());
    }
}
