package charactor;

public class Hero2 {
    private Hero2(){}
    private static Hero2 instance = new Hero2();
    public static Hero2 getInstance() {
        return instance;
    }
}
