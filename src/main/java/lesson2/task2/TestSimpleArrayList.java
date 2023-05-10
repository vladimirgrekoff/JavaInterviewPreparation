package lesson2.task2;

import java.util.Arrays;

public class TestSimpleArrayList {

    public static void main(String[] args) {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<>();

        simpleArrayList.add("Кот");
        simpleArrayList.add("Собака");
        simpleArrayList.add("Петух");
        simpleArrayList.add("Утка");
        simpleArrayList.add("Индюк");
        simpleArrayList.add("Поросенок");
        simpleArrayList.add("Мышка");

        System.out.println("получить элемент (индекс = 1): " + simpleArrayList.get(1));
        System.out.println("емкость массива: " + simpleArrayList.getCapacity());
        System.out.println("элементов в массиве: " + simpleArrayList.size());
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);
        System.out.println();
        System.out.println("получить индекс Утки: " + simpleArrayList.indexOf("Утка"));
        System.out.println("получить индекс Собаки: " + simpleArrayList.indexOf("Собака"));
        System.out.println("проверить наличие Поросенка: " + simpleArrayList.contains("Поросенок"));
        System.out.println("проверить наличие Жирафа: " + simpleArrayList.contains("Жираф"));

        System.out.println();

        System.out.println("вставка Колобка по индексам 0, 5 и 10:");
        System.out.println("вставка значения null по индексу 3:");
        simpleArrayList.add(0, "Колобок");
        simpleArrayList.add(3, null);
        simpleArrayList.add(5, "Колобок");
        simpleArrayList.add(10, "Колобок");
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);
        System.out.println("емкость массива: " + simpleArrayList.getCapacity());
        System.out.println("элементов в массиве: " + simpleArrayList.size());
        System.out.println();

        System.out.println("удалить элемент по индексу:");
        System.out.println("удален элемент 10: " + simpleArrayList.remove(10));
        System.out.println("удален элемент 6: " + simpleArrayList.remove(5));
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);
        System.out.println("емкость массива: " + simpleArrayList.getCapacity());
        System.out.println("элементов в массиве: " + simpleArrayList.size());
        System.out.println();

        System.out.println("удалить элемент по значению:");
        System.out.println("удалить элемент Колобок: " + simpleArrayList.remove("Колобок"));
        System.out.println("удалить элемент null: " + simpleArrayList.remove(null));
        System.out.println("удалить элемент null: " + simpleArrayList.remove(null));
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);
        System.out.println("емкость массива: " + simpleArrayList.getCapacity());
        System.out.println("элементов в массиве: " + simpleArrayList.size());
        System.out.println();

        System.out.println("очистить массив:");
        simpleArrayList.clear();
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);
        System.out.println("емкость массива: " + simpleArrayList.getCapacity());
        System.out.println("элементов в массиве: " + simpleArrayList.size());
        System.out.println();

        System.out.println("создать из массива:");
        simpleArrayList = new SimpleArrayList<>(Arrays.asList("Кот", "Собака", "Петух", "Утка", "Индюк", "Поросенок", "Мышка"));
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);
        System.out.println("емкость массива: " + simpleArrayList.getCapacity());
        System.out.println("элементов в массиве: " + simpleArrayList.size());
        System.out.println();

        System.out.println("Заменить значение по индексу 1: " + simpleArrayList.set(1, "Полкан") + ", на Полкан");
        System.out.println("перечислить все:");
        simpleArrayList.forEach(System.out::println);

    }
}
