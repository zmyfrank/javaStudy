package charactor;

import property.Weapon;

public class ADHero extends Hero implements AD, Mortal {

    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    public void attack() {
        physicAttack();
    }

    public ADHero() {
        super("");
        System.out.println("AD Hero的构造方法");
    }

    public ADHero(String name) {
        super(name);
        System.out.println("AD Hero的构造方法");
    }

    public void die() {
        System.out.println(name + "这个AD英雄挂了");
    }

    @Override
    public void battleWin() {
        System.out.println("ad battle win");
    }


    public void equip(Weapon w) {

    }

    public static void main(String[] args) {
       new ADHero("提莫");

    }
}
