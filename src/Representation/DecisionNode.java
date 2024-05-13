package Representation;

import java.util.Scanner;

public class DecisionNode extends Node {

    private Node[] nextNodes;

    public DecisionNode(int id, String description) {
        super(id, description);
    }

    public void setNextNodes(Node[] nextNodes) {
        this.nextNodes = nextNodes;
    }

    public Node[] getNextNodes() {
        return nextNodes;
    }

    @Override
    public Node chooseNext() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez une option :");
        for (int i = 0; i < nextNodes.length; i++) {
            System.out.println((i+1) + ". " + nextNodes[i].description);
        }
        int choice = scanner.nextInt();
        scanner.close();
        return nextNodes[choice - 1];
    }
}