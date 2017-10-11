package digit;

public class MyStringBuffer implements IStringBuffer {
    //初始长度
    private int capacity = 16;
    //初始输入的字符串的长度
    private int length = 0;
    //存放真正字符串的char数组
    private char[] value;

    public MyStringBuffer() {
        value = new char[capacity];
    }

    public MyStringBuffer(String str) {
        if (str != null) {
            value = str.toCharArray();
        }
        length = value.length;
        if (length > capacity) {
            capacity = length * 2;
        }
    }

    @Override
    public String toString() {
        char[] realValue = new char[length];
        System.arraycopy(value, 0, realValue, 0, length);
        return new String(realValue);
    }

    @Override
    public void append(String str) {

    }

    @Override
    public void append(char c) {

    }

    @Override
    public void insert(int pos, char b) {

    }

    @Override
    public void insert(int pos, String b) {
        if (pos > length)
            return;
        if (pos < 0)
            return;
        if (b == null)
            return;
        if (length + b.length() > capacity) {
            capacity = (int) ((length + b.length()) * 1.5f);
            char[] realValue = new char[capacity];
            System.arraycopy(value, 0, realValue, 0, length);
            value = realValue;
        }
    }

    @Override
    public void delete(int start) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++) {
            char temp = value[i];
            value[i] = value[length - i - 1];
            value[length - i - 1] = temp;
        }
    }

    @Override
    public int length() {
        return 0;
    }
}
