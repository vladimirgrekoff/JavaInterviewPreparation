package lesson3.task2;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Первый счетчик");
        counterOneTest();
        System.out.println();

        System.out.println("Второй счетчик");
        counterTwoTest();
        System.out.println();


        System.out.println("Третий счетчик");
        counterThreeTest();
        System.out.println();
    }


    private static void counterOneTest() throws InterruptedException {
        CounterOne counterOne = new CounterOne();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " выполнил increment(), " + (j + 1) + "-й раз, значение счетчика " + counterOne.increment());
                }
            });
            thread.setName("Поток № " + i);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println("Counter:" + counterOne.getValue());
    }

    private static void counterTwoTest() throws InterruptedException {
        CounterTwo counterTwo = new CounterTwo();

        for (int i = 0; i < 10; i++) {
        Thread thread = new Thread(() -> {
            for (int j = 0; j < 10; j++) {
                counterTwo.increase();
                System.out.println(Thread.currentThread().getName() + " выполнил increase(), "  + (j + 1) + "-й раз, значение счетчика " + counterTwo.getValue());
            }
        });
        thread.setName("Поток № " + i);
        thread.start();
    }
        Thread.sleep(1000);
        System.out.println("Counter:" + counterTwo.getValue());
    }

    private static void counterThreeTest() throws InterruptedException {
        CounterThree counterThree = new CounterThree();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " выполнил increment(), " + (j + 1) + "-й раз, значение счетчика " + counterThree.increment());
                }
            });
            thread.setName("Поток № " + i);
            thread.start();
        }
        Thread.sleep(1000);
        System.out.println(counterThree.getValue());
    }
}




