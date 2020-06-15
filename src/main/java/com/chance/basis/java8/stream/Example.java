package com.chance.basis.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * <p>
 * 从一个列表中筛选金额较高的交易
 * <p>
 *
 * @author chance
 * @since 2020-02-09
 */
public class Example {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(new Transaction(1000, 90), new Transaction(1100, 80), new Transaction(1200, 70));

        //筛选金额较高的交易
        Map<Integer, List<Transaction>> transactionsByCurrencies = transactions.stream()
                .filter((Transaction t) -> t.getPrice() > 1000)
                .collect(groupingBy(Transaction::getCurrency));

        System.out.println(transactionsByCurrencies);
    }

    private static class Transaction {
        private int price;
        private int currency;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getCurrency() {
            return currency;
        }

        public void setCurrency(int currency) {
            this.currency = currency;
        }

        public Transaction(int price, int currency) {
            this.price = price;
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "price=" + price +
                    ", currency=" + currency +
                    '}';
        }
    }
}
