package communityuni.com.io;

import java.util.ArrayList;
import communityuni.com.model.*;

public class TeacherRepository extends FileHandler<Teacher> {
    private static TeacherRepository uniqueInstance = null;

    private TeacherRepository() {
    }

    public static TeacherRepository getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new TeacherRepository();
        }
        return uniqueInstance;
    }

    @Override
    protected String getFilePath() {
        return "./src/communityuni/com/file/teacherList.txt";
    }

    @Override
    public ArrayList<Teacher> convertLineArrayToObjectList(ArrayList<String> lineArr) {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        for (String line : lineArr) {
            Teacher teacher = Teacher.plainToInstance(line);
            if (teacher != null) {
                teacherList.add(teacher);
            }
        }
        return teacherList;
    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Teacher> teacherList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Teacher teacher : teacherList) {
            lineArr.add(teacher.toLine());
        }
        return lineArr;
    }

}
