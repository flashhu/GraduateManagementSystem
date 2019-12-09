package util;

import java.util.ArrayList;

import entity.AdminInfo;
import entity.StudentInfo;

/**
 * 数据初始化
 * */
public class Init {
  public ArrayList<StudentInfo> stuList = new ArrayList<StudentInfo>();
  public ArrayList<AdminInfo> adminList = new ArrayList<AdminInfo>();
  
  public Init() {
	studentInit();
	adminInit();  
  }
  
  public void studentInit() {
	stuList.add(new StudentInfo("201800", "张三", "00", "12345678900", "男", "2022", "计算机"));
	stuList.add(new StudentInfo("201801", "李四", "01", "12345678000", "女", "2022", "计算机"));
	stuList.add(new StudentInfo("201802", "王五", "02", "12345670900", "男", "2022", "计算机"));
	stuList.add(new StudentInfo("201803", "李梅", "03", "12345608900", "女", "2022", "计算机"));
  }
		
  public void adminInit() {
	adminList.add(new AdminInfo("001", "admin", "1", "12345678900", "教务处"));
  }
  
}
