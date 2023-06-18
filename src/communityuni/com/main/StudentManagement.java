package communityuni.com.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import communityuni.com.io.*;
import communityuni.com.model.*;
import communityuni.com.utils.Console;

public class StudentManagement {
    static ArrayList<Student> studentList = StudentRepository.getInstance().readFile();
    static ArrayList<Teacher> teacherList = TeacherRepository.getInstance().readFile();
    static ArrayList<Course> courseList = CourseRepository.getInstance().readFile();
    static ArrayList<Attendant> attendantList = AttendantRepository.getInstance().readFile();

    private static final String[] OPTIONS = {
            "1. Show list of teachers",
            "2. Create course and assign teachers to course",
            "3. Show student list and sort by gpa including grade ranking",
            "4. Add student to the course",
            "5. Show the students of a course",
            "6. Show list of a student's courses",
            "7. Show list of good students",
            "8. Save and exit"
    };

    private static void showMenu() {
        for (String option : OPTIONS) {
            Console.show(option);
        }
    }

    private static boolean isTeacherExisted(String teacherId) {
        boolean result = false;
        for (Teacher teacher : teacherList) {
            if (teacher.id.equals(teacherId)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isStudentExisted(String studentId) {
        boolean result = false;
        for (Student student : studentList) {
            if (student.id.equals(studentId)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isCourseExisted(String courseId) {
        boolean result = false;
        for (Course course : courseList) {
            if (course.id.equals(courseId)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static void showTeacherList() {
        for (Teacher teacher : teacherList) {
            Console.show(teacher.name + " " + teacher.id);
        }
    }

    private static void createCourse() {
        String courseName = null;
        String courseId = null;
        String teacherId = null;

        Scanner in = new Scanner(System.in);
        System.out.print("Input course's name: ");
        courseName = in.nextLine();
        System.out.print("Input course's id: ");
        courseId = in.nextLine();
        System.out.print("Input teacher's id: ");
        teacherId = in.nextLine();

        if (!isTeacherExisted(teacherId)) {
            Console.show("teacherId not found: " + teacherId);
            return;
        }

        Course course = new Course(courseName, courseId, teacherId);
        courseList.add(course);

    }

    private static void showStudentList() {
        ArrayList<Student> listClone = new ArrayList<Student>(studentList);
        Collections.sort(listClone);
        for (Student student : listClone) {
            Console.show(student.toString());
        }
    }

    private static void addStudentToCourse() {
        String courseId = null;
        String studentId = null;

        Scanner in = new Scanner(System.in);
        Console.show("Input course's id: ");
        courseId = in.nextLine();
        Console.show("Input student's id: ");
        studentId = in.nextLine();

        if (!isCourseExisted(courseId)) {
            Console.show("courseId not found: " + courseId);
            return;
        }

        if (!isStudentExisted(studentId)) {
            Console.show("studentId not found: " + studentId);
            return;
        }

        Attendant attendant = new Attendant(studentId, courseId);
        attendantList.add(attendant);
    }

    private static void showStudentListOfCourse() {
        String courseId = null;

        System.out.print("Input course's id: ");
        courseId = new Scanner(System.in).nextLine();

        if (!isCourseExisted(courseId)) {
            Console.show("courseId not found: " + courseId);
            return;
        }

        for (Attendant attendant : attendantList) {
            if (attendant.courseId.equals(courseId)) {
                Console.show(attendant.getStudentName(studentList));
            }
        }
    }

    private static void showCourseListOfStudent() {
        String studentId = null;

        System.out.print("Input student's id: ");
        studentId = new Scanner(System.in).nextLine();

        if (!isStudentExisted(studentId)) {
            Console.show("studentId not found: " + studentId);
            return;
        }

        for (Attendant attendant : attendantList) {
            if (attendant.studentId.equals(studentId)) {
                Console.show(attendant.getCourseName(courseList));
            }
        }
    }

    private static void showStudentListByRank(Rank rank){
        for (Student student : studentList) {
            if(student.getRank().equals(rank)){
                Console.show(student.toString());
            }
        }
    }

    private static void saveData() {
        StudentRepository.getInstance().writeFile(studentList);
        TeacherRepository.getInstance().writeFile(teacherList);
        CourseRepository.getInstance().writeFile(courseList);
        AttendantRepository.getInstance().writeFile(attendantList);
    }

    public static void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1: {
                    showTeacherList();
                    break;
                }

                case 2: {
                    createCourse();
                    break;
                }

                case 3: {
                    showStudentList();
                    break;
                }

                case 4: {
                    addStudentToCourse();
                    break;
                }

                case 5: {
                    showStudentListOfCourse();
                    break;
                }

                case 6: {
                    showCourseListOfStudent();
                    break;
                }

                case 7: {
                    showStudentListByRank(Rank.GOOD);
                    break;
                }

                case 8:
                    isRunning = false;
                    saveData();

                default:
                    break;
            }
        }
    }

}