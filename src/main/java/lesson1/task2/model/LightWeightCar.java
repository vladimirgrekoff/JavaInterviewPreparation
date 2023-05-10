package lesson1.task2.model;


//модификатор поменять на public (доступ вне пакета)
public class LightWeightCar extends Car implements Moveable {


    //модификатор поменять на public (доступ вне пакета)
    @Override
    public void open() {
        System.out.println("Car is open");
    }

    // переопределение метода старт с функционалом суперкласса
    @Override
    public void start() {
        super.start();
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    //добавить конструкторы
    public LightWeightCar() {
    }
    public LightWeightCar(String name, String color, Engine engine) {
        super(name, color, engine);
    }
}


