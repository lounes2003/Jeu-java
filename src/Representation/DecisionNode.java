package Representation;

import java.util.Scanner;

public class DecisionNode extends Node {
    private Node[] nextNodes;

    public DecisionNode(int id, String description, Node[] nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }

    @Override
    public void display() {
        System.out.println(description);
    }

    @Override
    public Node chooseNext() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Faites un choix : ");
        for (int i = 0; i < nextNodes.length; i++) {
            System.out.println((i + 1) + ". " + nextNodes[i].description);
        }
        int choix = scanner.nextInt();
        return nextNodes[choix - 1];
    }
}
