package lesson1.task3;

import lesson1.task3.model.Circle;
import lesson1.task3.model.Figure;
import lesson1.task3.model.Square;
import lesson1.task3.model.Triangle;

import java.util.ArrayList;
import java.util.List;


public class TestFigure {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();

        figures.add(new Circle("круг", 4));
        figures.add(new Square("квадрат", 8));
        figures.add(new Triangle("треугольник", 6, 7, 8));

        figures.forEach(Figure::info);

    }
}
