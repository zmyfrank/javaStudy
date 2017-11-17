package multiplethread;

import charactor.Hero;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Frank
 * @Date: 2017/11/15 10:00
 */
public class TestThread {
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    public static void searchFile(File file, String search) {
        if (file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".java")) {
                SearchFileThread searchFileThread = new SearchFileThread(file, search);
                threadPool.execute(searchFileThread);
            }
        }
        if (file.isDirectory()) {
            File[] file1 = file.listFiles();
            assert file1 != null;
            for (File f :
                    file1) {
                searchFile(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("d:/mywork/javaStudy");
        String searchName1 = "1";
        String searchName2 = "u";
        searchFile(file,searchName1);
        searchFile(file,searchName2);
    }
}
