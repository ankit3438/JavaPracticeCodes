package PracticeCodes.Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class firstNonRepeatingInteger {

    /*  
    Grouping by has 3 overloaded methods:
    1. groupingBy(Function<? super T, ? extends K> classifier)  
    2. groupingBy(Function<? super T, ? extends K> classifier,
               Collector<? super T, A, D> downstream)
    3. groupingBy(Function<? super T, ? extends K> classifier,
    */

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);

        Optional<Integer> result =
                list.stream()
                    .collect(Collectors.groupingBy(
                        x -> x,                 // instead of Function.identity()
                        LinkedHashMap::new,
                        Collectors.counting()
                    ))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(entry -> entry.getKey())
                    .findFirst();

        System.out.println(result); // Optional[1]

    }

}
