package communityuni.com.io;

import java.util.ArrayList;
import communityuni.com.model.*;

public class TeacherRepository extends FileHandler<Teacher> {

    @Override
    protected String getFilePath() {
        return "./src/communityuni/com/file/teacherList.txt";
    }

    @Override
    public ArrayList<Teacher> convertLineArrayToObjectList(ArrayList<String> lineArr) {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        for (String line : lineArr) {
            String[] arr = line.split(";");
            if (arr.length == 2) {
                String teacherId = arr[0];
                String teacherName = arr[1];
                Teacher teacher = new Teacher(teacherName, teacherId);
                teacherList.add(teacher);
            }
        }
        return teacherList;
    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Teacher> teacherList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Teacher teacher : teacherList) {
            String line = teacher.name + ";" + teacher.id;
            lineArr.add(line);
        }
        return lineArr;
    }

}
