package lambda;

import charactor.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestStream {
    public static int marched(){

    }
    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero("hero-"+i,random.nextInt(100),random.nextInt(1000));
            heroes.add(hero);
        }
        System.out.println("初始化数组完毕");

    }
}
