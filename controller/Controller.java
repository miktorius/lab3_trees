package controller;

import trees.AVLTree;
import trees.Node;
import algorithms.*;

import java.util.InputMismatchException;
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
            System.out.println("0. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    binaryTreeTesting();
                    break;
                case "2":
                    AVLTreeTesting();
                    break;
                case "0":
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
            System.out.println("2. Traverse in-order");
            System.out.println("0. Exit");
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
                case "0":
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
        int input;
        String traversal;
        _output = "None.";
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("Output: " + _output);
            System.out.println("Choose an option:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Breadth traversal");
            System.out.println("5. Depth traversal");
            System.out.println("0. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Input key to insert: ");
                    input = Integer.parseInt(_scanner.nextLine());
                    try {
                        avlTree.insert(input);
                        _output = "Key inserted.";
                    } catch (InputMismatchException e) {
                        _output = "Duplicate keys are not allowed.";
                    }
                    break;
                case "2":
                    System.out.print("Input key to delete: ");
                    input = Integer.parseInt(_scanner.nextLine());
                    try {
                        avlTree.delete(input);
                        _output = "Key deleted.";
                    } catch (RuntimeException e) {
                        _output = "Key not found.";
                    }
                    break;
                case "3":
                    System.out.print("Input key to search: ");
                    input = Integer.parseInt(_scanner.nextLine());
                    if (avlTree.search(input) != null) {
                        _output = "Key found.";
                    } else {
                        _output = "Key not found.";
                    }
                    break;
                case "4":
                    traversal = IterativeTraversal.BFS(avlTree.getRoot());
                    _output = traversal != "" ? traversal : "Tree is empty.";
                    break;
                case "5":
                    depthTraversalTesting(avlTree);
                    break;
                case "0":
                    running = false;
                    _output = "None.";
                    break;
                default:
                    _output = "Invalid choice.";
                    break;
            }
        }
    }

    private void depthTraversalTesting(AVLTree avlTree) {

        String traversal = "";
        _output = "None.";
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("Output: " + _output);
            System.out.println("Choose order of depth traversal:");
            System.out.println("1. Pre-order");
            System.out.println("2. In-order");
            System.out.println("3. Post-order");
            System.out.println("0. Exit");
            System.out.print("Input: ");
            String choice = _scanner.nextLine();
            switch (choice) {
                case "1":
                    traversal = IterativeTraversal.preorderDFS(avlTree.getRoot());
                    _output = traversal != "" ? traversal : "Tree is empty.";
                    break;
                case "2":
                    traversal = IterativeTraversal.inorderDFS(avlTree.getRoot());
                    _output = traversal != "" ? traversal : "Tree is empty.";
                    break;
                case "3":
                    traversal = IterativeTraversal.postorderDFS(avlTree.getRoot());
                    _output = traversal != "" ? traversal : "Tree is empty.";
                    break;
                case "0":
                    running = false;
                    _output = "None.";
                    break;
                default:
                    _output = "Invalid input.";
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
