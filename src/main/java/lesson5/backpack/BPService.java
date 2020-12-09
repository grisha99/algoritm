package lesson5.backpack;

import java.util.LinkedList;
import java.util.List;

public class BPService {

    private Backpack backPack;

    public BPService(Backpack backPack) {
        this.backPack = backPack;
    }

    public int getItemsValue(List<PackItem> items) {
        int sum = 0;
        for(PackItem item : items) {
            sum += item.getValue();
        }
        return sum;
    }

    public int getItemsWeight(List<PackItem> items) {
        int sum = 0;
        for(PackItem item : items) {
            sum += item.getWeight();
        }
        return sum;
    }

    /**
     *
     * Попытка упаковать полученный набор элементов
     *
     * @param items - элементы для упаковки
     */

    public void tryPackItems(List<PackItem> items) {

        if (backPack.getItems() == null) {
            if (getItemsWeight(items) <= backPack.getWeight()) {
                backPack.setItems(items);
                backPack.setItemsValue(getItemsValue(items));
            }
        } else {
            if (getItemsWeight(items) <= backPack.getWeight()) {
                if (getItemsValue(items) > backPack.getItemsValue()) {
                    backPack.setItems(items);
                    backPack.setItemsValue(getItemsValue(items));
                }
            }
        }
    }

    /**
     *
     * проверка всех комбинаций коллекции элементов
     *
     * @param items - элементы для упаковки в "рюкзак"
     */
    public void inspectItem(List<PackItem> items) {
        if (!items.isEmpty()) {
            tryPackItems(items);
        }

        for(int i = 0; i < items.size(); i++) {
            LinkedList<PackItem> newItemsList = new LinkedList<>(items);
            newItemsList.remove(i);
            inspectItem(newItemsList);
        }
    }
}
