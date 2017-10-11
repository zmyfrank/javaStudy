package property;

public class Armor extends Item {
    private int ac;
    public boolean disposable(){
        return false;
    }
    public static void main(String[] args) {
        Armor cloth = new Armor();
        Armor hauberk = new Armor();
        cloth.name = "布甲";
        cloth.prise = 20;
        cloth.ac = 30;
        hauberk.name = "锁子甲";
        hauberk.prise = 40;
        hauberk.ac = 100;
    }
}
