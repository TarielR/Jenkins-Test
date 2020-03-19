package pro.tariel.jenkinstest.service;

import org.springframework.stereotype.Service;
import pro.tariel.jenkinstest.domain.Item;
import pro.tariel.jenkinstest.util.ItemUtils;

@Service("dummy")
public class DummyService implements ItemService{

    @Override
    public Item getItem() {
        return ItemUtils.retrieveItem();
    }
}
