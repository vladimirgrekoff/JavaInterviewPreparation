package lesson1.task3.model;



public abstract class Figure {
    private String name;
    private double perimeter;
    private double area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    protected Figure(String name) {
        this.name = name;
    }

    public void info() {}
}
