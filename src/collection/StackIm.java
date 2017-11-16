package collection;

import charactor.Hero;

import java.util.*;

/**
 * @author: Frank
 * @Date: 2017/10/30 10:28
 */
public class StackIm implements Stack {
    private LinkedList<Hero> heroes =(LinkedList<Hero>) Collections.synchronizedList(new LinkedList<Hero>());

    //变为线程安全的之后，以后的都不用加上synchronizd来进行修饰了
    @Override
    public synchronized void push(Hero h) {
        heroes.addLast(h);
    }

    @Override
    public synchronized Hero pull() {
        return heroes.removeLast();
    }

    @Override
    public Hero peek() {
        return heroes.getLast();
    }

    public static void main(String[] args) {
        StackIm heroStack = new StackIm();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero("frank" + i);
            System.out.println("压入英雄" + hero);
            heroStack.push(hero);
        }
        for (int i = 0; i < 10; i++) {
            Hero h = heroStack.pull();
            System.out.println("弹出 hero" + h);
        }
    }
}
