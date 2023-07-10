package Homework_2;
/*
 * 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        String[] string = { "name:Ivanov", "country:Russia", "city:Moscow", "age:null" };
        StringBuilder prestr = new StringBuilder("SELECT * FROM USER");
        int tempIndex = 0;
        for (String item : string) {
            if (!(item.contains("null"))) {
                tempIndex++;
                if (!(prestr.toString().toLowerCase().contains("where")) && tempIndex != 0) {
                    prestr.append(" WHERE ");
                }
                prestr.append("'"+item+ "' ");
            }
        }
        System.out.println(prestr);
    }
}
