package teme.w07_comparable.ex1_stock_market;

import java.time.LocalDate;
import java.util.Objects;

class StockUpdate implements Comparable<StockUpdate> {
    private double price;
    private String code;
    private LocalDate lastUpdate;

    StockUpdate(String code, LocalDate lastUpdate, double price) {
        this.code = code;
        this.lastUpdate = lastUpdate;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockUpdate that = (StockUpdate) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(code, that.code) &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, code, lastUpdate);
    }

    @Override
    public int compareTo(StockUpdate o) {
        if (this.getLastUpdate().isBefore(o.getLastUpdate())) {
            return -1;
        }

        if (this.getLastUpdate().isEqual(o.getLastUpdate())) {

            return this.getCode().compareTo(o.getCode());
        }
        return 1;
    }

    @Override
    public String toString() {
        return "StockUpdate{" +
                "price=" + price +
                ", code='" + code + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    //TODO: add rest of fields, methods..
}
