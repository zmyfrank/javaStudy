package multiplethread;

import charactor.Hero;

/**
 * @author: Frank
 * @Date: 2017/11/15 10:03
 */
public class KillThread extends Thread {
    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2) {
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
