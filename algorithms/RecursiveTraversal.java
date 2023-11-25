package algorithms;

import trees.Node;

public class RecursiveTraversal {

    static String answer = "";

    // Depth traversal

    // Preorder traversal: Root, Left, Right
    public static String preorderTraversal(Node root) {
        if (root != null) {
            answer += root.data + " ";
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return answer;
    }

    // Inorder traversal: Left, Root, Right
    public static String inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            answer += root.data + " ";
            inorderTraversal(root.right);
        }
        return answer;
    }

    // Postorder traversal: Left, Right, Root
    public static String postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            answer += root.data + " ";
        }
        return answer;
    }

    public static void clearAnswer() {
        answer = "";
    }
}
