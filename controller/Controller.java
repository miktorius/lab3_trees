package controller;

import trees.AVLTree;
import trees.Node;
import algorithms.*;

import java.util.Scanner;

public class Controller {

    private Scanner _scanner;
    private String _output;

    public Controller() {
        _scanner = new Scanner(System.in);
        _output = "None.";
    }

    public void run() {
        while (true) {
            clearScreen();
            System.out.println("Output: " + _output);
            System.out.println("Choose a tree to test:");
            System.out.println("1. Binary Tree");
            System.out.println("2. AVL-Tree");
            System.out.println("3. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    binaryTreeTesting();
                    break;
                case "2":
                    AVLTreeTesting();
                    break;
                case "3":
                    System.out.println("Exiting program.");
                    _scanner.close();
                    System.exit(0);
                default:
                    _output = "Invalid choice.";
                    break;
            }
        }
    }

    private void binaryTreeTesting() {

        Node<Integer> binaryTreeRoot = null;
        String bracketNotation = "";
        _output = "None.";
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("Output: " + _output);
            System.out.println("Choose an option:");
            System.out.println("1. Parse bracket notation");
            System.out.println("2. Traverse inorder");
            System.out.println("3. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Input bracket notation of a tree: ");
                    bracketNotation = _scanner.nextLine();
                    try {
                        binaryTreeRoot = BracketNotationParser.parseBracketNotation(bracketNotation);
                        _output = bracketNotation;
                    } catch (Exception e) {
                        _output = "Invalid bracket notation.";
                    }
                    break;
                case "2":
                    TreeTraversal.clearAnswer();
                    if (binaryTreeRoot != null) {
                        _output = "\n\nBracket notation: " + bracketNotation + "\n\nTraversal: " + TreeTraversal.inorderTraversal(binaryTreeRoot) + "\n\n";
                    } else {
                        _output = "Tree is not set.";
                    }
                    break;
                case "3":
                    running = false;
                    _output = "None.";
                    break;
                default:
                    _output = "Invalid choice.";
                    break;
            }
        }
    }

    private void AVLTreeTesting() {
        _output = "None.";
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("Output: " + _output);
            System.out.println("Choose an option:");
            System.out.println("1. Initialize tree");
            System.out.println("2. Add");
            System.out.println("3. Remove");
            System.out.println("4. Search");
            System.out.println("5. Breadth traversal");
            System.out.println("6. Depth Traversal");
            System.out.println("7. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Input element: ");
                    Node<String> node = new Node<>(_scanner.nextLine());
                    AVLTree<String> avlTree = new AVLTree<>(node);
                    break;
                case "7":
                    running = false;
                    _output = "None.";
                    break;
                default:
                    _output = "Invalid choice.";
                    break;
            }
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
