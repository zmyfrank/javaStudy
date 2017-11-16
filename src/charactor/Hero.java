package charactor;

import property.Item;

public class Hero implements Comparable<Hero> {
    public String name; //姓名

    public float hp; //血量

    public float armor; //护甲

    public float damage;

    public int moveSpeed; //移动速度

    static String copyright;

    public Hero() {

    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    public Hero(String name, float hp, float damage) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
    }

    public void battleWin() {
        System.out.println("hero battle win");
    }

    public static void battleWin2() {
        System.out.println("hero battle win");
    }

    public void useItem(Item i) {
        System.out.println("hero use item");
        i.effect();
    }

    public void kill(Mortal m) {
        System.out.println(name + "放了一个大招，");
        m.die();
    }

    public boolean equals(Object o) {
        if (o instanceof Hero) {
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }

    public void finalize() {
        System.out.println("这个英雄正在被回收");
    }

    class BattleScore {
        int kill;
        int die;
        int assit;

        public void legenddary() {
            if (kill >= 8) {
                System.out.println(name + "超神！");
            } else {
                System.out.println(name + "还未超神！");
            }
        }
    }

    static class EnemyCrystal {
        int hp = 1000;

        public void CheackIfvictory() {
            if (hp == 1000) {
                Hero.battleWin2();
            }
        }
    }


    public static void main(String[] args) {


    }

    public boolean matched() {
        return this.hp > 100 && this.damage < 50;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }

    @Override
    public int compareTo(Hero o) {
        return (int) (damage - o.damage);
    }

    public void attackHero(Hero h) {
        h.hp -= damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);

        if (h.isDead()){
            System.out.println(h.name + "死了！");
        }
    }

    public boolean isDead() {
        return 0 >= hp;
    }

    //回血
    public synchronized void recover(){
        if (hp==616){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp+=1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }

    //掉血
    public synchronized void hurt(){
        hp-=1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }
}