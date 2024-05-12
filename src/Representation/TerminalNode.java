package Representation;

import Univers.Univers;

public class TerminalNode extends Node {
    public TerminalNode(int id, String description, Univers univers) {
        super(id, description, univers);
    }

    public Node chooseNext(){
        return null;
    }

}