package entity;

public class AdminInfo extends PersonInfo {
  private String dept; //部门
  
  /**
   * @param id 工号
   * @param name 姓名
   * @param pwd 密码
   * @param phone 联系方式
   * @param dept 部门
   * */
  public AdminInfo(String id, String name, String pwd, String phone, String dept) {
    this.setId(id);
    this.setName(name);
    this.setPwd(pwd);
    this.setPhone(phone);
    this.dept = dept;
  }
  
  public String getDept() {
	return dept;
  }
  
  public void setDept(String dept) {
	this.dept = dept;
  }
}
