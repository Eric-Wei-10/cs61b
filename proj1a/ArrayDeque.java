public class ArrayDeque<T> {
    /** Treat the array as a circular array */
    int size;
    T[] items;
    int front;
    int rear;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        front = 0;
        rear = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size;
        front = other.front;
        rear = other.rear;
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
    }

    private void resize(int newSize) {
        T[] p = (T[]) new Object[newSize];
        System.arraycopy(items, 0, p, 0, rear);
        System.arraycopy(items, front, p, p.length-items.length+front, items.length-front);
        front = p.length-items.length+front;
        items = p;
    }

    public void addLast(T item) {
        /** This means the array is full */
        if (size != 0 && front == rear) {
            resize(2*items.length);
        }
        items[rear] = item;
        rear = (rear + 1) % items.length;
        size = size + 1;
    }

    public void addFirst(T item) {
        if (size != 0 && front == rear) {
            resize(2*items.length);
        }
        items[(front - 1 + items.length) % items.length] = item;
        front = (front - 1 + items.length) % items.length;
        size = size + 1;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16 && (((double) (size - 1)) / items.length <= 0.25)) {
            resize(items.length/2);
        }
        T res = items[(rear - 1 + items.length) % items.length];
        rear = (rear - 1 + items.length) % items.length;
        size = size - 1;
        return res;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (items.length >= 16 && (((double) (size - 1)) / items.length <= 0.25)) {
            resize(items.length/2);
        }
        T res = items[front];
        front = (front + 1) % items.length;
        size = size - 1;
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[(front + index) % items.length];
    }
}
