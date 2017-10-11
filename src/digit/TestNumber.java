package digit;


import java.util.Arrays;

public class TestNumber {

    public static int randomNo() {
        return (int) (Math.random() * 128);
    }

    public static String getRandomString(int max1) {
        short an = (short) 'A';
        short zn = (short) 'Z';
        short a1n = (short) 'a';
        short z2n = (short) 'z';
        short a0n = (short) '0';
        short z9n = (short) '9';
        String result = "";
        while (result.length() < max1) {
            int x = result.length();
            int a = randomNo();
            if ((a >= an && a <= zn) || (a >= a1n && a <= z2n) || (a >= a0n && a <= z9n)) {
                char b = (char) a;
                result += b;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] b = new String[8];
        short[] c = new short[8];
        for (int i = 0; i < b.length; i++) {
            b[i] = getRandomString(5);
            char j = b[i].toLowerCase().charAt(0);
            c[i] = (short) j;
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length - 1; j++) {
                if (c[j] > c[j + 1]) {
                    short temp2 = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp2;
                    String temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(b));

    }
}