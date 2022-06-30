public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, Node n) {
            prev = p;
            next = n;
        }

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        Node n = new Node(null, item, null);
        n.next = sentinel.next;
        n.prev = sentinel;
        sentinel.next.prev = n;
        sentinel.next = n;
        size = size + 1;
    }

    public void addLast(T item) {
        Node n = new Node(null, item, null);
        n.next = sentinel;
        n.prev = sentinel.prev;
        sentinel.prev.next = n;
        sentinel.prev = n;
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T res = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size = size - 1;
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T res = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = size - 1;
        return res;
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    private T getRecursive(Node n, int index) {
        if (index == 0) {
            return n.next.item;
        }
        return getRecursive(n.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursive(sentinel, index);
    }
}
