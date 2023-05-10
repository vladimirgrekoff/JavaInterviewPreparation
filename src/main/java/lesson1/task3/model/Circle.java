package lesson1.task3.model;



public class Circle extends Figure implements Computable {
    private final double PI = Math.PI;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(String name, double radius) {
        super(name);
        this.setRadius(radius);
        computePerimeter();
        computeArea();
    }

    @Override
    public void computePerimeter() {
        double perimeter = 2 * PI * radius;
        perimeter = Math.round(perimeter * 100.0) / 100.0;
        super.setPerimeter(perimeter);
    }



    @Override
    public void computeArea() {
        double area = PI * radius * radius;
        area = Math.round(area * 100.0) / 100.0;
        super.setArea(area);
    }

    @Override
    public String toString() {
        return "Фигура " + this.getName() + ", радиус " + this.getRadius() + ", длина окружности " + this.getPerimeter() + ", площадь " + this.getArea();
    }

    @Override
    public void info() {
        System.out.println(this.toString());
    }
}
