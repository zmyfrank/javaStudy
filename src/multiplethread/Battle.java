package multiplethread;

import charactor.Hero;

/**
 * @author: Frank
 * @Date: 2017/11/15 10:20
 */
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        while (!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
