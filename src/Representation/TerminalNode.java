package Representation;

import Univers.Univers;

public class TerminalNode extends Node {
    private TerminalNode terminalNode;

    public TerminalNode(int id, String description, Univers univers) {
        super(id, description, univers);
    }

    public Node chooseNext(){
        return terminalNode;
    }
}