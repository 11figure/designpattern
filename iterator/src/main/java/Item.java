import com.google.common.base.MoreObjects;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 12:41 2018/7/21
 * @Modified By:
 */
public class Item {

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    private ItemType type;
    private String name;

    public Item(ItemType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("type", type)
            .add("name", name)
            .toString();
    }
}
