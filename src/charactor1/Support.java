package charactor1;

import charactor.Hero;

public class Support extends Hero {
    public void heal(Hero h1,int hp) {
        System.out.println(name+'给'+h1.name+"恢复了"+hp+"点血量");
    }
    public void attack(){
        System.out.println("进行了治疗");
    }
    public static void main(String[] args) {

    }
}
