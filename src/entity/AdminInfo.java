package entity;

public class AdminInfo extends PersonInfo {
  private String dept; //����
  
  /**
   * @param id ����
   * @param name ����
   * @param pwd ����
   * @param phone ��ϵ��ʽ
   * @param dept ����
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
