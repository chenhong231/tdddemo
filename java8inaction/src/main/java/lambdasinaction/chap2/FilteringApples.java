package lambdasinaction.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApplesByColor(inventory, "green");
        System.out.println(greenApples);

        // [Apple{color='red', weight=120}]
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);

//        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
//        System.out.println(greenApples2);
//
//        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
//        System.out.println(heavyApples);
//
//        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
//        System.out.println(redAndHeavyApples);

        List<Apple> result = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
    }

    public static <T> List<T> filter(List<T> inventory, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : inventory){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

//    private static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {
//        List<Apple> result = new ArrayList<>();
//        for(Apple apple : inventory){
//            if(predicate.test(apple)){
//                result.add(apple);
//            }
//        }
//        return result;
//    }

    private static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if(color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
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

//    public interface ApplePredicate{
//        boolean test (Apple apple);
//    }

    public interface Predicate<T>{
        boolean test (T t);
    }

//    static class AppleColorPredicate implements ApplePredicate{
//        public boolean test(Apple apple){
//            return "green".equals(apple.getColor());
//        }
//    }
//
//    static class AppleWeightPredicate implements ApplePredicate{
//        public boolean test(Apple apple){
//            return apple.getWeight() > 150;
//        }
//    }
//
//    static class AppleRedAndHeavyPredicate implements ApplePredicate{
//        public boolean test(Apple apple){
//            return "red".equals(apple.getColor())
//                    && apple.getWeight() > 150;
//        }
//    }
}
