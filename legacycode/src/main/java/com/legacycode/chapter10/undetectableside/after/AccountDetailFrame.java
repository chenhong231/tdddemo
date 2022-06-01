package com.legacycode.chapter10.undetectableside.after;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AccountDetailFrame extends Frame implements ActionListener, WindowListener {

    private TextField display = new TextField(10);
    private DetailFrame detailDisplay;

    public AccountDetailFrame() {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String source = (String) event.getActionCommand();
        performCommand(source);
    }

    public void performCommand(String source) {
        if(source.equals("project activity")) {
            setDescription(getDetailText() + "" + getProjectionText());
            String accountDescription = getAccountSymbol();
            accountDescription += ": ";

            setDisplayText(accountDescription);
        }
    }

    private void setDisplayText(String accountDescription) {
        display.setText(accountDescription);
    }

    private void setDescription(String description) {
        detailDisplay = new DetailFrame();
        detailDisplay.setDescription(description);
        detailDisplay.show();
    }

    private String getAccountSymbol() {
        return detailDisplay.getAccountSymbol();
    }

    private String getProjectionText() {
        return "";
    }

    private String getDetailText() {
        return "";
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
