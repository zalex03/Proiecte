package teme.w08_streams.ex0_warmup;

import teme.w08_streams.ex0_warmup.Person.HairColor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static teme.w08_streams.ex0_warmup.Person.HairColor.*;

public class StreamsWarmup {

    /**
     * 0.a.i Given a list of numbers, return another list with all numbers which are greater than 10 and smaller than 100.
     */
    static List<Integer> onlyBetween10And100(List<Integer> numbers) {
        List<Integer> result = numbers.stream().
                filter(i -> i > 10 && i < 100).
                collect(Collectors.toList());
        return result;
    }


    /**
     * 0.a.ii Given a list of Strings, write a method that returns a list of all strings that
     * start with the letter 'a' (lower case) and have exactly 3 letters.
     */
    static List<String> startWithLetterAndHaveLength(char letter, int wordLength, List<String> words) {
        return words.stream().
                filter(word -> word.startsWith(String.valueOf(letter))
                        && word.length() == wordLength).
                collect(Collectors.toList());
    }

    /**
     * 0.a.iii Given an array of Strings, return a list based on initial array, but in which all empty strings are removed,
     * and the remaining strings are changed to uppercase then also sorted alphabetically.
     */
    static List<String> withoutEmptyStringsAndChangedToUpperAndSorted(String[] arrayOfStrings) {
        return Arrays.stream(arrayOfStrings).
                filter(s -> (s != null && s.length() > 0))
                .map(word -> word.toUpperCase()).sorted().collect(Collectors.toList());
    }

    /**
     * 0.a.iv Write a method that returns a comma separated string based on a given list of integers. Each element should be
     * preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
     * For example, if the input list is (3,44), the output should be 'o3,e44'.
     */
    static String addLetterForEvenOdd(List<Integer> numbers) {
        return numbers.stream()
                .map(integer -> integer % 2 == 0 ? "e" + integer : "o" + integer)
                .collect(Collectors.joining(","));
    }


    /**
     * 0.b.i Given an array of numbers, return a list with only 3 smallest numbers from all of them (and ordered ascending by value).
     */
    static List<Integer> only3Smallest(Integer[] numbers) {

        return Arrays.stream(numbers).
                sorted().limit(3).
                collect(Collectors.toList());
    }

    /**
     * 0.b.ii Same as previous, but now also ignore any duplicates.
     */
    static List<Integer> only3SmallestNoDuplicates(Integer[] numbers) {

        return Arrays.stream(numbers).
                sorted().distinct().limit(3)
                .collect(Collectors.toList());
    }

    /**
     * 0.b.iii Similar to previous, but now return a list with only the 3 biggest numbers, ordered descending (and ignoring duplicates).
     */
    static List<Integer> only3BiggestNoDuplicates(Integer[] numbers) {
        //TODO
        return Arrays.stream(numbers).sorted((integer, t1) -> t1.compareTo(integer)).distinct().limit(3).collect(Collectors.toList());
    }


    /**
     * 0.c.i Given an array of numbers, count how many of them are even (return just the count, not the numbers)
     */
    static long countOfEvenNumbers(List<Integer> numbersList) {
        return numbersList.stream()
                .filter(i -> i % 2 == 0)
                .count();
    }

    /**
     * 0.c.ii Given an array of numbers (of type double), display only the positive numbers, printing each number on a separate line.
     */
    static void printPositives(double[] numbers) {

        Arrays.stream(numbers).
                filter(i -> i > 0).
                forEach(System.out::println);
    }

    /**
     * 0.c.iii Given a list of numbers (of primitive type long), determine if all numbers are even, and print out
     * a single message about it (like “Numbers are all even? : <true>/<false>..”)
     */
    static boolean checkIfAllEven(List<Long> numbers) {

        return numbers.stream().
                allMatch(i -> i % 2 == 0);
    }

    /**
     * 0.c.iv Given a list of Person objects (with attributes: name, hairColor), find out if there is at least one person
     * with hair color ‘black’, and print out his/her name. Try to solve this without using the filter() operation.
     * (look over the available terminal operations to get ideas, think about how you can find a single element...)
     */
    static String findNameOfFirstPersonWithHairColor(List<Person> persons, HairColor color) {
        Optional<String> optional = persons.stream()
                .filter(p -> p.getHairColor() == color)
                .map(p -> p.getName())
                .findAny();
        return optional.orElse("NONE");
    }


    /**
     * 0.d.i Given a list of Person objects (having an age field, of type int), compute and return their average age
     * (or default value 0 if you cannot compute it).
     * Question: is there any valid case when you cannot compute the average age?..
     */
    static double averageAge(List<Person> persons) {

        return persons.stream()
                .mapToInt(p -> p.getAge()).
                        average().orElse(0.0);
    }

    /**
     * 0.d.ii Given a list of Person objects (having fields: name, age), return just the name of the oldest person.
     */
    static String nameOfOldest(List<Person> persons) {
        Optional<Person> oldest = persons.stream().max(Comparator.comparing(Person::getAge));
        return oldest.map(b -> b.getName()).orElse("NO_PERSONS_PRESENT");
    }


    /**
     * 0.e.i Return as a List the first 10 powers of 3 which are greater than 1000 (hint: use IntStream.iterate(), limit(), filter(), boxed()..)
     */
    static List<Integer> powGreaterThan(int base, int minValue, int count) {
        List<Integer> holdNumbers = IntStream.iterate(1, i -> i * 3).filter(i -> i > minValue).limit(count).boxed().collect(Collectors.toList());
        return holdNumbers;
    }

    /**
     * 0.e.ii Return as a List all the square numbers (of form n^2) between 1000 and 10000 (hint: use IntStream.range(), map(), boxed()..)
     */
    static List<Integer> allSquareNumbersBetween(int minValue, int maxValue) {
        /*List<Integer>holdNumbers = IntStream.iterate(0,i->i+1).filter(i->i*i>minValue&&i*i<maxValue).boxed().collect(Collectors.toList());*/
        return null;
    }


    /**
     * 0.f.i Given a list of Person objects (with 2 attributes: name and hair color), group all of them by their hair color,
     * and then display these groups.
     */
    static Map<HairColor, List<Person>> groupedByHairColor(List<Person> persons) {
        Map<HairColor, List<Person>> group = persons.stream().collect(Collectors.groupingBy(Person::getHairColor));
        return group;
    }

    /**
     * [OPTIONAL]
     * 0.f.ii Given a string, count the occurrences of each letter
     * <p>
     * Hint: see Collectors.groupingBy, Collectors.counting..
     * more info:  https://dzone.com/articles/the-ultimate-guide-to-the-java-stream-api-grouping
     */
    static Map<String, Long> countChars(String text) {
        Map<String, Long> frequentChars = Arrays.stream(
                text.toLowerCase().split("")).collect(
                Collectors.groupingBy(c -> c, Collectors.counting()));
        return frequentChars;
    }


    /**
     * [OPTIONAL]
     * 0.g.i Write a method which receives a list of Strings, tries to convert each of them to a number
     * (if possible - if they contain a valid number), then prints out the first 3 numbers which are bigger than value 10.
     * <p>
     * Hint: you may need to read more about exceptions; also about flatMap() operation on streams.
     */
    static List<Integer> toNumbersThenFirst3BiggerThan10(List<String> possibleNumbers) {


        return null;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(-7, 1, 3, 7, 12, -30, 19, 55, 84, 120, 180, 5, 25, -30, 0, 120);
        Integer[] numbersArr = {-7, 1, 3, 7, 12, -30, 19, 55, 84, 120, 180, 5, 25, -30, 0, 120};

        System.out.println("numbers: " + numbers);
        System.out.println("onlyBetween10And100: " + onlyBetween10And100(numbers));
        System.out.println("only3Smallest: " + only3Smallest(numbersArr));
        System.out.println("only3SmallestNoDuplicates: " + only3SmallestNoDuplicates(numbersArr));
        System.out.println("only3BiggestNoDuplicates: " + only3BiggestNoDuplicates(numbersArr));

        System.out.println("\nprintPositives():");
        printPositives(new double[]{3, -5, 7.5, -2.3, 0, 99.9});

        System.out.println("\ncheckIfAllEven(0, 2, 8, -6, 12): " + checkIfAllEven(Arrays.asList(0L, 2L, 8L, -6L, 12L)));
        System.out.println("checkIfAllEven(0, 2, 8, -6, 12, 13): " + checkIfAllEven(Arrays.asList(0L, 2L, 8L, -6L, 12L, 13L)));

        System.out.println("\naddLetterForEvenOdd: " + addLetterForEvenOdd(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        System.out.println("startWithLetterAndHaveLength('a', 3, [\"aaabbccccd\", \"aaa\", \"bcd\"]: " +
                startWithLetterAndHaveLength('a', 3, Arrays.asList("aaabbccccd", "aaa", "bcd")));
        System.out.println("withoutEmptyStringsAndChangedToUpperAndSorted([\"\", \"zz\", \"aabb\", \"\", \"dd\", \"cc\", \"bcd\"]): " +
                withoutEmptyStringsAndChangedToUpperAndSorted(new String[]{"", "zz", "aabb", "", "dd", "cc", "bcd"}));

        List<Person> persons = Arrays.asList(
                new Person("Andrei", BLACK, 20),
                new Person("Bogdan", BROWN, 25),
                new Person("Codrin", BROWN, 22),
                new Person("Diana", BLONDE, 21));
        System.out.println("\nall persons: " + persons);
        System.out.println("findNameOfFirstPersonWithHairColor(BROWN): " + findNameOfFirstPersonWithHairColor(persons, BROWN));
        System.out.println("findNameOfFirstPersonWithHairColor(RED): " + findNameOfFirstPersonWithHairColor(persons, RED));

        System.out.println("averageAge: " + averageAge(persons));
        System.out.println("averageAge(empty list): " + averageAge(emptyList()));

        System.out.println("nameOfOldest: " + nameOfOldest(persons));
        System.out.println("nameOfOldest(empty list): " + nameOfOldest(emptyList()));

        System.out.println("groupedByHairColor: " + groupedByHairColor(persons));

        System.out.println("\npowGreaterThan(3, 1000, 10): " + powGreaterThan(3, 1000, 10));
        System.out.println("allSquareNumbersBetween(1000, 2500) :" + allSquareNumbersBetween(1000, 2500));

        System.out.println("\ncountChars('eeaaabbccccdaaxxyyy'): " + countChars("eeaaabbccccdaaxxyyy"));
        System.out.println("\ntoNumbersThenFirst3BiggerThan10([\"3\", \"23\", \"abc\", \"2\", \"11\", \"15\", \"7\", \"19\", \"x\"]):  "
                + toNumbersThenFirst3BiggerThan10(Arrays.asList("3", "23", "abc", "2", "11", "15", "7", "19", "x")));
    }
}
