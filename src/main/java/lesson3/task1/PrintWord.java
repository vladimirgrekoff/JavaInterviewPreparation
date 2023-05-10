package lesson3.task1;

public class PrintWord {
    private final Object mon = new Object();
    private volatile String currentWord = "Ping";

//  printWord = "Ping", newValue = "Pong";
//  printWord = "Pong", newValue = "Ping";

    public void printPingPong(String printWord, String newValue) {
        synchronized (mon) {
            try {
                while (!currentWord.equals(printWord)) {
                    mon.wait();
                }
                Thread.sleep(500);
                System.out.println(printWord);
                currentWord = newValue;
                mon.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
