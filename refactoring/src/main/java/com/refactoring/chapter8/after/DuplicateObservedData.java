package com.refactoring.chapter8.after;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Observable;
import java.util.Observer;

public class DuplicateObservedData extends Frame implements Observer {
    private Interval subject;
    private TextField startField;
    private TextField endField;
    private TextField lengthField;

    public DuplicateObservedData() {
        subject = new Interval();
        subject.addObserver(this);
        update(subject, null);
    }

    String getEnd() {
        return subject.getEnd();
    }

    void setEnd(String end) {
        subject.setEnd(end);
    }

    String getStart() {
        return subject.getStart();
    }

    void setStart(String start) {
        subject.setStart(start);
    }

    String getLength() {
        return subject.getLength();
    }

    void setLength(String length) {
        subject.setLength(length);
    }

    @Override
    public void update(Observable observed, Object arg) {
        endField.setText(subject.getEnd());
    }

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
            if(isNotInteger(subject.getLength())) {
                subject.setLength("0");
            }
            calculateEnd();
        }

        private boolean isNotInteger(String text) {
            return false;
        }

        private void calculateEnd() {
            subject.calculateEnd();
        }

        private void EndField_FocusLost(FocusEvent event) {
            setEnd(endField.getText());
            if(isNotInteger(getEnd())) {
                setEnd("0");
            }
            calculateLength();
        }

        private void calculateLength() {
            subject.calculateLength();
        }

        private void StartField_FocusLost(FocusEvent event) {
            if(isNotInteger(getStart())) {
                setStart("0");
            }
            calculateLength();
        }
    }
}
