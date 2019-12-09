package ui;

import java.util.Scanner;
import service.StudentService;

import util.Init;

public class StudentUI {
  //数据初始化
  static Init init = new Init();
  static StudentService studentService = new StudentService();
	  
  private static Scanner input = new Scanner(System.in);
  //登录时使用的账户密码
  private static String[] inputInfo = new String[2];
  //修改时输入的新旧信息
  private static String[] modifyInfo = new String[2];

  /**
   * 学生登录界面
   * */
  public static void loginPage() {
	System.out.println("\n\n");
	System.out.println(">学生登录");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入学号：（输入exit返回主页）");
	  inputInfo[0] = input.next();
	  if(MainPageUI.isExit(inputInfo[0])) {
	    return;
	  }
	  System.out.println("请输入密码：");
	  inputInfo[1] = input.next();
	  if (StudentService.login(inputInfo, StudentUI.init.stuList)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println(" 登录成功！");
		StudentUI.mainPage();
		break;
	  }
	  System.out.println("输入有误！\n\n");
    }
  }
  
  /**
   * 学生端主页
   * */
  public static void mainPage() {
	System.out.println("\n\n");
	System.out.println(">学生主页");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.就业去向");
	System.out.println("2.个人信息");
	System.out.println("（输入exit退出登录）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      StudentUI.infoRegisterPage();;
	      isInputRight = 1;
	      break;
	    case "2":
		  StudentUI.personalInfoPage();;
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
   * 学生端就业登记页
   * */
  public static void infoRegisterPage() {
	System.out.println("\n\n");
	System.out.println(">学生主页>就业去向");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
  }
  
  /**
   * 学生端个人信息页
   * */
  public static void personalInfoPage() {
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.查看");
	System.out.println("2.修改");
	System.out.println("（输入exit返回学生主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      StudentUI.infoInquirePage();
	      isInputRight = 1;
	      break;
	    case "2":
		  StudentUI.infoModifyPage();;
		  isInputRight = 1;
		  break;
	    case "exit":
	      System.out.println("\n");
		  StudentUI.mainPage();;
		  isInputRight = 1;
		  break;
	    default:
		  System.out.println("输入有误！\n\n");
	  }
	}
  }
  
  /**
   * 学生端查看个人信息页
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuList);
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>查看");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("学号\t\t" + currentUserInfo[0]);
	System.out.println("姓名\t\t" + currentUserInfo[1]);
	System.out.println("密码\t\t" + currentUserInfo[2]);
	System.out.println("性别\t\t" + currentUserInfo[4]);
	System.out.println("专业\t\t" + currentUserInfo[6]);
	System.out.println("毕业年份\t\t" + currentUserInfo[5]);
	System.out.println("联系方式\t\t" + currentUserInfo[3]);
	System.out.println("（输入exit返回个人信息页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	while(true) {
	  System.out.print("请输入：");
	  if(input.next().equals("exit")) {
	    StudentUI.personalInfoPage();
		break;
	  }else {
		System.out.println("输入有误! \n\n");
	  }
	}
  }
  
  /**
   * 学生端修改个人信息页
   * */
  public static void infoModifyPage() {
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>修改");
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
	      StudentUI.pwdModify();
	      isInputRight = 1;
	      break;
	    case "2":
		  StudentUI.phoneModify();;
		  isInputRight = 1;
		  break;
	    case "exit":
		  StudentUI.personalInfoPage();;
		  isInputRight = 1;
		  break;
	    default:
		  System.out.println("输入有误！\n\n");
	  }
	}
  }
  
  /**
   * 学生端修改密码页
   * */
  public static void pwdModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuList);
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>修改>密码");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入原有密码：（输入exit返回修改页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		StudentUI.infoModifyPage();;
		return;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("请输入新密码：");
		modifyInfo[1] = input.next();
		if (StudentService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.stuList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改密码成功！新密码为" + modifyInfo[1]);
	      StudentUI.infoModifyPage();
		  break;
		}
	  }else {
		System.out.println("输入有误！\n\n");
	  }
    }
  }
  
  /**
   * 学生端修改联系方式页
   * */
  public static void phoneModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuList);
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>修改>联系方式");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入新联系方式：（输入exit返回修改页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		StudentUI.infoModifyPage();
		return;  
	  }else if (StudentService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.stuList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改联系方式成功！新联系方式为" + modifyInfo[0]);
	      StudentUI.infoModifyPage();
		  break;
	  }else {
		System.out.println("输入有误！\n\n");
	  }
    }
  }
}
