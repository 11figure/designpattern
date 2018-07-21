import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 12:41 2018/7/21
 * @Modified By:
 */
public class TreasureChest {

    private List<Item> items;

    public TreasureChest() {
        items = new ArrayList<>();
        items.add(new Item(ItemType.Anay, "any"));
        items.add(new Item(ItemType.WEAPON, "weapon"));
        items.add(new Item(ItemType.RING, "ring"));
        items.add(new Item(ItemType.POTION, "potion"));
    }

    ItemIterator iterate(ItemType itemType) {
        return new TreasureChestItemIteratorImpl(this, itemType);
    }

    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        list.addAll(items);
        return list;
    }


}
