package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public abstract class FileHandler<T> {

    protected abstract String getFilePath();

    protected abstract ArrayList<T> convertLineArrayToObjectList(ArrayList<String> lineArr);

    protected abstract ArrayList<String> convertObjectListToLineArray(ArrayList<T> teacherList);

    public ArrayList<T> readFile() {
        ArrayList<String> lineArr = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(this.getFilePath());
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

        ArrayList<T> result = this.convertLineArrayToObjectList(lineArr);
        return result;
    }

    public void writeFile(ArrayList<T> teacherList) {
        ArrayList<String> lineArr = this.convertObjectListToLineArray(teacherList);

        try {
            FileOutputStream fos = new FileOutputStream(this.getFilePath());
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
