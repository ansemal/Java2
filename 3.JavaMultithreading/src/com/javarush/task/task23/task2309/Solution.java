package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;
import java.util.List;

/* 
Анонимность иногда так приятна!
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static <T extends NamedItem> void print(List<T> list) {
        String format = "Id=%d, name='%s', description=%s";
        for (NamedItem obj : list) {
            System.out.printf((format) + "%n", obj.getId(), obj.getName(), obj.getDescription());
        }
    }

    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER" ;
            }
        }.execute();
    }

    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        }.execute();
    }
    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        }.execute();
    }
    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        }.execute();

    }
    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        }.execute();
    }
}

/*
1. В пакете vo создай public классы User, Location, Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создай свой метод, который возвращает список экземпляров класса.

Например, для класса User это будет - public List<User> getUsers()
Для класса Location это будет - public List<Location> getLocations()

3. Внутри каждого такого метода создай анонимный класс от AbstractDbSelectExecutor и вызови его нужный метод.

Подсказка:
тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
Id=1, name='Location-1', description=Received from executing 'SELECT * FROM LOCATION'

5. Проанализируй пример вывода и сформируй правильный query для всех классов.


Requirements:
1. В пакете vo должны быть созданы public классы User, Location, Server, Subject и Subscription,
унаследованные от класса NamedItem.
2. В методах getUsers, getLocations, getServers, getSubjects, getSubscriptions должен быть создан объект
класса AbstractDbSelectExecutor с параметром типа User, Location, Server, Subject или Subscription соответственно.
3. Методы getUsers, getLocations, getServers, getSubjects, getSubscriptions должны возвращать корректный
список(в соответствии с условием задачи).
 */
