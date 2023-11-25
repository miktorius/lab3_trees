package trees;

import java.util.InputMismatchException;

public class AVLTree {
    private Node root;

    // Constructor
    public AVLTree() {
        root = null;
    }

    // Get height of a node
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Rotate right
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Rotate left
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a node into the AVL tree
    public Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            throw new InputMismatchException();
        }

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // Perform rotations if needed to balance the tree
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Public method to insert a node
    public void insert(int data) {
        root = insert(root, data);
    }

    // ... (Previous code for AVLTree class and Node class)

    // Search for a node with a given key
    public Node search(Node node, int key) {
        if (node == null || node.data == key) {
            return node;
        }

        if (key < node.data) {
            return search(node.left, key);
        }

        return search(node.right, key);
    }

    // Public method to search for a node
    public Node search(int key) {
        return search(root, key);
    }

    // Find the node with the minimum value in a subtree
    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Delete a node with a given key
    public Node delete(Node node, int key) {
        if (node == null) {
            throw new RuntimeException();
        }

        // Perform a standard BST delete
        if (key < node.data) {
            node.left = delete(node.left, key);
        } else if (key > node.data) {
            node.right = delete(node.right, key);
        } else {
            // Node with only one child or no child
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.left) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // One child case
                    node = temp;
                }
            } else {
                // Node with two children: get the inorder successor (smallest in the right
                // subtree)
                Node temp = minValueNode(node.right);

                // Copy the inorder successor's data to this node
                node.data = temp.data;

                // Delete the inorder successor
                node.right = delete(node.right, temp.data);
            }
        }

        // If the tree had only one node, return
        if (node == null) {
            return node;
        }

        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // Perform rotations if needed to balance the tree
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Public method to delete a node with a given key
    public void delete(int key) {
        root = delete(root, key);
    }

    public Node getRoot(){
        return root;
    }
}
