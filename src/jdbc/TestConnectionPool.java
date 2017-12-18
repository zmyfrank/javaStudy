package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/22 16:26
 */
public class TestConnectionPool {
    private static int threadNumber = 100;
    static int insertTime = 1;

    private static void connectionPollWay() {
        ConnectionPool poll = new ConnectionPool(10);
        List<Thread> list = new ArrayList<>();
        System.out.println("开始用线程池的方式插入");
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNumber; i++) {
            ConnectionpoolWorkingThread cwt = new ConnectionpoolWorkingThread(poll);
            cwt.start();
            list.add(cwt);
        }
        //等待所有线程结束
        for (Thread t :
                list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("一共用时"+(end-start));
    }

    private static void ordenaryWay(){
        HeroDao heroDao = new HeroDao();
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadNumber; i++) {
            Hero2 hero2 = new Hero2(1,"小明明"+i,30f,200);
            heroDao.add(hero2);
        }
        long end = System.currentTimeMillis();
        System.out.println("笨办法耗时"+(end-start));
    }

    public static void main(String[] args) {
        connectionPollWay();
        ordenaryWay();
    }
}
