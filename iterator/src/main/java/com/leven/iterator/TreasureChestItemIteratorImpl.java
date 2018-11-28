package com.leven.iterator;

import java.util.List;

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
        return findNextIdx() != -1;
    }

    /**
     * 存在每调用一次idx更改一次的问题。
     * @return
     */
    private int findNextIdx() {
        List<Item> allItems = treasureChest.getAllItems();
        int tempIdx = idx;
        while (tempIdx < allItems.size()-1) {
            //保证同一对象每次调用返回相同值
            tempIdx++;
            ItemType nextItemType = allItems.get(tempIdx).getType();
            if (itemType.equals(nextItemType)) {
//                System.out.println(tempIdx);
                return tempIdx;
            }
        }
//        allItems.stream()
//        方法1
//        List<com.leven.iterator.Item> items = treasureChest.getAllItems();
//        boolean found = false;
//        int tempIdx = idx;
//        while (!found) {
//            tempIdx++;
//            if (tempIdx >= items.size()) {
//                tempIdx = -1;
//                break;
//            }
//            if (items.get(tempIdx).getType().equals(itemType)) {
//                found = true;
//                break;
//            }
//        }
//        return tempIdx;
        return -1;
    }

    @Override
    public Item next() {
        //let idx change to next index
        idx = findNextIdx();
        if (idx != -1) {
            return treasureChest.getAllItems().get(idx);
        }
        return null;
    }
}
