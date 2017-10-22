package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestStream {
    public static void splitFile(File file, int eachSize) {
        if (!file.exists()) {
            throw new RuntimeException("文件不存在或长度为0，不可拆分！");
        }
        byte[] fileContent = new byte[(int) file.length()];
        try {
            FileInputStream fip = new FileInputStream(file);
            fip.read(fileContent);
            fip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int fileQuantity;
        if (fileContent.length % eachSize == 0) {
            fileQuantity = fileContent.length / eachSize;
        } else {
            fileQuantity = (fileContent.length / eachSize) + 1;
        }
        for (int i = 0; i < fileQuantity; i++) {
            String fileName = file.getName() + "-" + i;
            File eachFile = new File(file.getParent(), fileName);
            byte[] eachContent;
            if (i != fileQuantity - 1) {
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
            } else {
                eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);
            }
            try {
                FileOutputStream fout = new FileOutputStream(eachFile);
                fout.write(eachContent);
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mergeFile(String fileName, String filePath) {
        int i = 0;
        File file = new File(filePath, fileName + "-new");
        try {
            FileOutputStream fout = new FileOutputStream(file);
            while (true) {
                File eachFile = new File(filePath, fileName + "-" + i++);
                if (!eachFile.exists()) {
                    break;
                }
                FileInputStream fis = new FileInputStream(eachFile);
                byte[] eachContent = new byte[(int) eachFile.length()];
                fis.read(eachContent);
                fis.close();
                fout.write(eachContent);
                fout.flush();
            }
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        File file = new File("d:/vueTest/yarn.lock");
//        int eachSize = 1024 * 20;//20kb
//        splitFile(file, eachSize);
        mergeFile("yarn.lock", "d:/vueTest");
    }
}
