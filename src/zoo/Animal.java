package zoo;

public abstract class Animal {
    protected int leg;

    protected Animal(int leg) {
        this.leg = leg;
    }

    public abstract void eat();

    public void walk() {
        System.out.println("这个动物用"+leg+"来行走");
    }

}
