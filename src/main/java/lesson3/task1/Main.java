package lesson3.task1;

public class Main {
    public static void main(String[] args) {
        PrintWord printWord = new PrintWord();



    Thread thread1 = new Thread(() -> {
        for (int i = 0; i < 5; i++) {
            printWord.printPingPong("Ping", "Pong");
        }
    });

    Thread thread2 = new Thread(() -> {
        for (int i = 0; i < 5; i++) {
            printWord.printPingPong("Pong","Ping");
        }
    });
        thread1.start();
        thread2.start();
    }

}
