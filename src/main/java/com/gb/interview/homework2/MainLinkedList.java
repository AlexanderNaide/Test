package com.gb.interview.homework2;

public class MainLinkedList <T> {

    private Node<T> first;
    private Node<T> last;

    private int count;

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
        Node<T> node = getNodeForIndex(x);
        Node<T> newNode = new Node<>(value);
        node.getParent().setChild(newNode);
        newNode.setParent(node.getParent());
        newNode.setChild(node);
        node.setParent(newNode);
        count++;
    }

    public void del(T value){
        if (first != null){
            Node<T> node = getNodeForValue(value);
            if (node.getParent() != null){
                node.getParent().setChild(node.getChild());
            }
            if (node.getChild() != null){
                node.getChild().setParent(node.getParent());
            }
            count--;
        }
    }

    public void remove(int x){
        if (first != null){
            Node<T> node = getNodeForIndex(x);
            if (node.getParent() != null){
                node.getParent().setChild(node.getChild());
            }
            if (node.getChild() != null){
                node.getChild().setParent(node.getParent());
            }
            count--;
        }
    }

    public int size(){
        return count;
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
        Node<T> node;
        if (first == null){
            return false;
        } else {
            node = first;
        }
        do {
            if(node.getValue().equals(value)){
                return true;
            } else {
                node = node.getChild();
            }
        } while (!node.equals(last));
        return false;
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
