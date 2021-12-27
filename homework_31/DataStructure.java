package homework_31;

import java.util.Iterator;

public class DataStructure<E> {
    private final E[] array;

    public DataStructure(E[] array) {
        this.array = array;
    }

    public void printEven() {
        EvenIterator evenIterator = this.new EvenIterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
    }

    public EvenIterator evenIterator() {
        return this.new EvenIterator();
    }

    public EvenIterator evenIterator(int index) {
        return this.new EvenIterator(index);
    }

    private interface ArrayIterator<E> extends Iterator<E> {

    }

    private class EvenIterator implements ArrayIterator<E> {
        int index = 0;

        public EvenIterator() {
        }

        public EvenIterator(int index) {
            this.index = index;
        }


        public boolean hasNext() {
            return index < array.length;
        }

        public E next() {
            E result = array[index];
            index += 2;
            return result;
        }
    }
}

