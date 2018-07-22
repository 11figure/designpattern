/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 13:12 2018/7/21
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        ItemIterator potionIterator = new TreasureChest().iterate(ItemType.POTION);
        while (potionIterator.hasNext()) {
            System.out.println(potionIterator.next().toString());
        }
    }
}
