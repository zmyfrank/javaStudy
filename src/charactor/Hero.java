package charactor;

import property.Item;

public class Hero {
    public String name; //姓名

    private float hp; //血量

    public float armor; //护甲

    public int moveSpeed; //移动速度

    static String copyright;

    public Hero() {
        System.out.println("Hero 的构造方法");
    }

    public Hero(String name) {
        System.out.println("Hero的有一个参数的构造方法 ");
        this.name = name;
    }

    public Hero(String name, float hp) {
        this.name = name;
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

    public void attackHero(Hero h) throws EnemyHeroIsDeadExpection{
        if (h.hp==0){
            throw new EnemyHeroIsDeadExpection(h.name +"已经挂了，不能释放技能");
        }
    }

    public static void main(String[] args) {
        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616;

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 0;
        try {
            garen.attackHero(teemo);
        } catch (EnemyHeroIsDeadExpection enemyHeroIsDeadExpection) {
            System.out.println("具体异常原因: \t"+enemyHeroIsDeadExpection.getMessage());
            enemyHeroIsDeadExpection.printStackTrace();
        }
    }
}