package communityuni.com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import communityuni.com.io.*;
import communityuni.com.model.*;

public class testSv {
    public static void main(String[] args) {
        ArrayList<sv> dsSv = rwSv.readSv();
        ArrayList<gv> dsGv = rwGv.readGv();
        ArrayList<mh> dsMh = rwMh.readMh();
        ArrayList<attendant> dsAtt = rwAtt.readAtt();
        boolean flag = true;
        while (flag) {
            System.out.println("1. hiển thị ds gv");
            System.out.println("2. tạo môn học và gắn gv cho môn học");
            System.out.println("3. hiển thị ds sv và sắp xếp theo điểm tb bao gồm cả xếp loại");
            System.out.println("4. thêm 1 sv vào môn học");
            System.out.println("5. in ra các sv của 1 môn học");
            System.out.println("6. in ra ds môn học của 1 sv bao gồm tên của gv dạy môn đó");
            System.out.println("7. lưu dữ liệu mới vào file và thoát ctr");
            int n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1: // 1. hiển thị ds gv
                    for (gv gv : dsGv) {
                        System.out.println(gv.getName() + " " + gv.getId());
                    }
                    break;
                case 2:
                    mh newMh = new mh();
                    System.out.print("Nhập tên môn: ");
                    String s = new Scanner(System.in).nextLine();
                    newMh.setName(s);
                    System.out.print("Nhập mã môn: ");
                    s = new Scanner(System.in).nextLine();
                    newMh.setId(s);
                    System.out.print("Nhập id giáo viên");
                    s = new Scanner(System.in).nextLine();
                    newMh.setIdGv(s);
                    dsMh.add(newMh);
                    break;
                case 3:
                    ArrayList<sv> dsClone = (ArrayList<sv>) dsSv.clone();
                    Collections.sort(dsClone);
                    for (sv sv : dsClone) {
                        System.out.println(sv.toString() + " " + sv.getXepLoai());
                    }
                    break;
                case 4:
                    attendant newAtt = new attendant();
                    System.out.println("Nhap ma mon hoc: ");
                    s = new Scanner(System.in).nextLine();
                    newAtt.setIdMh(s);
                    System.out.println("Nhap id sv: ");
                    s = new Scanner(System.in).nextLine();
                    newAtt.setIdSv(s);
                    dsAtt.add(newAtt);
                    break;
                case 5:
                    System.out.print("Nhap ma mon hoc: ");
                    s = new Scanner(System.in).nextLine();
                    for (attendant att : dsAtt) {
                        if (att.getIdMh().equals(s))
                            for (sv sv : dsSv) {
                                if (att.getIdSv().equals(sv.getId())) {
                                    System.out.println(sv.toString());
                                    break;
                                }
                            }
                    }
                    break;
                case 6:
                    System.out.print("Nhap id sv: ");
                    s = new Scanner(System.in).nextLine();
                    for (attendant att : dsAtt) {
                        if (att.getIdSv().equals(s))
                            for (mh mh : dsMh) {
                                if (att.getIdMh().equals(mh.getId())) {
                                    System.out.print(mh.toString());
                                    for (gv gv : dsGv) {
                                        if (gv.getId().equals(mh.getIdGv()))
                                            System.out.println(" Giao Vien: " + gv.getName());
                                    }
                                    break;
                                }
                            }
                    }
                    break;
                case 7:
                    flag = false;
                    rwSv.writeSv(dsSv);
                    rwGv.writeGv(dsGv);
                    rwMh.writeMh(dsMh);
                    rwAtt.writeAtt(dsAtt);
                default:
                    break;

            }
        }
    }

}