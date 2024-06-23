package com.example.doubly;

import java.util.ArrayList;

public class DoublyLinkedList<E> extends ArrayList<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean add(E data) {
        if (data == null) {
            throw new NullPointerException("Data can't be empty");
        }
        Node<E> newNode = new Node<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, E data) {
        if (data == null) {
            throw new NullPointerException("Data can't be empty");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't provide index less then 0 or exceed list size.");
        }
        Node<E> newNode = new Node<>(data);
        if (size == 0) {// List don't have any data
            head = newNode;
            tail = newNode;
        } else if (size > 0 && index == 0) {// Add at the beginning of the list
            head.left = newNode;
            newNode.right = head;
            head = newNode;
        } else if (size > 0 && index == size - 1) { // Add at the end of the list
            tail.right = newNode;
            newNode.left = tail;
            tail = newNode;
        } else { // Add in middle of the list
            Node<E> currentNode = findCurNode(index);
            if (currentNode == null) {
                throw new NullPointerException("Not found node from index provided.");
            }
            currentNode.left.right = newNode;
            newNode.left = currentNode.left;
            currentNode.left = newNode;
            newNode.right = currentNode;
        }
        size++;
    }

    // Remove return deleted value
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't provide index less then 0 or exceed list size.");
        }
        Node<E> currentNode = findCurNode(index);
        E oldData = currentNode.data;
        if (size == 1) { // list have only one and delete
            head = null;
            tail = null;
        } else if (index == 0) { // delete first index
            head = currentNode.right;
            currentNode.right = null;
            if (head != null) { // ensure head not null
                head.left = null;
            }
        } else if (index == size - 1) { // delete last index
            tail = currentNode.left;
            currentNode.left = null;
            if (tail != null) { // ensure tail not null
                tail.right = null;
            }
        } else { // delete middle of list
            currentNode.left.right = currentNode.right;
            currentNode.right.left = currentNode.left;
        }
        size--;
        return oldData;
    }

    //Set return old value
    @Override
    public E set(int index, E data) {
        if (data == null) {
            throw new NullPointerException("Data can't be empty");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't provide index less then 0 or exceed list size.");
        }
        Node<E> currentNode = findCurNode(index);
        E oldData = currentNode.data;
        currentNode.data = data;
        return oldData;
    }

    public void printForward() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.right;
        }
    }

    public void printBackward() {
        Node<E> currentNode = tail;
        int fLoop = 0;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.left;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't provide index less then 0 or exceed list size.");
        }
        return findCurNode(index).data;
    }

    private Node<E> findCurNode(int index) {
        Node<E> currentNode = head;
        int fLoop = 0;
        while (fLoop < index) {
            currentNode = currentNode.right;
            fLoop++;
        }
        return currentNode;
    }

}
