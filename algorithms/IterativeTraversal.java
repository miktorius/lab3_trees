package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import trees.Node;

public class IterativeTraversal {

    // Depth traversal
    public static String preorderDFS(Node root) {

        String answer = "";

        if (root == null) {
            return "";
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            answer += current.data + " ";

            // Push the right child first, so it's processed after the left child
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return answer;
    }

    public static String inorderDFS(Node root) {

        String answer = "";

        if (root == null) {
            return answer;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            answer += current.data + " ";
            current = current.right;
        }

        return answer;
    }

    public static String postorderDFS(Node root) {

        String answer = "";

        if (root == null) {
            return answer;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            Node current = stack2.pop();
            answer += current.data + " ";
        }
        return answer;

    }

    // Breadth traversal

    public static String BFS(Node root) {
        String answer = "";

        if (root == null) {
            return answer;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            answer += current.data + " ";

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return answer;
    }
}
