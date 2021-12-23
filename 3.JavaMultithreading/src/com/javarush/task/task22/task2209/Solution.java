package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            List<String> words = new ArrayList<>();
            while (fileReader.ready()) {
                words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
            }
            String[] strings = new String[words.size()];
            words.toArray(strings);
            StringBuilder result = getLine(strings);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0)
            return new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        ArrayList<String> tempList = new ArrayList<>();
        Collections.addAll(tempList, words);
        list.add(tempList.get(0));
        tempList.remove(0);
        while (!tempList.isEmpty()) {
            ArrayList<String> iterList = (ArrayList<String>) tempList.stream().collect(Collectors.toList());
            for (String name : iterList) {
                if (name.codePointAt(name.length()-1) == list.get(0).toLowerCase().codePointAt(0)) {
                    list.add(0, name);
                    tempList.remove(name);
                } else if (name.toLowerCase().codePointAt(0) == list.get(list.size()-1).codePointAt(list.get(list.size()-1).length()-1)) {
                    list.add(name);
                    tempList.remove(name);
                }
            }
        }
        for (String name: list)
            builder.append(name).append(" ");
        if (builder.length()>0)
            builder.setLength(builder.length()-1);
        return builder;
    }
}

/*
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн
Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.
Requirements:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.
 */
