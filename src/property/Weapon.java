package property;

public class Weapon extends Item {
    int damage;
    public boolean disposable(){
        return false;
    }
    public static void main(String[] args) {
        Weapon infinityEdge = new Weapon();
        infinityEdge.name = "无尽之刃";
        infinityEdge.damage = 10000;
        infinityEdge.prise = 100;
        int test = infinityEdge.prise*3;
        System.out.println(test);
    }
}
