package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.mh;

public class rwMh {
    public static ArrayList<mh> readMh()
    {
        ArrayList<mh> dsMh = new ArrayList<mh>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/dsMh.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null)
            {
                String [] arr = line.split(";");
                if(arr.length == 3)
                {
                    mh tmp = new mh() ;
                    tmp.setName(arr[0]);
                    tmp.setId(arr[1]);
                    tmp.setIdGv(arr[2]);
                    dsMh.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
			isr.close();
			fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsMh;
    }
    public static void writeMh(ArrayList<mh> dsMh)
    {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/dsMh.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for(mh mh : dsMh)
            {
                String line = mh.getName() + ";" + mh.getId()+ ";" + mh.getIdGv();
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
