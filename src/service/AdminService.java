package service;

import java.util.HashMap;
import java.util.Map;

import entity.AdminInfo;
import entity.StudentInfo;

public class AdminService {
  /**
   * 当前管理员账号信息
   * 0 -> id 工号
   * 1 -> name 姓名
   * 2 -> pwd 密码
   * 3 -> phone 联系方式
   * 4 -> dept 部门
   * */
  public static String[] currentUserInfo = new String[7];
  //所查询的学生信息
  public static String[] inquireStuInfo = new String[7];
	
  public AdminService() {
  }
	
  /**
   * 管理员登录匹配
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
   * 获取管理员个人信息
   * 0 -> id 工号
   * 1 -> name 姓名
   * 2 -> pwd 密码
   * 3 -> phone 联系方式
   * 4 -> dept 部门
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
   * 修改管理员密码
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
   * 修改管理员联系方式
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
   * 管理员修改学生专业
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
   * 管理员修改学生毕业年份
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
   * 管理员查询是否有该学生
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
   * 管理员根据学号查询具体学生信息,顺序与查看页表头的顺序一致
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
