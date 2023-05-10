package lesson1.task2;

import lesson1.task2.model.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestCars {

    public static void main(String[] args) throws NoSuchMethodException {


        List<Car> cars = new ArrayList<>();
//        LightWeightCar car1 = new LightWeightCar();
//        car1.setColor("Красный");
//        car1.setName("ЗАЗ-968");
//        cars.add(car1);
//        Lorry car2 = new Lorry();
//        car2.setColor("Белый");
//        car2.setName("МАЗ-500");
//        cars.add(car2);
//
//
//        for(Car car: cars) {
//            if (car.equals(car1)) {
//                System.out.println(car.getColor() + " " + car.getName());
//                car1.open();
//                car1.start();
//                car1.move();
//            } else if (car.equals(car2)) {
//                System.out.println(car2.getColor() + " " + car2.getName());
//                car2.open();
//                car2.start();
//                car2.move();
//                car2.stop();
//            }
//        }

// при добавлении конструкторов в классы код упрощается
        cars.add(new LightWeightCar("ЗАЗ-968","Красный", new Engine()));
        cars.add(new Lorry("МАЗ-500", "Белый", new Engine()));
        cars.forEach (car -> {
            System.out.println(car.getColor() + " " + car.getName());
            car.open();
            car.start();
            car.move();
        });

    }
}
