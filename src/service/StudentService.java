package service;

import java.util.ArrayList;

import entity.StudentInfo;

public class StudentService{
  /**
   * 0 -> id 学号
   * 1 -> name 姓名
   * 2 -> pwd 密码
   * 3 -> phone 联系方式
   * 4 -> sex 性别
   * 5 -> graduYear 毕业年份
   * 6 -> specialty 专业
   * */
  private static String[] currentUserInfo = new String[7];
	
  public StudentService() {
  }
  
  /**
   * 学生登录匹配
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
   * 获取学生个人信息
   * 0 -> id 学号
   * 1 -> name 姓名
   * 2 -> pwd 密码
   * 3 -> phone 联系方式
   * 4 -> sex 性别
   * 5 -> graduYear 毕业年份
   * 6 -> specialty 专业
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
   * 修改学生密码
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
   * 修改学生联系方式
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
