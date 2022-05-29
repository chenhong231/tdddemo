package lambdasinaction.chap10;

import java.util.Map;
import java.util.Optional;

public class OperationsWithOptional {

    private static Map<String, Object> map;

    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();


        Car car = new Car();
        Optional<Car> optCar1 = Optional.of(car);

        Optional<Car> optCar2 = Optional.ofNullable(car);
        Insurance insurance = new Insurance();

        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        Optional<Object> value = Optional.ofNullable(map.get("key"));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UnKnown");
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {

        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UnKnown");
    }
}
