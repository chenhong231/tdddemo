package com.chapter6.creationmethod.after;

public class StringParser {

    private StringBuffer textBuffer;
    private int textBegin;
    private int textEnd;
    private StringNodeParsingOption stringNodeParsingOption = new StringNodeParsingOption();


    public Node find() {
        NodeFactory nodeFactory = new NodeFactory();
        return nodeFactory.createStringNode(textBuffer, textBegin, textEnd, stringNodeParsingOption.shouldDecodeNodes());
    }

    public StringNodeParsingOption getStringNodeParsingOption() {
        return stringNodeParsingOption;
    }

    public void setStringNodeParsingOption(StringNodeParsingOption stringNodeParsingOption) {
        this.stringNodeParsingOption = stringNodeParsingOption;
    }
}
