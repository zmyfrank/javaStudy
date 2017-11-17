package multiplethread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: Frank
 * @Date: 2017/11/17 10:21
 */
public class SearchFileThread implements Runnable  {
    private File file;
    private String search;

    public SearchFileThread(File file, String search) {
        this.file = file;
        this.search = search;
    }



    public String readFilecontent(){
        try (FileReader fileReader = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fileReader.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void run() {
        String result = readFilecontent();
        if (result.contains(search)) {
            System.out.printf("线程: %s 找到子目标字符串%s,在文件:%s%n", Thread.currentThread().getName(), search, file);
        }
    }
}
