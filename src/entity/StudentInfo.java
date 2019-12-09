package entity;

/**
 * ѧ��������Ϣ
 * */
public class StudentInfo extends PersonInfo{
  private String sex; //�Ա�
  private String graduYear; //��ҵ���
  private String specialty; //רҵ
  
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
}
