package ui;

import java.util.Scanner;

import service.BaseService;
import service.StudentService;

import util.Init;

public class StudentUI {
  //数据初始化
  public static Init init = new Init();
  static StudentService studentService = new StudentService();
	  
  private static Scanner input = new Scanner(System.in);
  //登录时使用的账户密码
  private static String[] inputInfo = new String[2];
  //修改时输入的新旧信息
  private static String[] modifyInfo = new String[2];
  //就业登记时输入信息
  private static String[] registerInfo = new String[2];

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
	  if (StudentService.login(inputInfo, StudentUI.init.stuMap)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println("登录成功！");
		StudentUI.mainPage();
		break;
	  }
	  System.err.println("学号或密码输入有误！\n\n");
    }
  }
  
  /**
   * 学生端主页
   * */
  public static void mainPage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.就业去向");
	System.out.println("2.个人信息");
	if(currentUserInfo[7].equals("未登记")) {
	  System.out.println("\n请尽快完成就业登记！");
	}
	System.out.println("（输入logout退出登录）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      StudentUI.employRegisterPage();;
	      isInputRight = 1;
	      break;
	    case "2":
		  StudentUI.personalInfoPage();;
		  isInputRight = 1;
		  break;
	    case "logout":
	      System.out.println("您已登出学生端！\n\n");
		  MainPageUI.welcome();
		  isInputRight = 1;
		  return;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 学生端就业登记页
   * */
  public static void employRegisterPage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页>就业去向");
	System.out.println("=======================================================");
	System.out.println("");
    if(currentUserInfo[7].equals("未登记"))
	  System.out.println("1.登记");
    if(currentUserInfo[7].equals("已登记")) {
	  System.out.println("1.查看");
	  System.out.println("2.修改");
    }
	System.out.println("（输入back返回上一页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      if(currentUserInfo[7].equals("已登记")) {
	    	StudentUI.employInfoInquirePage();
	      } else {
	    	StudentUI.employInfoWritePage("register"); 
	      }
	      isInputRight = 1;
	      break;
	    case "2":
	      if (currentUserInfo[7].equals("已登记")) {
			StudentUI.employInfoModifyPage();
		    isInputRight = 1;
	      }else {
	    	System.err.println("请按导航内选项输入！\n\n");
	      }
		  break;
	    case "back":
		  StudentUI.mainPage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 学生端就业去向登记详情页
   * @param type 用于鉴别具体功能 设置对应返回页面
   * */
  public static void employInfoWritePage(String type) {
	System.out.println("\n\n");
	if (type.equals("register"))
	  System.out.println(">学生主页>就业去向>登记");
	if (type.equals("modify"))
	  System.out.println(">学生主页>就业去向>修改>就业类型");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.待业");
	System.out.println("2.入职");
	System.out.println("3.创业");
	System.out.println("4.研究生");
	System.out.println("（输入back返回上一页；输入exit返回学生主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
		  isInputRight = 1;
	  	  StudentUI.restInfoRegiser("register");
		  break;
	    case "2":
	      isInputRight = 1;
          StudentUI.workInfoRegister("入职", "register");
          break;
	    case "3":
	      isInputRight = 1;
          StudentUI.workInfoRegister("创业", "register");
          break;
	    case "4":
	      isInputRight = 1;
	      StudentUI.studyInfoRegister("register");
	      break;
	    case "exit":
		  StudentUI.mainPage();
		  isInputRight = 1;
		  break;
	    case "back":
	      if(type == "register") 
		    StudentUI.employRegisterPage();
	      if(type == "modify") 
	    	StudentUI.employInfoModifyPage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
	
  }
  
  /**
   * 学生待业信息登记页
   * @param type 用于鉴别具体功能 设置对应返回页面
   * */
  public static void restInfoRegiser(String type) {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	if (type.equals("register"))
	  System.out.println(">学生主页>就业去向>登记>待业");
	if (type.equals("modify"))
	  System.out.println(">学生主页>就业去向>修改>具体信息");
    System.out.println("=======================================================");
    System.out.print("请输入所在地："); 
    registerInfo[0] = input.next();
    if(StudentService.modifyPlace(registerInfo[0], currentUserInfo[0], init.stuMap)) {
	  int isInputRight = 0; //控制是否输入合法
	  while(isInputRight == 0) {
		System.out.println("\n您的联系方式为： " + currentUserInfo[3]);
		System.out.println("如无误，请输入commit;如修改，请输入新联系方式");
	    registerInfo[1] = input.next();
	    if(!registerInfo[1].equals("commit")) {
     	  if (BaseService.isMobile(registerInfo[1])) {
			StudentService.modifyPhone(registerInfo[1], currentUserInfo[0], init.stuMap);
			isInputRight = 1;
		  }else {
			System.err.println("手机号格式有误!");
		  }
		}else {
		  isInputRight = 1;
		}
	  }
      System.out.println("");
      System.out.println("-------------------------------------------------------");
      if(type.equals("register"))
        System.out.println("登记成功！");
      if(type.equals("modify"))
      	System.out.println("修改成功！");
      StudentUI.employRegisterPage();
    }else {
      System.err.println("您的页面走失啦TAT 请重试");
      StudentUI.mainPage();
     }
  }
  
  /**
   * 学生入职，创业信息登记页
   * @param status 区分入职或创业
   * @param type 用于鉴别具体功能 设置对应返回页面
   * */
  public static void workInfoRegister(String status, String type) {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
    System.out.println("\n\n");
    if(type.equals("register"))
      System.out.println(">学生主页>就业去向>登记>" + status);
    if(type.equals("modify"))
      System.out.println(">学生主页>就业去向>修改>具体信息");
    System.out.println("=======================================================");
    System.out.print("请输入工作单位："); 
    registerInfo[0] = input.next();
    System.out.print("请输入工作职位：");
    registerInfo[1] = input.next();
    if(StudentService.modifyEmployed(status, registerInfo, currentUserInfo[0],init.stuMap)) {
      System.out.println("");
      System.out.println("-------------------------------------------------------");
      if(type.equals("register"))
        System.out.println("登记成功！");
      if(type.equals("modify"))
    	System.out.println("修改成功！");
      StudentUI.employRegisterPage();
    }else {
      System.err.println("您的页面走失啦TAT 请重试");
      StudentUI.mainPage();
    }
  }
  
  /*
   * 学生就业去向研究生登记
   * **/
  public static void studyInfoRegister(String type) {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
    System.out.println("\n\n");
    if(type.equals("register"))
      System.out.println(">学生主页>就业去向>登记>研究生");
    if(type.equals("modify"))
      System.out.println(">学生主页>就业去向>修改>具体信息");
    System.out.println("=======================================================");
    System.out.print("请输入录取学校："); 
    registerInfo[0] = input.next();
    if(StudentService.modifySchool(registerInfo[0], currentUserInfo[0],init.stuMap)) {
      System.out.println("");
      System.out.println("-------------------------------------------------------");
      if(type.equals("register"))
        System.out.println("登记成功！");
      if(type.equals("modify"))
      	System.out.println("修改成功！");
      StudentUI.employRegisterPage();
    }else {
       System.err.println("您的页面走失啦TAT 请重试");
       StudentUI.mainPage();
     }
  }
  
  /**
   * 学生端就业去向登记信息查看页
   * */
  public static void employInfoInquirePage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页>就业去向>查看");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("就业去向\t\t" + currentUserInfo[8]);
	switch (currentUserInfo[8]) {
	  case "待业":
	    System.out.println("所在地\t\t" + currentUserInfo[12]);
	    System.out.println("联系方式\t\t" + currentUserInfo[3]);
	    break;
	  case "入职":case "创业":
	    System.out.println("工作单位\t\t" + currentUserInfo[9]);
	    System.out.println("工作岗位\t\t" + currentUserInfo[10]);
	    break;
	  case "研究生":
	    System.out.println("录取学校\t\t" + currentUserInfo[11]);
	    break;
	  default:
		System.err.println("您的信息走丢啦TAT 请重新登记");
		StudentUI.employRegisterPage();
	}
	System.out.println("（输入back返回上一页；输入exit返回学生主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请输入：");
	  switch (input.next()){
	    case "back":
	      isInputRight = 1;
	      StudentUI.employRegisterPage();
		  break;
	    case "exit":
	      isInputRight = 1;
	      StudentUI.mainPage();
		default:
		  System.err.println("请按导航内选项输入！ \n\n");
	  }
	}
  }
  
  /**
   * 学生端就业去向修改页
   * */
  public static void employInfoModifyPage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页>就业去向>修改");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.就业类型");
	System.out.println("2.具体信息");
    System.out.println("（输入back返回上一页；输入exit返回学生主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
		  isInputRight = 1;
	  	  StudentUI.employInfoWritePage("modify");
		  break;
	    case "2":
	      isInputRight = 1;
	      switch (currentUserInfo[8]) {
	        case "待业":
              StudentUI.restInfoRegiser("modify");
	          break;
	        case "入职":
	          StudentUI.workInfoRegister("入职", "modify");
	          break;
	        case "创业":
	          StudentUI.workInfoRegister("创业", "modify");
	          break;
	        case "研究生":
	          StudentUI.studyInfoRegister("modify");
	          break;
	        default:
    		  System.err.println("您的信息走丢啦TAT 请重新登记");
    		  StudentUI.employRegisterPage();
	      }
          break;
	    case "exit":
		  StudentUI.mainPage();
		  isInputRight = 1;
		  break;
	    case "back":
		  StudentUI.employRegisterPage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
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
	System.out.println("（输入back返回上一页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请选择：");
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
	    case "back":
		  StudentUI.mainPage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 学生端查看个人信息页
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>查看");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("学号\t\t" + currentUserInfo[0]);
	System.out.println("姓名\t\t" + currentUserInfo[1]);
	System.out.println("性别\t\t" + currentUserInfo[4]);
	System.out.println("密码\t\t" + currentUserInfo[2]);
	System.out.println("专业\t\t" + currentUserInfo[6]);
	System.out.println("毕业年份\t\t" + currentUserInfo[5]);
	System.out.println("联系方式\t\t" + currentUserInfo[3]);
	System.out.println("（输入back返回上一页；输入exit返回学生主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请输入：");
	  switch (input.next()){
	    case "back":
	      isInputRight = 1;
	      StudentUI.personalInfoPage();
		  break;
	    case "exit":
	      isInputRight = 1;
	      StudentUI.mainPage();
		default:
		  System.err.println("请按导航内选项输入！ \n\n");
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
	System.out.println("（输入back返回上一页；输入exit返回学生主页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");	
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请选择：");
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
	    case "back":
		  StudentUI.personalInfoPage();;
		  isInputRight = 1;
		  break;
	    case "exit":
	      StudentUI.mainPage();
	      isInputRight = 1;
	      break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 学生端修改密码页
   * */
  public static void pwdModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>修改>密码");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入原有密码：（输入back返回上一页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		StudentUI.infoModifyPage();;
		return;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("请输入新密码：");
		modifyInfo[1] = input.next();
		if (StudentService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.stuMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改密码成功！新密码为" + modifyInfo[1]);
	      StudentUI.infoModifyPage();
		  break;
		}
	  }else {
		System.err.println("原密码匹配不成功！\n\n");
	  }
    }
  }
  
  /**
   * 学生端修改联系方式页
   * */
  public static void phoneModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">学生主页>个人信息>修改>联系方式");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入新联系方式：（输入back返回上一页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		StudentUI.infoModifyPage();
		return;  
	  }else if (BaseService.isMobile(modifyInfo[0]) & StudentService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.stuMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改联系方式成功！新联系方式为" + modifyInfo[0]);
	      StudentUI.infoModifyPage();
		  break;
	  }else {
		System.err.println("手机号格式有误！\n\n");
	  }
    }
  }
}
