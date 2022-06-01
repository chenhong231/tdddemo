package com.legacycode.chapter10.undetectableside.before;

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
        if(source.equals("project activity")) {
            detailDisplay = new DetailFrame();
            detailDisplay.setDescription(getDetailText() + "" + getProjectionText());
            detailDisplay.show();
            String accountDescription = detailDisplay.getAccountSymbol();
            accountDescription += ": ";

            display.setText(accountDescription);

        }
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
