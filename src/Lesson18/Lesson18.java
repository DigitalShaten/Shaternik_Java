package Lesson18;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Домашнее задание №18
 *
 * @author Nikita Shaternik
 * 01.05.2026
 */

public class Lesson18 {
    public static void main(String[] args) {
        /*Задача 1:
        Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
        Stream'ов:
        - Удалить дубликаты
        - Оставить только четные элементы
        - Вывести сумму оставшихся элементов в стриме  */
        System.out.println("Задача 1");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 3, 5, 14, 22, 13, 1, 2, 14));

        int sum = arrayList.stream()
                .distinct()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Сумма чётных уникальных элементов: " + sum);

        /*Задача *:
        Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
        этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
        Среди отобранных значений отобрать только те, которые имеют нечетное количество
        букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.  */
        System.out.println("Задача 2");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Anna");
        map.put(2, "Bob");
        map.put(3, "Michael");
        map.put(5, "Alex");
        map.put(8, "John");
        map.put(9, "Kate");
        map.put(13, "Tom");

        Set<Integer> allowedIds = Set.of(1, 2, 5, 8, 9, 13);

        List<String> result = map.entrySet().stream()
                .filter(entry -> allowedIds.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .filter(name -> name.length() % 2 != 0)
                .map(name -> new StringBuilder(name).reverse().toString())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
