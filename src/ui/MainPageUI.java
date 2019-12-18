package ui;

import java.util.Scanner;

/**
 * 系统主界面
 * */
public class MainPageUI {
  private static Scanner input = new Scanner(System.in);
  
  /**
   * 主页样式设置
   * */
  public static void welcome() {
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("\t\t毕业生就业去向管理系统");
	System.out.println(">登录");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.学生");
	System.out.println("2.管理员");
	System.out.println("(输入exit退出系统）");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	System.out.println("学生可用账号\t201800 \t初始密码\t00 \n管理员可用账号\t001 \t初始密码\t1\n");
	System.out.print("请选择：");
	String choice = input.next();
	switch (choice) {
	  case "1":
		StudentUI.loginPage();
		break;
	  case "2":
		AdminUI.loginPage();
		break;
	  case "exit":
		System.out.println("\n====================== 感谢使用！=====================");
		break;
	  default:
		System.err.println("请按导航内选项输入！\n\n\n");
		MainPageUI.welcome();
	}
  }
  
  /**
   * 判断是否为输入exit,返回主页面
   */
  public static boolean isExit(String input) {
	if(input.equals("exit")) {
	  System.out.println("");
	  System.out.println("-------------------------------------------------------");
	  System.out.println("\n\n");
	  MainPageUI.welcome();
      return true;
	}
	return false;
  }
}
