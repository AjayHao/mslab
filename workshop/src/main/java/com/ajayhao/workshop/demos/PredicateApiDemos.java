package com.ajayhao.workshop.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * PredicateApiDemos
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2020/3/2 22:37
 */
public class PredicateApiDemos {

    // Java program to illustrate Simple Predicate
    public void simplePredicate() {
        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));
    }


    // Java program to illustrate Predicate Chaining
    public void callPredicateChain() {
        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }


    // passing Predicate into function
    public static void predicateParam(int number, Predicate<Integer> predicate)  {
        if (predicate.test(number)) {
            System.out.println("Number " + number);
        }
    }

    public static void predicateOr()
    {
        Predicate<String> hasLengthOf10 = p -> p.length() > 10;
        Predicate<String> containsLetterA = p -> p.contains("A");
        String containsA = "And";
        boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
        System.out.println(outcome);
    }


    public static List<String> filter(List<String> strs,
                                      Predicate<String> predicat)
    {
        List<String> result = new ArrayList<>();
        for (String str: strs) {
            if (predicat.test(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        predicateParam(10, (i) -> i > 7);
        predicateOr();
        List<String> l1 = Arrays.asList("Arron", "Ajay", "Bruce", "Helen", "Lewie", "Landon");
        filter(l1, str->str.startsWith("A"));
    }
}
