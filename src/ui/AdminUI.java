package ui;

import java.util.Scanner;

import service.AdminService;
import util.Init;

public class AdminUI {
  //数据初始化
  static Init init = new Init();
  static AdminService adminService = new AdminService();
  
  private static Scanner input = new Scanner(System.in);
  //登录时使用的账户密码
  private static String[] inputInfo = new String[2];
  //修改时输入的新旧信息
  private static String[] modifyInfo = new String[2];
  
  /**
   * 管理端登录界面
   * */
  public static void loginPage() {
	System.out.println("\n\n");
	System.out.println(">管理员登录");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入工号：（输入exit返回主页）");
	  inputInfo[0] = input.next();
	  if(MainPageUI.isExit(inputInfo[0])) 
	   break;
	  System.out.println("请输入密码：");
	  inputInfo[1] = input.next();
	  if (AdminService.login(inputInfo, AdminUI.init.adminList)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println(" 登录成功！");
		AdminUI.mainPage();
		break;
	  }
	  System.out.println("输入有误！\n\n");
    }
  }
  
  
  /**
   * 管理端主页
   * */
  public static void mainPage() {
	System.out.println("\n\n");
	System.out.println(">管理员主页");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.信息管理");
	System.out.println("2.信息汇总");
	System.out.println("3.个人信息");
	System.out.println("（输入exit退出登录）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      AdminUI.infoManagePage();
	      isInputRight = 1;
	      break;
	    case "2":
		  AdminUI.infoCollectPage();
		  isInputRight = 1;
		  break;
	    case "3":
		  AdminUI.personalInfoPage();
		  isInputRight = 1;
		  break;
	    case "exit":
	      System.out.println("\n");
		  MainPageUI.welcome();
		  isInputRight = 1;
		  break;
	    default:
		  System.out.println("输入有误！\n\n");
	  }
	}
  }
  
  
  /**
   * 管理端信息管理页
   * */
  public static void infoManagePage() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理");
	System.out.println("=======================================================");
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
  }
  
  /**
   * 管理端信息汇总页
   * */
  public static void infoCollectPage() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息汇总");
	System.out.println("=======================================================");
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
  }
  
  /**
   * 管理端个人信息页
   * */
  public static void personalInfoPage() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息");
	System.out.println("=======================================================");
	System.out.println("");  
	System.out.println("1.查看");
	System.out.println("2.修改");
	System.out.println("（输入exit返回管理员主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      AdminUI.infoInquirePage();;
	      isInputRight = 1;
	      break;
	    case "2":
		  AdminUI.infoModifyPage();;
		  isInputRight = 1;
		  break;
	    case "exit":
	      System.out.println("\n");
		  AdminUI.mainPage();;
		  isInputRight = 1;
		  break;
	    default:
		  System.out.println("输入有误！\n\n");
	  }
	}
  }
  
  /**
   * 管理员查看个人信息页
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminList);
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>查看");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("工号\t\t" + currentUserInfo[0]);
	System.out.println("姓名\t\t" + currentUserInfo[1]);
	System.out.println("密码\t\t" + currentUserInfo[2]);
	System.out.println("部门\t\t" + currentUserInfo[4]);
	System.out.println("联系方式\t\t" + currentUserInfo[3]);
	System.out.println("（输入exit返回个人信息页）");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	while(true) {
	  System.out.print("请输入：");
	  if(input.next().equals("exit")) {
	    AdminUI.personalInfoPage();
		break;
	  }else {
		System.out.println("输入有误! \n\n");
	  }
	}
  }
  
  /**
   * 管理员修改个人信息页
   * */
  public static void infoModifyPage() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>修改");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("1.密码");
	System.out.println("2.联系方式");
	System.out.println("（输入exit返回个人信息页）");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");  
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      AdminUI.pwdModify();
	      isInputRight = 1;
	      break;
	    case "2":
		  AdminUI.phoneModify();;
		  isInputRight = 1;
		  break;
	    case "exit":
		  AdminUI.personalInfoPage();;
		  isInputRight = 1;
		  break;
	    default:
		  System.out.println("输入有误！\n\n");
	  }
	}
  }
  
  /**
   * 管理员修改密码页
   * */
  public static void pwdModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminList);
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>修改>密码");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入原有密码：（输入exit返回修改页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		AdminUI.infoModifyPage();;
		break;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("请输入新密码：");
		modifyInfo[1] = input.next();
		if (AdminService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.adminList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改密码成功！新密码为" + modifyInfo[1]);
	      AdminUI.infoModifyPage();
		  break;
		}
	  }else {
		System.out.println("输入有误！\n\n");
	  }
    }
  }
  
  /**
   * 管理员修改联系方式页
   * */
  public static void phoneModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminList);
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>修改>联系方式");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入新联系方式：（输入exit返回修改页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		AdminUI.infoModifyPage();
		break;  
	  }else if (AdminService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.adminList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改联系方式成功！新联系方式为" + modifyInfo[0]);
	      AdminUI.infoModifyPage();
		  break;
	  }else {
		System.out.println("输入有误！\n\n");
	  }
    }
  }
}

