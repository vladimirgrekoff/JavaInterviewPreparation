package lesson1.task3.model;



public class Square extends Figure implements Computable {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(String name, double side) {
        super(name);
        this.setSide(side);
        computePerimeter();
        computeArea();
    }

    @Override
    public void computePerimeter() {
        double perimeter = 4 * side;
        perimeter = Math.round(perimeter * 100.0) / 100.0;
        super.setPerimeter(perimeter);
    }

    @Override
    public void computeArea() {
        double area = side * side;
        area = Math.round(area * 100.0) / 100.0;
        super.setArea(area);
    }

    @Override
    public String toString() {
        return "Фигура " + this.getName() + ", сторона " + this.getSide() + ", периметр " + this.getPerimeter() + ", площадь " + this.getArea();

    }

    @Override
    public void info() {
        System.out.println(this.toString());
    }
}
