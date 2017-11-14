package generic;

import charactor.APHero;
import charactor.Hero;

import java.util.ArrayList;

/**
 * @author: Frank
 * @Date: 2017/11/14 15:12
 */
public class HeroStack {
    public static void iterates(ArrayList<? extends Hero> list){
        for (Hero h :
                list) {
            System.out.println(h.name);
        }
    }
    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<APHero> apHeroes = new ArrayList<>();
        //不可以！
        //apHeroes = heroes;
    }
}
