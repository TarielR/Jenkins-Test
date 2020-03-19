package pro.tariel.jenkinstest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

class DummyServiceUnitTest {

    @Autowired
    @Qualifier("dummy")
    private ItemService service;

    @Test
    void getItem() {

    }
}
