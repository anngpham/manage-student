package communityuni.com.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class test {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("./src/communityuni/com/dsSv.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            br.close();
            isr.close();
            fis.close();
            System.out.println(line);
        } catch (Exception e) {
                e.printStackTrace();
                System.out.println("fail");
        }
    }
}
