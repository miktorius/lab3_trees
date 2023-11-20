package algorithms;

import trees.Node;

public class TreeTraversal {

    static String answer = "";

    // Preorder traversal: Root, Left, Right
    public static <T> String preorderTraversal(Node<T> root) {
        if (root != null) {
            answer += root.getData() + " ";
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return answer;
    }

    // Inorder traversal: Left, Root, Right
    public static <T> String inorderTraversal(Node<T> root) {
        if (root != null) {
            inorderTraversal(root.left);
            answer += root.getData() + " ";
            inorderTraversal(root.right);
        }
        return answer;
    }

    // Postorder traversal: Left, Right, Root
    public static <T> String postorderTraversal(Node<T> root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            // System.out.print(root.getData() + " ");
            answer += root.getData() + " ";
        }
        return answer;
    }

    public static void clearAnswer() {
        answer = "";
    }
}
