package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Frank
 * @Date: 2017/11/14 14:41
 */
public class NodeTree<T extends Comparable<T>> {
    public NodeTree<T> leftNode;
    public NodeTree<T> rightNode;
    public T value;

    public void add(T t) {
        if (value == null) {
            value = t;
        } else {
            if (t.compareTo(value) <= 0) {
                if (leftNode == null) {
                    leftNode = new NodeTree<T>();
                }
                leftNode.add(t);
            } else {
                if (rightNode == null) {
                    rightNode = new NodeTree<T>();
                }
                rightNode.add(t);
            }
        }
    }

    public List<T> values() {
        List<T> values = new ArrayList<>();
        if (leftNode != null) {
            values.addAll(leftNode.values());
        }
        //当前节点
        values.add(value);
        //右节点
        if (rightNode != null) {
            values.addAll(rightNode.values());
        }
        return values;
    }

    public static void main(String[] args) {
        int[] randoms = new int[]{123, 124, 142, 14242, 532, 673, 432, 43, 123};
        NodeTree<Integer> numberNodeTree = new NodeTree<>();
        for (int i :
                randoms) {
            numberNodeTree.add(i);
        }
        System.out.println(numberNodeTree.values());

    }
}
