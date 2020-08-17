package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {

    public static String readStringFromFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static int generateInt() {
        return 1;
    }

    public static void main(String[] args) throws IOException {
        String s = readStringFromFile("panTadeusz.txt");
        String[] words = s.split("\\PL+");
//        for (String word : words) {
//            System.out.println(word);
//        }

        List<String> letters = Arrays.stream(words)
                .map(s1 -> s1.split(""))
                .flatMap(strings -> Arrays.stream(strings))
                .collect(Collectors.toList());
        //    letters.forEach(System.out::println);

        int count = letters.stream().mapToInt(value -> 1).sum();
        System.out.println(count);
        long count1 = letters.stream().count();
        System.out.println(count1);

        Stream<Integer> generate = Stream.generate(CreatingStreams::generateInt).limit(10);
        generate.forEach(integer -> System.out.println(integer));

        Stream.iterate(0, integer -> integer + 1).limit(5).forEach(integer -> System.out.println(integer));

        Stream<String> stringStream = Pattern.compile("\\PL+").splitAsStream(s);

        Stream<Integer> stream1 = Stream.iterate(0, integer -> integer + 1).limit(5);
        Stream<Integer> stream2 = Stream.iterate(5, integer -> integer + 1).limit(5);
        Stream<Integer> concat = Stream.concat(stream1, stream2);

        concat.forEach(integer -> System.out.println(integer));

        List<String> strings = Arrays.asList(words);
        System.out.println(strings.stream().count());
        long count2 = strings.stream().distinct().count();
        System.out.println(count2);
        List<String> sorted = strings.stream().distinct().sorted().collect(Collectors.toList());
        //sorted.forEach(s1 -> System.out.println(s1));

        Optional<String> max = strings.stream().max((o1, o2) -> o1.length() - o2.length());
        System.out.println(max.orElse("!"));

        System.out.println(2.5 / 0); //Infinity
        Optional<Object> empty = Optional.empty();
        //  System.out.println(empty.get()); // NoSuchElementExc.

        strings.stream().forEachOrdered(s1 -> System.out.println(s1));

        String[] strings1 = strings.stream().toArray(String[]::new);
        Object[] objects = strings.stream().toArray();
        List<String> collect = strings.stream().collect(Collectors.toList());
        List<String> collect1 = strings.stream().collect(Collectors.toCollection(LinkedList::new));
        String collect2 = strings.stream().limit(5).collect(Collectors.joining(", "));
        System.out.println(collect2);

        Stream<Integer> limit = Stream.iterate(1, integer -> integer + 1).limit(10);
        String collect3 = limit.map(Objects::toString).collect(Collectors.joining("-"));
        System.out.println(collect3);

        IntSummaryStatistics summaryStatistics = strings.stream().collect(Collectors.summarizingInt(String::length));
        int min = summaryStatistics.getMin();
        System.out.println(min);
        System.out.println(summaryStatistics.getMax());

        Map<String, Integer> collect4 = strings.stream().limit(10).distinct().collect(Collectors.toMap(Function.identity(), String::length));
        collect4.forEach((s1, aLong) -> System.out.println(s1 + " - " + aLong));


        Map<String, Long> collect5 = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect5.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(stringLongEntry -> System.out.println(stringLongEntry));

        Map<String, Integer> newMap = new HashMap<>();
        for (String string : strings) {
            newMap.merge(string, 1, Integer::sum);
        }
        newMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(stringIntegerEntry -> System.out.println(stringIntegerEntry));

        Map<Boolean, List<String>> collect6 = strings.stream().collect(Collectors.partitioningBy(s1 -> s1.length() > 10));

        collect6.forEach((aBoolean, strings2) -> System.out.println(aBoolean + " - " + strings2.size()));

        Map<Integer, Set<String>> collect7 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.toCollection(HashSet::new)));


        collect7.forEach((integer, strings2) -> System.out.println(integer + " " + strings2.stream().collect(Collectors.joining(", "))));

        Map<String, Set<Integer>> collect8 = strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(String::length, Collectors.toSet())));
        collect8.forEach((s1, integers) -> System.out.println(s1 + " - "+ integers.stream().map(String::valueOf).collect(Collectors.joining(", "))));

        Integer reduce = Stream.iterate(0, integer -> integer + 1).limit(3).reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println(reduce);

    }
}
