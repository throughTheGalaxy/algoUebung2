package lists;

import data.Student;

import java.util.List;

public interface IListable<T> {
    void add(Student data);

    void addFirst(Student data);

    void addLast(Student data);

    void insert(int index, Student data);

    T get(int index);

    void remove(int index);

    int size();

    boolean isEmpty();

    void clear();

    void print();

    // TODO: find
    IListable<Student> find(int meth, String param);

}
