package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 管理端，学生端的通用方法
 * */
public class BaseService {
  /**
   * 判断输入字符串是否为手机号
   * */
  public static boolean isMobile(final String str) {
	Pattern p = null;
	Matcher m = null;
	boolean b = false;
	p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
	m = p.matcher(str);
	b = m.matches();
	return b;
  }
}
