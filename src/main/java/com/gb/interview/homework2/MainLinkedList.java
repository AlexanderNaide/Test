package com.gb.interview.homework2;

import java.util.Arrays;
import java.util.List;

public class MainLinkedList <T> {

    private Node<T> first;
    private Node<T> last;
    private int count;

    public MainLinkedList() {
        this.count = 0;
    }

    public MainLinkedList(T[] arr) {
        this.count = 0;
        Arrays.stream(arr).forEach(this::add);
    }

    public MainLinkedList(List<T> list) {
        this.count = 0;
        list.forEach(this::add);
    }

    public void add(T value){
        Node<T> node = new Node<>(value);
        if (first == null){
            first = node;
        } else {
            last.setChild(node);
            node.setParent(last);
        }
        last = node;
        count++;
    }

    public void add(int x, T value){
        if(x > count + 1 || x < 0){
            throw new NullPointerException();
        }
        if (first == null){
            add(value);
        }
        Node<T> node = getNodeForIndex(x);
        Node<T> newNode = new Node<>(value);
        if (node == first){
            newNode.setChild(node);
            node.setParent(newNode);
            first = newNode;
        } else if (node == last){
            node.setChild(newNode);
            newNode.setParent(node);
            last = newNode;
        } else {
            node.getParent().setChild(newNode);
            newNode.setParent(node.getParent());
            newNode.setChild(node);
            node.setParent(newNode);
        }
        count++;
    }

    public void del(T value){
        deleteNode(getNodeForValue(value));
    }

    public void remove(int x){
        deleteNode(getNodeForIndex(x));
    }

    public int size(){
        return count;
    }

    private void deleteNode(Node<T> node){
        if (first != null){
            if (node.getParent() != null){
                if(node.getChild() == null){
                    node.getParent().setChild(null);
                    last = node.getParent();
                } else {
                    node.getParent().setChild(node.getChild());
                }
            }
            if (node.getChild() != null){
                if (node.getParent() == null){
                    node.getChild().setParent(null);
                    first = node.getChild();
                } else {
                    node.getChild().setParent(node.getParent());
                }
            }
            count--;
        }
    }

    private Node<T> getNodeForIndex(int x){
        Node<T> node = null;
        if (x < count / 2){
            for (int i = 0; i <= x; i++) {
                if (node == null) {
                    node = first;
                } else {
                    node = node.getChild();
                }
            }
        } else {
            for (int i = count - 1; i >= x; i--) {
                if (node == null) {
                    node = last;
                } else {
                    node = node.getParent();
                }
            }
        }
        return node;
    }

    private Node<T> getNodeForValue(T value){
        Node<T> node = first;
        do {
            if(node.getValue().equals(value)){
                return node;
            } else {
                node = node.getChild();
            }
        } while (!node.equals(last));
        return node;
    }

    public T get(int x){
        if(x > count || x < 0){
            throw new NullPointerException();
        }
        Node<T> node = getNodeForIndex(x);
        return node.getValue();
    }

    public boolean contains(T value){
        return search(value) != -1;
    }

    public int search(T value){
        Node<T> node;
        int position;
        if (first == null){
            return -1;
        } else {
            node = first;
            position = 0;
        }
        do {
            if(node.getValue().equals(value)){
                return position;
            } else {
                node = node.getChild();
                position++;
            }
        } while (!node.equals(last));
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (first != null){
            Node<T> node = first;
            sb.append(node.getValue());
            do {
                node = node.getChild();
                sb.append(", ");
                sb.append(node.getValue());
            } while (!node.equals(last));
        }
        sb.append("]");
        return sb.toString();
    }
}
