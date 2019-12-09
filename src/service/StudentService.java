package service;

import java.util.ArrayList;

import entity.StudentInfo;

public class StudentService{
  /**
   * 0 -> id ѧ��
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> sex �Ա�
   * 5 -> graduYear ��ҵ���
   * 6 -> specialty רҵ
   * */
  private static String[] currentUserInfo = new String[7];
	
  public StudentService() {
  }
  
  /**
   * ѧ����¼ƥ��
   * */
  public static boolean login(String[] input, ArrayList<StudentInfo> student) {
	for (StudentInfo user : student) {
	  if (user.getId().equals(input[0]) && ((StudentInfo)user).getPwd().equals(input[1])) {
		  return true;
	  }
	}
	return false;
  }
  
  /**
   * ��ȡѧ��������Ϣ
   * 0 -> id ѧ��
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> sex �Ա�
   * 5 -> graduYear ��ҵ���
   * 6 -> specialty רҵ
   * */
  public static String[] getStudentInfo(String id, ArrayList<StudentInfo> student) {
	currentUserInfo[0] = id;
	for (StudentInfo user : student) {
	  if (user.getId().equals(id)) {
		currentUserInfo[1] = user.getName();
		currentUserInfo[2] = user.getPwd();
		currentUserInfo[3] = user.getPhone();
		currentUserInfo[4] = user.getSex();
		currentUserInfo[5] = user.getGraduYear();
		currentUserInfo[6] = user.getSpecialty();
	    break;
	  }
	}
	return currentUserInfo;
  }
  
  /**
   * �޸�ѧ������
   * @return boolean
   */
  public static boolean modifyPwd(String input, String id, ArrayList<StudentInfo> student) {
	for (StudentInfo user : student) {
	  if (user.getId().equals(id)) {
		user.setPwd(input); 
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * �޸�ѧ����ϵ��ʽ
   * @return boolean
   */
  public static boolean modifyPhone(String input, String id, ArrayList<StudentInfo> student) {
	for (StudentInfo user : student) {
	  if (user.getId().equals(id)) {
		user.setPhone(input); 
		return true;
	  } 
	}
	return false;
  }
}
