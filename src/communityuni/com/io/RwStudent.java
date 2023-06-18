package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.*;

public class RwStudent {
    public static ArrayList<Student> readStudent() {
        ArrayList<Student> listStudent = new ArrayList<Student>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/listStudent.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                if (arr.length == 3) {
                    String studentName = arr[0];
                    String studentId = arr[1];
                    double studentGpa = Double.parseDouble(arr[2]);
                    Student tmp = new Student(studentName, studentId, studentGpa);
                    listStudent.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudent;
    }

    public static void writeStudent(ArrayList<Student> listStudent) {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/listStudent.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for (Student sv : listStudent) {
                String line = sv.name + ";" + sv.id + ";" + Double.toString(sv.gpa);
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
