package charactor;

public class APHero extends Hero implements AP,Mortal{
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }
    public void attack(){
        magicAttack();
    }
    public void die(){
        System.out.println(name+"这个ad英雄挂了");
    }
}
