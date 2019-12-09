package util;

import java.util.ArrayList;

import entity.AdminInfo;
import entity.StudentInfo;

/**
 * ���ݳ�ʼ��
 * */
public class Init {
  public ArrayList<StudentInfo> stuList = new ArrayList<StudentInfo>();
  public ArrayList<AdminInfo> adminList = new ArrayList<AdminInfo>();
  
  public Init() {
	studentInit();
	adminInit();  
  }
  
  public void studentInit() {
	stuList.add(new StudentInfo("201800", "����", "00", "12345678900", "��", "2022", "�����"));
	stuList.add(new StudentInfo("201801", "����", "01", "12345678000", "Ů", "2022", "�����"));
	stuList.add(new StudentInfo("201802", "����", "02", "12345670900", "��", "2022", "�����"));
	stuList.add(new StudentInfo("201803", "��÷", "03", "12345608900", "Ů", "2022", "�����"));
  }
		
  public void adminInit() {
	adminList.add(new AdminInfo("001", "admin", "1", "12345678900", "����"));
  }
  
}
