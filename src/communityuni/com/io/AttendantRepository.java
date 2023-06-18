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
            Attendant attendant = Attendant.plainToInstance(line);
            if (attendant != null) {
                attendantList.add(attendant);
            }
        }
        return attendantList;

    }

    @Override
    public ArrayList<String> convertObjectListToLineArray(ArrayList<Attendant> attendantList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Attendant attendant : attendantList) {
            lineArr.add(attendant.toLine());
        }
        return lineArr;
    }

}
