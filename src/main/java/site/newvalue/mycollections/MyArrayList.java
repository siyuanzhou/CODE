package site.newvalue.mycollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        // TODO Auto-generated constructor stub
        doclear();
    }

    public void clear() {
        doclear();
    }

    private void doclear() {
        // TODO Auto-generated method stub
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newCapacity) {
        // TODO Auto-generated method stub
        if (newCapacity < theSize) {
            return;
        }

        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = old[i];
        }
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    private void trim2Size() {
        ensureCapacity(theSize);
    }

    public T get(int index) {
        if (index < 0 || index > theSize) {
            throw new IndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public void set(int index, T val) {
        if (index < 0 || index > theSize) {
            throw new IndexOutOfBoundsException();
        }
        theItems[index] = val;
    }

    public boolean add(T val) {
        add(size(), val);
        return true;

    }

    public void add(int index, T val) {
        if (theSize == theItems.length) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = val;
        theSize++;
    }

    public void remove(int index) {
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
    }

    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new myArraylistIterator();
    }

    class myArraylistIterator implements Iterator<T> {

        private int current = 0;

        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current < size();
        }


        public T next() {
            // TODO Auto-generated method stub
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current++;
            return theItems[current];
        }

        public void remove() {
            MyArrayList.this.remove(current);
            current--;
        }

    }


}
