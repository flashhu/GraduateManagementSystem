package service;

import java.util.ArrayList;

import entity.AdminInfo;

public class AdminService {
  /**
   * 0 -> id 工号
   * 1 -> name 姓名
   * 2 -> pwd 密码
   * 3 -> phone 联系方式
   * 4 -> dept 部门
   * */
  private static String[] currentUserInfo = new String[7];
	
  public AdminService() {
  }
	
  /**
   * 管理员登录匹配
   * */
  public static boolean login(String[] input, ArrayList<AdminInfo> admin) {
	for (Object user : admin) {
	  if (((AdminInfo)user).getId().equals(input[0]) && ((AdminInfo)user).getPwd().equals(input[1])) {
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
  public static String[] getAdminInfo(String id, ArrayList<AdminInfo> admin) {
	currentUserInfo[0] = id;
	for (AdminInfo user : admin) {
	  if (user.getId().equals(id)) {
		currentUserInfo[1] = user.getName();
		currentUserInfo[2] = user.getPwd();
		currentUserInfo[3] = user.getPhone();
		currentUserInfo[4] = user.getDept();
		break;
	  }
	}
	return currentUserInfo;
  }

  /**
   * 修改管理员密码
   * @return boolean
   */
  public static boolean modifyPwd(String input, String id, ArrayList<AdminInfo> admin) {
	for (AdminInfo user : admin) {
	  if (user.getId().equals(id)) {
		user.setPwd(input); 
		return true;
	  } 
	}
	return false;
  }
  
  /**
   * 修改管理员联系方式
   * @return boolean
   */
  public static boolean modifyPhone(String input, String id, ArrayList<AdminInfo> admin) {
	for (AdminInfo user : admin) {
	  if (user.getId().equals(id)) {
		user.setPhone(input); 
		return true;
	  } 
	}
	return false;
  }
}
