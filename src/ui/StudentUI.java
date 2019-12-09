package ui;

import java.util.Scanner;
import service.StudentService;

import util.Init;

public class StudentUI {
  //���ݳ�ʼ��
  static Init init = new Init();
  static StudentService studentService = new StudentService();
	  
  private static Scanner input = new Scanner(System.in);
  //��¼ʱʹ�õ��˻�����
  private static String[] inputInfo = new String[2];
  //�޸�ʱ������¾���Ϣ
  private static String[] modifyInfo = new String[2];

  /**
   * ѧ����¼����
   * */
  public static void loginPage() {
	System.out.println("\n\n");
	System.out.println(">ѧ����¼");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("������ѧ�ţ�������exit������ҳ��");
	  inputInfo[0] = input.next();
	  if(MainPageUI.isExit(inputInfo[0])) {
	    return;
	  }
	  System.out.println("���������룺");
	  inputInfo[1] = input.next();
	  if (StudentService.login(inputInfo, StudentUI.init.stuList)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println(" ��¼�ɹ���");
		StudentUI.mainPage();
		break;
	  }
	  System.out.println("��������\n\n");
    }
  }
  
  /**
   * ѧ������ҳ
   * */
  public static void mainPage() {
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.��ҵȥ��");
	System.out.println("2.������Ϣ");
	System.out.println("������exit�˳���¼��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  System.out.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ѧ���˾�ҵ�Ǽ�ҳ
   * */
  public static void infoRegisterPage() {
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>��ҵȥ��");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
  }
  
  /**
   * ѧ���˸�����Ϣҳ
   * */
  public static void personalInfoPage() {
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.�鿴");
	System.out.println("2.�޸�");
	System.out.println("������exit����ѧ����ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  System.out.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ѧ���˲鿴������Ϣҳ
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuList);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�鿴");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("ѧ��\t\t" + currentUserInfo[0]);
	System.out.println("����\t\t" + currentUserInfo[1]);
	System.out.println("����\t\t" + currentUserInfo[2]);
	System.out.println("�Ա�\t\t" + currentUserInfo[4]);
	System.out.println("רҵ\t\t" + currentUserInfo[6]);
	System.out.println("��ҵ���\t\t" + currentUserInfo[5]);
	System.out.println("��ϵ��ʽ\t\t" + currentUserInfo[3]);
	System.out.println("������exit���ظ�����Ϣҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	while(true) {
	  System.out.print("�����룺");
	  if(input.next().equals("exit")) {
	    StudentUI.personalInfoPage();
		break;
	  }else {
		System.out.println("��������! \n\n");
	  }
	}
  }
  
  /**
   * ѧ�����޸ĸ�����Ϣҳ
   * */
  public static void infoModifyPage() {
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�޸�");
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
		  System.out.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ѧ�����޸�����ҳ
   * */
  public static void pwdModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuList);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�޸�>����");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("������ԭ�����룺������exit�����޸�ҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		StudentUI.infoModifyPage();;
		return;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("�����������룺");
		modifyInfo[1] = input.next();
		if (StudentService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.stuList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸�����ɹ���������Ϊ" + modifyInfo[1]);
	      StudentUI.infoModifyPage();
		  break;
		}
	  }else {
		System.out.println("��������\n\n");
	  }
    }
  }
  
  /**
   * ѧ�����޸���ϵ��ʽҳ
   * */
  public static void phoneModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuList);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�޸�>��ϵ��ʽ");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("����������ϵ��ʽ��������exit�����޸�ҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("exit")) {
		StudentUI.infoModifyPage();
		return;  
	  }else if (StudentService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.stuList)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸���ϵ��ʽ�ɹ�������ϵ��ʽΪ" + modifyInfo[0]);
	      StudentUI.infoModifyPage();
		  break;
	  }else {
		System.out.println("��������\n\n");
	  }
    }
  }
}
