package lesson2.task1;

import java.util.Collection;
import java.util.function.Consumer;

public class SimpleLinkedList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> getNode(int index) {
        Node<E> required;
        if (index <= ((size-1)/2)) {
            required = first;
            for (int i = 0; i < index; i++) {
                required = required.next;
            }
        } else {
            required = last;
            for (int i = size - 1; i > index; i--) {
                required = required.prev;
            }
        }
        return required;
    }

    private void addNode(E item, int index) {
        final Node<E> firstNode = first;
        final Node<E> lastNode = last;

        if (firstNode == null || index == 0) {
            final Node<E> newNode = new Node<>(null, item, firstNode);
            first = newNode;
            if (firstNode == null) {
                last = newNode;
            } else {
                firstNode.prev = newNode;
            }
        } else if (index == -1 || (index == size && size > 0)) {
            final Node<E> newNode = new Node<>(lastNode, item, null);
            last = newNode;
            if (lastNode == null) {
                first = newNode;
            } else {
                lastNode.next = newNode;
            }
        } else {
            Node<E> current = getNode(index);
            final Node<E> previous = current.prev;
            final Node<E> newNode = new Node<>(previous, item, current);
            current.prev = newNode;
            if (previous == null) {
                first = newNode;
            } else {
                previous.next = newNode;
            }
        }
        size++;
    }

    private E deleteNode(int index) {
        Node<E> removable = getNode(index);
        final E element = removable.item;
        final Node<E> next = removable.next;
        final Node<E> previous = removable.prev;

        if (previous == null) {
            first = next;
        } else {
            previous.next = next;
            removable.prev = null;
        }

        if (next == null) {
            last = previous;
        } else {
            next.prev = previous;
            removable.next = null;
        }

        removable.item = null;
        size--;
        return element;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    public int indexOf(E item) {
        int index = 0;

        for (Node<E> checked = first; checked != null; checked = checked.next) {
            if (item == null) {
                if (checked.item == null) {
                    return index;
                }
            } else {
                if (item.equals(checked.item)) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public E getFirst() {
        Node<E> firstNode = first;
        return firstNode.item;
    }

    public E getLast() {
        Node<E> lastNode = last;
        return lastNode.item;
    }

    public void addFirst(E item) {
        addNode(item, 0);
    }

    public void addLast(E item) {
        addNode(item, size);
    }

    public void clear() {
        for (Node<E> current = first; current != null; ) {
            Node<E> next = current.next;
            current.item = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        first = last = null;
        size = 0;
    }

    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    public E get(int index) {
        if (isElementIndex(index)) {
            return getNode(index).item;
        } else {
            return null;
        }
    }

    public E set(int index, E item) {
        if (isElementIndex(index)) {
            Node<E> required = getNode(index);
            E oldVal = required.item;
            required.item = item;
            return oldVal;
        } else {
            return null;
        }
    }

    public boolean add(E item) {
        addNode(item, -1);
        return true;
    }

    public void add(int index, E item) {
        if (isPositionIndex(index)) {
            addNode(item, index);
        }
    }

    public E removeFirst() {
        return deleteNode(0);
    }

    public E removeLast() {
        return deleteNode(size);
    }

    public E remove(int index) {
        if (isElementIndex(index)) {
            return deleteNode(index);
        }
        return null;
    }

    public boolean remove(E item) {
        int index = indexOf(item);
        if (index >= 0) {
            return item == deleteNode(index);
        }
        return false;
    }

    public void forEach(Consumer<? super E> action) {
        Node<E> current = first;
        int nextIndex = 0;
        while (current != null && nextIndex < size) {
            E element = current.item;
            current = current.next;
            action.accept(element);
            nextIndex++;
        }
    }

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(Collection<? extends E> collection) {

        Object[] a = collection.toArray();
        int numNew = a.length;
        if (numNew == 0) return;

        for (Object o : a) {
            E item = (E) o;//
            add(item);
        }
    }
}
