package lambdasinaction.chap10;

import java.util.Optional;
import java.util.Properties;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadPositiveIntParam {

    public void testMap() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
    }

    public static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if(value != null) {
            try {
                int i = Integer.parseInt(value);
                if(i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    public static int readDurationWithOptional1(Properties props, String name) {
        return ofNullable(props.getProperty(name))
                .flatMap(ReadPositiveIntParam::s2i)
                .filter(i -> i > 0).orElse(0);
    }

    public static Optional<Integer> s2i(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
