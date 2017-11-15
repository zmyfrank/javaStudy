package stream;

import java.io.File;

/**
 * @author: Frank
 * @Date: 2017/11/15 10:56
 */
public class BattleStream implements Runnable {
    private String search;
    private File file;

    public BattleStream(String search, File file) {
        this.search = search;
        this.file = file;
    }

    @Override
    public void run() {
        String filecontent = FindDictorInside.readFileContent(this.file);
        assert filecontent != null;
        if (filecontent.contains(this.search)) {
            System.out.printf("找到子目标字符串%s，在文件：%s%n", this.search, this.file);
        }
    }
}
