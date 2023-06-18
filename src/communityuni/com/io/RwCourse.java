package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.*;

public class RwCourse {
    public static ArrayList<Course> readCourse() {
        ArrayList<Course> listCourse = new ArrayList<Course>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/listCourse.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 3) {
                    String courseName = arr[0];
                    String courseId = arr[1];
                    String teacherId = arr[2];
                    Course tmp = new Course(courseName, courseId, teacherId);
                    listCourse.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCourse;
    }

    public static void writeCourse(ArrayList<Course> listCourse) {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/listCourse.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Course mh : listCourse) {
                String line = mh.name + ";" + mh.id + ";" + mh.teacherId;
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
