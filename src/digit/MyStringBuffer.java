package digit;

import java.awt.*;

public class MyStringBuffer implements IStringBuffer {
    //初始长度
    private int capacity = 16;
    //初始输入的字符串的长度
    private int length = 0;
    //存放真正字符串的char数组
    private char[] value;
    class IndexIsNagetiveException extends Exception {
        public IndexIsNagetiveException() {
        }

        public IndexIsNagetiveException(String message) {
            super(message);
        }
    }

    class IndexIsOutofRangeException extends Exception {
        public IndexIsOutofRangeException() {
        }

        public IndexIsOutofRangeException(String message) {
            super(message);
        }
    }
    public void cheakOutRange(int pos) throws IndexIsOutofRangeException {
        if (pos>length){
            throw new IndexIsOutofRangeException("下标超出范围异常");
        }
    }

    public void cheaknagetive(int pos) throws IndexIsNagetiveException {
        if (pos<0){
            throw new IndexIsNagetiveException("下标为负异常");
        }
    }
    private MyStringBuffer() {
        value = new char[capacity];
    }

    MyStringBuffer(String str) {
        this();
        if (str == null) {
            return;
        }
        length = value.length;
        if (str.length() > capacity) {
            capacity = length * 2;
            value = new char[capacity];
        }
        if (str.length() <= capacity) {
            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        }
        length = str.length();
    }

    @Override
    public String toString() {
        char[] realValue = new char[length];
        System.arraycopy(value, 0, realValue, 0, length);
        return new String(realValue);
    }

    @Override
    public void append(String str) {
        insert(length, str);
    }

    @Override
    public void append(char c) {
        append(String.valueOf(c));
    }

    @Override
    public void insert(int pos, char b) {
        insert(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) {
        try {
            cheakOutRange(pos);
            cheaknagetive(pos);
        } catch (IndexIsOutofRangeException | IndexIsNagetiveException e) {
            e.printStackTrace();
            System.out.println("具体原因是"+e.getMessage());
        }
        if (b == null)
            return;
        //扩容
        if (length + b.length() > capacity) {
            capacity = (int) ((length + b.length()) * 1.5f);
            char[] realValue = new char[capacity];
            System.arraycopy(value, 0, realValue, 0, length);
            value = realValue;
        }
        char[] cs = b.toCharArray();
        //腾出空间来给它复制
        System.arraycopy(value, pos, value, pos + cs.length, length - pos);
        //插入到制定位置
        System.arraycopy(cs, 0, value, pos, cs.length);
        length = length + cs.length;
    }

    @Override
    public void delete(int start) {
        delete(start, length);
    }

    @Override
    public void delete(int start, int end) {
        if (start < 0 || end < 0) {
            return;
        }
        if (start > length || end > length) {
            return;
        }
        if (start > end) {
            return;
        }
        System.arraycopy(value, end, value, start, end - start);
        length = end - start;
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
        return length;
    }
}
