package Representation;

import Univers.*;

public abstract class Node {
    protected int id;
    protected String description;

    public Node(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract void display();
    public abstract Node chooseNext();
}
