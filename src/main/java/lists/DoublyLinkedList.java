package lists;

import data.Student;
import sort.*;


public class DoublyLinkedList<T> implements IListable<T> {


    private int size = 0;

    private Node first = null;
    private Node last = null;

    private static class Node {
        private Node previous;
        private Student value;
        private Node next;

        public Node(Node previous, Student value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return first == null && last == null;
    }


    public void add(Student data) {
        if (size == 0) {
            first = new Node(null, data, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, data, null);
            secondLast.next = last;
        }
        size++;
    }


    public void addFirst(Student data) {
        Node nodeNext = getNode(0);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, data, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }


    public void addLast(Student data) {
        add(data);
    }


    public void insert(int index, Student data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(data);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, data, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }


    public T get(int index) {

        return (T) getNode(index).value;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }



    public void remove(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
    }


    public void print() {
        Node node = first;
        for (int i = 0; i < size; i++) {
            System.out.println(node.value.toString());
            node = node.next;
        }
    }


    public IListable<Student> find(int meth, String param) {
        IListable<Student> listable = (IListable<Student>) new DoublyLinkedList<Student>();
        Node node = first;
        String eq = "";
        String eqNum = "";
        switch (meth) {
            case 1:
                for (int i = 0; i < size; i++) {
                    if (param.equals(node.value.getPrename())) {
                        listable.add(node.value);
                    }
                    node = node.next;
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    if (param.equals(node.value.getSurname())) {
                        listable.add(node.value);
                    }
                    node = node.next;
                }
                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    if (param.equals(eq + node.value.getCourse())) {
                        listable.add(node.value);
                    }
                    node = node.next;
                }
                break;
            case 4:
                for (int i = 0; i < size; i++) {
                    if (param.equals(eqNum + node.value.getMatriculationNumber())) {
                        listable.add(node.value);
                    }
                    node = node.next;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + meth);
        }
        return listable;
    }


    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("List: " + System.lineSeparator());
        Node temp = first;
        while (temp != null) {
            builder.append(" " + temp.value + System.lineSeparator());
            temp = temp.next;
        }
        return builder.toString();
    }
}