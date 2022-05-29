package lambdasinaction.chap5;

import lambdasinaction.chap4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

import static lambdasinaction.chap4.Dish.menu;

public class Mapping {

    public static void main(String...args){
        // map
        List<Integer> dishNames = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNames);

        System.out.println("===================================================");

        // map
        List<String> words = Arrays.asList("Hello", "World");
        words.stream().map(String::length)
                .collect(toList());

        System.out.println(words);
        System.out.println("=======================================================");

        List<String> uniqueCharacters = words.stream()
                .map( w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);
    }
}
