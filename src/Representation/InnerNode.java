package Representation;

public class InnerNode extends Node {
    private Node[] nextNodes;

    public InnerNode(int id, String description, Node[] nextNodes) {
        super(id, description);
        this.nextNodes = nextNodes;
    }

    @Override
    public void display() {
        System.out.println(description);
    }

    @Override
    public Node chooseNext() {
        // Logique de choix de noeud suivant
        return nextNodes[0]; // Exemple simplifié
    }
}
