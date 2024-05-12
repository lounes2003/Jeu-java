package Representation;
import Univers.Univers;

public abstract class Node {
    protected int id;
    protected String description;
    protected Univers univers;

    public Node(){

    }

    public Node(int id, String description, Univers univers) {
        this.id = id;
        this.description = description;
        this.univers = univers;
    }

    public Node(int id, String description){
        this.id = id;
        this.description = description;
    }

    public abstract Node chooseNext();

    public void display() {
        System.out.println(description);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}