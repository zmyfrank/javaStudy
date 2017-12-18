package reflection;

import charactor.ADHero;
import charactor.APHero;
import charactor.Hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @author: Frank
 * @Date: 2017/12/18 14:26
 */
public class TestReflection {
    public static void main(String[] args) {
        Hero hero = getHero();
        hero.name = "xiaotimo";
        System.out.println(hero);
    }
    public static Hero getHero(){
        File file = new File("D:\\mywork\\javaStudy\\src\\hero.config");
        try(FileReader fileReader = new FileReader(file)){
            String className;
            char[] all = new char[(int) file.length()];
            fileReader.read(all);
            className = new String(all);
            Class clazz = Class.forName(className);
            clazz.newInstance();
            Constructor constructor = clazz.getConstructor();
            Hero hero = (Hero) constructor.newInstance();
            return hero;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
