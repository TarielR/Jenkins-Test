package pro.tariel.jenkinstest.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pro.tariel.jenkinstest.domain.Item;
import pro.tariel.jenkinstest.util.TestUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DummyControllerUnitTest {

    @Autowired
    private DummyController controller;

    private Item item;

    @BeforeEach
    void setUp() {
        item = TestUtils.retrieveItem();
    }

    @Test
    void loadContext() {
        assertNotNull(controller);
    }

    @Test
    void getString() {
        String expected = "Some string";
        String actual = controller.getString();
        assertEquals(expected, actual);
    }

    @Test
    void getItem() {
        Item actual = controller.getItem();
        actual.setCreated(item.getCreated());
        assertEquals(item, actual);
    }

    @Test
    void getResponse() {
        ResponseEntity<Item> expected = new ResponseEntity<>(item, HttpStatus.OK);
        ResponseEntity<Item> actual = controller.getResponse();
        Objects.requireNonNull(actual.getBody()).setCreated(item.getCreated());
        assertEquals(expected, actual);
    }
}
