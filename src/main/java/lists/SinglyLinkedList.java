package lists;

import data.Course;
import data.Student;

public class SinglyLinkedList<T> implements IListable<T> {


    private Node first = null;
    private int size = 0;

    private class Node {
        Student data;

        public Node(Student data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node next;
    }


    @Override
    public void add(Student data) {
        Node node = new Node(data, null);
        //node.data = data;
        //node.next = null;

        if (first == null) {
            first = node;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    @Override
    public void addFirst(Student data) {
        if (size == 0) {
            add(data);
            size++;
            return;
        }
        Node newSecond = getNode(0);
        Node newFirst = new Node(data, newSecond);
        first = newFirst;
        size++;
    }

    @Override
    public void addLast(Student data) {

        add(data);
    }

    @Override
    public void insert(int index, Student data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(data);
            return;
        }
        /*
        Node temp = first;
        int counter = 0;
        while (counter != index) {
            temp = temp.next;
            counter++;
        }
         */
        Node node = getNode(index);
        Node previous = getNode(index - 1);
        Node insert = new Node(data, node.next);
        previous.next = insert;
        insert.next = node;
        size++;
    }


    @Override
    public T get(int index) {
        return (T) getNode(index).data;
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


    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = first;
        int counter = 0;
        while (counter != index) {
            temp = temp.next;
            counter++;
        }
        Node before = getNode(counter - 1);
        before.next = temp.next;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    @Override
    public IListable<Student> find(int meth, String param) {
        IListable<Student> listable = (IListable<Student>) new DoublyLinkedList<Student>();
        Node node = first;
        String eq = "";
        String eqNum = "";
        switch (meth) {
            case 1:
                for (int i = 0; i < size; i++) {
                    if (param.equals(node.data.getPrename())) {
                        listable.add(node.data);
                    }
                    node = node.next;
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    if (param.equals(node.data.getSurname())) {
                        listable.add(node.data);
                    }
                    node = node.next;
                }
                break;
            case 3:
                for (int i = 0; i < size; i++) {
                    if (param.equals(eq + node.data.getCourse())) {
                        listable.add(node.data);
                    }
                    node = node.next;
                }
                break;
            case 4:
                for (int i = 0; i < size; i++) {
                    if (param.equals(eqNum + node.data.getMatriculationNumber())) {
                        listable.add(node.data);
                    }
                    node = node.next;
                }
                break;
        }
        return listable;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("List: " + System.lineSeparator());
        Node temp = first;
        while (temp != null) {
            builder.append(" " + temp.data + System.lineSeparator());
            temp = temp.next;
        }
        return builder.toString();
    }
}