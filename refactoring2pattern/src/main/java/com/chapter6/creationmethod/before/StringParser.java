package com.chapter6.creationmethod.before;

public class StringParser {

    private StringBuffer textBuffer;
    private int textBegin;
    private int textEnd;
    private StringParser parser;

    public Node find() {
        return StringNode.createStringNode(textBuffer, textBegin, textEnd, parser.shouldDecodeNodes());
    }

    private boolean shouldDecodeNodes() {
        return false;
    }


}
