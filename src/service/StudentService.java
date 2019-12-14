package service;

import java.util.HashMap;
import java.util.Map;

import entity.StudentInfo;

public class StudentService{
  // ��ȡ��ǰѧ����Ϣ
  public static String[] currentUserInfo = new String[13];
	
  public StudentService() {
  }
  
  /**
   * ѧ����¼ƥ��
   * */
  public static boolean login(String[] input, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(input[0]) && entry.getValue().getPwd().equals(input[1])) {
		  return true;
	  }
	}
	return false;
  }
  
  /**
   * ��ȡ��ǰѧ��������Ϣ
   * 0 -> id ѧ��
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> sex �Ա�
   * 5 -> graduYear ��ҵ���
   * 6 -> specialty רҵ
   * 7 -> isFinished �Ƿ���ɾ�ҵ�Ǽ�
   * 8 -> employStatus ��ҵȥ������
   * 9 -> company ��˾
   * 10 -> job ְλ
   * 11 -> school ѧУ
   * 12 -> place ��ҵȥ��
   * */
  public static String[] getStudentInfo(String id, HashMap<String, StudentInfo> student) {
	currentUserInfo[0] = id;
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		currentUserInfo[1] = entry.getValue().getName();
		currentUserInfo[2] = entry.getValue().getPwd();
		currentUserInfo[3] = entry.getValue().getPhone();
		currentUserInfo[4] = entry.getValue().getSex();
		currentUserInfo[5] = entry.getValue().getGraduYear();
		currentUserInfo[6] = entry.getValue().getSpecialty();
		currentUserInfo[7] = entry.getValue().getIsFinished();
		currentUserInfo[8] = entry.getValue().getEmployStatus();
		currentUserInfo[9] = entry.getValue().getCompany();
		currentUserInfo[10] = entry.getValue().getJob();
		currentUserInfo[11] = entry.getValue().getSchool();
		currentUserInfo[12] = entry.getValue().getPlace();
	    break;
	  }
	}
	return currentUserInfo;
  }
  
  /**
   * �޸�ѧ������
   * @return boolean
   */
  public static boolean modifyPwd(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setPwd(input); 
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * �޸�ѧ����ϵ��ʽ
   * @return boolean
   */
  public static boolean modifyPhone(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setPhone(input); 
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * �޸�ѧ��������λ��������λ
   * @return boolean
   */
  public static boolean modifyEmployed(String type, String input[], String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setIsFinished();
		entry.getValue().setCompany(input[0]); 
		entry.getValue().setJob(input[1]); 
		entry.getValue().setEmployStatus(type);
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * �޸�ѧ����ҵȥ��
   * @return boolean
   */
  public static boolean modifyPlace(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setIsFinished();
		entry.getValue().setPlace(input); 
		entry.getValue().setEmployStatus("��ҵ");
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * �޸�ѧ���о���¼ȡѧУ
   * @return boolean
   */
  public static boolean modifySchool(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setIsFinished();
		entry.getValue().setSchool(input); 
		entry.getValue().setEmployStatus("�о���");
		return true;
	  } 
	}
	return false;
  }
}
