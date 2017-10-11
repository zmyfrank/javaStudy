package zoo;

import com.sun.org.apache.xpath.internal.functions.FuncQname;

public class Fish extends Animal implements pet {
    private String name;
    public Fish(){
        super(0);
    }
    @Override
    public void walk() {
        System.out.println("鱼不能走还没有腿哦！");
    }

    @Override
    public void eat() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {

    }
}
