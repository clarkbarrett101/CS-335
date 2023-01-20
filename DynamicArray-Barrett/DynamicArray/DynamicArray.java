package DynamicArray;

import java.util.*;

public class DynamicArray<T> {

    int[] arg;
    int lastIndex;

    public DynamicArray() {
        arg = new int[20];
    }

    public DynamicArray(final int capacity) {
        arg = new int[capacity];
    }

    public void add(final int element) {
        if (lastIndex >= arg.length) {
            arg = Arrays.copyOf(arg, arg.length * 2);
        }
        arg[lastIndex] = element;
        lastIndex++;
    }

    public int remove(final int idx) {
        int removedItem = arg[idx];
        for (int i = idx; i < lastIndex - 1; i++) {
            arg[i] = arg[i + 1];
        }
        lastIndex--;
        if (arg.length > 20 && lastIndex <= arg.length / 2) {
            arg = Arrays.copyOf(arg, arg.length / 2);
        }
        return removedItem;
    }

    public void put(final int idx, int element) {
        arg[idx] = element;
    }

    public int get(final int idx) {
        return arg[idx];
    }

    public int get_size() {
        return lastIndex;
    }

    public int get_capacity() {
        return arg.length;
    }

    public boolean is_empty() {
        if (lastIndex == 0) {
            return true;
        } else {
            return false;
        }
    }

}