package com.chapter6.creationmethod.after;

public class StringNodeParsingOption {

    private boolean shouldDecodeNodes = false;

    public boolean shouldDecodeNodes() {
        return this.shouldDecodeNodes;
    }

    public void setNodeDecoding(boolean shouldDecodeNodes) {
        this.shouldDecodeNodes = shouldDecodeNodes;
    }
}
