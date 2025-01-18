import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    public E get(int index) {
        checkIndexOutBound(index);

        return elements[index];
    }

    public E remove(int index) {
        checkIndexOutBound(index);

        E removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);

        return removedElement;
    }

    public int size() {
        return size;
    }

    private void checkIndexOutBound(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void addAll(CustomArrayList<? extends E> other) {
        ensureCapacity(size + other.size());
        System.arraycopy(other.elements, 0, elements, size, other.size());
        size += other.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
