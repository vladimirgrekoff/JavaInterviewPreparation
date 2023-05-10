package lesson3.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThree {
    private final Lock lock = new ReentrantLock();
    private int value;

    public int increment() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }
}


