package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.gv;

public class rwGv {
    public static ArrayList<gv> readGv()
    {
        ArrayList<gv> dsGv = new ArrayList<gv>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/dsGv.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null)
            {
                String [] arr = line.split(";");
                if(arr.length == 2)
                {
                    gv tmp = new gv() ;
                    tmp.setName(arr[0]);
                    tmp.setId(arr[1]);
                    dsGv.add(tmp);
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
        return dsGv;
    }
    public static void writeGv(ArrayList<gv> dsGv)
    {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/dsGv.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for(gv gv : dsGv)
            {
                String line = gv.getName() + ";" + gv.getId();
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
