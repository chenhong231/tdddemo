package factory.after;

public class StringParser {

    public Node find() {
        StringBuffer textBuffer = null;
        int textBegin = 0;
        int textEnd = 0;
        Parser parser = new Parser();
        NodeFactory nodeFactory = new NodeFactory();
        return nodeFactory.createStringNode(textBuffer, textBegin, textEnd);
    }
}
