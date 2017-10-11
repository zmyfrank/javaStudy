package digit;

import java.util.Arrays;

public class Cracked {

    public static void main(String[] args) {
        int countpwd = 3;
        String pwd = aString(countpwd);
        char[] testword = pwd.toCharArray();
        char begin = '0';
        System.out.println("破解的密码为：");
        for (int i = 0; i < testword.length; i++) {
            char password = (char) searchPwd(testword[i], begin);
            System.out.print(password);
        }
        System.out.println(" ");
        System.out.println("生成的随机密码是:");
        System.out.println(pwd);


    }

    public static String aString(int number) {
        char[] stringChar = new char[number];
        short start = '0';
        short end = 'z' + 1;
        for (int i = 0; i < stringChar.length; i++) {
            while (true) {
                char c = (char) (Math.random() * (end - start) + start);
                if (Character.isDigit(c) || Character.isLetter(c)) {
                    stringChar[i] = c;
                    break;
                }
            }
        }
        String pwd = Arrays.toString(stringChar);
        return pwd;

    }


    public static char searchPwd(char password, char test) {
        short pwd = (short) password;
        short testword = (short) test;
        if (testword == pwd)
            return test;
        else {
            test = (char) ((test + 1) % 256);
            return searchPwd(password, test);
        }
    }
}
