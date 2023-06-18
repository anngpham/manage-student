package communityuni.com.io;

import java.util.ArrayList;
import communityuni.com.model.*;

public class AttendantRepository extends FileHandler<Attendant> {
    private static AttendantRepository uniqueInstance = null;

    private AttendantRepository() {
    }

    public static AttendantRepository getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new AttendantRepository();
        }
        return uniqueInstance;
    }

    @Override
    protected String getFilePath() {
        return "./src/communityuni/com/file/attendantList.txt";
    }

    @Override
    public ArrayList<Attendant> convertLineArrayToObjectList(ArrayList<String> lineArr) {
        ArrayList<Attendant> attendantList = new ArrayList<Attendant>();
        for (String line : lineArr) {
            String[] arr = line.split(";");
            if (arr.length == 2) {
                String studentId = arr[0];
                String courseId = arr[1];
                Attendant attendant = new Attendant(studentId, courseId);
                attendantList.add(attendant);
            }
        }
        return attendantList;

    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Attendant> attendantList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Attendant attendant : attendantList) {
            String line = attendant.courseId + ";" + attendant.studentId;
            lineArr.add(line);
        }
        return lineArr;
    }

}
