package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args) {
        method3();
    }

    public static void method2() throws FileNotFoundException {
        System.out.println("试图打开");
        File f = new File("d:/XXX.exe");
        new FileInputStream(f);
        System.out.println("成功打开");
    }

    public static void mehod1() {
        try {
            method2();
        } catch (FileNotFoundException e) {
            System.out.println("打开失败");
            e.printStackTrace();
        }
    }

    private static int method3(){
        try {
            return 1;
        }catch (){
            return 2;
        }finally {
            return 3;
        }
    }
}
