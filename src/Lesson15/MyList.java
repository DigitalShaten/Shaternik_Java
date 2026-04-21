package Lesson15;

public class MyList<T> {
    private Object[] array;
    private int size;

    public MyList() {
        this.array = new Object[10];
        this.size = 0;
    }

    public MyList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size] = element;
        size++;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index);
        }
    }

    public int size() {
        return size;
    }
}
