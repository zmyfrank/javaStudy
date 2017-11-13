package charactor1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Item implements Comparable<Item> {
    public String name;
    public int prise;


    public Item(String name, int prise) {
        this.name = name;
        this.prise = prise;
    }

    @Override
    public int compareTo(Item o) {
        return o.prise - prise;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item item = new Item("item" + 1, (int) (Math.random() * 100));
            items.add(item);
        }
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
    }
}
