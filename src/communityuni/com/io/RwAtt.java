package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.*;

public class RwAtt {
    public static ArrayList<Attendant> readAtt() {
        ArrayList<Attendant> listAttendant = new ArrayList<Attendant>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/listAttendant.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 2) {
                    String studentId = arr[0];
                    String courseId = arr[1];
                    Attendant tmp = new Attendant(studentId, courseId);
                    listAttendant.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAttendant;
    }

    public static void writeAtt(ArrayList<Attendant> listAttendant) {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/listAttendant.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Attendant attendant : listAttendant) {
                String line = attendant.courseId + ";" + attendant.studentId;
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
