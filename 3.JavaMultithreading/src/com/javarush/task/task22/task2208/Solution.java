package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> mapTest = new LinkedHashMap<>();
        mapTest.put("name", "Ivanov");
        mapTest.put("country", "Ukraine");
        mapTest.put("city", "Kiev");
        mapTest.put("age", null);
        System.out.println(getQuery(mapTest));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry: params.entrySet()) {
            if (entry.getValue() != null) {
                builder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
            }
        }
        if (builder.length()>5)
            builder.setLength(builder.length()-5);
        return builder.toString();
    }
}
/*
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}
Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
Requirements:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
 */