package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entity.StudentInfo;
import service.AdminService;
import service.BaseService;
import util.Init;

public class AdminUI {
  //数据初始化
  static Init init = StudentUI.init;
  static AdminService adminService = new AdminService();
  
  private static Scanner input = new Scanner(System.in);
  //登录时使用的账户密码
  private static String[] inputInfo = new String[2];
  //修改时输入的新旧信息
  private static String[] modifyInfo = new String[2];
  //增加记录时的输入信息
  private static String[] addInfo = new String[7];
  
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
	  if (AdminService.login(inputInfo, AdminUI.init.adminMap)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println(" 登录成功！");
		AdminUI.mainPage();
		break;
	  }
	  System.err.println("工号或密码输入有误！\n\n");
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
	System.out.println("（输入logout退出登录）");
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
	      AdminUI.infoMergePage();
	      isInputRight = 1;
	      break;
	    case "3":
		  AdminUI.personalInfoPage();
		  isInputRight = 1;
		  break;
	    case "logout":
	      System.out.println("您已登出管理员端 \n\n");
		  MainPageUI.welcome();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
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
	System.out.println("1.查看"); 
	System.out.println("2.增加");
	System.out.println("3.编辑");
	System.out.println("4.删除");
	System.out.println("5.查询");
	System.out.println("（输入back返回上一页）");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      isInputRight = 1;
	      AdminUI.showAllStudentInfo();
	      break;
	    case "2":
		  isInputRight = 1;
		  AdminUI.addStudentInfo();
		  break;
	    case "3":
		  isInputRight = 1;
		  AdminUI.ModifyStudentInfo();
		  break;
	    case "4":
		  isInputRight = 1;
		  AdminUI.delStudentInfo();
		  break;
	    case "5":
	      isInputRight = 1;
	      AdminUI.inquireStuInfo();
	      break;
	    case "back":
		  AdminUI.mainPage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   *管理员端显示全部毕业生信息 
   * */
  public static void showAllStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>查看");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("学号\t姓名\t性别\t专业\t毕业年份\t联系方式\t\t就业类型\t"); 
	for (Map.Entry<String, StudentInfo> entry : init.stuMap.entrySet()) {
	  System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t"+entry.getValue().getEmployStatus()+"\t");
	}
	System.out.println("（输入back返回上一页；输入exit返回管理员主页）");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请输入：");
	  switch (input.next()){
	    case "back":
	      isInputRight = 1;
	      AdminUI.infoManagePage();
		  break;
	    case "exit":
	      isInputRight = 1;
	      AdminUI.mainPage();
		default:
		  System.err.println("请按导航内选项输入! \n\n");
	  }
	}
  }
  
  /**
   * 管理端增加学生记录
   * */
  public static void addStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>增加");
	System.out.println("=======================================================");
	while(true) {
	  System.out.print("请输入学号：");
      addInfo[0] = input.next();
      if(AdminService.isInStuList(addInfo[0], init.stuMap)) {
        System.err.println("该学号已被占用!");
      }else {
    	break;
      }
	}
	System.out.print("请输入姓名：");
	addInfo[1] = input.next();
	System.out.print("请输入性别：");
	addInfo[2] = input.next();
	System.out.print("请输入毕业年份：");
	addInfo[3] = input.next();
	while(true) {
	  System.out.print("请输入联系方式：");
	  addInfo[4] = input.next();
	  if(BaseService.isMobile(addInfo[4])) {
		break;
	  }else {
		System.err.println("手机号格式有误!");
	  }
	}
	System.out.print("请输入专业：");
	addInfo[5] = input.next();
	System.out.print("请输入密码：");
	addInfo[6] = input.next();
	init.stuMap.put(addInfo[0], new StudentInfo(addInfo[0], addInfo[1], addInfo[6], addInfo[4], addInfo[2], addInfo[3], addInfo[5]));
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
	System.out.println("添加成功！");
	AdminUI.infoManagePage();
  }
  
  /**
   * 管理端编辑指定学号的记录
   * */
  public static void ModifyStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>编辑");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("1.专业");
	System.out.println("2.毕业年份");
	System.out.println("（输入back返回上一页；输入exit返回管理员主页）");
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      AdminUI.modifyStuSpecialty();
	      isInputRight = 1;
	      break;
	    case "2":
		  AdminUI.modifyStuGraYear();
		  isInputRight = 1;
		  break;
	    case "exit":
		  AdminUI.mainPage();
		  isInputRight = 1;
		  break;
	    case "back":
		  AdminUI.infoManagePage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 管理员端修改学生专业
   * */
  public static void modifyStuSpecialty() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>编辑>专业");
	System.out.println("=======================================================");
	while(true) {
	  System.out.println("请输入学生学号：");
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		System.out.println("请输入新专业：");
		inputInfo[1] = input.next();
		AdminService.modifySpecialty(inputInfo[1], inputInfo[0], init.stuMap);
		break;
	  }else {
		System.err.println("未找到对应项！\n\n");
	  }
	}
	System.out.println("-------------------------------------------------------");
	System.out.println("编辑成功！");
	AdminUI.infoManagePage();
  }
  
  /**
   * 管理员端修改学生毕业年份
   * */
  public static void modifyStuGraYear() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>编辑>毕业年份");
	System.out.println("=======================================================");
	while(true) {
	  System.out.println("请输入学生学号：");
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		System.out.println("请输入新毕业年份：");
		inputInfo[1] = input.next();
		AdminService.modifyGradYear(inputInfo[1], inputInfo[0], init.stuMap);
		break;
	  }else {
		System.err.println("未找到对应项！\n\n");
	  }
	}
	System.out.println("-------------------------------------------------------");
	System.out.println("编辑成功！");
	AdminUI.infoManagePage();
  }
  
  /**
   * 管理端删除学生记录
   * */
  public static void delStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>删除");
	System.out.println("=======================================================");
	while(true) {
      System.out.println("请输入学生学号：");  
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		System.out.println("确认删除学号为 "+inputInfo[0]+" 同学的记录吗？");
		System.out.println("确认，请输入confirm;返回上一页，请输入back");
		inputInfo[1] = input.next();
	    if(inputInfo[1].equals("confirm")) {
	      init.stuMap.remove(inputInfo[0]);
	      System.out.println("");  
	      System.out.println("-------------------------------------------------------"); 
	      System.out.println("删除成功！");
	      AdminUI.infoManagePage(); 
	      break;
	    }else if(inputInfo[1].equals("back")){
	   	  AdminUI.infoManagePage();
	      break;
	    }else {
	      System.err.println("请按导航内选项输入！\n");
	    } 
	  }else {
		System.err.println("未找到对应项！\n\n");
	  }
	}
  }
  
  /**
   * 管理端查询信息
   * */
  public static void inquireStuInfo() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息管理>查询");
	System.out.println("=======================================================");
	while(true) {
	  System.out.println("请输入学生学号：");  
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		String[] inquireStuInfo = AdminService.inquireInfo(inputInfo[0], init.stuMap);
		System.out.println("\n查询结果：\n学号\t姓名\t性别\t专业\t毕业年份\t联系方式\t\t就业类型\t"); 
		System.out.println(inquireStuInfo[0]+"\t"+inquireStuInfo[1]+"\t"+inquireStuInfo[2]+"\t"+inquireStuInfo[3]+"\t"+inquireStuInfo[4]+"\t"+inquireStuInfo[5]+"\t"+inquireStuInfo[6]);
		System.out.println("");   
		break;
	  }else {
		System.err.println("未找到对应项！\n\n");  
	  }
	} 
	System.out.println("（输入back返回上一页；输入exit返回管理员主页）");
	System.out.println("-------------------------------------------------------");	
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.print("请选择：");
	  String choice = input.next();
	  switch (choice) {
	    case "exit":
		  AdminUI.mainPage();
		  isInputRight = 1;
		  break;
	    case "back":
		  AdminUI.infoManagePage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 管理员端信息汇总页
   * */
  public static void infoMergePage() {
	System.out.println("\n\n");
	System.out.println(">管理员主页>信息汇总");
	System.out.println("=======================================================");
	System.out.println(""); 
	AdminUI.infoStatisticPage();
	System.out.println("\n（输入back返回上一页）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //控制是否输入合法
	while(isInputRight == 0) {
	  System.out.println("请输入：");
	  if(input.next().equals("back")){
	    isInputRight = 1;
	    AdminUI.mainPage();
	    break;
	  }else {
		System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 管理端根据去向分类显示全部毕业生记录（待业，入职，创业，研究生，未登记）
   * */
  public static void infoClassifyPage(HashMap<String, StudentInfo> student) {
	AdminService.classifyStuInfo(student);
	if(!AdminService.restStuMap.isEmpty()) {
	  System.out.println("『待业』");
	  System.out.println("学号\t姓名\t性别\t专业\t毕业年份\t联系方式\t\t所在地\t");
	  for (Map.Entry<String, StudentInfo> entry : AdminService.restStuMap.entrySet()) {
	    System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t"+entry.getValue().getPlace()+"\t");
	  }
	}
	if(!AdminService.employStuMap.isEmpty()) {
	  System.out.println("『入职』");
	  System.out.println("学号\t姓名\t性别\t专业\t毕业年份\t联系方式\t\t单位\t岗位");
	  for (Map.Entry<String, StudentInfo> entry : AdminService.employStuMap.entrySet()) {
	    System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t"+entry.getValue().getCompany()+"\t" + entry.getValue().getJob());
	  }
	}
	if(!AdminService.createStuMap.isEmpty()) {
	  System.out.println("『创业』");
	  System.out.println("学号\t姓名\t性别\t专业\t毕业年份\t联系方式\t\t单位\t岗位");
	  for (Map.Entry<String, StudentInfo> entry : AdminService.createStuMap.entrySet()) {
	    System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t"+entry.getValue().getCompany()+"\t"+ entry.getValue().getJob());
	  }
	}
	if(!AdminService.furtherStuMap.isEmpty()) {
	  System.out.println("『研究生』");
	  System.out.println("学号\t姓名\t性别\t专业\t毕业年份\t联系方式\t\t学校\t");
	  for (Map.Entry<String, StudentInfo> entry : AdminService.furtherStuMap.entrySet()) {
	    System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t"+entry.getValue().getSchool()+"\t");
	  }
	}
	if(!AdminService.unfinishedStuMap.isEmpty()) {
	  System.out.println("『未登记』"); 
	  System.out.println("学号\t姓名\t性别\t专业\t毕业年份\t联系方式");
	  for (Map.Entry<String, StudentInfo> entry : AdminService.unfinishedStuMap.entrySet()) {
	    System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t");
	  }
	}
  }
  
  /**
   * 管理端对信息进行分类汇总统计
   * */
  public static void infoStatisticPage() {
	int allNum = init.stuMap.size();
	System.out.println("【总人数：" + allNum + "】\n"); 
	AdminService.sexClassifyInfo(init.stuMap);
	
	AdminService.classifyStuInfo(AdminService.maleStuMap);
	int maleNum = AdminService.maleStuMap.size();
	int maleUnFinish = AdminService.unfinishedStuMap.size();
	int maleRest = AdminService.restStuMap.size();
	int maleStudy = AdminService.furtherStuMap.size();
	System.out.println("【 男：" + maleNum + "人】");
	AdminUI.infoClassifyPage(AdminService.maleStuMap);
	
	AdminService.classifyStuInfo(AdminService.femaleStuMap);
	int femaleNum = AdminService.femaleStuMap.size();
	int femaleUnFinish = AdminService.unfinishedStuMap.size();
	int femaleRest = AdminService.restStuMap.size();
	int femaleStudy = AdminService.furtherStuMap.size();
	System.out.println("\n【 女：" + femaleNum + "人】");
	AdminUI.infoClassifyPage(AdminService.femaleStuMap);
	
	System.out.println("\n\n" + (maleUnFinish + femaleUnFinish) + "位同学尚未完成就业登记");
	System.out.println("男女比例为 " + (maleNum*1.0 / femaleNum));
	int employeeNum = allNum - maleUnFinish - femaleUnFinish - maleStudy - femaleStudy;
	System.out.println("总就业率为 " + (employeeNum - maleRest - femaleRest) * 1.00/employeeNum);
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
	System.out.println("（输入back返回上一页）");
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
	    case "back":
	      System.out.println("\n");
		  AdminUI.mainPage();;
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 管理员查看个人信息页
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminMap);
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>查看");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("工号\t\t" + currentUserInfo[0]);
	System.out.println("姓名\t\t" + currentUserInfo[1]);
	System.out.println("密码\t\t" + currentUserInfo[2]);
	System.out.println("部门\t\t" + currentUserInfo[4]);
	System.out.println("联系方式\t\t" + currentUserInfo[3]);
	System.out.println("（输入back返回上一页；输入exit返回管理员主页）");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	while(true) {
	  System.out.print("请输入：");
	  switch (input.next()){
	    case "back":
	      AdminUI.personalInfoPage();
		  break;
	    case "exit":
	      AdminUI.mainPage();
		default:
		  System.err.println("请按导航内选项输入！ \n\n");
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
	System.out.println("（输入back返回上一页；输入exit返回管理员主页）");
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
	    case "back":
		  AdminUI.personalInfoPage();;
		  isInputRight = 1;
		  break;
	    case "exit":
	      AdminUI.mainPage();
	      isInputRight = 1;
	      break;
	    default:
		  System.err.println("请按导航内选项输入！\n\n");
	  }
	}
  }
  
  /**
   * 管理员修改密码页
   * */
  public static void pwdModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminMap);
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>修改>密码");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入原有密码：（输入back返回上一页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		AdminUI.infoModifyPage();;
		break;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("请输入新密码：");
		modifyInfo[1] = input.next();
		if (AdminService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.adminMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改密码成功！新密码为" + modifyInfo[1]);
	      AdminUI.infoModifyPage();
		  break;
		}
	  }else {
		System.err.println("原密码匹配不成功！\n\n");
	  }
    }
  }
  
  /**
   * 管理员修改联系方式页
   * */
  public static void phoneModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminMap);
	System.out.println("\n\n");
	System.out.println(">管理员主页>个人信息>修改>联系方式");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("请输入新联系方式：（输入back返回上一页）");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		AdminUI.infoModifyPage();
		break;  
	  }else if (BaseService.isMobile(modifyInfo[0]) & AdminService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.adminMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("修改联系方式成功！新联系方式为" + modifyInfo[0]);
	      AdminUI.infoModifyPage();
		  break;
	  }else {
		System.err.println("手机号格式有误！\n\n");
	  }
    }
  }
}

