package streams;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveSteams {
    public static void main(String[] args) throws IOException {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        IntStream zeroToNinetyNine = IntStream.range(0, 100);
        IntStream zeroToHundred = IntStream.rangeClosed(0, 100);

        String s = CreatingStreams.readStringFromFile("panTadeusz.txt");
        List<String> words = List.of(s.split("\\PL+"));

        IntStream intStream1 = words.stream().mapToInt(String::length);

        Stream<Integer> boxed = IntStream.rangeClosed(0, 100).boxed();

        int[] ints = IntStream.rangeClosed(0, 100).toArray();

        int sum = IntStream.rangeClosed(0, 100).sum();
        OptionalDouble average = IntStream.rangeClosed(0, 100).average();
        System.out.println(average.getAsDouble());

        int reduce = IntStream.rangeClosed(1, 4).reduce(1, (left, right) -> left * right);
        System.out.println(reduce);




    }
}
