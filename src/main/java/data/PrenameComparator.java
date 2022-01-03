package data;

import java.util.Comparator;

public class PrenameComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getPrename().compareTo(student2.getPrename());
    }
}
