package communityuni.com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import communityuni.com.io.*;
import communityuni.com.model.*;

public class TestManageStudent {
    public static void main(String[] args) {
        ArrayList<Student> listStudent = RwStudent.readStudent();
        ArrayList<Teacher> listTeacher = RwTeacher.readTeacher();
        ArrayList<Course> listCourse = RwCourse.readCourse();
        ArrayList<Attendant> listAttendant = RwAtt.readAtt();
        boolean flag = true;
        while (flag) {
            System.out.println("1. Show list of teachers");
            System.out.println("2. Create course and assign teachers to course");
            System.out.println("3. Show student list and sort by gpa including grade ranking");
            System.out.println("4. Add student to the course");
            System.out.println("5. Show the students of a course");
            System.out.println("6. Show list of a student's courses including the name of the teacher who teaches that course");
            System.out.println("7. Save and exit");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1: 
                    for (Teacher gv : listTeacher) {
                        System.out.println(gv.getName() + " " + gv.getId());
                    }
                    break;
                case 2:
                    Course newCr = new Course();
                    System.out.print("Input course's name: ");
                    String s = new Scanner(System.in).nextLine();
                    newCr.setName(s);
                    System.out.print("Input course's id: ");
                    s = new Scanner(System.in).nextLine();
                    newCr.setId(s);
                    System.out.print("Input teacher's id");
                    s = new Scanner(System.in).nextLine();
                    newCr.setIdTeacher(s);
                    listCourse.add(newCr);
                    break;
                case 3:
                    ArrayList<Student> lsClone = (ArrayList<Student>) listStudent.clone();
                    Collections.sort(lsClone);
                    for (Student sv : lsClone) {
                        System.out.println(sv.toString() + " " + sv.getGpa());
                    }
                    break;
                case 4:
                    Attendant newAtt = new Attendant();
                    System.out.println("Input course's id: ");
                    s = new Scanner(System.in).nextLine();
                    newAtt.setIdCourse(s);
                    System.out.println("Input student's id: ");
                    s = new Scanner(System.in).nextLine();
                    newAtt.setIdStudent(s);
                    listAttendant.add(newAtt);
                    break;
                case 5:
                    System.out.print("Input course's id: ");
                    s = new Scanner(System.in).nextLine();
                    for (Attendant att : listAttendant) {
                        if (att.getIdCourse().equals(s))
                            for (Student student : listStudent) {
                                if (att.getIdStudent().equals(student.getId())) {
                                    System.out.println(student.toString());
                                    break;
                                }
                            }
                    }
                    break;
                case 6:
                    System.out.print("Input student's id: ");
                    s = new Scanner(System.in).nextLine();
                    for (Attendant att : listAttendant) {
                        if (att.getIdStudent().equals(s))
                            for (Course cr : listCourse) {
                                if (att.getIdCourse().equals(cr.getId())) {
                                    System.out.print(cr.toString());
                                    for (Teacher teacher : listTeacher) {
                                        if (teacher.getId().equals(cr.getIdTeacher()))
                                            System.out.println(" Teacher: " + teacher.getName());
                                    }
                                    break;
                                }
                            }
                    }
                    break;
                case 7:
                    flag = false;
                    RwStudent.writeStudent(listStudent);
                    RwTeacher.writeTeacher(listTeacher);
                    RwCourse.writeCourse(listCourse);
                    RwAtt.writeAtt(listAttendant);
                default:
                    break;

            }
        }
    }

}