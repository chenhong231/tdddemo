package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Sorting {

    public static void main(String...args){
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));

        //1
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        //2
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        //3
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        //4
        Comparator<Apple> c = comparing((Apple a) -> a.getWeight());
        inventory.sort(c);

        //5
        inventory.sort(comparing((a) -> a.getWeight()));

        //6
        inventory.sort(comparing(Apple::getWeight));

        //7
        inventory.sort(comparing(Apple::getWeight).reversed());

        //8
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));


        //3.8.3
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

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


    public static class AppleComparator implements Comparator<Apple> {

        public AppleComparator() {
        }

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
