package service;

import java.util.ArrayList;

import entity.AdminInfo;

public class AdminService {
  /**
   * 0 -> id ����
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> dept ����
   * */
  private static String[] currentUserInfo = new String[7];
	
  public AdminService() {
  }
	
  /**
   * ����Ա��¼ƥ��
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
   * ��ȡ����Ա������Ϣ
   * 0 -> id ����
   * 1 -> name ����
   * 2 -> pwd ����
   * 3 -> phone ��ϵ��ʽ
   * 4 -> dept ����
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
   * �޸Ĺ���Ա����
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
   * �޸Ĺ���Ա��ϵ��ʽ
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
