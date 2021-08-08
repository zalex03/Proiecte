package teme.w07_comparable.ex0_warmup;

import java.util.Iterator;

public class SquaresIterableDemo {
    public static void main(String[] args) throws InterruptedException {

        //TODO: uncomment these when ready

        //iterable without limit
//        System.out.println("\nUsing iterable without limit:");
//        for (long l : new SquaresIterable()) {
//            if (l > 100_000) {
//                break;
//            }
////            Thread.sleep(2000);
//            System.out.print(l);
//            System.out.println();
//        }


        //iterable with limit!
        System.out.println("\nUsing iterable with limit:");
        for (long l : new SquaresIterableWithLimit(100_000, "asta este un mesaj smecher")) {
            System.out.println(l);
        }

    }
}


class SquaresIterable implements Iterable<Long> {

    @Override
    public Iterator<Long> iterator() {

        return new SquaresIterator();
    }
}

class SquaresIterator implements Iterator<Long> {

    private long n = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        System.out.print(n + "^2 = ");
        long result = n * n;
        n++;
        return result;
    }

}


//--- OPTIONAL ---//

class SquaresIterableWithLimit implements Iterable<Long> {
    private String message;
    private long maxLimit;

    public SquaresIterableWithLimit(long maxLimit, String message) {
        this.message = message;
        this.maxLimit = maxLimit;
    }

    @Override
    public Iterator<Long> iterator() {
        return new SquaresIteratorWithLimit(maxLimit, message);
    }
}

class SquaresIteratorWithLimit implements Iterator<Long> {
    private long n = 1;
    private long maxLimit;
    private String message;

    public SquaresIteratorWithLimit(long maxLimit, String message) {
        this.maxLimit = maxLimit;
        this.message = message;
    }

    @Override
    public boolean hasNext() {
        return n * n < maxLimit;
    }

    @Override
    public Long next() {
        System.out.println(message);
        long result = n * n;
        n++;
        return result;
    }
}
