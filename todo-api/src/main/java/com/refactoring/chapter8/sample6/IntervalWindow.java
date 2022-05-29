package com.refactoring.chapter8.sample6;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class IntervalWindow extends Frame implements Observer {

    private Interval _subject;

    private TextField _startField;
    private TextField _endField;
    private TextField _lengthField;

    public IntervalWindow() {
        _subject = new Interval();
        _subject.addObserver(this);
        update(_subject, null);

    }

    @Override
    public void update(Observable observed, Object arg) {
        _endField.setText(_subject.getEnd());
    }

    String getEnd() {
        return _subject.getEnd();
    }

    void setEnd(String arg) {
        _subject.setEnd(arg);
    }

    class SymFocus extends java.awt.event.FocusAdapter
    {
        public void focusLost(java.awt.event.FocusEvent event)
        {
            Object object = event.getSource();
            if (object == _startField)
                StartField_FocusLost(event);
            else if (object == _endField)
                EndField_FocusLost(event);
            else if (object == _lengthField)
                LengthField_FocusLost(event);
        }

        void StartField_FocusLost(java.awt.event.FocusEvent event) {
            if (isNotInteger(_startField.getText()))
                _startField.setText("0");
            calculateLength();
        }

        void EndField_FocusLost(java.awt.event.FocusEvent event) {
            setEnd(_endField.getText());
            if (isNotInteger(getEnd()))
                setEnd("0");
            calculateLength();
        }

        private boolean isNotInteger(String text) {
            return false;
        }

        void LengthField_FocusLost(java.awt.event.FocusEvent event) {
            if (isNotInteger(_lengthField.getText()))
                _lengthField.setText("0");
            calculateEnd();
        }
    }

    void calculateLength(){
        try {
            int start = Integer.parseInt(_startField.getText());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            _lengthField.setText(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException ("Unexpected Number Format Error");
        }
    }

    void calculateEnd() {
        try {
            int start = Integer.parseInt(_startField.getText());
            int length = Integer.parseInt(_lengthField.getText());
            int end = start + length;
            setEnd(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException ("Unexpected Number Format Error");
        }
    }
}
