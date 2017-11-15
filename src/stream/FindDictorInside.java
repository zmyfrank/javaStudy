package stream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Frank
 * @Date: 2017/11/15 10:38
 */
public class FindDictorInside {
    /**
     * 读取文件内容的方法
     *
     * @param file 文件
     * @return String 文件内容
     */
    public static String readFileContent(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            char[] all = new char[(int) (file.length())];
            fileReader.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找文件
     *
     * @param file   文件
     * @param search 需要匹配文字
     */
    public static void search(File file, String search) {
        if (file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".java")) {
                BattleStream battleStream = new BattleStream(search, file);
                new Thread(battleStream).start();
            }
        }
        //处理是文件夹的情况
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File f :
                    files) {
                search(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File fileFolder = new File("d:/mywork/javaStudy");
        search(fileFolder, "up");
    }
}
