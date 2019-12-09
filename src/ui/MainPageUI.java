package ui;

import java.util.Scanner;

/**
 * ϵͳ������
 * */
public class MainPageUI {
  private static Scanner input = new Scanner(System.in);
  
  /**
   * ��ҳ��ʽ����
   * */
  public static void welcome() {
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("\t\t��ҵ����ҵȥ�����ϵͳ");
	System.out.println(">��¼");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.ѧ��");
	System.out.println("2.����Ա");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	System.out.println("ѧ�������˺�\t201800 \t����\t00 \n����Ա�����˺�\t001 \t����\t1\n");
	System.out.print("��ѡ��");
	int choice = input.nextInt();
	switch (choice) {
	  case 1:
		StudentUI.loginPage();
		break;
	  case 2:
		AdminUI.loginPage();
		break;
	  default:
		System.out.println("��������\n\n\n");
		MainPageUI.welcome();
	}
  }
  
  /**
   * �ж��Ƿ�Ϊ����exit,������ҳ��
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
