package ui;

import java.util.Map;
import java.util.Scanner;

import entity.StudentInfo;
import service.AdminService;
import service.BaseService;
import util.Init;

public class AdminUI {
  //���ݳ�ʼ��
  static Init init = StudentUI.init;
  static AdminService adminService = new AdminService();
  
  private static Scanner input = new Scanner(System.in);
  //��¼ʱʹ�õ��˻�����
  private static String[] inputInfo = new String[2];
  //�޸�ʱ������¾���Ϣ
  private static String[] modifyInfo = new String[2];
  //���Ӽ�¼ʱ��������Ϣ
  private static String[] addInfo = new String[7];
  
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
	  if (AdminService.login(inputInfo, AdminUI.init.adminMap)) {
		System.out.println("");
	    System.out.println("-------------------------------------------------------");
	    System.out.println(" ��¼�ɹ���");
		AdminUI.mainPage();
		break;
	  }
	  System.err.println("��������\n\n");
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
	System.out.println("2.������Ϣ");
	System.out.println("������logout�˳���¼��");
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
		  AdminUI.personalInfoPage();
		  isInputRight = 1;
		  break;
	    case "logout":
	      System.out.println("���ѵǳ�����Ա�� \n\n");
		  MainPageUI.welcome();
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("��������\n\n");
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
	System.out.println("1.�鿴"); 
	System.out.println("2.����");
	System.out.println("3.�༭");
	System.out.println("4.ɾ��");
	System.out.println("5.��ѯ");
	System.out.println("������back������һҳ��");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  AdminUI.ModifyStudentPage();
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
		  System.err.println("��������\n\n");
	  }
	}
  }
  
  /**
   *����Ա����ʾȫ����ҵ����Ϣ 
   * */
  public static void showAllStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>�鿴");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("ѧ��\t����\t�Ա�\tרҵ\t��ҵ���\t��ϵ��ʽ\t\t��ҵ����\t"); 
	for (Map.Entry<String, StudentInfo> entry : init.stuMap.entrySet()) {
	  System.out.println(entry.getValue().getId()+"\t"+ entry.getValue().getName()+"\t"+entry.getValue().getSex()+"\t"+entry.getValue().getSpecialty()+"\t"+entry.getValue().getGraduYear()+"\t"+ entry.getValue().getPhone()+"\t"+entry.getValue().getEmployStatus()+"\t");
	}
	System.out.println("������back������һҳ������exit���ع���Ա��ҳ��");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.println("�����룺");
	  switch (input.next()){
	    case "back":
	      isInputRight = 1;
	      AdminUI.infoManagePage();
		  break;
	    case "exit":
	      isInputRight = 1;
	      AdminUI.mainPage();
		default:
		  System.err.println("��������! \n\n");
	  }
	}
  }
  
  /**
   * ���������ѧ����¼
   * */
  public static void addStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>����");
	System.out.println("=======================================================");
	System.out.print("������ѧ�ţ�");
	addInfo[0] = input.next();
	System.out.print("������������");
	addInfo[1] = input.next();
	System.out.print("�������Ա�");
	addInfo[2] = input.next();
	System.out.print("�������ҵ��ݣ�");
	addInfo[3] = input.next();
	while(true) {
	  System.out.print("��������ϵ��ʽ��");
	  addInfo[4] = input.next();
	  if(BaseService.isMobile(addInfo[4])) {
		break;
	  }else {
		System.err.println("��������");
	  }
	}
	System.out.print("������רҵ��");
	addInfo[5] = input.next();
	System.out.print("���������룺");
	addInfo[6] = input.next();
	init.stuMap.put(addInfo[0], new StudentInfo(addInfo[0], addInfo[1], addInfo[6], addInfo[4], addInfo[2], addInfo[3], addInfo[5]));
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
	System.out.println("��ӳɹ���");
	AdminUI.infoManagePage();
  }
  
  /**
   * ����˱༭ָ��ѧ�ŵļ�¼
   * */
  public static void ModifyStudentPage() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>�༭");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("1.רҵ");
	System.out.println("2.��ҵ���");
	System.out.println("������back������һҳ������exit���ع���Ա��ҳ��");
	System.out.println("");  
	System.out.println("-------------------------------------------------------");
	int isInputRight = 0; //�����Ƿ�����Ϸ�
	while(isInputRight == 0) {
	  System.out.print("��ѡ��");
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
		  System.err.println("��������\n\n");
	  }
	}

  }
  
  /**
   * ����Ա���޸�ѧ��רҵ
   * */
  public static void modifyStuSpecialty() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>�༭>רҵ");
	System.out.println("=======================================================");
	while(true) {
	  System.out.println("������ѧ��ѧ�ţ�");
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		System.out.println("��������רҵ��");
		inputInfo[1] = input.next();
		AdminService.modifySpecialty(inputInfo[1], inputInfo[0], init.stuMap);
		break;
	  }else {
		System.err.println("δ�ҵ���Ӧ�\n\n");
	  }
	}
	System.out.println("-------------------------------------------------------");
	System.out.println("�༭�ɹ���");
	AdminUI.infoManagePage();
  }
  
  /**
   * ����Ա���޸�ѧ����ҵ���
   * */
  public static void modifyStuGraYear() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>�༭>��ҵ���");
	System.out.println("=======================================================");
	while(true) {
	  System.out.println("������ѧ��ѧ�ţ�");
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		System.out.println("�������±�ҵ��ݣ�");
		inputInfo[1] = input.next();
		AdminService.modifyGradYear(inputInfo[1], inputInfo[0], init.stuMap);
		break;
	  }else {
		System.err.println("δ�ҵ���Ӧ�\n\n");
	  }
	}
	System.out.println("-------------------------------------------------------");
	System.out.println("�༭�ɹ���");
	AdminUI.infoManagePage();
  }
  
  /**
   * �����ɾ��ѧ����¼
   * */
  public static void delStudentInfo() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>ɾ��");
	System.out.println("=======================================================");
	while(true) {
      System.out.println("������ѧ��ѧ�ţ�");  
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		System.out.println("ȷ��ɾ��ѧ��Ϊ "+inputInfo[0]+" ͬѧ�ļ�¼��");
		System.out.println("ȷ�ϣ�������confirm;������һҳ��������back");
		inputInfo[1] = input.next();
	    if(inputInfo[1].equals("confirm")) {
	      init.stuMap.remove(inputInfo[0]);
	      System.out.println("");  
	      System.out.println("-------------------------------------------------------"); 
	      System.out.println("ɾ���ɹ���");
	      AdminUI.infoManagePage(); 
	      break;
	    }else if(inputInfo[1].equals("back")){
	   	  AdminUI.infoManagePage();
	      break;
	    }else {
	      System.err.println("��������\n");
	    } 
	  }else {
		System.err.println("δ�ҵ���Ӧ�\n\n");
	  }
	}
  }
  
  /**
   * ����˲�ѯ��Ϣ
   * */
  public static void inquireStuInfo() {
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>��Ϣ����>��ѯ");
	System.out.println("=======================================================");
	while(true) {
	  System.out.println("������ѧ��ѧ�ţ�");  
	  inputInfo[0] = input.next();
	  if(AdminService.isInStuList(inputInfo[0], init.stuMap)) {
		String[] inquireStuInfo = AdminService.inquireInfo(inputInfo[0], init.stuMap);
		System.out.println("\n��ѯ�����\nѧ��\t����\t�Ա�\tרҵ\t��ҵ���\t��ϵ��ʽ\t\t��ҵ����\t"); 
		System.out.println(inquireStuInfo[0]+"\t"+inquireStuInfo[1]+"\t"+inquireStuInfo[2]+"\t"+inquireStuInfo[3]+"\t"+inquireStuInfo[4]+"\t"+inquireStuInfo[5]+"\t"+inquireStuInfo[6]);
		System.out.println("");   
		break;
	  }else {
		System.err.println("δ�ҵ���Ӧ�\n\n");  
	  }
	} 
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
	System.out.println("������back������һҳ��");
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
	    case "back":
	      System.out.println("\n");
		  AdminUI.mainPage();;
		  isInputRight = 1;
		  break;
	    default:
		  System.err.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ����Ա�鿴������Ϣҳ
   * */
  public static void infoInquirePage() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminMap);
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�鿴");
	System.out.println("=======================================================");
	System.out.println(""); 
	System.out.println("����\t\t" + currentUserInfo[0]);
	System.out.println("����\t\t" + currentUserInfo[1]);
	System.out.println("����\t\t" + currentUserInfo[2]);
	System.out.println("����\t\t" + currentUserInfo[4]);
	System.out.println("��ϵ��ʽ\t\t" + currentUserInfo[3]);
	System.out.println("������back������һҳ������exit���ع���Ա��ҳ��");
	System.out.println(""); 
	System.out.println("-------------------------------------------------------");
	while(true) {
	  System.out.print("�����룺");
	  switch (input.next()){
	    case "back":
	      AdminUI.personalInfoPage();
		  break;
	    case "exit":
	      AdminUI.mainPage();
		default:
		  System.err.println("��������! \n\n");
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
	System.out.println("������back������һҳ������exit���ع���Ա��ҳ��");
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
	    case "back":
		  AdminUI.personalInfoPage();;
		  isInputRight = 1;
		  break;
	    case "exit":
	      AdminUI.mainPage();
	      isInputRight = 1;
	      break;
	    default:
		  System.err.println("��������\n\n");
	  }
	}
  }
  
  /**
   * ����Ա�޸�����ҳ
   * */
  public static void pwdModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminMap);
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�޸�>����");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("������ԭ�����룺������back������һҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		AdminUI.infoModifyPage();;
		break;  
	  }else if(modifyInfo[0].equals(currentUserInfo[2])) {
		System.out.println("�����������룺");
		modifyInfo[1] = input.next();
		if (AdminService.modifyPwd(modifyInfo[1], currentUserInfo[0], init.adminMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸�����ɹ���������Ϊ" + modifyInfo[1]);
	      AdminUI.infoModifyPage();
		  break;
		}
	  }else {
		System.err.println("��������\n\n");
	  }
    }
  }
  
  /**
   * ����Ա�޸���ϵ��ʽҳ
   * */
  public static void phoneModify() {
	String[] currentUserInfo = AdminService.getAdminInfo(inputInfo[0], init.adminMap);
	System.out.println("\n\n");
	System.out.println(">����Ա��ҳ>������Ϣ>�޸�>��ϵ��ʽ");
	System.out.println("=======================================================");
    while(true) {
	  System.out.println("����������ϵ��ʽ��������back������һҳ��");
	  modifyInfo[0] = input.next();
	  if(modifyInfo[0].equals("back")) {
		AdminUI.infoModifyPage();
		break;  
	  }else if (AdminService.modifyPhone(modifyInfo[0], currentUserInfo[0], init.adminMap)) {
		  System.out.println("");
		  System.out.println("-------------------------------------------------------");
		  System.out.println("�޸���ϵ��ʽ�ɹ�������ϵ��ʽΪ" + modifyInfo[0]);
	      AdminUI.infoModifyPage();
		  break;
	  }else {
		System.err.println("��������\n\n");
	  }
    }
  }
}

