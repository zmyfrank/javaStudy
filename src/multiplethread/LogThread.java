package multiplethread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/16 9:46
 */
public class LogThread extends Thread {
    private List<String> logList;

    public LogThread(List<String> logList) {
        this.logList = logList;
        //设置守护线程
        this.setDaemon(true);
    }

    @Override
    public void run() {
        logTheList(this.logList);
    }

    public void logTheList(List<String> list) {
        while (true) {
            while (list.size()<1) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String passWorld = list.remove(0);
            System.out.println("本次生成的密码是" + passWorld);
        }
    }
}
