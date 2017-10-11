package property;

public class MagicPotion extends Item {
    public void effect(){
        System.out.println("蓝瓶被使用，可以回蓝");
    }
    public boolean disposable(){
        return true;
    }
}
