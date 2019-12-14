package entity;

/**
 * ѧ��������Ϣ
 * */
public class StudentInfo extends PersonInfo{
  private String sex; //�Ա�
  private String graduYear; //��ҵ���
  private String specialty; //רҵ
  //�Ƿ���ɾ�ҵ�Ǽǣ�Ĭ��δ���   
  private String isFinished = "δ�Ǽ�"; //(Ϊ������Ϣ�����ͬ��String�����������String)
  private String employStatus="-"; //��ҵ����
  private String company="-"; //��λ
  private String job="-"; //��λ
  private String school="-"; //ѧУ��Ϣ
  private String place="-"; //���ڵ�
  
  /**
   * @param id ѧ��
   * @param name ����
   * @param pwd ����
   * @param phone ��ϵ��ʽ
   * @param sex �Ա�
   * @param graduYear ��ҵ���
   * @param specialty רҵ
   * */
  public StudentInfo(String id, String name, String pwd, String phone, String sex, String graduYear, String specialty) {
    this.setId(id);
    this.setName(name);
    this.setPwd(pwd);
    this.setPhone(phone);
    this.sex = sex;
    this.graduYear = graduYear;
    this.specialty = specialty;
  }

  public String getSex() {
	return sex;
  }
  
  public void setSex(String sex) {
	this.sex = sex;
  }
  
  public String getGraduYear() {
	return graduYear;
  }
  
  public void setGraduYear(String graduYear) {
	this.graduYear = graduYear;
  }
  
  public String getSpecialty() {
	return specialty;
  }
  
  public void setSpecialty(String specialty) {
	this.specialty = specialty;
  }
  
  public String getIsFinished() {
	return isFinished;
  }
  
  public void setIsFinished() {
	if (isFinished.equals("δ�Ǽ�")) {
	  isFinished = "�ѵǼ�";
	}
  }
  
  public String getEmployStatus() {
	return employStatus;
  }
  
  public void setEmployStatus(String type) {
	employStatus = type;
  }
  
  public String getCompany() {
	return company;
  }
  
  public void setCompany(String company) {
	this.company = company;
  }
  
  /**
   * ������λ
   * */
  public String getJob() {
	return job;
  }
  
  /**
   * ������λ
   * */
  public void setJob(String job) {
	this.job = job;
  }
  
  public String getSchool() {
	return school;
  }
  
  public void setSchool(String school) {
	this.school = school;
  }
  
  /**
   * ��ҵȥ��
   * */
  public String getPlace() {
    return place;
  }
  
  /**
   * ��ҵȥ��
   * */
  public void setPlace(String place) {
	this.place = place;
  }
}
