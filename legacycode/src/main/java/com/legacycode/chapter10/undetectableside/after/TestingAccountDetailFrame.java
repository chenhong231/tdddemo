package com.legacycode.chapter10.undetectableside.after;

public class TestingAccountDetailFrame extends AccountDetailFrame {

    String displayText = "";
    String accountSymbol = "";

    void setDescription(String description) {
    }

    String getAccountSymbol() {
        return accountSymbol;
    }

    void setDisplayText(String text) {
        displayText = text;
    }

    public void testPerformCommand() {
        final TestingAccountDetailFrame frame = new TestingAccountDetailFrame();
        frame.accountSymbol = "SYM";
        frame.performCommand("project activity");
    }
}
