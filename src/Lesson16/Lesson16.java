package Lesson16;

import java.util.*;

/**
 * Домашнее задание №14
 *
 * @author Nikita Shaternik
 * 26.04.2026
 */

public class Lesson16 {
    public static void main(String[] args) {
        /* Задача 1:
        На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
        строка является ключом, и ее значение равно true, если эта строка встречается в массиве
        2 или более раз. Пример:
        wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
        wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
        wordMultiple(["c", "c", "c", "c"]) → {"c": true}*/
        String[] inputTaskOne = {"a", "b", "a", "c", "b"};
        System.out.println(wordMultiple(inputTaskOne));

        /*Задача 2:
        На вход поступает массив непустых строк, создайте и верните Map<String,
        String> следующим образом: для каждой строки добавьте ее первый символ в
        качестве ключа с последним символом в качестве значения. Пример:
        pairs(["code", "bug"]) → {"b": "g", "c": "e"}
        pairs(["man", "moon", "main"]) → {"m": "n"}
        pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"} */
        String[] inputTaskTwo = {"man", "moon", "main"};
        System.out.println(pairs(inputTaskTwo));

        /*Задача *:
        Задана строка, которая может иметь внутри себя скобки. Скобкой считается
        любой из следующих символов — «(«, «)», «[«, «]», «{«, «}». Проверить
        сбалансированность расстановки скобок в этой строке. Набор скобок считается
        сбалансированной парой, если открывающая скобка "(", "[" и "{" стоит слева от
        соответствующей закрывающей скобки ")", "]" и "} ", соответственно. Строка,
        содержащая пары скобок, не сбалансирована, если набор заключенных в нее
        скобок не совпадает .
        Например, если ввод «{[(])}», пара квадратных скобок «[]» заключает в себя
        одну несбалансированную открывающую круглую скобку «(». Аналогично, пара
        круглых скобок «() ", заключает в себя одну несбалансированную
        закрывающую квадратную скобку "]". Таким образом, входная строка "{[(])}"
        несбалансированная.
        Пример
        () - сбалансирована
        [()] - сбалансирована
        {[()]} - сбалансирована
        ([{{[(())]}}]) - сбалансирована
        {{[]()}}}} - не сбалансирована
        {[(])} - не сбалансирована */
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("[()]"));
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[]()}}}}"));

    }
    // метод для 1 Задания
    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();

        for (String str : strings) {
            if (map.containsKey(str)) {
                map.put(str, true);
            } else {
                map.put(str, false);
            }
        }
        return map;
    }

    // метод для 2 Задания
    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();

        for (String str : strings) {
            String first = str.substring(0, 1);
            String last = str.substring(str.length() - 1);
            map.put(first, last);
        }
        return map;
    }

    // метод для 3 Задания
    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char last = stack.pop();

                if (!isMatchingPair(last, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
