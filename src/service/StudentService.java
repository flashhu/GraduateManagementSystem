package service;

import java.util.HashMap;
import java.util.Map;

import entity.StudentInfo;

public class StudentService{
  // 获取当前学生信息
  public static String[] currentUserInfo = new String[13];
	
  public StudentService() {
  }
  
  /**
   * 学生登录匹配
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
   * 获取当前学生个人信息
   * 0 -> id 学号
   * 1 -> name 姓名
   * 2 -> pwd 密码
   * 3 -> phone 联系方式
   * 4 -> sex 性别
   * 5 -> graduYear 毕业年份
   * 6 -> specialty 专业
   * 7 -> isFinished 是否完成就业登记
   * 8 -> employStatus 就业去向类型
   * 9 -> company 公司
   * 10 -> job 职位
   * 11 -> school 学校
   * 12 -> place 待业去处
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
   * 修改学生密码
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
   * 修改学生联系方式
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
   * 修改学生工作单位，工作岗位
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
   * 修改学生待业去处
   * @return boolean
   */
  public static boolean modifyPlace(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setIsFinished();
		entry.getValue().setPlace(input); 
		entry.getValue().setEmployStatus("待业");
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * 修改学生研究生录取学校
   * @return boolean
   */
  public static boolean modifySchool(String input, String id, HashMap<String, StudentInfo> student) {
	for (Map.Entry<String, StudentInfo> entry : student.entrySet()) {
	  if (entry.getValue().getId().equals(id)) {
		entry.getValue().setIsFinished();
		entry.getValue().setSchool(input); 
		entry.getValue().setEmployStatus("研究生");
		return true;
	  } 
	}
	return false;
  }
}
