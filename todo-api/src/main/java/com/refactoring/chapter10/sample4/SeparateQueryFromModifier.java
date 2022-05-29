package com.refactoring.chapter10.sample4;

public class SeparateQueryFromModifier {

    void sendAlert(String[] people) {
        if( !("".equals(foundPerson(people)))) {
            sendAlert();
        }
    }

    private void sendAlert() {
    }

    String foundPerson(String [] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals ("Don")){
                return "Don";
            }
            if (people[i].equals ("John")){
                return "John";
            }
        }
        return "";
    }



    void checkSecurity(String[] people) {
        sendAlert(people);
        String found = foundPerson(people);
        someLaterCode(found);
    }

    private void someLaterCode(String found) {

    }
}
