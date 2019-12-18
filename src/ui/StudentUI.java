package ui;

import java.util.Scanner;

import service.BaseService;
import service.StudentService;

import util.Init;

public class StudentUI {
  //���ݳ�ʼ��
  public static Init init = new Init();
  static StudentService studentService = new StudentService();
	  
  private static Scanner input = new Scanner(System.in);
  //��¼ʱʹ�õ��˻�����
  private static String[] inputInfo = new String[2];
  //�޸�ʱ������¾���Ϣ
  private static String[] modifyInfo = new String[2];
  //��ҵ�Ǽ�ʱ������Ϣ
  private static String[] registerInfo = new String[2];

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
	  if (StudentService.login(inputInfo, StudentUI.init.stuMap)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println("��¼�ɹ���");
		StudentUI.mainPage();
		break;
	  }
	  System.err.println("ѧ�Ż�������������\n\n");
    }
  }
  
  /**
   * ѧ������ҳ
   * */
  public static void mainPage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.��ҵȥ��");
	System.out.println("2.������Ϣ");
	if(currentUserInfo[7].equals("δ�Ǽ�")) {
	  System.out.println("\n�뾡����ɾ�ҵ�Ǽǣ�");
	}
	System.out.println("������logout�˳���¼��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
	      System.out.println("���ѵǳ�ѧ���ˣ�\n\n");
		  MainPageUI.welcome();
		  isInputRight = 1;
		  return;
	    default:
		  System.err.println("�밴������ѡ�����룡\n\n");
	  }
	}
  }
  
  /**
   * ѧ���˾�ҵ�Ǽ�ҳ
   * */
  public static void employRegisterPage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>��ҵȥ��");
	System.out.println("=======================================================");
	System.out.println("");
    if(currentUserInfo[7].equals("δ�Ǽ�"))
	  System.out.println("1.�Ǽ�");
    if(currentUserInfo[7].equals("�ѵǼ�")) {
	  System.out.println("1.�鿴");
	  System.out.println("2.�޸�");
    }
	System.out.println("������back������һҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
	      if(currentUserInfo[7].equals("�ѵǼ�")) {
	    	StudentUI.employInfoInquirePage();
	      } else {
	    	StudentUI.employInfoWritePage("register"); 
	      }
	      isInputRight = 1;
	      break;
	    case "2":
	      if (currentUserInfo[7].equals("�ѵǼ�")) {
			StudentUI.employInfoModifyPage();
		    isInputRight = 1;
	      }else {
	    	System.err.println("�밴������ѡ�����룡\n\n");
	      }
		  break;
	    case "back":
		  StudentUI.mainPage();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("�밴������ѡ�����룡\n\n");
	  }
	}
  }
  
  /**
   * ѧ���˾�ҵȥ��Ǽ�����ҳ
   * @param type ���ڼ�����幦�� ���ö�Ӧ����ҳ��
   * */
  public static void employInfoWritePage(String type) {
	System.out.println("\n\n");
	if (type.equals("register"))
	  System.out.println(">ѧ����ҳ>��ҵȥ��>�Ǽ�");
	if (type.equals("modify"))
	  System.out.println(">ѧ����ҳ>��ҵȥ��>�޸�>��ҵ����");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.��ҵ");
	System.out.println("2.��ְ");
	System.out.println("3.��ҵ");
	System.out.println("4.�о���");
	System.out.println("������back������һҳ������exit����ѧ����ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.println("��ѡ��");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
		  isInputRight = 1;
	  	  StudentUI.restInfoRegiser("register");
		  break;
	    case "2":
	      isInputRight = 1;
          StudentUI.workInfoRegister("��ְ", "register");
          break;
	    case "3":
	      isInputRight = 1;
          StudentUI.workInfoRegister("��ҵ", "register");
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
		  System.err.println("�밴������ѡ�����룡\n\n");
	  }
	}
	
  }
  
  /**
   * ѧ����ҵ��Ϣ�Ǽ�ҳ
   * @param type ���ڼ�����幦�� ���ö�Ӧ����ҳ��
   * */
  public static void restInfoRegiser(String type) {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	if (type.equals("register"))
	  System.out.println(">ѧ����ҳ>��ҵȥ��>�Ǽ�>��ҵ");
	if (type.equals("modify"))
	  System.out.println(">ѧ����ҳ>��ҵȥ��>�޸�>������Ϣ");
    System.out.println("=======================================================");
    System.out.print("���������ڵأ�"); 
    registerInfo[0] = input.next();
    if(StudentService.modifyPlace(registerInfo[0], currentUserInfo[0], init.stuMap)) {
	  int isInputRight = 0; //�����Ƿ�����Ϸ�
	  while(isInputRight == 0) {
		System.out.println("\n������ϵ��ʽΪ�� " + currentUserInfo[3]);
		System.out.println("������������commit;���޸ģ�����������ϵ��ʽ");
	    registerInfo[1] = input.next();
	    if(!registerInfo[1].equals("commit")) {
     	  if (BaseService.isMobile(registerInfo[1])) {
			StudentService.modifyPhone(registerInfo[1], currentUserInfo[0], init.stuMap);
			isInputRight = 1;
		  }else {
			System.err.println("�ֻ��Ÿ�ʽ����!");
		  }
		}else {
		  isInputRight = 1;
		}
	  }
      System.out.println("");
      System.out.println("-------------------------------------------------------");
      if(type.equals("register"))
        System.out.println("�Ǽǳɹ���");
      if(type.equals("modify"))
      	System.out.println("�޸ĳɹ���");
      StudentUI.employRegisterPage();
    }else {
      System.err.println("����ҳ����ʧ��TAT ������");
      StudentUI.mainPage();
     }
  }
  
  /**
   * ѧ����ְ����ҵ��Ϣ�Ǽ�ҳ
   * @param status ������ְ��ҵ
   * @param type ���ڼ�����幦�� ���ö�Ӧ����ҳ��
   * */
  public static void workInfoRegister(String status, String type) {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
    System.out.println("\n\n");
    if(type.equals("register"))
      System.out.println(">ѧ����ҳ>��ҵȥ��>�Ǽ�>" + status);
    if(type.equals("modify"))
      System.out.println(">ѧ����ҳ>��ҵȥ��>�޸�>������Ϣ");
    System.out.println("=======================================================");
    System.out.print("�����빤����λ��"); 
    registerInfo[0] = input.next();
    System.out.print("�����빤��ְλ��");
    registerInfo[1] = input.next();
    if(StudentService.modifyEmployed(status, registerInfo, currentUserInfo[0],init.stuMap)) {
      System.out.println("");
      System.out.println("-------------------------------------------------------");
      if(type.equals("register"))
        System.out.println("�Ǽǳɹ���");
      if(type.equals("modify"))
    	System.out.println("�޸ĳɹ���");
      StudentUI.employRegisterPage();
    }else {
      System.err.println("����ҳ����ʧ��TAT ������");
      StudentUI.mainPage();
    }
  }
  
  /*
   * ѧ����ҵȥ���о����Ǽ�
   * **/
  public static void studyInfoRegister(String type) {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
    System.out.println("\n\n");
    if(type.equals("register"))
      System.out.println(">ѧ����ҳ>��ҵȥ��>�Ǽ�>�о���");
    if(type.equals("modify"))
      System.out.println(">ѧ����ҳ>��ҵȥ��>�޸�>������Ϣ");
    System.out.println("=======================================================");
    System.out.print("������¼ȡѧУ��"); 
    registerInfo[0] = input.next();
    if(StudentService.modifySchool(registerInfo[0], currentUserInfo[0],init.stuMap)) {
      System.out.println("");
      System.out.println("-------------------------------------------------------");
      if(type.equals("register"))
        System.out.println("�Ǽǳɹ���");
      if(type.equals("modify"))
      	System.out.println("�޸ĳɹ���");
      StudentUI.employRegisterPage();
    }else {
       System.err.println("����ҳ����ʧ��TAT ������");
       StudentUI.mainPage();
     }
  }
  
  /**
   * ѧ���˾�ҵȥ��Ǽ���Ϣ�鿴ҳ
   * */
  public static void employInfoInquirePage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>��ҵȥ��>�鿴");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("��ҵȥ��\t\t" + currentUserInfo[8]);
	switch (currentUserInfo[8]) {
	  case "��ҵ":
	    System.out.println("���ڵ�\t\t" + currentUserInfo[12]);
	    System.out.println("��ϵ��ʽ\t\t" + currentUserInfo[3]);
	    break;
	  case "��ְ":case "��ҵ":
	    System.out.println("������λ\t\t" + currentUserInfo[9]);
	    System.out.println("������λ\t\t" + currentUserInfo[10]);
	    break;
	  case "�о���":
	    System.out.println("¼ȡѧУ\t\t" + currentUserInfo[11]);
	    break;
	  default:
		System.err.println("������Ϣ�߶���TAT �����µǼ�");
		StudentUI.employRegisterPage();
	}
	System.out.println("������back������һҳ������exit����ѧ����ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("�����룺");
	  switch (input.next()){
	    case "back":
	      isInputRight = 1;
	      StudentUI.employRegisterPage();
		  break;
	    case "exit":
	      isInputRight = 1;
	      StudentUI.mainPage();
		default:
		  System.err.println("�밴������ѡ�����룡 \n\n");
	  }
	}
  }
  
  /**
   * ѧ���˾�ҵȥ���޸�ҳ
   * */
  public static void employInfoModifyPage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>��ҵȥ��>�޸�");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("1.��ҵ����");
	System.out.println("2.������Ϣ");
    System.out.println("������back������һҳ������exit����ѧ����ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.println("��ѡ��");
	  String choice = input.next();
	  switch (choice) {
	    case "1":
		  isInputRight = 1;
	  	  StudentUI.employInfoWritePage("modify");
		  break;
	    case "2":
	      isInputRight = 1;
	      switch (currentUserInfo[8]) {
	        case "��ҵ":
              StudentUI.restInfoRegiser("modify");
	          break;
	        case "��ְ":
	          StudentUI.workInfoRegister("��ְ", "modify");
	          break;
	        case "��ҵ":
	          StudentUI.workInfoRegister("��ҵ", "modify");
	          break;
	        case "�о���":
	          StudentUI.studyInfoRegister("modify");
	          break;
	        default:
    		  System.err.println("������Ϣ�߶���TAT �����µǼ�");
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
		  System.err.println("�밴������ѡ�����룡\n\n");
	  }
	}
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
	System.out.println("������back������һҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.println("��ѡ��");
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
		  System.err.println("�밴������ѡ�����룡\n\n");
	  }
	}
  }
  
  /**
   * ѧ���˲鿴������Ϣҳ
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�鿴");
	System.out.println("=======================================================");
	System.out.println("");
	System.out.println("ѧ��\t\t" + currentUserInfo[0]);
	System.out.println("����\t\t" + currentUserInfo[1]);
	System.out.println("�Ա�\t\t" + currentUserInfo[4]);
	System.out.println("����\t\t" + currentUserInfo[2]);
	System.out.println("רҵ\t\t" + currentUserInfo[6]);
	System.out.println("��ҵ���\t\t" + currentUserInfo[5]);
	System.out.println("��ϵ��ʽ\t\t" + currentUserInfo[3]);
	System.out.println("������back������һҳ������exit����ѧ����ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.println("�����룺");
	  switch (input.next()){
	    case "back":
	      isInputRight = 1;
	      StudentUI.personalInfoPage();
		  break;
	    case "exit":
	      isInputRight = 1;
	      StudentUI.mainPage();
		default:
		  System.err.println("�밴������ѡ�����룡 \n\n");
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
	System.out.println("������back������һҳ������exit����ѧ����ҳ��");
	System.out.println("");
	System.out.println("-------------------------------------------------------");	
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.println("��ѡ��");
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
		  System.err.println("�밴������ѡ�����룡\n\n");
	  }
	}
  }
  
  /**
   * ѧ�����޸�����ҳ
   * */
  public static void pwdModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�޸�>����");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("������ԭ�����룺������back������һҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		StudentUI.infoModifyPage();;
		return;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("�����������룺");
		modifyInfo[1] = input.next();
		if (StudentService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.stuMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸�����ɹ���������Ϊ" + modifyInfo[1]);
	      StudentUI.infoModifyPage();
		  break;
		}
	  }else {
		System.err.println("ԭ����ƥ�䲻�ɹ���\n\n");
	  }
    }
  }
  
  /**
   * ѧ�����޸���ϵ��ʽҳ
   * */
  public static void phoneModify() {
	String[] currentUserInfo = StudentService.getStudentInfo(inputInfo[0], init.stuMap);
	System.out.println("\n\n");
	System.out.println(">ѧ����ҳ>������Ϣ>�޸�>��ϵ��ʽ");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("����������ϵ��ʽ��������back������һҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		StudentUI.infoModifyPage();
		return;  
	  }else if (BaseService.isMobile(modifyInfo[0]) & StudentService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.stuMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸���ϵ��ʽ�ɹ�������ϵ��ʽΪ" + modifyInfo[0]);
	      StudentUI.infoModifyPage();
		  break;
	  }else {
		System.err.println("�ֻ��Ÿ�ʽ����\n\n");
	  }
    }
  }
}
