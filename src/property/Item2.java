package property;

public class Item2 {
    private static Item2 instance;
    private Item2(){}
    public static Item2 getInstance(){
        if (instance==null){
            instance = new Item2();
        }
        return instance;
    }
}
