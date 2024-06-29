package Representation;
//classe pour les tests
public class ConcreteNode extends Node {

    public ConcreteNode(int id, String description) {
        super(id, description);
    }

    @Override
    public void display(int id) {
        System.out.println("Displaying node with id: " + id);
    }

    @Override
    public Node chooseNext(int id) {
        return new ConcreteNode(id, "Next node");
    }
}
