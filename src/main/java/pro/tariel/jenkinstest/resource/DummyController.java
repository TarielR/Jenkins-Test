package pro.tariel.jenkinstest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.tariel.jenkinstest.domain.Item;
import pro.tariel.jenkinstest.service.DummyService;

@RestController
@RequestMapping(path = "api")
public class DummyController {

    @Qualifier("dummy")
    private final DummyService service;

    @Autowired
    public DummyController(DummyService service) {
        this.service = service;
    }

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/string")
    public String getString() {
        return "Some string";
    }

    @GetMapping("item")
    public Item getItem() {
        return service.getItem();
    }

    @GetMapping("response")
    public ResponseEntity<Item> getResponse() {
        return new ResponseEntity<>(service.getItem(), HttpStatus.OK);
    }
}
