
//import com.google.common.math.Quantiles;

import data.*;
import lists.*;
import sort.*;

import java.util.*;

public class MainApp {


    public static void main(String[] args) throws InterruptedException {


        boolean work = true;
        boolean select = true;
        IListable<Student> list = null;


        //forMenu
        String text = null;
        String middleSingleList = "Console-Application: Exercise-2 <Nikita> <Ostrovskii> <s0578966>\n" +
                "You selected SinglyLinkedList:\n" +
                "  1. Add Student to the end of this list.\n" +
                "  2. Inserts the Student at the specified position in this list.\n" +
                "  3. Inserts the Student at the beginning of this list.\n" +
                "  4. Appends the Student to the end of this list.\n" +
                "  5. Returns the Student at the specified position in this list.\n" +
                "  6. Print all students to console from list.\n" +
                "  7. Returns the number of Students in this list.\n" +
                "  8. Removes the Student at the specified position in this list.\n" +
                "  9. Removes all of the Students from this list.\n" +
                " 10. Search for student(s) by different characteristics.\n" +
                " 11. Sort list by different properties.\n" +
                "  0. Exit\n" +
                "Please enter a number for an option:";

        String middleDoubleList = "Console-Application: Exercise-2 <Nikita> <Ostrovskii> <s0578966>\n" +
                "You selected DoublyLinkedList:\n" +
                "  1. Add Student to the end of this list.\n" +
                "  2. Inserts the Student at the specified position in this list.\n" +
                "  3. Inserts the Student at the beginning of this list.\n" +
                "  4. Appends the Student to the end of this list.\n" +
                "  5. Returns the Student at the specified position in this list.\n" +
                "  6. Print all students to console from list.\n" +
                "  7. Returns the number of Students in this list.\n" +
                "  8. Removes the Student at the specified position in this list.\n" +
                "  9. Removes all of the Students from this list.\n" +
                " 10. Search for student(s) by different characteristics.\n" +
                " 11. Sort list by different properties.\n" +
                "  0. Exit\n" +
                "Please enter a number for an option:";

        String middleArrayList = "Console-Application: Exercise-2 <Nikita> <Ostrovskii> <s0578966>\n" +
                "You selected ArrayList:\n" +
                "  1. Add Student to the end of this list.\n" +
                "  2. Inserts the Student at the specified position in this list.\n" +
                "  3. Inserts the Student at the beginning of this list.\n" +
                "  4. Appends the Student to the end of this list.\n" +
                "  5. Returns the Student at the specified position in this list.\n" +
                "  6. Print all students to console from list.\n" +
                "  7. Returns the number of Students in this list.\n" +
                "  8. Removes the Student at the specified position in this list.\n" +
                "  9. Removes all of the Students from this list.\n" +
                " 10. Search for student(s) by different characteristics.\n" +
                " 11. Sort list by different properties.\n" +
                "  0. Exit\n" +
                "Please enter a number for an option:";


        //fields of Objects
        String prename;
        String surname;
        int course;
        int number;
        String courseEnum;

        //index of List
        int index;

        //forSearch
        int characteristic;
        String method;
        String forSearch = "Select a property to search for the student:\n" +
                " 1. Search by prename?\n" +
                " 2. Search by surname?\n" +
                " 3. Search by course?\n" +
                " 4. Search by matriculation number?\n" +
                "Please enter a number for an option: \n";
        IListable<Student> listable;


        //forSorting
        String sBeginning = "Select a sorting method for sorting:\n" +
                " 1. Bubblesort?\n" +
                " 2. Selectionsort?\n" +
                "Please enter a number for an option: ";
        String sBubble = "Please select a property for sorting with the 'Bubblesort' algorithm:\n" +
                " 1. Sort by course?\n" +
                " 2. Sort by matriculation number?\n" +
                "Please enter a number for an option: \n";

        String sSelection = "Please select a property for sorting with the 'Selectionsort' algorithm:\n" +
                " 1. Sort by course?\n" +
                " 2. Sort by matriculation number?\n" +
                "Please enter a number for an option: \n";


        while (work) {
            String anfang = "Console-Application: Exercise-2 <Nikita> <Ostrovskii> <s0578966>\n" +
                    "Select list type before starting the main menu:\n" +
                    "  1. SinglyLinkedList\n" +
                    "  2. DoublyLinkedList\n" +
                    "  3. ArrayList\n" +
                    "Please enter a number for an option: \n";


            System.out.println(anfang);

            Scanner scanner = new Scanner(System.in);


            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    list = new SinglyLinkedList<>();
                    text = middleSingleList;
                    work = false;
                    break;
                case 2:
                    list = new DoublyLinkedList<>();
                    text = middleDoubleList;
                    work = false;
                    break;
                case 3:
                    list = new StudentArrayList<>();
                    text = middleArrayList;
                    work = false;
                    break;
                default:
                    work = false;
                    select = false;
                    break;
            }


            while (select) {
                System.out.println(text);
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        System.out.println("Enter prename: ");
                        prename = scanner.nextLine();
                        System.out.println("Enter surname: ");
                        surname = scanner.nextLine();
                        System.out.println("Enter course:");
                        courseEnum = scanner.nextLine();
                        System.out.println("Enter matriculation number: ");
                        number = Integer.parseInt(scanner.nextLine());
                        list.add(new Student(prename, surname, Course.valueOf(courseEnum), number));
                        break;
                    case 2:
                        System.out.println("Enter prename: ");
                        prename = scanner.nextLine();
                        System.out.println("Enter surname: ");
                        surname = scanner.nextLine();
                        System.out.println("Enter course:");
                        courseEnum = scanner.nextLine();
                        System.out.println("Enter matriculation number: ");
                        number = Integer.parseInt(scanner.nextLine());
                        System.out.println("Enter number of position: ");
                        index = Integer.parseInt(scanner.nextLine());
                        list.insert(index, new Student(prename, surname, Course.valueOf(courseEnum), number));
                        break;
                    case 3:
                        System.out.println("Enter prename: ");
                        prename = scanner.nextLine();
                        System.out.println("Enter surname: ");
                        surname = scanner.nextLine();
                        System.out.println("Enter course:");
                        courseEnum = scanner.nextLine();
                        System.out.println("Enter matriculation number: ");
                        number = Integer.parseInt(scanner.nextLine());
                        list.addFirst(new Student(prename, surname, Course.valueOf(courseEnum), number));
                        break;
                    case 4:
                        System.out.println("Enter prename: ");
                        prename = scanner.nextLine();
                        System.out.println("Enter surname: ");
                        surname = scanner.nextLine();
                        System.out.println("Enter course:");
                        courseEnum = scanner.nextLine();
                        System.out.println("Enter matriculation number: ");
                        number = Integer.parseInt(scanner.nextLine());
                        list.addLast(new Student(prename, surname, Course.valueOf(courseEnum), number));
                        break;
                    case 5:
                        System.out.println("Enter number of position: ");
                        index = Integer.parseInt(scanner.nextLine());
                        System.out.println(list.get(index));
                        break;
                    case 6:
                        list.print();
                        break;
                    case 7:
                        System.out.println("Size of list is " + list.size());
                        break;
                    case 8:
                        System.out.println("Enter number of position: ");
                        index = Integer.parseInt(scanner.nextLine());
                        list.remove(index);
                        break;
                    case 9:
                        list.clear();
                        break;
                    case 10:
                        System.out.println(forSearch);
                        switch (Integer.parseInt(scanner.nextLine())) {
                            case 1:
                                System.out.println("Please enter prename: ");
                                method = (String) scanner.nextLine();
                                listable = list.find(1, method);
                                listable.print();
                                break;
                            case 2:
                                System.out.println("Please enter surname: ");
                                method = (String) scanner.nextLine();
                                listable = list.find(2, method);
                                listable.print();
                                break;
                            case 3:
                                System.out.println("Please enter course: ");
                                method = (String) scanner.nextLine();
                                listable = list.find(3, method);
                                listable.print();
                                break;
                            case 4:
                                System.out.println("Please enter matriculation number: ");
                                method = (String) scanner.nextLine();
                                listable = list.find(4, method);
                                listable.print();
                                break;
                        }
                        break;
                    case 11:
                        /*
                        System.out.println(sBeginning);
                        switch (Integer.parseInt(scanner.nextLine())) {
                            case 1:
                                BubbleSort<Student> bubbleSort = new BubbleSort<>();
                                CourseComparator courseNummer = new CourseComparator();
                                MatriculationNumberComparator matricNummer = new MatriculationNumberComparator();
                                System.out.println(sBubble);
                                switch (Integer.parseInt(scanner.nextLine())) {
                                    case 1:
                                        list = bubbleSort.sort(list, courseNummer);
                                        break;
                                    case 2:
                                        list = bubbleSort.sort(list, matricNummer);
                                        break;
                                }
                                break;
                            case 2:
                                SelectionSort<Student> selectionSort = new SelectionSort<>();
                                CourseComparator courseNummer1 = new CourseComparator();
                                MatriculationNumberComparator matricNummer1 = new MatriculationNumberComparator();
                                System.out.println(sSelection);
                                switch (Integer.parseInt(scanner.nextLine())) {
                                    case 1:
                                        list = selectionSort.sort(list, courseNummer1);
                                        break;
                                    case 2:
                                        list = selectionSort.sort(list, matricNummer1);
                                        break;
                                }
                                break;
                        }
                        break;

                         */
                    case 0:
                        System.out.println("\nExit.");
                        select = false;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + Integer.parseInt(scanner.nextLine()));
                }
            }
        }
    }
}