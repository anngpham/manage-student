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
            Student student = Student.plainToInstance(line);
            if(student != null){
                studentList.add(student);
            }
        }
        return studentList;

    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Student> studentList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Student student : studentList) {
            lineArr.add(student.toLine());
        }
        return lineArr;
    }

}
