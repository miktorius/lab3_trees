package trees;

public class Node<T> {

    private T _data;
    public Node<T> left, right, parent;

    public Node(T data) {
        _data = data;
        left = right = null;
    }

    public T getData() {
        return _data;
    }
}