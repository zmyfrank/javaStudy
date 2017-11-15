package multiplethread;

import charactor.Hero;

/**
 * @author: Frank
 * @Date: 2017/11/15 10:00
 */
public class TestThread {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;


        Thread t3 = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    if (i < 3) {
                        System.out.println("波动拳");
                        i++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("开始充能，5s");
                        i = 0;
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        };

        t3.start();

    }
}
