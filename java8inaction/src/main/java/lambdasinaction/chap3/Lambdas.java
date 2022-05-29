package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Lambdas {

    public static void main(String ...args){
        // Simple example
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        Comparator<Apple> c = comparing((Apple a) -> a.getWeight());
        inventory.sort(c);

        inventory.sort(comparing((Apple a) -> a.getWeight()));

        inventory.sort(comparing(Apple::getWeight));
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
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


