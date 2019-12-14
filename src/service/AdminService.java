package service;

import java.util.HashMap;
import java.util.Map;

import entity.AdminInfo;
import entity.StudentInfo;

public class AdminService {
  /**
   * ��ǰ����Ա�˺���Ϣ
   * 0 -> id ����
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> dept ����
   * */
  public static String[] currentUserInfo = new String[7];
  //����ѯ��ѧ����Ϣ
  public static String[] inquireStuInfo = new String[7];
	
  public AdminService() {
  }
	
  /**
   * ����Ա��¼ƥ��
   * */
  public static boolean login(String[] input, HashMap<String, AdminInfo> admin) {
	for (Map.Entry<String, AdminInfo> entry : admin.entrySet()) {
	  if (entry.getKey().equals(input[0]) && entry.getValue().getPwd().equals(input[1])) {
		  return true;
	  }	  
	}
	return false;
  }
  
  /**
   * ��ȡ����Ա������Ϣ
   * 0 -> id ����
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> dept ����
   * */
  public static String[] getAdminInfo(String id, HashMap<String, AdminInfo> admin) {
	currentUserInfo[0] = id;
	for (Map.Entry<String, AdminInfo> entry : admin.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		currentUserInfo[1] = entry.getValue().getName();
		currentUserInfo[2] = entry.getValue().getPwd();
		currentUserInfo[3] = entry.getValue().getPhone();
		currentUserInfo[4] = entry.getValue().getDept();
		break;
	  }
	}
	return currentUserInfo;
  }

  /**
   * �޸Ĺ���Ա����
   * @return boolean
   */
  public static boolean modifyPwd(String input, String id, HashMap<String, AdminInfo> admin) {
	for (Map.Entry<String, AdminInfo> entry : admin.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setPwd(input); 
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * �޸Ĺ���Ա��ϵ��ʽ
   * @return boolean
   */
  public static boolean modifyPhone(String input, String id, HashMap<String, AdminInfo> admin) {
	for (Map.Entry<String, AdminInfo> entry : admin.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setPhone(input); 
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * ����Ա�޸�ѧ��רҵ
   * @return boolean
   */
  public static boolean modifySpecialty(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setSpecialty(input);
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * ����Ա�޸�ѧ����ҵ���
   * @return boolean
   */
  public static boolean modifyGradYear(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setGraduYear(input);
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * ����Ա��ѯ�Ƿ��и�ѧ��
   * */
  public static boolean isInStuList(String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * ����Ա����ѧ�Ų�ѯ����ѧ����Ϣ,˳����鿴ҳ��ͷ��˳��һ��
   * */
  public static String[] inquireInfo(String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		inquireStuInfo[0] = entry.getValue().getId();
		inquireStuInfo[1] = entry.getValue().getName();
		inquireStuInfo[2] = entry.getValue().getSex();
		inquireStuInfo[3] = entry.getValue().getSpecialty();
		inquireStuInfo[4] = entry.getValue().getGraduYear();
		inquireStuInfo[5] = entry.getValue().getPhone();
		inquireStuInfo[6] = entry.getValue().getEmployStatus();
	  } 
	}
	return inquireStuInfo;
  }
}
