package factory.before;

public class StringParser {

    public Node find() {
        StringBuffer textBuffer = null;
        int textBegin = 0;
        int textEnd = 0;
        Parser parser = new Parser();
        return StringNode.createStringNode(textBuffer, textBegin, textEnd, parser.shouldDecodeNodes());
    }
}
