package zoo;

public class Cat extends Animal implements pet {
    String name;

    public Cat() {
        this("");
    }

    public Cat(String name) {
        super(4);
        this.name = name;
    }


    @Override
    public void eat() {
        System.out.println(name + "正在吃饭");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.println(name + "正在玩耍");
    }
}
