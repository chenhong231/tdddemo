package lambdasinaction.chap5;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) throws Exception{

        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());

//        long uniqueWords = Files.lines(Paths.get("lambdasinaction/chap5/data.txt"), Charset.defaultCharset())
//                .flatMap(line -> Arrays.stream(line.split(" ")))
//                .distinct()
//                .count();

//        System.out.println("There are " + uniqueWords + " unique words in data.txt");

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // fibonnaci with iterate
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                . map(t -> t[0])
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
