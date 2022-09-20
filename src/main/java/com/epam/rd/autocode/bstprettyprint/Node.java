package com.epam.rd.autocode.bstprettyprint;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Node<T extends Comparable<T>> {

    T value;

    Node<T> left, right;

    public void insertToTree(T v) {

        if (value == null) {
            value = v;
            return;
        }
        if (value.equals(v))
            return;
        if (v.compareTo(value) > 0) {
            if (left == null) {
                left = new Node<T>();
            }
            left.insertToTree(v);
        } else {
            if (right == null) {
                right = new Node<T>();
            }
            right.insertToTree(v);
        }
    }

    public void printTree(StringBuilder out) throws IOException {

        if (right != null) {
            right.printTree(out, true, " ".repeat(value.toString().length() - 1));
        }
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, " ".repeat(value.toString().length() - 1));
        }
    }

    private void printNodeValue(StringBuilder out) throws IOException {
        if (value == null) {
            out.append("<null>");
        } else {

            if (right != null && left == null)
                out.append(value.toString()).append("┘");
            else if (left != null && right == null)
                out.append(value.toString()).append("┐");
            else if (right != null)
                out.append(value.toString()).append("┤");
            else
                out.append(value.toString());

        }
        out.append('\n');
    }

    private void printTree(StringBuilder out, boolean isRight, String indent) throws IOException {


        if (right != null) {
            right.printTree(out, true, indent + (isRight ? " ".repeat(value.toString().length() + 1)
                    : " │" + " ".repeat(value.toString().length() - 1)));
        }

        out.append(indent);
        if (isRight) {
            out.append(" ┌");
        } else {
            out.append(" └");
        }

        printNodeValue(out);

        if (left != null) {

            left.printTree(out, false, indent + (isRight ? " │" + " ".repeat(value.toString().length() - 1)
                    : "" + " ".repeat(value.toString().length() + 1)));
        }
    }

}