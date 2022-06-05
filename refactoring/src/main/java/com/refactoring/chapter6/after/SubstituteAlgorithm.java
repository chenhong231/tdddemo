package com.refactoring.chapter6.after;

import java.util.Arrays;
import java.util.List;

public class SubstituteAlgorithm {

    String foundPerson(String[] people) {
        List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});

        for(int i = 0; i < people.length; i++) {
            if(candidates.contains(people[i])) {
                return people[i];
            }
        }

        return " ";
    }
}
