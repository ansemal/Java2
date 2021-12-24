package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        int firstIndex;
        if (string==null || string.length()<2 || (firstIndex = string.indexOf(' '))<0)
            throw new TooShortStringException();
        int secondIndex = firstIndex;
        for (int i = 2; i < 5; i++) {
            secondIndex = string.indexOf(' ', secondIndex+1);
            if (secondIndex<0)
                throw new TooShortStringException();
        }
        int endIndex = string.indexOf(' ', secondIndex+1);
        if (endIndex>0)
            return string.substring(firstIndex+1, endIndex);
        else
            return string.substring(firstIndex+1);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

/*
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример:    "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
Пример:    "Амиго и Диего лучшие друзья!"
Результат: "и Диего лучшие друзья!"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Requirements:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные,
должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела
и до конца слова, которое следует после 4-го пробела.
 */
