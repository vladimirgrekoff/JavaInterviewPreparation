package lesson3.task2;

class CounterOne {
    private long counter;

    public long increment() {
        synchronized (this) {
            return ++counter;
        }
    }

    public long getValue() {
            return counter;
    }
}

