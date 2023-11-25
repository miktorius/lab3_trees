package trees;

public class Node {

    protected int height;
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}