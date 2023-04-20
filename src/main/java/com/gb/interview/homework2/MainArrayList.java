package com.gb.interview.homework2;

import java.util.Arrays;
import java.util.List;

public class MainArrayList<T> {

    private Object[] array;
    private int count;

    private final int startSize = 10;

    public MainArrayList() {
        this.array = new Object[startSize];
        this.count = 0;
    }

    public MainArrayList(T[] arr) {
        this.array = Arrays.copyOf(arr, arr.length);
        this.count = array.length;
    }

    public MainArrayList(List<T> list) {
        this.array = Arrays.copyOf(list.toArray(), list.size());
        this.count = array.length;
    }

    private void recalculationUp(){
        if (count == array.length){
            array = Arrays.copyOf(array, (count * 2) + 1);
        }
    }

    private void recalculationDown(){
        if (count == array.length / 2){
            array = Arrays.copyOf(array, count + 1);
        }
    }



    public void add(T value){
        recalculationUp();
        array[count] = value;
        count++;
    }

    public void add(int position, T value){
        if (position == count){
            add(value);
        } else {
            recalculationUp();
            for (int i = count; i > position; i--) {
                array[i] = array[i - 1];
            }
            array[position] = value;
            count++;
        }
    }

    public void del(T value){
        deleteForIndex(search(value));
    }

    public void remove(int position){
        deleteForIndex(position);
    }

    public int size(){
        return count;
    }


    private void deleteForIndex(int i){
        if (i >= 0 && i < count){
            for (int j = i; j < count - 1; j++) {
                array[j] = array[j + 1];
            }
            array[count - 1] = null;
            count--;
            recalculationDown();
        }
    }

    public T get(int x){
        if(x > count - 1 || x < 0){
            throw new NullPointerException();
        }
        return (T) array[x];
    }

    public boolean contains(T value){
        return search(value) != -1;
    }

    public int search(T value){
        if (count == 0){
            return -1;
        } else {
            for (int i = 0; i < count; i++) {
                if(array[i].equals(value)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            if (i > 0){
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
