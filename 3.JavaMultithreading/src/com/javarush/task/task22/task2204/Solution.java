package com.javarush.task.task22.task2204;

/* 
Форматирование строки
*/

public class Solution {
    public static void main(String[] args) {
        System.out.printf((getFormattedString()) + "%n", 20.0 / 7.0, 10.0 / 3.0);
        //должен быть вывод
        //20 / 7 = 2,86
        //Exp = 3,33e+00
    }

    public static String getFormattedString() {
        return "20 / 7 = %.2f%nExp = %.2e";
    }
}

/*
Исправить метод getFormattedString так, чтобы он возвращал строку с параметрами для форматирования.
Для перевода каретки не используй \n.
Требования:
• Для перевода строки не должно быть использовано выражение \n.
• Метод getFormattedString должен быть статическим.
• Вывод на экран должен соответствовать условию задачи.
• Метод getFormattedString должен возвращать строку с параметрами для форматирования согласно условию задачи.
 */
