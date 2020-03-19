package pro.tariel.jenkinstest.util;

import pro.tariel.jenkinstest.domain.Asset;
import pro.tariel.jenkinstest.domain.Item;

import java.time.LocalDateTime;

public class ItemUtils {
    private static Asset retrieveAssetWithoutNull() {
        return new Asset("40", "30", "20","3", "7");
    }

    private static Asset retrieveAssetWithOneNull() {
        return new Asset("40", "30", "20",null, "10");
    }

    private static Asset retrieveAssetWithTwoNulls() {
        return new Asset("40", "30", null,null, "30");
    }

    private static Asset retrieveAssetWithThreeNulls() {
        return new Asset("40", null, "60",null, null);
    }

    private static Asset retrieveAssetWithFourNulls() {
        return new Asset(null, "100", null,null, null);
    }

    public static Item retrieveItem() {
        return new Item("First item", LocalDateTime.now(), retrieveAssetWithoutNull());
    }


}
