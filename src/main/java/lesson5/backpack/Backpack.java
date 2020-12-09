package lesson5.backpack;

import java.util.List;

public class Backpack {

    private final int weight;
    private int itemsValue;
    private List<PackItem> items;
    private final BPService service;

    public Backpack(int weight) {
        this.weight = weight;
        service = new BPService(this);
    }

    /**
     *
     * Упаковка элементов
     *
     * @param items - коллекция элементов
     */

    public void pack(List<PackItem> items) {
        service.inspectItem(items);
    }

    public int getWeight() {
        return weight;
    }

    public int getItemsValue() {
        return itemsValue;
    }

    public void setItemsValue(int itemsValue) {
        this.itemsValue = itemsValue;
    }

    public List<PackItem> getItems() {
        return items;
    }

    public void setItems(List<PackItem> items) {
        if (service.getItemsWeight(items) > weight) {
            throw new IllegalStateException();
        }
        this.items = items;
    }

    public BPService getService() {
        return service;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Backpack: Max weight: %d; Items weight: %d; Items count: %d; Values: %d\n", weight, service.getItemsWeight(items), items.size(), itemsValue));
        for (PackItem item : items) {
            result.append(item).append("\n");
        }

        return result.toString();
    }
}
