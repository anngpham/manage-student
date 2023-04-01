package communityuni.com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import communityuni.com.model.sv;

public class rwSv {
    public static ArrayList<sv> readSv()
    {
        ArrayList<sv> dsSv = new ArrayList<sv>();
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/file/dsSv.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null)
            {
                String [] arr = line.split(";");
                if(arr.length == 3)
                {
                    sv tmp = new sv() ;
                    tmp.setName(arr[0]);
                    tmp.setId(arr[1]);
                    tmp.setDtb(Double.parseDouble(arr[2]));
                    dsSv.add(tmp);
                }
                line = br.readLine();
            }
            br.close();
			isr.close();
			fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSv;
    }
    public static void writeSv(ArrayList<sv> dsSv)
    {
        try {
            FileOutputStream fos = new FileOutputStream("./src/communityuni/com/file/dsSv.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            for(sv sv : dsSv)
            {
                String line = sv.getName() + ";" + sv.getId()+ ";" + Double.toString(sv.getDtb());
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
