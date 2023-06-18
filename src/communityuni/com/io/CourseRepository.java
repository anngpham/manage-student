package communityuni.com.io;

import java.util.ArrayList;
import communityuni.com.model.*;

public class CourseRepository extends FileHandler<Course> {
    private static CourseRepository uniqueInstance = null;

    private CourseRepository() {
    }

    public static CourseRepository getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CourseRepository();
        }
        return uniqueInstance;
    }

    @Override
    protected String getFilePath() {
        return "./src/communityuni/com/file/courseList.txt";
    }

    @Override
    public ArrayList<Course> convertLineArrayToObjectList(ArrayList<String> lineArr) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        for (String line : lineArr) {
            String[] arr = line.split(";");
            if (arr.length == 3) {
                String courseName = arr[0];
                String courseId = arr[1];
                String teacherId = arr[2];
                Course course = new Course(courseName, courseId, teacherId);
                courseList.add(course);
            }
        }
        return courseList;
    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Course> courseList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Course course : courseList) {
            String line = course.name + ";" + course.id + ";" + course.teacherId;
            lineArr.add(line);
        }
        return lineArr;
    }

}