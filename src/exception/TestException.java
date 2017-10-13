package exception;


import java.io.File;
import java.io.FileInputStream;

public class TestException {
    static void testFn() throws Throwable {
        File file = new File("d:/xxx.exe");
        new FileInputStream(file);
    }

    public static void main(String[] args) {
        try {
            testFn();
        } catch (Throwable throwable) {
            System.out.println("file is not found");
            throwable.printStackTrace();
        }
    }
}
