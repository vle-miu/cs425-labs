package edu.miu.cs.cs425.studentrecordsmgmtapp;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp
{
    public static void main( String[] args )
    {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(110001L, "Dave", LocalDate.of(1951, 11, 18));
        Student s2 = new Student(110002L, "Anna", LocalDate.of(1990, 12, 7));
        Student s3 = new Student(110003L, "Erica", LocalDate.of(1974, 1, 31));
        Student s4 = new Student(110004L, "Carlos", LocalDate.of(2009, 8, 22));
        Student s5 = new Student(110005L, "Bob", LocalDate.of(1994, 8, 5));
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println("All students: ");
        printListOfStudents(students);

        System.out.println("All PlatinumAlumniStudents: ");
        List<Student> platiumAlmuniStudents = getListOfPlatinumAlumniStudents(students);
        for (Student student : platiumAlmuniStudents) {
            System.out.println(student);
        }

        System.out.println("Print HelloWorld: ");
        printHelloWorld(new int[] {5, 7, 35});


        System.out.println("Print findSecondBiggest: [1, 2, 3, 4, 5]");
        System.out.println(findSecondBiggest(new int[] {1, 2, 3, 4, 5}));

        System.out.println("Print findSecondBiggest: [19, 9, 11, 0, 12]");
        System.out.println(findSecondBiggest(new int[] {19, 9, 11, 0, 12}));
    }

    private static void printListOfStudents(List<Student> students) {
        students = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        return students.stream()
                .filter(e -> e.getDateOfAdmission().plus(30, ChronoUnit.YEARS).isBefore(LocalDate.now()))
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .collect(Collectors.toList());
    }

    private static void printHelloWorld(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 5 == 0 && numbers[i] % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (numbers[i] % 5 == 0) {
                System.out.println("Hello");
            } else if (numbers[i] % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    private static int findSecondBiggest(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int biggest = numbers[0];
        int secondBiggest = numbers[1];
        if (biggest < secondBiggest) {
            int temp = biggest;
            biggest = secondBiggest;
            secondBiggest = temp;
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > biggest) {
                secondBiggest = biggest;
                biggest = numbers[i];
            } else if (numbers[i] > secondBiggest) {
                secondBiggest = numbers[i];
            }
        }
        return secondBiggest;
    }
}
