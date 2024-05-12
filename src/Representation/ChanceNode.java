package Representation;

import java.util.Random;

public class ChanceNode extends Node{
    public ChanceNode(int id, String description) {
        super(id, description);
    }

    @Override
    public Node chooseNext() {
        Random random = new Random();
        int index = random.nextInt(nextNodes.length);
        return nextNodes[index];
    }
}
