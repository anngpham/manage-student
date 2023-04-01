package communityuni.com.io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.*;
public class rwAtt {
    public static ArrayList<attendant> readAtt()
    {
        ArrayList<attendant> dsAtt = new ArrayList<attendant>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/dsAtt.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null)
            {
                String [] arr = line.split(";");
                if(arr.length == 2)
                {
                    attendant tmp = new attendant() ;
                    tmp.setIdMh(arr[0]);
                    tmp.setIdSv(arr[1]);
                    dsAtt.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
			isr.close();
			fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsAtt;
    }
    public static void writeAtt(ArrayList<attendant> dsAtt)
    {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/dsAtt.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for(attendant attendant : dsAtt)
            {
                String line = attendant.getIdMh() + ";" + attendant.getIdSv();
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
