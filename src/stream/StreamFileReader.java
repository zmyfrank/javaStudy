package stream;


import java.io.*;

public class StreamFileReader {
    //加密
    public static void encodeFile(File encodingFile, File encodedFile) {
        try (FileReader encodingFileReader = new FileReader(encodingFile); FileWriter encodeFileWriter = new FileWriter(encodedFile)) {
            //读取文件
            char[] encdodingFileContent = new char[(int) encodingFile.length()];
            encodingFileReader.read(encdodingFileContent);
            System.out.println("加密前的文件");
            System.out.println(new String(encdodingFileContent));
            //根据规则进行转换
            useRule(encdodingFileContent);
            System.out.println("加密后的内容");
            System.out.println(new String(encdodingFileContent));
            //写入
            encodeFileWriter.write(encdodingFileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //加密规则
    public static void useRule(char[] endcodingData) {
        for (int i = 0; i < endcodingData.length; i++) {
            char c = endcodingData[i];
            if (!isPecial(c)) {
                switch (c) {
                    case '9': {
                        c = '0';
                        break;
                    }
                    case 'z': {
                        c = 'a';
                        break;
                    }
                    case 'Z': {
                        c = 'A';
                        break;
                    }
                    default: {
                        c++;
                        break;
                    }
                }
            }
            endcodingData[i] = c;
        }
    }

    //判断规则
    public static boolean isPecial(char c) {
        String normal = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return normal.indexOf(c) == -1;
    }

    public static void main(String[] args) {
        File a = new File("d:/xxx.txt");
        File b = new File("d:/xxx2.txt");
        encodeFile(a, b);
    }
}
