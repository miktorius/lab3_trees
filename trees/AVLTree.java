package trees;

public class AVLTree {

    private Node root;

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.right) - height(node.left);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            throw new RuntimeException();
        }
        return rebalance(root);
    }

    public Node delete(Node node, int data) {
        if (node == null) {
            return node;
        } else if (node.data > data) {
            node.left = delete(node.left, data);
        } else if (node.data < data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.data = mostLeftChild.data;
                node.right = delete(node.right, node.data);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    public Node find(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                break;
            }
            current = current.data < data ? current.right : current.left;
        }
        return current;
    }

    private Node mostLeftChild(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
