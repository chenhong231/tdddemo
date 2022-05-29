package lambdasinaction.chap5;

import lambdasinaction.chap4.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

import static lambdasinaction.chap4.Dish.menu;

public class Filtering {

    public static void main(String...args){
        List<Dish> vegetarianMenu =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());

        vegetarianMenu.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter( i -> i%2 == 0)
                .distinct()
                .forEach(System.out::println);

        List<Dish> dishes = menu.stream()
                .filter( d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        dishes.forEach(System.out::println);

        System.out.println("=================================");

        // Skipping elements
        List<Dish> dishesSkip2 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(toList());

        dishesSkip2.forEach(System.out::println);
    }
}
