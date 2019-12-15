package util;

import java.util.HashMap;

import entity.AdminInfo;
import entity.StudentInfo;

/**
 * ���ݳ�ʼ��
 * */
public class Init {
  public HashMap<String, StudentInfo> stuMap = new HashMap<String, StudentInfo>();
  public HashMap<String, AdminInfo> adminMap = new HashMap<String, AdminInfo>();
  
  public Init() {
	studentInit();
	adminInit();  
  }
  
  public void studentInit() {
	stuMap.put("201800", new StudentInfo("201800", "����", "00", "13174569635", "��", "2022", "�����"));
	stuMap.put("201801", new StudentInfo("201801", "����", "01", "13965237458", "Ů", "2022", "�����"));
	stuMap.put("201802", new StudentInfo("201802", "����", "02", "18874123658", "��", "2022", "������"));
	stuMap.put("201803", new StudentInfo("201803", "��÷", "03", "19745623581", "Ů", "2022", "�����", "�о���", "�㽭��ѧ"));
	stuMap.put("201804", new StudentInfo("201804", "����", "04", "13385267431", "��", "2022", "�����", "��ҵ", "�Ϻ�"));
	stuMap.put("201805", new StudentInfo("201805", "����", "05", "13574982561", "Ů", "2022", "�������", "��ҵ", "����", "�����ܼ�"));
	stuMap.put("201806", new StudentInfo("201806", "���", "06", "13159248637", "��", "2022", "������", "��ְ", "����", "ǰ��"));
	stuMap.put("201807", new StudentInfo("201807", "����", "07", "16625413698", "Ů", "2022", "�������", "�о���", "�廪��ѧ"));
  }
		
  public void adminInit() {
	adminMap.put("001", new AdminInfo("001", "admin", "1", "13874526123", "����"));
	adminMap.put("002", new AdminInfo("002", "admin", "2", "13425648379", "ѧ����"));
  }
  
}
