package lesson5.backpack;

public class PackItem {

    public static int initID = 0;

    private int id;
    private int weight;
    private int value;

    {
        initID++;
    }

    public PackItem(int weight, int value) {
        id = initID;
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Item: [ id=%d; weight=%d; value=%d ]", id, weight, value);
    }
}
