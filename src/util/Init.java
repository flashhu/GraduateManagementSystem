package util;

import java.util.HashMap;

import entity.AdminInfo;
import entity.StudentInfo;

/**
 * 数据初始化
 * */
public class Init {
  public HashMap<String, StudentInfo> stuMap = new HashMap<String, StudentInfo>();
  public HashMap<String, AdminInfo> adminMap = new HashMap<String, AdminInfo>();
  
  public Init() {
	studentInit();
	adminInit();  
  }
  
  public void studentInit() {
	stuMap.put("201800", new StudentInfo("201800", "张三", "00", "13174569635", "男", "2022", "计算机"));
	stuMap.put("201801", new StudentInfo("201801", "李四", "01", "13965237458", "女", "2022", "计算机"));
	stuMap.put("201802", new StudentInfo("201802", "王五", "02", "18874123658", "男", "2022", "物联网"));
	stuMap.put("201803", new StudentInfo("201803", "李梅", "03", "19745623581", "女", "2022", "计算机", "研究生", "浙江大学"));
	stuMap.put("201804", new StudentInfo("201804", "张亮", "04", "13385267431", "男", "2022", "计算机", "待业", "上海"));
	stuMap.put("201805", new StudentInfo("201805", "王静", "05", "13574982561", "女", "2022", "软件工程", "创业", "我想", "技术总监"));
	stuMap.put("201806", new StudentInfo("201806", "徐飞", "06", "13159248637", "男", "2022", "物联网", "入职", "阅文", "前端"));
	stuMap.put("201807", new StudentInfo("201807", "马丽", "07", "16625413698", "女", "2022", "软件工程", "研究生", "清华大学"));
  }
		
  public void adminInit() {
	adminMap.put("001", new AdminInfo("001", "admin", "1", "13874526123", "教务处"));
	adminMap.put("002", new AdminInfo("002", "admin", "2", "13425648379", "学工办"));
  }
  
}
