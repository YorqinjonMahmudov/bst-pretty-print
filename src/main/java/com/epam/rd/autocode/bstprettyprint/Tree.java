package com.epam.rd.autocode.bstprettyprint;

import java.io.IOException;

public class Tree implements PrintableTree{

    private Node<Integer> node = new Node<>();

    @Override
    public void add(int i) {
        node.insertToTree(i);
    }

    @Override
    public String prettyPrint() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            node.printTree(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
