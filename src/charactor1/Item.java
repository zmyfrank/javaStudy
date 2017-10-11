package charactor1;

public abstract class Item {
    public String name;
    public int prise;
    public abstract void disposable();

    public static void main(String[] args) {
        Item xx = new Item() {
            @Override
            public void disposable() {
                System.out.println("true");
            }
        };
        xx.disposable();
    }
}
