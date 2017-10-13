package file;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class TestFile {
    private static String maxFile = "";
    private static String minFile = "";
    private static long maxfileLength = 0;
    private static long minfileLength = 100000;

    public static void getFile(String filePath) {
        File f = new File(filePath);
        String[] fs = f.list();
        if (fs!=null){
            for (int i = 0; i < fs.length; i++) {
                String filePathN = filePath + "/" + fs[i];
                File file = new File(filePathN);
                if (file.isDirectory() && file.length() > 0) {
                    getFile(filePathN);
                } else {
                    if (file.length() > maxfileLength) {
                        maxfileLength = file.length();
                        maxFile = fs[i];
                    }
                    if (file.length() < minfileLength & file.length() != 0) {
                        minfileLength = file.length();
                        minFile = fs[i];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        getFile("c:/Windows");
        System.out.println("最大文件名为" + maxFile + "大小为" + maxfileLength);
        System.out.println("最小文件名为" + minFile + "大小为" + minfileLength);
    }
}
