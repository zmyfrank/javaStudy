package pcq;

/**
 * @author: Frank
 * @Date: 2017/11/16 17:24
 */
public class Consumer extends Thread {
    private Mylist<Character> list;

    public Consumer(Mylist<Character> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            char c = list.pull();
            System.out.println("弹出"+c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
