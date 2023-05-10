package lesson1.task3.model;



public class Triangle extends Figure implements Computable {
    double sideA;
    double sideB;
    double sideC;
    double semi_perimeter;


    public Triangle(String name, double sideA, double sideB, double sideC) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        computePerimeter();
        computeArea();
    }

    @Override
    public void computePerimeter() {
        double perimeter = sideA + sideB + sideC;
        perimeter = Math.round(perimeter * 100.0) / 100.0;
        super.setPerimeter(perimeter);
        this.semi_perimeter = perimeter / 2;
    }

    @Override
    public void computeArea() {
        double area = Math.sqrt(semi_perimeter * (semi_perimeter - sideA) * (semi_perimeter - sideB) * (semi_perimeter - sideC));
        area = Math.round(area * 100.0) / 100.0;
        super.setArea(area);
    }

    @Override
    public String toString() {
        return "Фигура " + this.getName() + ", стороны (a = " + sideA + ", b = " + sideB + ", c = " + sideC + "), " + " периметр " + this.getPerimeter() + ", площадь " + this.getArea();
    }

    @Override
    public void info() {
        System.out.println(this.toString());
    }

}
