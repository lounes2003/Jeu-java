package Representation;

public class InnerNode extends Node {
    private Node[] nextNodes;

    public InnerNode(int id, String description, Univers univers ,Node[] nextNodes) {
        super(id, description, univers);
        this.nextNodes = nextNodes;
    }
    public InnerNode(Node[] nextNodes) {
        this.nextNodes = nextNodes;
    }

    // Méthode pour obtenir les nœuds connectés
    public Node[] getNextNodes() {
        return nextNodes;
    }

    // Méthode pour définir les nœuds connectés
    public void setNextNodes(Node[] nextNodes) {
        this.nextNodes = nextNodes;
    }

    @Override
    public Node chooseNext() {
        return null;
    }
}