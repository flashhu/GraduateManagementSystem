package entity;

/**
 * 基础信息表：账号，姓名，密码，联系方式
 * */
public abstract class PersonInfo {
  private String id; //学号，工号
  private String name; //姓名
  private String pwd; //密码
  private String phone; //联系方式
  
  public String getId() {
	return id;
  }
  
  public void setId(String id) {
	this.id = id;
  }
  
  public String getName() {
	return name;
  }
  
  public void setName(String name) {
	this.name = name;
  }
  
  public String getPwd() {
	return pwd;
  }
  
  public void setPwd(String pwd) {
	this.pwd = pwd;
  }
  
  public String getPhone() {
	return phone;
  }
  
  public void setPhone(String phone) {
	this.phone = phone;
  }
}
