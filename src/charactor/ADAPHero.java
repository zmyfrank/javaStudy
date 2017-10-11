package charactor;

public class ADAPHero extends Hero implements AP, AD, Mortal {
    @Override
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }

    public ADAPHero(){
        super("");
        System.out.println("APAP构造函数");
    }
    public void die() {
        System.out.println(name + "这个混合英雄挂了");
    }

    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
    public void attack(){
        magicAttack();
    }
}
