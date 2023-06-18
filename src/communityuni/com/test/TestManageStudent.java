package communityuni.com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import communityuni.com.io.*;
import communityuni.com.model.*;

public class TestManageStudent {
    public static void main(String[] args) {

        TeacherRepository teacherRepository = new TeacherRepository();       
        ArrayList<Student> listStudent = RwStudent.readStudent();
        ArrayList<Teacher> listTeacher = teacherRepository.readFile();
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
                        System.out.println(teacher.name + " " + teacher.id);
                    }
                    break;
                case 2: {

                    String courseName = null;
                    String courseId = null;
                    String teacherId = null;

                    System.out.print("Input course's name: ");
                    courseName = new Scanner(System.in).nextLine();
                    System.out.print("Input course's id: ");
                    courseId = new Scanner(System.in).nextLine();
                    System.out.print("Input teacher's id");
                    teacherId = new Scanner(System.in).nextLine();

                    Course course = new Course(courseName, courseId, teacherId);
                    listCourse.add(course);
                    break;
                }
                case 3:
                    ArrayList<Student> lsClone = (ArrayList<Student>) listStudent.clone();
                    Collections.sort(lsClone);
                    for (Student st : lsClone) {
                        System.out.println(st.toString() + " " + st.gpa);
                    }
                    break;
                case 4: {
                    String courseId = null;
                    String studentId = null;

                    System.out.println("Input course's id: ");
                    courseId = new Scanner(System.in).nextLine();
                    System.out.println("Input student's id: ");
                    studentId = new Scanner(System.in).nextLine();

                    Attendant attendant = new Attendant(studentId, courseId);
                    listAttendant.add(attendant);
                    break;
                }
                case 5:
                    String courseId = null;
                    System.out.print("Input course's id: ");
                    courseId = new Scanner(System.in).nextLine();
                    for (Attendant att : listAttendant) {
                        if (att.courseId.equals(courseId))
                            System.out.println(att.getStudentName(listStudent));
                    }
                    break;
                case 6:
                    String studentId = null;
                    System.out.print("Input student's id: ");
                    studentId = new Scanner(System.in).nextLine();
                    for (Attendant att : listAttendant) {
                        if (att.studentId.equals(studentId))
                            for (Course cr : listCourse) {
                                if (att.courseId.equals(cr.id)) {
                                    System.out.print(cr.toString());
                                    System.out.println(
                                            " Teacher: " + cr.getTeacherName(listTeacher));
                                    break;
                                }
                            }
                    }
                    break;
                case 7:
                    flag = false;
                    RwStudent.writeStudent(listStudent);
                    teacherRepository.writeFile(listTeacher);
                    RwCourse.writeCourse(listCourse);
                    RwAtt.writeAtt(listAttendant);
                default:
                    break;

            }
        }
    }

}