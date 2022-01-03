package lists;

import data.Student;

import java.util.Arrays;

public class StudentArrayList<T> implements IListable<T> {
    private Student [] array = new Student[10];
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public void add(Student car) {
        increaseArray();
        array[size] = car;
        size++;
    }

    @Override
    public void addFirst(Student data) {
        int index = 0;
        increaseArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = data;
        size++;
    }

    @Override
    public void addLast(Student data) {
        int index = size();
        increaseArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = data;
        size++;
    }


    public void insert(int index, Student car) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = car;
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new Student[10];
        size = 0;
    }

    @Override
    public void print() {
        for (Student s : array) {
            if (s == null) {
                continue;
            }
            System.out.println(s);
        }
    }

    @Override
    public IListable<Student> find(int meth, String param) {
        IListable<Student> listable = new StudentArrayList<>();
        String eq = "";
        String eqNum = "";
        switch (meth) {
            case 1:
                for (int i = 0; i < size(); i++) {
                    if (param.equals(array[i].getPrename())) {
                        listable.add(array[i]);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < size(); i++) {
                    if (param.equals(array[i].getSurname())) {
                        listable.add(array[i]);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < size(); i++) {
                    if (param.equals(eq + array[i].getCourse())) {
                        listable.add(array[i]);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < size(); i++) {
                    if (param.equals(eqNum + array[i].getMatriculationNumber())) {
                        listable.add(array[i]);
                    }
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + meth);
        }
        return listable;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
}