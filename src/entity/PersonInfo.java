package entity;

/**
 * ������Ϣ���˺ţ����������룬��ϵ��ʽ
 * */
public abstract class PersonInfo {
  private String id; //ѧ�ţ�����
  private String name; //����
  private String pwd; //����
  private String phone; //��ϵ��ʽ
  
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
