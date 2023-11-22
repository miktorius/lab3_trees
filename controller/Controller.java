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

        Node binaryTreeRoot = null;
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
                    RecursiveTraversal.clearAnswer();
                    if (binaryTreeRoot != null) {
                        _output = "\n\nBracket notation: " + bracketNotation + "\n\nTraversal: "
                                + RecursiveTraversal.inorderTraversal(binaryTreeRoot) + "\n\n";
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

        AVLTree avlTree = new AVLTree();
        _output = "None.";
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("Output: " + _output);
            System.out.println("Choose an option:");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Search");
            System.out.println("4. Breadth traversal");
            System.out.println("5. Depth Traversal");
            System.out.println("6. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Input element: ");
                    int input = Integer.parseInt(_scanner.nextLine());
                    try {
                        avlTree.insert(new Node(input), input);
                    } catch (RuntimeException e) {
                        _output = "No duplicate keys allowed.";
                    }
                    break;
                case "2":

                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
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
