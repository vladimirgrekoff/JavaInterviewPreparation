package lesson1.task2.model;

//модификатор поменять на public (доступ вне пакета)
public abstract class Car {
    private String name;
    private String color;
    public Engine engine;

    public Car() {
    }
    //модификатор поменять на public (доступ вне пакета)
    public void start() {
        System.out.println("Car starting");
    }
    //модификатор поменять на public (доступ вне пакета)
    public abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //добавить конструктор
    protected Car(String name, String color, Engine engine) {
        this.name = name;
        this.color = color;
        this.engine = engine;
    }
    //добавить открытый абстрактный метод для возможности использования в коллекции
    public abstract void move();
}
