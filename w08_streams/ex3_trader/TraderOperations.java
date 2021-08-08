package teme.w08_streams.ex3_trader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TraderOperations {

    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    static List<Transaction> transactionFromYearSortedByValue(List<Transaction> transactions, int year) {
        List<Transaction> holdAndSort = transactions.stream().
                filter(i -> i.getYear() == year).
                sorted(Transaction::compareTo).
                collect(Collectors.toList());
        return holdAndSort;
    }

    static Set<String> distinctTraderCities(List<Transaction> trans) {
        Set<String> holdDistinct = new HashSet<>();
        //nu inteleg dc nu am putut sa scriu asa
        //holdDistinct = trans.stream().forEach(b->holdDistinct.add(b.getTrader().getCity()));
        trans.stream().
                forEach(b -> holdDistinct.
                        add(b.getTrader().getCity()));
        return holdDistinct;
    }

    static List<Trader> tradersFromCitySortedByNameDescending(List<Transaction> trans, String city) {
        List<Trader> holdTraders;
        holdTraders = trans.stream().map(Transaction::getTrader).distinct().collect(Collectors.toList());
        return holdTraders.stream().
                filter(b -> b.getCity().equals(city)).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }

    static String tradersNamesSorted(List<Transaction> trans) {
        String holdTradersName = trans.stream().map(Transaction::getTrader).
                map(Trader::getName).
                distinct().sorted().
                collect(Collectors.
                        joining(","));
        return holdTradersName;
    }

    static boolean isAnyTraderFromCity(List<Transaction> trans, String city) {

        return trans.stream().anyMatch(b -> b.getTrader().getCity().equals(city));
    }

    static void relocateTraders(List<Transaction> trans, String fromCity, String toCity) {
        trans.stream().
                filter(b -> b.getTrader().getCity().equals(fromCity)).
                forEach(b -> b.getTrader().setCity(toCity));
    }

    static Optional<Transaction> transactionWithHighestValue(List<Transaction> trans) {
        //TODO
        return trans.stream().max(Transaction::compareTo);
    }

    static Optional<Transaction> transactionWithLowestValue(List<Transaction> trans) {
        //TODO
        return trans.stream().min(Transaction::compareTo);
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {

        //build some traders
        Trader tony = new Trader("Tony", "Milan");
        Trader john = new Trader("John", "Cambridge");
        Trader oliver = new Trader("Oliver", "Cambridge");
        Trader ion = new Trader("Ion", "Iasi");

        //and some transactions
        List<Transaction> trans = Arrays.asList(
                new Transaction(2011, 100, tony),
                new Transaction(2012, 80, tony),
                new Transaction(2013, 120, tony),
                new Transaction(2011, 50, oliver),
                new Transaction(2010, 130, john),
                new Transaction(2011, 70, john),
                new Transaction(2012, 90, john),
                new Transaction(2011, 60, ion),
                new Transaction(2012, 140, ion));

        System.out.println("\ninitial transactions list:");
        trans.forEach(System.out::println);


        // - Find all transactions from 2011 and sort them by value (small to high)
        System.out.println("\ntransactions from 2011, sorted by value:");
        transactionFromYearSortedByValue(trans, 2011).forEach(System.out::println);

        // - What are all the unique cities where traders work?
        System.out.println("\ntraders cities: " + distinctTraderCities(trans));

        // - Find all traders from Cambridge and sort them by name (descending)
        System.out.println("\ntraders from Cambridge (sorted descending by name):");
        tradersFromCitySortedByNameDescending(trans, "Cambridge").forEach(System.out::println);

        // - Return a string of all traders’ names sorted alphabetically and separated by comma
        System.out.println("\nnames of all traders: " + tradersNamesSorted(trans));


        // - Determine if there are any traders from Milan
        System.out.println("\nany trader from Milan?: " + isAnyTraderFromCity(trans, "Milan"));


        //   Update all transactions so that the traders from Milan are moved to Cambridge
        relocateTraders(trans, "Milan", "Cambridge");
        System.out.println("\ntransactions after trader relocation:");
        trans.forEach(System.out::println);


        // - What’s the highest value in all transactions? What’s the transaction with the lowest value?
        Optional<Transaction> highestValueTrans = transactionWithHighestValue(trans);
        System.out.println("\nhighestValueTrans: " + highestValueTrans);

        Optional<Transaction> lowestValueTrans = transactionWithLowestValue(trans);
        System.out.println("lowestValueTrans: " + lowestValueTrans);
    }
}
