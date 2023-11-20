package algorithms;

import java.util.Stack;

import trees.Node;

public class BracketNotationParser {

    public static Node<Integer> parseBracketNotation(String s) {
        if (s.isEmpty()) {
            return null;
        }

        Stack<Node<Integer>> stack = new Stack<>();
        Node<Integer> root = null;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                Node<Integer> node = new Node<>(Character.getNumericValue(c));
                if (!stack.isEmpty()) {
                    Node<Integer> parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                stack.push(node);
            } else if (c == ')') {
                if (stack.size() == 1) {
                    root = stack.pop();
                } else {
                    stack.pop();
                }

            }
        }

        if (!stack.isEmpty()) {
            root = stack.pop();
        }

        return root;
    }
}