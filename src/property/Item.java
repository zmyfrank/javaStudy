package property;

import charactor.Hero;

public abstract class Item {
    public String name;
    public int prise;

    public void buy() {
        System.out.println("物品被购买");
    }

    public void effect() {
        System.out.println("物品被使用，已有效果");
    }

    public String toString() {
        return this.name + "" + this.prise;
    }

    public void finalize() {
        System.out.println("该对象正在被回收");
    }

    public boolean equals(Object o) {
        if (o instanceof Item) {
            Item i = (Item) o;
            return this.prise == i.prise;
        }
        return false;
    }

    public abstract boolean disposable();

    public static void main(String[] args) {
       Item bujia = new Armor();
       System.out.println(bujia.disposable());
    }
}