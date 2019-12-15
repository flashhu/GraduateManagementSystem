package entity;

/**
 * 学生基本信息
 * */
public class StudentInfo extends PersonInfo{
  private String sex; //性别
  private String graduYear; //毕业年份
  private String specialty; //专业
  //是否完成就业登记，默认未完成   
  private String isFinished = "未登记"; //(为方便信息存放在同个String数组里，所以用String)
  private String employStatus="-"; //就业类型
  private String company="-"; //单位
  private String job="-"; //岗位
  private String school="-"; //学校信息
  private String place="-"; //所在地
  
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
  
  /**
   * @param id 学号
   * @param name 姓名
   * @param pwd 密码
   * @param phone 联系方式
   * @param sex 性别
   * @param graduYear 毕业年份
   * @param specialty 专业
   * @param type 就业类型->研究生/待业
   * @param info 学校/所在地
   * */
  public StudentInfo(String id, String name, String pwd, String phone, String sex, String graduYear, String specialty, String type, String info) {
    this.setId(id);
    this.setName(name);
    this.setPwd(pwd);
    this.setPhone(phone);
    this.sex = sex;
    this.graduYear = graduYear;
    this.specialty = specialty;
    this.isFinished = "已登记";
    if(type.equals("研究生")) {
      this.employStatus = "研究生";
      this.school = info;     
    }else {
      this.employStatus = "待业";
      this.place = info;
    }
  }
  
  /**
   * @param id 学号
   * @param name 姓名
   * @param pwd 密码
   * @param phone 联系方式
   * @param sex 性别
   * @param graduYear 毕业年份
   * @param specialty 专业
   * @param type 就业类型->入职，创业
   * @param company 公司
   * @param job 岗位
   * */
  public StudentInfo(String id, String name, String pwd, String phone, String sex, String graduYear, String specialty, String type, String company, String job) {
    this.setId(id);
    this.setName(name);
    this.setPwd(pwd);
    this.setPhone(phone);
    this.sex = sex;
    this.graduYear = graduYear;
    this.specialty = specialty;
    this.isFinished = "已登记";
    this.employStatus = type;
    this.company = company;           
    this.job = job;
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
	if (isFinished.equals("未登记")) {
	  isFinished = "已登记";
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
   * 工作岗位
   * */
  public String getJob() {
	return job;
  }
  
  /**
   * 工作岗位
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
   * 待业去处
   * */
  public String getPlace() {
    return place;
  }
  
  /**
   * 待业去处
   * */
  public void setPlace(String place) {
	this.place = place;
  }
}
