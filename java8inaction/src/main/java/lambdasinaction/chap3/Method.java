package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class Method {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(Comparator.comparing(Apple::getWeight));

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        stringToInteger = Integer::parseInt;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        contains = List::contains;

        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        c1 = () -> new Apple();
        a1 = c1.get();

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(100);

        //等价于
        c2 = (weight) -> new Apple(weight);
        a2 = c2.apply(100);

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(100, "green");

        //等价于

        c3 = (weight, color) -> new Apple(weight, color);
        a3 = c3.apply(100, "green");
     }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple() {
        }

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(Integer weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
