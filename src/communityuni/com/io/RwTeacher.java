package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.*;

public class RwTeacher {
    public static ArrayList<Teacher> readTeacher() {
        ArrayList<Teacher> listTeacher = new ArrayList<Teacher>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/listTeacher.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 2) {
                    Teacher tmp = new Teacher(arr[0], arr[1]);
                    listTeacher.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return listTeacher;
    }

    public static void writeTeacher(ArrayList<Teacher> listTeacher) {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/listTeacher.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Teacher gv : listTeacher) {
                String line = gv.name + ";" + gv.id;
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
