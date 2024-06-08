package Representation;

import java.util.Random;

public class ChanceNode extends Node {
    private Node nextNode1;
    private Node nextNode2;

    public ChanceNode(int id, String description, Node nextNode1, Node nextNode2) {
        super(id, description);
        this.nextNode1 = nextNode1;
        this.nextNode2 = nextNode2;
    }

    @Override
    public void display() {
        System.out.println(description);
    }

    @Override
    public Node chooseNext() {
        Random random = new Random();
        return random.nextBoolean() ? nextNode1 : nextNode2;
    }
}
