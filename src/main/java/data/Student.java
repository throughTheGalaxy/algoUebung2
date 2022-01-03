package data;

import sort.Comparator;

import java.util.Objects;

public class Student implements Comparable<Student>, Comparator<Student> {


    private String prename;
    private String surname;
    private Course course;
    private int matriculationNumber;

    public Student(String prename, String surname, Course course, int matriculationNumber) {
        super();
        this.prename = prename;
        this.surname = surname;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }


    @Override
    public String toString() {
        return "Student [prename=" + prename + ", surname=" + surname + ", course=" + course + ", matriculationNumber="
                + matriculationNumber + "]";
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }


    Comparator<Student> studentComparator = new Comparator<Student>() {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.getMatriculationNumber() - student2.getMatriculationNumber();
        }
    };


    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && matriculationNumber == student.matriculationNumber && Objects.equals(prename, student.prename) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prename, surname, course, matriculationNumber);
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public int compareTo(Student o) {
        if ((this.getMatriculationNumber() == o.getMatriculationNumber())) {
            return 0;
        } else if (this.getMatriculationNumber() < o.getMatriculationNumber()) {
            return -1;
        } else {
            return 1;
        }
    }
}