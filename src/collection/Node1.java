package collection;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/10/30 10:53
 */
public class Node1 {
    public Node1 leftNode;
    public Node1 rightNode;
    public Object value;
    private static int NUMBERAMOUNT = 40000;

    public void add(Object v) {
        //如果没有值，就把当前数字放在节点上
        if (value == null) {
            value = v;
        } else {
            //如果有值就对比当前值和传入值的大小关系
            //如果值大于等于传入值，放左边
            if ((int) value >= (int) v) {
                if (leftNode == null) {
                    leftNode = new Node1();
                }
                leftNode.add(v);
            } else {
                //如果大的话放右边
                if (rightNode == null) {
                    rightNode = new Node1();
                }
                rightNode.add(v);
            }
        }
    }

    /**
     * 依次往下遍历，一步一步走，先左再中最后右
     *
     * @return 返回每一个遍历的结果
     */
    public List<Object> values() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftNode) {
            values.addAll(leftNode.values());
        }

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightNode) {
            values.addAll(rightNode.values());
        }


        return values;
    }



    public static void main(String[] args) {
        //产生随机数
        List<Integer> numbers = new ArrayList<>();
        System.out.println("产生随机数开始");
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBERAMOUNT; i++) {
            int number = (int) (Math.random() * NUMBERAMOUNT);
            numbers.add(number);
        }
        long b = System.currentTimeMillis();
        System.out.println("产生随机数共用时" + (b - a) + "毫秒");
        //二叉树排序
        System.out.println("开始二叉树排序");
        Node1 node = new Node1();
        long q = System.currentTimeMillis();
        for (int c :
                numbers) {
            node.add(c);
        }
        List<Object> erchashu = node.values();
        long w = System.currentTimeMillis();
        System.out.println("二叉树排序结束，共用时"+(w-q)+"毫秒");
    }
}
