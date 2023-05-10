package lesson2.task1;



import java.util.List;

public class TestSimpleLinkedList {
    public static void main(String[] args) {

        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList<>();

        System.out.println("добавить значения в список:");
        simpleLinkedList.add("пирамида");
        simpleLinkedList.add("конус");
        simpleLinkedList.add("цилиндр");
        simpleLinkedList.add("призма");

        System.out.println("и получить все: ");
        simpleLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("добавить значения в начало и конец:");
        simpleLinkedList.addFirst("куб");
        simpleLinkedList.addLast("тор");

        simpleLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("добавить значения по индексам 0 и 2");
        simpleLinkedList.add(0,"шар");
        simpleLinkedList.add(2,"параллелепипед");
        System.out.println("проверить: ");
        simpleLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("Получить первый элемент: " + simpleLinkedList.getFirst());
        System.out.println("Получить последний элемент: " + simpleLinkedList.getLast());
        System.out.println("Получить значение по индексу 4: " + simpleLinkedList.get(4));
        System.out.println();


        System.out.println("Получить индекс элемента тетраэдр: " + simpleLinkedList.indexOf("тетраэдр"));
        System.out.println("Получить индекс элемента куб: " + simpleLinkedList.indexOf("куб"));
        System.out.println("Получить индекс элемента пирамида: " + simpleLinkedList.indexOf("пирамида"));
        System.out.println("Получить индекс элемента тор: " + simpleLinkedList.indexOf("тор"));
        System.out.println();

        System.out.println("Удалить по индексу 1: " + simpleLinkedList.remove(1));
        System.out.println("Удалить по значению - параллелепипед: " + simpleLinkedList.remove("параллелепипед"));
        System.out.println("проверить: ");
        simpleLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("Заменить значение по индексу 4: " + simpleLinkedList.set(4, "параллелепипед") + ", на параллелепипед");
        System.out.println("Есть ли в списке призма: " + simpleLinkedList.contains("призма"));
        System.out.println("Получить индекс элемента призма: " + simpleLinkedList.indexOf("призма"));
        simpleLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("Удалить первый и последний: ");
        System.out.println("Удален первый: " + simpleLinkedList.removeFirst());
        System.out.println("Удален последний: " + simpleLinkedList.removeLast());
        System.out.println("Получить все: ");
        simpleLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("очистить список: ");
        simpleLinkedList.clear();
        System.out.println("Получить размер списка: " + simpleLinkedList.getSize());
        System.out.println();

        System.out.println("создать из массива:");
        simpleLinkedList = new SimpleLinkedList<>(List.of(new String[]{"круг", "овал", "треугольник", "четырехугольник", "квадрат", "ромб", "трапеция", "параллелограмм"}));
        simpleLinkedList.forEach(System.out::println);
        System.out.println("размер списка: " + simpleLinkedList.getSize());

    }
}
