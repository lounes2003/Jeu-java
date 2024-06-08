package Representation;

public class TerminalNode extends Node {
    public TerminalNode(int id, String description) {
        super(id, description);
    }

    @Override
    public void display() {
        System.out.println("Fin du jeu : " + description);
    }

    @Override
    public Node chooseNext() {
        return this;
    }
}
