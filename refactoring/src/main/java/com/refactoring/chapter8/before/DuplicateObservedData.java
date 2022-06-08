package com.refactoring.chapter8.before;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DuplicateObservedData extends Frame {
    
    private TextField startField;
    private TextField endField;
    private TextField lengthField;
    
    class SymFocus extends FocusAdapter {
        public void focusLost(FocusEvent event) {
            final Object object = event.getSource();
            if(object == startField) {
                StartField_FocusLost(event);
            } else if(object == endField) {
                EndField_FocusLost(event);
            } else if(object == lengthField) {
                LengthField_Focus_Lost(event);
            }
        }

        private void LengthField_Focus_Lost(FocusEvent event) {
            if(isNotInteger(lengthField.getText())) {
                lengthField.setText("0");
            }
            calculateEnd();
        }

        private boolean isNotInteger(String text) {
            return false;
        }

        private void calculateEnd() {
            try {
                int start = Integer.parseInt(startField.getText());
                int end = Integer.parseInt(endField.getText());
                int length = end - start;
                lengthField.setText(String.valueOf(length));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Unexpected Number Format Error");
            }
        }

        private void EndField_FocusLost(FocusEvent event) {
            if(isNotInteger(endField.getText())) {
                endField.setText("0");
            }
            calculateLength();
        }

        private void calculateLength() {
            try {
                int start = Integer.parseInt(startField.getText());
                int end = Integer.parseInt(endField.getText());
                int length = end -start;
                lengthField.setText(String.valueOf(length));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Unexpected Number Format Error");
            }
        }

        private void StartField_FocusLost(FocusEvent event) {
            if(isNotInteger(startField.getText())) {
                startField.setText("0");
            }
            calculateLength();
        }


    }
}
