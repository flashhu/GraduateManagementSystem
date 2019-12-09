package entity;

/**
 * 学生基本信息
 * */
public class StudentInfo extends PersonInfo{
  private String sex; //性别
  private String graduYear; //毕业年份
  private String specialty; //专业
  
  /**
   * @param id 学号
   * @param name 姓名
   * @param pwd 密码
   * @param phone 联系方式
   * @param sex 性别
   * @param graduYear 毕业年份
   * @param specialty 专业
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
