package teme.w07_comparable.ex1_stock_market;

import java.time.LocalDate;
import java.util.*;

class StockMarket {
    public List<StockUpdate> holdStocks = new ArrayList<>(
    );

    //TODO: add fields, etc...

    void add(StockUpdate update) {


        for (StockUpdate searchCode : holdStocks) {
            if (searchCode.getCode().equals(update.getCode()) &&
                    (searchCode.getLastUpdate().equals(update.getLastUpdate()))) {
                return;
            }

        }
        holdStocks.add(update);
        holdStocks.sort(StockUpdate::compareTo);
    }

    List<StockUpdate> getUpdates(LocalDate from, LocalDate to) {
        List<StockUpdate> sortedList = new ArrayList<>();
        for (int i = 0; i < holdStocks.size(); i++) {
            if (holdStocks.get(i).getLastUpdate().isAfter(from)
                    && holdStocks.get(i).getLastUpdate().isBefore(to)
                    || holdStocks.get(i).getLastUpdate().isEqual(from)
                    || holdStocks.get(i).getLastUpdate().isEqual(to)) {
                sortedList.add(holdStocks.get(i));

            }
        }


        return sortedList;
    }

    List<StockUpdate> getUpdates(LocalDate from, LocalDate to, String code) {
        List<StockUpdate> codeList = new ArrayList<>();
        for (StockUpdate search : getUpdates(from, to)
        ) {
            if (search.getCode() == code) {
                codeList.add(search);
            }
        }
        codeList.sort(StockUpdate::compareTo);
        return codeList;
    }

    Map<String, Double> getPrices(LocalDate date) {
        Map<String, Double> pricesAtDate = new LinkedHashMap<>();
        for (int i = 0; i < holdStocks.size(); i++) {
            if (holdStocks.get(i).getLastUpdate().isEqual(date)) {
                pricesAtDate.put(holdStocks.get(i).getCode(), holdStocks.get(i).getPrice());
            } else if (holdStocks.get(i).getLastUpdate().isBefore(date)) {
                pricesAtDate.put(holdStocks.get(i).getCode(), holdStocks.get(i).getPrice());
            }

        }
        return pricesAtDate;
    }

    double getPrice(LocalDate date, String code) {
        double price = 0;
        TreeSet<StockUpdate> newSet = new TreeSet<>(holdStocks);
        for (int i = 0; i < holdStocks.size(); i++) {
            if (holdStocks.get(i).getCode().equals(code) &&
                    holdStocks.get(i).getLastUpdate().isEqual(date)) {
                price = holdStocks.get(i).getPrice();

            } else if (holdStocks.get(i).getCode().equals(code) && holdStocks.get(i).getLastUpdate().isBefore(date)) {
                price = holdStocks.get(i).getPrice();

            }

        }
        return price;
    }


}

