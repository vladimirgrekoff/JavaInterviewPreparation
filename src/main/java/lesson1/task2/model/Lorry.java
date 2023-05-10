package lesson1.task2.model;

//множественное наследование не допустимо
// (class Lorry extends Car, Moveable, Stopable), интерфейсы реализуются
//модификатор поменять на public (доступ вне пакета)
public class Lorry extends Car implements Moveable, Stopable {
    public void move(){
        System.out.println("Car is moving");
    }
    public void stop(){
        System.out.println("Car is stop");
    }

// реализация абстрактного метода (объявлен в классе Car)
    @Override
    public void open() {
        System.out.println("Car is open");
    }
// переопределение метода старт с функционалом суперкласса
    @Override
    public void start() {
        super.start();
    }

    //добавить конструкторы
    public Lorry() {
    }
    public Lorry(String name, String color, Engine engine) {
        super(name, color, engine);
    }
}
