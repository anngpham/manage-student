package communityuni.com.io;

import java.util.ArrayList;
import communityuni.com.model.*;

public class StudentRepository extends FileHandler<Student> {
    private static StudentRepository uniqueInstance = null;

    private StudentRepository() {
    }

    public static StudentRepository getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new StudentRepository();
        }
        return uniqueInstance;
    }

    @Override
    protected String getFilePath() {
        return "./src/communityuni/com/file/studentList.txt";
    }

    @Override
    public ArrayList<Student> convertLineArrayToObjectList(ArrayList<String> lineArr) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        for (String line : lineArr) {
            String[] arr = line.split(";");
            if (arr.length == 3) {
                String studentName = arr[0];
                String studentId = arr[1];
                double studentGpa = Double.parseDouble(arr[2]);
                Student student = new Student(studentName, studentId, studentGpa);
                studentList.add(student);
            }
        }
        return studentList;

    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Student> studentList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Student student : studentList) {
            String line = student.name + ";" + student.id + ";" + Double.toString(student.gpa);
            lineArr.add(line);
        }
        return lineArr;
    }

}
