package ui;

import java.util.Scanner;

import service.AdminService;
import util.Init;

public class AdminUI {
  //���ݳ�ʼ��
  static Init init = new Init();
  static AdminService adminService = new AdminService();
  
  private static Scanner input = new Scanner(System.in);
  //��¼ʱʹ�õ��˻�����
  private static String[] inputInfo = new String[2];
  //�޸�ʱ������¾���Ϣ
  private static String[] modifyInfo = new String[2];
  
  /**
   * ����˵�¼����
   * */
  public static void loginPage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��¼");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("�����빤�ţ�������exit������ҳ��");
	  inputInfo[0] = input.next();
	  if(MainPageUI.isExit(inputInfo[0])) 
	   break;
	  System.out.println("���������룺");
	  inputInfo[1] = input.next();
	  if (AdminService.login(inputInfo, AdminUI.init.adminList)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println(" ��¼�ɹ���");
		AdminUI.mainPage();
		break;
	  }
	  System.out.println("��������\n\n");
    }
  }
  
  
  /**
   * �������ҳ
   * */
  public static void mainPage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.��Ϣ����");
	System.out.println("2.��Ϣ����");
	System.out.println("3.������Ϣ");
	System.out.println("������exit�˳���¼��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  System.out.println("��������\n\n");
	  }
	}
  }
  
  
  /**
   * �������Ϣ����ҳ
   * */
  public static void infoManagePage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����");
	System.out.println("=======================================================");
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
  }
  
  /**
   * �������Ϣ����ҳ
   * */
  public static void infoCollectPage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����");
	System.out.println("=======================================================");
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
  }
  
  /**
   * ����˸�����Ϣҳ
   * */
  public static void personalInfoPage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ");
	System.out.println("=======================================================");
	System.out.println("");  
	System.out.println("1.�鿴");
	System.out.println("2.�޸�");
	System.out.println("������exit���ع���Ա��ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  System.out.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ����Ա�鿴������Ϣҳ
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminList);
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�鿴");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("����\t\t" + currentUserInfo[0]);
	System.out.println("����\t\t" + currentUserInfo[1]);
	System.out.println("����\t\t" + currentUserInfo[2]);
	System.out.println("����\t\t" + currentUserInfo[4]);
	System.out.println("��ϵ��ʽ\t\t" + currentUserInfo[3]);
	System.out.println("������exit���ظ�����Ϣҳ��");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	while(true) {
	  System.out.print("�����룺");
	  if(input.next().equals("exit")) {
	    AdminUI.personalInfoPage();
		break;
	  }else {
		System.out.println("��������! \n\n");
	  }
	}
  }
  
  /**
   * ����Ա�޸ĸ�����Ϣҳ
   * */
  public static void infoModifyPage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�޸�");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("1.����");
	System.out.println("2.��ϵ��ʽ");
	System.out.println("������exit���ظ�����Ϣҳ��");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");  
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  System.out.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ����Ա�޸�����ҳ
   * */
  public static void pwdModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminList);
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�޸�>����");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("������ԭ�����룺������exit�����޸�ҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		AdminUI.infoModifyPage();;
		break;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("�����������룺");
		modifyInfo[1] = input.next();
		if (AdminService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.adminList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸�����ɹ���������Ϊ" + modifyInfo[1]);
	      AdminUI.infoModifyPage();
		  break;
		}
	  }else {
		System.out.println("��������\n\n");
	  }
    }
  }
  
  /**
   * ����Ա�޸���ϵ��ʽҳ
   * */
  public static void phoneModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminList);
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�޸�>��ϵ��ʽ");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("����������ϵ��ʽ��������exit�����޸�ҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		AdminUI.infoModifyPage();
		break;  
	  }else if (AdminService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.adminList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸���ϵ��ʽ�ɹ�������ϵ��ʽΪ" + modifyInfo[0]);
	      AdminUI.infoModifyPage();
		  break;
	  }else {
		System.out.println("��������\n\n");
	  }
    }
  }
}

