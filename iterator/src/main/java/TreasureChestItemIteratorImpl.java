/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 12:33 2018/7/21
 * @Modified By:
 */
public class TreasureChestItemIteratorImpl implements ItemIterator {
    private TreasureChest treasureChest;
    private ItemType itemType;
    private int idx;

    public TreasureChestItemIteratorImpl(TreasureChest treasureChest,ItemType itemType) {
        this.treasureChest = treasureChest;
        this.itemType = itemType;
        this.idx = 0;
    }

    @Override
    public boolean hasNext() {
        return idx < treasureChest.getAllItems().size();
    }

    @Override
    public Item next() {

    }
}
