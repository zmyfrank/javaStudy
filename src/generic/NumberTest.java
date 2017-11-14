package generic;

import charactor.Hero;

import java.util.LinkedList;

/**
 * @author: Frank
 * @Date: 2017/11/14 14:08
 */
public class NumberTest {
    LinkedList<Hero> heroes = new LinkedList<>();
   public void push(Hero h){
       heroes.addLast(h);
   }
   public Hero pull(){
       return heroes.removeLast();
   }
   public Hero pick(){
       return heroes.getLast();
   }
}

