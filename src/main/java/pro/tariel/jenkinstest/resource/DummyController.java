package pro.tariel.jenkinstest.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.tariel.jenkinstest.domain.Item;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api")
public class DummyController {
    private Item item = createItem();

    @GetMapping("/string")
    public String getString() {
        return "Some string";
    }

    @GetMapping("item")
    public Item getItem() {
        return item;
    }

    @GetMapping("response")
    public ResponseEntity<Item> getResponse() {
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    private Item createItem() {
        item = new Item("First item", LocalDateTime.now(), null);
        return item;
    }

}
