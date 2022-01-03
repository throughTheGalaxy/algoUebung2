package data;

import lists.*;
import sort.*;

public class MatriculationNumberComparator<T> implements sort.Comparator<T> {


    public int compare(Student student1, Student student2) {
        if (student1.getMatriculationNumber() == student2.getMatriculationNumber()) {
            return 0;
        } else if (student1.getMatriculationNumber() < student2.getMatriculationNumber()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
}