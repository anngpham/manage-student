package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.*;

public class FileHandler {
    private static final String FILE_PATH = "./src/communityuni/com/file/teacherList.txt";

    private static ArrayList<Teacher> convertLineArrayToTeacherList(ArrayList<String> lineArr) {
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

    private static ArrayList<String> convertTeacherListToLineArray(ArrayList<Teacher> teacherList) {
        ArrayList<String> lineArr = new ArrayList<String>();
        for (Teacher teacher : teacherList) {
            String line = teacher.name + ";" + teacher.id;
            lineArr.add(line);
        }
        return lineArr;
    }

    public static ArrayList<Teacher> readFile() {
        ArrayList<String> lineArr = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            while (line != null) {
                lineArr.add(line);
                line = br.readLine();
            }

            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Teacher> result = FileHandler.convertLineArrayToTeacherList(lineArr);
        return result;
    }

    public static void writeFile(ArrayList<Teacher> teacherList) {
        ArrayList<String> lineArr = FileHandler.convertTeacherListToLineArray(teacherList);

        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            for (String line : lineArr) {
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
