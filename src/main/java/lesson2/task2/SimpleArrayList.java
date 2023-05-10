package lesson2.task2;


import java.util.Collection;
import java.util.function.Consumer;

public class SimpleArrayList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int count;
    private T[] array ;


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        int coefficient = capacity / DEFAULT_CAPACITY;
        if (capacity > DEFAULT_CAPACITY) {
            if (capacity % DEFAULT_CAPACITY > 0) {
                capacity = (coefficient + 1) * DEFAULT_CAPACITY;
            } else {
                capacity = coefficient * DEFAULT_CAPACITY;
            }
        } else {
            capacity = DEFAULT_CAPACITY;
        }
        resize(capacity);
    }


    public int size() {
        return count;
    }

    private void resize(int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, count);
        array = (T[]) newArray;
        capacity = array.length;
    }

    public void add(T item){
        if (this.count + 1 >= array.length - 1) resize(array.length * 2);
        array[count++] = item;
    }

    public void add(int index, T item){
        if (this.count + 1 >= array.length - 1) resize(array.length * 2);
        Object[] newArray = new Object[array.length];

        if (index == 0) {
            newArray[0] = item;
            System.arraycopy(array, 0, newArray, 1, count);
            array = (T[]) newArray;
            this.count++;
        } else if (index > 0 && index < count - 1){
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = item;
            System.arraycopy(array, index, newArray, index + 1, array.length - (index + 1));
            array = (T[]) newArray;
            this.count++;
        } else if(index > count - 1){
            array[count++] = item;
        }
    }

    public T get(int index) {
        return array[index];
    }

    public T set(int index, T item) {
        T oldValue = array[index];
        array[index] = item;
        return oldValue;
    }

    public void forEach(Consumer<? super T> action){
        for (int i =0; i < count; i++) {
                action.accept(array[i]);
        }
    }

    public T remove(int index) {
        T removedValue = null;
        if (index >= 0 && index <= size() - 1) {
            Object[] newArray = new Object[array.length];
            removedValue = array[index];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - (index + 1));
            array = (T[]) newArray;
            this.count--;
        }
        return removedValue;
    }

    public boolean remove(T item) {
        int arraySize = this.size();
        int i;
        for (i = 0; i < arraySize; i++) {
            if (item == null) {
                if (array[i] == null) {
                    this.remove(i);
                    return true;
                }
            } else {
                if (item.equals(array[i])) {
                    this.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        int arraySize = size();
        for (int i = 0; i < arraySize; i++) {
            array[i] = null;
        }
        this.count = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public int indexOf(T item) {
        int arraySize = size();

        for (int i = 0; i < arraySize; i++) {
            if (item == null) {
                if (array[i] == null) {
                    return i;
                }
            } else {
                if (item.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) >= 0;
    }

    public SimpleArrayList(){
        this.capacity = DEFAULT_CAPACITY;
        T[] newArray = (T[]) new Object[capacity];
        array = newArray;
    }


    public SimpleArrayList(Collection<? extends T> collection) {
        Object[] a = collection.toArray();
        this.capacity = DEFAULT_CAPACITY;
        array = (T[]) new Object[capacity];;

        if (a.length != 0) {
            if (array.length <= a.length){
                setCapacity(a.length);
            }
            count = a.length;
            array = (T[]) a;
        } else {
            this.capacity = DEFAULT_CAPACITY;
            this.count = 0;
            array = (T[]) new Object[capacity];
        }
    }
}
