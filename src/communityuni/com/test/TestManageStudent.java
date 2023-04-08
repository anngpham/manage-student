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
            System.out.println(
                    "6. Show list of a student's courses including the name of the teacher who teaches that course");
            System.out.println("7. Save and exit");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    for (Teacher teacher : listTeacher) {
                        System.out.println(teacher.getName() + " " + teacher.getId());
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
                    for (Student st : lsClone) {
                        System.out.println(st.toString() + " " + st.getGpa());
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
                            System.out.println(att.getStudentNameById(att.getIdStudent(), listStudent));
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
                                    System.out.println(
                                            " Teacher: " + cr.getTeacherNameById(cr.getIdTeacher(), listTeacher));
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