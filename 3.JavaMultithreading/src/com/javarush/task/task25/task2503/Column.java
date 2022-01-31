package com.javarush.task.task25.task2503;

import java.util.*;
import java.util.stream.Collectors;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
//        List<Column> result = new LinkedList<>();
//        OptionalInt maxOptional = Arrays.stream(realOrder).max();
//        if (maxOptional.isPresent()) {
//            int max = maxOptional.getAsInt();
//            int[] newArray = new int[max+1];
//            for (int i = 0; i < realOrder.length; i++) {
//                if (realOrder[i] != -1)
//                    newArray[realOrder[i]] = i;
//            }
//            for (int j : newArray) {
//                result.add(values()[j]);
//            }
//        }
//        return result;
        return Arrays.stream(Column.values())  //делаем стрим
                .filter(Column::isShown)           //фильтруем видимые
                .sorted(Comparator.comparingInt(c -> realOrder[c.ordinal()])) //вот тут сортируем
                .collect(Collectors.toList());  //возвращаем коллекцию.
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder != null && realOrder[ordinal()] != -1;
    }

    @Override
    public void hide() {
        int oldOrder = realOrder[ordinal()];
        if (oldOrder == -1) return; //already hidden
        realOrder[ordinal()] = -1;
        //reorder
        for (int i = 0; i < realOrder.length; i++) {
            if (realOrder[i] > oldOrder)
                realOrder[i]--;
        }
    }
}
