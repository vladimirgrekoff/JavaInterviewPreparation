package lesson3.task2;

import java.util.concurrent.atomic.LongAdder;

public class CounterTwo {
    LongAdder counter;

    public CounterTwo() {
        counter = new LongAdder();
    }

    void increase(){
        counter.increment();
    }

    public long getValue(){
        return counter.longValue();
    }


}
