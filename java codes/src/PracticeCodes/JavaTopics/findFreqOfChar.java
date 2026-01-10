package PracticeCodes.JavaTopics;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class findFreqOfChar {
    /* Find frequency of each character in a string 
    --String is not a collection so steam() method is not directly applicable
    --We can convert string to char array or use chars() or toCharMethod() method to get IntStream
    --Streams only supports three premitive streasm: IntStream, LongStream, DoubleStream
    --char() returns IntStream so we need to convert it back to Character object
    --toCharArray() returns char[] which we can use to create Character stream
    */

    public static void main(String[] args) {
        String str = "hello world";

        // 1️⃣ Create map first
        Map<Character, Integer> freqMap = new HashMap<>();

        // 2️⃣ Use it inside stream
        str.chars()                            //gives integer stream of ASCCI Value
           .mapToObj(c -> (char) c)
           .filter(c -> c != ' ')
           .forEach(c ->
               freqMap.put(c, freqMap.getOrDefault(c, 0) + 1)
           );

        // 3️⃣ Print the map
        System.out.println(freqMap);

    }
}
